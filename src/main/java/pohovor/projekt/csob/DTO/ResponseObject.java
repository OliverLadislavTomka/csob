package pohovor.projekt.csob.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseObject implements Serializable {
    private String message = "Permission granted!";
}
