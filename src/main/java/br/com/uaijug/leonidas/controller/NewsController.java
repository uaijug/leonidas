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

import br.com.uaijug.leonidas.model.domain.News;
import br.com.uaijug.leonidas.model.service.NewsService;
import br.com.uaijug.leonidas.web.exception.NewsNotFoundException;

@RestController
@RequestMapping("/api/news")
public class NewsController extends AbstractRestController {
	
	@Autowired
    private NewsService newsService;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<News> list() {
        return newsService.list();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public News findById(@PathVariable Long id) throws NewsNotFoundException {
    	News dailyWorkSchedule = null;
        try {
        	dailyWorkSchedule = newsService.findById(id);
        } catch (Exception e) {
            throw new NewsNotFoundException("Newso não Existe", e);
        }

        return dailyWorkSchedule;
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public News create(@RequestBody @Valid News dailyWorkSchedule) {
        newsService.save(dailyWorkSchedule);
        return dailyWorkSchedule;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public News update(@PathVariable Long id, @RequestBody @Valid News dailyWorkSchedule) throws NewsNotFoundException {
    	News result = null;
        try {
            result = newsService.update(id, dailyWorkSchedule);
        } catch (Exception e) {
            throw new NewsNotFoundException("Newso não Existe", e);
        }
        return result;
    }

    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable Long id) throws NewsNotFoundException {
        try {
            newsService.delete(id);
        } catch (Exception e) {
			throw new NewsNotFoundException("Newso não Existe", e);
        }
    }
}
