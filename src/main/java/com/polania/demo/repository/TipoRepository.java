package com.polania.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polania.demo.entities.TipoServicio;

public interface TipoRepository extends JpaRepository<TipoServicio, Integer>{

}
