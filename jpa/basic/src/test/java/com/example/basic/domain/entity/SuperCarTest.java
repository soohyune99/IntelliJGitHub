package com.example.basic.domain.entity;

import com.example.basic.repository.SuperCarDAO;
import com.example.basic.type.SuperCarBrand;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarTest {
    @Autowired
    private SuperCarDAO superCarDAO;

    @Test
    public void saveTest(){
        SuperCar bentley = new SuperCar();
        SuperCar lamborghini = new SuperCar();
        LocalDateTime bentleyReleaseDate = LocalDateTime.of(2019, 12, 4, 0, 0);
        LocalDateTime lamborghiniReleaseDate = LocalDateTime.of(2022, 4, 25, 0, 0);
        bentley.create(SuperCarBrand.BENTLEY, "White", "GT", 350_000_000L, bentleyReleaseDate);
        lamborghini.create(SuperCarBrand.LAMBORGHINI, "Yellow", "Urus", 450_000_000L, lamborghiniReleaseDate);

        superCarDAO.save(bentley);
        superCarDAO.save(lamborghini);
    }

    @Test
    public void findSuperCarBetweenReleaseDateTest(){
        LocalDateTime startDate = LocalDateTime.of(2019, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 0, 0);
//        Assertions.assertThat(superCarDAO.findSuperCarBetweenReleaseDate(startDate,endDate).get(0).getSuperCarBrand()).isEqualTo(SuperCarBrand.LAMBORGHINI);
        Assertions.assertThat(superCarDAO.findSuperCarBetweenReleaseDate(startDate,endDate).get(0).getSuperCarBrand()).isEqualTo(SuperCarBrand.BENTLEY);
    }
}
