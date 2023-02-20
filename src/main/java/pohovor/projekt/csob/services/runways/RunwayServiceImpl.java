package pohovor.projekt.csob.services.runways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;
import pohovor.projekt.csob.dbmodel.entities.runways.Runway;
import pohovor.projekt.csob.exceptions.BadRequestException;
import pohovor.projekt.csob.repositories.RunwayRepository;

import java.util.Date;
import java.util.List;

@Service
@Primary
public class RunwayServiceImpl implements IRunwayService{

    @Autowired
    private RunwayRepository runwayRepository;

    @Override
    public void bookRunway(Airport airport, Aircraft aircraft) {

        List<Runway> runways = runwayRepository.findByAirport_Id(airport.getId());
        Runway runway = runways.stream().filter(k -> k.getFreeAfter().before(new Date())).findFirst().get();
        System.out.println("Booking runway #" + runway.getId());
        long timeToSet = new Date().getTime() + 300;
        runway.setFreeAfter(new Date(timeToSet));
        runwayRepository.save(runway);
    }
}
