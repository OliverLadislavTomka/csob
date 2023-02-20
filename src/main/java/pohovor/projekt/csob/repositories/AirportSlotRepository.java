package pohovor.projekt.csob.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pohovor.projekt.csob.dbmodel.entities.airportSlots.AirportSlot;

import java.util.List;

@Repository
public interface AirportSlotRepository extends CrudRepository<AirportSlot, Long> {
    List<AirportSlot> findAllByAirport_IdAndAircraft_Id(Long airport_id, Long aircraft_id);
}
