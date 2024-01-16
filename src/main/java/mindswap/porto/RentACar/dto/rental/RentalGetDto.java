package mindswap.porto.RentACar.dto.rental;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RentalGetDto (
    long id,
    long carId,
    long clientId,
    LocalDate rentalDate,
    LocalDate returnDate,
    double rentalPrice
    ){
}
