package academy.ouaf.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "age_ranges")
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
