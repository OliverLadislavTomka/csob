package pohovor.projekt.csob.services.hangars;

import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;
import pohovor.projekt.csob.dbmodel.entities.airportSlots.AirportSlot;

public interface IAirportSlotService {
    AirportSlot bookHangar(Airport airport, Aircraft aircraft);

    void freeHangar(Airport airport, Aircraft aircraft);
}
