package academy.ouaf.model;

import academy.ouaf.views.DogView;
import academy.ouaf.views.EnrollmentView;
import academy.ouaf.views.LessonView;

import academy.ouaf.views.OwnerView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({LessonView.class, EnrollmentView.class, DogView.class})
    protected Long enrollmentId;

    @CreatedDate
    @Column(nullable = false)
    @JsonView(LessonView.class)
    private LocalDateTime dateCreation;

    private LocalDateTime paymentDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dog_id", nullable = false)
    @JsonView({LessonView.class, EnrollmentView.class})
    private Dog dog;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lesson_id", nullable = false)
    @JsonView({EnrollmentView.class, DogView.class})
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "enrollment_cancellation_id")
    @JsonView(EnrollmentView.class)
    private EnrollmentCancellationReason enrollmentCancellationReason;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
