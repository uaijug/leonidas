package br.com.uaijug.leonidas.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uaijug.leonidas.model.domain.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
	
}
