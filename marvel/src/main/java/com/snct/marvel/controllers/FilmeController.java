package com.snct.marvel.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snct.marvel.entities.Filme;
import com.snct.marvel.services.FilmeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {
	
	private final FilmeService service;

	public FilmeController(FilmeService service) {
		this.service = service;
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Filme> buscarFilme(@PathVariable Long id) {
		Filme Filme = service.buscarFilme(id);
		return ResponseEntity.ok(Filme);
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<Filme> buscarFilmePorNome(@PathVariable String nome) {
		Filme Filme = service.buscarFilmeNome(nome);
		return ResponseEntity.ok(Filme);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Filme>> listarFilmes() {
		List<Filme> filmes = service.listarFilmes();
		return ResponseEntity.ok(filmes);
	}

	@PostMapping("/salvar")
	public Filme salvarFilme(@Valid @RequestBody Filme Filme) {
		return service.salvarFilme(Filme);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Filme> atualizarFilme(@Valid @PathVariable Long id, @RequestBody Filme Filme) {
		Filme FilmeAtualizado = service.atualizarFilme(id, Filme);
		return ResponseEntity.ok(FilmeAtualizado);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
		service.deletarFilme(id);
		return ResponseEntity.noContent().build();
	}
}
