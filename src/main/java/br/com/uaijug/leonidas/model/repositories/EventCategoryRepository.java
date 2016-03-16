package br.com.uaijug.leonidas.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uaijug.leonidas.model.domain.EventCategory;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Long> {
}
