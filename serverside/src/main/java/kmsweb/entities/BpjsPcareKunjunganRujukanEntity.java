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
import kmsweb.dtos.BpjsPcareKunjunganRujukanEntityDto;
import kmsweb.entities.listeners.BpjsPcareKunjunganRujukanEntityListener;
import kmsweb.serializers.BpjsPcareKunjunganRujukanSerializer;
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
@EntityListeners({BpjsPcareKunjunganRujukanEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPcareKunjunganRujukanSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPcareKunjunganRujukanEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPcareKunjunganRujukanEntityDto and converts it into a BpjsPcareKunjunganRujukanEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPcareKunjunganRujukanEntityDto
	 */
	public BpjsPcareKunjunganRujukanEntity(BpjsPcareKunjunganRujukanEntityDto bpjsPcareKunjunganRujukanEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPcareKunjunganRujukanEntityDto.getId() != null) {
			this.setId(bpjsPcareKunjunganRujukanEntityDto.getId());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNorujukan() != null) {
			this.setNorujukan(bpjsPcareKunjunganRujukanEntityDto.getNorujukan());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKdppk() != null) {
			this.setKdppk(bpjsPcareKunjunganRujukanEntityDto.getKdppk());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmppk() != null) {
			this.setNmppk(bpjsPcareKunjunganRujukanEntityDto.getNmppk());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getAlamat() != null) {
			this.setAlamat(bpjsPcareKunjunganRujukanEntityDto.getAlamat());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKdkc() != null) {
			this.setKdkc(bpjsPcareKunjunganRujukanEntityDto.getKdkc());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmkc() != null) {
			this.setNmkc(bpjsPcareKunjunganRujukanEntityDto.getNmkc());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getAlamatkc() != null) {
			this.setAlamatkc(bpjsPcareKunjunganRujukanEntityDto.getAlamatkc());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getTelpkc() != null) {
			this.setTelpkc(bpjsPcareKunjunganRujukanEntityDto.getTelpkc());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getFaxkc() != null) {
			this.setFaxkc(bpjsPcareKunjunganRujukanEntityDto.getFaxkc());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKdprop() != null) {
			this.setKdprop(bpjsPcareKunjunganRujukanEntityDto.getKdprop());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKddati() != null) {
			this.setKddati(bpjsPcareKunjunganRujukanEntityDto.getKddati());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmdati() != null) {
			this.setNmdati(bpjsPcareKunjunganRujukanEntityDto.getNmdati());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKdkr() != null) {
			this.setKdkr(bpjsPcareKunjunganRujukanEntityDto.getKdkr());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmkr() != null) {
			this.setNmkr(bpjsPcareKunjunganRujukanEntityDto.getNmkr());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getAlamatkr() != null) {
			this.setAlamatkr(bpjsPcareKunjunganRujukanEntityDto.getAlamatkr());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getTelpkr() != null) {
			this.setTelpkr(bpjsPcareKunjunganRujukanEntityDto.getTelpkr());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getFaxkr() != null) {
			this.setFaxkr(bpjsPcareKunjunganRujukanEntityDto.getFaxkr());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getTglkunjungan() != null) {
			this.setTglkunjungan(bpjsPcareKunjunganRujukanEntityDto.getTglkunjungan());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKdpoli() != null) {
			this.setKdpoli(bpjsPcareKunjunganRujukanEntityDto.getKdpoli());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmpoli() != null) {
			this.setNmpoli(bpjsPcareKunjunganRujukanEntityDto.getNmpoli());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNokapst() != null) {
			this.setNokapst(bpjsPcareKunjunganRujukanEntityDto.getNokapst());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmpst() != null) {
			this.setNmpst(bpjsPcareKunjunganRujukanEntityDto.getNmpst());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getTgllahir() != null) {
			this.setTgllahir(bpjsPcareKunjunganRujukanEntityDto.getTgllahir());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getPisa() != null) {
			this.setPisa(bpjsPcareKunjunganRujukanEntityDto.getPisa());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKetpisa() != null) {
			this.setKetpisa(bpjsPcareKunjunganRujukanEntityDto.getKetpisa());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getSex() != null) {
			this.setSex(bpjsPcareKunjunganRujukanEntityDto.getSex());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKddiag1() != null) {
			this.setKddiag1(bpjsPcareKunjunganRujukanEntityDto.getKddiag1());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmdiag1() != null) {
			this.setNmdiag1(bpjsPcareKunjunganRujukanEntityDto.getNmdiag1());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKddiag2() != null) {
			this.setKddiag2(bpjsPcareKunjunganRujukanEntityDto.getKddiag2());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmdiag2() != null) {
			this.setNmdiag2(bpjsPcareKunjunganRujukanEntityDto.getNmdiag2());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKddiag3() != null) {
			this.setKddiag3(bpjsPcareKunjunganRujukanEntityDto.getKddiag3());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmdiag3() != null) {
			this.setNmdiag3(bpjsPcareKunjunganRujukanEntityDto.getNmdiag3());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getCatatan() != null) {
			this.setCatatan(bpjsPcareKunjunganRujukanEntityDto.getCatatan());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getKddokter() != null) {
			this.setKddokter(bpjsPcareKunjunganRujukanEntityDto.getKddokter());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmdokter() != null) {
			this.setNmdokter(bpjsPcareKunjunganRujukanEntityDto.getNmdokter());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getNmtacc() != null) {
			this.setNmtacc(bpjsPcareKunjunganRujukanEntityDto.getNmtacc());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getAlasantacc() != null) {
			this.setAlasantacc(bpjsPcareKunjunganRujukanEntityDto.getAlasantacc());
		}

		if (bpjsPcareKunjunganRujukanEntityDto.getInfodenda() != null) {
			this.setInfodenda(bpjsPcareKunjunganRujukanEntityDto.getInfodenda());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for noRujukan here] off begin
	@CsvBindByName(column = "NORUJUKAN", required = false)
	@Nullable
	@Column(name = "norujukan")
	@Schema(description = "The noRujukan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noRujukan here] end
	private String norujukan;

	// % protected region % [Modify attribute annotation for kdPPK here] off begin
	@CsvBindByName(column = "KDPPK", required = false)
	@Nullable
	@Column(name = "kdppk")
	@Schema(description = "The kdPPK of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdPPK here] end
	private String kdppk;

	// % protected region % [Modify attribute annotation for nmPPK here] off begin
	@CsvBindByName(column = "NMPPK", required = false)
	@Nullable
	@Column(name = "nmppk")
	@Schema(description = "The nmPPK of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmPPK here] end
	private String nmppk;

	// % protected region % [Modify attribute annotation for alamat here] off begin
	@CsvBindByName(column = "ALAMAT", required = false)
	@Nullable
	@Column(name = "alamat")
	@Schema(description = "The alamat of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for alamat here] end
	private String alamat;

	// % protected region % [Modify attribute annotation for kdKC here] off begin
	@CsvBindByName(column = "KDKC", required = false)
	@Nullable
	@Column(name = "kdkc")
	@Schema(description = "The kdKC of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdKC here] end
	private String kdkc;

	// % protected region % [Modify attribute annotation for nmKC here] off begin
	@CsvBindByName(column = "NMKC", required = false)
	@Nullable
	@Column(name = "nmkc")
	@Schema(description = "The nmKC of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmKC here] end
	private String nmkc;

	// % protected region % [Modify attribute annotation for alamatKC here] off begin
	@CsvBindByName(column = "ALAMATKC", required = false)
	@Nullable
	@Column(name = "alamatkc")
	@Schema(description = "The alamatKC of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for alamatKC here] end
	private String alamatkc;

	// % protected region % [Modify attribute annotation for telpKC here] off begin
	@CsvBindByName(column = "TELPKC", required = false)
	@Nullable
	@Column(name = "telpkc")
	@Schema(description = "The telpKC of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for telpKC here] end
	private String telpkc;

	// % protected region % [Modify attribute annotation for faxKC here] off begin
	@CsvBindByName(column = "FAXKC", required = false)
	@Nullable
	@Column(name = "faxkc")
	@Schema(description = "The faxKC of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for faxKC here] end
	private String faxkc;

	// % protected region % [Modify attribute annotation for kdProp here] off begin
	@CsvBindByName(column = "KDPROP", required = false)
	@Nullable
	@Column(name = "kdprop")
	@Schema(description = "The kdProp of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdProp here] end
	private String kdprop;

	// % protected region % [Modify attribute annotation for kdDati here] off begin
	@CsvBindByName(column = "KDDATI", required = false)
	@Nullable
	@Column(name = "kddati")
	@Schema(description = "The kdDati of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdDati here] end
	private String kddati;

	// % protected region % [Modify attribute annotation for nmDati here] off begin
	@CsvBindByName(column = "NMDATI", required = false)
	@Nullable
	@Column(name = "nmdati")
	@Schema(description = "The nmDati of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmDati here] end
	private String nmdati;

	// % protected region % [Modify attribute annotation for kdKR here] off begin
	@CsvBindByName(column = "KDKR", required = false)
	@Nullable
	@Column(name = "kdkr")
	@Schema(description = "The kdKR of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdKR here] end
	private String kdkr;

	// % protected region % [Modify attribute annotation for nmKR here] off begin
	@CsvBindByName(column = "NMKR", required = false)
	@Nullable
	@Column(name = "nmkr")
	@Schema(description = "The nmKR of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmKR here] end
	private String nmkr;

	// % protected region % [Modify attribute annotation for alamatKR here] off begin
	@CsvBindByName(column = "ALAMATKR", required = false)
	@Nullable
	@Column(name = "alamatkr")
	@Schema(description = "The alamatKR of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for alamatKR here] end
	private String alamatkr;

	// % protected region % [Modify attribute annotation for telpKR here] off begin
	@CsvBindByName(column = "TELPKR", required = false)
	@Nullable
	@Column(name = "telpkr")
	@Schema(description = "The telpKR of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for telpKR here] end
	private String telpkr;

	// % protected region % [Modify attribute annotation for faxKR here] off begin
	@CsvBindByName(column = "FAXKR", required = false)
	@Nullable
	@Column(name = "faxkr")
	@Schema(description = "The faxKR of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for faxKR here] end
	private String faxkr;

	// % protected region % [Modify attribute annotation for tglKunjungan here] off begin
	@CsvBindByName(column = "TGLKUNJUNGAN", required = false)
	@Nullable
	@Column(name = "tglkunjungan")
	@Schema(description = "The tglKunjungan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglKunjungan here] end
	private String tglkunjungan;

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

	// % protected region % [Modify attribute annotation for nokaPst here] off begin
	@CsvBindByName(column = "NOKAPST", required = false)
	@Nullable
	@Column(name = "nokapst")
	@Schema(description = "The nokaPst of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nokaPst here] end
	private String nokapst;

	// % protected region % [Modify attribute annotation for nmPst here] off begin
	@CsvBindByName(column = "NMPST", required = false)
	@Nullable
	@Column(name = "nmpst")
	@Schema(description = "The nmPst of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmPst here] end
	private String nmpst;

	// % protected region % [Modify attribute annotation for tglLahir here] off begin
	@CsvBindByName(column = "TGLLAHIR", required = false)
	@Nullable
	@Column(name = "tgllahir")
	@Schema(description = "The tglLahir of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglLahir here] end
	private String tgllahir;

	// % protected region % [Modify attribute annotation for pisa here] off begin
	@CsvBindByName(column = "PISA", required = false)
	@Nullable
	@Column(name = "pisa")
	@Schema(description = "The pisa of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for pisa here] end
	private String pisa;

	// % protected region % [Modify attribute annotation for ketPisa here] off begin
	@CsvBindByName(column = "KETPISA", required = false)
	@Nullable
	@Column(name = "ketpisa")
	@Schema(description = "The ketPisa of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ketPisa here] end
	private String ketpisa;

	// % protected region % [Modify attribute annotation for sex here] off begin
	@CsvBindByName(column = "SEX", required = false)
	@Nullable
	@Column(name = "sex")
	@Schema(description = "The sex of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for sex here] end
	private String sex;

	// % protected region % [Modify attribute annotation for kdDiag1 here] off begin
	@CsvBindByName(column = "KDDIAG1", required = false)
	@Nullable
	@Column(name = "kddiag1")
	@Schema(description = "The kdDiag1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdDiag1 here] end
	private String kddiag1;

	// % protected region % [Modify attribute annotation for nmDiag1 here] off begin
	@CsvBindByName(column = "NMDIAG1", required = false)
	@Nullable
	@Column(name = "nmdiag1")
	@Schema(description = "The nmDiag1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmDiag1 here] end
	private String nmdiag1;

	// % protected region % [Modify attribute annotation for kdDiag2 here] off begin
	@CsvBindByName(column = "KDDIAG2", required = false)
	@Nullable
	@Column(name = "kddiag2")
	@Schema(description = "The kdDiag2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdDiag2 here] end
	private String kddiag2;

	// % protected region % [Modify attribute annotation for nmDiag2 here] off begin
	@CsvBindByName(column = "NMDIAG2", required = false)
	@Nullable
	@Column(name = "nmdiag2")
	@Schema(description = "The nmDiag2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmDiag2 here] end
	private String nmdiag2;

	// % protected region % [Modify attribute annotation for kdDiag3 here] off begin
	@CsvBindByName(column = "KDDIAG3", required = false)
	@Nullable
	@Column(name = "kddiag3")
	@Schema(description = "The kdDiag3 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdDiag3 here] end
	private String kddiag3;

	// % protected region % [Modify attribute annotation for nmDiag3 here] off begin
	@CsvBindByName(column = "NMDIAG3", required = false)
	@Nullable
	@Column(name = "nmdiag3")
	@Schema(description = "The nmDiag3 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmDiag3 here] end
	private String nmdiag3;

	// % protected region % [Modify attribute annotation for catatan here] off begin
	@CsvBindByName(column = "CATATAN", required = false)
	@Nullable
	@Column(name = "catatan")
	@Schema(description = "The catatan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for catatan here] end
	private String catatan;

	// % protected region % [Modify attribute annotation for kdDokter here] off begin
	@CsvBindByName(column = "KDDOKTER", required = false)
	@Nullable
	@Column(name = "kddokter")
	@Schema(description = "The kdDokter of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdDokter here] end
	private String kddokter;

	// % protected region % [Modify attribute annotation for nmDokter here] off begin
	@CsvBindByName(column = "NMDOKTER", required = false)
	@Nullable
	@Column(name = "nmdokter")
	@Schema(description = "The nmDokter of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmDokter here] end
	private String nmdokter;

	// % protected region % [Modify attribute annotation for nmTacc here] off begin
	@CsvBindByName(column = "NMTACC", required = false)
	@Nullable
	@Column(name = "nmtacc")
	@Schema(description = "The nmTacc of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmTacc here] end
	private String nmtacc;

	// % protected region % [Modify attribute annotation for alasanTacc here] off begin
	@CsvBindByName(column = "ALASANTACC", required = false)
	@Nullable
	@Column(name = "alasantacc")
	@Schema(description = "The alasanTacc of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for alasanTacc here] end
	private String alasantacc;

	// % protected region % [Modify attribute annotation for infoDenda here] off begin
	@CsvBindByName(column = "INFODENDA", required = false)
	@Nullable
	@Column(name = "infodenda")
	@Schema(description = "The infoDenda of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for infoDenda here] end
	private String infodenda;

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
		return "NORUJUKAN,KDPPK,NMPPK,ALAMAT,KDKC,NMKC,ALAMATKC,TELPKC,FAXKC,KDPROP,KDDATI,NMDATI,KDKR,NMKR,ALAMATKR,TELPKR,FAXKR,TGLKUNJUNGAN,KDPOLI,NMPOLI,NOKAPST,NMPST,TGLLAHIR,PISA,KETPISA,SEX,KDDIAG1,NMDIAG1,KDDIAG2,NMDIAG2,KDDIAG3,NMDIAG3,CATATAN,KDDOKTER,NMDOKTER,NMTACC,ALASANTACC,INFODENDA,ID";
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
	public boolean equals(Object bpjsPcareKunjunganRujukan) {
		if (this == bpjsPcareKunjunganRujukan) {
			return true;
		}
		if (bpjsPcareKunjunganRujukan == null || this.getClass() != bpjsPcareKunjunganRujukan.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPcareKunjunganRujukan)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPcareKunjunganRujukanEntity that = (BpjsPcareKunjunganRujukanEntity) bpjsPcareKunjunganRujukan;
		return
			Objects.equals(this.norujukan, that.norujukan) &&
			Objects.equals(this.kdppk, that.kdppk) &&
			Objects.equals(this.nmppk, that.nmppk) &&
			Objects.equals(this.alamat, that.alamat) &&
			Objects.equals(this.kdkc, that.kdkc) &&
			Objects.equals(this.nmkc, that.nmkc) &&
			Objects.equals(this.alamatkc, that.alamatkc) &&
			Objects.equals(this.telpkc, that.telpkc) &&
			Objects.equals(this.faxkc, that.faxkc) &&
			Objects.equals(this.kdprop, that.kdprop) &&
			Objects.equals(this.kddati, that.kddati) &&
			Objects.equals(this.nmdati, that.nmdati) &&
			Objects.equals(this.kdkr, that.kdkr) &&
			Objects.equals(this.nmkr, that.nmkr) &&
			Objects.equals(this.alamatkr, that.alamatkr) &&
			Objects.equals(this.telpkr, that.telpkr) &&
			Objects.equals(this.faxkr, that.faxkr) &&
			Objects.equals(this.tglkunjungan, that.tglkunjungan) &&
			Objects.equals(this.kdpoli, that.kdpoli) &&
			Objects.equals(this.nmpoli, that.nmpoli) &&
			Objects.equals(this.nokapst, that.nokapst) &&
			Objects.equals(this.nmpst, that.nmpst) &&
			Objects.equals(this.tgllahir, that.tgllahir) &&
			Objects.equals(this.pisa, that.pisa) &&
			Objects.equals(this.ketpisa, that.ketpisa) &&
			Objects.equals(this.sex, that.sex) &&
			Objects.equals(this.kddiag1, that.kddiag1) &&
			Objects.equals(this.nmdiag1, that.nmdiag1) &&
			Objects.equals(this.kddiag2, that.kddiag2) &&
			Objects.equals(this.nmdiag2, that.nmdiag2) &&
			Objects.equals(this.kddiag3, that.kddiag3) &&
			Objects.equals(this.nmdiag3, that.nmdiag3) &&
			Objects.equals(this.catatan, that.catatan) &&
			Objects.equals(this.kddokter, that.kddokter) &&
			Objects.equals(this.nmdokter, that.nmdokter) &&
			Objects.equals(this.nmtacc, that.nmtacc) &&
			Objects.equals(this.alasantacc, that.alasantacc) &&
			Objects.equals(this.infodenda, that.infodenda);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
