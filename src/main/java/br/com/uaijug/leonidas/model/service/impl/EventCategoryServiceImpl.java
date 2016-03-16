package br.com.uaijug.leonidas.model.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uaijug.leonidas.model.domain.EventCategory;
import br.com.uaijug.leonidas.model.repositories.EventCategoryRepository;
import br.com.uaijug.leonidas.model.service.EventCategoryService;

@Service
public class EventCategoryServiceImpl implements EventCategoryService {

	@Autowired
	private EventCategoryRepository eventCategoryRepository;

	@Override
	@Transactional
	public EventCategory create(EventCategory eventCategory) {
		return eventCategoryRepository.save(eventCategory);
	}

	@Override
	public EventCategory save(EventCategory eventCategory) {
		return create(eventCategory);
	}

	@Override
	public EventCategory update(Long id, EventCategory eventCategory) {
		EventCategory result = loadEventCategory(id);
		/*result.setBlock(eventCategory.getBlock());
		result.setStreet(eventCategory.getStreet());
		result.setLatitude(eventCategory.getLatitude());
		result.setLongitude(eventCategory.getLongitude());
		result.setLastModifiedBy("sistema@geden.com.br");
		result.setLastModifiedDate(new Date());*/
		return create(result);
	}

	@Override
	public List<EventCategory> list() {
		return eventCategoryRepository.findAll();
	}

	@Override
	public EventCategory findById(Long id) {
		return eventCategoryRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		eventCategoryRepository.delete(id);
	}

	@Transactional
	public EventCategory loadEventCategory(Long id) {
		EventCategory result = eventCategoryRepository.findOne(id);

		if (result == null) {
			throw new EntityNotFoundException("Endereço não encontrada");
		}

		return result;
	}
}
