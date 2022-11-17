package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SuperCarRepository extends JpaRepository<SuperCar, Long> {

    @Query("select count(s) from SuperCar s")
    public Long getCountOfSuperCar(Long superCarId);

    @Query("select s from SuperCar s where function('to_char', s.superCarReleaseDate, 'yyyyMMdd') = :superCarReleaseDate")
    public List<SuperCar> findSuperCarByReleaseDate(String superCarReleaseDate);

    @Query("select s from SuperCar s where s.superCarColor like :keyword")
    public List<SuperCar> findSuperCarByColorContaining(@Param("keyword") String keyword);

    @Query("select s from SuperCar s where s.superCarReleaseDate between :startDate and :endDate")
    public List<SuperCar> findSuperCarBetweenReleaseDate(LocalDateTime startDate, LocalDateTime endDate);

    @Query("select s from SuperCar s order by s.superCarId desc")
    public List<SuperCar> findAllPaging(int offset, int limit);

    @Query("update SuperCar s set s.superCarPrice = s.superCarPrice * 1.1 where function('to_char', s.superCarReleaseDate, 'yyyyMMdd') = :superCarReleaseDate")
    public List<SuperCar> bulkUpdate(String superCarReleaseDate);

}
