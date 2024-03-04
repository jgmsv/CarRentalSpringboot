package mindswap.porto.RentACar.controller;

import mindswap.porto.RentACar.dto.car.*;
import mindswap.porto.RentACar.exceptions.carexceptions.CarAlreadyExists;
import mindswap.porto.RentACar.exceptions.carexceptions.CarNotFoundException;
import mindswap.porto.RentACar.exceptions.carexceptions.LicencePlateException;
import mindswap.porto.RentACar.exceptions.clientexceptions.LicenceException;
import jakarta.validation.Valid;
import mindswap.porto.RentACar.model.Car;
import mindswap.porto.RentACar.service.CarService;
import mindswap.porto.RentACar.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/")
    public ResponseEntity<Car> add(@Valid @RequestBody CarCreateDto car, BindingResult bindingResult) throws CarAlreadyExists, LicencePlateException {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(carService.add(car), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CarGetDto>>getAll(){
        return ResponseEntity.ok(carService.getAll());
    }

    @PutMapping("/{carId}")
    public ResponseEntity<Object> Put(@PathVariable("carId") Long id, @RequestBody CarUpdateDto car, BindingResult bindingResult) throws CarNotFoundException, LicenceException {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        carService.put(id, car);
        return new ResponseEntity<>(Messages.CLIENTUPDATED, HttpStatus.OK);
    }

    @PostMapping("/availability/{carId}")
    public ResponseEntity<Object> UpdateAvailability(@PathVariable("carId") Long id, @RequestBody AvailabilityDto availabilityDto, BindingResult bindingResult) throws CarNotFoundException {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        carService.updateAvailability(id, availabilityDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/price/{carId}")
    public ResponseEntity<Object> UpdatePrice(@PathVariable("carId") Long id, @RequestBody UpdatePriceDto updatePriceDto, BindingResult bindingResult) throws CarNotFoundException{
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        carService.updateprice(id, updatePriceDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
