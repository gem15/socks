package com.example.socks.controller;

import com.example.socks.model.Sock;
import com.example.socks.service.SocksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/socks")
public class SocksController {

    private final SocksService socksService;

    @Autowired
    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @PostMapping("/income")
    public ResponseEntity<Sock> income(@Valid @RequestBody Sock sock){
        return ResponseEntity.status(HttpStatus.CREATED).body(socksService.income(sock));
    }

    @PostMapping("/outcome")
    public ResponseEntity<Sock> outcome(@Valid @RequestBody Sock sock){
        //FIXME do it
        Sock s = socksService.findSock(sock);

        if (s == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sock);
        }
        int qty = s.getQuantity() - sock.getQuantity();
//        if (qty == 0)
//            sockRepository.delete(sock);
//        else
        if (qty > 0)
            s = socksService.outcome(s,qty);
        else
            // обработка?
            log.error("Расход превышает остаток");

        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    //api/socks?color=red&operation=moreThan&cottonPart=90
    @GetMapping
    public ResponseEntity<List<Sock>> socks(
            @RequestParam String color,
            @RequestParam("operation") String operation,
            @RequestParam("cottonPart") int cottonPart
    ){
        return ResponseEntity.ok(socksService.totalSocks(color,operation,cottonPart));
    }

}
