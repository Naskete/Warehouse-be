package com.naskete.manage.dao;

import com.naskete.manage.entity.Ware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WareDao extends JpaRepository<Ware, Integer> {
    @Query(value = "SELECT * FROM ware WHERE ptime > DATE(?1) ", nativeQuery = true)
    List<Ware> findAfterTime(String time);

    @Query(value = "SELECT * FROM ware WHERE ptime > DATE(?1) AND ptime < DATE(?2) ", nativeQuery = true)
    List<Ware> findBetweenTime(String start, String end);
}
