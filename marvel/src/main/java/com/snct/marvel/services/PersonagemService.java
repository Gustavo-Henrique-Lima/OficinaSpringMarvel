package com.snct.marvel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.snct.marvel.entities.Personagem;
import com.snct.marvel.repositories.PersonagemRepository;

@Service
public class PersonagemService {

	private final PersonagemRepository repository;

	public PersonagemService(PersonagemRepository repository) {
		this.repository = repository;
	}

	public Personagem buscarPersonagem(Long id) {
		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado"));
	}

	public Personagem buscarPersonagemNome(String nome) {
		return repository.findByNome(nome);
	}

	public List<Personagem> listarPersonagens() {
		return repository.findAll();
	}

	public Personagem salvarPersonagem(Personagem personagem) {
		return repository.save(personagem);
	}

	public Personagem atualizarPersonagem(Long id, Personagem p) {
		Personagem personagem = buscarPersonagem(id);

		personagem.setPopularidade(p.getPopularidade());
		personagem.setTipo(p.getTipo());
		personagem.setAparicoes(p.getAparicoes());
		personagem.setUrl_foto(p.getUrl_foto());

		repository.save(personagem);

		return personagem;
	}

	public void deletarPersonagem(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Personagem não encontrado");
		}
	}

}