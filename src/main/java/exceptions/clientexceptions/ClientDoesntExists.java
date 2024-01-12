package exceptions.clientexceptions;

public class ClientDoesntExists extends Exception{
    public ClientDoesntExists(String message){
        super(message);
    }
}
