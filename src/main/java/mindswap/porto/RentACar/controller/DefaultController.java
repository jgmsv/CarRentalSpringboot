package mindswap.porto.RentACar.controller;

import mindswap.porto.RentACar.exceptions.carexceptions.CarNotFoundException;
import mindswap.porto.RentACar.util.Messages;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @GetMapping("/exception")
    public void returnCarnotFoundException() throws Exception {
        throw new Exception("exception returned");
    }
}
