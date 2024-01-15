package mindswap.porto.RentACar.controller;

import exceptions.carexceptions.CarAlreadyExists;
import exceptions.carexceptions.LicencePlateException;
import exceptions.clientexceptions.EmailException;
import exceptions.clientexceptions.LicenceException;
import exceptions.clientexceptions.NifException;
import jakarta.validation.Valid;
import mindswap.porto.RentACar.converter.CarConverter;
import mindswap.porto.RentACar.dto.car.CarCreateDto;
import mindswap.porto.RentACar.dto.client.ClientCreateDto;
import mindswap.porto.RentACar.service.CarService;
import mindswap.porto.RentACar.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> add(@Valid @RequestBody CarCreateDto car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            carService.add(car);
        } catch ( CarAlreadyExists | LicencePlateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
