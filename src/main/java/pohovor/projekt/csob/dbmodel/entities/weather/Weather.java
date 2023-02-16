package pohovor.projekt.csob.dbmodel.entities.weather;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import pohovor.projekt.csob.dbmodel.DBconstants;
import pohovor.projekt.csob.dbmodel.MyEntity;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = DBconstants.TableNames.weather)
@Data
public class Weather extends MyEntity {

    @OneToOne
    @JoinColumn(name = DBconstants.Weather.airport_id)
    private Airport airport;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = DBconstants.Weather.updateDate, nullable = false)
    private Date updateDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

}
