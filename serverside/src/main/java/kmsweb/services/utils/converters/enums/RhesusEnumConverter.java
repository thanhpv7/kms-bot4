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
package kmsweb.services.utils.converters.enums;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import kmsweb.entities.enums.RhesusEnum;
import com.opencsv.bean.AbstractBeanField;

public class RhesusEnumConverter extends AbstractBeanField<RhesusEnum, RhesusEnum>{

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException {
        RhesusEnum rhesusEnum;

		if (value == null || value.matches("")) {
            return null;
        }

        try {
            rhesusEnum = RhesusEnum.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new CsvDataTypeMismatchException(value + " is not a valid value for RhesusEnum.  Use one of the following instead: \n" +
					"	POSITIVE, NEGATIVE");
        }
        return rhesusEnum;
    }
}