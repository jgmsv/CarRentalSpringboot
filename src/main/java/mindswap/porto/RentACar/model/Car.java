package mindswap.porto.RentACar.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mindswap.porto.RentACar.util.GearType;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private int numberOfSeats;
    private int numberOfDoors;
    private GearType gear;
    private String carType;
    @Column(unique = true)
    private String licencePlate;
    private boolean available;
    private double pricePerHour;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;


}
