package pohovor.projekt.csob.dbmodel.entities.Aircraft;

import lombok.Data;
import pohovor.projekt.csob.dbmodel.DBconstants;
import pohovor.projekt.csob.dbmodel.MyEntity;
import pohovor.projekt.csob.dbmodel.entities.airportSlots.AirportSlot;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Data
@Table(name = DBconstants.TableNames.aircraft)
public class Aircraft extends MyEntity {

    @Enumerated
    @Column(nullable = false, name = DBconstants.Aircraft.aircraftType)
    private AircraftType type;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = DBconstants.Aircraft.registrationDate)
    private Date regisration;

    @Column(nullable = false, name = DBconstants.Aircraft.registrationCountry)
    private String registrationCountry;

    @Column(unique = true, nullable = false, name = DBconstants.Aircraft.serialNumber)
    private String serialNumber;

    @Column(nullable = false, name = DBconstants.Aircraft.age)
    private Long age;

    @OneToOne(mappedBy = "aircraft",fetch = FetchType.EAGER)
    private AirportSlot airportSlot;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "type=" + type +
                ", regisration=" + regisration +
                ", registrationCountry='" + registrationCountry + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, regisration, registrationCountry, serialNumber, age);
    }
}
