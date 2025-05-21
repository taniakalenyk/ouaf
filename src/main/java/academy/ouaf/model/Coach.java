package academy.ouaf.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@DiscriminatorValue("COACH")
@Table(name = "coaches")
@Getter
@Setter
public class Coach extends User {

    @Column(length = 13, nullable = false, unique = true)
    @Size(max = 13, message = "Veuillez rentrer 13 chiffres maximum")
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "coach_specialization",
            joinColumns = @JoinColumn(name = "coach_id"),           // owning side
            inverseJoinColumns = @JoinColumn(name = "type_id")      // referenced type
    )
    protected Set<Type> type;

}
