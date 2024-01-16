package mindswap.porto.RentACar.controller;

import jakarta.validation.Valid;
import mindswap.porto.RentACar.dto.rental.RentalCreateDto;
import mindswap.porto.RentACar.exceptions.carexceptions.CarNotFoundException;
import mindswap.porto.RentACar.exceptions.clientexceptions.ClientNotFoundException;
import mindswap.porto.RentACar.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/rental")
public class RentalController {

    @Autowired
    RentalService rentalService;

    @PostMapping("/")
    public ResponseEntity<String> addRental(@Valid @RequestBody RentalCreateDto rentalDto) throws ClientNotFoundException, CarNotFoundException {
        rentalService.add(rentalDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
