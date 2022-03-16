package com.example.socks.repository;

import com.example.socks.model.Sock;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SockRepository extends CrudRepository<Sock, Integer> {

    Sock findByColorAndCottonPart(String color, int cottonPart);

    // недогляд
    List<Sock> findAllByColorAndCottonPartLessThan(String color,int percent);
    List<Sock> findAllByColorAndCottonPartGreaterThan(String color,int percent);
    List<Sock> findAllByColorAndCottonPartEquals(String color,int percent);

    @Modifying
    @Query("UPDATE sock SET quantity = :qty WHERE id = :id")
    boolean updateById(@Param("id") int id, @Param("qty") int qty);

    @Query("select sum(s.quantity) from sock s where  s.color = :color and s.cotton_part < :part")
    int findByColorAndCottonPartLessThan(@Param("color") String color, @Param("part") int percent);

    @Query("select sum(s.quantity) from sock s where  s.color = :color and s.cotton_part > :part")
    int findByColorAndCottonPartGreaterThan(@Param("color") String color, @Param("part") int percent);

    @Query("select sum(s.quantity) from sock s where  s.color = :color and s.cotton_part = :part")
    int findByColorAndCottonPartEquals(@Param("color") String color, @Param("part") int percent);

}
