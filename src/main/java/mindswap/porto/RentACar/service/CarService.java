package mindswap.porto.RentACar.service;

import exceptions.carexceptions.CarAlreadyExists;
import exceptions.carexceptions.CarNotFoundException;
import exceptions.carexceptions.LicencePlateException;
import exceptions.clientexceptions.*;
import mindswap.porto.RentACar.converter.CarConverter;
import mindswap.porto.RentACar.dto.car.CarCreateDto;
import mindswap.porto.RentACar.dto.car.CarGetDto;
import mindswap.porto.RentACar.dto.car.CarUpdateDto;
import mindswap.porto.RentACar.dto.client.ClientGetDto;
import mindswap.porto.RentACar.dto.client.ClientUpdateDto;
import mindswap.porto.RentACar.repository.CarRepository;
import mindswap.porto.RentACar.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static mindswap.porto.RentACar.converter.CarConverter.carDtoToCar;

@Service
public class CarService implements CarServiceI{

    private final CarRepository carRepository;
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public void add(CarCreateDto car) throws CarAlreadyExists, LicencePlateException {
        carRepository.save(carDtoToCar(car));
    }

    @Override
    public List<CarGetDto> getAll() {
        return null;
    }

    @Override
    public void put(long id, CarUpdateDto client) throws CarNotFoundException, LicencePlateException {

    }
}
