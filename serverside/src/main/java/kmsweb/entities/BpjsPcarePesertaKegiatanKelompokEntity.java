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
import kmsweb.dtos.BpjsPcarePesertaKegiatanKelompokEntityDto;
import kmsweb.entities.listeners.BpjsPcarePesertaKegiatanKelompokEntityListener;
import kmsweb.serializers.BpjsPcarePesertaKegiatanKelompokSerializer;
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
@EntityListeners({BpjsPcarePesertaKegiatanKelompokEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPcarePesertaKegiatanKelompokSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPcarePesertaKegiatanKelompokEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPcarePesertaKegiatanKelompokEntityDto and converts it into a BpjsPcarePesertaKegiatanKelompokEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPcarePesertaKegiatanKelompokEntityDto
	 */
	public BpjsPcarePesertaKegiatanKelompokEntity(BpjsPcarePesertaKegiatanKelompokEntityDto bpjsPcarePesertaKegiatanKelompokEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getId() != null) {
			this.setId(bpjsPcarePesertaKegiatanKelompokEntityDto.getId());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getEduid() != null) {
			this.setEduid(bpjsPcarePesertaKegiatanKelompokEntityDto.getEduid());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getNokartu() != null) {
			this.setNokartu(bpjsPcarePesertaKegiatanKelompokEntityDto.getNokartu());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getNama() != null) {
			this.setNama(bpjsPcarePesertaKegiatanKelompokEntityDto.getNama());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getHubungankeluarga() != null) {
			this.setHubungankeluarga(bpjsPcarePesertaKegiatanKelompokEntityDto.getHubungankeluarga());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getSex() != null) {
			this.setSex(bpjsPcarePesertaKegiatanKelompokEntityDto.getSex());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getTgllahir() != null) {
			this.setTgllahir(bpjsPcarePesertaKegiatanKelompokEntityDto.getTgllahir());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getTglmulaiaktif() != null) {
			this.setTglmulaiaktif(bpjsPcarePesertaKegiatanKelompokEntityDto.getTglmulaiaktif());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getTglakhirberlaku() != null) {
			this.setTglakhirberlaku(bpjsPcarePesertaKegiatanKelompokEntityDto.getTglakhirberlaku());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getKdprovider() != null) {
			this.setKdprovider(bpjsPcarePesertaKegiatanKelompokEntityDto.getKdprovider());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getNmprovider() != null) {
			this.setNmprovider(bpjsPcarePesertaKegiatanKelompokEntityDto.getNmprovider());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getKdprovidergigi() != null) {
			this.setKdprovidergigi(bpjsPcarePesertaKegiatanKelompokEntityDto.getKdprovidergigi());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getNmprovidergigi() != null) {
			this.setNmprovidergigi(bpjsPcarePesertaKegiatanKelompokEntityDto.getNmprovidergigi());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getNamakelas() != null) {
			this.setNamakelas(bpjsPcarePesertaKegiatanKelompokEntityDto.getNamakelas());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getKodekelas() != null) {
			this.setKodekelas(bpjsPcarePesertaKegiatanKelompokEntityDto.getKodekelas());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getNamapeserta() != null) {
			this.setNamapeserta(bpjsPcarePesertaKegiatanKelompokEntityDto.getNamapeserta());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getKodepeserta() != null) {
			this.setKodepeserta(bpjsPcarePesertaKegiatanKelompokEntityDto.getKodepeserta());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getGoldarah() != null) {
			this.setGoldarah(bpjsPcarePesertaKegiatanKelompokEntityDto.getGoldarah());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getNohp() != null) {
			this.setNohp(bpjsPcarePesertaKegiatanKelompokEntityDto.getNohp());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getNoktp() != null) {
			this.setNoktp(bpjsPcarePesertaKegiatanKelompokEntityDto.getNoktp());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getPstprol() != null) {
			this.setPstprol(bpjsPcarePesertaKegiatanKelompokEntityDto.getPstprol());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getPstprb() != null) {
			this.setPstprb(bpjsPcarePesertaKegiatanKelompokEntityDto.getPstprb());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getKetaktif() != null) {
			this.setKetaktif(bpjsPcarePesertaKegiatanKelompokEntityDto.getKetaktif());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getKdasuransi() != null) {
			this.setKdasuransi(bpjsPcarePesertaKegiatanKelompokEntityDto.getKdasuransi());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getNmasuransi() != null) {
			this.setNmasuransi(bpjsPcarePesertaKegiatanKelompokEntityDto.getNmasuransi());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getNoasuransi() != null) {
			this.setNoasuransi(bpjsPcarePesertaKegiatanKelompokEntityDto.getNoasuransi());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getCob() != null) {
			this.setCob(bpjsPcarePesertaKegiatanKelompokEntityDto.getCob());
		}

		if (bpjsPcarePesertaKegiatanKelompokEntityDto.getTunggakan() != null) {
			this.setTunggakan(bpjsPcarePesertaKegiatanKelompokEntityDto.getTunggakan());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for eduId here] off begin
	@CsvBindByName(column = "EDUID", required = false)
	@Nullable
	@Column(name = "eduid")
	@Schema(description = "The eduId of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for eduId here] end
	private String eduid;

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

	// % protected region % [Modify attribute annotation for kdProvider here] off begin
	@CsvBindByName(column = "KDPROVIDER", required = false)
	@Nullable
	@Column(name = "kdprovider")
	@Schema(description = "The kdProvider of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdProvider here] end
	private String kdprovider;

	// % protected region % [Modify attribute annotation for nmProvider here] off begin
	@CsvBindByName(column = "NMPROVIDER", required = false)
	@Nullable
	@Column(name = "nmprovider")
	@Schema(description = "The nmProvider of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmProvider here] end
	private String nmprovider;

	// % protected region % [Modify attribute annotation for kdProviderGigi here] off begin
	@CsvBindByName(column = "KDPROVIDERGIGI", required = false)
	@Nullable
	@Column(name = "kdprovidergigi")
	@Schema(description = "The kdProviderGigi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdProviderGigi here] end
	private String kdprovidergigi;

	// % protected region % [Modify attribute annotation for nmProviderGigi here] off begin
	@CsvBindByName(column = "NMPROVIDERGIGI", required = false)
	@Nullable
	@Column(name = "nmprovidergigi")
	@Schema(description = "The nmProviderGigi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmProviderGigi here] end
	private String nmprovidergigi;

	// % protected region % [Modify attribute annotation for namaKelas here] off begin
	@CsvBindByName(column = "NAMAKELAS", required = false)
	@Nullable
	@Column(name = "namakelas")
	@Schema(description = "The namaKelas of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for namaKelas here] end
	private String namakelas;

	// % protected region % [Modify attribute annotation for kodeKelas here] off begin
	@CsvBindByName(column = "KODEKELAS", required = false)
	@Nullable
	@Column(name = "kodekelas")
	@Schema(description = "The kodeKelas of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodeKelas here] end
	private String kodekelas;

	// % protected region % [Modify attribute annotation for namaPeserta here] off begin
	@CsvBindByName(column = "NAMAPESERTA", required = false)
	@Nullable
	@Column(name = "namapeserta")
	@Schema(description = "The namaPeserta of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for namaPeserta here] end
	private String namapeserta;

	// % protected region % [Modify attribute annotation for kodePeserta here] off begin
	@CsvBindByName(column = "KODEPESERTA", required = false)
	@Nullable
	@Column(name = "kodepeserta")
	@Schema(description = "The kodePeserta of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodePeserta here] end
	private String kodepeserta;

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

	// % protected region % [Modify attribute annotation for pstProl here] off begin
	@CsvBindByName(column = "PSTPROL", required = false)
	@Nullable
	@Column(name = "pstprol")
	@Schema(description = "The pstProl of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for pstProl here] end
	private String pstprol;

	// % protected region % [Modify attribute annotation for pstPrb here] off begin
	@CsvBindByName(column = "PSTPRB", required = false)
	@Nullable
	@Column(name = "pstprb")
	@Schema(description = "The pstPrb of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for pstPrb here] end
	private String pstprb;

	// % protected region % [Modify attribute annotation for ketAktif here] off begin
	@CsvBindByName(column = "KETAKTIF", required = false)
	@Nullable
	@Column(name = "ketaktif")
	@Schema(description = "The ketAktif of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ketAktif here] end
	private String ketaktif;

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

	// % protected region % [Modify attribute annotation for cob here] off begin
	@CsvBindByName(column = "COB", required = false)
	@Nullable
	@Column(name = "cob")
	@Schema(description = "The cob of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for cob here] end
	private String cob;

	// % protected region % [Modify attribute annotation for tunggakan here] off begin
	@CsvBindByName(column = "TUNGGAKAN", required = false)
	@Nullable
	@Column(name = "tunggakan")
	@Schema(description = "The tunggakan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tunggakan here] end
	private String tunggakan;

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
		return "EDUID,NOKARTU,NAMA,HUBUNGANKELUARGA,SEX,TGLLAHIR,TGLMULAIAKTIF,TGLAKHIRBERLAKU,KDPROVIDER,NMPROVIDER,KDPROVIDERGIGI,NMPROVIDERGIGI,NAMAKELAS,KODEKELAS,NAMAPESERTA,KODEPESERTA,GOLDARAH,NOHP,NOKTP,PSTPROL,PSTPRB,KETAKTIF,KDASURANSI,NMASURANSI,NOASURANSI,COB,TUNGGAKAN,ID";
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
	public boolean equals(Object bpjsPcarePesertaKegiatanKelompok) {
		if (this == bpjsPcarePesertaKegiatanKelompok) {
			return true;
		}
		if (bpjsPcarePesertaKegiatanKelompok == null || this.getClass() != bpjsPcarePesertaKegiatanKelompok.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPcarePesertaKegiatanKelompok)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPcarePesertaKegiatanKelompokEntity that = (BpjsPcarePesertaKegiatanKelompokEntity) bpjsPcarePesertaKegiatanKelompok;
		return
			Objects.equals(this.eduid, that.eduid) &&
			Objects.equals(this.nokartu, that.nokartu) &&
			Objects.equals(this.nama, that.nama) &&
			Objects.equals(this.hubungankeluarga, that.hubungankeluarga) &&
			Objects.equals(this.sex, that.sex) &&
			Objects.equals(this.tgllahir, that.tgllahir) &&
			Objects.equals(this.tglmulaiaktif, that.tglmulaiaktif) &&
			Objects.equals(this.tglakhirberlaku, that.tglakhirberlaku) &&
			Objects.equals(this.kdprovider, that.kdprovider) &&
			Objects.equals(this.nmprovider, that.nmprovider) &&
			Objects.equals(this.kdprovidergigi, that.kdprovidergigi) &&
			Objects.equals(this.nmprovidergigi, that.nmprovidergigi) &&
			Objects.equals(this.namakelas, that.namakelas) &&
			Objects.equals(this.kodekelas, that.kodekelas) &&
			Objects.equals(this.namapeserta, that.namapeserta) &&
			Objects.equals(this.kodepeserta, that.kodepeserta) &&
			Objects.equals(this.goldarah, that.goldarah) &&
			Objects.equals(this.nohp, that.nohp) &&
			Objects.equals(this.noktp, that.noktp) &&
			Objects.equals(this.pstprol, that.pstprol) &&
			Objects.equals(this.pstprb, that.pstprb) &&
			Objects.equals(this.ketaktif, that.ketaktif) &&
			Objects.equals(this.kdasuransi, that.kdasuransi) &&
			Objects.equals(this.nmasuransi, that.nmasuransi) &&
			Objects.equals(this.noasuransi, that.noasuransi) &&
			Objects.equals(this.cob, that.cob) &&
			Objects.equals(this.tunggakan, that.tunggakan);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
