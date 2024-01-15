package mindswap.porto.RentACar.repository;

import mindswap.porto.RentACar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
