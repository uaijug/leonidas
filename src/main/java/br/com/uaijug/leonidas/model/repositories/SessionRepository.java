package br.com.uaijug.leonidas.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uaijug.leonidas.model.domain.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
