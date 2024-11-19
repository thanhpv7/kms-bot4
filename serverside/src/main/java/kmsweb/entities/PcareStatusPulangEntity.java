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
import kmsweb.dtos.PcareStatusPulangEntityDto;
import kmsweb.entities.listeners.PcareStatusPulangEntityListener;
import kmsweb.serializers.PcareStatusPulangSerializer;
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
@EntityListeners({PcareStatusPulangEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareStatusPulangSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PcareStatusPulangEntity extends AbstractEntity {

	/**
	 * Takes a PcareStatusPulangEntityDto and converts it into a PcareStatusPulangEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareStatusPulangEntityDto
	 */
	public PcareStatusPulangEntity(PcareStatusPulangEntityDto pcareStatusPulangEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareStatusPulangEntityDto.getId() != null) {
			this.setId(pcareStatusPulangEntityDto.getId());
		}

		if (pcareStatusPulangEntityDto.getKodeStatusPulang() != null) {
			this.setKodeStatusPulang(pcareStatusPulangEntityDto.getKodeStatusPulang());
		}

		if (pcareStatusPulangEntityDto.getNamaStatusPulang() != null) {
			this.setNamaStatusPulang(pcareStatusPulangEntityDto.getNamaStatusPulang());
		}

		if (pcareStatusPulangEntityDto.getKodeReferensiInternal() != null) {
			this.setKodeReferensiInternal(pcareStatusPulangEntityDto.getKodeReferensiInternal());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Kode Status Pulang here] off begin
	@CsvBindByName(column = "KODE_STATUS_PULANG", required = false)
	@Nullable
	@Column(name = "kode_status_pulang")
	@Schema(description = "The Kode Status Pulang of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kode Status Pulang here] end
	private String kodeStatusPulang;

	// % protected region % [Modify attribute annotation for Nama Status Pulang here] off begin
	@CsvBindByName(column = "NAMA_STATUS_PULANG", required = false)
	@Nullable
	@Column(name = "nama_status_pulang")
	@Schema(description = "The Nama Status Pulang of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nama Status Pulang here] end
	private String namaStatusPulang;

	// % protected region % [Modify attribute annotation for Kode Referensi Internal here] off begin
	@CsvBindByName(column = "KODE_REFERENSI_INTERNAL", required = false)
	@Nullable
	@Column(name = "kode_referensi_internal")
	@Schema(description = "The Kode Referensi Internal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kode Referensi Internal here] end
	private String kodeReferensiInternal;

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
		return "KODE_STATUS_PULANG,NAMA_STATUS_PULANG,KODE_REFERENSI_INTERNAL,ID";
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
	public boolean equals(Object pcareStatusPulang) {
		if (this == pcareStatusPulang) {
			return true;
		}
		if (pcareStatusPulang == null || this.getClass() != pcareStatusPulang.getClass()) {
			return false;
		}
		if (!super.equals(pcareStatusPulang)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareStatusPulangEntity that = (PcareStatusPulangEntity) pcareStatusPulang;
		return
			Objects.equals(this.kodeStatusPulang, that.kodeStatusPulang) &&
			Objects.equals(this.namaStatusPulang, that.namaStatusPulang) &&
			Objects.equals(this.kodeReferensiInternal, that.kodeReferensiInternal);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
