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

package kmsweb.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.BpjsPcareRiwayatKunjunganEntityDto;
import kmsweb.entities.listeners.BpjsPcareRiwayatKunjunganEntityListener;
import kmsweb.serializers.BpjsPcareRiwayatKunjunganSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({BpjsPcareRiwayatKunjunganEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPcareRiwayatKunjunganSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPcareRiwayatKunjunganEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPcareRiwayatKunjunganEntityDto and converts it into a BpjsPcareRiwayatKunjunganEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPcareRiwayatKunjunganEntityDto
	 */
	public BpjsPcareRiwayatKunjunganEntity(BpjsPcareRiwayatKunjunganEntityDto bpjsPcareRiwayatKunjunganEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPcareRiwayatKunjunganEntityDto.getId() != null) {
			this.setId(bpjsPcareRiwayatKunjunganEntityDto.getId());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getNokunjungan() != null) {
			this.setNokunjungan(bpjsPcareRiwayatKunjunganEntityDto.getNokunjungan());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getTglkunjungan() != null) {
			this.setTglkunjungan(bpjsPcareRiwayatKunjunganEntityDto.getTglkunjungan());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getProviderpelayanan() != null) {
			this.setProviderpelayanan(bpjsPcareRiwayatKunjunganEntityDto.getProviderpelayanan());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getNokartu() != null) {
			this.setNokartu(bpjsPcareRiwayatKunjunganEntityDto.getNokartu());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getNama() != null) {
			this.setNama(bpjsPcareRiwayatKunjunganEntityDto.getNama());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getHubungankeluarga() != null) {
			this.setHubungankeluarga(bpjsPcareRiwayatKunjunganEntityDto.getHubungankeluarga());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getSex() != null) {
			this.setSex(bpjsPcareRiwayatKunjunganEntityDto.getSex());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getTgllahir() != null) {
			this.setTgllahir(bpjsPcareRiwayatKunjunganEntityDto.getTgllahir());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getTglmulaiaktif() != null) {
			this.setTglmulaiaktif(bpjsPcareRiwayatKunjunganEntityDto.getTglmulaiaktif());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getTglakhirberlaku() != null) {
			this.setTglakhirberlaku(bpjsPcareRiwayatKunjunganEntityDto.getTglakhirberlaku());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getKodeppkpeserta() != null) {
			this.setKodeppkpeserta(bpjsPcareRiwayatKunjunganEntityDto.getKodeppkpeserta());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getKodeppkgigi() != null) {
			this.setKodeppkgigi(bpjsPcareRiwayatKunjunganEntityDto.getKodeppkgigi());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getJeniskelas() != null) {
			this.setJeniskelas(bpjsPcareRiwayatKunjunganEntityDto.getJeniskelas());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getJenispeserta() != null) {
			this.setJenispeserta(bpjsPcareRiwayatKunjunganEntityDto.getJenispeserta());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getGoldarah() != null) {
			this.setGoldarah(bpjsPcareRiwayatKunjunganEntityDto.getGoldarah());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getNohp() != null) {
			this.setNohp(bpjsPcareRiwayatKunjunganEntityDto.getNohp());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getNoktp() != null) {
			this.setNoktp(bpjsPcareRiwayatKunjunganEntityDto.getNoktp());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getAsuransi() != null) {
			this.setAsuransi(bpjsPcareRiwayatKunjunganEntityDto.getAsuransi());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getPoli() != null) {
			this.setPoli(bpjsPcareRiwayatKunjunganEntityDto.getPoli());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getJeniskunjungan() != null) {
			this.setJeniskunjungan(bpjsPcareRiwayatKunjunganEntityDto.getJeniskunjungan());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getProgprolanis() != null) {
			this.setProgprolanis(bpjsPcareRiwayatKunjunganEntityDto.getProgprolanis());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getKeluhan() != null) {
			this.setKeluhan(bpjsPcareRiwayatKunjunganEntityDto.getKeluhan());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getDiagnosa() != null) {
			this.setDiagnosa(bpjsPcareRiwayatKunjunganEntityDto.getDiagnosa());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getDiagnosa2() != null) {
			this.setDiagnosa2(bpjsPcareRiwayatKunjunganEntityDto.getDiagnosa2());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getDiagnosa3() != null) {
			this.setDiagnosa3(bpjsPcareRiwayatKunjunganEntityDto.getDiagnosa3());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getKesadaran() != null) {
			this.setKesadaran(bpjsPcareRiwayatKunjunganEntityDto.getKesadaran());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getSistole() != null) {
			this.setSistole(bpjsPcareRiwayatKunjunganEntityDto.getSistole());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getDiastole() != null) {
			this.setDiastole(bpjsPcareRiwayatKunjunganEntityDto.getDiastole());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getBeratbadan() != null) {
			this.setBeratbadan(bpjsPcareRiwayatKunjunganEntityDto.getBeratbadan());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getTinggibadan() != null) {
			this.setTinggibadan(bpjsPcareRiwayatKunjunganEntityDto.getTinggibadan());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getRespiratoryrate() != null) {
			this.setRespiratoryrate(bpjsPcareRiwayatKunjunganEntityDto.getRespiratoryrate());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getHeartrate() != null) {
			this.setHeartrate(bpjsPcareRiwayatKunjunganEntityDto.getHeartrate());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getCatatan() != null) {
			this.setCatatan(bpjsPcareRiwayatKunjunganEntityDto.getCatatan());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getPemeriksaanfisiklain() != null) {
			this.setPemeriksaanfisiklain(bpjsPcareRiwayatKunjunganEntityDto.getPemeriksaanfisiklain());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getTglpulang() != null) {
			this.setTglpulang(bpjsPcareRiwayatKunjunganEntityDto.getTglpulang());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getDokter() != null) {
			this.setDokter(bpjsPcareRiwayatKunjunganEntityDto.getDokter());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getStatuspulang() != null) {
			this.setStatuspulang(bpjsPcareRiwayatKunjunganEntityDto.getStatuspulang());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getTingkatpelayanan() != null) {
			this.setTingkatpelayanan(bpjsPcareRiwayatKunjunganEntityDto.getTingkatpelayanan());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getRujukbalik() != null) {
			this.setRujukbalik(bpjsPcareRiwayatKunjunganEntityDto.getRujukbalik());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getProviderasalrujuk() != null) {
			this.setProviderasalrujuk(bpjsPcareRiwayatKunjunganEntityDto.getProviderasalrujuk());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getProviderrujuklanjut() != null) {
			this.setProviderrujuklanjut(bpjsPcareRiwayatKunjunganEntityDto.getProviderrujuklanjut());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getPolirujukinternal() != null) {
			this.setPolirujukinternal(bpjsPcareRiwayatKunjunganEntityDto.getPolirujukinternal());
		}

		if (bpjsPcareRiwayatKunjunganEntityDto.getPolirujuklanjut() != null) {
			this.setPolirujuklanjut(bpjsPcareRiwayatKunjunganEntityDto.getPolirujuklanjut());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for noKunjungan here] off begin
	@CsvBindByName(column = "NOKUNJUNGAN", required = false)
	@Nullable
	@Column(name = "nokunjungan")
	@Schema(description = "The noKunjungan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noKunjungan here] end
	private String nokunjungan;

	// % protected region % [Modify attribute annotation for tglkunjungan here] off begin
	@CsvBindByName(column = "TGLKUNJUNGAN", required = false)
	@Nullable
	@Column(name = "tglkunjungan")
	@Schema(description = "The tglkunjungan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglkunjungan here] end
	private String tglkunjungan;

	// % protected region % [Modify attribute annotation for providerPelayanan here] off begin
	@CsvBindByName(column = "PROVIDERPELAYANAN", required = false)
	@Nullable
	@Column(name = "providerpelayanan")
	@Schema(description = "The providerPelayanan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for providerPelayanan here] end
	private String providerpelayanan;

	// % protected region % [Modify attribute annotation for noKartu here] off begin
	@CsvBindByName(column = "NOKARTU", required = false)
	@Nullable
	@Column(name = "nokartu")
	@Schema(description = "The noKartu of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noKartu here] end
	private String nokartu;

	// % protected region % [Modify attribute annotation for nama here] off begin
	@CsvBindByName(column = "NAMA", required = false)
	@Nullable
	@Column(name = "nama")
	@Schema(description = "The nama of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nama here] end
	private String nama;

	// % protected region % [Modify attribute annotation for hubunganKeluarga here] off begin
	@CsvBindByName(column = "HUBUNGANKELUARGA", required = false)
	@Nullable
	@Column(name = "hubungankeluarga")
	@Schema(description = "The hubunganKeluarga of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for hubunganKeluarga here] end
	private String hubungankeluarga;

	// % protected region % [Modify attribute annotation for sex here] off begin
	@CsvBindByName(column = "SEX", required = false)
	@Nullable
	@Column(name = "sex")
	@Schema(description = "The sex of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for sex here] end
	private String sex;

	// % protected region % [Modify attribute annotation for tglLahir here] off begin
	@CsvBindByName(column = "TGLLAHIR", required = false)
	@Nullable
	@Column(name = "tgllahir")
	@Schema(description = "The tglLahir of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglLahir here] end
	private String tgllahir;

	// % protected region % [Modify attribute annotation for tglMulaiAktif here] off begin
	@CsvBindByName(column = "TGLMULAIAKTIF", required = false)
	@Nullable
	@Column(name = "tglmulaiaktif")
	@Schema(description = "The tglMulaiAktif of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglMulaiAktif here] end
	private String tglmulaiaktif;

	// % protected region % [Modify attribute annotation for tglAkhirBerlaku here] off begin
	@CsvBindByName(column = "TGLAKHIRBERLAKU", required = false)
	@Nullable
	@Column(name = "tglakhirberlaku")
	@Schema(description = "The tglAkhirBerlaku of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglAkhirBerlaku here] end
	private String tglakhirberlaku;

	// % protected region % [Modify attribute annotation for kodePPKPeserta here] off begin
	@CsvBindByName(column = "KODEPPKPESERTA", required = false)
	@Nullable
	@Column(name = "kodeppkpeserta")
	@Schema(description = "The kodePPKPeserta of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodePPKPeserta here] end
	private String kodeppkpeserta;

	// % protected region % [Modify attribute annotation for kodePPKGigi here] off begin
	@CsvBindByName(column = "KODEPPKGIGI", required = false)
	@Nullable
	@Column(name = "kodeppkgigi")
	@Schema(description = "The kodePPKGigi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodePPKGigi here] end
	private String kodeppkgigi;

	// % protected region % [Modify attribute annotation for jenisKelas here] off begin
	@CsvBindByName(column = "JENISKELAS", required = false)
	@Nullable
	@Column(name = "jeniskelas")
	@Schema(description = "The jenisKelas of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for jenisKelas here] end
	private String jeniskelas;

	// % protected region % [Modify attribute annotation for jenisPeserta here] off begin
	@CsvBindByName(column = "JENISPESERTA", required = false)
	@Nullable
	@Column(name = "jenispeserta")
	@Schema(description = "The jenisPeserta of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for jenisPeserta here] end
	private String jenispeserta;

	// % protected region % [Modify attribute annotation for golDarah here] off begin
	@CsvBindByName(column = "GOLDARAH", required = false)
	@Nullable
	@Column(name = "goldarah")
	@Schema(description = "The golDarah of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for golDarah here] end
	private String goldarah;

	// % protected region % [Modify attribute annotation for noHP here] off begin
	@CsvBindByName(column = "NOHP", required = false)
	@Nullable
	@Column(name = "nohp")
	@Schema(description = "The noHP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noHP here] end
	private String nohp;

	// % protected region % [Modify attribute annotation for noKTP here] off begin
	@CsvBindByName(column = "NOKTP", required = false)
	@Nullable
	@Column(name = "noktp")
	@Schema(description = "The noKTP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noKTP here] end
	private String noktp;

	// % protected region % [Modify attribute annotation for asuransi here] off begin
	@CsvBindByName(column = "ASURANSI", required = false)
	@Nullable
	@Column(name = "asuransi")
	@Schema(description = "The asuransi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for asuransi here] end
	private String asuransi;

	// % protected region % [Modify attribute annotation for poli here] off begin
	@CsvBindByName(column = "POLI", required = false)
	@Nullable
	@Column(name = "poli")
	@Schema(description = "The poli of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for poli here] end
	private String poli;

	// % protected region % [Modify attribute annotation for jenisKunjungan here] off begin
	@CsvBindByName(column = "JENISKUNJUNGAN", required = false)
	@Nullable
	@Column(name = "jeniskunjungan")
	@Schema(description = "The jenisKunjungan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for jenisKunjungan here] end
	private String jeniskunjungan;

	// % protected region % [Modify attribute annotation for progProlanis here] off begin
	@CsvBindByName(column = "PROGPROLANIS", required = false)
	@Nullable
	@Column(name = "progprolanis")
	@Schema(description = "The progProlanis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for progProlanis here] end
	private String progprolanis;

	// % protected region % [Modify attribute annotation for keluhan here] off begin
	@CsvBindByName(column = "KELUHAN", required = false)
	@Nullable
	@Column(name = "keluhan")
	@Schema(description = "The keluhan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for keluhan here] end
	private String keluhan;

	// % protected region % [Modify attribute annotation for diagnosa here] off begin
	@CsvBindByName(column = "DIAGNOSA", required = false)
	@Nullable
	@Column(name = "diagnosa")
	@Schema(description = "The diagnosa of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for diagnosa here] end
	private String diagnosa;

	// % protected region % [Modify attribute annotation for diagnosa2 here] off begin
	@CsvBindByName(column = "DIAGNOSA2", required = false)
	@Nullable
	@Column(name = "diagnosa2")
	@Schema(description = "The diagnosa2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for diagnosa2 here] end
	private String diagnosa2;

	// % protected region % [Modify attribute annotation for diagnosa3 here] off begin
	@CsvBindByName(column = "DIAGNOSA3", required = false)
	@Nullable
	@Column(name = "diagnosa3")
	@Schema(description = "The diagnosa3 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for diagnosa3 here] end
	private String diagnosa3;

	// % protected region % [Modify attribute annotation for kesadaran here] off begin
	@CsvBindByName(column = "KESADARAN", required = false)
	@Nullable
	@Column(name = "kesadaran")
	@Schema(description = "The kesadaran of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kesadaran here] end
	private String kesadaran;

	// % protected region % [Modify attribute annotation for sistole here] off begin
	@CsvBindByName(column = "SISTOLE", required = false)
	@Nullable
	@Column(name = "sistole")
	@Schema(description = "The sistole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for sistole here] end
	private String sistole;

	// % protected region % [Modify attribute annotation for diastole here] off begin
	@CsvBindByName(column = "DIASTOLE", required = false)
	@Nullable
	@Column(name = "diastole")
	@Schema(description = "The diastole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for diastole here] end
	private String diastole;

	// % protected region % [Modify attribute annotation for beratBadan here] off begin
	@CsvBindByName(column = "BERATBADAN", required = false)
	@Nullable
	@Column(name = "beratbadan")
	@Schema(description = "The beratBadan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for beratBadan here] end
	private String beratbadan;

	// % protected region % [Modify attribute annotation for tinggiBadan here] off begin
	@CsvBindByName(column = "TINGGIBADAN", required = false)
	@Nullable
	@Column(name = "tinggibadan")
	@Schema(description = "The tinggiBadan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tinggiBadan here] end
	private String tinggibadan;

	// % protected region % [Modify attribute annotation for respiratoryRate here] off begin
	@CsvBindByName(column = "RESPIRATORYRATE", required = false)
	@Nullable
	@Column(name = "respiratoryrate")
	@Schema(description = "The respiratoryRate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for respiratoryRate here] end
	private String respiratoryrate;

	// % protected region % [Modify attribute annotation for heartRate here] off begin
	@CsvBindByName(column = "HEARTRATE", required = false)
	@Nullable
	@Column(name = "heartrate")
	@Schema(description = "The heartRate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for heartRate here] end
	private String heartrate;

	// % protected region % [Modify attribute annotation for catatan here] off begin
	@CsvBindByName(column = "CATATAN", required = false)
	@Nullable
	@Column(name = "catatan")
	@Schema(description = "The catatan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for catatan here] end
	private String catatan;

	// % protected region % [Modify attribute annotation for pemeriksaanFisikLain here] off begin
	@CsvBindByName(column = "PEMERIKSAANFISIKLAIN", required = false)
	@Nullable
	@Column(name = "pemeriksaanfisiklain")
	@Schema(description = "The pemeriksaanFisikLain of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for pemeriksaanFisikLain here] end
	private String pemeriksaanfisiklain;

	// % protected region % [Modify attribute annotation for tglPulang here] off begin
	@CsvBindByName(column = "TGLPULANG", required = false)
	@Nullable
	@Column(name = "tglpulang")
	@Schema(description = "The tglPulang of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglPulang here] end
	private String tglpulang;

	// % protected region % [Modify attribute annotation for dokter here] off begin
	@CsvBindByName(column = "DOKTER", required = false)
	@Nullable
	@Column(name = "dokter")
	@Schema(description = "The dokter of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for dokter here] end
	private String dokter;

	// % protected region % [Modify attribute annotation for statusPulang here] off begin
	@CsvBindByName(column = "STATUSPULANG", required = false)
	@Nullable
	@Column(name = "statuspulang")
	@Schema(description = "The statusPulang of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for statusPulang here] end
	private String statuspulang;

	// % protected region % [Modify attribute annotation for tingkatPelayanan here] off begin
	@CsvBindByName(column = "TINGKATPELAYANAN", required = false)
	@Nullable
	@Column(name = "tingkatpelayanan")
	@Schema(description = "The tingkatPelayanan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tingkatPelayanan here] end
	private String tingkatpelayanan;

	// % protected region % [Modify attribute annotation for rujukBalik here] off begin
	@CsvBindByName(column = "RUJUKBALIK", required = false)
	@Nullable
	@Column(name = "rujukbalik")
	@Schema(description = "The rujukBalik of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for rujukBalik here] end
	private String rujukbalik;

	// % protected region % [Modify attribute annotation for providerAsalRujuk here] off begin
	@CsvBindByName(column = "PROVIDERASALRUJUK", required = false)
	@Nullable
	@Column(name = "providerasalrujuk")
	@Schema(description = "The providerAsalRujuk of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for providerAsalRujuk here] end
	private String providerasalrujuk;

	// % protected region % [Modify attribute annotation for providerRujukLanjut here] off begin
	@CsvBindByName(column = "PROVIDERRUJUKLANJUT", required = false)
	@Nullable
	@Column(name = "providerrujuklanjut")
	@Schema(description = "The providerRujukLanjut of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for providerRujukLanjut here] end
	private String providerrujuklanjut;

	// % protected region % [Modify attribute annotation for poliRujukInternal here] off begin
	@CsvBindByName(column = "POLIRUJUKINTERNAL", required = false)
	@Nullable
	@Column(name = "polirujukinternal")
	@Schema(description = "The poliRujukInternal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for poliRujukInternal here] end
	private String polirujukinternal;

	// % protected region % [Modify attribute annotation for poliRujukLanjut here] off begin
	@CsvBindByName(column = "POLIRUJUKLANJUT", required = false)
	@Nullable
	@Column(name = "polirujuklanjut")
	@Schema(description = "The poliRujukLanjut of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for poliRujukLanjut here] end
	private String polirujuklanjut;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "NOKUNJUNGAN,TGLKUNJUNGAN,PROVIDERPELAYANAN,NOKARTU,NAMA,HUBUNGANKELUARGA,SEX,TGLLAHIR,TGLMULAIAKTIF,TGLAKHIRBERLAKU,KODEPPKPESERTA,KODEPPKGIGI,JENISKELAS,JENISPESERTA,GOLDARAH,NOHP,NOKTP,ASURANSI,POLI,JENISKUNJUNGAN,PROGPROLANIS,KELUHAN,DIAGNOSA,DIAGNOSA2,DIAGNOSA3,KESADARAN,SISTOLE,DIASTOLE,BERATBADAN,TINGGIBADAN,RESPIRATORYRATE,HEARTRATE,CATATAN,PEMERIKSAANFISIKLAIN,TGLPULANG,DOKTER,STATUSPULANG,TINGKATPELAYANAN,RUJUKBALIK,PROVIDERASALRUJUK,PROVIDERRUJUKLANJUT,POLIRUJUKINTERNAL,POLIRUJUKLANJUT,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsPcareRiwayatKunjungan) {
		if (this == bpjsPcareRiwayatKunjungan) {
			return true;
		}
		if (bpjsPcareRiwayatKunjungan == null || this.getClass() != bpjsPcareRiwayatKunjungan.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPcareRiwayatKunjungan)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPcareRiwayatKunjunganEntity that = (BpjsPcareRiwayatKunjunganEntity) bpjsPcareRiwayatKunjungan;
		return
			Objects.equals(this.nokunjungan, that.nokunjungan) &&
			Objects.equals(this.tglkunjungan, that.tglkunjungan) &&
			Objects.equals(this.providerpelayanan, that.providerpelayanan) &&
			Objects.equals(this.nokartu, that.nokartu) &&
			Objects.equals(this.nama, that.nama) &&
			Objects.equals(this.hubungankeluarga, that.hubungankeluarga) &&
			Objects.equals(this.sex, that.sex) &&
			Objects.equals(this.tgllahir, that.tgllahir) &&
			Objects.equals(this.tglmulaiaktif, that.tglmulaiaktif) &&
			Objects.equals(this.tglakhirberlaku, that.tglakhirberlaku) &&
			Objects.equals(this.kodeppkpeserta, that.kodeppkpeserta) &&
			Objects.equals(this.kodeppkgigi, that.kodeppkgigi) &&
			Objects.equals(this.jeniskelas, that.jeniskelas) &&
			Objects.equals(this.jenispeserta, that.jenispeserta) &&
			Objects.equals(this.goldarah, that.goldarah) &&
			Objects.equals(this.nohp, that.nohp) &&
			Objects.equals(this.noktp, that.noktp) &&
			Objects.equals(this.asuransi, that.asuransi) &&
			Objects.equals(this.poli, that.poli) &&
			Objects.equals(this.jeniskunjungan, that.jeniskunjungan) &&
			Objects.equals(this.progprolanis, that.progprolanis) &&
			Objects.equals(this.keluhan, that.keluhan) &&
			Objects.equals(this.diagnosa, that.diagnosa) &&
			Objects.equals(this.diagnosa2, that.diagnosa2) &&
			Objects.equals(this.diagnosa3, that.diagnosa3) &&
			Objects.equals(this.kesadaran, that.kesadaran) &&
			Objects.equals(this.sistole, that.sistole) &&
			Objects.equals(this.diastole, that.diastole) &&
			Objects.equals(this.beratbadan, that.beratbadan) &&
			Objects.equals(this.tinggibadan, that.tinggibadan) &&
			Objects.equals(this.respiratoryrate, that.respiratoryrate) &&
			Objects.equals(this.heartrate, that.heartrate) &&
			Objects.equals(this.catatan, that.catatan) &&
			Objects.equals(this.pemeriksaanfisiklain, that.pemeriksaanfisiklain) &&
			Objects.equals(this.tglpulang, that.tglpulang) &&
			Objects.equals(this.dokter, that.dokter) &&
			Objects.equals(this.statuspulang, that.statuspulang) &&
			Objects.equals(this.tingkatpelayanan, that.tingkatpelayanan) &&
			Objects.equals(this.rujukbalik, that.rujukbalik) &&
			Objects.equals(this.providerasalrujuk, that.providerasalrujuk) &&
			Objects.equals(this.providerrujuklanjut, that.providerrujuklanjut) &&
			Objects.equals(this.polirujukinternal, that.polirujukinternal) &&
			Objects.equals(this.polirujuklanjut, that.polirujuklanjut);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
