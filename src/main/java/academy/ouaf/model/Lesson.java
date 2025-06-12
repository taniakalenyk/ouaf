package academy.ouaf.model;

import academy.ouaf.views.DogView;
import academy.ouaf.views.EnrollmentView;
import academy.ouaf.views.LessonView;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView({LessonView.class, EnrollmentView.class, DogView.class})
    private Long lessonId;

    @Column(nullable = false)
    @NotNull
    @Future(message = "La date du cours doit être dans le futur")
    @JsonView({LessonView.class, EnrollmentView.class, DogView.class})
    private LocalDateTime startDateTime;

    @Column(nullable = false)
    @NotNull
    @Future(message = "La date du cours doit être dans le futur")
    @JsonView({LessonView.class, EnrollmentView.class})
    private LocalDateTime endDateTime;

    @Column(length = 255)
    @JsonView({LessonView.class, EnrollmentView.class})
    private String location;

    @ManyToOne
    @JoinColumn(name = "lesson_cancellation_id")
    @JsonView({LessonView.class, EnrollmentView.class})
    private LessonCancellationReason lessonCancellationReason;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    @JsonView({LessonView.class, EnrollmentView.class})
    private Coach coach;

    @ManyToOne(optional = false)
    @JoinColumn(name = "template_id", nullable = false)
    @JsonView({LessonView.class, EnrollmentView.class})
    private Template template;

//    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = true)

    @OneToMany(mappedBy = "lesson")
    @JsonView(LessonView.class)
    private List<Enrollment> enrollments;

}
