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

import br.com.uaijug.leonidas.model.domain.Session;
import br.com.uaijug.leonidas.model.service.SessionService;
import br.com.uaijug.leonidas.web.exception.SessionNotFoundException;

@RestController
@RequestMapping("/api/sessions")
public class SessionController extends AbstractRestController {
	
	@Autowired
    private SessionService sessionService;
	
	@RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Session> list() {
        return sessionService.list();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Session findById(@PathVariable Long id) throws SessionNotFoundException {
    	Session session = null;
        try {
        	session = sessionService.findById(id);
        } catch (Exception e) {
            throw new SessionNotFoundException("Sessiono não Existe", e);
        }

        return session;
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Session create(@RequestBody @Valid Session dailyWorkSchedule) {
        sessionService.save(dailyWorkSchedule);
        return dailyWorkSchedule;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Session update(@PathVariable Long id, @RequestBody @Valid Session session) throws SessionNotFoundException {
    	Session result = null;
        try {
            result = sessionService.update(id, session);
        } catch (Exception e) {
            throw new SessionNotFoundException("Sessiono não Existe", e);
        }
        return result;
    }

    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable Long id) throws SessionNotFoundException {
        try {
            sessionService.delete(id);
        } catch (Exception e) {
			throw new SessionNotFoundException("Sessiono não Existe", e);
        }
    }
}
