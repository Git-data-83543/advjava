package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Reciepe;

@Repository
public interface ReciepeRepo extends JpaRepository<Reciepe, Long> {

}
