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
package kmsweb.inject.modules.entities;

import kmsweb.entities.*;
import kmsweb.entities.enums.*;
import kmsweb.inject.factories.*;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

// % protected region % [Apply any additional imports here] off begin
// % protected region % [Apply any additional imports here] end

/**
 * Guice module for PCare MCU used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareMCUModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareMCUModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareMCUModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareMCUEntityFactory pcareMCUEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareMCUEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareMCUEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareMCUEntityFactory");

		// % protected region % [Apply any additional logic for pcareMCUEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUEntityFactory before the main body here] end

		PcareMCUEntityFactory entityFactory = new PcareMCUEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareMCUEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareMCUEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareMCUEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUEntityFactory after the main body here] end

		log.trace("Created PcareMCUEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare MCU entity with no references set.
	 */
	@Provides
	@Named("pcareMCUEntityWithNoRef")
	public PcareMCUEntity pcareMCUEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareMCUEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareMCUEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareMCUEntity with no reference");

		// % protected region % [Apply any additional logic for pcareMCUWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUWithNoRef before the main body here] end

		PcareMCUEntity newEntity = new PcareMCUEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Kode MCU here] off begin
		String randomStringforKodeMCU = mock
				.strings()
				.get();
		newEntity.setKodeMCU(randomStringforKodeMCU);
		// % protected region % [Add customisation for Kode MCU here] end
		// % protected region % [Add customisation for No Kunjungan here] off begin
		String randomStringforNoKunjungan = mock
				.strings()
				.get();
		newEntity.setNoKunjungan(randomStringforNoKunjungan);
		// % protected region % [Add customisation for No Kunjungan here] end
		// % protected region % [Add customisation for Kode Provider here] off begin
		String randomStringforKodeProvider = mock
				.strings()
				.get();
		newEntity.setKodeProvider(randomStringforKodeProvider);
		// % protected region % [Add customisation for Kode Provider here] end
		// % protected region % [Add customisation for Nama Provider here] off begin
		String randomStringforNamaProvider = mock
				.strings()
				.get();
		newEntity.setNamaProvider(randomStringforNamaProvider);
		// % protected region % [Add customisation for Nama Provider here] end
		// % protected region % [Add customisation for Tanggal Pelayanan here] off begin
		String randomStringforTanggalPelayanan = mock
				.strings()
				.get();
		newEntity.setTanggalPelayanan(randomStringforTanggalPelayanan);
		// % protected region % [Add customisation for Tanggal Pelayanan here] end
		// % protected region % [Add customisation for Sistole here] off begin
		String randomStringforSistole = mock
				.strings()
				.get();
		newEntity.setSistole(randomStringforSistole);
		// % protected region % [Add customisation for Sistole here] end
		// % protected region % [Add customisation for Diastole here] off begin
		String randomStringforDiastole = mock
				.strings()
				.get();
		newEntity.setDiastole(randomStringforDiastole);
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Radiologi Foto here] off begin
		String randomStringforRadiologiFoto = mock
				.strings()
				.get();
		newEntity.setRadiologiFoto(randomStringforRadiologiFoto);
		// % protected region % [Add customisation for Radiologi Foto here] end
		// % protected region % [Add customisation for Hemoglobin here] off begin
		String randomStringforHemoglobin = mock
				.strings()
				.get();
		newEntity.setHemoglobin(randomStringforHemoglobin);
		// % protected region % [Add customisation for Hemoglobin here] end
		// % protected region % [Add customisation for Leukosit here] off begin
		String randomStringforLeukosit = mock
				.strings()
				.get();
		newEntity.setLeukosit(randomStringforLeukosit);
		// % protected region % [Add customisation for Leukosit here] end
		// % protected region % [Add customisation for Eritrosit here] off begin
		String randomStringforEritrosit = mock
				.strings()
				.get();
		newEntity.setEritrosit(randomStringforEritrosit);
		// % protected region % [Add customisation for Eritrosit here] end
		// % protected region % [Add customisation for Laju Endap Darah here] off begin
		String randomStringforLajuEndapDarah = mock
				.strings()
				.get();
		newEntity.setLajuEndapDarah(randomStringforLajuEndapDarah);
		// % protected region % [Add customisation for Laju Endap Darah here] end
		// % protected region % [Add customisation for Hematokrit here] off begin
		String randomStringforHematokrit = mock
				.strings()
				.get();
		newEntity.setHematokrit(randomStringforHematokrit);
		// % protected region % [Add customisation for Hematokrit here] end
		// % protected region % [Add customisation for Trombosit here] off begin
		String randomStringforTrombosit = mock
				.strings()
				.get();
		newEntity.setTrombosit(randomStringforTrombosit);
		// % protected region % [Add customisation for Trombosit here] end
		// % protected region % [Add customisation for HDL here] off begin
		String randomStringforHdl = mock
				.strings()
				.get();
		newEntity.setHdl(randomStringforHdl);
		// % protected region % [Add customisation for HDL here] end
		// % protected region % [Add customisation for LDL here] off begin
		String randomStringforLdl = mock
				.strings()
				.get();
		newEntity.setLdl(randomStringforLdl);
		// % protected region % [Add customisation for LDL here] end
		// % protected region % [Add customisation for Cholesterol here] off begin
		String randomStringforCholesterol = mock
				.strings()
				.get();
		newEntity.setCholesterol(randomStringforCholesterol);
		// % protected region % [Add customisation for Cholesterol here] end
		// % protected region % [Add customisation for Trigliserida here] off begin
		String randomStringforTrigliserida = mock
				.strings()
				.get();
		newEntity.setTrigliserida(randomStringforTrigliserida);
		// % protected region % [Add customisation for Trigliserida here] end
		// % protected region % [Add customisation for Sewaktu here] off begin
		String randomStringforSewaktu = mock
				.strings()
				.get();
		newEntity.setSewaktu(randomStringforSewaktu);
		// % protected region % [Add customisation for Sewaktu here] end
		// % protected region % [Add customisation for Puasa here] off begin
		String randomStringforPuasa = mock
				.strings()
				.get();
		newEntity.setPuasa(randomStringforPuasa);
		// % protected region % [Add customisation for Puasa here] end
		// % protected region % [Add customisation for Post Prandial here] off begin
		String randomStringforPostPrandial = mock
				.strings()
				.get();
		newEntity.setPostPrandial(randomStringforPostPrandial);
		// % protected region % [Add customisation for Post Prandial here] end
		// % protected region % [Add customisation for HbA1c here] off begin
		String randomStringforHba1c = mock
				.strings()
				.get();
		newEntity.setHba1c(randomStringforHba1c);
		// % protected region % [Add customisation for HbA1c here] end
		// % protected region % [Add customisation for SGOT here] off begin
		String randomStringforSgot = mock
				.strings()
				.get();
		newEntity.setSgot(randomStringforSgot);
		// % protected region % [Add customisation for SGOT here] end
		// % protected region % [Add customisation for SGPT here] off begin
		String randomStringforSgpt = mock
				.strings()
				.get();
		newEntity.setSgpt(randomStringforSgpt);
		// % protected region % [Add customisation for SGPT here] end
		// % protected region % [Add customisation for Gamma here] off begin
		String randomStringforGamma = mock
				.strings()
				.get();
		newEntity.setGamma(randomStringforGamma);
		// % protected region % [Add customisation for Gamma here] end
		// % protected region % [Add customisation for Protein Kualitatif here] off begin
		String randomStringforProteinKualitatif = mock
				.strings()
				.get();
		newEntity.setProteinKualitatif(randomStringforProteinKualitatif);
		// % protected region % [Add customisation for Protein Kualitatif here] end
		// % protected region % [Add customisation for Albumin here] off begin
		String randomStringforAlbumin = mock
				.strings()
				.get();
		newEntity.setAlbumin(randomStringforAlbumin);
		// % protected region % [Add customisation for Albumin here] end
		// % protected region % [Add customisation for Creatinine here] off begin
		String randomStringforCreatinine = mock
				.strings()
				.get();
		newEntity.setCreatinine(randomStringforCreatinine);
		// % protected region % [Add customisation for Creatinine here] end
		// % protected region % [Add customisation for Ureum here] off begin
		String randomStringforUreum = mock
				.strings()
				.get();
		newEntity.setUreum(randomStringforUreum);
		// % protected region % [Add customisation for Ureum here] end
		// % protected region % [Add customisation for Asam here] off begin
		String randomStringforAsam = mock
				.strings()
				.get();
		newEntity.setAsam(randomStringforAsam);
		// % protected region % [Add customisation for Asam here] end
		// % protected region % [Add customisation for ABI here] off begin
		String randomStringforAbi = mock
				.strings()
				.get();
		newEntity.setAbi(randomStringforAbi);
		// % protected region % [Add customisation for ABI here] end
		// % protected region % [Add customisation for EKG here] off begin
		String randomStringforEkg = mock
				.strings()
				.get();
		newEntity.setEkg(randomStringforEkg);
		// % protected region % [Add customisation for EKG here] end
		// % protected region % [Add customisation for Echo here] off begin
		String randomStringforEcho = mock
				.strings()
				.get();
		newEntity.setEcho(randomStringforEcho);
		// % protected region % [Add customisation for Echo here] end
		// % protected region % [Add customisation for Funduskopi here] off begin
		String randomStringforFunduskopi = mock
				.strings()
				.get();
		newEntity.setFunduskopi(randomStringforFunduskopi);
		// % protected region % [Add customisation for Funduskopi here] end
		// % protected region % [Add customisation for Pemeriksaan Lain here] off begin
		String randomStringforPemeriksaanLain = mock
				.strings()
				.get();
		newEntity.setPemeriksaanLain(randomStringforPemeriksaanLain);
		// % protected region % [Add customisation for Pemeriksaan Lain here] end
		// % protected region % [Add customisation for Keterangan here] off begin
		String randomStringforKeterangan = mock
				.strings()
				.get();
		newEntity.setKeterangan(randomStringforKeterangan);
		// % protected region % [Add customisation for Keterangan here] end

		// % protected region % [Apply any additional logic for pcareMCUWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUWithNoRef after the main body here] end

		log.trace("Created entity of type PcareMCUEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare MCU entities with no reference at all.
	 */
	@Provides
	@Named("pcareMCUEntitiesWithNoRef")
	public Collection<PcareMCUEntity> pcareMCUEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareMCUEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareMCUEntitiesWithNoRef here] end
		PcareMCUEntityFactory pcareMCUEntityFactory
	) {
		log.trace("Creating entities of type PcareMCUEntity with no reference");

		// % protected region % [Apply any additional logic for pcareMCUEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUEntitiesWithNoRef before the main body here] end

		Collection<PcareMCUEntity> newEntities = pcareMCUEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareMCUEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareMCUEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare MCU entity with all references set.
	 */
	@Provides
	@Named("pcareMCUEntityWithRefs")
	public PcareMCUEntity pcareMCUEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareMCUEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareMCUEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareMCUEntity with references");

		// % protected region % [Apply any additional logic for pcareMCUEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUEntityWithRefs before the main body here] end

		PcareMCUEntity pcareMCUEntity = injector.getInstance(Key.get(PcareMCUEntity.class, Names.named("pcareMCUEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareMCUEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareMCUEntity with references");

		return pcareMCUEntity;
	}

	/**
	 * Return a collection of PCare MCU entities with all references set.
	 */
	@Provides
	@Named("pcareMCUEntitiesWithRefs")
	public Collection<PcareMCUEntity> pcareMCUEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareMCUEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareMCUEntitiesWithRefs here] end
		PcareMCUEntityFactory pcareMCUEntityFactory
	) {
		log.trace("Creating entities of type PcareMCUEntity with references");

		// % protected region % [Apply any additional logic for pcareMCUEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUEntitiesWithRefs before the main body here] end

		Collection<PcareMCUEntity> newEntities = pcareMCUEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareMCUEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareMCUEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareMCUEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
