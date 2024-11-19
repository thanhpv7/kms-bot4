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
import kmsweb.dtos.PcareMCUEntityDto;
import kmsweb.entities.listeners.PcareMCUEntityListener;
import kmsweb.serializers.PcareMCUSerializer;
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
@EntityListeners({PcareMCUEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareMCUSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PcareMCUEntity extends AbstractEntity {

	/**
	 * Takes a PcareMCUEntityDto and converts it into a PcareMCUEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareMCUEntityDto
	 */
	public PcareMCUEntity(PcareMCUEntityDto pcareMCUEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareMCUEntityDto.getId() != null) {
			this.setId(pcareMCUEntityDto.getId());
		}

		if (pcareMCUEntityDto.getKodeMCU() != null) {
			this.setKodeMCU(pcareMCUEntityDto.getKodeMCU());
		}

		if (pcareMCUEntityDto.getNoKunjungan() != null) {
			this.setNoKunjungan(pcareMCUEntityDto.getNoKunjungan());
		}

		if (pcareMCUEntityDto.getKodeProvider() != null) {
			this.setKodeProvider(pcareMCUEntityDto.getKodeProvider());
		}

		if (pcareMCUEntityDto.getNamaProvider() != null) {
			this.setNamaProvider(pcareMCUEntityDto.getNamaProvider());
		}

		if (pcareMCUEntityDto.getTanggalPelayanan() != null) {
			this.setTanggalPelayanan(pcareMCUEntityDto.getTanggalPelayanan());
		}

		if (pcareMCUEntityDto.getSistole() != null) {
			this.setSistole(pcareMCUEntityDto.getSistole());
		}

		if (pcareMCUEntityDto.getDiastole() != null) {
			this.setDiastole(pcareMCUEntityDto.getDiastole());
		}

		if (pcareMCUEntityDto.getRadiologiFoto() != null) {
			this.setRadiologiFoto(pcareMCUEntityDto.getRadiologiFoto());
		}

		if (pcareMCUEntityDto.getHemoglobin() != null) {
			this.setHemoglobin(pcareMCUEntityDto.getHemoglobin());
		}

		if (pcareMCUEntityDto.getLeukosit() != null) {
			this.setLeukosit(pcareMCUEntityDto.getLeukosit());
		}

		if (pcareMCUEntityDto.getEritrosit() != null) {
			this.setEritrosit(pcareMCUEntityDto.getEritrosit());
		}

		if (pcareMCUEntityDto.getLajuEndapDarah() != null) {
			this.setLajuEndapDarah(pcareMCUEntityDto.getLajuEndapDarah());
		}

		if (pcareMCUEntityDto.getHematokrit() != null) {
			this.setHematokrit(pcareMCUEntityDto.getHematokrit());
		}

		if (pcareMCUEntityDto.getTrombosit() != null) {
			this.setTrombosit(pcareMCUEntityDto.getTrombosit());
		}

		if (pcareMCUEntityDto.getHdl() != null) {
			this.setHdl(pcareMCUEntityDto.getHdl());
		}

		if (pcareMCUEntityDto.getLdl() != null) {
			this.setLdl(pcareMCUEntityDto.getLdl());
		}

		if (pcareMCUEntityDto.getCholesterol() != null) {
			this.setCholesterol(pcareMCUEntityDto.getCholesterol());
		}

		if (pcareMCUEntityDto.getTrigliserida() != null) {
			this.setTrigliserida(pcareMCUEntityDto.getTrigliserida());
		}

		if (pcareMCUEntityDto.getSewaktu() != null) {
			this.setSewaktu(pcareMCUEntityDto.getSewaktu());
		}

		if (pcareMCUEntityDto.getPuasa() != null) {
			this.setPuasa(pcareMCUEntityDto.getPuasa());
		}

		if (pcareMCUEntityDto.getPostPrandial() != null) {
			this.setPostPrandial(pcareMCUEntityDto.getPostPrandial());
		}

		if (pcareMCUEntityDto.getHba1c() != null) {
			this.setHba1c(pcareMCUEntityDto.getHba1c());
		}

		if (pcareMCUEntityDto.getSgot() != null) {
			this.setSgot(pcareMCUEntityDto.getSgot());
		}

		if (pcareMCUEntityDto.getSgpt() != null) {
			this.setSgpt(pcareMCUEntityDto.getSgpt());
		}

		if (pcareMCUEntityDto.getGamma() != null) {
			this.setGamma(pcareMCUEntityDto.getGamma());
		}

		if (pcareMCUEntityDto.getProteinKualitatif() != null) {
			this.setProteinKualitatif(pcareMCUEntityDto.getProteinKualitatif());
		}

		if (pcareMCUEntityDto.getAlbumin() != null) {
			this.setAlbumin(pcareMCUEntityDto.getAlbumin());
		}

		if (pcareMCUEntityDto.getCreatinine() != null) {
			this.setCreatinine(pcareMCUEntityDto.getCreatinine());
		}

		if (pcareMCUEntityDto.getUreum() != null) {
			this.setUreum(pcareMCUEntityDto.getUreum());
		}

		if (pcareMCUEntityDto.getAsam() != null) {
			this.setAsam(pcareMCUEntityDto.getAsam());
		}

		if (pcareMCUEntityDto.getAbi() != null) {
			this.setAbi(pcareMCUEntityDto.getAbi());
		}

		if (pcareMCUEntityDto.getEkg() != null) {
			this.setEkg(pcareMCUEntityDto.getEkg());
		}

		if (pcareMCUEntityDto.getEcho() != null) {
			this.setEcho(pcareMCUEntityDto.getEcho());
		}

		if (pcareMCUEntityDto.getFunduskopi() != null) {
			this.setFunduskopi(pcareMCUEntityDto.getFunduskopi());
		}

		if (pcareMCUEntityDto.getPemeriksaanLain() != null) {
			this.setPemeriksaanLain(pcareMCUEntityDto.getPemeriksaanLain());
		}

		if (pcareMCUEntityDto.getKeterangan() != null) {
			this.setKeterangan(pcareMCUEntityDto.getKeterangan());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Kode MCU here] off begin
	@CsvBindByName(column = "KODE_MCU", required = false)
	@Nullable
	@Column(name = "kode_mcu")
	@Schema(description = "The Kode MCU of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kode MCU here] end
	private String kodeMCU;

	// % protected region % [Modify attribute annotation for No Kunjungan here] off begin
	@CsvBindByName(column = "NO_KUNJUNGAN", required = false)
	@Nullable
	@Column(name = "no_kunjungan")
	@Schema(description = "The No Kunjungan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for No Kunjungan here] end
	private String noKunjungan;

	// % protected region % [Modify attribute annotation for Kode Provider here] off begin
	@CsvBindByName(column = "KODE_PROVIDER", required = false)
	@Nullable
	@Column(name = "kode_provider")
	@Schema(description = "The Kode Provider of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kode Provider here] end
	private String kodeProvider;

	// % protected region % [Modify attribute annotation for Nama Provider here] off begin
	@CsvBindByName(column = "NAMA_PROVIDER", required = false)
	@Nullable
	@Column(name = "nama_provider")
	@Schema(description = "The Nama Provider of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nama Provider here] end
	private String namaProvider;

	// % protected region % [Modify attribute annotation for Tanggal Pelayanan here] off begin
	@CsvBindByName(column = "TANGGAL_PELAYANAN", required = false)
	@Nullable
	@Column(name = "tanggal_pelayanan")
	@Schema(description = "The Tanggal Pelayanan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tanggal Pelayanan here] end
	private String tanggalPelayanan;

	// % protected region % [Modify attribute annotation for Sistole here] off begin
	@CsvBindByName(column = "SISTOLE", required = false)
	@Nullable
	@Column(name = "sistole")
	@Schema(description = "The Sistole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sistole here] end
	private String sistole;

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@CsvBindByName(column = "DIASTOLE", required = false)
	@Nullable
	@Column(name = "diastole")
	@Schema(description = "The Diastole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diastole here] end
	private String diastole;

	// % protected region % [Modify attribute annotation for Radiologi Foto here] off begin
	@CsvBindByName(column = "RADIOLOGI_FOTO", required = false)
	@Nullable
	@Column(name = "radiologi_foto")
	@Schema(description = "The Radiologi Foto of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Radiologi Foto here] end
	private String radiologiFoto;

	// % protected region % [Modify attribute annotation for Hemoglobin here] off begin
	@CsvBindByName(column = "HEMOGLOBIN", required = false)
	@Nullable
	@Column(name = "hemoglobin")
	@Schema(description = "The Hemoglobin of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hemoglobin here] end
	private String hemoglobin;

	// % protected region % [Modify attribute annotation for Leukosit here] off begin
	@CsvBindByName(column = "LEUKOSIT", required = false)
	@Nullable
	@Column(name = "leukosit")
	@Schema(description = "The Leukosit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Leukosit here] end
	private String leukosit;

	// % protected region % [Modify attribute annotation for Eritrosit here] off begin
	@CsvBindByName(column = "ERITROSIT", required = false)
	@Nullable
	@Column(name = "eritrosit")
	@Schema(description = "The Eritrosit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Eritrosit here] end
	private String eritrosit;

	// % protected region % [Modify attribute annotation for Laju Endap Darah here] off begin
	@CsvBindByName(column = "LAJU_ENDAP_DARAH", required = false)
	@Nullable
	@Column(name = "laju_endap_darah")
	@Schema(description = "The Laju Endap Darah of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Laju Endap Darah here] end
	private String lajuEndapDarah;

	// % protected region % [Modify attribute annotation for Hematokrit here] off begin
	@CsvBindByName(column = "HEMATOKRIT", required = false)
	@Nullable
	@Column(name = "hematokrit")
	@Schema(description = "The Hematokrit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hematokrit here] end
	private String hematokrit;

	// % protected region % [Modify attribute annotation for Trombosit here] off begin
	@CsvBindByName(column = "TROMBOSIT", required = false)
	@Nullable
	@Column(name = "trombosit")
	@Schema(description = "The Trombosit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Trombosit here] end
	private String trombosit;

	// % protected region % [Modify attribute annotation for HDL here] off begin
	@CsvBindByName(column = "HDL", required = false)
	@Nullable
	@Column(name = "hdl")
	@Schema(description = "The HDL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for HDL here] end
	private String hdl;

	// % protected region % [Modify attribute annotation for LDL here] off begin
	@CsvBindByName(column = "LDL", required = false)
	@Nullable
	@Column(name = "ldl")
	@Schema(description = "The LDL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for LDL here] end
	private String ldl;

	// % protected region % [Modify attribute annotation for Cholesterol here] off begin
	@CsvBindByName(column = "CHOLESTEROL", required = false)
	@Nullable
	@Column(name = "cholesterol")
	@Schema(description = "The Cholesterol of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Cholesterol here] end
	private String cholesterol;

	// % protected region % [Modify attribute annotation for Trigliserida here] off begin
	@CsvBindByName(column = "TRIGLISERIDA", required = false)
	@Nullable
	@Column(name = "trigliserida")
	@Schema(description = "The Trigliserida of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Trigliserida here] end
	private String trigliserida;

	// % protected region % [Modify attribute annotation for Sewaktu here] off begin
	@CsvBindByName(column = "SEWAKTU", required = false)
	@Nullable
	@Column(name = "sewaktu")
	@Schema(description = "The Sewaktu of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sewaktu here] end
	private String sewaktu;

	// % protected region % [Modify attribute annotation for Puasa here] off begin
	@CsvBindByName(column = "PUASA", required = false)
	@Nullable
	@Column(name = "puasa")
	@Schema(description = "The Puasa of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Puasa here] end
	private String puasa;

	// % protected region % [Modify attribute annotation for Post Prandial here] off begin
	@CsvBindByName(column = "POST_PRANDIAL", required = false)
	@Nullable
	@Column(name = "post_prandial")
	@Schema(description = "The Post Prandial of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Post Prandial here] end
	private String postPrandial;

	// % protected region % [Modify attribute annotation for HbA1c here] off begin
	@CsvBindByName(column = "HBA1C", required = false)
	@Nullable
	@Column(name = "hba1c")
	@Schema(description = "The HbA1c of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for HbA1c here] end
	private String hba1c;

	// % protected region % [Modify attribute annotation for SGOT here] off begin
	@CsvBindByName(column = "SGOT", required = false)
	@Nullable
	@Column(name = "sgot")
	@Schema(description = "The SGOT of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SGOT here] end
	private String sgot;

	// % protected region % [Modify attribute annotation for SGPT here] off begin
	@CsvBindByName(column = "SGPT", required = false)
	@Nullable
	@Column(name = "sgpt")
	@Schema(description = "The SGPT of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SGPT here] end
	private String sgpt;

	// % protected region % [Modify attribute annotation for Gamma here] off begin
	@CsvBindByName(column = "GAMMA", required = false)
	@Nullable
	@Column(name = "gamma")
	@Schema(description = "The Gamma of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gamma here] end
	private String gamma;

	// % protected region % [Modify attribute annotation for Protein Kualitatif here] off begin
	@CsvBindByName(column = "PROTEIN_KUALITATIF", required = false)
	@Nullable
	@Column(name = "protein_kualitatif")
	@Schema(description = "The Protein Kualitatif of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Protein Kualitatif here] end
	private String proteinKualitatif;

	// % protected region % [Modify attribute annotation for Albumin here] off begin
	@CsvBindByName(column = "ALBUMIN", required = false)
	@Nullable
	@Column(name = "albumin")
	@Schema(description = "The Albumin of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Albumin here] end
	private String albumin;

	// % protected region % [Modify attribute annotation for Creatinine here] off begin
	@CsvBindByName(column = "CREATININE", required = false)
	@Nullable
	@Column(name = "creatinine")
	@Schema(description = "The Creatinine of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Creatinine here] end
	private String creatinine;

	// % protected region % [Modify attribute annotation for Ureum here] off begin
	@CsvBindByName(column = "UREUM", required = false)
	@Nullable
	@Column(name = "ureum")
	@Schema(description = "The Ureum of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ureum here] end
	private String ureum;

	// % protected region % [Modify attribute annotation for Asam here] off begin
	@CsvBindByName(column = "ASAM", required = false)
	@Nullable
	@Column(name = "asam")
	@Schema(description = "The Asam of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Asam here] end
	private String asam;

	// % protected region % [Modify attribute annotation for ABI here] off begin
	@CsvBindByName(column = "ABI", required = false)
	@Nullable
	@Column(name = "abi")
	@Schema(description = "The ABI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ABI here] end
	private String abi;

	// % protected region % [Modify attribute annotation for EKG here] off begin
	@CsvBindByName(column = "EKG", required = false)
	@Nullable
	@Column(name = "ekg")
	@Schema(description = "The EKG of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for EKG here] end
	private String ekg;

	// % protected region % [Modify attribute annotation for Echo here] off begin
	@CsvBindByName(column = "ECHO", required = false)
	@Nullable
	@Column(name = "echo")
	@Schema(description = "The Echo of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Echo here] end
	private String echo;

	// % protected region % [Modify attribute annotation for Funduskopi here] off begin
	@CsvBindByName(column = "FUNDUSKOPI", required = false)
	@Nullable
	@Column(name = "funduskopi")
	@Schema(description = "The Funduskopi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Funduskopi here] end
	private String funduskopi;

	// % protected region % [Modify attribute annotation for Pemeriksaan Lain here] off begin
	@CsvBindByName(column = "PEMERIKSAAN_LAIN", required = false)
	@Nullable
	@Column(name = "pemeriksaan_lain")
	@Schema(description = "The Pemeriksaan Lain of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pemeriksaan Lain here] end
	private String pemeriksaanLain;

	// % protected region % [Modify attribute annotation for Keterangan here] off begin
	@CsvBindByName(column = "KETERANGAN", required = false)
	@Nullable
	@Column(name = "keterangan")
	@Schema(description = "The Keterangan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Keterangan here] end
	private String keterangan;

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
		return "KODE_MCU,NO_KUNJUNGAN,KODE_PROVIDER,NAMA_PROVIDER,TANGGAL_PELAYANAN,SISTOLE,DIASTOLE,RADIOLOGI_FOTO,HEMOGLOBIN,LEUKOSIT,ERITROSIT,LAJU_ENDAP_DARAH,HEMATOKRIT,TROMBOSIT,HDL,LDL,CHOLESTEROL,TRIGLISERIDA,SEWAKTU,PUASA,POST_PRANDIAL,HBA1C,SGOT,SGPT,GAMMA,PROTEIN_KUALITATIF,ALBUMIN,CREATININE,UREUM,ASAM,ABI,EKG,ECHO,FUNDUSKOPI,PEMERIKSAAN_LAIN,KETERANGAN,ID";
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
	public boolean equals(Object pcareMCU) {
		if (this == pcareMCU) {
			return true;
		}
		if (pcareMCU == null || this.getClass() != pcareMCU.getClass()) {
			return false;
		}
		if (!super.equals(pcareMCU)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareMCUEntity that = (PcareMCUEntity) pcareMCU;
		return
			Objects.equals(this.kodeMCU, that.kodeMCU) &&
			Objects.equals(this.noKunjungan, that.noKunjungan) &&
			Objects.equals(this.kodeProvider, that.kodeProvider) &&
			Objects.equals(this.namaProvider, that.namaProvider) &&
			Objects.equals(this.tanggalPelayanan, that.tanggalPelayanan) &&
			Objects.equals(this.sistole, that.sistole) &&
			Objects.equals(this.diastole, that.diastole) &&
			Objects.equals(this.radiologiFoto, that.radiologiFoto) &&
			Objects.equals(this.hemoglobin, that.hemoglobin) &&
			Objects.equals(this.leukosit, that.leukosit) &&
			Objects.equals(this.eritrosit, that.eritrosit) &&
			Objects.equals(this.lajuEndapDarah, that.lajuEndapDarah) &&
			Objects.equals(this.hematokrit, that.hematokrit) &&
			Objects.equals(this.trombosit, that.trombosit) &&
			Objects.equals(this.hdl, that.hdl) &&
			Objects.equals(this.ldl, that.ldl) &&
			Objects.equals(this.cholesterol, that.cholesterol) &&
			Objects.equals(this.trigliserida, that.trigliserida) &&
			Objects.equals(this.sewaktu, that.sewaktu) &&
			Objects.equals(this.puasa, that.puasa) &&
			Objects.equals(this.postPrandial, that.postPrandial) &&
			Objects.equals(this.hba1c, that.hba1c) &&
			Objects.equals(this.sgot, that.sgot) &&
			Objects.equals(this.sgpt, that.sgpt) &&
			Objects.equals(this.gamma, that.gamma) &&
			Objects.equals(this.proteinKualitatif, that.proteinKualitatif) &&
			Objects.equals(this.albumin, that.albumin) &&
			Objects.equals(this.creatinine, that.creatinine) &&
			Objects.equals(this.ureum, that.ureum) &&
			Objects.equals(this.asam, that.asam) &&
			Objects.equals(this.abi, that.abi) &&
			Objects.equals(this.ekg, that.ekg) &&
			Objects.equals(this.echo, that.echo) &&
			Objects.equals(this.funduskopi, that.funduskopi) &&
			Objects.equals(this.pemeriksaanLain, that.pemeriksaanLain) &&
			Objects.equals(this.keterangan, that.keterangan);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
