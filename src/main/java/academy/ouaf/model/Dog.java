package academy.ouaf.model;

import academy.ouaf.views.DogView;
import academy.ouaf.views.EnrollmentView;
import academy.ouaf.views.LessonView;
import academy.ouaf.views.OwnerView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "dogs")
@EntityListeners(AuditingEntityListener.class)
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({DogView.class, OwnerView.class, LessonView.class, EnrollmentView.class})
    protected Long dogId;

    @JsonView({DogView.class, OwnerView.class, LessonView.class, EnrollmentView.class})
    @Column(nullable = false, length = 20)
    @NotNull(message = "Le nom du chien ne peut pas être vide")
    @Size(min = 2, max = 20, message = "Le nom du chien doit contenir entre 2 et 20 caractères")
    protected String name;

    @JsonView({DogView.class, OwnerView.class})
    @Column()
    protected Boolean gender; // true for female, false for male

    @Column(nullable = false)
    @JsonView({DogView.class,EnrollmentView.class})
    @NotNull(message = "La date de naissance du chien est obligatoire")
    @PastOrPresent(message = "La date de naissance ne peut pas être dans le futur")
    protected LocalDate birthDate;

    @JsonView({OwnerView.class, DogView.class})
    protected String photoId;

    @JsonView(DogView.class)
    @Positive(message = "Le poids doit être un nombre positif")
    protected Float weight;

    @JsonView(DogView.class)
    @Column(length = 300, columnDefinition = "TEXT")
    @Size(max = 300, message = "Les notes ne peuvent pas dépasser 300 caractères")
    protected String notes;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime registrationDate;

    @JsonView(DogView.class)
    @OneToMany
    protected Set<Enrollment> enrollments;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    protected Owner owner;

    @JsonView({DogView.class, OwnerView.class})
    @ManyToOne(optional = false)
    @JoinColumn(name = "primary_breed_id", nullable = false)
    protected Breed primaryBreed;

    @JsonView({DogView.class, OwnerView.class})
    @ManyToOne
    @JoinColumn(name = "secondary_breed_id")
    protected Breed secondaryBreed;

    @JsonView({DogView.class, OwnerView.class})
    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    protected Veterinarian veterinarian;

    @JsonIgnore
    @OneToMany(mappedBy = "dog")
    protected Set<Vaccination> vaccinations;
}
