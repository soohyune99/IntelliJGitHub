package com.example.basic.domain.entity;

import com.example.basic.repository.SuperCarRepository;
import com.example.basic.type.SuperCarBrand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarRepositoryTest {

    @Autowired
    private SuperCarRepository superCarRepository;

    @Test
    public void saveTest(){
        SuperCar bentley = new SuperCar();
        SuperCar lamborghini = new SuperCar();

        LocalDateTime bentleyReleaseDate = LocalDateTime.of(2019, 12, 4, 0, 0);
        LocalDateTime lamborghiniReleaseDate = LocalDateTime.of(2022, 4, 25, 0, 0);

        bentley.create(SuperCarBrand.BENTLEY, "White", "GT", 350_000_000L, bentleyReleaseDate);
        lamborghini.create(SuperCarBrand.LAMBORGHINI, "Yellow", "Urus", 450_000_000L, lamborghiniReleaseDate);

        log.info("saved superCar: " + superCarRepository.save(bentley));
        log.info("saved superCar: " + superCarRepository.save(lamborghini));
    }

    @Test
    public void deleteTest(){
        superCarRepository.deleteById(3L);
    }

    @Test
    public void findByIdTest(){
        assertThat(superCarRepository.findById(3L)).isNotEmpty();
    }

//    @Test
//    public void findAllTest(){
//        assertThat(superCarRepository.findAll());
//    }

    @Test
    public void getCountOfSuperCarTest(){
        superCarRepository.getCountOfSuperCar(3L);
    }

    @Test
    public void findSuperCarByReleaseDateTest(){
        LocalDateTime releaseDate = LocalDateTime.of(2022, 4, 25, 0, 0);
        String format = releaseDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        superCarRepository.findSuperCarByReleaseDate(format).stream().map(SuperCar::getSuperCarName).forEach(log::info);
    }

    @Test
    public void findSuperCarByColorContainingTest(){
        superCarRepository.findSuperCarByColorContaining("White").stream().map(SuperCar::getSuperCarBrand).forEach(brand -> {
            log.info("brand: " + brand);
        });
        assertThat(superCarRepository.findSuperCarByColorContaining("White").stream().map(SuperCar::getSuperCarBrand).collect(Collectors.toList()).get(0).name()).isEqualTo("BENTLEY");
    }

    @Test
    public void findSuperCarBetweenReleaseDateTest(){
        LocalDateTime startDate = LocalDateTime.of(2019, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 0, 0);
        assertThat(superCarRepository.findSuperCarBetweenReleaseDate(startDate,endDate).get(0).getSuperCarBrand()).isEqualTo(SuperCarBrand.BENTLEY);
    }

    @Test
    public void findAllPagingTest(){
        superCarRepository.findAllPaging(10, 10).stream().map(SuperCar::getSuperCarName).forEach(log::info);
    }

    @Test
    public void bulkUpdateTest(){
        
    }
}
