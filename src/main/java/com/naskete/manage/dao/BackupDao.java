package com.naskete.manage.dao;

import com.naskete.manage.entity.Backup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackupDao extends JpaRepository<Backup, Integer> {
}
