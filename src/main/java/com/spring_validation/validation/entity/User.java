package com.spring_validation.validation.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "myuserstable")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "User entity stored in the database")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Auto-generated user ID", example = "1")
    private int userId;

    @Schema(description = "Full name of the user", example = "pankhuri")
    private String name;

    @Schema(description = "Email address", example = "pankhuri@gmail.com")
    private String email;

    @Schema(description = "Mobile number", example = "7423456789")
    private String mobile;

    @Schema(description = "Gender", example = "Female")
    private String gender;

    @Schema(description = "Age in years", example = "27")
    private int age;

    @Schema(description = "State of residence", example = "Bihar")
    private String state;

    @Transient
    private AddressOfUsers address;
}
