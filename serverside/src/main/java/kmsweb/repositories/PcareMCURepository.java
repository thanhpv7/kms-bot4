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

import kmsweb.entities.PcareMCUEntity;
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
public interface PcareMCURepository extends AbstractRepository<PcareMCUEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Kode MCU.
	 *
	 * @param kodeMCU the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kode MCU
	 */
	List<PcareMCUEntity> findByKodeMCU(@NotNull String kodeMCU);
	/**
	 * Return an entity or a list of entities that have the given attribute No Kunjungan.
	 *
	 * @param noKunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute No Kunjungan
	 */
	List<PcareMCUEntity> findByNoKunjungan(@NotNull String noKunjungan);
	/**
	 * Return an entity or a list of entities that have the given attribute Kode Provider.
	 *
	 * @param kodeProvider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kode Provider
	 */
	List<PcareMCUEntity> findByKodeProvider(@NotNull String kodeProvider);
	/**
	 * Return an entity or a list of entities that have the given attribute Nama Provider.
	 *
	 * @param namaProvider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nama Provider
	 */
	List<PcareMCUEntity> findByNamaProvider(@NotNull String namaProvider);
	/**
	 * Return an entity or a list of entities that have the given attribute Tanggal Pelayanan.
	 *
	 * @param tanggalPelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tanggal Pelayanan
	 */
	List<PcareMCUEntity> findByTanggalPelayanan(@NotNull String tanggalPelayanan);
	/**
	 * Return an entity or a list of entities that have the given attribute Sistole.
	 *
	 * @param sistole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sistole
	 */
	List<PcareMCUEntity> findBySistole(@NotNull String sistole);
	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	List<PcareMCUEntity> findByDiastole(@NotNull String diastole);
	/**
	 * Return an entity or a list of entities that have the given attribute Radiologi Foto.
	 *
	 * @param radiologiFoto the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Radiologi Foto
	 */
	List<PcareMCUEntity> findByRadiologiFoto(@NotNull String radiologiFoto);
	/**
	 * Return an entity or a list of entities that have the given attribute Hemoglobin.
	 *
	 * @param hemoglobin the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hemoglobin
	 */
	List<PcareMCUEntity> findByHemoglobin(@NotNull String hemoglobin);
	/**
	 * Return an entity or a list of entities that have the given attribute Leukosit.
	 *
	 * @param leukosit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Leukosit
	 */
	List<PcareMCUEntity> findByLeukosit(@NotNull String leukosit);
	/**
	 * Return an entity or a list of entities that have the given attribute Eritrosit.
	 *
	 * @param eritrosit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Eritrosit
	 */
	List<PcareMCUEntity> findByEritrosit(@NotNull String eritrosit);
	/**
	 * Return an entity or a list of entities that have the given attribute Laju Endap Darah.
	 *
	 * @param lajuEndapDarah the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Laju Endap Darah
	 */
	List<PcareMCUEntity> findByLajuEndapDarah(@NotNull String lajuEndapDarah);
	/**
	 * Return an entity or a list of entities that have the given attribute Hematokrit.
	 *
	 * @param hematokrit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hematokrit
	 */
	List<PcareMCUEntity> findByHematokrit(@NotNull String hematokrit);
	/**
	 * Return an entity or a list of entities that have the given attribute Trombosit.
	 *
	 * @param trombosit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Trombosit
	 */
	List<PcareMCUEntity> findByTrombosit(@NotNull String trombosit);
	/**
	 * Return an entity or a list of entities that have the given attribute HDL.
	 *
	 * @param hdl the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HDL
	 */
	List<PcareMCUEntity> findByHdl(@NotNull String hdl);
	/**
	 * Return an entity or a list of entities that have the given attribute LDL.
	 *
	 * @param ldl the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute LDL
	 */
	List<PcareMCUEntity> findByLdl(@NotNull String ldl);
	/**
	 * Return an entity or a list of entities that have the given attribute Cholesterol.
	 *
	 * @param cholesterol the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cholesterol
	 */
	List<PcareMCUEntity> findByCholesterol(@NotNull String cholesterol);
	/**
	 * Return an entity or a list of entities that have the given attribute Trigliserida.
	 *
	 * @param trigliserida the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Trigliserida
	 */
	List<PcareMCUEntity> findByTrigliserida(@NotNull String trigliserida);
	/**
	 * Return an entity or a list of entities that have the given attribute Sewaktu.
	 *
	 * @param sewaktu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sewaktu
	 */
	List<PcareMCUEntity> findBySewaktu(@NotNull String sewaktu);
	/**
	 * Return an entity or a list of entities that have the given attribute Puasa.
	 *
	 * @param puasa the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Puasa
	 */
	List<PcareMCUEntity> findByPuasa(@NotNull String puasa);
	/**
	 * Return an entity or a list of entities that have the given attribute Post Prandial.
	 *
	 * @param postPrandial the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Post Prandial
	 */
	List<PcareMCUEntity> findByPostPrandial(@NotNull String postPrandial);
	/**
	 * Return an entity or a list of entities that have the given attribute HbA1c.
	 *
	 * @param hba1c the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HbA1c
	 */
	List<PcareMCUEntity> findByHba1c(@NotNull String hba1c);
	/**
	 * Return an entity or a list of entities that have the given attribute SGOT.
	 *
	 * @param sgot the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SGOT
	 */
	List<PcareMCUEntity> findBySgot(@NotNull String sgot);
	/**
	 * Return an entity or a list of entities that have the given attribute SGPT.
	 *
	 * @param sgpt the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SGPT
	 */
	List<PcareMCUEntity> findBySgpt(@NotNull String sgpt);
	/**
	 * Return an entity or a list of entities that have the given attribute Gamma.
	 *
	 * @param gamma the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gamma
	 */
	List<PcareMCUEntity> findByGamma(@NotNull String gamma);
	/**
	 * Return an entity or a list of entities that have the given attribute Protein Kualitatif.
	 *
	 * @param proteinKualitatif the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Protein Kualitatif
	 */
	List<PcareMCUEntity> findByProteinKualitatif(@NotNull String proteinKualitatif);
	/**
	 * Return an entity or a list of entities that have the given attribute Albumin.
	 *
	 * @param albumin the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Albumin
	 */
	List<PcareMCUEntity> findByAlbumin(@NotNull String albumin);
	/**
	 * Return an entity or a list of entities that have the given attribute Creatinine.
	 *
	 * @param creatinine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Creatinine
	 */
	List<PcareMCUEntity> findByCreatinine(@NotNull String creatinine);
	/**
	 * Return an entity or a list of entities that have the given attribute Ureum.
	 *
	 * @param ureum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ureum
	 */
	List<PcareMCUEntity> findByUreum(@NotNull String ureum);
	/**
	 * Return an entity or a list of entities that have the given attribute Asam.
	 *
	 * @param asam the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Asam
	 */
	List<PcareMCUEntity> findByAsam(@NotNull String asam);
	/**
	 * Return an entity or a list of entities that have the given attribute ABI.
	 *
	 * @param abi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ABI
	 */
	List<PcareMCUEntity> findByAbi(@NotNull String abi);
	/**
	 * Return an entity or a list of entities that have the given attribute EKG.
	 *
	 * @param ekg the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute EKG
	 */
	List<PcareMCUEntity> findByEkg(@NotNull String ekg);
	/**
	 * Return an entity or a list of entities that have the given attribute Echo.
	 *
	 * @param echo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Echo
	 */
	List<PcareMCUEntity> findByEcho(@NotNull String echo);
	/**
	 * Return an entity or a list of entities that have the given attribute Funduskopi.
	 *
	 * @param funduskopi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Funduskopi
	 */
	List<PcareMCUEntity> findByFunduskopi(@NotNull String funduskopi);
	/**
	 * Return an entity or a list of entities that have the given attribute Pemeriksaan Lain.
	 *
	 * @param pemeriksaanLain the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pemeriksaan Lain
	 */
	List<PcareMCUEntity> findByPemeriksaanLain(@NotNull String pemeriksaanLain);
	/**
	 * Return an entity or a list of entities that have the given attribute Keterangan.
	 *
	 * @param keterangan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Keterangan
	 */
	List<PcareMCUEntity> findByKeterangan(@NotNull String keterangan);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PcareMCUEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PcareMCUEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}