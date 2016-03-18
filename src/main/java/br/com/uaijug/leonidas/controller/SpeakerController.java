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

import br.com.uaijug.leonidas.model.domain.Speaker;
import br.com.uaijug.leonidas.model.service.SpeakerService;
import br.com.uaijug.leonidas.web.exception.SpeakerNotFoundException;

@RestController
@RequestMapping("/api/speakers")
public class SpeakerController extends AbstractRestController {
	
	@Autowired
	private SpeakerService speakerService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Speaker> list() {
		return speakerService.list();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Speaker findById(@PathVariable Long id) throws SpeakerNotFoundException {
		Speaker speaker = null;
		try {
			speaker = speakerService.findById(id);
		} catch (Exception e) {
			throw new SpeakerNotFoundException("Speakero não Existe", e);
		}

		return speaker;
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Speaker create(@RequestBody @Valid Speaker dailyWorkSchedule) {
		speakerService.save(dailyWorkSchedule);
		return dailyWorkSchedule;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Speaker update(@PathVariable Long id, @RequestBody @Valid Speaker speaker) throws SpeakerNotFoundException {
		Speaker result = null;
		try {
			result = speakerService.update(id, speaker);
		} catch (Exception e) {
			throw new SpeakerNotFoundException("Speakero não Existe", e);
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void delete(@PathVariable Long id) throws SpeakerNotFoundException {
		try {
			speakerService.delete(id);
		} catch (Exception e) {
			throw new SpeakerNotFoundException("Speakero não Existe", e);
		}
	}
}
