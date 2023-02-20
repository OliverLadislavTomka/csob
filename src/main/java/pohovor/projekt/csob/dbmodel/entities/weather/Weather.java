package pohovor.projekt.csob.dbmodel.entities.weather;

import lombok.Data;
import pohovor.projekt.csob.dbmodel.DBconstants;
import pohovor.projekt.csob.dbmodel.MyEntity;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = DBconstants.TableNames.weather)
@Data
public class Weather extends MyEntity {

    @OneToOne
    @JoinColumn(nullable = false, name = DBconstants.Weather.airport_id)
    private Airport airport;

    @Temporal(TemporalType.DATE)
    @Column(name = DBconstants.Weather.updateDate)
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

    @Override
    public String toString() {
        return "Weather{" +
                "airport=" + airport +
                ", updateDate=" + updateDate +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), updateDate);
    }
}
