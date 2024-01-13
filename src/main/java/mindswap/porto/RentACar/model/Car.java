package mindswap.porto.RentACar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import mindswap.porto.RentACar.util.GearType;
import org.jetbrains.annotations.NotNull;


@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String brand;
    @NotNull
    private int numberOfSeats;
    @NotNull
    private int numberOfDoors;
    @NotNull
    private GearType gear;
    @NotNull
    private String carType;
    @NotNull
    @Column(unique = true)
    @Size(min = 3, max = 15)
    private String licencePlate;
    @NotNull
    private boolean available;
    @NotNull
    private double pricePerHour;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    public Car() {
    }

    public Car(String brand, int numberOfSeats, int numberOfDoors, GearType gear, String carType, String licencePlate, boolean available, double pricePerHour, Rental rental) {
        this.brand = brand;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.gear = gear;
        this.carType = carType;
        this.licencePlate = licencePlate;
        this.available = available;
        this.pricePerHour = pricePerHour;
        this.rental = rental;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public GearType getGear() {
        return gear;
    }

    public void setGear(GearType gear) {
        this.gear = gear;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
