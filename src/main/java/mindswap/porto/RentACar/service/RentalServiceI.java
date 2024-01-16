package mindswap.porto.RentACar.service;

import mindswap.porto.RentACar.dto.rental.RentalCreateDto;
import mindswap.porto.RentACar.exceptions.carexceptions.CarNotFoundException;
import mindswap.porto.RentACar.exceptions.clientexceptions.ClientNotFoundException;

public interface RentalServiceI {

    void add(RentalCreateDto rental) throws ClientNotFoundException, CarNotFoundException;

/*
    List<ClientGetDto> getAll();


    void put(long id, ClientUpdateDto client) throws ClientNotFoundException, NifException, EmailException;

*/


}
