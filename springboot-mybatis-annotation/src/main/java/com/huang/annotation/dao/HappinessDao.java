package com.huang.annotation.dao;

import com.huang.annotation.vo.Happiness;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by sccy on 2019/7/9/0009.
 */
@Mapper
public interface HappinessDao {

    @Select("Select * from happiness where city = '${city}'")
    Happiness findHappinessByCity(@Param("city")String city);

    @Insert("insert into happiness(city,num) values('${city}','${num}')")
    int insertHappiness(@Param("city")String city,@Param("num")Integer num);
}
