package com.oracle.poc.demomuiltipledatabase.nssfdb.repo;

import com.oracle.poc.demomuiltipledatabase.nssfdb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
