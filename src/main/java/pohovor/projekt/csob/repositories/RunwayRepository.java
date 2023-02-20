package pohovor.projekt.csob.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pohovor.projekt.csob.dbmodel.entities.runways.Runway;

import java.util.Date;
import java.util.List;

@Repository
public interface RunwayRepository extends CrudRepository<Runway, Long> {
    List<Runway> findByAirport_Id(Long airport_id);

}
