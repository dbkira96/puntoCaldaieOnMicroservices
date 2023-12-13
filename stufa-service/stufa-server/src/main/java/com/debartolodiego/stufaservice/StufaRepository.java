package com.debartolodiego.stufaservice;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StufaRepository extends JpaRepository<Stufa,Long> {
    List<Stufa> findAllByClientid(Long clientId);
}
