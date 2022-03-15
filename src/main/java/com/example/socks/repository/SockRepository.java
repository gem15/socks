package com.example.socks.repository;

import com.example.socks.model.Sock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SockRepository extends CrudRepository<Sock,Integer> {
    Sock findByColorAndCottonPart(String color,int cottonPart);
    List<Sock> findAllByColorAndCottonPartLessThan(String color,int percent);
    List<Sock> findAllByColorAndCottonPartGreaterThan(String color,int percent);
    List<Sock> findAllByColorAndCottonPartEquals(String color,int percent);
}
