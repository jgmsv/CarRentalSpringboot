package mindswap.porto.RentACar.dto.car;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record UpdatePriceDto(
        @Min(50)
        double pricePerDay
) {
}
