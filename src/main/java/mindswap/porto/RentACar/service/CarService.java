package mindswap.porto.RentACar.service;

import mindswap.porto.RentACar.dto.car.*;
import mindswap.porto.RentACar.exceptions.carexceptions.CarAlreadyExists;
import mindswap.porto.RentACar.exceptions.carexceptions.CarNotFoundException;
import mindswap.porto.RentACar.exceptions.carexceptions.LicencePlateException;
import mindswap.porto.RentACar.exceptions.clientexceptions.ClientNotFoundException;
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
    public Car add(CarCreateDto car) throws CarAlreadyExists, LicencePlateException {
        return carRepository.save(dtoToCar(car));
    }

    @Override
    public List<CarGetDto> getAll() {
        return CarToDtoList(carRepository.findAll());
    }

    @Override
    public void put(long id, CarUpdateDto client) throws CarNotFoundException{
        Car carToUpdate = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(String.format(Messages.CARIDDOESNTEXIXTS, id)));
        carRepository.save(carToUpdate);
    }

    @Override
    public Car findByID(long id) throws CarNotFoundException {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(String.format(Messages.CARIDDOESNTEXIXTS, id)));
    }

    @Override
    public void updateAvailability(Long id, AvailabilityDto availabilityDto) throws CarNotFoundException {
        Car carToUpdate = carRepository.findById(id).orElseThrow(()-> new CarNotFoundException(String.format(Messages.CARIDDOESNTEXIXTS, id)));
        carToUpdate.setAvailable(!carToUpdate.isAvailable());
        carRepository.save(carToUpdate);
    }

    @Override
    public void updateprice(Long id, UpdatePriceDto updatePriceDto) throws CarNotFoundException {
        Car carToUpdate = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(String.format(Messages.CARIDDOESNTEXIXTS, id)));
        carToUpdate.setPricePerDay(updatePriceDto.pricePerDay());
        carRepository.save(carToUpdate);
    }
}
