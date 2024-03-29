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

import br.com.uaijug.leonidas.model.domain.Institution;
import br.com.uaijug.leonidas.model.service.InstitutionService;
import br.com.uaijug.leonidas.web.exception.InstituitionNotFoundException;

@RestController
@RequestMapping("/api/instituitions")
public class InstituitionController extends AbstractRestController {
	
	@Autowired
    private InstitutionService instituitionService;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Institution> list() {
        return instituitionService.list();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Institution findById(@PathVariable Long id) throws InstituitionNotFoundException {
    	Institution dailyWorkSchedule = null;
        try {
        	dailyWorkSchedule = instituitionService.findById(id);
        } catch (Exception e) {
            throw new InstituitionNotFoundException("Instituitiono não Existe", e);
        }

        return dailyWorkSchedule;
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Institution create(@RequestBody @Valid Institution dailyWorkSchedule) {
        instituitionService.save(dailyWorkSchedule);
        return dailyWorkSchedule;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Institution update(@PathVariable Long id, @RequestBody @Valid Institution dailyWorkSchedule) throws InstituitionNotFoundException {
    	Institution result = null;
        try {
            result = instituitionService.update(id, dailyWorkSchedule);
        } catch (Exception e) {
            throw new InstituitionNotFoundException("Instituitiono não Existe", e);
        }
        return result;
    }

    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable Long id) throws InstituitionNotFoundException {
        try {
            instituitionService.delete(id);
        } catch (Exception e) {
			throw new InstituitionNotFoundException("Instituitiono não Existe", e);
        }
    }
}
