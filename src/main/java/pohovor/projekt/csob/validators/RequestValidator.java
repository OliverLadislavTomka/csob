package pohovor.projekt.csob.validators;

import lombok.AllArgsConstructor;
import pohovor.projekt.csob.DTO.AirRequest;
import pohovor.projekt.csob.exceptions.BadRequestException;

@AllArgsConstructor
public class RequestValidator implements IValidator{
    private AirRequest request;
    @Override
    public void validate() {
        if  (!(this.request != null &&
                this.request.getType() != null &&
                this.request.getRequest() != null &&
                this.request.getRequest().getAge() != null &&
                this.request.getRequest().getRegistration() != null &&
                this.request.getRequest().getType() != null &&
                this.request.getRequest().getSerialNumber() != null &&
                this.request.getRequest().getRegistrationCountry() != null)) throw new BadRequestException();
    }
}
