package pohovor.projekt.csob.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airport")
public class AirportController {



    @PostMapping("/{airportId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Object newFlight(@RequestBody Object nieco, @PathVariable Long airportId) {
        throw new RuntimeException();
    }

}
