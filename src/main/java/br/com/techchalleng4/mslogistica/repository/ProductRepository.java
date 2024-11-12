package br.com.techchalleng4.mslogistica.repository;

import br.com.techchalleng4.mslogistica.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
