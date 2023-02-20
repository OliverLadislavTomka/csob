package pohovor.projekt.csob.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pohovor.projekt.csob.dbmodel.entities.runways.Runway;

import java.util.Date;

@Repository
public interface RunwayRepository extends CrudRepository<Runway, Long> {
    Runway findByFreeAfterAfterAndAirport_Id(Date freeAfter, Long airport_id);
}
