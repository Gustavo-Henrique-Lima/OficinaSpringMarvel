package com.snct.marvel.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "tb_filme")
public class Filme implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 90)
	private String nome;
	@Size(min = 0)
	private double duracao;
	private int ano;
	@Size(min = 0, max = 10)
	private double avaliacao;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_personagens_filme", joinColumns = @JoinColumn(name = "id_filme"), inverseJoinColumns = @JoinColumn(name = "id_personagem"))
	private List<Personagem> personagens;

	public Filme() {
	}

	public Filme(Long id, String nome, double duracao, int ano, double avaliacao) {
		this.id = id;
		this.nome = nome;
		this.duracao = duracao;
		this.ano = ano;
		this.avaliacao = avaliacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Personagem> getPersonagens() {
		return personagens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}