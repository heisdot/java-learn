package com.mycode.javalearn.controller;

import com.mycode.javalearn.exception.base.BizException;
import com.mycode.javalearn.model.DO.User;
import com.mycode.javalearn.model.DTO.UserDTO;
import com.mycode.javalearn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 用户管理接口
 * @Author toolman
 * @Date 2020/12/15 21:06
 **/
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/{id}")
    public User get(@PathVariable String id) {
        log.info("查询用户userId：" + id);
        return userService.getById(id);
    }

    @PostMapping("/")
    public String add(@RequestBody UserDTO userDTO) {
        return "hello";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody UserDTO userDTO) {
        return "hello";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return "hello";
    }

}
