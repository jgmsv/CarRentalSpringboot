package mindswap.porto.RentACar.aspects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Error {
    private String message;
    private String path;
    private String method;
    private Date timestamp;
}
