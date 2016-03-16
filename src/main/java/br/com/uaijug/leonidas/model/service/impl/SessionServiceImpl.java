package br.com.uaijug.leonidas.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.uaijug.leonidas.model.domain.Session;
import br.com.uaijug.leonidas.model.repositories.SessionRepository;
import br.com.uaijug.leonidas.model.service.SessionService;

public class SessionServiceImpl implements SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;

	@Override
	public Session save(Session session) {
		return sessionRepository.save(session);
	}

	@Override
	public List<Session> list() {
		return sessionRepository.findAll();
	}

	@Override
	public Session findById(Long id) {
		return sessionRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		sessionRepository.delete(id);
	}

	@Override
	public Session create(Session e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session update(Long id, Session e) {
		// TODO Auto-generated method stub
		return null;
	}

}
