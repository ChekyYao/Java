package com.cheky.springboot.logging.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootDemoLoggingApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {
		//日志的级别
		//由低到高 trace < debug < info < warn < error
		//可以调整输出的日志级别；日志就只会在这个级别及其以后的高级别生效
		logger.trace("这个是trace日志...");
		logger.debug("这个是debug日志...");

		//Spring boot 默认给我们使用的是Info级别，即 没指定级别的就用 SpringBoot默认规定的级别：root级别
		logger.info("这个是info日志...");
		logger.warn("这个是warn日志...");
		logger.error("这个是error日志...");
	}

}
