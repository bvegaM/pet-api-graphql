package com.bvega.petapigraphql.repository;

import com.bvega.petapigraphql.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleCrudRepository extends JpaRepository<Schedule,Long> {

    List<Schedule> findByPetsId(Long id);
    List<Schedule> findByEmployeesId(Long id);
    List<Schedule> findByPetsOwnerId(Long id);
}
