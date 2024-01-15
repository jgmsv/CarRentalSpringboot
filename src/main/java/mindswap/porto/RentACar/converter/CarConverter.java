package mindswap.porto.RentACar.converter;

import mindswap.porto.RentACar.dto.car.CarCreateDto;
import mindswap.porto.RentACar.model.Car;

public class CarConverter  {

    public static Car carDtoToCar(CarCreateDto dto) {
        return Car.builder()
                .brand(dto.brand())
                .numberOfSeats(dto.numberOfSeats())
                .numberOfDoors(dto.numberOfDoors())
                .gear(dto.gear())
                .carType(dto.carType())
                .licencePlate(dto.licencePlate())
                .available(dto.available())
                .pricePerHour(dto.pricePerHour())
                .build();
    }
}
