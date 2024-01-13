package mindswap.porto.RentACar.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import mindswap.porto.RentACar.util.Messages;

public record ClientUpdateDto(
        @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = Messages.INVALIDEMAIL)
        String email,
        @NotBlank(message = Messages.EMPTYNAME)
        String name
) {
}
