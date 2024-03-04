package mindswap.porto.RentACar.converter;

import mindswap.porto.RentACar.dto.rental.RentalCreateDto;
import mindswap.porto.RentACar.model.Car;
import mindswap.porto.RentACar.model.Client;
import mindswap.porto.RentACar.model.Rental;

public class RentalConverter {


    public static Rental dtoToRental (RentalCreateDto rentalCreateDto, Car car, Client client) {
        return Rental.builder()
                .car(car)
                .client(client)
                .rentalDate(rentalCreateDto.rentalDate())
                .build();
    }

}
