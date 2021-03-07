package com.redis.jardemo.controller;

import com.domedo.caching.enums.DomedoCacheType;
import com.domedo.caching.pojos.UserCache;
import com.domedo.caching.pojos.api.DomedoCache;
import com.domedo.caching.service.IDomedoCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@RestController
@RequestMapping(value = "/user")
public class UserCacheController {

    @Autowired
    private IDomedoCachingService domedoCachingService;

    @PostMapping()
    public String put(@RequestBody UserCache user) {
        domedoCachingService.put(user);
        return "Saved sucessfully in cache";
    }

    @GetMapping("/{userId}")
    public UserCache get(@PathVariable("userId") String userId) {
        return (UserCache) domedoCachingService.get(DomedoCacheType.USER, userId);
    }
}
