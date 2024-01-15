package mindswap.porto.RentACar.dto.car;

import jakarta.validation.constraints.NotNull;

public record CarUpdateDto (
        @NotNull
        boolean available,
        @NotNull
        double pricePerHour
){
}
