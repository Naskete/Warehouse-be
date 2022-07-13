package com.naskete.manage.dao;

import com.naskete.manage.entity.Ware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareDao extends JpaRepository<Ware, Integer> {
}
