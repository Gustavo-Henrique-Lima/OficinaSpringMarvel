package com.snct.marvel.entities;

import java.io.Serializable;
import java.util.Objects;

import com.snct.marvel.entities.enums.TipoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_personagem")
public class Personagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 90, unique = true)
	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	private String url_foto;
	private TipoEnum tipo;
	@Size(min = 0)
	private int aparicoes;
	@Size(min = 0, max = 10)
	private double popularidade;

	public Personagem() {
	}

	public Personagem(Long id, String nome, String url_foto, TipoEnum tipo, int aparicoes, double popularidade) {
		this.id = id;
		this.nome = nome;
		this.url_foto = url_foto;
		this.tipo = tipo;
		this.aparicoes = aparicoes;
		this.popularidade = popularidade;
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

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public int getAparicoes() {
		return aparicoes;
	}

	public void setAparicoes(int aparicoes) {
		this.aparicoes = aparicoes;
	}

	public double getPopularidade() {
		return popularidade;
	}

	public void setPopularidade(double popularidade) {
		this.popularidade = popularidade;
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
		Personagem other = (Personagem) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}