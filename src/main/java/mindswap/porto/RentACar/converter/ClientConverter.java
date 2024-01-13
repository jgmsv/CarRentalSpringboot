package mindswap.porto.RentACar.converter;

import mindswap.porto.RentACar.dto.client.ClientCreateDto;
import mindswap.porto.RentACar.dto.client.ClientGetDto;
import mindswap.porto.RentACar.model.Client;

import java.util.List;

public class ClientConverter {



    public static Client fromModelToCreateDto(ClientCreateDto client){
        return Client.builder()
                .name(client.name())
                .nif(client.nif())
                .licence(client.licence())
                .build();
    }

    public static ClientGetDto fromModeltoGetDto(Client client){
        return ClientGetDto.builder()
                .name(client.getName())
                .nif(client.getNif())
                .email(client.getEmail())
                .build();

    }

    public static List<ClientGetDto> fromClientModelListToGetDtoList(List<Client> clients) {
        return clients.stream()
                .map(ClientConverter::fromModeltoGetDto)
                .toList();
    }



}
