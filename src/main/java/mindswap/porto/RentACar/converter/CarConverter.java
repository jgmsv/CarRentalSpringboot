package mindswap.porto.RentACar.converter;

import mindswap.porto.RentACar.dto.car.CarCreateDto;
import mindswap.porto.RentACar.dto.car.CarGetDto;
import mindswap.porto.RentACar.model.Car;

import java.util.List;

public class CarConverter  {

    public static Car dtoToCar(CarCreateDto dto) {
        return Car.builder()
                .brand(dto.brand())
                .numberOfSeats(dto.numberOfSeats())
                .numberOfDoors(dto.numberOfDoors())
                .gear(dto.gear())
                .carType(dto.carType())
                .licencePlate(dto.licencePlate())
                .available(dto.available())
                .pricePerDay(dto.pricePerDay())
                .build();
    }

    private static CarGetDto carToDto(Car car) {
        return new CarGetDto(
                car.getBrand(),
                car.getNumberOfSeats(),
                car.getNumberOfDoors(),
                car.getGear(),
                car.getCarType(),
                car.isAvailable(),
                car.getPricePerDay()
        );
    }

    public static List<CarGetDto> CarToDtoList(List<Car> cars) {
        return cars.stream()
                .map(CarConverter::carToDto)
                .toList();
    }



}
