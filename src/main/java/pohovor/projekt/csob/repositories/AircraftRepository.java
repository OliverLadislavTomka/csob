package pohovor.projekt.csob.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
    Aircraft findBySerialNumber(Long serialNumber);
}
