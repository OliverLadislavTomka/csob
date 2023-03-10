package pohovor.projekt.csob.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Data sent was incomplete")
public class BadRequestException extends RuntimeException {
}
