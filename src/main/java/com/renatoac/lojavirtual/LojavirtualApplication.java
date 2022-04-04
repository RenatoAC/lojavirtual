package com.renatoac.lojavirtual;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renatoac.lojavirtual.domain.Categoria;
import com.renatoac.lojavirtual.repositories.CategoriaRepository;

@SpringBootApplication
public class LojavirtualApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LojavirtualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Camisetas");
		Categoria cat2 = new Categoria(null, "Bermudas");
		Categoria cat3 = new Categoria(null, "Vestidos");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}

}
