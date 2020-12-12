/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> MyLocalDateTimeConverter.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 6 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 */
package com.papeleria.del.istmo.mowin.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> MyLocalDateTimeConverter.java
 * <br><b>Description:</b> 
 *
 * @author Herwin Toral Rios
 * @company Inssoft
 * @created 6 feb. 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 feb. 2020 Herwin: Creacion de la clase
 *
 * @category 
 *
 **/
@Converter(autoApply = true)
public class MyLocalDateTimeConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp>{

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		if(attribute == null)
			return null;
		else
			return java.sql.Timestamp.valueOf(attribute);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		if(dbData == null)
			return null;
		else
			return dbData.toLocalDateTime();
	}

}
