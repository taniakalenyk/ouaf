package academy.ouaf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class LessonCancellationReason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Byte lessonCancellationId;

    @Column
    protected String reason;

    @OneToMany(mappedBy = "lessonCancellationReason")
    private List<Lesson> lessons;

}
