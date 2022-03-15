package com.example.socks.service;

import com.example.socks.model.Sock;
import com.example.socks.repository.SockRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

//@Sql("/sock-schema.sql")
@DataJdbcTest
class SocksServiceTest {

    @Autowired
    SockRepository sockRepository;

    @DisplayName("Test repositories")
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

        boolean ok = sockRepository.updateById(sock.getID(), 100);
        Sock sock4 = sockRepository.findById(sock.getID()).orElse(null);
        Assertions.assertEquals(100,sock4.getQuantity());

        sockRepository.delete(sock);
        sock = sockRepository.findById(sock.getID()).orElse(null);
        Assertions.assertNull(sock);
        System.out.println("stop");
    }
}