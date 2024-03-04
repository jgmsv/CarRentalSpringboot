package mindswap.porto.RentACar.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Rental> clientRentals = new HashSet<>();
    private String name;
    @Column(unique = true)
    private Integer nif;
    private LocalDate birthDate;
    private String licence;
    private String email;
    @Transient
    private Integer age;


    public Client(String name, Integer nif, LocalDate birthDate, String licence, String email) {
        this.name = name;
        this.nif = nif;
        this.birthDate = birthDate;
        this.licence = licence;
        this.email = email;

    }

    public Client() {
    }

    public Integer getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

}
