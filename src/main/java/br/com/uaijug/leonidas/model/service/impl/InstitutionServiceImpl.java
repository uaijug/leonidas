package br.com.uaijug.leonidas.model.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uaijug.leonidas.model.domain.Institution;
import br.com.uaijug.leonidas.model.repositories.InstitutionRepository;
import br.com.uaijug.leonidas.model.service.InstitutionService;

@Service
public class InstitutionServiceImpl implements InstitutionService {

	@Autowired
	private InstitutionRepository institutionRepository;

	@Override
	@Transactional
	public Institution create(Institution institution) {
		return institutionRepository.save(institution);
	}
	
	@Override
	public Institution save(Institution institution) {
		institution.setCreateBy("sistema@geden.com.br");
		institution.setCreatedDate(new Date());
		return create(institution);
	}
	
	@Override
	public Institution update(Long id, Institution institution) {
		Institution result = loadInstitution(id);
		/*result.setState(institution.getState());
		result.setName(institution.getName());
		result.setAcronym(institution.getAcronym());
		result.setLastModifiedBy("sistema@geden.com.br");
		result.setLastModifiedDate(new Date());*/
		return create(result);
	}
	
	@Override
	public List<Institution> list() {
		return institutionRepository.findAll();
	}

	@Override
	public Institution findById(Long id) {
		return institutionRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		institutionRepository.delete(id);
	}
	
	@Transactional
	public Institution loadInstitution(Long id) {
		Institution result = institutionRepository.findOne(id);
	
		if (result == null) {
			throw new EntityNotFoundException("Cidade não encontrada");
		}
		
		return result;
	}
	
}
