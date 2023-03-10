package pohovor.projekt.csob.services.flylogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pohovor.projekt.csob.dbmodel.entities.flyLogging.FlyLog;
import pohovor.projekt.csob.repositories.FlyLogRepository;

@Service
@Primary
public class FlyLogServiceImpl implements IFlyLogService {

    @Autowired
    FlyLogRepository flyLogRepository;

    @Override
    public void createNewLog(FlyLog flyLog) {
        System.out.println("The flight log has been logged into database.");
        flyLogRepository.save(flyLog);
    }
}
