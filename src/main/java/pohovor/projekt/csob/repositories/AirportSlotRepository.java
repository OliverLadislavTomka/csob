package pohovor.projekt.csob.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pohovor.projekt.csob.dbmodel.entities.airportSlots.AirportSlot;

@Repository
public interface AirportSlotRepository extends CrudRepository<AirportSlot, Long> {
    AirportSlot findAllByAirport_IdAndAircraft_Id(Long airport_id, Long aircraft_id);
}
