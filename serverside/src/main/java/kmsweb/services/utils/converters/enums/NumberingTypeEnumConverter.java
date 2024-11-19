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
import kmsweb.entities.enums.NumberingTypeEnum;
import com.opencsv.bean.AbstractBeanField;

public class NumberingTypeEnumConverter extends AbstractBeanField<NumberingTypeEnum, NumberingTypeEnum>{

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException {
        NumberingTypeEnum numberingTypeEnum;

		if (value == null || value.matches("")) {
            return null;
        }

        try {
            numberingTypeEnum = NumberingTypeEnum.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new CsvDataTypeMismatchException(value + " is not a valid value for NumberingTypeEnum.  Use one of the following instead: \n" +
					"	PRESCRIPTION_NON_COMPOUND, PRESCRIPTION_COMPOUND, REVISED_PRESCRIPTION_NON_COMPOUND, REVISED_PRESCRIPTION_COMPOUND, PRESCRIPTION_QUEUE, PATIENT_ID_GENERAL, PATIENT_ID_EXTERNAL, PATIENT_ID_UNKNOWN, INVOICE_OUTPATIENT, INVOICE_INPATIENT, PAYMENT, DOWN_PAYMENT, REFUND, REGISTRATION_ID, GENERAL_NUMBER, INVENTORY_ADJUSTMENT, INVENTORY_TRANSFER_ORDER, INVENTORY_INTERNAL_ORDER, INVENTORY_STOCK_ISSUANCE, INVENTORY_STOCK_RECEIVING, INVENTORY_BATCH_CORRECTION, PURCHASE_REQUISITION, PURCHASE_ORDER, PURCHASE_GOOD_RECEIVE_NOTES, PURCHASE_RETURN_SUPPLIER, JOURNAL_NUMBER, BPJS_INACBG_CLAIM");
        }
        return numberingTypeEnum;
    }
}