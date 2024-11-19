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
import kmsweb.entities.BpjsPcareKunjunganRujukanEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsPcareKunjunganRujukanFactory implements FactoryBean<BpjsPcareKunjunganRujukanEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsPcareKunjunganRujukanEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsPcareKunjunganRujukanEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsPcareKunjunganRujukanEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanWithNoRef before the main body here] end

		BpjsPcareKunjunganRujukanEntity newEntity = new BpjsPcareKunjunganRujukanEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for noRujukan here] off begin
		String randomStringForNorujukan = mockNeat
				.strings()
				.get();
		newEntity.setNorujukan(randomStringForNorujukan);
		// % protected region % [Add customisation for noRujukan here] end
		// % protected region % [Add customisation for kdPPK here] off begin
		String randomStringForKdppk = mockNeat
				.strings()
				.get();
		newEntity.setKdppk(randomStringForKdppk);
		// % protected region % [Add customisation for kdPPK here] end
		// % protected region % [Add customisation for nmPPK here] off begin
		String randomStringForNmppk = mockNeat
				.strings()
				.get();
		newEntity.setNmppk(randomStringForNmppk);
		// % protected region % [Add customisation for nmPPK here] end
		// % protected region % [Add customisation for alamat here] off begin
		String randomStringForAlamat = mockNeat
				.strings()
				.get();
		newEntity.setAlamat(randomStringForAlamat);
		// % protected region % [Add customisation for alamat here] end
		// % protected region % [Add customisation for kdKC here] off begin
		String randomStringForKdkc = mockNeat
				.strings()
				.get();
		newEntity.setKdkc(randomStringForKdkc);
		// % protected region % [Add customisation for kdKC here] end
		// % protected region % [Add customisation for nmKC here] off begin
		String randomStringForNmkc = mockNeat
				.strings()
				.get();
		newEntity.setNmkc(randomStringForNmkc);
		// % protected region % [Add customisation for nmKC here] end
		// % protected region % [Add customisation for alamatKC here] off begin
		String randomStringForAlamatkc = mockNeat
				.strings()
				.get();
		newEntity.setAlamatkc(randomStringForAlamatkc);
		// % protected region % [Add customisation for alamatKC here] end
		// % protected region % [Add customisation for telpKC here] off begin
		String randomStringForTelpkc = mockNeat
				.strings()
				.get();
		newEntity.setTelpkc(randomStringForTelpkc);
		// % protected region % [Add customisation for telpKC here] end
		// % protected region % [Add customisation for faxKC here] off begin
		String randomStringForFaxkc = mockNeat
				.strings()
				.get();
		newEntity.setFaxkc(randomStringForFaxkc);
		// % protected region % [Add customisation for faxKC here] end
		// % protected region % [Add customisation for kdProp here] off begin
		String randomStringForKdprop = mockNeat
				.strings()
				.get();
		newEntity.setKdprop(randomStringForKdprop);
		// % protected region % [Add customisation for kdProp here] end
		// % protected region % [Add customisation for kdDati here] off begin
		String randomStringForKddati = mockNeat
				.strings()
				.get();
		newEntity.setKddati(randomStringForKddati);
		// % protected region % [Add customisation for kdDati here] end
		// % protected region % [Add customisation for nmDati here] off begin
		String randomStringForNmdati = mockNeat
				.strings()
				.get();
		newEntity.setNmdati(randomStringForNmdati);
		// % protected region % [Add customisation for nmDati here] end
		// % protected region % [Add customisation for kdKR here] off begin
		String randomStringForKdkr = mockNeat
				.strings()
				.get();
		newEntity.setKdkr(randomStringForKdkr);
		// % protected region % [Add customisation for kdKR here] end
		// % protected region % [Add customisation for nmKR here] off begin
		String randomStringForNmkr = mockNeat
				.strings()
				.get();
		newEntity.setNmkr(randomStringForNmkr);
		// % protected region % [Add customisation for nmKR here] end
		// % protected region % [Add customisation for alamatKR here] off begin
		String randomStringForAlamatkr = mockNeat
				.strings()
				.get();
		newEntity.setAlamatkr(randomStringForAlamatkr);
		// % protected region % [Add customisation for alamatKR here] end
		// % protected region % [Add customisation for telpKR here] off begin
		String randomStringForTelpkr = mockNeat
				.strings()
				.get();
		newEntity.setTelpkr(randomStringForTelpkr);
		// % protected region % [Add customisation for telpKR here] end
		// % protected region % [Add customisation for faxKR here] off begin
		String randomStringForFaxkr = mockNeat
				.strings()
				.get();
		newEntity.setFaxkr(randomStringForFaxkr);
		// % protected region % [Add customisation for faxKR here] end
		// % protected region % [Add customisation for tglKunjungan here] off begin
		String randomStringForTglkunjungan = mockNeat
				.strings()
				.get();
		newEntity.setTglkunjungan(randomStringForTglkunjungan);
		// % protected region % [Add customisation for tglKunjungan here] end
		// % protected region % [Add customisation for kdPoli here] off begin
		String randomStringForKdpoli = mockNeat
				.strings()
				.get();
		newEntity.setKdpoli(randomStringForKdpoli);
		// % protected region % [Add customisation for kdPoli here] end
		// % protected region % [Add customisation for nmPoli here] off begin
		String randomStringForNmpoli = mockNeat
				.strings()
				.get();
		newEntity.setNmpoli(randomStringForNmpoli);
		// % protected region % [Add customisation for nmPoli here] end
		// % protected region % [Add customisation for nokaPst here] off begin
		String randomStringForNokapst = mockNeat
				.strings()
				.get();
		newEntity.setNokapst(randomStringForNokapst);
		// % protected region % [Add customisation for nokaPst here] end
		// % protected region % [Add customisation for nmPst here] off begin
		String randomStringForNmpst = mockNeat
				.strings()
				.get();
		newEntity.setNmpst(randomStringForNmpst);
		// % protected region % [Add customisation for nmPst here] end
		// % protected region % [Add customisation for tglLahir here] off begin
		String randomStringForTgllahir = mockNeat
				.strings()
				.get();
		newEntity.setTgllahir(randomStringForTgllahir);
		// % protected region % [Add customisation for tglLahir here] end
		// % protected region % [Add customisation for pisa here] off begin
		String randomStringForPisa = mockNeat
				.strings()
				.get();
		newEntity.setPisa(randomStringForPisa);
		// % protected region % [Add customisation for pisa here] end
		// % protected region % [Add customisation for ketPisa here] off begin
		String randomStringForKetpisa = mockNeat
				.strings()
				.get();
		newEntity.setKetpisa(randomStringForKetpisa);
		// % protected region % [Add customisation for ketPisa here] end
		// % protected region % [Add customisation for sex here] off begin
		String randomStringForSex = mockNeat
				.strings()
				.get();
		newEntity.setSex(randomStringForSex);
		// % protected region % [Add customisation for sex here] end
		// % protected region % [Add customisation for kdDiag1 here] off begin
		String randomStringForKddiag1 = mockNeat
				.strings()
				.get();
		newEntity.setKddiag1(randomStringForKddiag1);
		// % protected region % [Add customisation for kdDiag1 here] end
		// % protected region % [Add customisation for nmDiag1 here] off begin
		String randomStringForNmdiag1 = mockNeat
				.strings()
				.get();
		newEntity.setNmdiag1(randomStringForNmdiag1);
		// % protected region % [Add customisation for nmDiag1 here] end
		// % protected region % [Add customisation for kdDiag2 here] off begin
		String randomStringForKddiag2 = mockNeat
				.strings()
				.get();
		newEntity.setKddiag2(randomStringForKddiag2);
		// % protected region % [Add customisation for kdDiag2 here] end
		// % protected region % [Add customisation for nmDiag2 here] off begin
		String randomStringForNmdiag2 = mockNeat
				.strings()
				.get();
		newEntity.setNmdiag2(randomStringForNmdiag2);
		// % protected region % [Add customisation for nmDiag2 here] end
		// % protected region % [Add customisation for kdDiag3 here] off begin
		String randomStringForKddiag3 = mockNeat
				.strings()
				.get();
		newEntity.setKddiag3(randomStringForKddiag3);
		// % protected region % [Add customisation for kdDiag3 here] end
		// % protected region % [Add customisation for nmDiag3 here] off begin
		String randomStringForNmdiag3 = mockNeat
				.strings()
				.get();
		newEntity.setNmdiag3(randomStringForNmdiag3);
		// % protected region % [Add customisation for nmDiag3 here] end
		// % protected region % [Add customisation for catatan here] off begin
		String randomStringForCatatan = mockNeat
				.strings()
				.get();
		newEntity.setCatatan(randomStringForCatatan);
		// % protected region % [Add customisation for catatan here] end
		// % protected region % [Add customisation for kdDokter here] off begin
		String randomStringForKddokter = mockNeat
				.strings()
				.get();
		newEntity.setKddokter(randomStringForKddokter);
		// % protected region % [Add customisation for kdDokter here] end
		// % protected region % [Add customisation for nmDokter here] off begin
		String randomStringForNmdokter = mockNeat
				.strings()
				.get();
		newEntity.setNmdokter(randomStringForNmdokter);
		// % protected region % [Add customisation for nmDokter here] end
		// % protected region % [Add customisation for nmTacc here] off begin
		String randomStringForNmtacc = mockNeat
				.strings()
				.get();
		newEntity.setNmtacc(randomStringForNmtacc);
		// % protected region % [Add customisation for nmTacc here] end
		// % protected region % [Add customisation for alasanTacc here] off begin
		String randomStringForAlasantacc = mockNeat
				.strings()
				.get();
		newEntity.setAlasantacc(randomStringForAlasantacc);
		// % protected region % [Add customisation for alasanTacc here] end
		// % protected region % [Add customisation for infoDenda here] off begin
		String randomStringForInfodenda = mockNeat
				.strings()
				.get();
		newEntity.setInfodenda(randomStringForInfodenda);
		// % protected region % [Add customisation for infoDenda here] end

		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKunjunganRujukanWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsPcareKunjunganRujukanEntity> getObjectType() {
		return BpjsPcareKunjunganRujukanEntity.class;
	}
}