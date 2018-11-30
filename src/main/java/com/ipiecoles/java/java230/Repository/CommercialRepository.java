package com.ipiecoles.java.java230.Repository;

import com.ipiecoles.java.java230.model.Commercial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommercialRepository extends JpaRepository<Commercial,Long> {

    List<Commercial> findByPerformanceGreaterThan(Integer performance);
}
