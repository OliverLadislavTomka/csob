package pohovor.projekt.csob.dbmodel.entities.airport;

import lombok.Data;
import pohovor.projekt.csob.dbmodel.DBconstants;
import pohovor.projekt.csob.dbmodel.MyEntity;
import pohovor.projekt.csob.dbmodel.entities.airportSlots.AirportSlot;
import pohovor.projekt.csob.dbmodel.entities.runways.Runway;
import pohovor.projekt.csob.dbmodel.entities.weather.Weather;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
@Entity
@Table(name = DBconstants.TableNames.airport)
public class Airport extends MyEntity {

    @Column(nullable = false, name = DBconstants.Airport.hangarCapacity)
    private Integer hangarCapacity;

    @Column(nullable = false, name = DBconstants.Airport.runwayCapacity)
    private Integer runwayCapacity;

    @Column(nullable = false, name = DBconstants.Airport.airportType)
    private AirportType airportType;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "airport")
    private List<AirportSlot> airportSlotSet = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "airport")
    private List<Runway> runwaysSet = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "airport")
    private Weather weather;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hangarCapacity, runwayCapacity, airportType, weather);
    }
}
