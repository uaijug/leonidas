package br.com.uaijug.leonidas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.uaijug.leonidas.model.domain.EventCategory;
import br.com.uaijug.leonidas.model.service.EventCategoryService;
import br.com.uaijug.leonidas.web.exception.EventCategoryNotFoundException;

@RestController
@RequestMapping("/api/event-categorys")
public class EventCategoryController extends AbstractRestController {
	
	@Autowired
	private EventCategoryService eventCategoryService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<EventCategory> list() {
		return eventCategoryService.list();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public EventCategory findById(@PathVariable Long id) throws EventCategoryNotFoundException {
		EventCategory eventCategory = null;
		try {
			eventCategory = eventCategoryService.findById(id);
		} catch (Exception e) {
			throw new EventCategoryNotFoundException("EventCategoryo não Existe", e);
		}

		return eventCategory;
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public EventCategory create(@RequestBody @Valid EventCategory dailyWorkSchedule) {
		eventCategoryService.save(dailyWorkSchedule);
		return dailyWorkSchedule;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public EventCategory update(@PathVariable Long id, @RequestBody @Valid EventCategory eventCategory) throws EventCategoryNotFoundException {
		EventCategory result = null;
		try {
			result = eventCategoryService.update(id, eventCategory);
		} catch (Exception e) {
			throw new EventCategoryNotFoundException("EventCategoryo não Existe", e);
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void delete(@PathVariable Long id) throws EventCategoryNotFoundException {
		try {
			eventCategoryService.delete(id);
		} catch (Exception e) {
			throw new EventCategoryNotFoundException("EventCategoryo não Existe", e);
		}
	}
}
