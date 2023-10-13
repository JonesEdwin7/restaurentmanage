package com.jones.Restaurant_Management_api.model;

import com.jones.Restaurant_Management_api.model.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Size(min = 8,message = "Password must contains 8 letters")
    private String password;

    @Email(message = "Email is not valid")
    private String email;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private UserRole role;
}
