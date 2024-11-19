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
import kmsweb.dtos.BpjsPcarePoliEntityDto;
import kmsweb.entities.listeners.BpjsPcarePoliEntityListener;
import kmsweb.serializers.BpjsPcarePoliSerializer;
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
@EntityListeners({BpjsPcarePoliEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPcarePoliSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPcarePoliEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPcarePoliEntityDto and converts it into a BpjsPcarePoliEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPcarePoliEntityDto
	 */
	public BpjsPcarePoliEntity(BpjsPcarePoliEntityDto bpjsPcarePoliEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPcarePoliEntityDto.getId() != null) {
			this.setId(bpjsPcarePoliEntityDto.getId());
		}

		if (bpjsPcarePoliEntityDto.getKdpoli() != null) {
			this.setKdpoli(bpjsPcarePoliEntityDto.getKdpoli());
		}

		if (bpjsPcarePoliEntityDto.getNmpoli() != null) {
			this.setNmpoli(bpjsPcarePoliEntityDto.getNmpoli());
		}

		if (bpjsPcarePoliEntityDto.getPolisakit() != null) {
			this.setPolisakit(bpjsPcarePoliEntityDto.getPolisakit());
		}

		if (bpjsPcarePoliEntityDto.getService() != null) {
			this.setService(bpjsPcarePoliEntityDto.getService());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	private Boolean polisakit = false ;

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

	// % protected region % [Update the annotation for Service here] off begin
	@Schema(description = "The Service entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service here] end
	private ServiceEntity service;

	// % protected region % [Update the annotation for serviceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for serviceId here] end
	private UUID serviceId;

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
	 * Similar to {@link this#setService(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setService(ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update the service in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to service
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setService here] off begin
		// % protected region % [Add any additional logic here before the main logic for setService here] end

		if (sameAsFormer(this.service, entity)) {
			return;
		}

		if (this.service != null) {
			this.service.unsetBpjsPcarePoli(false);
		}

		this.service = entity;
		if (reverseAdd) {
			this.service.setBpjsPcarePoli(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetService(boolean)} but default to true.
	 */
	public void unsetService() {
		this.unsetService(true);
	}

	/**
	 * Remove the ServiceEntity of service from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetService(boolean reverse) {
		if (reverse && this.service != null) {
			this.service.unsetBpjsPcarePoli();
		}
		this.service = null;
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
		return "KDPOLI,NMPOLI,POLISAKIT,SERVICE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<ServiceEntity> serviceRelation = Optional.ofNullable(this.service);
		serviceRelation.ifPresent(entity -> this.serviceId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsPcarePoli) {
		if (this == bpjsPcarePoli) {
			return true;
		}
		if (bpjsPcarePoli == null || this.getClass() != bpjsPcarePoli.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPcarePoli)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPcarePoliEntity that = (BpjsPcarePoliEntity) bpjsPcarePoli;
		return
			Objects.equals(this.kdpoli, that.kdpoli) &&
			Objects.equals(this.nmpoli, that.nmpoli) &&
			Objects.equals(this.polisakit, that.polisakit) &&
			Objects.equals(this.serviceId, that.serviceId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
