package academy.ouaf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long dogId;

    @Column(nullable = false)
    @NotNull(message = "Le nom du chien ne peut pas être vide")
    @Size(min = 2, max = 50, message = "Le nom du chien doit contenir entre 2 et 50 caractères")
    protected String name;

    @Column()
    protected Boolean sex; // true for female, false for male

    @Column(nullable = false)
    @NotNull(message = "La date de naissance du chien est obligatoire")
    protected Date birthDate;

    @Column(nullable = false)
    protected String photoId;

    @Column()
    protected float weight;

    @Column(nullable = false)
    @NotNull(message = "Veuillez indiquer si le chien est de race croisée ou non")
    protected Boolean crossBreed;

    @Column(nullable = false)
    @NotNull
    @Size(max = 300, message = "Les notes ne peuvent pas dépasser 300 caractères")
    protected String notes;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    protected User owner;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime registrationDate;

}
