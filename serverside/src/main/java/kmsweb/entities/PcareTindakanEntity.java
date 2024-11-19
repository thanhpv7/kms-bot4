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
import kmsweb.dtos.PcareTindakanEntityDto;
import kmsweb.entities.listeners.PcareTindakanEntityListener;
import kmsweb.serializers.PcareTindakanSerializer;
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
@EntityListeners({PcareTindakanEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareTindakanSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PcareTindakanEntity extends AbstractEntity {

	/**
	 * Takes a PcareTindakanEntityDto and converts it into a PcareTindakanEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareTindakanEntityDto
	 */
	public PcareTindakanEntity(PcareTindakanEntityDto pcareTindakanEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareTindakanEntityDto.getId() != null) {
			this.setId(pcareTindakanEntityDto.getId());
		}

		if (pcareTindakanEntityDto.getKodeTindakan() != null) {
			this.setKodeTindakan(pcareTindakanEntityDto.getKodeTindakan());
		}

		if (pcareTindakanEntityDto.getNamaTindakan() != null) {
			this.setNamaTindakan(pcareTindakanEntityDto.getNamaTindakan());
		}

		if (pcareTindakanEntityDto.getMaksimalTarif() != null) {
			this.setMaksimalTarif(pcareTindakanEntityDto.getMaksimalTarif());
		}

		if (pcareTindakanEntityDto.getWithvalue() != null) {
			this.setWithvalue(pcareTindakanEntityDto.getWithvalue());
		}

		if (pcareTindakanEntityDto.getTindakanInternal() != null) {
			this.setTindakanInternal(pcareTindakanEntityDto.getTindakanInternal());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Kode Tindakan here] off begin
	@CsvBindByName(column = "KODE_TINDAKAN", required = false)
	@Nullable
	@Column(name = "kode_tindakan")
	@Schema(description = "The Kode Tindakan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kode Tindakan here] end
	private String kodeTindakan;

	// % protected region % [Modify attribute annotation for Nama Tindakan here] off begin
	@CsvBindByName(column = "NAMA_TINDAKAN", required = false)
	@Nullable
	@Column(name = "nama_tindakan")
	@Schema(description = "The Nama Tindakan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nama Tindakan here] end
	private String namaTindakan;

	// % protected region % [Modify attribute annotation for Maksimal Tarif here] off begin
	@CsvBindByName(column = "MAKSIMAL_TARIF", required = false)
	@Nullable
	@Column(name = "maksimal_tarif")
	@Schema(description = "The Maksimal Tarif of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Maksimal Tarif here] end
	private String maksimalTarif;

	// % protected region % [Modify attribute annotation for withValue here] off begin
	@CsvBindByName(column = "WITHVALUE", required = false)
	@Nullable
	@Column(name = "withvalue")
	@Schema(description = "The withValue of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for withValue here] end
	private Boolean withvalue = false ;

	// % protected region % [Modify attribute annotation for Tindakan Internal here] off begin
	@CsvBindByName(column = "TINDAKAN_INTERNAL", required = false)
	@Nullable
	@Column(name = "tindakan_internal")
	@Schema(description = "The Tindakan Internal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tindakan Internal here] end
	private String tindakanInternal;

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
		return "KODE_TINDAKAN,NAMA_TINDAKAN,MAKSIMAL_TARIF,WITHVALUE,TINDAKAN_INTERNAL,ID";
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
	public boolean equals(Object pcareTindakan) {
		if (this == pcareTindakan) {
			return true;
		}
		if (pcareTindakan == null || this.getClass() != pcareTindakan.getClass()) {
			return false;
		}
		if (!super.equals(pcareTindakan)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareTindakanEntity that = (PcareTindakanEntity) pcareTindakan;
		return
			Objects.equals(this.kodeTindakan, that.kodeTindakan) &&
			Objects.equals(this.namaTindakan, that.namaTindakan) &&
			Objects.equals(this.maksimalTarif, that.maksimalTarif) &&
			Objects.equals(this.withvalue, that.withvalue) &&
			Objects.equals(this.tindakanInternal, that.tindakanInternal);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
