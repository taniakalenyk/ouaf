package academy.ouaf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "vaccinations")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long vaccinationId;

    @Column(nullable = false)
    @NotNull(message = "La date de première vaccination est requise")
    private LocalDate firstVaccinationDate;

    private LocalDate boosterDate;

    @ManyToOne(optional = false)
    @JsonBackReference("vaccine")
    @JoinColumn(name = "vaccine_id", nullable = false)
    private Vaccine vaccine;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dog_id", nullable = false)
    @JsonBackReference("vaccination")
    private Dog dog;
}
