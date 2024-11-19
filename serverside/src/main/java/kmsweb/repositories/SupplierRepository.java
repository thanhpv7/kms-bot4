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
package kmsweb.repositories;

import kmsweb.entities.SupplierEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.time.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface SupplierRepository extends AbstractRepository<SupplierEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Number.
	 *
	 * @param supplierNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Number
	 */
	Optional<SupplierEntity> findBySupplierNumber(@NotNull String supplierNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Name.
	 *
	 * @param supplierName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Name
	 */
	List<SupplierEntity> findBySupplierName(@NotNull String supplierName);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax ID.
	 *
	 * @param taxID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax ID
	 */
	List<SupplierEntity> findByTaxID(@NotNull String taxID);
	/**
	 * Return an entity or a list of entities that have the given attribute Supply Stock Group.
	 *
	 * @param supplyStockGroup the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supply Stock Group
	 */
	List<SupplierEntity> findBySupplyStockGroup(@NotNull String supplyStockGroup);
	/**
	 * Return an entity or a list of entities that have the given attribute Adress.
	 *
	 * @param adress the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Adress
	 */
	List<SupplierEntity> findByAdress(@NotNull String adress);
	/**
	 * Return an entity or a list of entities that have the given attribute Country.
	 *
	 * @param country the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Country
	 */
	List<SupplierEntity> findByCountry(@NotNull String country);
	/**
	 * Return an entity or a list of entities that have the given attribute State Province.
	 *
	 * @param stateProvince the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute State Province
	 */
	List<SupplierEntity> findByStateProvince(@NotNull String stateProvince);
	/**
	 * Return an entity or a list of entities that have the given attribute City.
	 *
	 * @param city the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute City
	 */
	List<SupplierEntity> findByCity(@NotNull String city);
	/**
	 * Return an entity or a list of entities that have the given attribute Postal Code.
	 *
	 * @param postalCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postal Code
	 */
	List<SupplierEntity> findByPostalCode(@NotNull String postalCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	List<SupplierEntity> findByPhoneNumber(@NotNull String phoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Phone Number.
	 *
	 * @param otherPhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Phone Number
	 */
	List<SupplierEntity> findByOtherPhoneNumber(@NotNull String otherPhoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Fax.
	 *
	 * @param fax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fax
	 */
	List<SupplierEntity> findByFax(@NotNull String fax);
	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	List<SupplierEntity> findByEmail(@NotNull String email);
	/**
	 * Return an entity or a list of entities that have the given attribute Website.
	 *
	 * @param website the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Website
	 */
	List<SupplierEntity> findByWebsite(@NotNull String website);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<SupplierEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Purchase Order Hold.
	 *
	 * @param purchaseOrderHold the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Order Hold
	 */
	List<SupplierEntity> findByPurchaseOrderHold(@NotNull Boolean purchaseOrderHold);
	/**
	 * Return an entity or a list of entities that have the given attribute Purchase Order Hold Reason.
	 *
	 * @param purchaseOrderHoldReason the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Order Hold Reason
	 */
	List<SupplierEntity> findByPurchaseOrderHoldReason(@NotNull String purchaseOrderHoldReason);
	/**
	 * Return an entity or a list of entities that have the given attribute VAT Included.
	 *
	 * @param vatIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute VAT Included
	 */
	List<SupplierEntity> findByVatIncluded(@NotNull Boolean vatIncluded);
	/**
	 * Return an entity or a list of entities that have the given attribute Shipping Method.
	 *
	 * @param shippingMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shipping Method
	 */
	List<SupplierEntity> findByShippingMethod(@NotNull String shippingMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Lead Time Minimum.
	 *
	 * @param leadTimeMinimum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lead Time Minimum
	 */
	List<SupplierEntity> findByLeadTimeMinimum(@NotNull Double leadTimeMinimum);
	/**
	 * Return an entity or a list of entities that have the given attribute Lead Time Maximum.
	 *
	 * @param leadTimeMaximum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lead Time Maximum
	 */
	List<SupplierEntity> findByLeadTimeMaximum(@NotNull Double leadTimeMaximum);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Purchase Date.
	 *
	 * @param lastPurchaseDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Purchase Date
	 */
	List<SupplierEntity> findByLastPurchaseDate(@NotNull OffsetDateTime lastPurchaseDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Purchase Order Number.
	 *
	 * @param lastPurchaseOrderNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Purchase Order Number
	 */
	List<SupplierEntity> findByLastPurchaseOrderNumber(@NotNull String lastPurchaseOrderNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Lead Time Measurement.
	 *
	 * @param leadTimeMeasurement the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lead Time Measurement
	 */
	List<SupplierEntity> findByLeadTimeMeasurement(@NotNull String leadTimeMeasurement);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<SupplierEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<SupplierEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}