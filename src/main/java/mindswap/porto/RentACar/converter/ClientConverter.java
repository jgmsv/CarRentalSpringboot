package mindswap.porto.RentACar.converter;

import mindswap.porto.RentACar.dto.client.ClientCreateDto;
import mindswap.porto.RentACar.dto.client.ClientGetDto;
import mindswap.porto.RentACar.model.Client;

import java.util.List;

public class ClientConverter {



    public static Client dtoToClient(ClientCreateDto client){
        return Client.builder()
                .name(client.name())
                .nif(client.nif())
                .birthDate(client.birthDate())
                .licence(client.licence())
                .email(client.email())
                .password(client.password())
                .build();
    }

    public static ClientGetDto clientToDto(Client client) {
        return new ClientGetDto(
                client.getName(),
                client.getEmail(),
                client.getNif()
        );
    }

    public static List<ClientGetDto> ClientToDtoList(List<Client> clients) {
        return clients.stream()
                .map(ClientConverter::clientToDto)
                .toList();
    }



}
