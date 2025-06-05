package academy.ouaf.model;

import academy.ouaf.views.LessonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(LessonView.class)
    protected Byte lessonCancellationId;

    @Column
    @JsonView(LessonView.class)
    protected String reason;


    @OneToMany(mappedBy = "lessonCancellationReason")
    @JsonIgnore
    private List<Lesson> lessons;

}
