package br.com.listinha.listinha.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.listinha.listinha.model.Produto;
import br.com.listinha.listinha.model.UnidadeMedida;

public class ProdutoDTO {

	
	private Long codigo;
	
	private String nome;
	private String descricao;
	private Double preco;
	private LocalDate dataValidade;
	private Long quantidade;
	private UnidadeMedida unidadeMedida;
	
	public ProdutoDTO(Produto produto) {
		super();
		this.codigo = produto.getCodigo();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.dataValidade = produto.getDataValidade();
		this.quantidade = produto.getQuantidade();
		this.unidadeMedida = produto.getUnidadeMedida();
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
	
	public static Page<ProdutoDTO> converter(Page<Produto> produtos) {
		return produtos.map(ProdutoDTO::new);
	}
	
}
