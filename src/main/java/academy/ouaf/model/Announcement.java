package academy.ouaf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="announcement")
@Getter
@Setter
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Byte announcementId;

    @NotNull(message = "La date de début ne peut pas être vide.")
    protected LocalDateTime startDateTime;

    @NotNull(message = "La date de fin ne peut pas être vide.")
    protected LocalDateTime endDateTime;

    @NotNull(message = "L'annonce ne peut pas être vide.")
    protected String announcementText;
}
