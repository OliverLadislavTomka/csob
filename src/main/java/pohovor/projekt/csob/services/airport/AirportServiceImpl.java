package pohovor.projekt.csob.services.airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pohovor.projekt.csob.DTO.AirRequest;
import pohovor.projekt.csob.DTO.ResponseObject;
import pohovor.projekt.csob.DTO.TypeOfRequest;
import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;
import pohovor.projekt.csob.dbmodel.entities.flyLogging.FlyLog;
import pohovor.projekt.csob.dbmodel.entities.flyLogging.FlyType;
import pohovor.projekt.csob.exceptions.IdNotFoundException;
import pohovor.projekt.csob.repositories.AirportRepository;
import pohovor.projekt.csob.services.aircraft.IAircraftService;
import pohovor.projekt.csob.services.flylogging.IFlyLogService;
import pohovor.projekt.csob.utils.AirportUtil;
import pohovor.projekt.csob.validators.RequestValidator;

@Service
@Primary
public class AirportServiceImpl implements IAirportService {


    @Autowired
    AirportRepository airportRepository;

    @Autowired
    IAircraftService aircraftService;

    @Autowired
    IFlyLogService flyLogService;

    @Override
    public ResponseObject createNewFlight(Long airportId, AirRequest request) {
        new RequestValidator(request).validate();
        Airport airport = airportRepository.findById(airportId).orElseThrow(IdNotFoundException::new);
        Aircraft aircraft = aircraftService.findAircraft(request.getRequest().getSerialNumber());
        if (aircraft == null) aircraft = aircraftService.create(request.getRequest());
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
    }

    private void flyAircraft(Airport airport, Aircraft aircraft) {
        flyLogService.createNewLog(new FlyLog(FlyType.DEPARTURE, airport.getId(), aircraft.getId()));
    }

}
