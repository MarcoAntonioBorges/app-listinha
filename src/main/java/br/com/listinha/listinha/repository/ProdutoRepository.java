package br.com.listinha.listinha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.listinha.listinha.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Page<Produto> findByNome(String nome, Pageable paginacao);

	Produto findByNome(String nome);

}
