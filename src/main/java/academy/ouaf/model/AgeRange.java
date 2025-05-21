package academy.ouaf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "age_ranges")
@Getter
@Setter
public class AgeRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Byte ageId;

    @Column(nullable = false)
    protected Short ageMin;

    @Column(nullable = false)
    protected Short ageMax;

    @ManyToMany(mappedBy = "ageRanges")
    private Set<Type> types;

    @OneToMany
    @JoinColumn
    private Set<Template> templates;

}
