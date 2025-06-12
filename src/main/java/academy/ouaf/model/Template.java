package academy.ouaf.model;

import academy.ouaf.views.EnrollmentView;
import academy.ouaf.views.LessonView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "templates")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(LessonView.class)
    protected Short templateId;

    @Column(nullable = false, length = 30)
    @Size(max = 30, min = 1)
    @JsonView({LessonView.class, EnrollmentView.class})
    protected Short capacity;

    @Column(precision = 10, scale = 2, nullable = false) // The column can store 8 digits before the decimal, 2 after = 10 total).
    @JsonView(LessonView.class)
    protected BigDecimal price;

    @Column(precision = 10, scale = 2)
    @JsonView(LessonView.class)
    private BigDecimal priceCorrection; // For discounts

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    @JsonView({LessonView.class, EnrollmentView.class})
    protected Type type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "age_id", nullable = false)
    @JsonView({LessonView.class})
    protected AgeRange ageRange;

    @OneToMany(mappedBy = "template")
    protected List<Lesson> lessons;

    @JsonView(LessonView.class)
    public BigDecimal getFinalPrice() {
        return price.add(priceCorrection != null ? priceCorrection : BigDecimal.ZERO);
    }
}
