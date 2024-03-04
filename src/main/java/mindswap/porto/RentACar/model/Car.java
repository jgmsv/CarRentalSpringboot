package mindswap.porto.RentACar.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mindswap.porto.RentACar.util.GearType;

import java.util.HashSet;
import java.util.Set;

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
    private double pricePerDay;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Rental> carRentals = new HashSet<>();

}
