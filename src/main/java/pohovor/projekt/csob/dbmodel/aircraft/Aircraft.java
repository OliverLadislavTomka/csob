package pohovor.projekt.csob.dbmodel.aircraft;

import lombok.Data;
import pohovor.projekt.csob.dbmodel.MyEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Aircraft extends MyEntity {

    @Enumerated
    @Column(nullable = false)
    private AircraftType type;

    @Column(nullable = false)
    private Date regisration;

    @Column(nullable = false, name = "")
    private String registrationCountry;


}
