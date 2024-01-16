package mindswap.porto.RentACar.service;

import mindswap.porto.RentACar.converter.RentalConverter;
import mindswap.porto.RentACar.dto.rental.RentalCreateDto;
import mindswap.porto.RentACar.exceptions.carexceptions.CarNotFoundException;
import mindswap.porto.RentACar.exceptions.clientexceptions.ClientNotFoundException;
import mindswap.porto.RentACar.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService implements RentalServiceI {
    private final RentalRepository rentalRepository;
    private final CarService carService;
    private final ClientService clientService;

    @Autowired
    public RentalService(RentalRepository rentalRepository, CarService carService, ClientService clientService) {
        this.rentalRepository = rentalRepository;
        this.carService = carService;
        this.clientService = clientService;
    }


    @Override
    public void add(RentalCreateDto rental) throws ClientNotFoundException, CarNotFoundException {
        rentalRepository.save(RentalConverter.dtoToRental(rental, carService.findByID(rental.car()), clientService.findByid(rental.client())));
    }
}
