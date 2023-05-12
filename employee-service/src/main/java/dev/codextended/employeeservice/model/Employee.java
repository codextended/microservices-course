package dev.codextended.employeeservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Firstname can't be empty")
    private String firstname;

    @NotEmpty(message = "Lastname can't be empty")
    private String lastname;

    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Must provide an email")
    private String email;
}
