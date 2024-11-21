package com.example.lap7.Controller;

import com.example.lap7.Model.User;
import com.example.lap7.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserContriller {

    private final UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @PostMapping("/addUsers")
    public ResponseEntity addUsers(@RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUsers(user);
        return ResponseEntity.status(200).body("added user successfully");
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable String id  ,@RequestBody @Valid User user , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body("updated successfully");
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        if (userService.deleteUser(id) == true){
            return ResponseEntity.status(200).body("Deleted new article");
        }
        return ResponseEntity.status(400).body("Not found");
    }

    @PutMapping("/Register_courses/{id}")
    public ResponseEntity  Register_courses(@PathVariable String id){
        boolean result = userService.Register_courses(id);
        if(result){
            return ResponseEntity.status(200).body("Registered courses");
        }
        return ResponseEntity.status(400).body("Not found");
    }

    @GetMapping("/getNameRegister")
    public ResponseEntity getNameRegister(){
        return ResponseEntity.ok(userService.getNameRegister());
    }

    @PutMapping("/checkCourse1")
    public ResponseEntity checkCourse1(){
        return ResponseEntity.ok(userService.checkCourse1());
    }





}
