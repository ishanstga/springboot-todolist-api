package com.ishan.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "User ID is required")
    @Positive(message = "User ID must be a positive number")
    private Integer userId;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Status is required")
    private String status;

    @NotBlank(message = "Priority is required")
    private String priority;

    @NotNull(message = "Date created is required")
    @PastOrPresent(message = "Date created cannot be in the future")
    private Date dateCreated;

    @NotNull(message = "Due date is required")
    @FutureOrPresent(message = "Due date must be today or in the future")
    private Date dueDate;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

}
