package pohovor.projekt.csob.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Airport currently does not have free runways!")
public class NoRunwaysAvailableException extends RuntimeException{
}
