package academy.ouaf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "veterinarians")
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer veterinarianId;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50, message = "Le prénom doit contenir entre 2 et 50 caractères")
    private String firstName;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    private String lastName;

    @Column(length = 13, nullable = false)
    @Size(max = 13, message = "Veuillez rentrer 13 chiffres maximum")
    private String phoneNumber;

    @Column(unique = true, nullable = false)
    @NotNull
    @Email(message = "Format d'email invalide")
    private String email;

    @Column(length = 50)
    @Size(min = 2, max = 50, message = "Le nom de la clinique doit contenir entre 2 et 50 caractères")
    private String clinicName;

    @Column(length = 50)
    @Size(min = 2, max = 50, message = "L'adresse doit contenir entre 2 et 50 caractères")
    private String clinicAddress;

    @Column(length = 30)
    @Size(min = 2, max = 30, message = "Le nom de la ville doit contenir entre 2 et 30 caractères")
    private String clinicCity;

    @Column(length = 10)
    @Size(min = 2, max = 10, message = "Le code postal doit contenir entre 2 et 10 caractères")
    private String clinicPostcode;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinarian")
    private List<Dog> dogs;

}
