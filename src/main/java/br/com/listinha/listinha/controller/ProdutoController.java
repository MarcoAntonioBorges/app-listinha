package br.com.listinha.listinha.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.listinha.listinha.dto.ProdutoDTO;
import br.com.listinha.listinha.form.ProdutoForm;
import br.com.listinha.listinha.model.Produto;
import br.com.listinha.listinha.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	public Page<ProdutoDTO> listar(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "codigo", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Produto> produtos;
		if (nome != null) {
			produtos = repository.findByNome(nome, paginacao);
		} else {
			produtos = repository.findAll(paginacao);
		}
		return ProdutoDTO.converter(produtos);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoDTO> buscarPorCodigo(
			@PathVariable Long codigo) {
		Optional<Produto> produtos = repository.findById(codigo);
		if (produtos.isPresent()) {
			return ResponseEntity.ok(new ProdutoDTO(produtos.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDTO> cadastrar(
			@RequestBody @Valid ProdutoForm form,
			UriComponentsBuilder uriBuilder) {
		Produto produtoEncontrado = repository.findByNome(form
				.getNome());
		Produto produto;
		if (produtoEncontrado != null) {
			produto = produtoEncontrado;
		} else {
			produto = form.converter();
			repository.save(produto);
		}
		URI uri = uriBuilder.path("/produtos/{codigo}").buildAndExpand(produto
				.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
	}

	
	@PutMapping("/{codigo}")
	@Transactional
	public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long codigo,
			@RequestBody @Valid ProdutoForm form) {
		Optional<Produto> optional = repository.findById(codigo);
		if (optional.isPresent()) {
			Produto usuario = form.atualizar(codigo, repository);
			return ResponseEntity.ok(new ProdutoDTO(usuario));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long codigo) {
		Optional<Produto> produto = repository.findById(codigo);
		if (produto.isPresent()) {
			repository.deleteById(codigo);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
