package com.example.socks.controller;

import com.example.socks.model.Sock;
import com.example.socks.service.SocksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/api/socks")
public class SocksController {

    private final SocksService socksService;

    @Autowired
    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @PostMapping
    public ResponseEntity<Sock> income(@RequestBody Sock sock){
//        socksService.saveIncome(sock);
        return ResponseEntity.status(HttpStatus.CREATED).body(socksService.saveIncome(sock));
    }
    @PostMapping
    public ResponseEntity<Sock> outcome(@RequestBody Sock sock){
//        socksService.saveIncome(sock);
        return ResponseEntity.status(HttpStatus.CREATED).body(socksService.saveIncome(sock));
    }

}
