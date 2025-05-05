package academy.ouaf.model;

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
    protected Short templateId;

    @Column(nullable = false, length = 30)
    @Size(max = 30, min = 1)
    protected Short capacity;

    @Column(precision = 10, scale = 2, nullable = false) // The column can store 8 digits before the decimal, 2 after = 10 total).
    protected BigDecimal price;

    @Column(precision = 10, scale = 2)
    private BigDecimal priceCorrection; // For discounts

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    protected Type type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "age_id", nullable = false)
    protected AgeRange ageRange;

    @OneToMany(mappedBy = "template")
    protected List<Lesson> lessons;

    public BigDecimal getFinalPrice() {
        return price.add(priceCorrection != null ? priceCorrection : BigDecimal.ZERO);
    }
}
