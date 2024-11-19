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
import kmsweb.entities.BpjsGeneralEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsGeneralFactory implements FactoryBean<BpjsGeneralEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsGeneralEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsGeneralEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsGeneralEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsGeneralWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralWithNoRef before the main body here] end

		BpjsGeneralEntity newEntity = new BpjsGeneralEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Cons ID here] off begin
		String randomStringForConsID = mockNeat
				.strings()
				.size(15)
				.get();
		newEntity.setConsID(randomStringForConsID);
		// % protected region % [Add customisation for Cons ID here] end
		// % protected region % [Add customisation for Secret Key here] off begin
		String randomStringForSecretKey = mockNeat
				.strings()
				.size(25)
				.get();
		newEntity.setSecretKey(randomStringForSecretKey);
		// % protected region % [Add customisation for Secret Key here] end
		// % protected region % [Add customisation for BPJS Web Service URL here] off begin
		String randomStringForBpjsWebServiceURL = mockNeat
				.strings()
				.get();
		newEntity.setBpjsWebServiceURL(randomStringForBpjsWebServiceURL);
		// % protected region % [Add customisation for BPJS Web Service URL here] end
		// % protected region % [Add customisation for Aplicare Web Service URL here] off begin
		String randomStringForAplicareWebServiceURL = mockNeat
				.strings()
				.get();
		newEntity.setAplicareWebServiceURL(randomStringForAplicareWebServiceURL);
		// % protected region % [Add customisation for Aplicare Web Service URL here] end
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
		// % protected region % [Add customisation for MJKN WS BPJS URL here] off begin
		String randomStringForMjknWSBPJSURL = mockNeat
				.strings()
				.get();
		newEntity.setMjknWSBPJSURL(randomStringForMjknWSBPJSURL);
		// % protected region % [Add customisation for MJKN WS BPJS URL here] end
		// % protected region % [Add customisation for MJKN WS BPJS User Key here] off begin
		String randomStringForMjknWSBPJSUserKey = mockNeat
				.strings()
				.get();
		newEntity.setMjknWSBPJSUserKey(randomStringForMjknWSBPJSUserKey);
		// % protected region % [Add customisation for MJKN WS BPJS User Key here] end
		// % protected region % [Add customisation for Vclaim User Key here] off begin
		String randomStringForVclaimUserKey = mockNeat
				.strings()
				.get();
		newEntity.setVclaimUserKey(randomStringForVclaimUserKey);
		// % protected region % [Add customisation for Vclaim User Key here] end
		// % protected region % [Add customisation for Connect To Other System here] off begin
		newEntity.setConnectToOtherSystem(mockNeat.bools().get());
		// % protected region % [Add customisation for Connect To Other System here] end
		// % protected region % [Add customisation for IsMobileJKN here] off begin
		newEntity.setIsmobilejkn(mockNeat.bools().get());
		// % protected region % [Add customisation for IsMobileJKN here] end
		// % protected region % [Add customisation for External System URL here] off begin
		String randomStringForExternalSystemURL = mockNeat
				.strings()
				.get();
		newEntity.setExternalSystemURL(randomStringForExternalSystemURL);
		// % protected region % [Add customisation for External System URL here] end
		// % protected region % [Add customisation for Basic Auth here] off begin
		newEntity.setBasicAuth(mockNeat.bools().get());
		// % protected region % [Add customisation for Basic Auth here] end
		// % protected region % [Add customisation for Basic Auth Username here] off begin
		String randomStringForBasicAuthUsername = mockNeat
				.strings()
				.get();
		newEntity.setBasicAuthUsername(randomStringForBasicAuthUsername);
		// % protected region % [Add customisation for Basic Auth Username here] end
		// % protected region % [Add customisation for Basic Auth Password here] off begin
		String randomStringForBasicAuthPassword = mockNeat
				.strings()
				.get();
		newEntity.setBasicAuthPassword(randomStringForBasicAuthPassword);
		// % protected region % [Add customisation for Basic Auth Password here] end
		// % protected region % [Add customisation for Bypass SSL Validation here] off begin
		newEntity.setBypassSSLValidation(mockNeat.bools().get());
		// % protected region % [Add customisation for Bypass SSL Validation here] end
		// % protected region % [Add customisation for Claim Status here] off begin
		newEntity.setClaimStatus(mockNeat.bools().get());
		// % protected region % [Add customisation for Claim Status here] end
		// % protected region % [Add customisation for Facility Type here] off begin
		String randomStringForFacilityType = mockNeat
				.strings()
				.get();
		newEntity.setFacilityType(randomStringForFacilityType);
		// % protected region % [Add customisation for Facility Type here] end
		// % protected region % [Add customisation for Send Non JKN here] off begin
		newEntity.setSendNonJKN(mockNeat.bools().get());
		// % protected region % [Add customisation for Send Non JKN here] end
		// % protected region % [Add customisation for Vclaim Integration here] off begin
		newEntity.setVclaimIntegration(mockNeat.bools().get());
		// % protected region % [Add customisation for Vclaim Integration here] end
		// % protected region % [Add customisation for External Vclaim Service URL here] off begin
		String randomStringForExternalVclaimServiceURL = mockNeat
				.strings()
				.get();
		newEntity.setExternalVclaimServiceURL(randomStringForExternalVclaimServiceURL);
		// % protected region % [Add customisation for External Vclaim Service URL here] end

		// % protected region % [Apply any additional logic for bpjsGeneralWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsGeneralEntity> getObjectType() {
		return BpjsGeneralEntity.class;
	}
}