package com.nctech.studentmanagement.database;

import com.nctech.studentmanagement.dto.StudentDTO;

import java.util.LinkedList;
import java.util.List;

public class StudentDB {
    public static List<StudentDTO> students = new LinkedList<>();

    public static void savetoList(StudentDTO student){
        students.add(student);
    }

}
