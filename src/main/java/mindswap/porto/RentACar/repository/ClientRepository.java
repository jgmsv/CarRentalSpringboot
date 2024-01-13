package mindswap.porto.RentACar.repository;

import mindswap.porto.RentACar.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByNif (Integer nif);
    Optional<Client> findByEmail (String email);
    Optional<Client> findByLicence (String licence);
}
