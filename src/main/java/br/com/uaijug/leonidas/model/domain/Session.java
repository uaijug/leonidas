package br.com.uaijug.leonidas.model.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "session", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Session extends AbstractEntity {

	private static final long serialVersionUID = -3906621335187809294L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;
	
	private String description;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToMany
	@JoinTable(name = "session_speaker", joinColumns = {
			@JoinColumn(name = "session_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "speaker_id", nullable = false, updatable = false) })
	public Set<Speaker> speakers;

	@NotNull
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate;

	@NotNull
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "end_date")
	private Date endDate;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Set<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
