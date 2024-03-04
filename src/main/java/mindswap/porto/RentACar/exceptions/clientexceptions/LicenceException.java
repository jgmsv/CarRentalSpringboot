package mindswap.porto.RentACar.exceptions.clientexceptions;

import mindswap.porto.RentACar.util.Messages;

public class LicenceException extends Throwable {
    public LicenceException(String message){
        super(Messages.EMAILEXISTS);
    }
}
