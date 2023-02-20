package pohovor.projekt.csob.services.runways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;
import pohovor.projekt.csob.dbmodel.entities.runways.Runway;
import pohovor.projekt.csob.repositories.RunwayRepository;

import java.util.Date;

@Service
@Primary
public class RunwayServiceImpl implements IRunwayService{

    @Autowired
    private RunwayRepository runwayRepository;

    @Override
    public void bookRunway(Airport airport, Aircraft aircraft) {
        Runway runway = runwayRepository.findByFreeAfterAfterAndAirport_Id(new Date(), airport.getId());
        runway.setFreeAfter(new Date(new Date().getTime() + 300));
        runwayRepository.save(runway);
    }
}
