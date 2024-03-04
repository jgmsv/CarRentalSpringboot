package mindswap.porto.RentACar.aspects;
import mindswap.porto.RentACar.exceptions.clientexceptions.ClientAlreadyExists;
import mindswap.porto.RentACar.exceptions.clientexceptions.EmailException;
import mindswap.porto.RentACar.exceptions.clientexceptions.LicenceException;
import mindswap.porto.RentACar.util.Messages;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Component
@ControllerAdvice
public class RentACarExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RentACarExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> genericExceptionHandler(Exception ex) {
        logger.error("Unknown Exception" + ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Messages.ANERROROCCURRED);

    }
    @ExceptionHandler(value = {LicenceException.class, ClientAlreadyExists.class, EmailException.class})
    public ResponseEntity<String> clientAddException(Exception ex){
        logger.error("Known Exception" + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
