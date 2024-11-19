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
import kmsweb.dtos.ServiceItemAssignmentEntityDto;
import kmsweb.entities.listeners.ServiceItemAssignmentEntityListener;
import kmsweb.serializers.ServiceItemAssignmentSerializer;
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
@EntityListeners({ServiceItemAssignmentEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ServiceItemAssignmentSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class ServiceItemAssignmentEntity extends AbstractEntity {

	/**
	 * Takes a ServiceItemAssignmentEntityDto and converts it into a ServiceItemAssignmentEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param serviceItemAssignmentEntityDto
	 */
	public ServiceItemAssignmentEntity(ServiceItemAssignmentEntityDto serviceItemAssignmentEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (serviceItemAssignmentEntityDto.getId() != null) {
			this.setId(serviceItemAssignmentEntityDto.getId());
		}

		if (serviceItemAssignmentEntityDto.getAssignCode() != null) {
			this.setAssignCode(serviceItemAssignmentEntityDto.getAssignCode());
		}

		if (serviceItemAssignmentEntityDto.getServiceItem() != null) {
			this.setServiceItem(serviceItemAssignmentEntityDto.getServiceItem());
		}

		if (serviceItemAssignmentEntityDto.getTariffPackage() != null) {
			this.setTariffPackage(serviceItemAssignmentEntityDto.getTariffPackage());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Assign Code here] off begin
	@CsvBindByName(column = "ASSIGN_CODE", required = false)
	@Nullable
	@Column(name = "assign_code")
	@Schema(description = "The Assign Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Assign Code here] end
	private String assignCode;

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

	// % protected region % [Update the annotation for Service Item here] off begin
	@Schema(description = "The Service Item entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service Item here] end
	private ServiceItemEntity serviceItem;

	// % protected region % [Update the annotation for serviceItemId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ITEM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for serviceItemId here] end
	private UUID serviceItemId;

	// % protected region % [Update the annotation for Tariff Package here] off begin
	@Schema(description = "The Tariff Package entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Package here] end
	private TariffPackageEntity tariffPackage;

	// % protected region % [Update the annotation for tariffPackageId here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_PACKAGE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for tariffPackageId here] end
	private UUID tariffPackageId;

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
	 * Similar to {@link this#setServiceItem(ServiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceItemEntity to be set to this entity
	 */
	public void setServiceItem(@NotNull ServiceItemEntity entity) {
		setServiceItem(entity, true);
	}

	/**
	 * Set or update the serviceItem in this entity with single ServiceItemEntity.
	 *
	 * @param entity the given ServiceItemEntity to be set or updated to serviceItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setServiceItem(@NotNull ServiceItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setServiceItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setServiceItem here] end

		if (sameAsFormer(this.serviceItem, entity)) {
			return;
		}

		if (this.serviceItem != null) {
			this.serviceItem.removeServiceItemAssignments(this, false);
		}
		this.serviceItem = entity;
		if (reverseAdd) {
			this.serviceItem.addServiceItemAssignments(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setServiceItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setServiceItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetServiceItem(boolean)} but default to true.
	 */
	public void unsetServiceItem() {
		this.unsetServiceItem(true);
	}

	/**
	 * Remove Service Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetServiceItem(boolean reverse) {
		if (reverse && this.serviceItem != null) {
			this.serviceItem.removeServiceItemAssignments(this, false);
		}
		this.serviceItem = null;
	}
	/**
	 * Similar to {@link this#setTariffPackage(TariffPackageEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageEntity to be set to this entity
	 */
	public void setTariffPackage(@NotNull TariffPackageEntity entity) {
		setTariffPackage(entity, true);
	}

	/**
	 * Set or update the tariffPackage in this entity with single TariffPackageEntity.
	 *
	 * @param entity the given TariffPackageEntity to be set or updated to tariffPackage
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTariffPackage(@NotNull TariffPackageEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTariffPackage here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTariffPackage here] end

		if (sameAsFormer(this.tariffPackage, entity)) {
			return;
		}

		if (this.tariffPackage != null) {
			this.tariffPackage.removeServiceItemAssignments(this, false);
		}
		this.tariffPackage = entity;
		if (reverseAdd) {
			this.tariffPackage.addServiceItemAssignments(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTariffPackage incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTariffPackage incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTariffPackage(boolean)} but default to true.
	 */
	public void unsetTariffPackage() {
		this.unsetTariffPackage(true);
	}

	/**
	 * Remove Tariff Package in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTariffPackage(boolean reverse) {
		if (reverse && this.tariffPackage != null) {
			this.tariffPackage.removeServiceItemAssignments(this, false);
		}
		this.tariffPackage = null;
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
		return "ASSIGN_CODE,SERVICE_ITEM_ID,TARIFF_PACKAGE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<ServiceItemEntity> serviceItemRelation = Optional.ofNullable(this.serviceItem);
		serviceItemRelation.ifPresent(entity -> this.serviceItemId = entity.getId());

		Optional<TariffPackageEntity> tariffPackageRelation = Optional.ofNullable(this.tariffPackage);
		tariffPackageRelation.ifPresent(entity -> this.tariffPackageId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object serviceItemAssignment) {
		if (this == serviceItemAssignment) {
			return true;
		}
		if (serviceItemAssignment == null || this.getClass() != serviceItemAssignment.getClass()) {
			return false;
		}
		if (!super.equals(serviceItemAssignment)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ServiceItemAssignmentEntity that = (ServiceItemAssignmentEntity) serviceItemAssignment;
		return
			Objects.equals(this.assignCode, that.assignCode) &&
			Objects.equals(this.serviceItemId, that.serviceItemId) &&
			Objects.equals(this.tariffPackageId, that.tariffPackageId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
