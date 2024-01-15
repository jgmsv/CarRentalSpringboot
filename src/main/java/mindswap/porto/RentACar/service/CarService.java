package mindswap.porto.RentACar.service;

import exceptions.carexceptions.CarAlreadyExists;
import exceptions.carexceptions.CarNotFoundException;
import exceptions.carexceptions.LicencePlateException;
import exceptions.clientexceptions.ClientNotFoundException;
import mindswap.porto.RentACar.converter.CarConverter;
import mindswap.porto.RentACar.dto.car.CarCreateDto;
import mindswap.porto.RentACar.dto.car.CarGetDto;
import mindswap.porto.RentACar.dto.car.CarUpdateDto;
import mindswap.porto.RentACar.model.Car;
import mindswap.porto.RentACar.model.Client;
import mindswap.porto.RentACar.repository.CarRepository;
import mindswap.porto.RentACar.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static mindswap.porto.RentACar.converter.CarConverter.CarToDtoList;
import static mindswap.porto.RentACar.converter.CarConverter.dtoToCar;

@Service
public class CarService implements CarServiceI{

    private final CarRepository carRepository;
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public void add(CarCreateDto car) throws CarAlreadyExists, LicencePlateException {
        carRepository.save(dtoToCar(car));
    }

    @Override
    public List<CarGetDto> getAll() {
        return CarToDtoList(carRepository.findAll());
    }

    @Override
    public void put(long id, CarUpdateDto client) throws CarNotFoundException{
        Car carToUpdate = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(String.format(Messages.CARDONTEXISTS, id)));
        carRepository.save(carToUpdate);
    }
}
