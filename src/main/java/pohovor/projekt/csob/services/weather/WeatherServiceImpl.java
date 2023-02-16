package pohovor.projekt.csob.services.weather;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;
import pohovor.projekt.csob.dbmodel.entities.weather.Weather;

@Service
@Primary
public class WeatherServiceImpl implements IWeatherService {

    @Override
    public Weather getCurrentWeather(Airport airport) {
        return null;
    }
}
