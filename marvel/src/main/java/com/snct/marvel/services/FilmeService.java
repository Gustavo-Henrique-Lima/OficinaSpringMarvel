package com.snct.marvel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.snct.marvel.entities.Filme;
import com.snct.marvel.repositories.FilmeRepository;

@Service
public class FilmeService {

	private final FilmeRepository repository;

	public FilmeService(FilmeRepository repository) {
		this.repository = repository;
	}

	public Filme buscarFilme(Long id) {
		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Filme não encontrado"));
	}

	public Filme buscarFilmeNome(String nome) {
		return repository.findByNome(nome);
	}

	public List<Filme> listarFilmes() {
		return repository.findAll();
	}

	public Filme salvarFilme(Filme Filme) {
		return repository.save(Filme);
	}

	public Filme atualizarFilme(Long id, Filme f) {
		Filme filme = buscarFilme(id);

		filme.setAvaliacao(f.getAvaliacao());

		repository.save(filme);

		return filme;
	}

	public void deletarFilme(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Filme não encontrado");
		}
	}
}