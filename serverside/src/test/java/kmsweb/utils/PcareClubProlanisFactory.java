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
import kmsweb.entities.PcareClubProlanisEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PcareClubProlanisFactory implements FactoryBean<PcareClubProlanisEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PcareClubProlanisEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PcareClubProlanisEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PcareClubProlanisEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for pcareClubProlanisWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisWithNoRef before the main body here] end

		PcareClubProlanisEntity newEntity = new PcareClubProlanisEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Club ID here] off begin
		String randomStringForClubID = mockNeat
				.strings()
				.get();
		newEntity.setClubID(randomStringForClubID);
		// % protected region % [Add customisation for Club ID here] end
		// % protected region % [Add customisation for Kode Program here] off begin
		String randomStringForKodeProgram = mockNeat
				.strings()
				.get();
		newEntity.setKodeProgram(randomStringForKodeProgram);
		// % protected region % [Add customisation for Kode Program here] end
		// % protected region % [Add customisation for Nama Program here] off begin
		String randomStringForNamaProgram = mockNeat
				.strings()
				.get();
		newEntity.setNamaProgram(randomStringForNamaProgram);
		// % protected region % [Add customisation for Nama Program here] end
		// % protected region % [Add customisation for Tanggal Mulai here] off begin
		String randomStringForTanggalMulai = mockNeat
				.strings()
				.get();
		newEntity.setTanggalMulai(randomStringForTanggalMulai);
		// % protected region % [Add customisation for Tanggal Mulai here] end
		// % protected region % [Add customisation for Tanggal Akhir here] off begin
		String randomStringForTanggalAkhir = mockNeat
				.strings()
				.get();
		newEntity.setTanggalAkhir(randomStringForTanggalAkhir);
		// % protected region % [Add customisation for Tanggal Akhir here] end
		// % protected region % [Add customisation for Alamat Club here] off begin
		String randomStringForAlamatClub = mockNeat
				.strings()
				.get();
		newEntity.setAlamatClub(randomStringForAlamatClub);
		// % protected region % [Add customisation for Alamat Club here] end
		// % protected region % [Add customisation for Nama Club here] off begin
		String randomStringForNamaClub = mockNeat
				.strings()
				.get();
		newEntity.setNamaClub(randomStringForNamaClub);
		// % protected region % [Add customisation for Nama Club here] end
		// % protected region % [Add customisation for No HP Ketua here] off begin
		String randomStringForNoHPKetua = mockNeat
				.strings()
				.get();
		newEntity.setNoHPKetua(randomStringForNoHPKetua);
		// % protected region % [Add customisation for No HP Ketua here] end
		// % protected region % [Add customisation for Nama Ketua here] off begin
		String randomStringForNamaKetua = mockNeat
				.strings()
				.get();
		newEntity.setNamaKetua(randomStringForNamaKetua);
		// % protected region % [Add customisation for Nama Ketua here] end

		// % protected region % [Apply any additional logic for pcareClubProlanisWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<PcareClubProlanisEntity> getObjectType() {
		return PcareClubProlanisEntity.class;
	}
}