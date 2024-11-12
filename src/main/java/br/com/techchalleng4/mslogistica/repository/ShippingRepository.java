package br.com.techchalleng4.mslogistica.repository;

import br.com.techchalleng4.mslogistica.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, UUID> {
}
