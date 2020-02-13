package br.com.listinha.listinha.form;

import java.time.LocalDate;

import br.com.listinha.listinha.model.Produto;
import br.com.listinha.listinha.model.UnidadeMedida;
import br.com.listinha.listinha.repository.ProdutoRepository;

public class ProdutoForm {
	
	private String nome;
	private String descricao;
	private Double preco;
	private LocalDate dataValidade;
	private Long quantidade;
	private UnidadeMedida unidadeMedida;
	
	
	public ProdutoForm() {
		super();
	}
	
	public ProdutoForm(String nome, String descricao, Double preco, LocalDate dataValidade, Long quantidade,
			UnidadeMedida unidadeMedida) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
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
	
	public Produto converter() {
		return new Produto(nome, descricao, preco, dataValidade, quantidade, unidadeMedida);
	}

	public Produto atualizar(Long codigo, ProdutoRepository repository) {
		Produto produto = repository.getOne(codigo);
		
		produto.setNome(this.nome);
		produto.setDescricao(this.descricao);
		produto.setPreco(this.preco);
		produto.setDataValidade(this.dataValidade);
		produto.setQuantidade(this.quantidade);
		produto.setUnidadeMedida(this.unidadeMedida);
		
		return produto;
	}
	
}
