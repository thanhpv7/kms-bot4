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
import kmsweb.dtos.PcareClubProlanisEntityDto;
import kmsweb.entities.listeners.PcareClubProlanisEntityListener;
import kmsweb.serializers.PcareClubProlanisSerializer;
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
@EntityListeners({PcareClubProlanisEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareClubProlanisSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PcareClubProlanisEntity extends AbstractEntity {

	/**
	 * Takes a PcareClubProlanisEntityDto and converts it into a PcareClubProlanisEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareClubProlanisEntityDto
	 */
	public PcareClubProlanisEntity(PcareClubProlanisEntityDto pcareClubProlanisEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareClubProlanisEntityDto.getId() != null) {
			this.setId(pcareClubProlanisEntityDto.getId());
		}

		if (pcareClubProlanisEntityDto.getClubID() != null) {
			this.setClubID(pcareClubProlanisEntityDto.getClubID());
		}

		if (pcareClubProlanisEntityDto.getKodeProgram() != null) {
			this.setKodeProgram(pcareClubProlanisEntityDto.getKodeProgram());
		}

		if (pcareClubProlanisEntityDto.getNamaProgram() != null) {
			this.setNamaProgram(pcareClubProlanisEntityDto.getNamaProgram());
		}

		if (pcareClubProlanisEntityDto.getTanggalMulai() != null) {
			this.setTanggalMulai(pcareClubProlanisEntityDto.getTanggalMulai());
		}

		if (pcareClubProlanisEntityDto.getTanggalAkhir() != null) {
			this.setTanggalAkhir(pcareClubProlanisEntityDto.getTanggalAkhir());
		}

		if (pcareClubProlanisEntityDto.getAlamatClub() != null) {
			this.setAlamatClub(pcareClubProlanisEntityDto.getAlamatClub());
		}

		if (pcareClubProlanisEntityDto.getNamaClub() != null) {
			this.setNamaClub(pcareClubProlanisEntityDto.getNamaClub());
		}

		if (pcareClubProlanisEntityDto.getNoHPKetua() != null) {
			this.setNoHPKetua(pcareClubProlanisEntityDto.getNoHPKetua());
		}

		if (pcareClubProlanisEntityDto.getNamaKetua() != null) {
			this.setNamaKetua(pcareClubProlanisEntityDto.getNamaKetua());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Club ID here] off begin
	@CsvBindByName(column = "CLUB_ID", required = false)
	@Nullable
	@Column(name = "club_id")
	@Schema(description = "The Club ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Club ID here] end
	private String clubID;

	// % protected region % [Modify attribute annotation for Kode Program here] off begin
	@CsvBindByName(column = "KODE_PROGRAM", required = false)
	@Nullable
	@Column(name = "kode_program")
	@Schema(description = "The Kode Program of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kode Program here] end
	private String kodeProgram;

	// % protected region % [Modify attribute annotation for Nama Program here] off begin
	@CsvBindByName(column = "NAMA_PROGRAM", required = false)
	@Nullable
	@Column(name = "nama_program")
	@Schema(description = "The Nama Program of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nama Program here] end
	private String namaProgram;

	// % protected region % [Modify attribute annotation for Tanggal Mulai here] off begin
	@CsvBindByName(column = "TANGGAL_MULAI", required = false)
	@Nullable
	@Column(name = "tanggal_mulai")
	@Schema(description = "The Tanggal Mulai of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tanggal Mulai here] end
	private String tanggalMulai;

	// % protected region % [Modify attribute annotation for Tanggal Akhir here] off begin
	@CsvBindByName(column = "TANGGAL_AKHIR", required = false)
	@Nullable
	@Column(name = "tanggal_akhir")
	@Schema(description = "The Tanggal Akhir of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tanggal Akhir here] end
	private String tanggalAkhir;

	// % protected region % [Modify attribute annotation for Alamat Club here] off begin
	@CsvBindByName(column = "ALAMAT_CLUB", required = false)
	@Nullable
	@Column(name = "alamat_club")
	@Schema(description = "The Alamat Club of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Alamat Club here] end
	private String alamatClub;

	// % protected region % [Modify attribute annotation for Nama Club here] off begin
	@CsvBindByName(column = "NAMA_CLUB", required = false)
	@Nullable
	@Column(name = "nama_club")
	@Schema(description = "The Nama Club of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nama Club here] end
	private String namaClub;

	// % protected region % [Modify attribute annotation for No HP Ketua here] off begin
	@CsvBindByName(column = "NO_HP_KETUA", required = false)
	@Nullable
	@Column(name = "no_hp_ketua")
	@Schema(description = "The No HP Ketua of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for No HP Ketua here] end
	private String noHPKetua;

	// % protected region % [Modify attribute annotation for Nama Ketua here] off begin
	@CsvBindByName(column = "NAMA_KETUA", required = false)
	@Nullable
	@Column(name = "nama_ketua")
	@Schema(description = "The Nama Ketua of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nama Ketua here] end
	private String namaKetua;

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
		return "CLUB_ID,KODE_PROGRAM,NAMA_PROGRAM,TANGGAL_MULAI,TANGGAL_AKHIR,ALAMAT_CLUB,NAMA_CLUB,NO_HP_KETUA,NAMA_KETUA,ID";
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
	public boolean equals(Object pcareClubProlanis) {
		if (this == pcareClubProlanis) {
			return true;
		}
		if (pcareClubProlanis == null || this.getClass() != pcareClubProlanis.getClass()) {
			return false;
		}
		if (!super.equals(pcareClubProlanis)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareClubProlanisEntity that = (PcareClubProlanisEntity) pcareClubProlanis;
		return
			Objects.equals(this.clubID, that.clubID) &&
			Objects.equals(this.kodeProgram, that.kodeProgram) &&
			Objects.equals(this.namaProgram, that.namaProgram) &&
			Objects.equals(this.tanggalMulai, that.tanggalMulai) &&
			Objects.equals(this.tanggalAkhir, that.tanggalAkhir) &&
			Objects.equals(this.alamatClub, that.alamatClub) &&
			Objects.equals(this.namaClub, that.namaClub) &&
			Objects.equals(this.noHPKetua, that.noHPKetua) &&
			Objects.equals(this.namaKetua, that.namaKetua);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
