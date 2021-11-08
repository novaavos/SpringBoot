package br.com.generation.farmacia.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.farmacia.model.Produto;
import br.com.generation.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAllProduto(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findByIDProduto(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/produtos/{nome}")
	public ResponseEntity<List<Produto>> findByDescricaoTitulo(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Produto> postProduto (@RequestBody Produto Produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto (@RequestBody Produto Produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Produto));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		repository.deleteById(id);
	}
}
