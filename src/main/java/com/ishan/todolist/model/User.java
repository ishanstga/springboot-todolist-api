package com.ishan.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotBlank(message = "username cannot be blank")
    @Pattern(regexp = "^[A-Za-z _-]+$", message = "username must not contain numbers or special characters")
    @Size(min=3, message = "username must have at least 3 letters")
    private String username;
}
