package pohovor.projekt.csob.services.airport;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AirportServiceImpl implements IAirportService {


    @Override
    public Object createNewFlight(Long id, Object aircraft) {
        return null;
    }
}
