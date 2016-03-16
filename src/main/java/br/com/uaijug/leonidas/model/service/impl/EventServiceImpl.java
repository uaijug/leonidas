package br.com.uaijug.leonidas.model.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uaijug.leonidas.model.domain.Event;
import br.com.uaijug.leonidas.model.repositories.EventRepository;
import br.com.uaijug.leonidas.model.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	@Transactional
	public Event create(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Event save(Event event) {
		event.setCreateBy("sistema@geden.com.br");
		event.setCreatedDate(new Date());
		return create(event);
	}

	@Override
	public Event update(Long id, Event event) {
		Event result = loadEvent(id);
		/*result.setNeighbourhood(event.getNeighbourhood());
		result.setName(event.getName());
		result.setNumber(event.getNumber());
		result.setLastModifiedBy("sistema@geden.com.br");
		result.setLastModifiedDate(new Date());*/
		return create(result);
	}

	@Override
	public List<Event> list() {
		return eventRepository.findAll();
	}

	@Override
	public Event findById(Long id) {
		return eventRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		eventRepository.delete(id);
	}

	@Transactional
	public Event loadEvent(Long id) {
		Event result = eventRepository.findOne(id);

		if (result == null) {
			throw new EntityNotFoundException("Zona não encontrada");
		}

		return result;
	}

}
