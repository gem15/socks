package com.example.socks.repository;

import com.example.socks.model.Mov;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MovRepository extends CrudRepository<Mov,Integer> {
}
