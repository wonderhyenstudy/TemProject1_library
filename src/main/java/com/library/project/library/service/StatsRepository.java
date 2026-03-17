package com.library.project.library.service;


import com.library.project.library.entity.LibraryStatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<LibraryStatsEntity, Long> {
    // interface로 선언해야 JpaRepository의 모든 기능을 사용할 수 있습니다.
}
