package mindswap.porto.RentACar.dto.car;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import mindswap.porto.RentACar.util.GearType;
import mindswap.porto.RentACar.util.Messages;

public record CarGetDto(
        String brand,
        int numberOfSeats,
        int numberOfDoors,
        GearType gear,
        String carType,
        boolean available,
        double pricePerHour
) {
}
