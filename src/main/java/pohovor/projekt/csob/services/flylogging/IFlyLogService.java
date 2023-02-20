package pohovor.projekt.csob.services.flylogging;

import pohovor.projekt.csob.dbmodel.entities.flyLogging.FlyLog;

public interface IFlyLogService {
    void createNewLog(FlyLog flyLog);
}
