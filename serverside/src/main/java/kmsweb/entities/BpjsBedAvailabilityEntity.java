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
import kmsweb.dtos.BpjsBedAvailabilityEntityDto;
import kmsweb.entities.listeners.BpjsBedAvailabilityEntityListener;
import kmsweb.serializers.BpjsBedAvailabilitySerializer;
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
@EntityListeners({BpjsBedAvailabilityEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsBedAvailabilitySerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"koderuang"}, name = "koderuang"),
	}
)
public class BpjsBedAvailabilityEntity extends AbstractEntity {

	/**
	 * Takes a BpjsBedAvailabilityEntityDto and converts it into a BpjsBedAvailabilityEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsBedAvailabilityEntityDto
	 */
	public BpjsBedAvailabilityEntity(BpjsBedAvailabilityEntityDto bpjsBedAvailabilityEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsBedAvailabilityEntityDto.getId() != null) {
			this.setId(bpjsBedAvailabilityEntityDto.getId());
		}

		if (bpjsBedAvailabilityEntityDto.getKoderuang() != null) {
			this.setKoderuang(bpjsBedAvailabilityEntityDto.getKoderuang());
		}

		if (bpjsBedAvailabilityEntityDto.getNamaruang() != null) {
			this.setNamaruang(bpjsBedAvailabilityEntityDto.getNamaruang());
		}

		if (bpjsBedAvailabilityEntityDto.getKodekelas() != null) {
			this.setKodekelas(bpjsBedAvailabilityEntityDto.getKodekelas());
		}

		if (bpjsBedAvailabilityEntityDto.getNamakelas() != null) {
			this.setNamakelas(bpjsBedAvailabilityEntityDto.getNamakelas());
		}

		if (bpjsBedAvailabilityEntityDto.getLastupdate() != null) {
			this.setLastupdate(bpjsBedAvailabilityEntityDto.getLastupdate());
		}

		if (bpjsBedAvailabilityEntityDto.getKapasitas() != null) {
			this.setKapasitas(bpjsBedAvailabilityEntityDto.getKapasitas());
		}

		if (bpjsBedAvailabilityEntityDto.getTersedia() != null) {
			this.setTersedia(bpjsBedAvailabilityEntityDto.getTersedia());
		}

		if (bpjsBedAvailabilityEntityDto.getTersediapria() != null) {
			this.setTersediapria(bpjsBedAvailabilityEntityDto.getTersediapria());
		}

		if (bpjsBedAvailabilityEntityDto.getTersediawanita() != null) {
			this.setTersediawanita(bpjsBedAvailabilityEntityDto.getTersediawanita());
		}

		if (bpjsBedAvailabilityEntityDto.getTersediapriawanita() != null) {
			this.setTersediapriawanita(bpjsBedAvailabilityEntityDto.getTersediapriawanita());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for koderuang here] off begin
	@CsvBindByName(column = "KODERUANG", required = false)
	@Nullable
	@Column(name = "koderuang")
	@Schema(description = "The koderuang of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for koderuang here] end
	private String koderuang;

	// % protected region % [Modify attribute annotation for namaruang here] off begin
	@CsvBindByName(column = "NAMARUANG", required = false)
	@Nullable
	@Column(name = "namaruang")
	@Schema(description = "The namaruang of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for namaruang here] end
	private String namaruang;

	// % protected region % [Modify attribute annotation for kodekelas here] off begin
	@CsvBindByName(column = "KODEKELAS", required = false)
	@Nullable
	@Column(name = "kodekelas")
	@Schema(description = "The kodekelas of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodekelas here] end
	private String kodekelas;

	// % protected region % [Modify attribute annotation for namakelas here] off begin
	@CsvBindByName(column = "NAMAKELAS", required = false)
	@Nullable
	@Column(name = "namakelas")
	@Schema(description = "The namakelas of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for namakelas here] end
	private String namakelas;

	// % protected region % [Modify attribute annotation for lastupdate here] off begin
	@CsvBindByName(column = "LASTUPDATE", required = false)
	@Nullable
	@Column(name = "lastupdate")
	@Schema(description = "The lastupdate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for lastupdate here] end
	private String lastupdate;

	// % protected region % [Modify attribute annotation for kapasitas here] off begin
	@CsvBindByName(column = "KAPASITAS", required = false)
	@Nullable
	@Column(name = "kapasitas")
	@Schema(description = "The kapasitas of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kapasitas here] end
	private Integer kapasitas;

	// % protected region % [Modify attribute annotation for tersedia here] off begin
	@CsvBindByName(column = "TERSEDIA", required = false)
	@Nullable
	@Column(name = "tersedia")
	@Schema(description = "The tersedia of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tersedia here] end
	private Integer tersedia;

	// % protected region % [Modify attribute annotation for tersediapria here] off begin
	@CsvBindByName(column = "TERSEDIAPRIA", required = false)
	@Nullable
	@Column(name = "tersediapria")
	@Schema(description = "The tersediapria of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tersediapria here] end
	private Integer tersediapria;

	// % protected region % [Modify attribute annotation for tersediawanita here] off begin
	@CsvBindByName(column = "TERSEDIAWANITA", required = false)
	@Nullable
	@Column(name = "tersediawanita")
	@Schema(description = "The tersediawanita of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tersediawanita here] end
	private Integer tersediawanita;

	// % protected region % [Modify attribute annotation for tersediapriawanita here] off begin
	@CsvBindByName(column = "TERSEDIAPRIAWANITA", required = false)
	@Nullable
	@Column(name = "tersediapriawanita")
	@Schema(description = "The tersediapriawanita of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tersediapriawanita here] end
	private Integer tersediapriawanita;

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
		return "KODERUANG,NAMARUANG,KODEKELAS,NAMAKELAS,LASTUPDATE,KAPASITAS,TERSEDIA,TERSEDIAPRIA,TERSEDIAWANITA,TERSEDIAPRIAWANITA,ID";
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
	public boolean equals(Object bpjsBedAvailability) {
		if (this == bpjsBedAvailability) {
			return true;
		}
		if (bpjsBedAvailability == null || this.getClass() != bpjsBedAvailability.getClass()) {
			return false;
		}
		if (!super.equals(bpjsBedAvailability)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsBedAvailabilityEntity that = (BpjsBedAvailabilityEntity) bpjsBedAvailability;
		return
			Objects.equals(this.koderuang, that.koderuang) &&
			Objects.equals(this.namaruang, that.namaruang) &&
			Objects.equals(this.kodekelas, that.kodekelas) &&
			Objects.equals(this.namakelas, that.namakelas) &&
			Objects.equals(this.lastupdate, that.lastupdate) &&
			Objects.equals(this.kapasitas, that.kapasitas) &&
			Objects.equals(this.tersedia, that.tersedia) &&
			Objects.equals(this.tersediapria, that.tersediapria) &&
			Objects.equals(this.tersediawanita, that.tersediawanita) &&
			Objects.equals(this.tersediapriawanita, that.tersediapriawanita);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
