package academy.ouaf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonId;

    @Column(nullable = false)
    @NotNull
    @Future(message = "La date du cours doit être dans le futur")
    private LocalDateTime startDateTime;

    @Column(nullable = false)
    @NotNull
    @Future(message = "La date du cours doit être dans le futur")
    private LocalDateTime endDateTime;

    @Column(length = 255)
    private String location;

    @ManyToOne
    @JoinColumn(name = "lesson_cancellation_id")
    private LessonCancellationReason lessonCancellationReason;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @ManyToOne(optional = false)
    @JoinColumn(name = "template_id", nullable = false)
    private Template template;

//    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = true)

    @OneToMany(mappedBy = "lesson")
    private List<Enrollment> enrollments;

}
