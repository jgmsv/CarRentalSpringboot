package mindswap.porto.RentACar.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.List;


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
    @OneToMany(mappedBy = "client")
    private List<Rental> rentals;
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
