package mindswap.porto.RentACar.controller;

import jakarta.validation.Valid;
import mindswap.porto.RentACar.dto.client.ClientCreateDto;
import mindswap.porto.RentACar.dto.client.ClientGetDto;
import mindswap.porto.RentACar.dto.client.ClientUpdateDto;
import mindswap.porto.RentACar.exceptions.clientexceptions.ClientNotFoundException;
import mindswap.porto.RentACar.exceptions.clientexceptions.EmailException;
import mindswap.porto.RentACar.exceptions.clientexceptions.LicenceException;
import mindswap.porto.RentACar.exceptions.clientexceptions.NifException;
import mindswap.porto.RentACar.service.ClientService;
import mindswap.porto.RentACar.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientGetDto>> getAll() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<Object> add(@Valid @RequestBody ClientCreateDto client, BindingResult bindingResult) throws NifException {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            clientService.add(client);
        } catch (NifException | EmailException | LicenceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(path = "{clientId}")
    public ResponseEntity<Object> Put(@PathVariable("clientId") Long id, @RequestBody ClientUpdateDto client, BindingResult bindingResult) throws ClientNotFoundException, EmailException {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clientService.put(id, client);
        return new ResponseEntity<>(Messages.CARUPDATED, HttpStatus.OK);
    }
}


