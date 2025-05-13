package academy.ouaf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Byte typeId;

    @Column
    @NotNull
    protected String typeAppointment;

    @OneToMany(mappedBy = "type")
    private List<Template> templates;

    @ManyToMany(mappedBy = "type")
    @JsonBackReference(value = "coach-type")
    private Set<Coach> coaches;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "type_age",
            joinColumns = @JoinColumn(name = "type_id"),           // owning side
            inverseJoinColumns = @JoinColumn(name = "dog_age_id")      // referenced type
    )
    @JsonManagedReference(value = "type-age")
    protected Set<AgeRange> ageRanges;
}
