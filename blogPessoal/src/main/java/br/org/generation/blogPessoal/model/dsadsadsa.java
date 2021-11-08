package br.org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "tb_produto")
public class dsadsadsa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produto;
	
	@NotNull(message = "O atributo título é obrigatório")
	@Size(min = 5, max = 100, message =  "O título deve ter no mínimo 5 e no máximo 100 caracteres!")
	private String titulo;
	
	@NotBlank(message = "A descrição é obrigatória")
	@Size(min = 10, max = 500, message = "O texto deve ter no mínimo 10 e no máximo 500 caracteres!")
	private String descrição;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@Range(min = 0)
	private int estoque;
	
}
