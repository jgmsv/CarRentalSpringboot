package mindswap.porto.RentACar.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private String password;
    private String email;
    @Transient
    private Integer age;

}
