package academy.ouaf.model;

import jakarta.persistence.*;

@Entity
@Table(name="quote_of_the_day")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Byte quoteId;

    @Column
    protected String quoteText;
}
