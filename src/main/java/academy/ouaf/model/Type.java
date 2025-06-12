package academy.ouaf.model;

import academy.ouaf.views.EnrollmentView;
import academy.ouaf.views.LessonView;
import academy.ouaf.views.OwnerView;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView({LessonView.class, EnrollmentView.class})
    protected String typeAppointment;

    @OneToMany(mappedBy = "type")
    private List<Template> templates;

    @ManyToMany(mappedBy = "type")
    private Set<Coach> coaches;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "type_age",
            joinColumns = @JoinColumn(name = "type_id"),           // owning side
            inverseJoinColumns = @JoinColumn(name = "dog_age_id")      // referenced type
    )
    protected Set<AgeRange> ageRanges;
}
