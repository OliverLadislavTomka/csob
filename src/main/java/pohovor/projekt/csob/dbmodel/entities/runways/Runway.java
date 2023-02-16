package pohovor.projekt.csob.dbmodel.entities.runways;

import lombok.Data;
import pohovor.projekt.csob.dbmodel.DBconstants;
import pohovor.projekt.csob.dbmodel.MyEntity;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = DBconstants.TableNames.airportRunway)
public class Runway extends MyEntity {

    @Column(nullable = false, name = DBconstants.Runway.isFree)
    private Boolean free;

    @Column(nullable = false, name = DBconstants.Runway.endUse)
    private Date freeAfter;

    @ManyToOne
    @JoinColumn(nullable = false, name = DBconstants.Runway.airport_id)
    private Airport airport;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

}
