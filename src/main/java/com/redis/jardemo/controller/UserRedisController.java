package com.redis.jardemo.controller;

import com.redis.caching.entity.BaseObj;
import com.redis.caching.entity.User;
import com.redis.caching.enums.CacheType;
import com.redis.caching.service.RedisDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@RestController
@RequestMapping("/user")
public class UserRedisController {

    @Autowired
    private RedisDynamicService redisDynamicService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        redisDynamicService.create(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userID) {
        return (User) redisDynamicService.get(CacheType.USER, userID);
    }

    @GetMapping("/")
    public Map<String, BaseObj> getAllUser() {
        return redisDynamicService.getAll(CacheType.USER);
    }

//    @DeleteMapping("/{userId}")
//    public void deleteUser(@PathVariable("userId") String userId) {
//        redisService.deleteUser(userId);
//    }
}
