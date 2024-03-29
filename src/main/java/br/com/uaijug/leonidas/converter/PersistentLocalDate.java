package br.com.uaijug.leonidas.converter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Convert a {@link LocalDateTime} into database column representation as
 * {@link Date} and back again.
 * 
 * @author Rogério Fontes
 */
@Converter(autoApply = true)
public class PersistentLocalDate implements AttributeConverter<LocalDate, Date> {


	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		Instant instant = attribute.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		Instant instant = Instant.ofEpochMilli(dbData.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}

}
