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
import kmsweb.dtos.BpjsPcarePendaftaranEntityDto;
import kmsweb.entities.listeners.BpjsPcarePendaftaranEntityListener;
import kmsweb.serializers.BpjsPcarePendaftaranSerializer;
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
@EntityListeners({BpjsPcarePendaftaranEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPcarePendaftaranSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPcarePendaftaranEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPcarePendaftaranEntityDto and converts it into a BpjsPcarePendaftaranEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPcarePendaftaranEntityDto
	 */
	public BpjsPcarePendaftaranEntity(BpjsPcarePendaftaranEntityDto bpjsPcarePendaftaranEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPcarePendaftaranEntityDto.getId() != null) {
			this.setId(bpjsPcarePendaftaranEntityDto.getId());
		}

		if (bpjsPcarePendaftaranEntityDto.getNourut() != null) {
			this.setNourut(bpjsPcarePendaftaranEntityDto.getNourut());
		}

		if (bpjsPcarePendaftaranEntityDto.getTgldaftar() != null) {
			this.setTgldaftar(bpjsPcarePendaftaranEntityDto.getTgldaftar());
		}

		if (bpjsPcarePendaftaranEntityDto.getProviderpelayanan() != null) {
			this.setProviderpelayanan(bpjsPcarePendaftaranEntityDto.getProviderpelayanan());
		}

		if (bpjsPcarePendaftaranEntityDto.getNokartu() != null) {
			this.setNokartu(bpjsPcarePendaftaranEntityDto.getNokartu());
		}

		if (bpjsPcarePendaftaranEntityDto.getNama() != null) {
			this.setNama(bpjsPcarePendaftaranEntityDto.getNama());
		}

		if (bpjsPcarePendaftaranEntityDto.getHubungankeluarga() != null) {
			this.setHubungankeluarga(bpjsPcarePendaftaranEntityDto.getHubungankeluarga());
		}

		if (bpjsPcarePendaftaranEntityDto.getSex() != null) {
			this.setSex(bpjsPcarePendaftaranEntityDto.getSex());
		}

		if (bpjsPcarePendaftaranEntityDto.getTgllahir() != null) {
			this.setTgllahir(bpjsPcarePendaftaranEntityDto.getTgllahir());
		}

		if (bpjsPcarePendaftaranEntityDto.getTglmulaiaktif() != null) {
			this.setTglmulaiaktif(bpjsPcarePendaftaranEntityDto.getTglmulaiaktif());
		}

		if (bpjsPcarePendaftaranEntityDto.getTglakhirberlaku() != null) {
			this.setTglakhirberlaku(bpjsPcarePendaftaranEntityDto.getTglakhirberlaku());
		}

		if (bpjsPcarePendaftaranEntityDto.getKdproviderpst() != null) {
			this.setKdproviderpst(bpjsPcarePendaftaranEntityDto.getKdproviderpst());
		}

		if (bpjsPcarePendaftaranEntityDto.getKdprovidergigi() != null) {
			this.setKdprovidergigi(bpjsPcarePendaftaranEntityDto.getKdprovidergigi());
		}

		if (bpjsPcarePendaftaranEntityDto.getJnskelas() != null) {
			this.setJnskelas(bpjsPcarePendaftaranEntityDto.getJnskelas());
		}

		if (bpjsPcarePendaftaranEntityDto.getJnspeserta() != null) {
			this.setJnspeserta(bpjsPcarePendaftaranEntityDto.getJnspeserta());
		}

		if (bpjsPcarePendaftaranEntityDto.getGoldarah() != null) {
			this.setGoldarah(bpjsPcarePendaftaranEntityDto.getGoldarah());
		}

		if (bpjsPcarePendaftaranEntityDto.getNohp() != null) {
			this.setNohp(bpjsPcarePendaftaranEntityDto.getNohp());
		}

		if (bpjsPcarePendaftaranEntityDto.getNoktp() != null) {
			this.setNoktp(bpjsPcarePendaftaranEntityDto.getNoktp());
		}

		if (bpjsPcarePendaftaranEntityDto.getAktif() != null) {
			this.setAktif(bpjsPcarePendaftaranEntityDto.getAktif());
		}

		if (bpjsPcarePendaftaranEntityDto.getKetaktif() != null) {
			this.setKetaktif(bpjsPcarePendaftaranEntityDto.getKetaktif());
		}

		if (bpjsPcarePendaftaranEntityDto.getAsuransi() != null) {
			this.setAsuransi(bpjsPcarePendaftaranEntityDto.getAsuransi());
		}

		if (bpjsPcarePendaftaranEntityDto.getKdpoli() != null) {
			this.setKdpoli(bpjsPcarePendaftaranEntityDto.getKdpoli());
		}

		if (bpjsPcarePendaftaranEntityDto.getNmpoli() != null) {
			this.setNmpoli(bpjsPcarePendaftaranEntityDto.getNmpoli());
		}

		if (bpjsPcarePendaftaranEntityDto.getPolisakit() != null) {
			this.setPolisakit(bpjsPcarePendaftaranEntityDto.getPolisakit());
		}

		if (bpjsPcarePendaftaranEntityDto.getKeluhan() != null) {
			this.setKeluhan(bpjsPcarePendaftaranEntityDto.getKeluhan());
		}

		if (bpjsPcarePendaftaranEntityDto.getKunjsakit() != null) {
			this.setKunjsakit(bpjsPcarePendaftaranEntityDto.getKunjsakit());
		}

		if (bpjsPcarePendaftaranEntityDto.getStatus() != null) {
			this.setStatus(bpjsPcarePendaftaranEntityDto.getStatus());
		}

		if (bpjsPcarePendaftaranEntityDto.getSistole() != null) {
			this.setSistole(bpjsPcarePendaftaranEntityDto.getSistole());
		}

		if (bpjsPcarePendaftaranEntityDto.getDiastole() != null) {
			this.setDiastole(bpjsPcarePendaftaranEntityDto.getDiastole());
		}

		if (bpjsPcarePendaftaranEntityDto.getBeratbadan() != null) {
			this.setBeratbadan(bpjsPcarePendaftaranEntityDto.getBeratbadan());
		}

		if (bpjsPcarePendaftaranEntityDto.getTinggibadan() != null) {
			this.setTinggibadan(bpjsPcarePendaftaranEntityDto.getTinggibadan());
		}

		if (bpjsPcarePendaftaranEntityDto.getResprate() != null) {
			this.setResprate(bpjsPcarePendaftaranEntityDto.getResprate());
		}

		if (bpjsPcarePendaftaranEntityDto.getHeartrate() != null) {
			this.setHeartrate(bpjsPcarePendaftaranEntityDto.getHeartrate());
		}

		if (bpjsPcarePendaftaranEntityDto.getKdtkp() != null) {
			this.setKdtkp(bpjsPcarePendaftaranEntityDto.getKdtkp());
		}

		if (bpjsPcarePendaftaranEntityDto.getNmtkp() != null) {
			this.setNmtkp(bpjsPcarePendaftaranEntityDto.getNmtkp());
		}

		if (bpjsPcarePendaftaranEntityDto.getKdproviderpelayanan() != null) {
			this.setKdproviderpelayanan(bpjsPcarePendaftaranEntityDto.getKdproviderpelayanan());
		}

		if (bpjsPcarePendaftaranEntityDto.getNmproviderpelayanan() != null) {
			this.setNmproviderpelayanan(bpjsPcarePendaftaranEntityDto.getNmproviderpelayanan());
		}

		if (bpjsPcarePendaftaranEntityDto.getNmproviderpst() != null) {
			this.setNmproviderpst(bpjsPcarePendaftaranEntityDto.getNmproviderpst());
		}

		if (bpjsPcarePendaftaranEntityDto.getNmprovidergigi() != null) {
			this.setNmprovidergigi(bpjsPcarePendaftaranEntityDto.getNmprovidergigi());
		}

		if (bpjsPcarePendaftaranEntityDto.getKodekls() != null) {
			this.setKodekls(bpjsPcarePendaftaranEntityDto.getKodekls());
		}

		if (bpjsPcarePendaftaranEntityDto.getNamakls() != null) {
			this.setNamakls(bpjsPcarePendaftaranEntityDto.getNamakls());
		}

		if (bpjsPcarePendaftaranEntityDto.getKodepeserta() != null) {
			this.setKodepeserta(bpjsPcarePendaftaranEntityDto.getKodepeserta());
		}

		if (bpjsPcarePendaftaranEntityDto.getNamapeserta() != null) {
			this.setNamapeserta(bpjsPcarePendaftaranEntityDto.getNamapeserta());
		}

		if (bpjsPcarePendaftaranEntityDto.getKdasuransi() != null) {
			this.setKdasuransi(bpjsPcarePendaftaranEntityDto.getKdasuransi());
		}

		if (bpjsPcarePendaftaranEntityDto.getNmasuransi() != null) {
			this.setNmasuransi(bpjsPcarePendaftaranEntityDto.getNmasuransi());
		}

		if (bpjsPcarePendaftaranEntityDto.getNoasuransi() != null) {
			this.setNoasuransi(bpjsPcarePendaftaranEntityDto.getNoasuransi());
		}

		if (bpjsPcarePendaftaranEntityDto.getLingkarperut() != null) {
			this.setLingkarperut(bpjsPcarePendaftaranEntityDto.getLingkarperut());
		}

		if (bpjsPcarePendaftaranEntityDto.getPatientVisit() != null) {
			this.setPatientVisit(bpjsPcarePendaftaranEntityDto.getPatientVisit());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for noUrut here] off begin
	@CsvBindByName(column = "NOURUT", required = false)
	@Nullable
	@Column(name = "nourut")
	@Schema(description = "The noUrut of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noUrut here] end
	private String nourut;

	// % protected region % [Modify attribute annotation for tgldaftar here] off begin
	@CsvBindByName(column = "TGLDAFTAR", required = false)
	@Nullable
	@Column(name = "tgldaftar")
	@Schema(description = "The tgldaftar of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tgldaftar here] end
	private String tgldaftar;

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

	// % protected region % [Modify attribute annotation for kdProviderPst here] off begin
	@CsvBindByName(column = "KDPROVIDERPST", required = false)
	@Nullable
	@Column(name = "kdproviderpst")
	@Schema(description = "The kdProviderPst of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdProviderPst here] end
	private String kdproviderpst;

	// % protected region % [Modify attribute annotation for kdProviderGigi here] off begin
	@CsvBindByName(column = "KDPROVIDERGIGI", required = false)
	@Nullable
	@Column(name = "kdprovidergigi")
	@Schema(description = "The kdProviderGigi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdProviderGigi here] end
	private String kdprovidergigi;

	// % protected region % [Modify attribute annotation for jnsKelas here] off begin
	@CsvBindByName(column = "JNSKELAS", required = false)
	@Nullable
	@Column(name = "jnskelas")
	@Schema(description = "The jnsKelas of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for jnsKelas here] end
	private String jnskelas;

	// % protected region % [Modify attribute annotation for jnsPeserta here] off begin
	@CsvBindByName(column = "JNSPESERTA", required = false)
	@Nullable
	@Column(name = "jnspeserta")
	@Schema(description = "The jnsPeserta of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for jnsPeserta here] end
	private String jnspeserta;

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

	// % protected region % [Modify attribute annotation for aktif here] off begin
	@CsvBindByName(column = "AKTIF", required = false)
	@Nullable
	@Column(name = "aktif")
	@Schema(description = "The aktif of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for aktif here] end
	private String aktif;

	// % protected region % [Modify attribute annotation for ketAktif here] off begin
	@CsvBindByName(column = "KETAKTIF", required = false)
	@Nullable
	@Column(name = "ketaktif")
	@Schema(description = "The ketAktif of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ketAktif here] end
	private String ketaktif;

	// % protected region % [Modify attribute annotation for asuransi here] off begin
	@CsvBindByName(column = "ASURANSI", required = false)
	@Nullable
	@Column(name = "asuransi")
	@Schema(description = "The asuransi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for asuransi here] end
	private String asuransi;

	// % protected region % [Modify attribute annotation for kdPoli here] off begin
	@CsvBindByName(column = "KDPOLI", required = false)
	@Nullable
	@Column(name = "kdpoli")
	@Schema(description = "The kdPoli of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdPoli here] end
	private String kdpoli;

	// % protected region % [Modify attribute annotation for nmPoli here] off begin
	@CsvBindByName(column = "NMPOLI", required = false)
	@Nullable
	@Column(name = "nmpoli")
	@Schema(description = "The nmPoli of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmPoli here] end
	private String nmpoli;

	// % protected region % [Modify attribute annotation for poliSakit here] off begin
	@CsvBindByName(column = "POLISAKIT", required = false)
	@Nullable
	@Column(name = "polisakit")
	@Schema(description = "The poliSakit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for poliSakit here] end
	private String polisakit;

	// % protected region % [Modify attribute annotation for keluhan here] off begin
	@CsvBindByName(column = "KELUHAN", required = false)
	@Nullable
	@Column(name = "keluhan")
	@Schema(description = "The keluhan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for keluhan here] end
	private String keluhan;

	// % protected region % [Modify attribute annotation for kunjSakit here] off begin
	@CsvBindByName(column = "KUNJSAKIT", required = false)
	@Nullable
	@Column(name = "kunjsakit")
	@Schema(description = "The kunjSakit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kunjSakit here] end
	private String kunjsakit;

	// % protected region % [Modify attribute annotation for status here] off begin
	@CsvBindByName(column = "STATUS", required = false)
	@Nullable
	@Column(name = "status")
	@Schema(description = "The status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for status here] end
	private String status;

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

	// % protected region % [Modify attribute annotation for respRate here] off begin
	@CsvBindByName(column = "RESPRATE", required = false)
	@Nullable
	@Column(name = "resprate")
	@Schema(description = "The respRate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for respRate here] end
	private String resprate;

	// % protected region % [Modify attribute annotation for heartRate here] off begin
	@CsvBindByName(column = "HEARTRATE", required = false)
	@Nullable
	@Column(name = "heartrate")
	@Schema(description = "The heartRate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for heartRate here] end
	private String heartrate;

	// % protected region % [Modify attribute annotation for kdTkp here] off begin
	@CsvBindByName(column = "KDTKP", required = false)
	@Nullable
	@Column(name = "kdtkp")
	@Schema(description = "The kdTkp of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdTkp here] end
	private String kdtkp;

	// % protected region % [Modify attribute annotation for nmTkp here] off begin
	@CsvBindByName(column = "NMTKP", required = false)
	@Nullable
	@Column(name = "nmtkp")
	@Schema(description = "The nmTkp of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmTkp here] end
	private String nmtkp;

	// % protected region % [Modify attribute annotation for kdProviderPelayanan here] off begin
	@CsvBindByName(column = "KDPROVIDERPELAYANAN", required = false)
	@Nullable
	@Column(name = "kdproviderpelayanan")
	@Schema(description = "The kdProviderPelayanan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdProviderPelayanan here] end
	private String kdproviderpelayanan;

	// % protected region % [Modify attribute annotation for nmProviderPelayanan here] off begin
	@CsvBindByName(column = "NMPROVIDERPELAYANAN", required = false)
	@Nullable
	@Column(name = "nmproviderpelayanan")
	@Schema(description = "The nmProviderPelayanan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmProviderPelayanan here] end
	private String nmproviderpelayanan;

	// % protected region % [Modify attribute annotation for nmProviderPst here] off begin
	@CsvBindByName(column = "NMPROVIDERPST", required = false)
	@Nullable
	@Column(name = "nmproviderpst")
	@Schema(description = "The nmProviderPst of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmProviderPst here] end
	private String nmproviderpst;

	// % protected region % [Modify attribute annotation for nmProviderGigi here] off begin
	@CsvBindByName(column = "NMPROVIDERGIGI", required = false)
	@Nullable
	@Column(name = "nmprovidergigi")
	@Schema(description = "The nmProviderGigi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmProviderGigi here] end
	private String nmprovidergigi;

	// % protected region % [Modify attribute annotation for kodeKls here] off begin
	@CsvBindByName(column = "KODEKLS", required = false)
	@Nullable
	@Column(name = "kodekls")
	@Schema(description = "The kodeKls of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodeKls here] end
	private String kodekls;

	// % protected region % [Modify attribute annotation for namaKls here] off begin
	@CsvBindByName(column = "NAMAKLS", required = false)
	@Nullable
	@Column(name = "namakls")
	@Schema(description = "The namaKls of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for namaKls here] end
	private String namakls;

	// % protected region % [Modify attribute annotation for kodePeserta here] off begin
	@CsvBindByName(column = "KODEPESERTA", required = false)
	@Nullable
	@Column(name = "kodepeserta")
	@Schema(description = "The kodePeserta of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodePeserta here] end
	private String kodepeserta;

	// % protected region % [Modify attribute annotation for namaPeserta here] off begin
	@CsvBindByName(column = "NAMAPESERTA", required = false)
	@Nullable
	@Column(name = "namapeserta")
	@Schema(description = "The namaPeserta of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for namaPeserta here] end
	private String namapeserta;

	// % protected region % [Modify attribute annotation for kdAsuransi here] off begin
	@CsvBindByName(column = "KDASURANSI", required = false)
	@Nullable
	@Column(name = "kdasuransi")
	@Schema(description = "The kdAsuransi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdAsuransi here] end
	private String kdasuransi;

	// % protected region % [Modify attribute annotation for nmAsuransi here] off begin
	@CsvBindByName(column = "NMASURANSI", required = false)
	@Nullable
	@Column(name = "nmasuransi")
	@Schema(description = "The nmAsuransi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmAsuransi here] end
	private String nmasuransi;

	// % protected region % [Modify attribute annotation for noAsuransi here] off begin
	@CsvBindByName(column = "NOASURANSI", required = false)
	@Nullable
	@Column(name = "noasuransi")
	@Schema(description = "The noAsuransi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noAsuransi here] end
	private String noasuransi;

	// % protected region % [Modify attribute annotation for lingkarPerut here] off begin
	@CsvBindByName(column = "LINGKARPERUT", required = false)
	@Nullable
	@Column(name = "lingkarperut")
	@Schema(description = "The lingkarPerut of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for lingkarPerut here] end
	private String lingkarperut;

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

	// % protected region % [Update the annotation for Patient Visit here] off begin
	@Schema(description = "The Patient Visit entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Visit here] end
	private PatientVisitEntity patientVisit;

	// % protected region % [Update the annotation for patientVisitId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VISIT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientVisitId here] end
	private UUID patientVisitId;

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
	 * Similar to {@link this#setPatientVisit(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisit(@NotNull PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(@NotNull PatientVisitEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] end

		if (sameAsFormer(this.patientVisit, entity)) {
			return;
		}

		if (this.patientVisit != null) {
			this.patientVisit.removeBpjsPcarePendaftarans(this, false);
		}
		this.patientVisit = entity;
		if (reverseAdd) {
			this.patientVisit.addBpjsPcarePendaftarans(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisit(boolean)} but default to true.
	 */
	public void unsetPatientVisit() {
		this.unsetPatientVisit(true);
	}

	/**
	 * Remove Patient Visit in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisit(boolean reverse) {
		if (reverse && this.patientVisit != null) {
			this.patientVisit.removeBpjsPcarePendaftarans(this, false);
		}
		this.patientVisit = null;
	}

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "NOURUT,TGLDAFTAR,PROVIDERPELAYANAN,NOKARTU,NAMA,HUBUNGANKELUARGA,SEX,TGLLAHIR,TGLMULAIAKTIF,TGLAKHIRBERLAKU,KDPROVIDERPST,KDPROVIDERGIGI,JNSKELAS,JNSPESERTA,GOLDARAH,NOHP,NOKTP,AKTIF,KETAKTIF,ASURANSI,KDPOLI,NMPOLI,POLISAKIT,KELUHAN,KUNJSAKIT,STATUS,SISTOLE,DIASTOLE,BERATBADAN,TINGGIBADAN,RESPRATE,HEARTRATE,KDTKP,NMTKP,KDPROVIDERPELAYANAN,NMPROVIDERPELAYANAN,NMPROVIDERPST,NMPROVIDERGIGI,KODEKLS,NAMAKLS,KODEPESERTA,NAMAPESERTA,KDASURANSI,NMASURANSI,NOASURANSI,LINGKARPERUT,PATIENT_VISIT_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PatientVisitEntity> patientVisitRelation = Optional.ofNullable(this.patientVisit);
		patientVisitRelation.ifPresent(entity -> this.patientVisitId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsPcarePendaftaran) {
		if (this == bpjsPcarePendaftaran) {
			return true;
		}
		if (bpjsPcarePendaftaran == null || this.getClass() != bpjsPcarePendaftaran.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPcarePendaftaran)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPcarePendaftaranEntity that = (BpjsPcarePendaftaranEntity) bpjsPcarePendaftaran;
		return
			Objects.equals(this.nourut, that.nourut) &&
			Objects.equals(this.tgldaftar, that.tgldaftar) &&
			Objects.equals(this.providerpelayanan, that.providerpelayanan) &&
			Objects.equals(this.nokartu, that.nokartu) &&
			Objects.equals(this.nama, that.nama) &&
			Objects.equals(this.hubungankeluarga, that.hubungankeluarga) &&
			Objects.equals(this.sex, that.sex) &&
			Objects.equals(this.tgllahir, that.tgllahir) &&
			Objects.equals(this.tglmulaiaktif, that.tglmulaiaktif) &&
			Objects.equals(this.tglakhirberlaku, that.tglakhirberlaku) &&
			Objects.equals(this.kdproviderpst, that.kdproviderpst) &&
			Objects.equals(this.kdprovidergigi, that.kdprovidergigi) &&
			Objects.equals(this.jnskelas, that.jnskelas) &&
			Objects.equals(this.jnspeserta, that.jnspeserta) &&
			Objects.equals(this.goldarah, that.goldarah) &&
			Objects.equals(this.nohp, that.nohp) &&
			Objects.equals(this.noktp, that.noktp) &&
			Objects.equals(this.aktif, that.aktif) &&
			Objects.equals(this.ketaktif, that.ketaktif) &&
			Objects.equals(this.asuransi, that.asuransi) &&
			Objects.equals(this.kdpoli, that.kdpoli) &&
			Objects.equals(this.nmpoli, that.nmpoli) &&
			Objects.equals(this.polisakit, that.polisakit) &&
			Objects.equals(this.keluhan, that.keluhan) &&
			Objects.equals(this.kunjsakit, that.kunjsakit) &&
			Objects.equals(this.status, that.status) &&
			Objects.equals(this.sistole, that.sistole) &&
			Objects.equals(this.diastole, that.diastole) &&
			Objects.equals(this.beratbadan, that.beratbadan) &&
			Objects.equals(this.tinggibadan, that.tinggibadan) &&
			Objects.equals(this.resprate, that.resprate) &&
			Objects.equals(this.heartrate, that.heartrate) &&
			Objects.equals(this.kdtkp, that.kdtkp) &&
			Objects.equals(this.nmtkp, that.nmtkp) &&
			Objects.equals(this.kdproviderpelayanan, that.kdproviderpelayanan) &&
			Objects.equals(this.nmproviderpelayanan, that.nmproviderpelayanan) &&
			Objects.equals(this.nmproviderpst, that.nmproviderpst) &&
			Objects.equals(this.nmprovidergigi, that.nmprovidergigi) &&
			Objects.equals(this.kodekls, that.kodekls) &&
			Objects.equals(this.namakls, that.namakls) &&
			Objects.equals(this.kodepeserta, that.kodepeserta) &&
			Objects.equals(this.namapeserta, that.namapeserta) &&
			Objects.equals(this.kdasuransi, that.kdasuransi) &&
			Objects.equals(this.nmasuransi, that.nmasuransi) &&
			Objects.equals(this.noasuransi, that.noasuransi) &&
			Objects.equals(this.lingkarperut, that.lingkarperut) &&
			Objects.equals(this.patientVisitId, that.patientVisitId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
