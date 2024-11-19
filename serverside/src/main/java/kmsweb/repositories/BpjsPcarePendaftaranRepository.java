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

import kmsweb.entities.BpjsPcarePendaftaranEntity;
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
public interface BpjsPcarePendaftaranRepository extends AbstractRepository<BpjsPcarePendaftaranEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute noUrut.
	 *
	 * @param nourut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noUrut
	 */
	List<BpjsPcarePendaftaranEntity> findByNourut(@NotNull String nourut);
	/**
	 * Return an entity or a list of entities that have the given attribute tgldaftar.
	 *
	 * @param tgldaftar the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tgldaftar
	 */
	List<BpjsPcarePendaftaranEntity> findByTgldaftar(@NotNull String tgldaftar);
	/**
	 * Return an entity or a list of entities that have the given attribute providerPelayanan.
	 *
	 * @param providerpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute providerPelayanan
	 */
	List<BpjsPcarePendaftaranEntity> findByProviderpelayanan(@NotNull String providerpelayanan);
	/**
	 * Return an entity or a list of entities that have the given attribute noKartu.
	 *
	 * @param nokartu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKartu
	 */
	List<BpjsPcarePendaftaranEntity> findByNokartu(@NotNull String nokartu);
	/**
	 * Return an entity or a list of entities that have the given attribute nama.
	 *
	 * @param nama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nama
	 */
	List<BpjsPcarePendaftaranEntity> findByNama(@NotNull String nama);
	/**
	 * Return an entity or a list of entities that have the given attribute hubunganKeluarga.
	 *
	 * @param hubungankeluarga the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute hubunganKeluarga
	 */
	List<BpjsPcarePendaftaranEntity> findByHubungankeluarga(@NotNull String hubungankeluarga);
	/**
	 * Return an entity or a list of entities that have the given attribute sex.
	 *
	 * @param sex the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sex
	 */
	List<BpjsPcarePendaftaranEntity> findBySex(@NotNull String sex);
	/**
	 * Return an entity or a list of entities that have the given attribute tglLahir.
	 *
	 * @param tgllahir the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglLahir
	 */
	List<BpjsPcarePendaftaranEntity> findByTgllahir(@NotNull String tgllahir);
	/**
	 * Return an entity or a list of entities that have the given attribute tglMulaiAktif.
	 *
	 * @param tglmulaiaktif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglMulaiAktif
	 */
	List<BpjsPcarePendaftaranEntity> findByTglmulaiaktif(@NotNull String tglmulaiaktif);
	/**
	 * Return an entity or a list of entities that have the given attribute tglAkhirBerlaku.
	 *
	 * @param tglakhirberlaku the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglAkhirBerlaku
	 */
	List<BpjsPcarePendaftaranEntity> findByTglakhirberlaku(@NotNull String tglakhirberlaku);
	/**
	 * Return an entity or a list of entities that have the given attribute kdProviderPst.
	 *
	 * @param kdproviderpst the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProviderPst
	 */
	List<BpjsPcarePendaftaranEntity> findByKdproviderpst(@NotNull String kdproviderpst);
	/**
	 * Return an entity or a list of entities that have the given attribute kdProviderGigi.
	 *
	 * @param kdprovidergigi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProviderGigi
	 */
	List<BpjsPcarePendaftaranEntity> findByKdprovidergigi(@NotNull String kdprovidergigi);
	/**
	 * Return an entity or a list of entities that have the given attribute jnsKelas.
	 *
	 * @param jnskelas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute jnsKelas
	 */
	List<BpjsPcarePendaftaranEntity> findByJnskelas(@NotNull String jnskelas);
	/**
	 * Return an entity or a list of entities that have the given attribute jnsPeserta.
	 *
	 * @param jnspeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute jnsPeserta
	 */
	List<BpjsPcarePendaftaranEntity> findByJnspeserta(@NotNull String jnspeserta);
	/**
	 * Return an entity or a list of entities that have the given attribute golDarah.
	 *
	 * @param goldarah the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute golDarah
	 */
	List<BpjsPcarePendaftaranEntity> findByGoldarah(@NotNull String goldarah);
	/**
	 * Return an entity or a list of entities that have the given attribute noHP.
	 *
	 * @param nohp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noHP
	 */
	List<BpjsPcarePendaftaranEntity> findByNohp(@NotNull String nohp);
	/**
	 * Return an entity or a list of entities that have the given attribute noKTP.
	 *
	 * @param noktp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKTP
	 */
	List<BpjsPcarePendaftaranEntity> findByNoktp(@NotNull String noktp);
	/**
	 * Return an entity or a list of entities that have the given attribute aktif.
	 *
	 * @param aktif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute aktif
	 */
	List<BpjsPcarePendaftaranEntity> findByAktif(@NotNull String aktif);
	/**
	 * Return an entity or a list of entities that have the given attribute ketAktif.
	 *
	 * @param ketaktif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketAktif
	 */
	List<BpjsPcarePendaftaranEntity> findByKetaktif(@NotNull String ketaktif);
	/**
	 * Return an entity or a list of entities that have the given attribute asuransi.
	 *
	 * @param asuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute asuransi
	 */
	List<BpjsPcarePendaftaranEntity> findByAsuransi(@NotNull String asuransi);
	/**
	 * Return an entity or a list of entities that have the given attribute kdPoli.
	 *
	 * @param kdpoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdPoli
	 */
	List<BpjsPcarePendaftaranEntity> findByKdpoli(@NotNull String kdpoli);
	/**
	 * Return an entity or a list of entities that have the given attribute nmPoli.
	 *
	 * @param nmpoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmPoli
	 */
	List<BpjsPcarePendaftaranEntity> findByNmpoli(@NotNull String nmpoli);
	/**
	 * Return an entity or a list of entities that have the given attribute poliSakit.
	 *
	 * @param polisakit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute poliSakit
	 */
	List<BpjsPcarePendaftaranEntity> findByPolisakit(@NotNull String polisakit);
	/**
	 * Return an entity or a list of entities that have the given attribute keluhan.
	 *
	 * @param keluhan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute keluhan
	 */
	List<BpjsPcarePendaftaranEntity> findByKeluhan(@NotNull String keluhan);
	/**
	 * Return an entity or a list of entities that have the given attribute kunjSakit.
	 *
	 * @param kunjsakit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kunjSakit
	 */
	List<BpjsPcarePendaftaranEntity> findByKunjsakit(@NotNull String kunjsakit);
	/**
	 * Return an entity or a list of entities that have the given attribute status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute status
	 */
	List<BpjsPcarePendaftaranEntity> findByStatus(@NotNull String status);
	/**
	 * Return an entity or a list of entities that have the given attribute sistole.
	 *
	 * @param sistole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sistole
	 */
	List<BpjsPcarePendaftaranEntity> findBySistole(@NotNull String sistole);
	/**
	 * Return an entity or a list of entities that have the given attribute diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diastole
	 */
	List<BpjsPcarePendaftaranEntity> findByDiastole(@NotNull String diastole);
	/**
	 * Return an entity or a list of entities that have the given attribute beratBadan.
	 *
	 * @param beratbadan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute beratBadan
	 */
	List<BpjsPcarePendaftaranEntity> findByBeratbadan(@NotNull String beratbadan);
	/**
	 * Return an entity or a list of entities that have the given attribute tinggiBadan.
	 *
	 * @param tinggibadan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tinggiBadan
	 */
	List<BpjsPcarePendaftaranEntity> findByTinggibadan(@NotNull String tinggibadan);
	/**
	 * Return an entity or a list of entities that have the given attribute respRate.
	 *
	 * @param resprate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute respRate
	 */
	List<BpjsPcarePendaftaranEntity> findByResprate(@NotNull String resprate);
	/**
	 * Return an entity or a list of entities that have the given attribute heartRate.
	 *
	 * @param heartrate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute heartRate
	 */
	List<BpjsPcarePendaftaranEntity> findByHeartrate(@NotNull String heartrate);
	/**
	 * Return an entity or a list of entities that have the given attribute kdTkp.
	 *
	 * @param kdtkp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdTkp
	 */
	List<BpjsPcarePendaftaranEntity> findByKdtkp(@NotNull String kdtkp);
	/**
	 * Return an entity or a list of entities that have the given attribute nmTkp.
	 *
	 * @param nmtkp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmTkp
	 */
	List<BpjsPcarePendaftaranEntity> findByNmtkp(@NotNull String nmtkp);
	/**
	 * Return an entity or a list of entities that have the given attribute kdProviderPelayanan.
	 *
	 * @param kdproviderpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProviderPelayanan
	 */
	List<BpjsPcarePendaftaranEntity> findByKdproviderpelayanan(@NotNull String kdproviderpelayanan);
	/**
	 * Return an entity or a list of entities that have the given attribute nmProviderPelayanan.
	 *
	 * @param nmproviderpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProviderPelayanan
	 */
	List<BpjsPcarePendaftaranEntity> findByNmproviderpelayanan(@NotNull String nmproviderpelayanan);
	/**
	 * Return an entity or a list of entities that have the given attribute nmProviderPst.
	 *
	 * @param nmproviderpst the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProviderPst
	 */
	List<BpjsPcarePendaftaranEntity> findByNmproviderpst(@NotNull String nmproviderpst);
	/**
	 * Return an entity or a list of entities that have the given attribute nmProviderGigi.
	 *
	 * @param nmprovidergigi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProviderGigi
	 */
	List<BpjsPcarePendaftaranEntity> findByNmprovidergigi(@NotNull String nmprovidergigi);
	/**
	 * Return an entity or a list of entities that have the given attribute kodeKls.
	 *
	 * @param kodekls the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodeKls
	 */
	List<BpjsPcarePendaftaranEntity> findByKodekls(@NotNull String kodekls);
	/**
	 * Return an entity or a list of entities that have the given attribute namaKls.
	 *
	 * @param namakls the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namaKls
	 */
	List<BpjsPcarePendaftaranEntity> findByNamakls(@NotNull String namakls);
	/**
	 * Return an entity or a list of entities that have the given attribute kodePeserta.
	 *
	 * @param kodepeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodePeserta
	 */
	List<BpjsPcarePendaftaranEntity> findByKodepeserta(@NotNull String kodepeserta);
	/**
	 * Return an entity or a list of entities that have the given attribute namaPeserta.
	 *
	 * @param namapeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namaPeserta
	 */
	List<BpjsPcarePendaftaranEntity> findByNamapeserta(@NotNull String namapeserta);
	/**
	 * Return an entity or a list of entities that have the given attribute kdAsuransi.
	 *
	 * @param kdasuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdAsuransi
	 */
	List<BpjsPcarePendaftaranEntity> findByKdasuransi(@NotNull String kdasuransi);
	/**
	 * Return an entity or a list of entities that have the given attribute nmAsuransi.
	 *
	 * @param nmasuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmAsuransi
	 */
	List<BpjsPcarePendaftaranEntity> findByNmasuransi(@NotNull String nmasuransi);
	/**
	 * Return an entity or a list of entities that have the given attribute noAsuransi.
	 *
	 * @param noasuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noAsuransi
	 */
	List<BpjsPcarePendaftaranEntity> findByNoasuransi(@NotNull String noasuransi);
	/**
	 * Return an entity or a list of entities that have the given attribute lingkarPerut.
	 *
	 * @param lingkarperut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute lingkarPerut
	 */
	List<BpjsPcarePendaftaranEntity> findByLingkarperut(@NotNull String lingkarperut);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcarePendaftaranEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcarePendaftaranEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}