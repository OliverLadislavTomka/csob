package pohovor.projekt.csob.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pohovor.projekt.csob.dbmodel.entities.weather.Weather;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
}
