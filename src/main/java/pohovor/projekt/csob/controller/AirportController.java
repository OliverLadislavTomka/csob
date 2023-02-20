package pohovor.projekt.csob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pohovor.projekt.csob.DTO.AirRequest;
import pohovor.projekt.csob.DTO.ResponseObject;
import pohovor.projekt.csob.services.airport.IAirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {


    @Autowired
    private IAirportService airportService;

    @PostMapping("/{airportId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseObject newFlight(@RequestBody AirRequest request, @PathVariable Long airportId) {
        return airportService.createNewFlight(airportId, request);
    }

}
