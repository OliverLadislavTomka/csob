package pohovor.projekt.csob.services.airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pohovor.projekt.csob.DTO.AirRequest;
import pohovor.projekt.csob.DTO.ResponseObject;
import pohovor.projekt.csob.DTO.TypeOfRequest;
import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;
import pohovor.projekt.csob.dbmodel.entities.airport.AirportType;
import pohovor.projekt.csob.dbmodel.entities.airportSlots.AirportSlot;
import pohovor.projekt.csob.dbmodel.entities.flyLogging.FlyLog;
import pohovor.projekt.csob.dbmodel.entities.flyLogging.FlyType;
import pohovor.projekt.csob.dbmodel.entities.runways.Runway;
import pohovor.projekt.csob.dbmodel.entities.weather.Weather;
import pohovor.projekt.csob.exceptions.IdNotFoundException;
import pohovor.projekt.csob.repositories.AirportRepository;
import pohovor.projekt.csob.services.aircraft.IAircraftService;
import pohovor.projekt.csob.services.flylogging.IFlyLogService;
import pohovor.projekt.csob.services.hangars.IAirportSlotService;
import pohovor.projekt.csob.services.runways.IRunwayService;
import pohovor.projekt.csob.utils.AirportUtil;
import pohovor.projekt.csob.validators.RequestValidator;

import java.util.*;

@Service
@Primary
public class AirportServiceImpl implements IAirportService {


    @Autowired
    AirportRepository airportRepository;

    @Autowired
    IAircraftService aircraftService;

    @Autowired
    IFlyLogService flyLogService;

    @Autowired
    IRunwayService runwayService;

    @Autowired
    IAirportSlotService slotService;

    @Override
    public void createAirport() {
        Airport airport = new Airport();
        airport.setRunwayCapacity(2);
        airport.setAirportType(AirportType.INTERNATIONAL);
        airport.setHangarCapacity(50);

        airportRepository.save(airport);

        Weather weather = new Weather();
        weather.setAirport(airport);
        airport.setWeather(weather);
        this.setSlots(airport);
        this.setRunways(airport);
        airportRepository.save(airport);

        Airport airport2 = new Airport();
        airport2.setRunwayCapacity(1);
        airport2.setAirportType(AirportType.REGIONAL);
        airport2.setHangarCapacity(10);

        airportRepository.save(airport2);
        airport2.setWeather(new Weather());
        Weather weather2 = new Weather();
        weather2.setAirport(airport2);
        airport2.setWeather(weather2);
        this.setSlots(airport2);
        this.setRunways(airport2);
        airportRepository.save(airport2);
    }

    @Override
    public ResponseObject createNewFlight(Long airportId, AirRequest request) {
        new RequestValidator(request).validate();
        System.out.println("New request");
        Airport airport = airportRepository.findById(airportId).orElseThrow(IdNotFoundException::new);
        Aircraft aircraft = aircraftService.findAircraft(request.getRequest().getSerialNumber());
        if (aircraft == null) {
            aircraft = aircraftService.create(request.getRequest());
            System.out.println("Aircraft with serial number " + aircraft.getSerialNumber() +" is visiting airport for the first time. Creating new aircraft");
        }
        AirportUtil.isAircraftCompatible(aircraft,airport);
        AirportUtil.hasFreeRunway(airport);
        if (request.getType() == TypeOfRequest.LANDING) {
            AirportUtil.hasFreeHangar(airport);
            landAircraft(airport,aircraft);
        } else {
            flyAircraft(airport, aircraft);
        }
        return new ResponseObject();
    }


    private void landAircraft(Airport airport, Aircraft aircraft) {
        flyLogService.createNewLog(new FlyLog(FlyType.ARRIVAL, airport.getId(), aircraft.getId()));
        runwayService.bookRunway(airport, aircraft);
        AirportSlot airportSlot = slotService.bookHangar(airport, aircraft);
        aircraft.setAirportSlot(airportSlot);
        aircraftService.update(aircraft);
    }

    private void flyAircraft(Airport airport, Aircraft aircraft) {
        flyLogService.createNewLog(new FlyLog(FlyType.DEPARTURE, airport.getId(), aircraft.getId()));
        runwayService.bookRunway(airport, aircraft);
        slotService.freeHangar(airport, aircraft);
        aircraft.setAirportSlot(null);
        aircraftService.update(aircraft);
    }

    private void setSlots(Airport airport) {
        for (int i = 0; i < airport.getHangarCapacity(); i++) {
            AirportSlot airportSlot = new AirportSlot();
            airportSlot.setAirport(airport);
            airport.getAirportSlotSet().add(airportSlot);
        }
    }

    private void setRunways(Airport airport) {
        for (int i = 0; i < airport.getRunwayCapacity(); i++) {
            Runway runway = new Runway();
            runway.setAirport(airport);
            runway.setFreeAfter(new Date());
            airport.getRunwaysSet().add(runway);
        }
    }

}
