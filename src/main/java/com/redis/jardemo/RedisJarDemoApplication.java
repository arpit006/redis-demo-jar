package com.redis.jardemo;

import com.redis.caching.service.RedisDynamicService;
import com.redis.jardemo.config.SharedConfigurationReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SharedConfigurationReference.class)
public class RedisJarDemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(RedisJarDemoApplication.class, args);
		RedisDynamicService redisDynamicService = (RedisDynamicService) applicationContext.getBean("redisDynamicService");
		redisDynamicService.printValue();
	}

}
