package mindswap.porto.RentACar.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "rental")
    private Car car;
    @ManyToOne()
    @JoinColumn(name="client_id")
    private Client client;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private double rentalPrice;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Rental rental = (Rental) object;
        return Double.compare(rentalPrice, rental.rentalPrice) == 0 && Objects.equals(id, rental.id) && Objects.equals(car, rental.car) && Objects.equals(client, rental.client) && Objects.equals(rentalDate, rental.rentalDate) && Objects.equals(returnDate, rental.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, client, rentalDate, returnDate, rentalPrice);
    }
}
