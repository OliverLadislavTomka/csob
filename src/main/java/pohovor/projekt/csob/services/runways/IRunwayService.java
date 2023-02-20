package pohovor.projekt.csob.services.runways;

import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;

public interface IRunwayService {
    void bookRunway(Airport airport, Aircraft aircraft);
}
