package mindswap.porto.RentACar.dto.car;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import mindswap.porto.RentACar.util.GearType;
import mindswap.porto.RentACar.util.Messages;

public record CarCreateDto(
        @NotNull
        String brand,
        @NotNull
        @Min(4)
        @Max(5)
        int numberOfSeats,
        @NotNull
        int numberOfDoors,
        @NotNull
        GearType gear,
        @NotNull
        String carType,
        @Pattern(regexp = "(^(?:[A-Z]{2}-\\d{2}-\\d{2})|(?:\\d{2}-[A-Z]{2}-\\d{2})|(?:\\d{2}-\\d{2}-[A-Z]{2})|(?:[A-Z]{2}-\\d{2}-[A-Z]{2})$)", message = Messages.INVALIDPLATE)
        String licencePlate,
        @NotNull
        boolean available,
        @NotNull
        double pricePerHour
) {


}
