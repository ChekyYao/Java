
package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("H311 Hello %s!", name);

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	int age;

	void aa()
	{
		bb();
	}

	/**
	 * 注释信息
	 */
	void bb(){
		Integer a = 128;
		Integer b = 128;
		var c = a == b; //false
		Integer x = 127;
		Integer y = 127;
		var z = x == y; //true
	}

	int add;

}
            