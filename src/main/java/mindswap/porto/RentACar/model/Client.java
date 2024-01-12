package mindswap.porto.RentACar.model;

import jakarta.persistence.*;
import mindswap.porto.RentACar.util.Messages;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "client")
    private List<Rental> rentals;
    private String name;
    @Column(unique = true)
    private Integer nif;
    private LocalDate birthDate;
    private String licence;

    public Client() {
    }

    public Client(List<Rental> rentals, String name, int nif, String licence) {
        this.rentals = rentals;
        this.name = name;
        this.nif = nif;
        this.licence = licence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String isLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getLicence() {
        return licence;
    }
}
