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
import kmsweb.entities.ChartOfAccountEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class ChartOfAccountFactory implements FactoryBean<ChartOfAccountEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public ChartOfAccountEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public ChartOfAccountEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public ChartOfAccountEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for chartOfAccountWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountWithNoRef before the main body here] end

		ChartOfAccountEntity newEntity = new ChartOfAccountEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Account Code here] off begin
		String randomStringForAccountCode = mockNeat
				.strings()
				.get();
		newEntity.setAccountCode(randomStringForAccountCode);
		// % protected region % [Add customisation for Account Code here] end
		// % protected region % [Add customisation for Account Name here] off begin
		String randomStringForAccountName = mockNeat
				.strings()
				.get();
		newEntity.setAccountName(randomStringForAccountName);
		// % protected region % [Add customisation for Account Name here] end
		// % protected region % [Add customisation for Account Type here] off begin
		String randomStringForAccountType = mockNeat
				.strings()
				.get();
		newEntity.setAccountType(randomStringForAccountType);
		// % protected region % [Add customisation for Account Type here] end
		// % protected region % [Add customisation for Tax Code here] off begin
		String randomStringForTaxCode = mockNeat
				.strings()
				.get();
		newEntity.setTaxCode(randomStringForTaxCode);
		// % protected region % [Add customisation for Tax Code here] end
		// % protected region % [Add customisation for Dashboard here] off begin
		newEntity.setDashboard(mockNeat.bools().get());
		// % protected region % [Add customisation for Dashboard here] end
		// % protected region % [Add customisation for Expense Claim here] off begin
		newEntity.setExpenseClaim(mockNeat.bools().get());
		// % protected region % [Add customisation for Expense Claim here] end
		// % protected region % [Add customisation for Enable Payment here] off begin
		newEntity.setEnablePayment(mockNeat.bools().get());
		// % protected region % [Add customisation for Enable Payment here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end

		// % protected region % [Apply any additional logic for chartOfAccountWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany Chart of Account Mappings here] off begin
			// Outgoing one to many reference
			var chartOfAccountMappingsFactory = new ChartOfAccountMappingFactory();
			newEntity.setChartOfAccountMappings(Collections.singletonList(chartOfAccountMappingsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Chart of Account Mappings here] end

		}

		// % protected region % [Apply any additional logic for chartOfAccount with ref here] off begin
		// % protected region % [Apply any additional logic for chartOfAccount with ref here] end

		return newEntity;
	}

	@Override
	public Class<ChartOfAccountEntity> getObjectType() {
		return ChartOfAccountEntity.class;
	}
}