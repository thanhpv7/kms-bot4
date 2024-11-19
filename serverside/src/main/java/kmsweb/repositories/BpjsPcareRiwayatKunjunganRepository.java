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

import kmsweb.entities.BpjsPcareRiwayatKunjunganEntity;
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
public interface BpjsPcareRiwayatKunjunganRepository extends AbstractRepository<BpjsPcareRiwayatKunjunganEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute noKunjungan.
	 *
	 * @param nokunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKunjungan
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByNokunjungan(@NotNull String nokunjungan);
	/**
	 * Return an entity or a list of entities that have the given attribute tglkunjungan.
	 *
	 * @param tglkunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglkunjungan
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByTglkunjungan(@NotNull String tglkunjungan);
	/**
	 * Return an entity or a list of entities that have the given attribute providerPelayanan.
	 *
	 * @param providerpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute providerPelayanan
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByProviderpelayanan(@NotNull String providerpelayanan);
	/**
	 * Return an entity or a list of entities that have the given attribute noKartu.
	 *
	 * @param nokartu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKartu
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByNokartu(@NotNull String nokartu);
	/**
	 * Return an entity or a list of entities that have the given attribute nama.
	 *
	 * @param nama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nama
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByNama(@NotNull String nama);
	/**
	 * Return an entity or a list of entities that have the given attribute hubunganKeluarga.
	 *
	 * @param hubungankeluarga the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute hubunganKeluarga
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByHubungankeluarga(@NotNull String hubungankeluarga);
	/**
	 * Return an entity or a list of entities that have the given attribute sex.
	 *
	 * @param sex the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sex
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findBySex(@NotNull String sex);
	/**
	 * Return an entity or a list of entities that have the given attribute tglLahir.
	 *
	 * @param tgllahir the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglLahir
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByTgllahir(@NotNull String tgllahir);
	/**
	 * Return an entity or a list of entities that have the given attribute tglMulaiAktif.
	 *
	 * @param tglmulaiaktif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglMulaiAktif
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByTglmulaiaktif(@NotNull String tglmulaiaktif);
	/**
	 * Return an entity or a list of entities that have the given attribute tglAkhirBerlaku.
	 *
	 * @param tglakhirberlaku the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglAkhirBerlaku
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByTglakhirberlaku(@NotNull String tglakhirberlaku);
	/**
	 * Return an entity or a list of entities that have the given attribute kodePPKPeserta.
	 *
	 * @param kodeppkpeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodePPKPeserta
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByKodeppkpeserta(@NotNull String kodeppkpeserta);
	/**
	 * Return an entity or a list of entities that have the given attribute kodePPKGigi.
	 *
	 * @param kodeppkgigi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodePPKGigi
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByKodeppkgigi(@NotNull String kodeppkgigi);
	/**
	 * Return an entity or a list of entities that have the given attribute jenisKelas.
	 *
	 * @param jeniskelas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute jenisKelas
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByJeniskelas(@NotNull String jeniskelas);
	/**
	 * Return an entity or a list of entities that have the given attribute jenisPeserta.
	 *
	 * @param jenispeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute jenisPeserta
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByJenispeserta(@NotNull String jenispeserta);
	/**
	 * Return an entity or a list of entities that have the given attribute golDarah.
	 *
	 * @param goldarah the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute golDarah
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByGoldarah(@NotNull String goldarah);
	/**
	 * Return an entity or a list of entities that have the given attribute noHP.
	 *
	 * @param nohp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noHP
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByNohp(@NotNull String nohp);
	/**
	 * Return an entity or a list of entities that have the given attribute noKTP.
	 *
	 * @param noktp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKTP
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByNoktp(@NotNull String noktp);
	/**
	 * Return an entity or a list of entities that have the given attribute asuransi.
	 *
	 * @param asuransi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute asuransi
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByAsuransi(@NotNull String asuransi);
	/**
	 * Return an entity or a list of entities that have the given attribute poli.
	 *
	 * @param poli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute poli
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByPoli(@NotNull String poli);
	/**
	 * Return an entity or a list of entities that have the given attribute jenisKunjungan.
	 *
	 * @param jeniskunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute jenisKunjungan
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByJeniskunjungan(@NotNull String jeniskunjungan);
	/**
	 * Return an entity or a list of entities that have the given attribute progProlanis.
	 *
	 * @param progprolanis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute progProlanis
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByProgprolanis(@NotNull String progprolanis);
	/**
	 * Return an entity or a list of entities that have the given attribute keluhan.
	 *
	 * @param keluhan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute keluhan
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByKeluhan(@NotNull String keluhan);
	/**
	 * Return an entity or a list of entities that have the given attribute diagnosa.
	 *
	 * @param diagnosa the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diagnosa
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByDiagnosa(@NotNull String diagnosa);
	/**
	 * Return an entity or a list of entities that have the given attribute diagnosa2.
	 *
	 * @param diagnosa2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diagnosa2
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByDiagnosa2(@NotNull String diagnosa2);
	/**
	 * Return an entity or a list of entities that have the given attribute diagnosa3.
	 *
	 * @param diagnosa3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diagnosa3
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByDiagnosa3(@NotNull String diagnosa3);
	/**
	 * Return an entity or a list of entities that have the given attribute kesadaran.
	 *
	 * @param kesadaran the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kesadaran
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByKesadaran(@NotNull String kesadaran);
	/**
	 * Return an entity or a list of entities that have the given attribute sistole.
	 *
	 * @param sistole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sistole
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findBySistole(@NotNull String sistole);
	/**
	 * Return an entity or a list of entities that have the given attribute diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diastole
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByDiastole(@NotNull String diastole);
	/**
	 * Return an entity or a list of entities that have the given attribute beratBadan.
	 *
	 * @param beratbadan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute beratBadan
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByBeratbadan(@NotNull String beratbadan);
	/**
	 * Return an entity or a list of entities that have the given attribute tinggiBadan.
	 *
	 * @param tinggibadan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tinggiBadan
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByTinggibadan(@NotNull String tinggibadan);
	/**
	 * Return an entity or a list of entities that have the given attribute respiratoryRate.
	 *
	 * @param respiratoryrate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute respiratoryRate
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByRespiratoryrate(@NotNull String respiratoryrate);
	/**
	 * Return an entity or a list of entities that have the given attribute heartRate.
	 *
	 * @param heartrate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute heartRate
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByHeartrate(@NotNull String heartrate);
	/**
	 * Return an entity or a list of entities that have the given attribute catatan.
	 *
	 * @param catatan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute catatan
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByCatatan(@NotNull String catatan);
	/**
	 * Return an entity or a list of entities that have the given attribute pemeriksaanFisikLain.
	 *
	 * @param pemeriksaanfisiklain the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute pemeriksaanFisikLain
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByPemeriksaanfisiklain(@NotNull String pemeriksaanfisiklain);
	/**
	 * Return an entity or a list of entities that have the given attribute tglPulang.
	 *
	 * @param tglpulang the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglPulang
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByTglpulang(@NotNull String tglpulang);
	/**
	 * Return an entity or a list of entities that have the given attribute dokter.
	 *
	 * @param dokter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute dokter
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByDokter(@NotNull String dokter);
	/**
	 * Return an entity or a list of entities that have the given attribute statusPulang.
	 *
	 * @param statuspulang the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute statusPulang
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByStatuspulang(@NotNull String statuspulang);
	/**
	 * Return an entity or a list of entities that have the given attribute tingkatPelayanan.
	 *
	 * @param tingkatpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tingkatPelayanan
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByTingkatpelayanan(@NotNull String tingkatpelayanan);
	/**
	 * Return an entity or a list of entities that have the given attribute rujukBalik.
	 *
	 * @param rujukbalik the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute rujukBalik
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByRujukbalik(@NotNull String rujukbalik);
	/**
	 * Return an entity or a list of entities that have the given attribute providerAsalRujuk.
	 *
	 * @param providerasalrujuk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute providerAsalRujuk
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByProviderasalrujuk(@NotNull String providerasalrujuk);
	/**
	 * Return an entity or a list of entities that have the given attribute providerRujukLanjut.
	 *
	 * @param providerrujuklanjut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute providerRujukLanjut
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByProviderrujuklanjut(@NotNull String providerrujuklanjut);
	/**
	 * Return an entity or a list of entities that have the given attribute poliRujukInternal.
	 *
	 * @param polirujukinternal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute poliRujukInternal
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByPolirujukinternal(@NotNull String polirujukinternal);
	/**
	 * Return an entity or a list of entities that have the given attribute poliRujukLanjut.
	 *
	 * @param polirujuklanjut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute poliRujukLanjut
	 */
	List<BpjsPcareRiwayatKunjunganEntity> findByPolirujuklanjut(@NotNull String polirujuklanjut);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcareRiwayatKunjunganEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcareRiwayatKunjunganEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}