package com.vn.devmaster.quanlysinhvien.demosinhvien.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO1 {
    private String fullName;
//    private String first_name;
//    private String last_name;

    private String nameClasses;
    private String nameSubject;
    private int point;
}
