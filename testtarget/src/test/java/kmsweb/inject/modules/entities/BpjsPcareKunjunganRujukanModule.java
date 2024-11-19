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
 * Guice module for Bpjs Pcare Kunjungan Rujukan used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPcareKunjunganRujukanModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPcareKunjunganRujukanModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPcareKunjunganRujukanModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPcareKunjunganRujukanEntityFactory bpjsPcareKunjunganRujukanEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPcareKunjunganRujukanEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPcareKunjunganRujukanEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPcareKunjunganRujukanEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntityFactory before the main body here] end

		BpjsPcareKunjunganRujukanEntityFactory entityFactory = new BpjsPcareKunjunganRujukanEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPcareKunjunganRujukanEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPcareKunjunganRujukanEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntityFactory after the main body here] end

		log.trace("Created BpjsPcareKunjunganRujukanEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Bpjs Pcare Kunjungan Rujukan entity with no references set.
	 */
	@Provides
	@Named("bpjsPcareKunjunganRujukanEntityWithNoRef")
	public BpjsPcareKunjunganRujukanEntity bpjsPcareKunjunganRujukanEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKunjunganRujukanEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKunjunganRujukanEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPcareKunjunganRujukanEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanWithNoRef before the main body here] end

		BpjsPcareKunjunganRujukanEntity newEntity = new BpjsPcareKunjunganRujukanEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for noRujukan here] off begin
		String randomStringforNorujukan = mock
				.strings()
				.get();
		newEntity.setNorujukan(randomStringforNorujukan);
		// % protected region % [Add customisation for noRujukan here] end
		// % protected region % [Add customisation for kdPPK here] off begin
		String randomStringforKdppk = mock
				.strings()
				.get();
		newEntity.setKdppk(randomStringforKdppk);
		// % protected region % [Add customisation for kdPPK here] end
		// % protected region % [Add customisation for nmPPK here] off begin
		String randomStringforNmppk = mock
				.strings()
				.get();
		newEntity.setNmppk(randomStringforNmppk);
		// % protected region % [Add customisation for nmPPK here] end
		// % protected region % [Add customisation for alamat here] off begin
		String randomStringforAlamat = mock
				.strings()
				.get();
		newEntity.setAlamat(randomStringforAlamat);
		// % protected region % [Add customisation for alamat here] end
		// % protected region % [Add customisation for kdKC here] off begin
		String randomStringforKdkc = mock
				.strings()
				.get();
		newEntity.setKdkc(randomStringforKdkc);
		// % protected region % [Add customisation for kdKC here] end
		// % protected region % [Add customisation for nmKC here] off begin
		String randomStringforNmkc = mock
				.strings()
				.get();
		newEntity.setNmkc(randomStringforNmkc);
		// % protected region % [Add customisation for nmKC here] end
		// % protected region % [Add customisation for alamatKC here] off begin
		String randomStringforAlamatkc = mock
				.strings()
				.get();
		newEntity.setAlamatkc(randomStringforAlamatkc);
		// % protected region % [Add customisation for alamatKC here] end
		// % protected region % [Add customisation for telpKC here] off begin
		String randomStringforTelpkc = mock
				.strings()
				.get();
		newEntity.setTelpkc(randomStringforTelpkc);
		// % protected region % [Add customisation for telpKC here] end
		// % protected region % [Add customisation for faxKC here] off begin
		String randomStringforFaxkc = mock
				.strings()
				.get();
		newEntity.setFaxkc(randomStringforFaxkc);
		// % protected region % [Add customisation for faxKC here] end
		// % protected region % [Add customisation for kdProp here] off begin
		String randomStringforKdprop = mock
				.strings()
				.get();
		newEntity.setKdprop(randomStringforKdprop);
		// % protected region % [Add customisation for kdProp here] end
		// % protected region % [Add customisation for kdDati here] off begin
		String randomStringforKddati = mock
				.strings()
				.get();
		newEntity.setKddati(randomStringforKddati);
		// % protected region % [Add customisation for kdDati here] end
		// % protected region % [Add customisation for nmDati here] off begin
		String randomStringforNmdati = mock
				.strings()
				.get();
		newEntity.setNmdati(randomStringforNmdati);
		// % protected region % [Add customisation for nmDati here] end
		// % protected region % [Add customisation for kdKR here] off begin
		String randomStringforKdkr = mock
				.strings()
				.get();
		newEntity.setKdkr(randomStringforKdkr);
		// % protected region % [Add customisation for kdKR here] end
		// % protected region % [Add customisation for nmKR here] off begin
		String randomStringforNmkr = mock
				.strings()
				.get();
		newEntity.setNmkr(randomStringforNmkr);
		// % protected region % [Add customisation for nmKR here] end
		// % protected region % [Add customisation for alamatKR here] off begin
		String randomStringforAlamatkr = mock
				.strings()
				.get();
		newEntity.setAlamatkr(randomStringforAlamatkr);
		// % protected region % [Add customisation for alamatKR here] end
		// % protected region % [Add customisation for telpKR here] off begin
		String randomStringforTelpkr = mock
				.strings()
				.get();
		newEntity.setTelpkr(randomStringforTelpkr);
		// % protected region % [Add customisation for telpKR here] end
		// % protected region % [Add customisation for faxKR here] off begin
		String randomStringforFaxkr = mock
				.strings()
				.get();
		newEntity.setFaxkr(randomStringforFaxkr);
		// % protected region % [Add customisation for faxKR here] end
		// % protected region % [Add customisation for tglKunjungan here] off begin
		String randomStringforTglkunjungan = mock
				.strings()
				.get();
		newEntity.setTglkunjungan(randomStringforTglkunjungan);
		// % protected region % [Add customisation for tglKunjungan here] end
		// % protected region % [Add customisation for kdPoli here] off begin
		String randomStringforKdpoli = mock
				.strings()
				.get();
		newEntity.setKdpoli(randomStringforKdpoli);
		// % protected region % [Add customisation for kdPoli here] end
		// % protected region % [Add customisation for nmPoli here] off begin
		String randomStringforNmpoli = mock
				.strings()
				.get();
		newEntity.setNmpoli(randomStringforNmpoli);
		// % protected region % [Add customisation for nmPoli here] end
		// % protected region % [Add customisation for nokaPst here] off begin
		String randomStringforNokapst = mock
				.strings()
				.get();
		newEntity.setNokapst(randomStringforNokapst);
		// % protected region % [Add customisation for nokaPst here] end
		// % protected region % [Add customisation for nmPst here] off begin
		String randomStringforNmpst = mock
				.strings()
				.get();
		newEntity.setNmpst(randomStringforNmpst);
		// % protected region % [Add customisation for nmPst here] end
		// % protected region % [Add customisation for tglLahir here] off begin
		String randomStringforTgllahir = mock
				.strings()
				.get();
		newEntity.setTgllahir(randomStringforTgllahir);
		// % protected region % [Add customisation for tglLahir here] end
		// % protected region % [Add customisation for pisa here] off begin
		String randomStringforPisa = mock
				.strings()
				.get();
		newEntity.setPisa(randomStringforPisa);
		// % protected region % [Add customisation for pisa here] end
		// % protected region % [Add customisation for ketPisa here] off begin
		String randomStringforKetpisa = mock
				.strings()
				.get();
		newEntity.setKetpisa(randomStringforKetpisa);
		// % protected region % [Add customisation for ketPisa here] end
		// % protected region % [Add customisation for sex here] off begin
		String randomStringforSex = mock
				.strings()
				.get();
		newEntity.setSex(randomStringforSex);
		// % protected region % [Add customisation for sex here] end
		// % protected region % [Add customisation for kdDiag1 here] off begin
		String randomStringforKddiag1 = mock
				.strings()
				.get();
		newEntity.setKddiag1(randomStringforKddiag1);
		// % protected region % [Add customisation for kdDiag1 here] end
		// % protected region % [Add customisation for nmDiag1 here] off begin
		String randomStringforNmdiag1 = mock
				.strings()
				.get();
		newEntity.setNmdiag1(randomStringforNmdiag1);
		// % protected region % [Add customisation for nmDiag1 here] end
		// % protected region % [Add customisation for kdDiag2 here] off begin
		String randomStringforKddiag2 = mock
				.strings()
				.get();
		newEntity.setKddiag2(randomStringforKddiag2);
		// % protected region % [Add customisation for kdDiag2 here] end
		// % protected region % [Add customisation for nmDiag2 here] off begin
		String randomStringforNmdiag2 = mock
				.strings()
				.get();
		newEntity.setNmdiag2(randomStringforNmdiag2);
		// % protected region % [Add customisation for nmDiag2 here] end
		// % protected region % [Add customisation for kdDiag3 here] off begin
		String randomStringforKddiag3 = mock
				.strings()
				.get();
		newEntity.setKddiag3(randomStringforKddiag3);
		// % protected region % [Add customisation for kdDiag3 here] end
		// % protected region % [Add customisation for nmDiag3 here] off begin
		String randomStringforNmdiag3 = mock
				.strings()
				.get();
		newEntity.setNmdiag3(randomStringforNmdiag3);
		// % protected region % [Add customisation for nmDiag3 here] end
		// % protected region % [Add customisation for catatan here] off begin
		String randomStringforCatatan = mock
				.strings()
				.get();
		newEntity.setCatatan(randomStringforCatatan);
		// % protected region % [Add customisation for catatan here] end
		// % protected region % [Add customisation for kdDokter here] off begin
		String randomStringforKddokter = mock
				.strings()
				.get();
		newEntity.setKddokter(randomStringforKddokter);
		// % protected region % [Add customisation for kdDokter here] end
		// % protected region % [Add customisation for nmDokter here] off begin
		String randomStringforNmdokter = mock
				.strings()
				.get();
		newEntity.setNmdokter(randomStringforNmdokter);
		// % protected region % [Add customisation for nmDokter here] end
		// % protected region % [Add customisation for nmTacc here] off begin
		String randomStringforNmtacc = mock
				.strings()
				.get();
		newEntity.setNmtacc(randomStringforNmtacc);
		// % protected region % [Add customisation for nmTacc here] end
		// % protected region % [Add customisation for alasanTacc here] off begin
		String randomStringforAlasantacc = mock
				.strings()
				.get();
		newEntity.setAlasantacc(randomStringforAlasantacc);
		// % protected region % [Add customisation for alasanTacc here] end
		// % protected region % [Add customisation for infoDenda here] off begin
		String randomStringforInfodenda = mock
				.strings()
				.get();
		newEntity.setInfodenda(randomStringforInfodenda);
		// % protected region % [Add customisation for infoDenda here] end

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPcareKunjunganRujukanEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Bpjs Pcare Kunjungan Rujukan entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPcareKunjunganRujukanEntitiesWithNoRef")
	public Collection<BpjsPcareKunjunganRujukanEntity> bpjsPcareKunjunganRujukanEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKunjunganRujukanEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKunjunganRujukanEntitiesWithNoRef here] end
		BpjsPcareKunjunganRujukanEntityFactory bpjsPcareKunjunganRujukanEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareKunjunganRujukanEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntitiesWithNoRef before the main body here] end

		Collection<BpjsPcareKunjunganRujukanEntity> newEntities = bpjsPcareKunjunganRujukanEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPcareKunjunganRujukanEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Bpjs Pcare Kunjungan Rujukan entity with all references set.
	 */
	@Provides
	@Named("bpjsPcareKunjunganRujukanEntityWithRefs")
	public BpjsPcareKunjunganRujukanEntity bpjsPcareKunjunganRujukanEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKunjunganRujukanEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKunjunganRujukanEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPcareKunjunganRujukanEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntityWithRefs before the main body here] end

		BpjsPcareKunjunganRujukanEntity bpjsPcareKunjunganRujukanEntity = injector.getInstance(Key.get(BpjsPcareKunjunganRujukanEntity.class, Names.named("bpjsPcareKunjunganRujukanEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPcareKunjunganRujukanEntity with references");

		return bpjsPcareKunjunganRujukanEntity;
	}

	/**
	 * Return a collection of Bpjs Pcare Kunjungan Rujukan entities with all references set.
	 */
	@Provides
	@Named("bpjsPcareKunjunganRujukanEntitiesWithRefs")
	public Collection<BpjsPcareKunjunganRujukanEntity> bpjsPcareKunjunganRujukanEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKunjunganRujukanEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKunjunganRujukanEntitiesWithRefs here] end
		BpjsPcareKunjunganRujukanEntityFactory bpjsPcareKunjunganRujukanEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareKunjunganRujukanEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntitiesWithRefs before the main body here] end

		Collection<BpjsPcareKunjunganRujukanEntity> newEntities = bpjsPcareKunjunganRujukanEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPcareKunjunganRujukanEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
