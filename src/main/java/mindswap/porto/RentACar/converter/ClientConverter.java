package mindswap.porto.RentACar.converter;

import mindswap.porto.RentACar.dto.ClientCreateDto;
import mindswap.porto.RentACar.model.Client;

public class ClientConverter {

    public static ClientCreateDto fromModelToCreateDto(Client client){
        return new ClientCreateDto(
                client.getRentals(),
                client.getName(),
                client.getNif(),
                client.isLicence()
        );
    }
    public static Client fromCreateDtoToModel (ClientCreateDto clientDto) {
        return new Client(
                clientDto.rentals(),
                clientDto.name(),
                clientDto.nif(),
                clientDto.licence()
        );
    }

}
