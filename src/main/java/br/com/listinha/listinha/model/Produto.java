package br.com.listinha.listinha.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="T_LIS_PRODUTO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto implements Serializable{

	/**
	 * @serial
	 */
	private static final long serialVersionUID = 1357943409866261881L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	private String descricao;
	private Double preco;
	private LocalDate dataValidade;
	private Long quantidade;
	
	@Enumerated(value = EnumType.STRING)
	private UnidadeMedida unidadeMedida;
	
	
	public Produto(Long codigo, String nome, Double preco, LocalDate dataValidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.dataValidade = dataValidade;
	}

	public Produto(String nome, String descricao, Double preco, LocalDate dataValidade, Long quantidade,
			UnidadeMedida unidadeMedida) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
	}

	public Produto(Long codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Produto() {
		super();
	}

	public Produto(Long codigo, String nome, String descricao, Double preco, LocalDate dataValidade, Long quantidade,
			UnidadeMedida unidadeMedida) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public LocalDate getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
}
