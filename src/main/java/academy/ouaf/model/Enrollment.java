package academy.ouaf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    protected Long enrollmentId;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime dateCreation;

    private LocalDateTime paymentDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dog_id", nullable = false)
    private Dog dog;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "enrollment_cancellation_id")
    private EnrollmentCancellationReason enrollmentCancellationReason;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;


}
