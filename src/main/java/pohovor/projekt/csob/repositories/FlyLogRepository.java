package pohovor.projekt.csob.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pohovor.projekt.csob.dbmodel.entities.flyLogging.FlyLog;

@Repository
public interface FlyLogRepository extends CrudRepository<FlyLog, Long> {
}
