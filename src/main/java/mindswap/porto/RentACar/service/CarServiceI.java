package mindswap.porto.RentACar.service;

import mindswap.porto.RentACar.dto.car.*;
import mindswap.porto.RentACar.exceptions.carexceptions.CarAlreadyExists;
import mindswap.porto.RentACar.exceptions.carexceptions.CarNotFoundException;
import mindswap.porto.RentACar.exceptions.carexceptions.LicencePlateException;
import mindswap.porto.RentACar.exceptions.clientexceptions.ClientNotFoundException;
import mindswap.porto.RentACar.model.Car;

import java.util.List;

public interface CarServiceI {
    Car add(CarCreateDto car) throws CarAlreadyExists, LicencePlateException;

    List<CarGetDto> getAll();

    void put(long id, CarUpdateDto client) throws CarNotFoundException, LicencePlateException, ClientNotFoundException;

    Car findByID(long id) throws CarNotFoundException;

    void updateAvailability (Long id, AvailabilityDto availabilityDto) throws CarNotFoundException;

    void updateprice (Long id, UpdatePriceDto updatePriceDto) throws CarNotFoundException;
}
