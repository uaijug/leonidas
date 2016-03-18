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

import br.com.uaijug.leonidas.model.domain.Room;
import br.com.uaijug.leonidas.model.service.RoomService;
import br.com.uaijug.leonidas.web.exception.RoomNotFoundException;

@RestController
@RequestMapping("/api/rooms")
public class RoomController extends AbstractRestController {
	@Autowired
	private RoomService roomService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Room> list() {
		return roomService.list();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Room findById(@PathVariable Long id) throws RoomNotFoundException {
		Room room = null;
		try {
			room = roomService.findById(id);
		} catch (Exception e) {
			throw new RoomNotFoundException("Roomo não Existe", e);
		}

		return room;
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Room create(@RequestBody @Valid Room dailyWorkSchedule) {
		roomService.save(dailyWorkSchedule);
		return dailyWorkSchedule;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Room update(@PathVariable Long id, @RequestBody @Valid Room room) throws RoomNotFoundException {
		Room result = null;
		try {
			result = roomService.update(id, room);
		} catch (Exception e) {
			throw new RoomNotFoundException("Roomo não Existe", e);
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void delete(@PathVariable Long id) throws RoomNotFoundException {
		try {
			roomService.delete(id);
		} catch (Exception e) {
			throw new RoomNotFoundException("Roomo não Existe", e);
		}
	}
}
