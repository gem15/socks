package com.example.socks.repository;

import com.example.socks.model.Sock;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SockRepository extends CrudRepository<Sock,Integer> {

    Sock findByColorAndCottonPart(String color,int cottonPart);

    // поиск по условию
    List<Sock> findAllByColorAndCottonPartLessThan(String color,int percent);
    List<Sock> findAllByColorAndCottonPartGreaterThan(String color,int percent);
    List<Sock> findAllByColorAndCottonPartEquals(String color,int percent);

    @Modifying
    @Query("UPDATE sock SET quantity = :qty WHERE id = :id")
    boolean updateById(@Param("id") int id, @Param("qty") int qty);
}
