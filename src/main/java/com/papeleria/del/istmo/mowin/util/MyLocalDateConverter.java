/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> MyLocalDateConverter.java
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

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> helpdesk
 * <br><b>Class:</b> MyLocalDateConverter.java
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
public class MyLocalDateConverter implements AttributeConverter<java.time.LocalDate, java.sql.Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		if (attribute == null)
			return null;
		else
			return java.sql.Date.valueOf(attribute);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		if(dbData == null)
			return null;
		else
			return dbData.toLocalDate();
	}

}
