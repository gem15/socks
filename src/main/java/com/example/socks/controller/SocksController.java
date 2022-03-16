package com.example.socks.controller;

import com.example.socks.model.Sock;
import com.example.socks.service.SocksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/socks")
public class SocksController {

    private final SocksService socksService;

    @Autowired
    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @Operation(summary = "Регистрирует приход носков на склад.")
    @ApiResponse(responseCode = "201", description = "Носки оприходованы", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Sock.class))})
    @PostMapping("/income")
    public ResponseEntity<Sock> income(@Valid @RequestBody Sock sock) {
        return ResponseEntity.status(HttpStatus.CREATED).body(socksService.income(sock));
    }

    @Operation(summary = "Регистрирует отпуск носков со склада.")
    @ApiResponse(responseCode = "204", description = "Носки отпущены со склада", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Sock.class))})
    @PostMapping("/outcome")
    public ResponseEntity<Void> outcome(@Valid @RequestBody Sock sock) {
        Sock s = socksService.findSock(sock);
        if (s == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        int qty = s.getQuantity() - sock.getQuantity();
//        if (qty == 0)
//            sockRepository.delete(sock);
//        else
        if (qty >= 0) {
            s = socksService.outcome(s, qty);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            return ResponseEntity.status(HttpStatus.OK).body(s);
        } else {
            // обработка?
            log.error("Расход превышает остаток");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //api/socks?color=red&operation=moreThan&cottonPart=90
    @Operation(summary = "Возвращает общее количество носков на складе, соответствующих переданным в параметрах критериям запроса.")
    @ApiResponse(responseCode = "200", description = "Количество носков", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Sock.class))})
    @GetMapping
    public ResponseEntity<Integer> socks(
            @RequestParam String color,
            @RequestParam("operation") String operation,
            @RequestParam("cottonPart") int cottonPart
    ) {
        return ResponseEntity.ok(socksService.sumSocks(color, operation, cottonPart));
    }

/*
    @Operation(summary = "Возвращает общее количество носков на складе, соответствующих переданным в параметрах критериям запроса.")
    @ApiResponse(responseCode = "200", description = "Список носков", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Sock.class))})
    @GetMapping
    public ResponseEntity<List<Sock>> socks(
            @RequestParam String color,
            @RequestParam("operation") String operation,
            @RequestParam("cottonPart") int cottonPart
    ) {
        return ResponseEntity.ok(socksService.totalSocks(color, operation, cottonPart));
    }
*/

}
