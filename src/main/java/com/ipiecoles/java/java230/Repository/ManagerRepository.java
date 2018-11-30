package com.ipiecoles.java.java230.Repository;

import com.ipiecoles.java.java230.model.Manager;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager,Long> {

    @EntityGraph(attributePaths = "equipe")
    Manager findById(Long Id);

    List<Manager> findByPerformanceGreaterThan(Integer performance);
}
