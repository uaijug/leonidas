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

import br.com.uaijug.leonidas.model.domain.Event;
import br.com.uaijug.leonidas.model.service.EventService;
import br.com.uaijug.leonidas.web.exception.EventNotFoundException;

@RestController
@RequestMapping("/api/events")
public class InstituitionController extends AbstractRestController {
	
	@Autowired
    private EventService eventService;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Event> list() {
        return eventService.list();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Event findById(@PathVariable Long id) throws EventNotFoundException {
    	Event dailyWorkSchedule = null;
        try {
        	dailyWorkSchedule = eventService.findById(id);
        } catch (Exception e) {
            throw new EventNotFoundException("Evento não Existe", e);
        }

        return dailyWorkSchedule;
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Event create(@RequestBody @Valid Event dailyWorkSchedule) {
        eventService.save(dailyWorkSchedule);
        return dailyWorkSchedule;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Event update(@PathVariable Long id, @RequestBody @Valid Event dailyWorkSchedule) throws EventNotFoundException {
    	Event result = null;
        try {
            result = eventService.update(id, dailyWorkSchedule);
        } catch (Exception e) {
            throw new EventNotFoundException("Evento não Existe", e);
        }
        return result;
    }

    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable Long id) throws EventNotFoundException {
        try {
            eventService.delete(id);
        } catch (Exception e) {
			throw new EventNotFoundException("Evento não Existe", e);
        }
    }
}
