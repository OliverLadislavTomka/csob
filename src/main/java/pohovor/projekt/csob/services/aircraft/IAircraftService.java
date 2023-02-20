package pohovor.projekt.csob.services.aircraft;

import pohovor.projekt.csob.DTO.AircraftRequest;
import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;

public interface IAircraftService {
    Aircraft findAircraft(Long serialNumber);

    Aircraft create(AircraftRequest request);

    Aircraft update(Aircraft request);
}
