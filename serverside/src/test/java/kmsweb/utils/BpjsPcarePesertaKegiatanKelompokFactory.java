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
import kmsweb.entities.BpjsPcarePesertaKegiatanKelompokEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsPcarePesertaKegiatanKelompokFactory implements FactoryBean<BpjsPcarePesertaKegiatanKelompokEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsPcarePesertaKegiatanKelompokEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsPcarePesertaKegiatanKelompokEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsPcarePesertaKegiatanKelompokEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokWithNoRef before the main body here] end

		BpjsPcarePesertaKegiatanKelompokEntity newEntity = new BpjsPcarePesertaKegiatanKelompokEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for eduId here] off begin
		String randomStringForEduid = mockNeat
				.strings()
				.get();
		newEntity.setEduid(randomStringForEduid);
		// % protected region % [Add customisation for eduId here] end
		// % protected region % [Add customisation for noKartu here] off begin
		String randomStringForNokartu = mockNeat
				.strings()
				.get();
		newEntity.setNokartu(randomStringForNokartu);
		// % protected region % [Add customisation for noKartu here] end
		// % protected region % [Add customisation for nama here] off begin
		String randomStringForNama = mockNeat
				.strings()
				.get();
		newEntity.setNama(randomStringForNama);
		// % protected region % [Add customisation for nama here] end
		// % protected region % [Add customisation for hubunganKeluarga here] off begin
		String randomStringForHubungankeluarga = mockNeat
				.strings()
				.get();
		newEntity.setHubungankeluarga(randomStringForHubungankeluarga);
		// % protected region % [Add customisation for hubunganKeluarga here] end
		// % protected region % [Add customisation for sex here] off begin
		String randomStringForSex = mockNeat
				.strings()
				.get();
		newEntity.setSex(randomStringForSex);
		// % protected region % [Add customisation for sex here] end
		// % protected region % [Add customisation for tglLahir here] off begin
		String randomStringForTgllahir = mockNeat
				.strings()
				.get();
		newEntity.setTgllahir(randomStringForTgllahir);
		// % protected region % [Add customisation for tglLahir here] end
		// % protected region % [Add customisation for tglMulaiAktif here] off begin
		String randomStringForTglmulaiaktif = mockNeat
				.strings()
				.get();
		newEntity.setTglmulaiaktif(randomStringForTglmulaiaktif);
		// % protected region % [Add customisation for tglMulaiAktif here] end
		// % protected region % [Add customisation for tglAkhirBerlaku here] off begin
		String randomStringForTglakhirberlaku = mockNeat
				.strings()
				.get();
		newEntity.setTglakhirberlaku(randomStringForTglakhirberlaku);
		// % protected region % [Add customisation for tglAkhirBerlaku here] end
		// % protected region % [Add customisation for kdProvider here] off begin
		String randomStringForKdprovider = mockNeat
				.strings()
				.get();
		newEntity.setKdprovider(randomStringForKdprovider);
		// % protected region % [Add customisation for kdProvider here] end
		// % protected region % [Add customisation for nmProvider here] off begin
		String randomStringForNmprovider = mockNeat
				.strings()
				.get();
		newEntity.setNmprovider(randomStringForNmprovider);
		// % protected region % [Add customisation for nmProvider here] end
		// % protected region % [Add customisation for kdProviderGigi here] off begin
		String randomStringForKdprovidergigi = mockNeat
				.strings()
				.get();
		newEntity.setKdprovidergigi(randomStringForKdprovidergigi);
		// % protected region % [Add customisation for kdProviderGigi here] end
		// % protected region % [Add customisation for nmProviderGigi here] off begin
		String randomStringForNmprovidergigi = mockNeat
				.strings()
				.get();
		newEntity.setNmprovidergigi(randomStringForNmprovidergigi);
		// % protected region % [Add customisation for nmProviderGigi here] end
		// % protected region % [Add customisation for namaKelas here] off begin
		String randomStringForNamakelas = mockNeat
				.strings()
				.get();
		newEntity.setNamakelas(randomStringForNamakelas);
		// % protected region % [Add customisation for namaKelas here] end
		// % protected region % [Add customisation for kodeKelas here] off begin
		String randomStringForKodekelas = mockNeat
				.strings()
				.get();
		newEntity.setKodekelas(randomStringForKodekelas);
		// % protected region % [Add customisation for kodeKelas here] end
		// % protected region % [Add customisation for namaPeserta here] off begin
		String randomStringForNamapeserta = mockNeat
				.strings()
				.get();
		newEntity.setNamapeserta(randomStringForNamapeserta);
		// % protected region % [Add customisation for namaPeserta here] end
		// % protected region % [Add customisation for kodePeserta here] off begin
		String randomStringForKodepeserta = mockNeat
				.strings()
				.get();
		newEntity.setKodepeserta(randomStringForKodepeserta);
		// % protected region % [Add customisation for kodePeserta here] end
		// % protected region % [Add customisation for golDarah here] off begin
		String randomStringForGoldarah = mockNeat
				.strings()
				.get();
		newEntity.setGoldarah(randomStringForGoldarah);
		// % protected region % [Add customisation for golDarah here] end
		// % protected region % [Add customisation for noHP here] off begin
		String randomStringForNohp = mockNeat
				.strings()
				.get();
		newEntity.setNohp(randomStringForNohp);
		// % protected region % [Add customisation for noHP here] end
		// % protected region % [Add customisation for noKTP here] off begin
		String randomStringForNoktp = mockNeat
				.strings()
				.get();
		newEntity.setNoktp(randomStringForNoktp);
		// % protected region % [Add customisation for noKTP here] end
		// % protected region % [Add customisation for pstProl here] off begin
		String randomStringForPstprol = mockNeat
				.strings()
				.get();
		newEntity.setPstprol(randomStringForPstprol);
		// % protected region % [Add customisation for pstProl here] end
		// % protected region % [Add customisation for pstPrb here] off begin
		String randomStringForPstprb = mockNeat
				.strings()
				.get();
		newEntity.setPstprb(randomStringForPstprb);
		// % protected region % [Add customisation for pstPrb here] end
		// % protected region % [Add customisation for ketAktif here] off begin
		String randomStringForKetaktif = mockNeat
				.strings()
				.get();
		newEntity.setKetaktif(randomStringForKetaktif);
		// % protected region % [Add customisation for ketAktif here] end
		// % protected region % [Add customisation for kdAsuransi here] off begin
		String randomStringForKdasuransi = mockNeat
				.strings()
				.get();
		newEntity.setKdasuransi(randomStringForKdasuransi);
		// % protected region % [Add customisation for kdAsuransi here] end
		// % protected region % [Add customisation for nmAsuransi here] off begin
		String randomStringForNmasuransi = mockNeat
				.strings()
				.get();
		newEntity.setNmasuransi(randomStringForNmasuransi);
		// % protected region % [Add customisation for nmAsuransi here] end
		// % protected region % [Add customisation for noAsuransi here] off begin
		String randomStringForNoasuransi = mockNeat
				.strings()
				.get();
		newEntity.setNoasuransi(randomStringForNoasuransi);
		// % protected region % [Add customisation for noAsuransi here] end
		// % protected region % [Add customisation for cob here] off begin
		String randomStringForCob = mockNeat
				.strings()
				.get();
		newEntity.setCob(randomStringForCob);
		// % protected region % [Add customisation for cob here] end
		// % protected region % [Add customisation for tunggakan here] off begin
		String randomStringForTunggakan = mockNeat
				.strings()
				.get();
		newEntity.setTunggakan(randomStringForTunggakan);
		// % protected region % [Add customisation for tunggakan here] end

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsPcarePesertaKegiatanKelompokEntity> getObjectType() {
		return BpjsPcarePesertaKegiatanKelompokEntity.class;
	}
}