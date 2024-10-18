package com.snct.marvel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.snct.marvel.entities.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

	Personagem findByNome(String nome);

}