package academy.ouaf.model;

import academy.ouaf.views.LessonView;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(LessonView.class)
    protected Byte ageId;

    @Column(nullable = false)
    @JsonView(LessonView.class)
    protected Short ageMin;

    @Column(nullable = false)
    @JsonView(LessonView.class)
    protected Short ageMax;

    @ManyToMany(mappedBy = "ageRanges")
    private Set<Type> types;

    @OneToMany
    @JoinColumn
    private Set<Template> templates;

}
