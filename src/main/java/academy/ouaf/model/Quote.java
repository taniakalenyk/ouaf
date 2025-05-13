package academy.ouaf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="quote_of_the_day")
@Getter
@Setter
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Byte quoteId;

    @Column
    @NotNull
    protected String quoteText;
}
