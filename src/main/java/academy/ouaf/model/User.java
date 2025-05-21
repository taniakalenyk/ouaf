package academy.ouaf.model;

import academy.ouaf.views.LoginView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users") // Custom table name to avoid conflicts with SQL reserved words
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class) // For CreatedDate to work
@DiscriminatorColumn(name = "user_type")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50, message = "Le prénom doit contenir entre 2 et 50 caractères")
    private String firstName;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    private String lastName;

    @Column(unique = true, nullable = false)
    @Email(message = "Format d'email invalide")
    @NotNull(groups = LoginView.class)
    @JsonView(LoginView.class)
    private String email;

    @Column(nullable = false)
    @NotNull(groups = LoginView.class)
    @JsonView(LoginView.class)
    private String password;

    @Column()
    private String photoId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime registrationDate;

    @Column(name = "verification_email_token")
    protected String verificationEmailToken = null;

    @Getter
    @Column(name = "user_type", insertable = false, updatable = false)
    protected String role;

    //    public String getRole() {
//        DiscriminatorValue annotation = this.getClass().getAnnotation(DiscriminatorValue.class);
//        return annotation != null ? annotation.value() : this.getClass().getSimpleName();
//    }
}
