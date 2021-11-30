package com.oracle.poc.demomuiltipledatabase.nssfdb.repo;

import com.oracle.poc.demomuiltipledatabase.nssfdb.model.StudentTeacher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentTeacherRepo extends JpaRepository<StudentTeacher,Integer> {



    @Query(value = "select Student.id as id ,  Student.name as studentname, Teacher.name as teachername from (:firstdatabase) inner join (:seconddatabase) on Student.id = Teacher.id", nativeQuery = true)
    List<StudentTeacher> getListStudentTeacher( @Param("firstdatabase") String firstdatabase, @Param("seconddatabase") String seconddatabase);

    @Query(value = "?1", nativeQuery = true)
    List<StudentTeacher> getListStudentTeacherQuery(String custQuery);


}
