package com.maxi.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.agenda.dtos.LoginCreateDTO;
import com.maxi.agenda.dtos.NewLoginCreatedDTO;
import com.maxi.agenda.services.LoginServiceImplementation;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginServiceImplementation service;

    @PostMapping("/create")
    public ResponseEntity<?> createLogin(@RequestBody LoginCreateDTO obj) {
        NewLoginCreatedDTO login = service.createLogin(obj);
        return ResponseEntity.ok().body(login);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String user, String password) {
        return ResponseEntity.ok().body(service.login(user, password));
    }

}
