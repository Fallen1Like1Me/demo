package com.example.demo.repository;

import com.example.demo.model.Pasport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PasportRepository extends JpaRepository<Pasport, Long> {


}
