package com.huang.service;

import com.huang.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    @Test
    public void save() {
        personService.save(new Person("2","hqs",22));
    }

    @Test
    public void getPerson() {
        System.out.println(personService.getPerson("2"));
    }
}