package mindswap.porto.RentACar.service;

import mindswap.porto.RentACar.dto.client.ClientCreateDto;
import mindswap.porto.RentACar.dto.client.ClientGetDto;
import mindswap.porto.RentACar.dto.client.ClientUpdateDto;
import mindswap.porto.RentACar.exceptions.clientexceptions.*;
import mindswap.porto.RentACar.model.Client;

import java.util.List;

public interface ClientServiceI {

    Client add(ClientCreateDto client) throws ClientAlreadyExists, NifException, EmailException, LicenceException;

    List<ClientGetDto> getAll();

    void put(long id, ClientUpdateDto client) throws ClientNotFoundException, NifException, EmailException;

    Client findByid(long id) throws ClientNotFoundException;
}
