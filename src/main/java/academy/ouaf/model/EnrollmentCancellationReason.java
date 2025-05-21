package academy.ouaf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class EnrollmentCancellationReason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Byte enrollmentCancellationId;

    @Column
    protected String reason;

    @OneToMany(mappedBy = "enrollmentCancellationReason")
    private List<Enrollment> enrollments;

}
