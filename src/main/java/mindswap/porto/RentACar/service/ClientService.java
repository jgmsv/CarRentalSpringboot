package mindswap.porto.RentACar.service;

import mindswap.porto.RentACar.dto.client.ClientCreateDto;
import mindswap.porto.RentACar.dto.client.ClientGetDto;
import mindswap.porto.RentACar.dto.client.ClientUpdateDto;
import mindswap.porto.RentACar.exceptions.clientexceptions.*;
import mindswap.porto.RentACar.model.Client;
import mindswap.porto.RentACar.repository.ClientRepository;
import mindswap.porto.RentACar.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static mindswap.porto.RentACar.converter.ClientConverter.*;

@Service
public class ClientService implements ClientServiceI {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client add(ClientCreateDto client) throws ClientAlreadyExists, NifException, EmailException, LicenceException {
        Optional<Client> clientOptional = this.clientRepository.findByNif(client.nif());
        if (clientOptional.isPresent()){

            throw new NifException(Messages.NIFEXISTS);
        }
        if (clientRepository.findByEmail(client.email()).isPresent()) {
            throw new EmailException(Messages.EMAILEXISTS);
        }
        if (clientRepository.findByLicence(client.licence()).isPresent()) {
            throw new LicenceException(Messages.LICENCEEXISTS);
        }

        return clientRepository.save(dtoToClient(client));
    }

    @Override
    public List<ClientGetDto> getAll() {
        return clientToDtoList(clientRepository.findAll());
    }

    @Override
    public void put(long id, ClientUpdateDto client) throws EmailException, ClientNotFoundException {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(!clientOptional.isPresent()){
            throw new ClientNotFoundException(String.format(Messages.CLIENTIDDOESNTEXISTS, id));
        }
        Client clientToUpdate = clientOptional.get();
        if (client.name() != null && !client.name().isEmpty() && !client.name().equals(clientToUpdate.getName())) {
            clientToUpdate.setName(client.name());
        }
        if (client.email() != null && client.email().length() > 0 & !client.email().equals(clientToUpdate.getEmail())) {
            Optional<Client> clientOptionalEmail = clientRepository.findByEmail(client.email());
            if(clientOptionalEmail.isPresent())
                throw new EmailException(Messages.EMAILEXISTS);
            clientToUpdate.setEmail(client.email());
        }
        clientRepository.save(clientToUpdate);
    }

    @Override
    public Client findByid(long id) throws ClientNotFoundException {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(String.format(Messages.CLIENTIDDOESNTEXISTS, id)));

    }


}
