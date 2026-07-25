package com.spring_validation.validation.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String state;
}
