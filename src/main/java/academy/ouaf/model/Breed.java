package academy.ouaf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "breeds")

public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breedId;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Le nom de la race ne peut pas être vide")
    @Size(min = 2, max = 50, message = "Le nom de la race doit contenir entre 2 et 50 caractères")
    private String breedName;
}