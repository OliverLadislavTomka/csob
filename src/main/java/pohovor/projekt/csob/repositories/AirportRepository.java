package pohovor.projekt.csob.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pohovor.projekt.csob.dbmodel.entities.airport.Airport;

import java.util.Optional;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {
    @Override
    Optional<Airport> findById(Long airportId);
}
