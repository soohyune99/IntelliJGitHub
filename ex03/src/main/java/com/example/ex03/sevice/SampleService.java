package com.example.ex03.sevice;

import com.example.ex03.aspect.LogStatus;
import com.example.ex03.aspect.Plus10;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static java.lang.Integer.*;

@Service
@Slf4j
public class SampleService {

    @Plus10
    @LogStatus
    public Integer doAdd(String str1, String str2) { //PointCut
        log.info("핵심 로직");
        return parseInt(str1) + parseInt(str2);
    }
}
