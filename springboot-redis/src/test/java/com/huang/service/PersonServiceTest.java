package com.huang.service;

import com.huang.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    @Test
    public void setStringRedisTemplateDemo() {
        personService.setStringRedisTemplateDemo();
    }

    @Test
    public void save() {
        Person person = new Person("1","hqs",22);
        personService.save(person);
    }

    @Test
    public void getString() {
        String yy = personService.getString();
        System.out.println(yy);
    }

    @Test
    public void getPerson() {
        Person person = personService.getPerson();
        System.out.println(person);
    }
}