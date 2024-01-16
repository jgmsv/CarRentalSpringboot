package mindswap.porto.RentACar.repository;

import mindswap.porto.RentACar.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
