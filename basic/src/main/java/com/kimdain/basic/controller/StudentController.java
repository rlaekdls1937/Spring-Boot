package com.kimdain.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimdain.basic.dto.request.student.PostStudentRequestDto;

import jakarta.validation.Valid;
// 비즈니스 로직 x
@RestController
@RequestMapping("/student")  // <- 첫 /는 생략가능
public class StudentController {

    // CREATE 
    @PostMapping("/")     
    public ResponseEntity<String> postStudent( 
        @RequestBody @Valid PostStudentRequestDto requestbody
    ){
        return null;
    }
    
    //UPDATE 
    @PatchMapping("/")
    public ResponseEntity<?> patchStudent(){
        return null;
    }

    // DELETE 
    @DeleteMapping("/{studentNumber}")
    public ResponseEntity<?> deleteStudent(
        @PathVariable("studentNumber") Integer studentNumber
    ){
        return null;
    }

}
