package mindswap.porto.RentACar.service;

import exceptions.clientexceptions.ClientAlreadyExists;
import exceptions.clientexceptions.ClientNotFoundException;
import mindswap.porto.RentACar.dto.ClientCreateDto;
import mindswap.porto.RentACar.dto.ClientGetDto;
import mindswap.porto.RentACar.dto.ClientUpdateDto;

import java.util.List;

public interface ClientServiceI {

    void add(ClientCreateDto client) throws ClientAlreadyExists;

    List<ClientGetDto> getAll();

    void update(long id, ClientUpdateDto client) throws ClientNotFoundException;

    void put(long id, ClientCreateDto client) throws ClientNotFoundException;

}
