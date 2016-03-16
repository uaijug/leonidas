package br.com.uaijug.leonidas.model.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uaijug.leonidas.model.domain.Room;
import br.com.uaijug.leonidas.model.repositories.RoomRepository;
import br.com.uaijug.leonidas.model.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository RoomRepository;

	@Override
	@Transactional
	public Room create(Room room) {
		return RoomRepository.save(room);
	}

	@Override
	public Room save(Room room) {
		room.setCreateBy("sistema@geden.com.br");
		room.setCreatedDate(new Date());
		return create(room);
	}

	@Override
	public Room update(Long id, Room Room) {
		Room result = loadRoom(id);
		/*result.setZone(Room.getZone());
		result.setName(Room.getName());
		result.setNumber(Room.getNumber());
		result.setLastModifiedBy("sistema@geden.com.br");
		result.setLastModifiedDate(new Date());*/
		return create(result);
	}

	@Override
	public List<Room> list() {
		return RoomRepository.findAll();
	}

	@Override
	public Room findById(Long id) {
		return RoomRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		RoomRepository.delete(id);
	}
	
	@Transactional
	public Room loadRoom(Long id) {
		Room result = RoomRepository.findOne(id);

		if (result == null) {
			throw new EntityNotFoundException("Zona não encontrada");
		}

		return result;
	}

}
