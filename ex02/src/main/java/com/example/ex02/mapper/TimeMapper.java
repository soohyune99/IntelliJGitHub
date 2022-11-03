package com.example.ex02.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// Mapper -> 인터페이스 -> 메소드
@Mapper
public interface TimeMapper {

    public String getTime();

//   TimeMapper/xml에서 쓰지 않고 여기서 간단히 작성 가능
    @Select("SELECT CURRENT_DATE FROM DUAL")
    public String getTimeQuick();
}
