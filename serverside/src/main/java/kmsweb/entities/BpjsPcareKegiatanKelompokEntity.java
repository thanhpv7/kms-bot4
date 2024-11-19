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
import kmsweb.dtos.BpjsPcareKegiatanKelompokEntityDto;
import kmsweb.entities.listeners.BpjsPcareKegiatanKelompokEntityListener;
import kmsweb.serializers.BpjsPcareKegiatanKelompokSerializer;
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
@EntityListeners({BpjsPcareKegiatanKelompokEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPcareKegiatanKelompokSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPcareKegiatanKelompokEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPcareKegiatanKelompokEntityDto and converts it into a BpjsPcareKegiatanKelompokEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPcareKegiatanKelompokEntityDto
	 */
	public BpjsPcareKegiatanKelompokEntity(BpjsPcareKegiatanKelompokEntityDto bpjsPcareKegiatanKelompokEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPcareKegiatanKelompokEntityDto.getId() != null) {
			this.setId(bpjsPcareKegiatanKelompokEntityDto.getId());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getKetuanama() != null) {
			this.setKetuanama(bpjsPcareKegiatanKelompokEntityDto.getKetuanama());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getNama() != null) {
			this.setNama(bpjsPcareKegiatanKelompokEntityDto.getNama());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getEduid() != null) {
			this.setEduid(bpjsPcareKegiatanKelompokEntityDto.getEduid());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getClubid() != null) {
			this.setClubid(bpjsPcareKegiatanKelompokEntityDto.getClubid());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getKdprogram() != null) {
			this.setKdprogram(bpjsPcareKegiatanKelompokEntityDto.getKdprogram());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getNmprogram() != null) {
			this.setNmprogram(bpjsPcareKegiatanKelompokEntityDto.getNmprogram());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getTglmulai() != null) {
			this.setTglmulai(bpjsPcareKegiatanKelompokEntityDto.getTglmulai());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getTglakhir() != null) {
			this.setTglakhir(bpjsPcareKegiatanKelompokEntityDto.getTglakhir());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getAlamat() != null) {
			this.setAlamat(bpjsPcareKegiatanKelompokEntityDto.getAlamat());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getKetuanohp() != null) {
			this.setKetuanohp(bpjsPcareKegiatanKelompokEntityDto.getKetuanohp());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getTglpelayanan() != null) {
			this.setTglpelayanan(bpjsPcareKegiatanKelompokEntityDto.getTglpelayanan());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getKegiatannama() != null) {
			this.setKegiatannama(bpjsPcareKegiatanKelompokEntityDto.getKegiatannama());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getKegiatankode() != null) {
			this.setKegiatankode(bpjsPcareKegiatanKelompokEntityDto.getKegiatankode());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getKelompoknama() != null) {
			this.setKelompoknama(bpjsPcareKegiatanKelompokEntityDto.getKelompoknama());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getKelompokkode() != null) {
			this.setKelompokkode(bpjsPcareKegiatanKelompokEntityDto.getKelompokkode());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getMateri() != null) {
			this.setMateri(bpjsPcareKegiatanKelompokEntityDto.getMateri());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getPembicara() != null) {
			this.setPembicara(bpjsPcareKegiatanKelompokEntityDto.getPembicara());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getLokasi() != null) {
			this.setLokasi(bpjsPcareKegiatanKelompokEntityDto.getLokasi());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getKeterangan() != null) {
			this.setKeterangan(bpjsPcareKegiatanKelompokEntityDto.getKeterangan());
		}

		if (bpjsPcareKegiatanKelompokEntityDto.getBiaya() != null) {
			this.setBiaya(bpjsPcareKegiatanKelompokEntityDto.getBiaya());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for ketuaNama here] off begin
	@CsvBindByName(column = "KETUANAMA", required = false)
	@Nullable
	@Column(name = "ketuanama")
	@Schema(description = "The ketuaNama of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ketuaNama here] end
	private String ketuanama;

	// % protected region % [Modify attribute annotation for nama here] off begin
	@CsvBindByName(column = "NAMA", required = false)
	@Nullable
	@Column(name = "nama")
	@Schema(description = "The nama of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nama here] end
	private String nama;

	// % protected region % [Modify attribute annotation for eduId here] off begin
	@CsvBindByName(column = "EDUID", required = false)
	@Nullable
	@Column(name = "eduid")
	@Schema(description = "The eduId of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for eduId here] end
	private String eduid;

	// % protected region % [Modify attribute annotation for clubId here] off begin
	@CsvBindByName(column = "CLUBID", required = false)
	@Nullable
	@Column(name = "clubid")
	@Schema(description = "The clubId of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for clubId here] end
	private String clubid;

	// % protected region % [Modify attribute annotation for kdProgram here] off begin
	@CsvBindByName(column = "KDPROGRAM", required = false)
	@Nullable
	@Column(name = "kdprogram")
	@Schema(description = "The kdProgram of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdProgram here] end
	private String kdprogram;

	// % protected region % [Modify attribute annotation for nmProgram here] off begin
	@CsvBindByName(column = "NMPROGRAM", required = false)
	@Nullable
	@Column(name = "nmprogram")
	@Schema(description = "The nmProgram of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmProgram here] end
	private String nmprogram;

	// % protected region % [Modify attribute annotation for tglMulai here] off begin
	@CsvBindByName(column = "TGLMULAI", required = false)
	@Nullable
	@Column(name = "tglmulai")
	@Schema(description = "The tglMulai of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglMulai here] end
	private String tglmulai;

	// % protected region % [Modify attribute annotation for tglAkhir here] off begin
	@CsvBindByName(column = "TGLAKHIR", required = false)
	@Nullable
	@Column(name = "tglakhir")
	@Schema(description = "The tglAkhir of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglAkhir here] end
	private String tglakhir;

	// % protected region % [Modify attribute annotation for alamat here] off begin
	@CsvBindByName(column = "ALAMAT", required = false)
	@Nullable
	@Column(name = "alamat")
	@Schema(description = "The alamat of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for alamat here] end
	private String alamat;

	// % protected region % [Modify attribute annotation for ketuaNoHp here] off begin
	@CsvBindByName(column = "KETUANOHP", required = false)
	@Nullable
	@Column(name = "ketuanohp")
	@Schema(description = "The ketuaNoHp of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ketuaNoHp here] end
	private String ketuanohp;

	// % protected region % [Modify attribute annotation for tglPelayanan here] off begin
	@CsvBindByName(column = "TGLPELAYANAN", required = false)
	@Nullable
	@Column(name = "tglpelayanan")
	@Schema(description = "The tglPelayanan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglPelayanan here] end
	private String tglpelayanan;

	// % protected region % [Modify attribute annotation for kegiatanNama here] off begin
	@CsvBindByName(column = "KEGIATANNAMA", required = false)
	@Nullable
	@Column(name = "kegiatannama")
	@Schema(description = "The kegiatanNama of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kegiatanNama here] end
	private String kegiatannama;

	// % protected region % [Modify attribute annotation for kegiatanKode here] off begin
	@CsvBindByName(column = "KEGIATANKODE", required = false)
	@Nullable
	@Column(name = "kegiatankode")
	@Schema(description = "The kegiatanKode of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kegiatanKode here] end
	private String kegiatankode;

	// % protected region % [Modify attribute annotation for kelompokNama here] off begin
	@CsvBindByName(column = "KELOMPOKNAMA", required = false)
	@Nullable
	@Column(name = "kelompoknama")
	@Schema(description = "The kelompokNama of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kelompokNama here] end
	private String kelompoknama;

	// % protected region % [Modify attribute annotation for kelompokKode here] off begin
	@CsvBindByName(column = "KELOMPOKKODE", required = false)
	@Nullable
	@Column(name = "kelompokkode")
	@Schema(description = "The kelompokKode of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kelompokKode here] end
	private String kelompokkode;

	// % protected region % [Modify attribute annotation for materi here] off begin
	@CsvBindByName(column = "MATERI", required = false)
	@Nullable
	@Column(name = "materi")
	@Schema(description = "The materi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for materi here] end
	private String materi;

	// % protected region % [Modify attribute annotation for pembicara here] off begin
	@CsvBindByName(column = "PEMBICARA", required = false)
	@Nullable
	@Column(name = "pembicara")
	@Schema(description = "The pembicara of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for pembicara here] end
	private String pembicara;

	// % protected region % [Modify attribute annotation for lokasi here] off begin
	@CsvBindByName(column = "LOKASI", required = false)
	@Nullable
	@Column(name = "lokasi")
	@Schema(description = "The lokasi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for lokasi here] end
	private String lokasi;

	// % protected region % [Modify attribute annotation for keterangan here] off begin
	@CsvBindByName(column = "KETERANGAN", required = false)
	@Nullable
	@Column(name = "keterangan")
	@Schema(description = "The keterangan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for keterangan here] end
	private String keterangan;

	// % protected region % [Modify attribute annotation for biaya here] off begin
	@CsvBindByName(column = "BIAYA", required = false)
	@Nullable
	@Column(name = "biaya")
	@Schema(description = "The biaya of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for biaya here] end
	private String biaya;

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
		return "KETUANAMA,NAMA,EDUID,CLUBID,KDPROGRAM,NMPROGRAM,TGLMULAI,TGLAKHIR,ALAMAT,KETUANOHP,TGLPELAYANAN,KEGIATANNAMA,KEGIATANKODE,KELOMPOKNAMA,KELOMPOKKODE,MATERI,PEMBICARA,LOKASI,KETERANGAN,BIAYA,ID";
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
	public boolean equals(Object bpjsPcareKegiatanKelompok) {
		if (this == bpjsPcareKegiatanKelompok) {
			return true;
		}
		if (bpjsPcareKegiatanKelompok == null || this.getClass() != bpjsPcareKegiatanKelompok.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPcareKegiatanKelompok)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPcareKegiatanKelompokEntity that = (BpjsPcareKegiatanKelompokEntity) bpjsPcareKegiatanKelompok;
		return
			Objects.equals(this.ketuanama, that.ketuanama) &&
			Objects.equals(this.nama, that.nama) &&
			Objects.equals(this.eduid, that.eduid) &&
			Objects.equals(this.clubid, that.clubid) &&
			Objects.equals(this.kdprogram, that.kdprogram) &&
			Objects.equals(this.nmprogram, that.nmprogram) &&
			Objects.equals(this.tglmulai, that.tglmulai) &&
			Objects.equals(this.tglakhir, that.tglakhir) &&
			Objects.equals(this.alamat, that.alamat) &&
			Objects.equals(this.ketuanohp, that.ketuanohp) &&
			Objects.equals(this.tglpelayanan, that.tglpelayanan) &&
			Objects.equals(this.kegiatannama, that.kegiatannama) &&
			Objects.equals(this.kegiatankode, that.kegiatankode) &&
			Objects.equals(this.kelompoknama, that.kelompoknama) &&
			Objects.equals(this.kelompokkode, that.kelompokkode) &&
			Objects.equals(this.materi, that.materi) &&
			Objects.equals(this.pembicara, that.pembicara) &&
			Objects.equals(this.lokasi, that.lokasi) &&
			Objects.equals(this.keterangan, that.keterangan) &&
			Objects.equals(this.biaya, that.biaya);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
