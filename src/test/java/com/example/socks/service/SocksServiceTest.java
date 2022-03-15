package com.example.socks.service;

import com.example.socks.model.Sock;
import com.example.socks.repository.SockRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Description;

import java.util.List;
import java.util.Optional;

//@Sql("/schema.sql")
@DataJdbcTest
class SocksServiceTest {

    @Autowired
    SockRepository sockRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void SockTest() {
        Sock sock =new Sock();
        sock.setColor("red");
        sock.setCottonPart(10);
        sock.setQuantity(2);
        sockRepository.save(sock);
        Optional<Sock> sock1 = sockRepository.findById(sock.getID());

        Sock sock2 = sockRepository.findByColorAndCottonPart("black", 30);

        List<Sock> socks = sockRepository.findAllByColorAndCottonPartLessThan("red", 40);
        List<Sock> socks1 = sockRepository.findAllByColorAndCottonPartGreaterThan("red", 18);
        List<Sock> socks2 = sockRepository.findAllByColorAndCottonPartEquals("red", 10);
        System.out.println("stop");
    }
}