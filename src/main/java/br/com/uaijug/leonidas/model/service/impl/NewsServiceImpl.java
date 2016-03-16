package br.com.uaijug.leonidas.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uaijug.leonidas.model.domain.News;
import br.com.uaijug.leonidas.model.repositories.NewsRepository;
import br.com.uaijug.leonidas.model.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsRepository newsRepository;

	@Override
	public News save(News news) {
		News saved = newsRepository.save(news);
		return saved;
	}

	@Override
	public List<News> list() {
		return newsRepository.findAll();
	}

	@Override
	public News findById(Long id) {
		return newsRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		newsRepository.delete(id);
	}

	@Override
	public News update(Long id, News e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public News create(News e) {
		// TODO Auto-generated method stub
		return null;
	}
}
