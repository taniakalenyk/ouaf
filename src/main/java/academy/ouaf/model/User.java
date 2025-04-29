package academy.ouaf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users") // Custom table name to avoid conflicts with SQL reserved words
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50, message = "Le prénom doit contenir entre 2 et 50 caractères")
    private String firstName;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    private String lastName;

    @Column(unique = true, nullable = false)
    @NotNull
    @Email(message = "Format d'email invalide")
    private String email;

    @Column(nullable = false)
    @NotNull
    private String password;

    @Column()
    private String photoId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime registrationDate;
}
