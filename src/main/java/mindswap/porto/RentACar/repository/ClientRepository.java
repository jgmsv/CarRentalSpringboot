package mindswap.porto.RentACar.repository;

import jakarta.transaction.Transactional;
import mindswap.porto.RentACar.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByNif (Integer nif);
    Optional<Client> findByEmail (String email);
    Optional<Client> findByLicence (String licence);

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE client AUTO_INCREMENT = 1", nativeQuery = true)
    void resetId();
}
