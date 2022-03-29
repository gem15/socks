package com.example.socks.service;

import com.example.socks.model.Sock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ISocksService {
    @Transactional
    Sock income(Sock sock);

    @Transactional
    Sock outcome(Sock sock, int qty);

    int sumSocks(String color, String operation, int cottonPart);

    @Deprecated
    List<Sock> totalSocks(String color, String operation, int cottonPart);

    Sock findSock(Sock sock);
}
