package com.renatoac.lojavirtual;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renatoac.lojavirtual.domain.Categoria;
import com.renatoac.lojavirtual.domain.Cidade;
import com.renatoac.lojavirtual.domain.Estado;
import com.renatoac.lojavirtual.domain.Produto;
import com.renatoac.lojavirtual.repositories.CategoriaRepository;
import com.renatoac.lojavirtual.repositories.CidadeRepository;
import com.renatoac.lojavirtual.repositories.EstadoRepository;
import com.renatoac.lojavirtual.repositories.ProdutoRepository;

@SpringBootApplication
public class LojavirtualApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LojavirtualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Camisetas");
		Categoria cat2 = new Categoria(null, "Bermudas");
		Categoria cat3 = new Categoria(null, "Vestidos");
		
		Produto p1 = new Produto(null, "Camiseta Mickey", 40.00);
		Produto p2 = new Produto(null, "Bermuda Pluto", 45.00);
		Produto p3 = new Produto(null, "Vestido Minnie", 60.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat3));		
				
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Alagoas");
		Estado est2 = new Estado(null, "Pernambuco");
		
		Cidade c1 = new Cidade(null, "Arapiraca", est1);
		Cidade c2 = new Cidade(null, "Lagoa da Canoa", est1);
		Cidade c3 = new Cidade(null, "Bom Conselho", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
	}

}
