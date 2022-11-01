package com.example.ex00.qualifier;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@Qualifier("outback") @Primary
public class Outback implements Resturant {

    private int steakPrice = Resturant.steakPrice + 10000;

    @Override
    public boolean useSaladBar(){
        return false;
    }
}
