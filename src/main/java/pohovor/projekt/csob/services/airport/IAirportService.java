package pohovor.projekt.csob.services.airport;

import pohovor.projekt.csob.DTO.AirRequest;
import pohovor.projekt.csob.DTO.ResponseObject;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;

public interface IAirportService {
    ResponseObject createNewFlight(Long airportId, AirRequest request);
    void createAirport();
}
