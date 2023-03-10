package pohovor.projekt.csob.services.aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pohovor.projekt.csob.DTO.AircraftRequest;
import pohovor.projekt.csob.DTO.AircraftType;
import pohovor.projekt.csob.dbmodel.entities.Aircraft.Aircraft;
import pohovor.projekt.csob.repositories.AircraftRepository;

@Service
@Primary
public class AircraftServiceImpl implements IAircraftService{

    @Autowired
    private AircraftRepository aircraftRepository;
    @Override
    public Aircraft findAircraft(String serialNumber) {
        return this.aircraftRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Aircraft create(AircraftRequest request) {
        Aircraft aircraft = new Aircraft();
        aircraft.setAge(request.getAge());
        aircraft.setType(request.getType() == AircraftType.NORMAL ?
                pohovor.projekt.csob.dbmodel.entities.Aircraft.AircraftType.NORMAL :
                pohovor.projekt.csob.dbmodel.entities.Aircraft.AircraftType.CARGO);
        aircraft.setRegisration(request.getRegistration());
        aircraft.setRegistrationCountry(request.getRegistrationCountry());
        aircraft.setSerialNumber(request.getSerialNumber());
        aircraft.setAge(request.getAge());
        return this.aircraftRepository.save(aircraft);
    }

    @Override
    public Aircraft update(Aircraft request) {
        return this.aircraftRepository.save(request);
    }
}
