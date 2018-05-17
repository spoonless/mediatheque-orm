package com.cgi.poei.mediatheque.db;

import java.time.Year;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class YearAttributeConverter implements AttributeConverter<Year, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Year attribute) {
		return attribute == null ? null : attribute.getValue();
	}

	@Override
	public Year convertToEntityAttribute(Integer dbYear) {
		return dbYear == null ? null : Year.of(dbYear);
	}

}

