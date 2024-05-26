package com.test.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class employeeDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
