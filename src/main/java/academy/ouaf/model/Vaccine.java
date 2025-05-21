package academy.ouaf.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vaccines")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaccineId;

    @Column(length = 80, nullable = false)
    @NotNull(message = "Le nom du vaccin est requis")
    @Size(max = 80, message = "Le nom du vaccin ne peut pas dépasser 80 caractères")
    private String vaccineName;

    @OneToMany(mappedBy = "vaccine")
    private Set<Vaccination> vaccinations;
}
