package com.oracle.poc.demomuiltipledatabase.nssfdb2.repo;

import com.oracle.poc.demomuiltipledatabase.nssfdb2.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
}
