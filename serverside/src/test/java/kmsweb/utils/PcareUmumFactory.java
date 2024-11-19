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
import kmsweb.entities.PcareUmumEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PcareUmumFactory implements FactoryBean<PcareUmumEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PcareUmumEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PcareUmumEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PcareUmumEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for pcareUmumWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumWithNoRef before the main body here] end

		PcareUmumEntity newEntity = new PcareUmumEntity();
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
		// % protected region % [Add customisation for Web Service URL here] off begin
		String randomStringForWebServiceURL = mockNeat
				.strings()
				.get();
		newEntity.setWebServiceURL(randomStringForWebServiceURL);
		// % protected region % [Add customisation for Web Service URL here] end
		// % protected region % [Add customisation for Auth Username here] off begin
		String randomStringForAuthUsername = mockNeat
				.strings()
				.get();
		newEntity.setAuthUsername(randomStringForAuthUsername);
		// % protected region % [Add customisation for Auth Username here] end
		// % protected region % [Add customisation for Auth Password here] off begin
		String randomStringForAuthPassword = mockNeat
				.strings()
				.get();
		newEntity.setAuthPassword(randomStringForAuthPassword);
		// % protected region % [Add customisation for Auth Password here] end
		// % protected region % [Add customisation for Kode Aplikasi here] off begin
		String randomStringForKodeAplikasi = mockNeat
				.strings()
				.get();
		newEntity.setKodeAplikasi(randomStringForKodeAplikasi);
		// % protected region % [Add customisation for Kode Aplikasi here] end
		// % protected region % [Add customisation for User Key here] off begin
		String randomStringForUserKey = mockNeat
				.strings()
				.get();
		newEntity.setUserKey(randomStringForUserKey);
		// % protected region % [Add customisation for User Key here] end
		// % protected region % [Add customisation for Regional Division here] off begin
		String randomStringForRegionalDivision = mockNeat
				.strings()
				.get();
		newEntity.setRegionalDivision(randomStringForRegionalDivision);
		// % protected region % [Add customisation for Regional Division here] end
		// % protected region % [Add customisation for Branch Office here] off begin
		String randomStringForBranchOffice = mockNeat
				.strings()
				.get();
		newEntity.setBranchOffice(randomStringForBranchOffice);
		// % protected region % [Add customisation for Branch Office here] end

		// % protected region % [Apply any additional logic for pcareUmumWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<PcareUmumEntity> getObjectType() {
		return PcareUmumEntity.class;
	}
}