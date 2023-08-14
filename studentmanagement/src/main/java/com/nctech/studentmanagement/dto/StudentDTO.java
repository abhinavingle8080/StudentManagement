package com.nctech.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String dob;
    private Integer age;
    private String email;
    private String contact;
    private String fatherName;
    private String highestEducation;
    private String currentEducation;
    private String familyEducation;
    private Double annualIncome;
    private String address;

}
