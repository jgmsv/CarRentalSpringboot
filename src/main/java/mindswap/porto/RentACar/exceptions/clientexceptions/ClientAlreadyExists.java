package mindswap.porto.RentACar.exceptions.clientexceptions;

import mindswap.porto.RentACar.util.Messages;

public class ClientAlreadyExists extends Exception{
    public ClientAlreadyExists(String message){
        super(Messages.CLIENTIDDOESNTEXISTS);
    }
}
