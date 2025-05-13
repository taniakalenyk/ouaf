package academy.ouaf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("OWNER")
@Table(name = "owners")
@Getter
@Setter
public class Owner extends User {

    @Column(length = 13, nullable = false, unique = true)
    @Size(max = 13, message = "Veuillez rentrer 13 chiffres maximum")
    private String phoneNumber;

    @Column(length = 50)
    @Size(min = 2, max = 50, message = "L'adresse doit contenir entre 2 et 50 caractères")
    private String address;

    @Column(length = 300, nullable = false, columnDefinition = "TEXT")
    @Size(min = 2, max = 300, message = "Ce champs doit contenir entre 2 et 300 caractères")
    private String about;

    @PastOrPresent(message = "La date de naissance ne peut pas être dans le futur")
    private LocalDate birthdate;

    @Column(length = 30)
    @Size(min = 2, max = 30, message = "Le nom de la ville doit contenir entre 2 et 30 caractères")
    private String city;

    @Column(length = 10)
    @Size(min = 2, max = 10, message = "Le code postal doit contenir entre 2 et 10 caractères")
    private String postcode;

    @OneToMany(mappedBy = "owner")
    @JsonBackReference(value = "owner")
    private List<Dog> dogs;
}
