package pohovor.projekt.csob.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AircraftRequest implements Serializable {
    private AircraftType type;
    private Date registration;
    private String registrationCountry;
    private String serialNumber;
    private Long age;
}
