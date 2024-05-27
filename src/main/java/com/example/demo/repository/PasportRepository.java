package com.example.demo.repository;

import com.example.demo.model.Pasport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasportRepository extends JpaRepository<Pasport, Long> {
}
