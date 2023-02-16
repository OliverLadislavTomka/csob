package pohovor.projekt.csob.dbmodel.entities.weather;

import lombok.Data;
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
    @Column(name = DBconstants.Weather.updateDate, nullable = false)
    private Date updateDate;

    @PrePersist
    private void onCreate() {
        this.updateDate = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        this.updateDate = new Date();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

}
