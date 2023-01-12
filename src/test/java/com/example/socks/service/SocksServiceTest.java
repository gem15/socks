package com.example.socks.service;

import com.example.socks.model.Mov;
import com.example.socks.model.Sock;
import com.example.socks.repository.MovRepository;
import com.example.socks.repository.SockRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

//@Sql("/sock-schema.sql")
@DataJdbcTest
class SocksServiceTest {

    @Autowired
    SockRepository sockRepository;
    @Autowired
    MovRepository movRepository;

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void orderTest() {
        Sock sock = new Sock();
        sock.setColor("red");
        sock.setCottonPart(10);
        sock.setQuantity(2);
        Sock newSock = sockRepository.save(sock);

        Mov mov = new Mov();
        mov.setQuantity(1);
        Set<Mov> movSet = new HashSet<>();
        movSet.add(mov);
        sock.setMovs(movSet);
        sockRepository.save(sock);
        System.out.println("stop");

    }

    @DisplayName("Test repositories")
    @Test
    void SockTest() {
        Sock sock = new Sock();
        sock.setColor("red");
        sock.setCottonPart(10);
        sock.setQuantity(2);
        Sock newSock = sockRepository.save(sock);
        newSock.setQuantity(22);
        sockRepository.save(newSock);
        sock.setQuantity(33);
        sockRepository.save(sock);

        Optional<Sock> sock1 = sockRepository.findById(sock.getID());

        Sock sock2 = sockRepository.findByColorAndCottonPart("black", 30);

        List<Sock> socks = sockRepository.findAllByColorAndCottonPartLessThan("red", 40);
        List<Sock> socks1 = sockRepository.findAllByColorAndCottonPartGreaterThan("red", 18);
        List<Sock> socks2 = sockRepository.findAllByColorAndCottonPartEquals("red", 10);


        boolean ok = sockRepository.updateById(sock.getID(), 100);
        Sock sock4 = sockRepository.findById(sock.getID()).orElse(null);
        assertEquals(100, sock4.getQuantity());

        sockRepository.delete(sock);
        sock = sockRepository.findById(sock.getID()).orElse(null);
        assertNull(sock);
        System.out.println("stop");
    }
}