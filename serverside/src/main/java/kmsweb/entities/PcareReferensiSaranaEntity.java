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
import kmsweb.dtos.PcareReferensiSaranaEntityDto;
import kmsweb.entities.listeners.PcareReferensiSaranaEntityListener;
import kmsweb.serializers.PcareReferensiSaranaSerializer;
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
@EntityListeners({PcareReferensiSaranaEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareReferensiSaranaSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PcareReferensiSaranaEntity extends AbstractEntity {

	/**
	 * Takes a PcareReferensiSaranaEntityDto and converts it into a PcareReferensiSaranaEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareReferensiSaranaEntityDto
	 */
	public PcareReferensiSaranaEntity(PcareReferensiSaranaEntityDto pcareReferensiSaranaEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareReferensiSaranaEntityDto.getId() != null) {
			this.setId(pcareReferensiSaranaEntityDto.getId());
		}

		if (pcareReferensiSaranaEntityDto.getKodeSarana() != null) {
			this.setKodeSarana(pcareReferensiSaranaEntityDto.getKodeSarana());
		}

		if (pcareReferensiSaranaEntityDto.getNamaSarana() != null) {
			this.setNamaSarana(pcareReferensiSaranaEntityDto.getNamaSarana());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Kode Sarana here] off begin
	@CsvBindByName(column = "KODE_SARANA", required = false)
	@Nullable
	@Column(name = "kode_sarana")
	@Schema(description = "The Kode Sarana of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kode Sarana here] end
	private String kodeSarana;

	// % protected region % [Modify attribute annotation for Nama Sarana here] off begin
	@CsvBindByName(column = "NAMA_SARANA", required = false)
	@Nullable
	@Column(name = "nama_sarana")
	@Schema(description = "The Nama Sarana of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nama Sarana here] end
	private String namaSarana;

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
		return "KODE_SARANA,NAMA_SARANA,ID";
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
	public boolean equals(Object pcareReferensiSarana) {
		if (this == pcareReferensiSarana) {
			return true;
		}
		if (pcareReferensiSarana == null || this.getClass() != pcareReferensiSarana.getClass()) {
			return false;
		}
		if (!super.equals(pcareReferensiSarana)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareReferensiSaranaEntity that = (PcareReferensiSaranaEntity) pcareReferensiSarana;
		return
			Objects.equals(this.kodeSarana, that.kodeSarana) &&
			Objects.equals(this.namaSarana, that.namaSarana);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
