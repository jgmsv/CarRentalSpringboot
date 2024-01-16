package mindswap.porto.RentACar.dto.car;

import jakarta.validation.constraints.NotNull;

public record AvailabilityDto(
        @NotNull
        boolean available
) {
}
