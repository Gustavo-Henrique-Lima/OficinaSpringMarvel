package com.snct.marvel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snct.marvel.entities.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{

	Filme findByNome(String nome);

}