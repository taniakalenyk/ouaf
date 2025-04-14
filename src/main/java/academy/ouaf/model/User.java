package com.club.sobaka.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users") // Custom table name to avoid conflicts with SQL reserved words
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the user

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name; // User's name

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 50, message = "")
    private String lastname; // User's lastname

    @Column(unique = true, nullable = false)
    @NotNull
    @Email(message = "Invalid email format")
    private String email; // Unique email for authentication

    @Column(nullable = false)
    @NotNull
    private String password; // Encrypted password (must be hashed)

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>(); // User roles (e.g., ADMIN, USER)

    @Column(name = "created_at", updatable = false)
    private java.time.LocalDateTime createdAt = java.time.LocalDateTime.now(); // Timestamp of account creation

    @PrePersist
    protected void onCreate() {
        createdAt = java.time.LocalDateTime.now();
    }
}
