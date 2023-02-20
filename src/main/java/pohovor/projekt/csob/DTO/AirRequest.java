package pohovor.projekt.csob.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class AirRequest implements Serializable {
    private TypeOfRequest type;
    private AircraftRequest request;
}
