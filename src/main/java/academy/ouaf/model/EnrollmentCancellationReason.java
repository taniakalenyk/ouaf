package academy.ouaf.model;

import academy.ouaf.views.EnrollmentView;
import academy.ouaf.views.LessonView;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView({EnrollmentView.class, LessonView.class})
    protected Byte enrollmentCancellationId;

    @Column
    @JsonView({EnrollmentView.class})
    protected String reason;

    @OneToMany(mappedBy = "enrollmentCancellationReason")
    private List<Enrollment> enrollments;

}
