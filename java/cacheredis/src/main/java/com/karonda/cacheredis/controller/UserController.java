package com.karonda.cacheredis.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.karonda.cacheredis.entity.User;
import com.karonda.cacheredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;
//    @Autowired
//    StringRedisTemplate redisTemplate;

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable int id){
        Map<String, Object> stringObjectMap = userService.get(id);
        return stringObjectMap;
    }

    @GetMapping("")
    public List<User> getAll(){

        return userService.getAll();
    }

    @PutMapping("")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return userService.delete(id);
    }

    @DeleteMapping("")
    public boolean deleteAll(){
        return userService.deleteAll();
    }
    @GetMapping("test")
    public User test(){
        String jsonStr = redisTemplate.opsForValue().get("user::1");
        User testVo= JSON.parseObject(jsonStr, User.class);
        return testVo;
    }
}
