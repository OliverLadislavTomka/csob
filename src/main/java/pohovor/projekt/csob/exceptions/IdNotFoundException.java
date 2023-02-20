package pohovor.projekt.csob.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Airport not found!")
public class IdNotFoundException extends RuntimeException{
}
