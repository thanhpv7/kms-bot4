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
import kmsweb.entities.BpjsDoctorScheduleEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsDoctorScheduleFactory implements FactoryBean<BpjsDoctorScheduleEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsDoctorScheduleEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsDoctorScheduleEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsDoctorScheduleEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleWithNoRef before the main body here] end

		BpjsDoctorScheduleEntity newEntity = new BpjsDoctorScheduleEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Hari here] off begin
		newEntity.setHari(mockNeat.ints().get());
		// % protected region % [Add customisation for Hari here] end
		// % protected region % [Add customisation for Nama Hari here] off begin
		String randomStringForNamaHari = mockNeat
				.strings()
				.get();
		newEntity.setNamaHari(randomStringForNamaHari);
		// % protected region % [Add customisation for Nama Hari here] end
		// % protected region % [Add customisation for Kapasitas here] off begin
		newEntity.setKapasitas(mockNeat.ints().get());
		// % protected region % [Add customisation for Kapasitas here] end
		// % protected region % [Add customisation for JKN Quota here] off begin
		newEntity.setJknQuota(mockNeat.ints().get());
		// % protected region % [Add customisation for JKN Quota here] end
		// % protected region % [Add customisation for JKN Non Quota here] off begin
		newEntity.setJknNonQuota(mockNeat.ints().get());
		// % protected region % [Add customisation for JKN Non Quota here] end
		// % protected region % [Add customisation for Interval here] off begin
		newEntity.setInterval(mockNeat.ints().get());
		// % protected region % [Add customisation for Interval here] end
		// % protected region % [Add customisation for Libur here] off begin
		newEntity.setLibur(mockNeat.bools().get());
		// % protected region % [Add customisation for Libur here] end
		// % protected region % [Add customisation for Jam Buka here] off begin
		String randomStringForJamBuka = mockNeat
				.strings()
				.get();
		newEntity.setJamBuka(randomStringForJamBuka);
		// % protected region % [Add customisation for Jam Buka here] end
		// % protected region % [Add customisation for Jam Tutup here] off begin
		String randomStringForJamTutup = mockNeat
				.strings()
				.get();
		newEntity.setJamTutup(randomStringForJamTutup);
		// % protected region % [Add customisation for Jam Tutup here] end
		// % protected region % [Add customisation for kodepoli here] off begin
		String randomStringForKodepoli = mockNeat
				.strings()
				.get();
		newEntity.setKodepoli(randomStringForKodepoli);
		// % protected region % [Add customisation for kodepoli here] end
		// % protected region % [Add customisation for namapoli here] off begin
		String randomStringForNamapoli = mockNeat
				.strings()
				.get();
		newEntity.setNamapoli(randomStringForNamapoli);
		// % protected region % [Add customisation for namapoli here] end
		// % protected region % [Add customisation for kodesubspesialis here] off begin
		String randomStringForKodesubspesialis = mockNeat
				.strings()
				.get();
		newEntity.setKodesubspesialis(randomStringForKodesubspesialis);
		// % protected region % [Add customisation for kodesubspesialis here] end
		// % protected region % [Add customisation for namasubspesialis here] off begin
		String randomStringForNamasubspesialis = mockNeat
				.strings()
				.get();
		newEntity.setNamasubspesialis(randomStringForNamasubspesialis);
		// % protected region % [Add customisation for namasubspesialis here] end
		// % protected region % [Add customisation for kodedokter here] off begin
		String randomStringForKodedokter = mockNeat
				.strings()
				.get();
		newEntity.setKodedokter(randomStringForKodedokter);
		// % protected region % [Add customisation for kodedokter here] end
		// % protected region % [Add customisation for namadokter here] off begin
		String randomStringForNamadokter = mockNeat
				.strings()
				.get();
		newEntity.setNamadokter(randomStringForNamadokter);
		// % protected region % [Add customisation for namadokter here] end

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsDoctorScheduleEntity> getObjectType() {
		return BpjsDoctorScheduleEntity.class;
	}
}