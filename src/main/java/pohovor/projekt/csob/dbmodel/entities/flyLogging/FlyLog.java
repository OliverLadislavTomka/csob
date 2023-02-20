package pohovor.projekt.csob.dbmodel.entities.flyLogging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pohovor.projekt.csob.dbmodel.DBconstants;
import pohovor.projekt.csob.dbmodel.MyEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = DBconstants.TableNames.flyLog)
public class FlyLog extends MyEntity {

    @Enumerated
    @Column(name = DBconstants.FlyLog.flyType, nullable = false)
    private FlyType flyType;

    private Long airport_id;
    private Long airport_slot_id;






}
