package pohovor.projekt.csob.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "This airport does not allow aircrafts of your type!")
public class AircraftNotAllowedException extends RuntimeException{
}
