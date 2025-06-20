package academy.ouaf.model;

import academy.ouaf.views.DogView;
import academy.ouaf.views.OwnerView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "breeds")
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short breedId;

    @JsonView({DogView.class, OwnerView.class})
    @Column(nullable = false, unique = true, length = 50)
    @NotNull(message = "Le nom de la race ne peut pas être vide")
    @Size(min = 2, max = 50, message = "Le nom de la race doit contenir entre 2 et 50 caractères")
    private String breedName;

    @JsonIgnore
    @OneToMany(mappedBy = "primaryBreed")
    private List<Dog> dogsOfPrimaryBreed;

    @JsonIgnore
    @OneToMany(mappedBy = "secondaryBreed")
    private List<Dog> dogsOfSecondaryBreed;

}