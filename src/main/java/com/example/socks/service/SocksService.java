package com.example.socks.service;

import com.example.socks.model.Sock;
import com.example.socks.repository.SockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@Slf4j
@Service
public class SocksService implements ISocksService {

    @Autowired
    SockRepository sockRepository;

    @Override
    @Transactional
    public Sock income(Sock sock) {
        Sock s = sockRepository.findByColorAndCottonPart(sock.getColor(), sock.getCottonPart());
        if (s == null)
            return sockRepository.save(sock);
        else {
            s.setQuantity(s.getQuantity() + sock.getQuantity());
            sockRepository.updateById(s.getID(), s.getQuantity());
            return s;
        }
    }

    @Override
    @Transactional
    public Sock outcome(Sock sock, int qty) {
//        Sock s = sockRepository.findByColorAndCottonPart(sock.getColor(), sock.getCottonPart());
        sockRepository.updateById(sock.getID(), qty);
        sock.setQuantity(qty);
        return sock;
    }

    @Override
    public int sumSocks(String color, String operation, int cottonPart) {
        //moreThan, lessThan, equal
        int sum = 0;
        switch (operation) {
            case "moreThan":
                sum = sockRepository.findByColorAndCottonPartGreaterThan(color, cottonPart).orElse(0);
                break;
            case "lessThan":
                sum = sockRepository.findByColorAndCottonPartLessThan(color, cottonPart).orElse(0);
                break;
            case "equal":
                sum = sockRepository.findByColorAndCottonPartEquals(color, cottonPart).orElse(0);
                break;
        }
        return sum;
    }

    @Override
    @Deprecated
    public List<Sock> totalSocks(String color, String operation, int cottonPart) {
        //moreThan, lessThan, equal
        List<Sock> socks = new ArrayList<>();
        switch (operation) {
            case "moreThan":
                socks = sockRepository.findAllByColorAndCottonPartGreaterThan(color, cottonPart);
                break;
            case "lessThan":
                socks = sockRepository.findAllByColorAndCottonPartLessThan(color, cottonPart);
                break;
            case "equal":
                socks = sockRepository.findAllByColorAndCottonPartEquals(color, cottonPart);
                break;
        }
        return socks;
    }

    @Override
    public Sock findSock(Sock sock) {
        return sockRepository.findByColorAndCottonPart(sock.getColor(), sock.getCottonPart());
    }
}
