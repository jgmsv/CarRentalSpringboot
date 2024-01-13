package mindswap.porto.RentACar.dto.client;

import lombok.Builder;

@Builder
public record ClientGetDto(
        String name,
        String email,
        int nif
) {
}
