package com.kimdain.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimdain.basic.service.BasicService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final BasicService basicService;

    @GetMapping("/{principle}")
    public String getJwt(
        @PathVariable("principle") String principle
    ){
        return basicService.getJwt(principle);
    }
}