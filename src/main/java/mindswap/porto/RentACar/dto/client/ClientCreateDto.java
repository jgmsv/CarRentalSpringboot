package mindswap.porto.RentACar.dto.client;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import mindswap.porto.RentACar.model.Rental;
import mindswap.porto.RentACar.util.Messages;


import java.util.List;


public record ClientCreateDto(
        @NotNull(message = Messages.EMPTYNAME)
        String name,
        @Column(unique = true)
        @Min(value = 100000000, message = Messages.NINEDIGITS)
        @Max(value = 999999999, message = Messages.NINEDIGITS)
        @NotNull()
        Integer nif,
        @NotNull()
        @Size(min = 9, max = 9, message = Messages.NINECHAR)
        String licence,
        @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = Messages.INVALIDEMAIL)
        String email
        )
{
}