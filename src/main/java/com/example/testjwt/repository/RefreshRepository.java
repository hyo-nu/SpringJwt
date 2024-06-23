package com.example.testjwt.repository;

import com.example.testjwt.entity.RefreshEntity;
import com.example.testjwt.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshRepository extends JpaRepository<RefreshEntity, Long> {

//    Boolean existsByRefresh(String refresh);

    RefreshEntity findByRefresh(String refresh);

    @Transactional
    void deleteByRefresh(String refresh);
}
