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

import kmsweb.entities.BpjsPcarePesertaKegiatanKelompokEntity;
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
public interface BpjsPcarePesertaKegiatanKelompokRepository extends AbstractRepository<BpjsPcarePesertaKegiatanKelompokEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute eduId.
	 *
	 * @param eduid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute eduId
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByEduid(@NotNull String eduid);
	/**
	 * Return an entity or a list of entities that have the given attribute noKartu.
	 *
	 * @param nokartu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKartu
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByNokartu(@NotNull String nokartu);
	/**
	 * Return an entity or a list of entities that have the given attribute nama.
	 *
	 * @param nama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nama
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByNama(@NotNull String nama);
	/**
	 * Return an entity or a list of entities that have the given attribute hubunganKeluarga.
	 *
	 * @param hubungankeluarga the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute hubunganKeluarga
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByHubungankeluarga(@NotNull String hubungankeluarga);
	/**
	 * Return an entity or a list of entities that have the given attribute sex.
	 *
	 * @param sex the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sex
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findBySex(@NotNull String sex);
	/**
	 * Return an entity or a list of entities that have the given attribute tglLahir.
	 *
	 * @param tgllahir the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglLahir
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByTgllahir(@NotNull String tgllahir);
	/**
	 * Return an entity or a list of entities that have the given attribute tglMulaiAktif.
	 *
	 * @param tglmulaiaktif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglMulaiAktif
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByTglmulaiaktif(@NotNull String tglmulaiaktif);
	/**
	 * Return an entity or a list of entities that have the given attribute tglAkhirBerlaku.
	 *
	 * @param tglakhirberlaku the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglAkhirBerlaku
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByTglakhirberlaku(@NotNull String tglakhirberlaku);
	/**
	 * Return an entity or a list of entities that have the given attribute kdProvider.
	 *
	 * @param kdprovider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProvider
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByKdprovider(@NotNull String kdprovider);
	/**
	 * Return an entity or a list of entities that have the given attribute nmProvider.
	 *
	 * @param nmprovider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProvider
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByNmprovider(@NotNull String nmprovider);
	/**
	 * Return an entity or a list of entities that have the given attribute kdProviderGigi.
	 *
	 * @param kdprovidergigi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProviderGigi
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByKdprovidergigi(@NotNull String kdprovidergigi);
	/**
	 * Return an entity or a list of entities that have the given attribute nmProviderGigi.
	 *
	 * @param nmprovidergigi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProviderGigi
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByNmprovidergigi(@NotNull String nmprovidergigi);
	/**
	 * Return an entity or a list of entities that have the given attribute namaKelas.
	 *
	 * @param namakelas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namaKelas
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByNamakelas(@NotNull String namakelas);
	/**
	 * Return an entity or a list of entities that have the given attribute kodeKelas.
	 *
	 * @param kodekelas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodeKelas
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByKodekelas(@NotNull String kodekelas);
	/**
	 * Return an entity or a list of entities that have the given attribute namaPeserta.
	 *
	 * @param namapeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namaPeserta
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByNamapeserta(@NotNull String namapeserta);
	/**
	 * Return an entity or a list of entities that have the given attribute kodePeserta.
	 *
	 * @param kodepeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodePeserta
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByKodepeserta(@NotNull String kodepeserta);
	/**
	 * Return an entity or a list of entities that have the given attribute golDarah.
	 *
	 * @param goldarah the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute golDarah
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByGoldarah(@NotNull String goldarah);
	/**
	 * Return an entity or a list of entities that have the given attribute noHP.
	 *
	 * @param nohp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noHP
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByNohp(@NotNull String nohp);
	/**
	 * Return an entity or a list of entities that have the given attribute noKTP.
	 *
	 * @param noktp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKTP
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByNoktp(@NotNull String noktp);
	/**
	 * Return an entity or a list of entities that have the given attribute pstProl.
	 *
	 * @param pstprol the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute pstProl
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByPstprol(@NotNull String pstprol);
	/**
	 * Return an entity or a list of entities that have the given attribute pstPrb.
	 *
	 * @param pstprb the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute pstPrb
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByPstprb(@NotNull String pstprb);
	/**
	 * Return an entity or a list of entities that have the given attribute ketAktif.
	 *
	 * @param ketaktif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketAktif
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByKetaktif(@NotNull String ketaktif);
	/**
	 * Return an entity or a list of entities that have the given attribute kdAsuransi.
	 *
	 * @param kdasuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdAsuransi
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByKdasuransi(@NotNull String kdasuransi);
	/**
	 * Return an entity or a list of entities that have the given attribute nmAsuransi.
	 *
	 * @param nmasuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmAsuransi
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByNmasuransi(@NotNull String nmasuransi);
	/**
	 * Return an entity or a list of entities that have the given attribute noAsuransi.
	 *
	 * @param noasuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noAsuransi
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByNoasuransi(@NotNull String noasuransi);
	/**
	 * Return an entity or a list of entities that have the given attribute cob.
	 *
	 * @param cob the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute cob
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByCob(@NotNull String cob);
	/**
	 * Return an entity or a list of entities that have the given attribute tunggakan.
	 *
	 * @param tunggakan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tunggakan
	 */
	List<BpjsPcarePesertaKegiatanKelompokEntity> findByTunggakan(@NotNull String tunggakan);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcarePesertaKegiatanKelompokEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcarePesertaKegiatanKelompokEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}