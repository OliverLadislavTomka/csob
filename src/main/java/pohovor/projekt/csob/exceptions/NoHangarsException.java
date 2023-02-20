package pohovor.projekt.csob.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Airport does not have capacity for new aircrafts!")
public class NoHangarsException extends RuntimeException{
}
