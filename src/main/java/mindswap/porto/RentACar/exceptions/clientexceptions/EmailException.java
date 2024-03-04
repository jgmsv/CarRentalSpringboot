package mindswap.porto.RentACar.exceptions.clientexceptions;

import mindswap.porto.RentACar.util.Messages;

public class EmailException extends Throwable {
    public EmailException(String message){
        super(Messages.EMAILEXISTS);
    }
}
