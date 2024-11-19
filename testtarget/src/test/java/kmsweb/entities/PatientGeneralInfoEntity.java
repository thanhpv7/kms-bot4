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

import kmsweb.lib.file.models.FileEntity;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PatientGeneralInfoEntity extends AbstractEntity {

	public PatientGeneralInfoEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsClaimSubmissionsOneMany = new EntityReference();
			BpjsClaimSubmissionsOneMany.entityName = "BpjsClaimSubmission";
			BpjsClaimSubmissionsOneMany.oppositeName = "PatientGeneralInfo";
			BpjsClaimSubmissionsOneMany.name = "BpjsClaimSubmissions";
			BpjsClaimSubmissionsOneMany.optional = true;
			BpjsClaimSubmissionsOneMany.type = "One";
			BpjsClaimSubmissionsOneMany.oppositeType = "Many";

		References.add(BpjsClaimSubmissionsOneMany);

		var CashRefundsOneMany = new EntityReference();
			CashRefundsOneMany.entityName = "CashRefund";
			CashRefundsOneMany.oppositeName = "PatientGeneralInfo";
			CashRefundsOneMany.name = "CashRefunds";
			CashRefundsOneMany.optional = true;
			CashRefundsOneMany.type = "One";
			CashRefundsOneMany.oppositeType = "Many";

		References.add(CashRefundsOneMany);

		var InformedConsentsOneMany = new EntityReference();
			InformedConsentsOneMany.entityName = "InformedConsent";
			InformedConsentsOneMany.oppositeName = "PatientGeneralInfo";
			InformedConsentsOneMany.name = "InformedConsents";
			InformedConsentsOneMany.optional = true;
			InformedConsentsOneMany.type = "One";
			InformedConsentsOneMany.oppositeType = "Many";

		References.add(InformedConsentsOneMany);

		var InvoiceReceiptsOneMany = new EntityReference();
			InvoiceReceiptsOneMany.entityName = "CashReceipt";
			InvoiceReceiptsOneMany.oppositeName = "Patient";
			InvoiceReceiptsOneMany.name = "InvoiceReceipts";
			InvoiceReceiptsOneMany.optional = true;
			InvoiceReceiptsOneMany.type = "One";
			InvoiceReceiptsOneMany.oppositeType = "Many";

		References.add(InvoiceReceiptsOneMany);

		var PatientCaseHistoriesOneMany = new EntityReference();
			PatientCaseHistoriesOneMany.entityName = "PatientCaseHistory";
			PatientCaseHistoriesOneMany.oppositeName = "PatientGeneralInformation";
			PatientCaseHistoriesOneMany.name = "PatientCaseHistories";
			PatientCaseHistoriesOneMany.optional = true;
			PatientCaseHistoriesOneMany.type = "One";
			PatientCaseHistoriesOneMany.oppositeType = "Many";

		References.add(PatientCaseHistoriesOneMany);

		var PatientConsentsOneMany = new EntityReference();
			PatientConsentsOneMany.entityName = "PatientConsent";
			PatientConsentsOneMany.oppositeName = "PatientGeneralInfo";
			PatientConsentsOneMany.name = "PatientConsents";
			PatientConsentsOneMany.optional = true;
			PatientConsentsOneMany.type = "One";
			PatientConsentsOneMany.oppositeType = "Many";

		References.add(PatientConsentsOneMany);

		var PatientContactInformationOneOne = new EntityReference();
			PatientContactInformationOneOne.entityName = "PatientContactInfo";
			PatientContactInformationOneOne.oppositeName = "PatientGeneralInformation";
			PatientContactInformationOneOne.name = "PatientContactInformation";
			PatientContactInformationOneOne.optional = true;
			PatientContactInformationOneOne.type = "One";
			PatientContactInformationOneOne.oppositeType = "One";

		References.add(PatientContactInformationOneOne);

		var PatientDetailAddressOneOne = new EntityReference();
			PatientDetailAddressOneOne.entityName = "PatientDetailAddress";
			PatientDetailAddressOneOne.oppositeName = "PatientGeneralInformation";
			PatientDetailAddressOneOne.name = "PatientDetailAddress";
			PatientDetailAddressOneOne.optional = true;
			PatientDetailAddressOneOne.type = "One";
			PatientDetailAddressOneOne.oppositeType = "One";

		References.add(PatientDetailAddressOneOne);

		var PatientDetailOneOne = new EntityReference();
			PatientDetailOneOne.entityName = "PatientDetail";
			PatientDetailOneOne.oppositeName = "PatientGeneralInformation";
			PatientDetailOneOne.name = "PatientDetail";
			PatientDetailOneOne.optional = true;
			PatientDetailOneOne.type = "One";
			PatientDetailOneOne.oppositeType = "One";

		References.add(PatientDetailOneOne);

		var PatientEmergencyContactDetailOneOne = new EntityReference();
			PatientEmergencyContactDetailOneOne.entityName = "PatientEmergencyContactDetail";
			PatientEmergencyContactDetailOneOne.oppositeName = "PatientGeneralInformation";
			PatientEmergencyContactDetailOneOne.name = "PatientEmergencyContactDetail";
			PatientEmergencyContactDetailOneOne.optional = true;
			PatientEmergencyContactDetailOneOne.type = "One";
			PatientEmergencyContactDetailOneOne.oppositeType = "One";

		References.add(PatientEmergencyContactDetailOneOne);

		var PatientEmploymentDetailOneOne = new EntityReference();
			PatientEmploymentDetailOneOne.entityName = "PatientEmploymentDetail";
			PatientEmploymentDetailOneOne.oppositeName = "PatientGeneralInfo";
			PatientEmploymentDetailOneOne.name = "PatientEmploymentDetail";
			PatientEmploymentDetailOneOne.optional = true;
			PatientEmploymentDetailOneOne.type = "One";
			PatientEmploymentDetailOneOne.oppositeType = "One";

		References.add(PatientEmploymentDetailOneOne);

		var PatientFinalizeProfilesOneMany = new EntityReference();
			PatientFinalizeProfilesOneMany.entityName = "PatientSupportingDocument";
			PatientFinalizeProfilesOneMany.oppositeName = "PatientGeneralInformation";
			PatientFinalizeProfilesOneMany.name = "PatientFinalizeProfiles";
			PatientFinalizeProfilesOneMany.optional = true;
			PatientFinalizeProfilesOneMany.type = "One";
			PatientFinalizeProfilesOneMany.oppositeType = "Many";

		References.add(PatientFinalizeProfilesOneMany);

		var PatientPaymentBPJSOneOne = new EntityReference();
			PatientPaymentBPJSOneOne.entityName = "PatientPaymentBPJS";
			PatientPaymentBPJSOneOne.oppositeName = "PatientGeneralInfo";
			PatientPaymentBPJSOneOne.name = "PatientPaymentBPJS";
			PatientPaymentBPJSOneOne.optional = true;
			PatientPaymentBPJSOneOne.type = "One";
			PatientPaymentBPJSOneOne.oppositeType = "One";

		References.add(PatientPaymentBPJSOneOne);

		var PatientPaymentTypeInsuranceOneOne = new EntityReference();
			PatientPaymentTypeInsuranceOneOne.entityName = "PatientPaymentInsurance";
			PatientPaymentTypeInsuranceOneOne.oppositeName = "PatientGeneralInformation";
			PatientPaymentTypeInsuranceOneOne.name = "PatientPaymentTypeInsurance";
			PatientPaymentTypeInsuranceOneOne.optional = true;
			PatientPaymentTypeInsuranceOneOne.type = "One";
			PatientPaymentTypeInsuranceOneOne.oppositeType = "One";

		References.add(PatientPaymentTypeInsuranceOneOne);

		var PatientPaymentTypeOthersOneOne = new EntityReference();
			PatientPaymentTypeOthersOneOne.entityName = "PatientPaymentOthers";
			PatientPaymentTypeOthersOneOne.oppositeName = "PatientGeneralInformation";
			PatientPaymentTypeOthersOneOne.name = "PatientPaymentTypeOthers";
			PatientPaymentTypeOthersOneOne.optional = true;
			PatientPaymentTypeOthersOneOne.type = "One";
			PatientPaymentTypeOthersOneOne.oppositeType = "One";

		References.add(PatientPaymentTypeOthersOneOne);

		var PatientPersonalInformationOneOne = new EntityReference();
			PatientPersonalInformationOneOne.entityName = "PatientPersonalInfo";
			PatientPersonalInformationOneOne.oppositeName = "PatientGeneralInformation";
			PatientPersonalInformationOneOne.name = "PatientPersonalInformation";
			PatientPersonalInformationOneOne.optional = true;
			PatientPersonalInformationOneOne.type = "One";
			PatientPersonalInformationOneOne.oppositeType = "One";

		References.add(PatientPersonalInformationOneOne);

		var PatientSelfPayingOneOne = new EntityReference();
			PatientSelfPayingOneOne.entityName = "PatientPaymentSelfPaying";
			PatientSelfPayingOneOne.oppositeName = "PatientGeneralInformation";
			PatientSelfPayingOneOne.name = "PatientSelfPaying";
			PatientSelfPayingOneOne.optional = true;
			PatientSelfPayingOneOne.type = "One";
			PatientSelfPayingOneOne.oppositeType = "One";

		References.add(PatientSelfPayingOneOne);

		var RetailPharmaciesOneMany = new EntityReference();
			RetailPharmaciesOneMany.entityName = "RetailPharmacy";
			RetailPharmaciesOneMany.oppositeName = "PatientGeneralInfo";
			RetailPharmaciesOneMany.name = "RetailPharmacies";
			RetailPharmaciesOneMany.optional = true;
			RetailPharmaciesOneMany.type = "One";
			RetailPharmaciesOneMany.oppositeType = "Many";

		References.add(RetailPharmaciesOneMany);

		var VisitsOneMany = new EntityReference();
			VisitsOneMany.entityName = "PatientVisit";
			VisitsOneMany.oppositeName = "Patient";
			VisitsOneMany.name = "Visits";
			VisitsOneMany.optional = true;
			VisitsOneMany.type = "One";
			VisitsOneMany.oppositeType = "Many";

		References.add(VisitsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Patient ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient ID here] end
	private String patientID;

	// % protected region % [Modify attribute annotation for Title here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Title here] end
	private String title;

	// % protected region % [Modify attribute annotation for Given Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Given Name here] end
	private String givenName;

	// % protected region % [Modify attribute annotation for Last Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Name here] end
	private String lastName;

	// % protected region % [Modify attribute annotation for Place of Birth here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Place of Birth here] end
	private String placeOfBirth;

	// % protected region % [Modify attribute annotation for Date of Birth here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Date of Birth here] end
	private OffsetDateTime dateOfBirth;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Patient Payment Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Payment Type here] end
	private String patientPaymentType;

	// % protected region % [Modify attribute annotation for Important Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Important Notes here] end
	private String importantNotes;

	// % protected region % [Modify attribute annotation for Has Outstanding Payment here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Has Outstanding Payment here] end
	private Boolean hasOutstandingPayment;

	private Set<FileEntity> patientPicture = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private PatientContactInfoEntity patientContactInformation;

	private PatientDetailAddressEntity patientDetailAddress;

	private PatientDetailEntity patientDetail;

	private PatientEmergencyContactDetailEntity patientEmergencyContactDetail;

	private PatientEmploymentDetailEntity patientEmploymentDetail;

	private PatientPaymentBPJSEntity patientPaymentBPJS;

	private PatientPaymentInsuranceEntity patientPaymentTypeInsurance;

	private PatientPaymentOthersEntity patientPaymentTypeOthers;

	private PatientPersonalInfoEntity patientPersonalInformation;

	private PatientPaymentSelfPayingEntity patientSelfPaying;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	private Set<CashRefundEntity> cashRefunds = new HashSet<>();

	private Set<InformedConsentEntity> informedConsents = new HashSet<>();

	private Set<CashReceiptEntity> invoiceReceipts = new HashSet<>();

	private Set<PatientCaseHistoryEntity> patientCaseHistories = new HashSet<>();

	private Set<PatientConsentEntity> patientConsents = new HashSet<>();

	private Set<PatientSupportingDocumentEntity> patientFinalizeProfiles = new HashSet<>();

	private Set<RetailPharmacyEntity> retailPharmacies = new HashSet<>();

	private Set<PatientVisitEntity> visits = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addBpjsClaimSubmissions(BpjsClaimSubmissionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be added to this entity
	 */
	public void addBpjsClaimSubmissions(@NonNull BpjsClaimSubmissionEntity entity) {
		addBpjsClaimSubmissions(entity, true);
	}

	/**
	 * Add a new BpjsClaimSubmissionEntity to bpjsClaimSubmissions in this entity.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsClaimSubmissions(@NonNull BpjsClaimSubmissionEntity entity, boolean reverseAdd) {
		if (!this.bpjsClaimSubmissions.contains(entity)) {
			bpjsClaimSubmissions.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInfo(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsClaimSubmissions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be added to this entity
	 */
	public void addBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities) {
		addBpjsClaimSubmissions(entities, true);
	}

	/**
	 * Add a new collection of BpjsClaimSubmissionEntity to BPJS Claim Submissions in this entity.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsClaimSubmissions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsClaimSubmissions(BpjsClaimSubmissionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be set to this entity
	 */
	public void removeBpjsClaimSubmissions(@NonNull BpjsClaimSubmissionEntity entity) {
		this.removeBpjsClaimSubmissions(entity, true);
	}

	/**
	 * Remove the given BpjsClaimSubmissionEntity from this entity.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsClaimSubmissions(@NonNull BpjsClaimSubmissionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInfo(false);
		}
		this.bpjsClaimSubmissions.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsClaimSubmissions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be removed to this entity
	 */
	public void removeBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities) {
		this.removeBpjsClaimSubmissions(entities, true);
	}

	/**
	 * Remove the given collection of BpjsClaimSubmissionEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsClaimSubmissions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsClaimSubmissions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be set to this entity
	 */
	public void setBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities) {
		setBpjsClaimSubmissions(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Claim Submissions with the given ones.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities, boolean reverseAdd) {

		this.unsetBpjsClaimSubmissions();
		this.bpjsClaimSubmissions = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setPatientGeneralInfo(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsClaimSubmissions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsClaimSubmissions() {
		this.unsetBpjsClaimSubmissions(true);
	}

	/**
	 * Remove all the entities in BPJS Claim Submissions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsClaimSubmissions(boolean doReverse) {
		if (doReverse) {
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetPatientGeneralInfo(false));
		}
		this.bpjsClaimSubmissions.clear();
	}

/**
	 * Similar to {@link this#addCashRefunds(CashRefundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashRefundEntity to be added to this entity
	 */
	public void addCashRefunds(@NonNull CashRefundEntity entity) {
		addCashRefunds(entity, true);
	}

	/**
	 * Add a new CashRefundEntity to cashRefunds in this entity.
	 *
	 * @param entity the given CashRefundEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCashRefunds(@NonNull CashRefundEntity entity, boolean reverseAdd) {
		if (!this.cashRefunds.contains(entity)) {
			cashRefunds.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInfo(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCashRefunds(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashRefundEntity to be added to this entity
	 */
	public void addCashRefunds(@NonNull Collection<CashRefundEntity> entities) {
		addCashRefunds(entities, true);
	}

	/**
	 * Add a new collection of CashRefundEntity to Cash Refunds in this entity.
	 *
	 * @param entities the given collection of CashRefundEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCashRefunds(@NonNull Collection<CashRefundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCashRefunds(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCashRefunds(CashRefundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashRefundEntity to be set to this entity
	 */
	public void removeCashRefunds(@NonNull CashRefundEntity entity) {
		this.removeCashRefunds(entity, true);
	}

	/**
	 * Remove the given CashRefundEntity from this entity.
	 *
	 * @param entity the given CashRefundEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCashRefunds(@NonNull CashRefundEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInfo(false);
		}
		this.cashRefunds.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCashRefunds(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CashRefundEntity to be removed to this entity
	 */
	public void removeCashRefunds(@NonNull Collection<CashRefundEntity> entities) {
		this.removeCashRefunds(entities, true);
	}

	/**
	 * Remove the given collection of CashRefundEntity from  to this entity.
	 *
	 * @param entities the given collection of CashRefundEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCashRefunds(@NonNull Collection<CashRefundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCashRefunds(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCashRefunds(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashRefundEntity to be set to this entity
	 */
	public void setCashRefunds(@NonNull Collection<CashRefundEntity> entities) {
		setCashRefunds(entities, true);
	}

	/**
	 * Replace the current entities in Cash Refunds with the given ones.
	 *
	 * @param entities the given collection of CashRefundEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCashRefunds(@NonNull Collection<CashRefundEntity> entities, boolean reverseAdd) {

		this.unsetCashRefunds();
		this.cashRefunds = new HashSet<>(entities);
		if (reverseAdd) {
			this.cashRefunds.forEach(cashRefundsEntity -> cashRefundsEntity.setPatientGeneralInfo(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCashRefunds(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCashRefunds() {
		this.unsetCashRefunds(true);
	}

	/**
	 * Remove all the entities in Cash Refunds from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCashRefunds(boolean doReverse) {
		if (doReverse) {
			this.cashRefunds.forEach(cashRefundsEntity -> cashRefundsEntity.unsetPatientGeneralInfo(false));
		}
		this.cashRefunds.clear();
	}

/**
	 * Similar to {@link this#addInformedConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be added to this entity
	 */
	public void addInformedConsents(@NonNull InformedConsentEntity entity) {
		addInformedConsents(entity, true);
	}

	/**
	 * Add a new InformedConsentEntity to informedConsents in this entity.
	 *
	 * @param entity the given InformedConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInformedConsents(@NonNull InformedConsentEntity entity, boolean reverseAdd) {
		if (!this.informedConsents.contains(entity)) {
			informedConsents.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInfo(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInformedConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 */
	public void addInformedConsents(@NonNull Collection<InformedConsentEntity> entities) {
		addInformedConsents(entities, true);
	}

	/**
	 * Add a new collection of InformedConsentEntity to Informed Consents in this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInformedConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInformedConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInformedConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be set to this entity
	 */
	public void removeInformedConsents(@NonNull InformedConsentEntity entity) {
		this.removeInformedConsents(entity, true);
	}

	/**
	 * Remove the given InformedConsentEntity from this entity.
	 *
	 * @param entity the given InformedConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInformedConsents(@NonNull InformedConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInfo(false);
		}
		this.informedConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInformedConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 */
	public void removeInformedConsents(@NonNull Collection<InformedConsentEntity> entities) {
		this.removeInformedConsents(entities, true);
	}

	/**
	 * Remove the given collection of InformedConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInformedConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInformedConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInformedConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be set to this entity
	 */
	public void setInformedConsents(@NonNull Collection<InformedConsentEntity> entities) {
		setInformedConsents(entities, true);
	}

	/**
	 * Replace the current entities in Informed Consents with the given ones.
	 *
	 * @param entities the given collection of InformedConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInformedConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {

		this.unsetInformedConsents();
		this.informedConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.informedConsents.forEach(informedConsentsEntity -> informedConsentsEntity.setPatientGeneralInfo(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInformedConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInformedConsents() {
		this.unsetInformedConsents(true);
	}

	/**
	 * Remove all the entities in Informed Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInformedConsents(boolean doReverse) {
		if (doReverse) {
			this.informedConsents.forEach(informedConsentsEntity -> informedConsentsEntity.unsetPatientGeneralInfo(false));
		}
		this.informedConsents.clear();
	}

/**
	 * Similar to {@link this#addInvoiceReceipts(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be added to this entity
	 */
	public void addInvoiceReceipts(@NonNull CashReceiptEntity entity) {
		addInvoiceReceipts(entity, true);
	}

	/**
	 * Add a new CashReceiptEntity to invoiceReceipts in this entity.
	 *
	 * @param entity the given CashReceiptEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceReceipts(@NonNull CashReceiptEntity entity, boolean reverseAdd) {
		if (!this.invoiceReceipts.contains(entity)) {
			invoiceReceipts.add(entity);
			if (reverseAdd) {
				entity.setPatient(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceReceipts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 */
	public void addInvoiceReceipts(@NonNull Collection<CashReceiptEntity> entities) {
		addInvoiceReceipts(entities, true);
	}

	/**
	 * Add a new collection of CashReceiptEntity to Invoice Receipts in this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceReceipts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceReceipts(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be set to this entity
	 */
	public void removeInvoiceReceipts(@NonNull CashReceiptEntity entity) {
		this.removeInvoiceReceipts(entity, true);
	}

	/**
	 * Remove the given CashReceiptEntity from this entity.
	 *
	 * @param entity the given CashReceiptEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceReceipts(@NonNull CashReceiptEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatient(false);
		}
		this.invoiceReceipts.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceReceipts(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 */
	public void removeInvoiceReceipts(@NonNull Collection<CashReceiptEntity> entities) {
		this.removeInvoiceReceipts(entities, true);
	}

	/**
	 * Remove the given collection of CashReceiptEntity from  to this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceReceipts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceReceipts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be set to this entity
	 */
	public void setInvoiceReceipts(@NonNull Collection<CashReceiptEntity> entities) {
		setInvoiceReceipts(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Receipts with the given ones.
	 *
	 * @param entities the given collection of CashReceiptEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceReceipts();
		this.invoiceReceipts = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceReceipts.forEach(invoiceReceiptsEntity -> invoiceReceiptsEntity.setPatient(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceReceipts(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceReceipts() {
		this.unsetInvoiceReceipts(true);
	}

	/**
	 * Remove all the entities in Invoice Receipts from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceReceipts(boolean doReverse) {
		if (doReverse) {
			this.invoiceReceipts.forEach(invoiceReceiptsEntity -> invoiceReceiptsEntity.unsetPatient(false));
		}
		this.invoiceReceipts.clear();
	}

/**
	 * Similar to {@link this#addPatientCaseHistories(PatientCaseHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientCaseHistoryEntity to be added to this entity
	 */
	public void addPatientCaseHistories(@NonNull PatientCaseHistoryEntity entity) {
		addPatientCaseHistories(entity, true);
	}

	/**
	 * Add a new PatientCaseHistoryEntity to patientCaseHistories in this entity.
	 *
	 * @param entity the given PatientCaseHistoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientCaseHistories(@NonNull PatientCaseHistoryEntity entity, boolean reverseAdd) {
		if (!this.patientCaseHistories.contains(entity)) {
			patientCaseHistories.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInformation(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientCaseHistories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to be added to this entity
	 */
	public void addPatientCaseHistories(@NonNull Collection<PatientCaseHistoryEntity> entities) {
		addPatientCaseHistories(entities, true);
	}

	/**
	 * Add a new collection of PatientCaseHistoryEntity to Patient Case Histories in this entity.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientCaseHistories(@NonNull Collection<PatientCaseHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientCaseHistories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientCaseHistories(PatientCaseHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientCaseHistoryEntity to be set to this entity
	 */
	public void removePatientCaseHistories(@NonNull PatientCaseHistoryEntity entity) {
		this.removePatientCaseHistories(entity, true);
	}

	/**
	 * Remove the given PatientCaseHistoryEntity from this entity.
	 *
	 * @param entity the given PatientCaseHistoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientCaseHistories(@NonNull PatientCaseHistoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInformation(false);
		}
		this.patientCaseHistories.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientCaseHistories(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to be removed to this entity
	 */
	public void removePatientCaseHistories(@NonNull Collection<PatientCaseHistoryEntity> entities) {
		this.removePatientCaseHistories(entities, true);
	}

	/**
	 * Remove the given collection of PatientCaseHistoryEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientCaseHistories(@NonNull Collection<PatientCaseHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientCaseHistories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientCaseHistories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to be set to this entity
	 */
	public void setPatientCaseHistories(@NonNull Collection<PatientCaseHistoryEntity> entities) {
		setPatientCaseHistories(entities, true);
	}

	/**
	 * Replace the current entities in Patient Case Histories with the given ones.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientCaseHistories(@NonNull Collection<PatientCaseHistoryEntity> entities, boolean reverseAdd) {

		this.unsetPatientCaseHistories();
		this.patientCaseHistories = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientCaseHistories.forEach(patientCaseHistoriesEntity -> patientCaseHistoriesEntity.setPatientGeneralInformation(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientCaseHistories(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientCaseHistories() {
		this.unsetPatientCaseHistories(true);
	}

	/**
	 * Remove all the entities in Patient Case Histories from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientCaseHistories(boolean doReverse) {
		if (doReverse) {
			this.patientCaseHistories.forEach(patientCaseHistoriesEntity -> patientCaseHistoriesEntity.unsetPatientGeneralInformation(false));
		}
		this.patientCaseHistories.clear();
	}

/**
	 * Similar to {@link this#addPatientConsents(PatientConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientConsentEntity to be added to this entity
	 */
	public void addPatientConsents(@NonNull PatientConsentEntity entity) {
		addPatientConsents(entity, true);
	}

	/**
	 * Add a new PatientConsentEntity to patientConsents in this entity.
	 *
	 * @param entity the given PatientConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientConsents(@NonNull PatientConsentEntity entity, boolean reverseAdd) {
		if (!this.patientConsents.contains(entity)) {
			patientConsents.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInfo(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientConsentEntity to be added to this entity
	 */
	public void addPatientConsents(@NonNull Collection<PatientConsentEntity> entities) {
		addPatientConsents(entities, true);
	}

	/**
	 * Add a new collection of PatientConsentEntity to Patient Consents in this entity.
	 *
	 * @param entities the given collection of PatientConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientConsents(@NonNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientConsents(PatientConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientConsentEntity to be set to this entity
	 */
	public void removePatientConsents(@NonNull PatientConsentEntity entity) {
		this.removePatientConsents(entity, true);
	}

	/**
	 * Remove the given PatientConsentEntity from this entity.
	 *
	 * @param entity the given PatientConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientConsents(@NonNull PatientConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInfo(false);
		}
		this.patientConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientConsentEntity to be removed to this entity
	 */
	public void removePatientConsents(@NonNull Collection<PatientConsentEntity> entities) {
		this.removePatientConsents(entities, true);
	}

	/**
	 * Remove the given collection of PatientConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientConsents(@NonNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientConsentEntity to be set to this entity
	 */
	public void setPatientConsents(@NonNull Collection<PatientConsentEntity> entities) {
		setPatientConsents(entities, true);
	}

	/**
	 * Replace the current entities in Patient Consents with the given ones.
	 *
	 * @param entities the given collection of PatientConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientConsents(@NonNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {

		this.unsetPatientConsents();
		this.patientConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientConsents.forEach(patientConsentsEntity -> patientConsentsEntity.setPatientGeneralInfo(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientConsents() {
		this.unsetPatientConsents(true);
	}

	/**
	 * Remove all the entities in Patient Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientConsents(boolean doReverse) {
		if (doReverse) {
			this.patientConsents.forEach(patientConsentsEntity -> patientConsentsEntity.unsetPatientGeneralInfo(false));
		}
		this.patientConsents.clear();
	}

	/**
	 * Similar to {@link this#setPatientContactInformation(PatientContactInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientContactInformation(@NonNull PatientContactInfoEntity entity) {
		setPatientContactInformation(entity, true);
	}

	/**
	 * Set or update patientContactInformation with the given PatientContactInfoEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientContactInformation(@NonNull PatientContactInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientContactInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientContactInformation here] end

		if (sameAsFormer(this.patientContactInformation, entity)) {
			return;
		}

		if (this.patientContactInformation != null) {
			this.patientContactInformation.unsetPatientGeneralInformation();
		}

		this.patientContactInformation = entity;

		if (reverseAdd) {
			this.patientContactInformation.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientContactInformation outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientContactInformation outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientContactInformation(boolean)} but default to true.
	 */
	public void unsetPatientContactInformation() {
		this.unsetPatientContactInformation(true);
	}

	/**
	 * Remove the PatientContactInfoEntity in Patient Contact Information from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientContactInformation(boolean reverse) {
		if (reverse && this.patientContactInformation != null) {
			this.patientContactInformation.unsetPatientGeneralInformation(false);
		}
		this.patientContactInformation = null;
	}

	/**
	 * Similar to {@link this#setPatientDetailAddress(PatientDetailAddressEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientDetailAddress(@NonNull PatientDetailAddressEntity entity) {
		setPatientDetailAddress(entity, true);
	}

	/**
	 * Set or update patientDetailAddress with the given PatientDetailAddressEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientDetailAddress(@NonNull PatientDetailAddressEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientDetailAddress here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientDetailAddress here] end

		if (sameAsFormer(this.patientDetailAddress, entity)) {
			return;
		}

		if (this.patientDetailAddress != null) {
			this.patientDetailAddress.unsetPatientGeneralInformation();
		}

		this.patientDetailAddress = entity;

		if (reverseAdd) {
			this.patientDetailAddress.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientDetailAddress outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientDetailAddress outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientDetailAddress(boolean)} but default to true.
	 */
	public void unsetPatientDetailAddress() {
		this.unsetPatientDetailAddress(true);
	}

	/**
	 * Remove the PatientDetailAddressEntity in Patient Detail Address from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientDetailAddress(boolean reverse) {
		if (reverse && this.patientDetailAddress != null) {
			this.patientDetailAddress.unsetPatientGeneralInformation(false);
		}
		this.patientDetailAddress = null;
	}

	/**
	 * Similar to {@link this#setPatientDetail(PatientDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientDetail(@NonNull PatientDetailEntity entity) {
		setPatientDetail(entity, true);
	}

	/**
	 * Set or update patientDetail with the given PatientDetailEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientDetail(@NonNull PatientDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientDetail here] end

		if (sameAsFormer(this.patientDetail, entity)) {
			return;
		}

		if (this.patientDetail != null) {
			this.patientDetail.unsetPatientGeneralInformation();
		}

		this.patientDetail = entity;

		if (reverseAdd) {
			this.patientDetail.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientDetail outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientDetail outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientDetail(boolean)} but default to true.
	 */
	public void unsetPatientDetail() {
		this.unsetPatientDetail(true);
	}

	/**
	 * Remove the PatientDetailEntity in Patient Detail from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientDetail(boolean reverse) {
		if (reverse && this.patientDetail != null) {
			this.patientDetail.unsetPatientGeneralInformation(false);
		}
		this.patientDetail = null;
	}

	/**
	 * Similar to {@link this#setPatientEmergencyContactDetail(PatientEmergencyContactDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientEmergencyContactDetail(@NonNull PatientEmergencyContactDetailEntity entity) {
		setPatientEmergencyContactDetail(entity, true);
	}

	/**
	 * Set or update patientEmergencyContactDetail with the given PatientEmergencyContactDetailEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientEmergencyContactDetail(@NonNull PatientEmergencyContactDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientEmergencyContactDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientEmergencyContactDetail here] end

		if (sameAsFormer(this.patientEmergencyContactDetail, entity)) {
			return;
		}

		if (this.patientEmergencyContactDetail != null) {
			this.patientEmergencyContactDetail.unsetPatientGeneralInformation();
		}

		this.patientEmergencyContactDetail = entity;

		if (reverseAdd) {
			this.patientEmergencyContactDetail.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientEmergencyContactDetail outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientEmergencyContactDetail outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientEmergencyContactDetail(boolean)} but default to true.
	 */
	public void unsetPatientEmergencyContactDetail() {
		this.unsetPatientEmergencyContactDetail(true);
	}

	/**
	 * Remove the PatientEmergencyContactDetailEntity in Patient Emergency Contact Detail from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientEmergencyContactDetail(boolean reverse) {
		if (reverse && this.patientEmergencyContactDetail != null) {
			this.patientEmergencyContactDetail.unsetPatientGeneralInformation(false);
		}
		this.patientEmergencyContactDetail = null;
	}

	/**
	 * Similar to {@link this#setPatientEmploymentDetail(PatientEmploymentDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientEmploymentDetail(@NonNull PatientEmploymentDetailEntity entity) {
		setPatientEmploymentDetail(entity, true);
	}

	/**
	 * Set or update patientEmploymentDetail with the given PatientEmploymentDetailEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientEmploymentDetail(@NonNull PatientEmploymentDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientEmploymentDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientEmploymentDetail here] end

		if (sameAsFormer(this.patientEmploymentDetail, entity)) {
			return;
		}

		if (this.patientEmploymentDetail != null) {
			this.patientEmploymentDetail.unsetPatientGeneralInfo();
		}

		this.patientEmploymentDetail = entity;

		if (reverseAdd) {
			this.patientEmploymentDetail.setPatientGeneralInfo(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientEmploymentDetail outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientEmploymentDetail outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientEmploymentDetail(boolean)} but default to true.
	 */
	public void unsetPatientEmploymentDetail() {
		this.unsetPatientEmploymentDetail(true);
	}

	/**
	 * Remove the PatientEmploymentDetailEntity in Patient Employment Detail  from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientEmploymentDetail(boolean reverse) {
		if (reverse && this.patientEmploymentDetail != null) {
			this.patientEmploymentDetail.unsetPatientGeneralInfo(false);
		}
		this.patientEmploymentDetail = null;
	}

/**
	 * Similar to {@link this#addPatientFinalizeProfiles(PatientSupportingDocumentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientSupportingDocumentEntity to be added to this entity
	 */
	public void addPatientFinalizeProfiles(@NonNull PatientSupportingDocumentEntity entity) {
		addPatientFinalizeProfiles(entity, true);
	}

	/**
	 * Add a new PatientSupportingDocumentEntity to patientFinalizeProfiles in this entity.
	 *
	 * @param entity the given PatientSupportingDocumentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientFinalizeProfiles(@NonNull PatientSupportingDocumentEntity entity, boolean reverseAdd) {
		if (!this.patientFinalizeProfiles.contains(entity)) {
			patientFinalizeProfiles.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInformation(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientFinalizeProfiles(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to be added to this entity
	 */
	public void addPatientFinalizeProfiles(@NonNull Collection<PatientSupportingDocumentEntity> entities) {
		addPatientFinalizeProfiles(entities, true);
	}

	/**
	 * Add a new collection of PatientSupportingDocumentEntity to Patient Finalize Profiles in this entity.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientFinalizeProfiles(@NonNull Collection<PatientSupportingDocumentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientFinalizeProfiles(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientFinalizeProfiles(PatientSupportingDocumentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientSupportingDocumentEntity to be set to this entity
	 */
	public void removePatientFinalizeProfiles(@NonNull PatientSupportingDocumentEntity entity) {
		this.removePatientFinalizeProfiles(entity, true);
	}

	/**
	 * Remove the given PatientSupportingDocumentEntity from this entity.
	 *
	 * @param entity the given PatientSupportingDocumentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientFinalizeProfiles(@NonNull PatientSupportingDocumentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInformation(false);
		}
		this.patientFinalizeProfiles.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientFinalizeProfiles(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to be removed to this entity
	 */
	public void removePatientFinalizeProfiles(@NonNull Collection<PatientSupportingDocumentEntity> entities) {
		this.removePatientFinalizeProfiles(entities, true);
	}

	/**
	 * Remove the given collection of PatientSupportingDocumentEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientFinalizeProfiles(@NonNull Collection<PatientSupportingDocumentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientFinalizeProfiles(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientFinalizeProfiles(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to be set to this entity
	 */
	public void setPatientFinalizeProfiles(@NonNull Collection<PatientSupportingDocumentEntity> entities) {
		setPatientFinalizeProfiles(entities, true);
	}

	/**
	 * Replace the current entities in Patient Finalize Profiles with the given ones.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientFinalizeProfiles(@NonNull Collection<PatientSupportingDocumentEntity> entities, boolean reverseAdd) {

		this.unsetPatientFinalizeProfiles();
		this.patientFinalizeProfiles = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientFinalizeProfiles.forEach(patientFinalizeProfilesEntity -> patientFinalizeProfilesEntity.setPatientGeneralInformation(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientFinalizeProfiles(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientFinalizeProfiles() {
		this.unsetPatientFinalizeProfiles(true);
	}

	/**
	 * Remove all the entities in Patient Finalize Profiles from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientFinalizeProfiles(boolean doReverse) {
		if (doReverse) {
			this.patientFinalizeProfiles.forEach(patientFinalizeProfilesEntity -> patientFinalizeProfilesEntity.unsetPatientGeneralInformation(false));
		}
		this.patientFinalizeProfiles.clear();
	}

	/**
	 * Similar to {@link this#setPatientPaymentBPJS(PatientPaymentBPJSEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientPaymentBPJS(@NonNull PatientPaymentBPJSEntity entity) {
		setPatientPaymentBPJS(entity, true);
	}

	/**
	 * Set or update patientPaymentBPJS with the given PatientPaymentBPJSEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentBPJS(@NonNull PatientPaymentBPJSEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] end

		if (sameAsFormer(this.patientPaymentBPJS, entity)) {
			return;
		}

		if (this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.unsetPatientGeneralInfo();
		}

		this.patientPaymentBPJS = entity;

		if (reverseAdd) {
			this.patientPaymentBPJS.setPatientGeneralInfo(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentBPJS(boolean)} but default to true.
	 */
	public void unsetPatientPaymentBPJS() {
		this.unsetPatientPaymentBPJS(true);
	}

	/**
	 * Remove the PatientPaymentBPJSEntity in Patient Payment BPJS from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentBPJS(boolean reverse) {
		if (reverse && this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.unsetPatientGeneralInfo(false);
		}
		this.patientPaymentBPJS = null;
	}

	/**
	 * Similar to {@link this#setPatientPaymentTypeInsurance(PatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientPaymentTypeInsurance(@NonNull PatientPaymentInsuranceEntity entity) {
		setPatientPaymentTypeInsurance(entity, true);
	}

	/**
	 * Set or update patientPaymentTypeInsurance with the given PatientPaymentInsuranceEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentTypeInsurance(@NonNull PatientPaymentInsuranceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentTypeInsurance here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentTypeInsurance here] end

		if (sameAsFormer(this.patientPaymentTypeInsurance, entity)) {
			return;
		}

		if (this.patientPaymentTypeInsurance != null) {
			this.patientPaymentTypeInsurance.unsetPatientGeneralInformation();
		}

		this.patientPaymentTypeInsurance = entity;

		if (reverseAdd) {
			this.patientPaymentTypeInsurance.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentTypeInsurance outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentTypeInsurance outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentTypeInsurance(boolean)} but default to true.
	 */
	public void unsetPatientPaymentTypeInsurance() {
		this.unsetPatientPaymentTypeInsurance(true);
	}

	/**
	 * Remove the PatientPaymentInsuranceEntity in Patient Payment Type Insurance from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentTypeInsurance(boolean reverse) {
		if (reverse && this.patientPaymentTypeInsurance != null) {
			this.patientPaymentTypeInsurance.unsetPatientGeneralInformation(false);
		}
		this.patientPaymentTypeInsurance = null;
	}

	/**
	 * Similar to {@link this#setPatientPaymentTypeOthers(PatientPaymentOthersEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientPaymentTypeOthers(@NonNull PatientPaymentOthersEntity entity) {
		setPatientPaymentTypeOthers(entity, true);
	}

	/**
	 * Set or update patientPaymentTypeOthers with the given PatientPaymentOthersEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentTypeOthers(@NonNull PatientPaymentOthersEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentTypeOthers here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentTypeOthers here] end

		if (sameAsFormer(this.patientPaymentTypeOthers, entity)) {
			return;
		}

		if (this.patientPaymentTypeOthers != null) {
			this.patientPaymentTypeOthers.unsetPatientGeneralInformation();
		}

		this.patientPaymentTypeOthers = entity;

		if (reverseAdd) {
			this.patientPaymentTypeOthers.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentTypeOthers outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentTypeOthers outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentTypeOthers(boolean)} but default to true.
	 */
	public void unsetPatientPaymentTypeOthers() {
		this.unsetPatientPaymentTypeOthers(true);
	}

	/**
	 * Remove the PatientPaymentOthersEntity in Patient Payment Type Others from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentTypeOthers(boolean reverse) {
		if (reverse && this.patientPaymentTypeOthers != null) {
			this.patientPaymentTypeOthers.unsetPatientGeneralInformation(false);
		}
		this.patientPaymentTypeOthers = null;
	}

	/**
	 * Similar to {@link this#setPatientPersonalInformation(PatientPersonalInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientPersonalInformation(@NonNull PatientPersonalInfoEntity entity) {
		setPatientPersonalInformation(entity, true);
	}

	/**
	 * Set or update patientPersonalInformation with the given PatientPersonalInfoEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPersonalInformation(@NonNull PatientPersonalInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPersonalInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPersonalInformation here] end

		if (sameAsFormer(this.patientPersonalInformation, entity)) {
			return;
		}

		if (this.patientPersonalInformation != null) {
			this.patientPersonalInformation.unsetPatientGeneralInformation();
		}

		this.patientPersonalInformation = entity;

		if (reverseAdd) {
			this.patientPersonalInformation.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPersonalInformation outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPersonalInformation outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPersonalInformation(boolean)} but default to true.
	 */
	public void unsetPatientPersonalInformation() {
		this.unsetPatientPersonalInformation(true);
	}

	/**
	 * Remove the PatientPersonalInfoEntity in Patient Personal Information from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPersonalInformation(boolean reverse) {
		if (reverse && this.patientPersonalInformation != null) {
			this.patientPersonalInformation.unsetPatientGeneralInformation(false);
		}
		this.patientPersonalInformation = null;
	}

	/**
	 * Similar to {@link this#setPatientSelfPaying(PatientPaymentSelfPayingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientSelfPaying(@NonNull PatientPaymentSelfPayingEntity entity) {
		setPatientSelfPaying(entity, true);
	}

	/**
	 * Set or update patientSelfPaying with the given PatientPaymentSelfPayingEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientSelfPaying(@NonNull PatientPaymentSelfPayingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientSelfPaying here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientSelfPaying here] end

		if (sameAsFormer(this.patientSelfPaying, entity)) {
			return;
		}

		if (this.patientSelfPaying != null) {
			this.patientSelfPaying.unsetPatientGeneralInformation();
		}

		this.patientSelfPaying = entity;

		if (reverseAdd) {
			this.patientSelfPaying.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientSelfPaying outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientSelfPaying outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientSelfPaying(boolean)} but default to true.
	 */
	public void unsetPatientSelfPaying() {
		this.unsetPatientSelfPaying(true);
	}

	/**
	 * Remove the PatientPaymentSelfPayingEntity in Patient Self Paying from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientSelfPaying(boolean reverse) {
		if (reverse && this.patientSelfPaying != null) {
			this.patientSelfPaying.unsetPatientGeneralInformation(false);
		}
		this.patientSelfPaying = null;
	}

/**
	 * Similar to {@link this#addRetailPharmacies(RetailPharmacyEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyEntity to be added to this entity
	 */
	public void addRetailPharmacies(@NonNull RetailPharmacyEntity entity) {
		addRetailPharmacies(entity, true);
	}

	/**
	 * Add a new RetailPharmacyEntity to retailPharmacies in this entity.
	 *
	 * @param entity the given RetailPharmacyEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRetailPharmacies(@NonNull RetailPharmacyEntity entity, boolean reverseAdd) {
		if (!this.retailPharmacies.contains(entity)) {
			retailPharmacies.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInfo(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRetailPharmacies(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be added to this entity
	 */
	public void addRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities) {
		addRetailPharmacies(entities, true);
	}

	/**
	 * Add a new collection of RetailPharmacyEntity to Retail Pharmacies in this entity.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRetailPharmacies(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRetailPharmacies(RetailPharmacyEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyEntity to be set to this entity
	 */
	public void removeRetailPharmacies(@NonNull RetailPharmacyEntity entity) {
		this.removeRetailPharmacies(entity, true);
	}

	/**
	 * Remove the given RetailPharmacyEntity from this entity.
	 *
	 * @param entity the given RetailPharmacyEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRetailPharmacies(@NonNull RetailPharmacyEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInfo(false);
		}
		this.retailPharmacies.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRetailPharmacies(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be removed to this entity
	 */
	public void removeRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities) {
		this.removeRetailPharmacies(entities, true);
	}

	/**
	 * Remove the given collection of RetailPharmacyEntity from  to this entity.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRetailPharmacies(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRetailPharmacies(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be set to this entity
	 */
	public void setRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities) {
		setRetailPharmacies(entities, true);
	}

	/**
	 * Replace the current entities in Retail Pharmacies with the given ones.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities, boolean reverseAdd) {

		this.unsetRetailPharmacies();
		this.retailPharmacies = new HashSet<>(entities);
		if (reverseAdd) {
			this.retailPharmacies.forEach(retailPharmaciesEntity -> retailPharmaciesEntity.setPatientGeneralInfo(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacies(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRetailPharmacies() {
		this.unsetRetailPharmacies(true);
	}

	/**
	 * Remove all the entities in Retail Pharmacies from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRetailPharmacies(boolean doReverse) {
		if (doReverse) {
			this.retailPharmacies.forEach(retailPharmaciesEntity -> retailPharmaciesEntity.unsetPatientGeneralInfo(false));
		}
		this.retailPharmacies.clear();
	}

/**
	 * Similar to {@link this#addVisits(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be added to this entity
	 */
	public void addVisits(@NonNull PatientVisitEntity entity) {
		addVisits(entity, true);
	}

	/**
	 * Add a new PatientVisitEntity to visits in this entity.
	 *
	 * @param entity the given PatientVisitEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addVisits(@NonNull PatientVisitEntity entity, boolean reverseAdd) {
		if (!this.visits.contains(entity)) {
			visits.add(entity);
			if (reverseAdd) {
				entity.setPatient(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addVisits(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVisitEntity to be added to this entity
	 */
	public void addVisits(@NonNull Collection<PatientVisitEntity> entities) {
		addVisits(entities, true);
	}

	/**
	 * Add a new collection of PatientVisitEntity to Visits in this entity.
	 *
	 * @param entities the given collection of PatientVisitEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addVisits(@NonNull Collection<PatientVisitEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addVisits(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeVisits(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void removeVisits(@NonNull PatientVisitEntity entity) {
		this.removeVisits(entity, true);
	}

	/**
	 * Remove the given PatientVisitEntity from this entity.
	 *
	 * @param entity the given PatientVisitEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVisits(@NonNull PatientVisitEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatient(false);
		}
		this.visits.remove(entity);
	}

	/**
	 * Similar to {@link this#removeVisits(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientVisitEntity to be removed to this entity
	 */
	public void removeVisits(@NonNull Collection<PatientVisitEntity> entities) {
		this.removeVisits(entities, true);
	}

	/**
	 * Remove the given collection of PatientVisitEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientVisitEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeVisits(@NonNull Collection<PatientVisitEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeVisits(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setVisits(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVisitEntity to be set to this entity
	 */
	public void setVisits(@NonNull Collection<PatientVisitEntity> entities) {
		setVisits(entities, true);
	}

	/**
	 * Replace the current entities in Visits with the given ones.
	 *
	 * @param entities the given collection of PatientVisitEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVisits(@NonNull Collection<PatientVisitEntity> entities, boolean reverseAdd) {

		this.unsetVisits();
		this.visits = new HashSet<>(entities);
		if (reverseAdd) {
			this.visits.forEach(visitsEntity -> visitsEntity.setPatient(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetVisits(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetVisits() {
		this.unsetVisits(true);
	}

	/**
	 * Remove all the entities in Visits from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetVisits(boolean doReverse) {
		if (doReverse) {
			this.visits.forEach(visitsEntity -> visitsEntity.unsetPatient(false));
		}
		this.visits.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	public void addPatientPicture(FileEntity newFile) {
		patientPicture.add(newFile);
	}

	public void addAllPatientPicture(Collection<FileEntity> newFiles) {
		patientPicture.addAll(newFiles);
	}

	public void removePatientPicture(FileEntity newFile) {
		patientPicture.remove(newFile);
	}

	public boolean containsPatientPicture(FileEntity newFile) {
		return patientPicture.contains(newFile);
	}

	public void clearAllPatientPicture() {
		patientPicture.clear();
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
