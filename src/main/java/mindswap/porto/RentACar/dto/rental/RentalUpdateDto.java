package mindswap.porto.RentACar.dto.rental;

import jakarta.validation.constraints.Min;
import mindswap.porto.RentACar.util.Messages;

import java.time.LocalDate;

public record RentalUpdateDto (
        LocalDate returnDate,
        @Min(value = 50, message = Messages.INVALIDAMOUNT)
        double rentalPrice
){

}
