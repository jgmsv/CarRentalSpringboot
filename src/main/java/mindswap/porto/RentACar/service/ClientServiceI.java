package mindswap.porto.RentACar.service;

import exceptions.clientexceptions.*;
import mindswap.porto.RentACar.dto.client.ClientCreateDto;
import mindswap.porto.RentACar.dto.client.ClientGetDto;
import mindswap.porto.RentACar.dto.client.ClientUpdateDto;

import java.util.List;

public interface ClientServiceI {

    void add(ClientCreateDto client) throws ClientAlreadyExists, NifException, EmailException, LicenceException;

    List<ClientGetDto> getAll();

    void putParcial(long id, ClientUpdateDto client) throws ClientNotFoundException, NifException, EmailException;



}
