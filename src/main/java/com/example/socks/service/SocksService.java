package com.example.socks.service;

import com.example.socks.model.Sock;
import com.example.socks.repository.SockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SocksService {

    @Autowired
    SockRepository sockRepository;

    @Transactional
    public Sock saveIncome(Sock sock) {
        return sockRepository.save(sock);
    }
}
