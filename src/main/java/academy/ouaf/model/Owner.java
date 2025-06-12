package academy.ouaf.model;

import academy.ouaf.views.OwnerView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("OWNER")
@Table(name = "owners")
@Getter
@Setter
public class Owner extends User {

    @JsonView(OwnerView.class)
    @Column(length = 13)
    @Size(max = 13, message = "Veuillez rentrer 13 chiffres maximum")
    private String phoneNumber;

    @JsonView(OwnerView.class)
    @Column(length = 50)
    @Size(min = 2, max = 50, message = "L'adresse doit contenir entre 2 et 50 caractères")
    private String address;

    @JsonView(OwnerView.class)
    @Column(length = 300, columnDefinition = "TEXT")
    @Size(min = 2, max = 300, message = "Ce champs doit contenir entre 2 et 300 caractères")
    private String about;

    @JsonView(OwnerView.class)
    @PastOrPresent(message = "La date de naissance ne peut pas être dans le futur")
    private LocalDate birthdate;

    @JsonView(OwnerView.class)
    @Column(length = 30)
    @Size(min = 2, max = 30, message = "Le nom de la ville doit contenir entre 2 et 30 caractères")
    private String city;

    @JsonView(OwnerView.class)
    @Column(length = 10)
    @Size(min = 2, max = 10, message = "Le code postal doit contenir entre 2 et 10 caractères")
    private String postcode;

    @JsonView(OwnerView.class)
    @OneToMany(mappedBy = "owner")
    private Set<Dog> dogs;
}
