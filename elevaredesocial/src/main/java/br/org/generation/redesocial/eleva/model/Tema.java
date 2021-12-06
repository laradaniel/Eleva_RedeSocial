package br.org.generation.redesocial.eleva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_temas")
public class Tema {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo Título é obrigatório")
	@Size(min = 5, max = 255, message = "O atributo possuí um mínimo de 5 caracteres e máximo de 255 caracteres")
	private String tituloTema;
	
	@NotNull(message = "O atributo Descrição não pode ser nulo")
	@Size(min = 5, max = 1000, message = "O atributo possuí um mínimo de 5 caracteres e máximo de 1000 caracteres")
	private String descricao;
	
	@NotBlank(message = "O atributo Palavra Chave é obrigatório")
	@Size(min = 2, max = 255, message = "O atributo possuí um mínimo de 5 caracteres e máximo de 255 caracteres")
	private String palavraChave;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloTema() {
		return tituloTema;
	}

	public void setTituloTema(String tituloTema) {
		this.tituloTema = tituloTema;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}
	
	
	
	
	
	
}
