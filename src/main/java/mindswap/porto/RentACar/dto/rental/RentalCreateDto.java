package mindswap.porto.RentACar.dto.rental;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import mindswap.porto.RentACar.model.Car;
import mindswap.porto.RentACar.model.Client;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record RentalCreateDto(
        @NotNull
        Long car,
        @NotNull
        Long client,
        @Past
        LocalDate rentalDate

) {
}
