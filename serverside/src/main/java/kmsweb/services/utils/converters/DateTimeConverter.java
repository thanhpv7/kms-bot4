/*
 * @bot-written
 *
 * WARNING AND NOTICE
 * Any access, download, storage, and/or use of this source code is subject to the terms and conditions of the
 * Full Software Licence as accepted by you before being granted access to this source code and other materials,
 * the terms of which can be accessed on the Codebots website at https://codebots.com/full-software-licence. Any
 * commercial use in contravention of the terms of the Full Software Licence may be pursued by Codebots through
 * licence termination and further legal action, and be required to indemnify Codebots for any loss or damage,
 * including interest and costs. You are deemed to have accepted the terms of the Full Software Licence on any
 * access, download, storage, and/or use of this source code.
 *
 * BOT WARNING
 * This file is bot-written.
 * Any changes out side of "protected regions" will be lost next time the bot makes any changes.
 */

package kmsweb.services.utils.converters;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.format.DateTimeParseException;
import java.time.OffsetDateTime;

public class DateTimeConverter extends AbstractBeanField<String, String> {

	@Override
    protected Object convert(String dateInput) throws CsvDataTypeMismatchException {
		if (dateInput == null || dateInput.matches("")) {
            return null;
		}

        // Will enter conditional if date was passed in without an offset for time zone
        // Statement inside conditional appends the offset of the current time zone
        if(!dateInput.matches(".*(\\+|-)\\d{2}(:?\\d{2})?$")){
            dateInput = dateInput.concat(OffsetDateTime.now().getOffset().toString());
        }

        OffsetDateTime dateTime = OffsetDateTime.now();
        try {
            dateTime = OffsetDateTime.parse(dateInput);
        } catch (DateTimeParseException e) {
            throw new CsvDataTypeMismatchException(dateInput + " must be in the format 'YYYY-MM-DDThh:mm:ss\u00B1hh:mm");
        }
        return dateTime;
    }
}