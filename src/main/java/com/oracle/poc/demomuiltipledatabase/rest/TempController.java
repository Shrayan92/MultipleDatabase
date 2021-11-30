package com.oracle.poc.demomuiltipledatabase.rest;

import com.oracle.poc.demomuiltipledatabase.nssfdb.model.Student;
import com.oracle.poc.demomuiltipledatabase.nssfdb.model.StudentTeacher;
import com.oracle.poc.demomuiltipledatabase.nssfdb.repo.StudentRepo;
import com.oracle.poc.demomuiltipledatabase.nssfdb.repo.StudentTeacherRepo;
import com.oracle.poc.demomuiltipledatabase.nssfdb2.model.Teacher;
import com.oracle.poc.demomuiltipledatabase.nssfdb2.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class TempController {

    @Autowired
    TeacherRepo teacherRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentTeacherRepo studentTeacherRepo;

    @Value("${firstdatabasename}")
    String first;

    @Value("${seconddatabasename}")
    String second;

    @GetMapping("get-data")
    public String getData(){
//        Teacher teacher = teacherRepo.findById(1).get();
//        Student student = studentRepo.findById(1).get();

        System.out.println(first+"  "+second);

        List<StudentTeacher> studentTeacherList = studentTeacherRepo.getListStudentTeacher(first+".Student",second+".Teacher");

//        System.out.println("Teacher::"+teacher.toString());
//        System.out.println("Student::"+student.toString());
//        System.out.println("StudentTeacher::"+studentTeacherList);

        return "data";
    }
}
