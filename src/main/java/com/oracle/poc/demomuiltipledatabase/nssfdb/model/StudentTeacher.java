package com.oracle.poc.demomuiltipledatabase.nssfdb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class StudentTeacher implements Serializable {

    @Id
    private Integer id;
    private String studentname;
    private String teachername;

    public StudentTeacher() {
    }

    public StudentTeacher(Integer id, String studentname, String teachername) {
        this.id = id;
        this.studentname = studentname;
        this.teachername = teachername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    @Override
    public String toString() {
        return "StudentTeacher{" +
                "studentname='" + studentname + '\'' +
                ", teachername='" + teachername + '\'' +
                '}';
    }
}
