package br.com.uaijug.leonidas.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uaijug.leonidas.model.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
