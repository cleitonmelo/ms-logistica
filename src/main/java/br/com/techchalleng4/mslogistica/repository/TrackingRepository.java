package br.com.techchalleng4.mslogistica.repository;

import br.com.techchalleng4.mslogistica.model.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackingRepository extends JpaRepository<Tracking, UUID> {
}
