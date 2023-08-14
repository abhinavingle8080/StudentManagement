package com.nctech.studentmanagement.controller;

import com.nctech.studentmanagement.database.StudentDB;
import com.nctech.studentmanagement.dto.StudentDTO;
import com.nctech.studentmanagement.services.StudentServices;
import com.nctech.studentmanagement.services.impl.StudentServicesImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student/")
public class StudentController {

    StudentServices studentServices = new StudentServicesImpl();

    @RequestMapping({"save", "update"})
    public void createOrUpdateStudent(@RequestBody StudentDTO student) {
        if (student.getId() == (null)) {
            studentServices.save(student);
            StudentDB.savetoList(student);
        } else {
            studentServices.update(student);
        }
    }

    @GetMapping("fetch/{id}")
    public StudentDTO fetchStudent(@PathVariable Integer id) {
        return studentServices.fetch(id);
    }

    @GetMapping("fetchAll")
    public List<StudentDTO> fetchAll() {
        return studentServices.fetchAll();
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Integer id) {
        return studentServices.delete(id);
    }

}
