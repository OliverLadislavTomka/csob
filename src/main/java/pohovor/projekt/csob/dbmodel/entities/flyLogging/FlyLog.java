package pohovor.projekt.csob.dbmodel.entities.flyLogging;

import lombok.Data;
import pohovor.projekt.csob.dbmodel.DBconstants;
import pohovor.projekt.csob.dbmodel.MyEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = DBconstants.TableNames.flyLog)
public class FlyLog extends MyEntity {

    @Enumerated
    @Column(name = DBconstants.FlyLog.flyType, nullable = false)
    private FlyType flyType;



}
