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
import kmsweb.entities.BpjsBedAvailabilityEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsBedAvailabilityFactory implements FactoryBean<BpjsBedAvailabilityEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsBedAvailabilityEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsBedAvailabilityEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsBedAvailabilityEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityWithNoRef before the main body here] end

		BpjsBedAvailabilityEntity newEntity = new BpjsBedAvailabilityEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for koderuang here] off begin
		String randomStringForKoderuang = mockNeat
				.strings()
				.get();
		newEntity.setKoderuang(randomStringForKoderuang);
		// % protected region % [Add customisation for koderuang here] end
		// % protected region % [Add customisation for namaruang here] off begin
		String randomStringForNamaruang = mockNeat
				.strings()
				.get();
		newEntity.setNamaruang(randomStringForNamaruang);
		// % protected region % [Add customisation for namaruang here] end
		// % protected region % [Add customisation for kodekelas here] off begin
		String randomStringForKodekelas = mockNeat
				.strings()
				.get();
		newEntity.setKodekelas(randomStringForKodekelas);
		// % protected region % [Add customisation for kodekelas here] end
		// % protected region % [Add customisation for namakelas here] off begin
		String randomStringForNamakelas = mockNeat
				.strings()
				.get();
		newEntity.setNamakelas(randomStringForNamakelas);
		// % protected region % [Add customisation for namakelas here] end
		// % protected region % [Add customisation for lastupdate here] off begin
		String randomStringForLastupdate = mockNeat
				.strings()
				.get();
		newEntity.setLastupdate(randomStringForLastupdate);
		// % protected region % [Add customisation for lastupdate here] end
		// % protected region % [Add customisation for kapasitas here] off begin
		newEntity.setKapasitas(mockNeat.ints().get());
		// % protected region % [Add customisation for kapasitas here] end
		// % protected region % [Add customisation for tersedia here] off begin
		newEntity.setTersedia(mockNeat.ints().get());
		// % protected region % [Add customisation for tersedia here] end
		// % protected region % [Add customisation for tersediapria here] off begin
		newEntity.setTersediapria(mockNeat.ints().get());
		// % protected region % [Add customisation for tersediapria here] end
		// % protected region % [Add customisation for tersediawanita here] off begin
		newEntity.setTersediawanita(mockNeat.ints().get());
		// % protected region % [Add customisation for tersediawanita here] end
		// % protected region % [Add customisation for tersediapriawanita here] off begin
		newEntity.setTersediapriawanita(mockNeat.ints().get());
		// % protected region % [Add customisation for tersediapriawanita here] end

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsBedAvailabilityEntity> getObjectType() {
		return BpjsBedAvailabilityEntity.class;
	}
}