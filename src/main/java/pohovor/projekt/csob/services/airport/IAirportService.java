package pohovor.projekt.csob.services.airport;

import pohovor.projekt.csob.DTO.AirRequest;
import pohovor.projekt.csob.DTO.ResponseObject;

public interface IAirportService {
    ResponseObject createNewFlight(Long airportId, AirRequest request);
}
