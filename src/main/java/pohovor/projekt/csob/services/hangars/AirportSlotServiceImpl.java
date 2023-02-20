package pohovor.projekt.csob.services.hangars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;
import pohovor.projekt.csob.dbmodel.entities.airportSlots.AirportSlot;
import pohovor.projekt.csob.repositories.AirportSlotRepository;

@Service
@Primary
public class AirportSlotServiceImpl implements IAirportSlotService{

    @Autowired
    private AirportSlotRepository db;

    @Override
    public AirportSlot bookHangar(Airport airport, Aircraft aircraft) {
        System.out.println("Booking hangar.");
        AirportSlot airportSlot = db.findAllByAirport_IdAndAircraft_Id(airport.getId(), null);
        airportSlot.setAircraft(aircraft);
        return db.save(airportSlot);
    }

    @Override
    public void freeHangar(Airport airport, Aircraft aircraft) {
        System.out.println("Freeing hangar.");
        AirportSlot airportSlot = db.findAllByAirport_IdAndAircraft_Id(airport.getId(), null);
        airportSlot.setAircraft(null);
        db.save(airportSlot);
    }
}
