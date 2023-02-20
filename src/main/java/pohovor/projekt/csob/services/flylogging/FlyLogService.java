package pohovor.projekt.csob.services.flylogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pohovor.projekt.csob.dbmodel.entities.flyLogging.FlyLog;
import pohovor.projekt.csob.repositories.FlyLogRepository;

@Service
@Primary
public class FlyLogService implements IFlyLogService {

    @Autowired
    FlyLogRepository flyLogRepository;

    @Override
    public void createNewLog(FlyLog flyLog) {
        flyLogRepository.save(flyLog);
    }
}
