package mindswap.porto.RentACar.service;

import exceptions.clientexceptions.*;
import mindswap.porto.RentACar.dto.client.ClientCreateDto;
import mindswap.porto.RentACar.dto.client.ClientGetDto;
import mindswap.porto.RentACar.dto.client.ClientUpdateDto;
import mindswap.porto.RentACar.model.Client;
import mindswap.porto.RentACar.repository.ClientRepository;
import mindswap.porto.RentACar.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static mindswap.porto.RentACar.converter.ClientConverter.ClientDbToDtoList;
import static mindswap.porto.RentACar.converter.ClientConverter.dtoToClientDb;

@Service
public class ClientService implements ClientServiceI {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void add(ClientCreateDto client) throws NifException, EmailException, LicenceException {

        if (clientRepository.findByNif(client.nif()).isPresent()) {
            throw new NifException(Messages.NIFEXISTS);
        }
        if (clientRepository.findByEmail(client.email()).isPresent()) {
            throw new EmailException(Messages.EMAILEXISTS);
        }
        if (clientRepository.findByLicence(client.licence()).isPresent()) {
            throw new LicenceException(Messages.LICENCEEXISTS);
        }
        clientRepository.save(dtoToClientDb(client));
    }


    @Override
    public List<ClientGetDto> getAll() {
        return ClientDbToDtoList(clientRepository.findAll());
    }

    @Override
    public void putParcial(long id, ClientUpdateDto client) throws EmailException, ClientNotFoundException {
        Client clientToUpdate = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(String.format(Messages.CLIENTIDDONTEXISTS, id)));
        if (client.name() != null && !client.name().isEmpty() && !client.name().equals(clientToUpdate.getName())) {
            clientToUpdate.setName(client.name());
        }
        if (client.email() != null && client.email().length() > 0 & !client.email().equals(clientToUpdate.getEmail())) {
            Optional<Client> userOptionalEmail = clientRepository.findByEmail(client.email());
            if (clientRepository.findByEmail(client.email()).isPresent()) {
                throw new EmailException(Messages.EMAILEXISTS);
            }
            clientRepository.save(clientToUpdate);
        }
    }




}
