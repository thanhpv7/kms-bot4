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
import kmsweb.entities.BpjsINACBGEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsINACBGFactory implements FactoryBean<BpjsINACBGEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsINACBGEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsINACBGEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsINACBGEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsINACBGWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGWithNoRef before the main body here] end

		BpjsINACBGEntity newEntity = new BpjsINACBGEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Health Facility Code here] off begin
		String randomStringForHealthFacilityCode = mockNeat
				.strings()
				.size(25)
				.get();
		newEntity.setHealthFacilityCode(randomStringForHealthFacilityCode);
		// % protected region % [Add customisation for Health Facility Code here] end
		// % protected region % [Add customisation for Health Facility Name here] off begin
		String randomStringForHealthFacilityName = mockNeat
				.strings()
				.size(100)
				.get();
		newEntity.setHealthFacilityName(randomStringForHealthFacilityName);
		// % protected region % [Add customisation for Health Facility Name here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringForAddress = mockNeat
				.strings()
				.get();
		newEntity.setAddress(randomStringForAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for State Province here] off begin
		String randomStringForStateProvince = mockNeat
				.strings()
				.size(50)
				.get();
		newEntity.setStateProvince(randomStringForStateProvince);
		// % protected region % [Add customisation for State Province here] end
		// % protected region % [Add customisation for City Regency here] off begin
		String randomStringForCityRegency = mockNeat
				.strings()
				.size(50)
				.get();
		newEntity.setCityRegency(randomStringForCityRegency);
		// % protected region % [Add customisation for City Regency here] end
		// % protected region % [Add customisation for Regional here] off begin
		String randomStringForRegional = mockNeat
				.strings()
				.size(50)
				.get();
		newEntity.setRegional(randomStringForRegional);
		// % protected region % [Add customisation for Regional here] end
		// % protected region % [Add customisation for Hospital Class here] off begin
		String randomStringForHospitalClass = mockNeat
				.strings()
				.size(25)
				.get();
		newEntity.setHospitalClass(randomStringForHospitalClass);
		// % protected region % [Add customisation for Hospital Class here] end
		// % protected region % [Add customisation for INACBG Tariff 1 here] off begin
		String randomStringForInacbgTariff1 = mockNeat
				.strings()
				.size(100)
				.get();
		newEntity.setInacbgTariff1(randomStringForInacbgTariff1);
		// % protected region % [Add customisation for INACBG Tariff 1 here] end
		// % protected region % [Add customisation for INACBG Tariff 2 here] off begin
		String randomStringForInacbgTariff2 = mockNeat
				.strings()
				.size(100)
				.get();
		newEntity.setInacbgTariff2(randomStringForInacbgTariff2);
		// % protected region % [Add customisation for INACBG Tariff 2 here] end
		// % protected region % [Add customisation for Additional Upgrade VIP here] off begin
		String randomStringForAdditionalUpgradeVIP = mockNeat
				.strings()
				.size(100)
				.get();
		newEntity.setAdditionalUpgradeVIP(randomStringForAdditionalUpgradeVIP);
		// % protected region % [Add customisation for Additional Upgrade VIP here] end
		// % protected region % [Add customisation for Payplan ID here] off begin
		String randomStringForPayplanID = mockNeat
				.strings()
				.size(100)
				.get();
		newEntity.setPayplanID(randomStringForPayplanID);
		// % protected region % [Add customisation for Payplan ID here] end
		// % protected region % [Add customisation for Payment Plan Code here] off begin
		String randomStringForPaymentPlanCode = mockNeat
				.strings()
				.size(100)
				.get();
		newEntity.setPaymentPlanCode(randomStringForPaymentPlanCode);
		// % protected region % [Add customisation for Payment Plan Code here] end
		// % protected region % [Add customisation for Tariff Code here] off begin
		String randomStringForTariffCode = mockNeat
				.strings()
				.size(50)
				.get();
		newEntity.setTariffCode(randomStringForTariffCode);
		// % protected region % [Add customisation for Tariff Code here] end
		// % protected region % [Add customisation for URL here] off begin
		String randomStringForUrl = mockNeat
				.strings()
				.get();
		newEntity.setUrl(randomStringForUrl);
		// % protected region % [Add customisation for URL here] end
		// % protected region % [Add customisation for Username here] off begin
		String randomStringForUsername = mockNeat
				.strings()
				.size(100)
				.get();
		newEntity.setUsername(randomStringForUsername);
		// % protected region % [Add customisation for Username here] end
		// % protected region % [Add customisation for Password here] off begin
		String randomStringForPassword = mockNeat
				.strings()
				.size(100)
				.get();
		newEntity.setPassword(randomStringForPassword);
		// % protected region % [Add customisation for Password here] end
		// % protected region % [Add customisation for Secret Key here] off begin
		String randomStringForSecretKey = mockNeat
				.strings()
				.size(225)
				.get();
		newEntity.setSecretKey(randomStringForSecretKey);
		// % protected region % [Add customisation for Secret Key here] end
		// % protected region % [Add customisation for Coder ID here] off begin
		String randomStringForCoderID = mockNeat
				.strings()
				.size(100)
				.get();
		newEntity.setCoderID(randomStringForCoderID);
		// % protected region % [Add customisation for Coder ID here] end

		// % protected region % [Apply any additional logic for bpjsINACBGWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsINACBGEntity> getObjectType() {
		return BpjsINACBGEntity.class;
	}
}