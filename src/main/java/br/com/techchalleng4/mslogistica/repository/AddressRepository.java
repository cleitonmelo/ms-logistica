package br.com.techchalleng4.mslogistica.repository;

import br.com.techchalleng4.mslogistica.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
