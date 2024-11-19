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
import kmsweb.entities.PcareMCUEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PcareMCUFactory implements FactoryBean<PcareMCUEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PcareMCUEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PcareMCUEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PcareMCUEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for pcareMCUWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUWithNoRef before the main body here] end

		PcareMCUEntity newEntity = new PcareMCUEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Kode MCU here] off begin
		String randomStringForKodeMCU = mockNeat
				.strings()
				.get();
		newEntity.setKodeMCU(randomStringForKodeMCU);
		// % protected region % [Add customisation for Kode MCU here] end
		// % protected region % [Add customisation for No Kunjungan here] off begin
		String randomStringForNoKunjungan = mockNeat
				.strings()
				.get();
		newEntity.setNoKunjungan(randomStringForNoKunjungan);
		// % protected region % [Add customisation for No Kunjungan here] end
		// % protected region % [Add customisation for Kode Provider here] off begin
		String randomStringForKodeProvider = mockNeat
				.strings()
				.get();
		newEntity.setKodeProvider(randomStringForKodeProvider);
		// % protected region % [Add customisation for Kode Provider here] end
		// % protected region % [Add customisation for Nama Provider here] off begin
		String randomStringForNamaProvider = mockNeat
				.strings()
				.get();
		newEntity.setNamaProvider(randomStringForNamaProvider);
		// % protected region % [Add customisation for Nama Provider here] end
		// % protected region % [Add customisation for Tanggal Pelayanan here] off begin
		String randomStringForTanggalPelayanan = mockNeat
				.strings()
				.get();
		newEntity.setTanggalPelayanan(randomStringForTanggalPelayanan);
		// % protected region % [Add customisation for Tanggal Pelayanan here] end
		// % protected region % [Add customisation for Sistole here] off begin
		String randomStringForSistole = mockNeat
				.strings()
				.get();
		newEntity.setSistole(randomStringForSistole);
		// % protected region % [Add customisation for Sistole here] end
		// % protected region % [Add customisation for Diastole here] off begin
		String randomStringForDiastole = mockNeat
				.strings()
				.get();
		newEntity.setDiastole(randomStringForDiastole);
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Radiologi Foto here] off begin
		String randomStringForRadiologiFoto = mockNeat
				.strings()
				.get();
		newEntity.setRadiologiFoto(randomStringForRadiologiFoto);
		// % protected region % [Add customisation for Radiologi Foto here] end
		// % protected region % [Add customisation for Hemoglobin here] off begin
		String randomStringForHemoglobin = mockNeat
				.strings()
				.get();
		newEntity.setHemoglobin(randomStringForHemoglobin);
		// % protected region % [Add customisation for Hemoglobin here] end
		// % protected region % [Add customisation for Leukosit here] off begin
		String randomStringForLeukosit = mockNeat
				.strings()
				.get();
		newEntity.setLeukosit(randomStringForLeukosit);
		// % protected region % [Add customisation for Leukosit here] end
		// % protected region % [Add customisation for Eritrosit here] off begin
		String randomStringForEritrosit = mockNeat
				.strings()
				.get();
		newEntity.setEritrosit(randomStringForEritrosit);
		// % protected region % [Add customisation for Eritrosit here] end
		// % protected region % [Add customisation for Laju Endap Darah here] off begin
		String randomStringForLajuEndapDarah = mockNeat
				.strings()
				.get();
		newEntity.setLajuEndapDarah(randomStringForLajuEndapDarah);
		// % protected region % [Add customisation for Laju Endap Darah here] end
		// % protected region % [Add customisation for Hematokrit here] off begin
		String randomStringForHematokrit = mockNeat
				.strings()
				.get();
		newEntity.setHematokrit(randomStringForHematokrit);
		// % protected region % [Add customisation for Hematokrit here] end
		// % protected region % [Add customisation for Trombosit here] off begin
		String randomStringForTrombosit = mockNeat
				.strings()
				.get();
		newEntity.setTrombosit(randomStringForTrombosit);
		// % protected region % [Add customisation for Trombosit here] end
		// % protected region % [Add customisation for HDL here] off begin
		String randomStringForHdl = mockNeat
				.strings()
				.get();
		newEntity.setHdl(randomStringForHdl);
		// % protected region % [Add customisation for HDL here] end
		// % protected region % [Add customisation for LDL here] off begin
		String randomStringForLdl = mockNeat
				.strings()
				.get();
		newEntity.setLdl(randomStringForLdl);
		// % protected region % [Add customisation for LDL here] end
		// % protected region % [Add customisation for Cholesterol here] off begin
		String randomStringForCholesterol = mockNeat
				.strings()
				.get();
		newEntity.setCholesterol(randomStringForCholesterol);
		// % protected region % [Add customisation for Cholesterol here] end
		// % protected region % [Add customisation for Trigliserida here] off begin
		String randomStringForTrigliserida = mockNeat
				.strings()
				.get();
		newEntity.setTrigliserida(randomStringForTrigliserida);
		// % protected region % [Add customisation for Trigliserida here] end
		// % protected region % [Add customisation for Sewaktu here] off begin
		String randomStringForSewaktu = mockNeat
				.strings()
				.get();
		newEntity.setSewaktu(randomStringForSewaktu);
		// % protected region % [Add customisation for Sewaktu here] end
		// % protected region % [Add customisation for Puasa here] off begin
		String randomStringForPuasa = mockNeat
				.strings()
				.get();
		newEntity.setPuasa(randomStringForPuasa);
		// % protected region % [Add customisation for Puasa here] end
		// % protected region % [Add customisation for Post Prandial here] off begin
		String randomStringForPostPrandial = mockNeat
				.strings()
				.get();
		newEntity.setPostPrandial(randomStringForPostPrandial);
		// % protected region % [Add customisation for Post Prandial here] end
		// % protected region % [Add customisation for HbA1c here] off begin
		String randomStringForHba1c = mockNeat
				.strings()
				.get();
		newEntity.setHba1c(randomStringForHba1c);
		// % protected region % [Add customisation for HbA1c here] end
		// % protected region % [Add customisation for SGOT here] off begin
		String randomStringForSgot = mockNeat
				.strings()
				.get();
		newEntity.setSgot(randomStringForSgot);
		// % protected region % [Add customisation for SGOT here] end
		// % protected region % [Add customisation for SGPT here] off begin
		String randomStringForSgpt = mockNeat
				.strings()
				.get();
		newEntity.setSgpt(randomStringForSgpt);
		// % protected region % [Add customisation for SGPT here] end
		// % protected region % [Add customisation for Gamma here] off begin
		String randomStringForGamma = mockNeat
				.strings()
				.get();
		newEntity.setGamma(randomStringForGamma);
		// % protected region % [Add customisation for Gamma here] end
		// % protected region % [Add customisation for Protein Kualitatif here] off begin
		String randomStringForProteinKualitatif = mockNeat
				.strings()
				.get();
		newEntity.setProteinKualitatif(randomStringForProteinKualitatif);
		// % protected region % [Add customisation for Protein Kualitatif here] end
		// % protected region % [Add customisation for Albumin here] off begin
		String randomStringForAlbumin = mockNeat
				.strings()
				.get();
		newEntity.setAlbumin(randomStringForAlbumin);
		// % protected region % [Add customisation for Albumin here] end
		// % protected region % [Add customisation for Creatinine here] off begin
		String randomStringForCreatinine = mockNeat
				.strings()
				.get();
		newEntity.setCreatinine(randomStringForCreatinine);
		// % protected region % [Add customisation for Creatinine here] end
		// % protected region % [Add customisation for Ureum here] off begin
		String randomStringForUreum = mockNeat
				.strings()
				.get();
		newEntity.setUreum(randomStringForUreum);
		// % protected region % [Add customisation for Ureum here] end
		// % protected region % [Add customisation for Asam here] off begin
		String randomStringForAsam = mockNeat
				.strings()
				.get();
		newEntity.setAsam(randomStringForAsam);
		// % protected region % [Add customisation for Asam here] end
		// % protected region % [Add customisation for ABI here] off begin
		String randomStringForAbi = mockNeat
				.strings()
				.get();
		newEntity.setAbi(randomStringForAbi);
		// % protected region % [Add customisation for ABI here] end
		// % protected region % [Add customisation for EKG here] off begin
		String randomStringForEkg = mockNeat
				.strings()
				.get();
		newEntity.setEkg(randomStringForEkg);
		// % protected region % [Add customisation for EKG here] end
		// % protected region % [Add customisation for Echo here] off begin
		String randomStringForEcho = mockNeat
				.strings()
				.get();
		newEntity.setEcho(randomStringForEcho);
		// % protected region % [Add customisation for Echo here] end
		// % protected region % [Add customisation for Funduskopi here] off begin
		String randomStringForFunduskopi = mockNeat
				.strings()
				.get();
		newEntity.setFunduskopi(randomStringForFunduskopi);
		// % protected region % [Add customisation for Funduskopi here] end
		// % protected region % [Add customisation for Pemeriksaan Lain here] off begin
		String randomStringForPemeriksaanLain = mockNeat
				.strings()
				.get();
		newEntity.setPemeriksaanLain(randomStringForPemeriksaanLain);
		// % protected region % [Add customisation for Pemeriksaan Lain here] end
		// % protected region % [Add customisation for Keterangan here] off begin
		String randomStringForKeterangan = mockNeat
				.strings()
				.get();
		newEntity.setKeterangan(randomStringForKeterangan);
		// % protected region % [Add customisation for Keterangan here] end

		// % protected region % [Apply any additional logic for pcareMCUWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<PcareMCUEntity> getObjectType() {
		return PcareMCUEntity.class;
	}
}