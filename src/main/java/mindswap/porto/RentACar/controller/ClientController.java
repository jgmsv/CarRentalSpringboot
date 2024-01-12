package mindswap.porto.RentACar.controller;

import exceptions.clientexceptions.ClientDoesntExists;
import exceptions.NifExistsException;
import mindswap.porto.RentACar.dto.ClientCreateDto;
import mindswap.porto.RentACar.model.Client;
import mindswap.porto.RentACar.service.ClientService;
import mindswap.porto.RentACar.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Client>>getUsers(){
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Object> addNewClient(@Valid @RequestBody ClientCreateDto client, BindingResult bindingResult) throws NifExistsException {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            clientService.createClient(client);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (NifExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(path = "{clientId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("clientId") Long clientId) throws ClientDoesntExists {
        try {
            clientService.deleteClient(clientId);
            return new ResponseEntity<>(Messages.CLIENTDELETED, HttpStatus.OK);
        }catch (ClientDoesntExists e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            }
        }



    @PutMapping(path = "{clientId}")
    public ResponseEntity<Object> updateClient(@PathVariable("clientId") Long id, @RequestBody ClientCreateDto client, BindingResult bindingResult) throws NifExistsException {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clientService.updateClient(id, client);
        return new ResponseEntity<>(Messages.CLIENTUPDATED, HttpStatus.OK);
    }

}
