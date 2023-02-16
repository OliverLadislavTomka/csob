package pohovor.projekt.csob.services.weather;

import pohovor.projekt.csob.dbmodel.entities.airport.Airport;
import pohovor.projekt.csob.dbmodel.entities.weather.Weather;

public interface IWeatherService {
    Weather getCurrentWeather(Airport airport);
}
