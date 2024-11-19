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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.SupplierBankAccountEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class SupplierBankAccountFactory implements FactoryBean<SupplierBankAccountEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public SupplierBankAccountEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public SupplierBankAccountEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public SupplierBankAccountEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for supplierBankAccountWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountWithNoRef before the main body here] end

		SupplierBankAccountEntity newEntity = new SupplierBankAccountEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Bank Name here] off begin
		String randomStringForBankName = mockNeat
				.strings()
				.get();
		newEntity.setBankName(randomStringForBankName);
		// % protected region % [Add customisation for Bank Name here] end
		// % protected region % [Add customisation for Account Name here] off begin
		String randomStringForAccountName = mockNeat
				.strings()
				.get();
		newEntity.setAccountName(randomStringForAccountName);
		// % protected region % [Add customisation for Account Name here] end
		// % protected region % [Add customisation for Account Number here] off begin
		String randomStringForAccountNumber = mockNeat
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setAccountNumber(randomStringForAccountNumber);
		// % protected region % [Add customisation for Account Number here] end
		// % protected region % [Add customisation for City here] off begin
		String randomStringForCity = mockNeat
				.strings()
				.get();
		newEntity.setCity(randomStringForCity);
		// % protected region % [Add customisation for City here] end
		// % protected region % [Add customisation for Branch here] off begin
		String randomStringForBranch = mockNeat
				.strings()
				.get();
		newEntity.setBranch(randomStringForBranch);
		// % protected region % [Add customisation for Branch here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for supplierBankAccountWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManySupplier here] off begin
			var supplierFactory = new SupplierFactory();
			newEntity.setSupplier(supplierFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManySupplier here] end

		}

		// % protected region % [Apply any additional logic for supplierBankAccount with ref here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccount with ref here] end

		return newEntity;
	}

	@Override
	public Class<SupplierBankAccountEntity> getObjectType() {
		return SupplierBankAccountEntity.class;
	}
}