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

    @Column(name = DBconstants.Runway.endUse, nullable = false)
    private Date freeAfter;

    @ManyToOne
    @JoinColumn(name = DBconstants.Runway.airport_id)
    private Airport airport;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    public Boolean getFree() {
        return new Date().getTime() > this.freeAfter.getTime();
    }
}
