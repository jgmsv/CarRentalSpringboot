package mindswap.porto.RentACar.exceptions.clientexceptions;

import mindswap.porto.RentACar.util.Messages;

public class NifException extends Exception{
    public NifException (String message){
        super(Messages.NIFEXISTS);
    }
}
