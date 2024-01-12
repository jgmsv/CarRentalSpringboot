package mindswap.porto.RentACar.service;

import exceptions.clientexceptions.ClientAlreadyExists;
import exceptions.clientexceptions.ClientNotFoundException;
import mindswap.porto.RentACar.dto.ClientCreateDto;
import mindswap.porto.RentACar.dto.ClientGetDto;
import mindswap.porto.RentACar.dto.ClientUpdateDto;
import mindswap.porto.RentACar.repository.ClientRepository;
import mindswap.porto.RentACar.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ClientServiceI{

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void add(ClientCreateDto client) throws ClientAlreadyExists {

        if (clientRepository.findByNif(client.nif()).isPresent()) {
            throw new ClientAlreadyExists(Messages.NIFEXISTS);
        }
        clientRepository.save(fromClientCreateDtoToModel(client));
    }

    @Override
    public List<ClientGetDto> getAll() {
        return null;
    }

    @Override
    public void update(long id, ClientUpdateDto client) throws ClientNotFoundException {

    }

    @Override
    public void put(long id, ClientCreateDto client) throws ClientNotFoundException {

    }
}