package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    // create && update
    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity){
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> getAll(){
        return userService.findAll();
    }

    // delete
    @DeleteMapping("")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }


    // findById -> path variable
    @GetMapping("/id/{id}")
    public UserEntity findById(@PathVariable Long id){
        var response = userService.findById(id);
        return response.get();
    }

    @GetMapping("/score")
    public List<UserEntity> filterScore(@RequestParam int score){
        return userService.filterScore(score);
    }



}
