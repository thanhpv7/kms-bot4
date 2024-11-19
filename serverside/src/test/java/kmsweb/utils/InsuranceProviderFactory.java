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
import kmsweb.entities.InsuranceProviderEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InsuranceProviderFactory implements FactoryBean<InsuranceProviderEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InsuranceProviderEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InsuranceProviderEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InsuranceProviderEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for insuranceProviderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderWithNoRef before the main body here] end

		InsuranceProviderEntity newEntity = new InsuranceProviderEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Provider Code here] off begin
		String randomStringForProviderCode = mockNeat
				.strings()
				.get();
		newEntity.setProviderCode(randomStringForProviderCode);
		// % protected region % [Add customisation for Provider Code here] end
		// % protected region % [Add customisation for Provider Name here] off begin
		String randomStringForProviderName = mockNeat
				.strings()
				.get();
		newEntity.setProviderName(randomStringForProviderName);
		// % protected region % [Add customisation for Provider Name here] end
		// % protected region % [Add customisation for Provider Type here] off begin
		String randomStringForProviderType = mockNeat
				.strings()
				.get();
		newEntity.setProviderType(randomStringForProviderType);
		// % protected region % [Add customisation for Provider Type here] end
		// % protected region % [Add customisation for Benefit Provider here] off begin
		String randomStringForBenefitProvider = mockNeat
				.strings()
				.get();
		newEntity.setBenefitProvider(randomStringForBenefitProvider);
		// % protected region % [Add customisation for Benefit Provider here] end
		// % protected region % [Add customisation for First Name here] off begin
		String randomStringForFirstName = mockNeat
				.strings()
				.get();
		newEntity.setFirstName(randomStringForFirstName);
		// % protected region % [Add customisation for First Name here] end
		// % protected region % [Add customisation for Last Name here] off begin
		String randomStringForLastName = mockNeat
				.strings()
				.get();
		newEntity.setLastName(randomStringForLastName);
		// % protected region % [Add customisation for Last Name here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringForPhoneNumber = mockNeat
				.strings()
				.get();
		newEntity.setPhoneNumber(randomStringForPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Mobile Phone Number here] off begin
		String randomStringForMobilePhoneNumber = mockNeat
				.strings()
				.get();
		newEntity.setMobilePhoneNumber(randomStringForMobilePhoneNumber);
		// % protected region % [Add customisation for Mobile Phone Number here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringForEmail = mockNeat
				.strings()
				.get();
		newEntity.setEmail(randomStringForEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Expiry Date here] off begin
		newEntity.setExpiryDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiry Date here] end
		// % protected region % [Add customisation for Expiring Date here] off begin
		newEntity.setExpiringDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiring Date here] end
		// % protected region % [Add customisation for Created Date here] off begin
		newEntity.setCreatedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Created Date here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for insuranceProviderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany Insurance Benefit Plans here] off begin
			// Outgoing one to many reference
			var insuranceBenefitPlansFactory = new InsuranceBenefitPlanFactory();
			newEntity.setInsuranceBenefitPlans(Collections.singletonList(insuranceBenefitPlansFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Insurance Benefit Plans here] end

		}

		// % protected region % [Apply any additional logic for insuranceProvider with ref here] off begin
		// % protected region % [Apply any additional logic for insuranceProvider with ref here] end

		return newEntity;
	}

	@Override
	public Class<InsuranceProviderEntity> getObjectType() {
		return InsuranceProviderEntity.class;
	}
}