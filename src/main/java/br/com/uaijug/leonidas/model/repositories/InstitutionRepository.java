package br.com.uaijug.leonidas.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uaijug.leonidas.model.domain.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
