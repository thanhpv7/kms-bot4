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
import kmsweb.entities.JournalEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class JournalFactory implements FactoryBean<JournalEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public JournalEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public JournalEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public JournalEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for journalWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for journalWithNoRef before the main body here] end

		JournalEntity newEntity = new JournalEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Journal Number here] off begin
		String randomStringForJournalNumber = mockNeat
				.strings()
				.get();
		newEntity.setJournalNumber(randomStringForJournalNumber);
		// % protected region % [Add customisation for Journal Number here] end
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Reference Number here] off begin
		String randomStringForReferenceNumber = mockNeat
				.strings()
				.get();
		newEntity.setReferenceNumber(randomStringForReferenceNumber);
		// % protected region % [Add customisation for Reference Number here] end
		// % protected region % [Add customisation for Transaction Type here] off begin
		String randomStringForTransactionType = mockNeat
				.strings()
				.get();
		newEntity.setTransactionType(randomStringForTransactionType);
		// % protected region % [Add customisation for Transaction Type here] end
		// % protected region % [Add customisation for Transaction Detail Type here] off begin
		String randomStringForTransactionDetailType = mockNeat
				.strings()
				.get();
		newEntity.setTransactionDetailType(randomStringForTransactionDetailType);
		// % protected region % [Add customisation for Transaction Detail Type here] end
		// % protected region % [Add customisation for Account Number here] off begin
		String randomStringForAccountNumber = mockNeat
				.strings()
				.get();
		newEntity.setAccountNumber(randomStringForAccountNumber);
		// % protected region % [Add customisation for Account Number here] end
		// % protected region % [Add customisation for Debit here] off begin
		newEntity.setDebit(mockNeat.doubles().get());
		// % protected region % [Add customisation for Debit here] end
		// % protected region % [Add customisation for Credit here] off begin
		newEntity.setCredit(mockNeat.doubles().get());
		// % protected region % [Add customisation for Credit here] end
		// % protected region % [Add customisation for Posting Status here] off begin
		String randomStringForPostingStatus = mockNeat
				.strings()
				.get();
		newEntity.setPostingStatus(randomStringForPostingStatus);
		// % protected region % [Add customisation for Posting Status here] end
		// % protected region % [Add customisation for Posting Date Time here] off begin
		newEntity.setPostingDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Posting Date Time here] end
		// % protected region % [Add customisation for Supplier Number here] off begin
		String randomStringForSupplierNumber = mockNeat
				.strings()
				.get();
		newEntity.setSupplierNumber(randomStringForSupplierNumber);
		// % protected region % [Add customisation for Supplier Number here] end
		// % protected region % [Add customisation for Supplier Name here] off begin
		String randomStringForSupplierName = mockNeat
				.strings()
				.get();
		newEntity.setSupplierName(randomStringForSupplierName);
		// % protected region % [Add customisation for Supplier Name here] end
		// % protected region % [Add customisation for Customer Number here] off begin
		String randomStringForCustomerNumber = mockNeat
				.strings()
				.get();
		newEntity.setCustomerNumber(randomStringForCustomerNumber);
		// % protected region % [Add customisation for Customer Number here] end
		// % protected region % [Add customisation for Customer Name here] off begin
		String randomStringForCustomerName = mockNeat
				.strings()
				.get();
		newEntity.setCustomerName(randomStringForCustomerName);
		// % protected region % [Add customisation for Customer Name here] end
		// % protected region % [Add customisation for Revenue Center here] off begin
		String randomStringForRevenueCenter = mockNeat
				.strings()
				.get();
		newEntity.setRevenueCenter(randomStringForRevenueCenter);
		// % protected region % [Add customisation for Revenue Center here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end

		// % protected region % [Apply any additional logic for journalWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for journalWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<JournalEntity> getObjectType() {
		return JournalEntity.class;
	}
}