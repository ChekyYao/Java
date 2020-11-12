package com.cheky.springboot.yaml.demo;

import com.cheky.springboot.yaml.demo.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootDemoYamlApplicationTests {

	@Autowired
	Person person;

	@Test
	void contextLoads() {
		//test person which is in yaml
		System.out.println(person);
	}

}
