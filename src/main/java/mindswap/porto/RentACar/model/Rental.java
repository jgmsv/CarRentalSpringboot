package mindswap.porto.RentACar.model;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isPaid;

    @OneToMany(mappedBy = "rental")
    private List<Car> cars;

    @ManyToOne()
    @JoinColumn(name="client_id")
    private Client client;

    public Rental() {
    }
}
