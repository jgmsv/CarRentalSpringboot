package exceptions.clientexceptions;

public class ClientAlreadyExists extends Exception{
    public ClientAlreadyExists(String message){
        super(message);
    }
}
