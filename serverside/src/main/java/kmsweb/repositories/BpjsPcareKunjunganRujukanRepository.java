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
package kmsweb.repositories;

import kmsweb.entities.BpjsPcareKunjunganRujukanEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface BpjsPcareKunjunganRujukanRepository extends AbstractRepository<BpjsPcareKunjunganRujukanEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute noRujukan.
	 *
	 * @param norujukan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noRujukan
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNorujukan(@NotNull String norujukan);
	/**
	 * Return an entity or a list of entities that have the given attribute kdPPK.
	 *
	 * @param kdppk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdPPK
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKdppk(@NotNull String kdppk);
	/**
	 * Return an entity or a list of entities that have the given attribute nmPPK.
	 *
	 * @param nmppk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmPPK
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmppk(@NotNull String nmppk);
	/**
	 * Return an entity or a list of entities that have the given attribute alamat.
	 *
	 * @param alamat the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute alamat
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByAlamat(@NotNull String alamat);
	/**
	 * Return an entity or a list of entities that have the given attribute kdKC.
	 *
	 * @param kdkc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdKC
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKdkc(@NotNull String kdkc);
	/**
	 * Return an entity or a list of entities that have the given attribute nmKC.
	 *
	 * @param nmkc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmKC
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmkc(@NotNull String nmkc);
	/**
	 * Return an entity or a list of entities that have the given attribute alamatKC.
	 *
	 * @param alamatkc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute alamatKC
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByAlamatkc(@NotNull String alamatkc);
	/**
	 * Return an entity or a list of entities that have the given attribute telpKC.
	 *
	 * @param telpkc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute telpKC
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByTelpkc(@NotNull String telpkc);
	/**
	 * Return an entity or a list of entities that have the given attribute faxKC.
	 *
	 * @param faxkc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute faxKC
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByFaxkc(@NotNull String faxkc);
	/**
	 * Return an entity or a list of entities that have the given attribute kdProp.
	 *
	 * @param kdprop the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProp
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKdprop(@NotNull String kdprop);
	/**
	 * Return an entity or a list of entities that have the given attribute kdDati.
	 *
	 * @param kddati the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdDati
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKddati(@NotNull String kddati);
	/**
	 * Return an entity or a list of entities that have the given attribute nmDati.
	 *
	 * @param nmdati the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmDati
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmdati(@NotNull String nmdati);
	/**
	 * Return an entity or a list of entities that have the given attribute kdKR.
	 *
	 * @param kdkr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdKR
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKdkr(@NotNull String kdkr);
	/**
	 * Return an entity or a list of entities that have the given attribute nmKR.
	 *
	 * @param nmkr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmKR
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmkr(@NotNull String nmkr);
	/**
	 * Return an entity or a list of entities that have the given attribute alamatKR.
	 *
	 * @param alamatkr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute alamatKR
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByAlamatkr(@NotNull String alamatkr);
	/**
	 * Return an entity or a list of entities that have the given attribute telpKR.
	 *
	 * @param telpkr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute telpKR
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByTelpkr(@NotNull String telpkr);
	/**
	 * Return an entity or a list of entities that have the given attribute faxKR.
	 *
	 * @param faxkr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute faxKR
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByFaxkr(@NotNull String faxkr);
	/**
	 * Return an entity or a list of entities that have the given attribute tglKunjungan.
	 *
	 * @param tglkunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglKunjungan
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByTglkunjungan(@NotNull String tglkunjungan);
	/**
	 * Return an entity or a list of entities that have the given attribute kdPoli.
	 *
	 * @param kdpoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdPoli
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKdpoli(@NotNull String kdpoli);
	/**
	 * Return an entity or a list of entities that have the given attribute nmPoli.
	 *
	 * @param nmpoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmPoli
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmpoli(@NotNull String nmpoli);
	/**
	 * Return an entity or a list of entities that have the given attribute nokaPst.
	 *
	 * @param nokapst the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nokaPst
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNokapst(@NotNull String nokapst);
	/**
	 * Return an entity or a list of entities that have the given attribute nmPst.
	 *
	 * @param nmpst the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmPst
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmpst(@NotNull String nmpst);
	/**
	 * Return an entity or a list of entities that have the given attribute tglLahir.
	 *
	 * @param tgllahir the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglLahir
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByTgllahir(@NotNull String tgllahir);
	/**
	 * Return an entity or a list of entities that have the given attribute pisa.
	 *
	 * @param pisa the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute pisa
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByPisa(@NotNull String pisa);
	/**
	 * Return an entity or a list of entities that have the given attribute ketPisa.
	 *
	 * @param ketpisa the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketPisa
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKetpisa(@NotNull String ketpisa);
	/**
	 * Return an entity or a list of entities that have the given attribute sex.
	 *
	 * @param sex the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sex
	 */
	List<BpjsPcareKunjunganRujukanEntity> findBySex(@NotNull String sex);
	/**
	 * Return an entity or a list of entities that have the given attribute kdDiag1.
	 *
	 * @param kddiag1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdDiag1
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKddiag1(@NotNull String kddiag1);
	/**
	 * Return an entity or a list of entities that have the given attribute nmDiag1.
	 *
	 * @param nmdiag1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmDiag1
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmdiag1(@NotNull String nmdiag1);
	/**
	 * Return an entity or a list of entities that have the given attribute kdDiag2.
	 *
	 * @param kddiag2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdDiag2
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKddiag2(@NotNull String kddiag2);
	/**
	 * Return an entity or a list of entities that have the given attribute nmDiag2.
	 *
	 * @param nmdiag2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmDiag2
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmdiag2(@NotNull String nmdiag2);
	/**
	 * Return an entity or a list of entities that have the given attribute kdDiag3.
	 *
	 * @param kddiag3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdDiag3
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKddiag3(@NotNull String kddiag3);
	/**
	 * Return an entity or a list of entities that have the given attribute nmDiag3.
	 *
	 * @param nmdiag3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmDiag3
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmdiag3(@NotNull String nmdiag3);
	/**
	 * Return an entity or a list of entities that have the given attribute catatan.
	 *
	 * @param catatan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute catatan
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByCatatan(@NotNull String catatan);
	/**
	 * Return an entity or a list of entities that have the given attribute kdDokter.
	 *
	 * @param kddokter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdDokter
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByKddokter(@NotNull String kddokter);
	/**
	 * Return an entity or a list of entities that have the given attribute nmDokter.
	 *
	 * @param nmdokter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmDokter
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmdokter(@NotNull String nmdokter);
	/**
	 * Return an entity or a list of entities that have the given attribute nmTacc.
	 *
	 * @param nmtacc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmTacc
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByNmtacc(@NotNull String nmtacc);
	/**
	 * Return an entity or a list of entities that have the given attribute alasanTacc.
	 *
	 * @param alasantacc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute alasanTacc
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByAlasantacc(@NotNull String alasantacc);
	/**
	 * Return an entity or a list of entities that have the given attribute infoDenda.
	 *
	 * @param infodenda the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute infoDenda
	 */
	List<BpjsPcareKunjunganRujukanEntity> findByInfodenda(@NotNull String infodenda);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcareKunjunganRujukanEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcareKunjunganRujukanEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}