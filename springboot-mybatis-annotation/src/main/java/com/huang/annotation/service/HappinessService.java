package com.huang.annotation.service;

import com.huang.annotation.vo.Happiness;
import com.huang.annotation.dao.HappinessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sccy on 2019/7/9/0009.
 */
@Service
public class HappinessService {

    @Autowired
    private HappinessDao happinessDao;

    public Happiness selectService(String city){
        return happinessDao.findHappinessByCity(city);
    }

    @Transactional
    public void insertService(){
        happinessDao.insertHappiness("西安",9421);
        happinessDao.insertHappiness("长安",1294);
    }
}
