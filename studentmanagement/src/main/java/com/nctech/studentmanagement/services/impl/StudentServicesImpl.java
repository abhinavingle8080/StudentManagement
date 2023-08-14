package com.nctech.studentmanagement.services.impl;

import com.nctech.studentmanagement.dto.StudentDTO;
import com.nctech.studentmanagement.repository.StudentRepository;
import com.nctech.studentmanagement.repository.impl.StudentRepositoryImpl;
import com.nctech.studentmanagement.services.StudentServices;

import java.util.List;

public class StudentServicesImpl implements StudentServices {

    StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public void save(StudentDTO student) {
        student.setId(studentRepository.get().size() +1);
        studentRepository.save(student);
    }

    @Override
    public StudentDTO fetch(Integer id) {
        for (StudentDTO studentDTO : studentRepository.get()) {
            if (studentDTO.getId().equals(id)) {
                return studentDTO;
            }
        }
        return null;
    }

    @Override
    public List<StudentDTO> fetchAll() {
        return studentRepository.get();
    }

    @Override
    public boolean update(StudentDTO student) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        StudentDTO studentDTO = fetch(id);
        return studentRepository.get().remove(studentDTO);
    }
}
