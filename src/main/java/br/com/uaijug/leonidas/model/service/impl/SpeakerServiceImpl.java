package br.com.uaijug.leonidas.model.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uaijug.leonidas.model.domain.Speaker;
import br.com.uaijug.leonidas.model.repositories.SpeakerRepository;
import br.com.uaijug.leonidas.model.service.SpeakerService;

@Service
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	private SpeakerRepository speakerRepository;

	@Override
	@Transactional
	public Speaker create(Speaker speaker) {
		return speakerRepository.save(speaker);
	}
	
	@Override
	public Speaker save(Speaker city) {
		city.setCreateBy("sistema@geden.com.br");
		city.setCreatedDate(new Date());
		return create(city);
	}
	
	@Override
	public Speaker update(Long id, Speaker speaker) {
		Speaker result = loadSpeaker(id);
		/*result.setCity(speaker.getCity());
		result.setName(speaker.getName());
		result.setNumber(speaker.getNumber());
 		result.setLastModifiedBy("sistema@geden.com.br");
		result.setLastModifiedDate(new Date());*/
		return create(result);
	}

	@Override
	public void delete(Long id) {
		speakerRepository.delete(id);
	}
	
	@Transactional
	public Speaker loadSpeaker(Long id) {
		Speaker result = speakerRepository.findOne(id);
	
		if (result == null) {
			throw new EntityNotFoundException("Setor não encontrada");
		}
		
		return result;
	}

	@Override
	public List<Speaker> list() {
		return speakerRepository.findAll();
	}

	@Override
	public Speaker findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
