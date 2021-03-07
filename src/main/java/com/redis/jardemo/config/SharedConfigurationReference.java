package com.redis.jardemo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Configuration
@ComponentScan({/*"com.redis.caching", */"com.domedo.caching"})
//@EnableJpaRepositories("com.redis.caching")
//@EntityScan("com.redis.caching")
public class SharedConfigurationReference {}