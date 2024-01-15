package mindswap.porto.RentACar.service;

import exceptions.carexceptions.CarAlreadyExists;
import exceptions.carexceptions.CarNotFoundException;
import exceptions.carexceptions.LicencePlateException;
import exceptions.clientexceptions.*;
import mindswap.porto.RentACar.dto.car.CarCreateDto;
import mindswap.porto.RentACar.dto.car.CarGetDto;
import mindswap.porto.RentACar.dto.car.CarUpdateDto;
import mindswap.porto.RentACar.dto.client.ClientCreateDto;
import mindswap.porto.RentACar.dto.client.ClientGetDto;
import mindswap.porto.RentACar.dto.client.ClientUpdateDto;

import java.util.List;

public interface CarServiceI {
    void add(CarCreateDto car) throws CarAlreadyExists, LicencePlateException;

    List<CarGetDto> getAll();

    void put(long id, CarUpdateDto client) throws CarNotFoundException, LicencePlateException;
}
