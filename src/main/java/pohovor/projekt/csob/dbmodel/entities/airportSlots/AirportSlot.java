package pohovor.projekt.csob.dbmodel.entities.airportSlots;

import lombok.Data;
import pohovor.projekt.csob.dbmodel.DBconstants;
import pohovor.projekt.csob.dbmodel.MyEntity;
import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = DBconstants.TableNames.airportSlot)
public class AirportSlot extends MyEntity {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DBconstants.AirportSlot.airport_id)
    private Airport airport;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DBconstants.AirportSlot.aircraft_id)
    private Aircraft aircraft;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "AirportSlot{" +
                "airport=" + airport +
                ", aircraft=" + aircraft +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), airport.getId(), aircraft);
    }
}
