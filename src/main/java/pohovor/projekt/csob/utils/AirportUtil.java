package pohovor.projekt.csob.utils;

import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;
import pohovor.projekt.csob.dbmodel.entities.Aircraft.AircraftType;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;
import pohovor.projekt.csob.dbmodel.entities.airport.AirportType;
import pohovor.projekt.csob.exceptions.AircraftNotAllowedException;
import pohovor.projekt.csob.exceptions.NoRunwaysAvailableException;

public class AirportUtil {
    public static void isAircraftCompatible(Aircraft aircraft, Airport airport) {
        if ((aircraft.getType() == AircraftType.CARGO && airport.getAirportType() == AirportType.INTERNATIONAL) ||
                (aircraft.getType() == AircraftType.NORMAL && airport.getAirportType() == AirportType.REGIONAL)) {
            throw new AircraftNotAllowedException();
        }
    }

    public static void hasFreeRunway(Airport airport) {
        if (airport.getRunwaysSet().stream().allMatch(runway -> Boolean.FALSE.equals(runway.getFree()))) {
            throw new NoRunwaysAvailableException();
        }
    }

    public static void hasFreeHangar(Airport airport) {
        if (airport.getAirportSlotSet().stream().anyMatch(airportSlot -> airportSlot.getAircraft() == null)) {
            throw new NoRunwaysAvailableException();
        }
    }
}
