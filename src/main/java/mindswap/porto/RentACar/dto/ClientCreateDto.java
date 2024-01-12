package mindswap.porto.RentACar.dto;

import jakarta.persistence.Column;
import mindswap.porto.RentACar.model.Rental;
import mindswap.porto.RentACar.util.Messages;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;
import java.util.List;


public record ClientCreateDto(
        List<Rental> rentals,
        @NotNull(message = Messages.EMPTYNAME)
        String name,
        @Column(unique = true)
        @Min(value = 100000000, message = Messages.NINEDIGITS)
        @Max(value = 999999999, message = Messages.NINEDIGITS)
        @NotNull()
        Integer nif,
        @NotNull()
        @Size(min = 9, max = 9, message = Messages.NINECHAR)
        String licence){

}
