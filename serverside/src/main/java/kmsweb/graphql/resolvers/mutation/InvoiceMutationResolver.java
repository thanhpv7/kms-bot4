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

package kmsweb.graphql.resolvers.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kmsweb.entities.InvoiceEntity;
import kmsweb.services.InvoiceService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BedFacilityService;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.services.DiagnosesAndProceduresService;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.services.InvoiceItemService;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.services.InvoicePaymentInsuranceService;
import kmsweb.entities.InvoicePaymentInsuranceEntity;
import kmsweb.services.InvoicePaymentOtherService;
import kmsweb.entities.InvoicePaymentOtherEntity;
import kmsweb.services.InvoicePaymentSelfPayingService;
import kmsweb.entities.InvoicePaymentSelfPayingEntity;
import kmsweb.services.InvoiceSummaryService;
import kmsweb.entities.InvoiceSummaryEntity;
import kmsweb.services.MedicationHeaderService;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.services.PatientVisitService;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.services.PrescriptionHeaderService;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.services.StaffService;
import kmsweb.entities.StaffEntity;
import kmsweb.services.TariffSchemaService;
import kmsweb.entities.TariffSchemaEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class InvoiceMutationResolver implements GraphQLMutationResolver {

	private final InvoiceService invoiceService;

	private final BedFacilityService bedFacilityService;

	private final DiagnosesAndProceduresService diagnosesAndProceduresService;

	private final InvoiceItemService invoiceItemService;

	private final InvoicePaymentInsuranceService invoicePaymentInsuranceService;

	private final InvoicePaymentOtherService invoicePaymentOtherService;

	private final InvoicePaymentSelfPayingService invoicePaymentSelfPayingService;

	private final InvoiceSummaryService invoiceSummaryService;

	private final MedicationHeaderService medicationHeaderService;

	private final PatientVisitService patientVisitService;

	private final PrescriptionHeaderService prescriptionHeaderService;

	private final StaffService staffService;

	private final TariffSchemaService tariffSchemaService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InvoiceMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BedFacilityService bedFacilityService,
			DiagnosesAndProceduresService diagnosesAndProceduresService,
			InvoiceItemService invoiceItemService,
			InvoicePaymentInsuranceService invoicePaymentInsuranceService,
			InvoicePaymentOtherService invoicePaymentOtherService,
			InvoicePaymentSelfPayingService invoicePaymentSelfPayingService,
			InvoiceSummaryService invoiceSummaryService,
			MedicationHeaderService medicationHeaderService,
			PatientVisitService patientVisitService,
			PrescriptionHeaderService prescriptionHeaderService,
			StaffService staffService,
			TariffSchemaService tariffSchemaService,
			InvoiceService invoiceService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.invoiceService = invoiceService;

		this.bedFacilityService = bedFacilityService;

		this.diagnosesAndProceduresService = diagnosesAndProceduresService;

		this.invoiceItemService = invoiceItemService;

		this.invoicePaymentInsuranceService = invoicePaymentInsuranceService;

		this.invoicePaymentOtherService = invoicePaymentOtherService;

		this.invoicePaymentSelfPayingService = invoicePaymentSelfPayingService;

		this.invoiceSummaryService = invoiceSummaryService;

		this.medicationHeaderService = medicationHeaderService;

		this.patientVisitService = patientVisitService;

		this.prescriptionHeaderService = prescriptionHeaderService;

		this.staffService = staffService;

		this.tariffSchemaService = tariffSchemaService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'create')")
	public InvoiceEntity createInvoice(@NonNull InvoiceEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getMedicationHeader() != null) {
			rawEntity.setMedicationHeader(medicationHeaderService.updateOldData(rawEntity.getMedicationHeader()));
		}

		if (rawEntity.getInvoicePaymentOther() != null) {
			rawEntity.setInvoicePaymentOther(invoicePaymentOtherService.updateOldData(rawEntity.getInvoicePaymentOther()));
		}

		if (rawEntity.getInvoicePaymentSelfPaying() != null) {
			rawEntity.setInvoicePaymentSelfPaying(invoicePaymentSelfPayingService.updateOldData(rawEntity.getInvoicePaymentSelfPaying()));
		}

		if (rawEntity.getInvoiceSummary() != null) {
			rawEntity.setInvoiceSummary(invoiceSummaryService.updateOldData(rawEntity.getInvoiceSummary()));
		}

		if (rawEntity.getPrescriptionHeader() != null) {
			rawEntity.setPrescriptionHeader(prescriptionHeaderService.updateOldData(rawEntity.getPrescriptionHeader()));
		}

		if (rawEntity.getIcd10() != null) {
			rawEntity.setIcd10(diagnosesAndProceduresService.updateOldData(rawEntity.getIcd10()));
		}

		if (rawEntity.getIcd9CM() != null) {
			rawEntity.setIcd9CM(diagnosesAndProceduresService.updateOldData(rawEntity.getIcd9CM()));
		}

		if (rawEntity.getBedFacility() != null) {
			rawEntity.setBedFacility(bedFacilityService.updateOldData(rawEntity.getBedFacility()));
		}

		if (rawEntity.getPatientVisit() != null) {
			rawEntity.setPatientVisit(patientVisitService.updateOldData(rawEntity.getPatientVisit()));
		}

		if (rawEntity.getTariffSchema() != null) {
			rawEntity.setTariffSchema(tariffSchemaService.updateOldData(rawEntity.getTariffSchema()));
		}

		if (rawEntity.getVerifiedBy() != null) {
			rawEntity.setVerifiedBy(staffService.updateOldData(rawEntity.getVerifiedBy()));
		}

		Set<InvoiceItemEntity> invoiceItems = new HashSet<>();
		rawEntity.getInvoiceItems().forEach(entity -> {
			invoiceItems.add(invoiceItemService.updateOldData(entity));
		});
		rawEntity.setInvoiceItems(invoiceItems);

		Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurances = new HashSet<>();
		rawEntity.getInvoicePaymentInsurances().forEach(entity -> {
			invoicePaymentInsurances.add(invoicePaymentInsuranceService.updateOldData(entity));
		});
		rawEntity.setInvoicePaymentInsurances(invoicePaymentInsurances);

		InvoiceEntity newEntity = invoiceService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InvoiceMutationResolver#createInvoice(InvoiceEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'create')")
	public List<InvoiceEntity> createAllInvoice(@NonNull List<InvoiceEntity> rawEntities) {
		List<InvoiceEntity> newEntities = Lists.newArrayList(invoiceService.createAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the created entities here] off begin
		// % protected region % [Add any additional logic for update before returning the created entities here] end

		return newEntities;
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'update')")
	public InvoiceEntity updateInvoice(@NonNull InvoiceEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getMedicationHeader() != null) {
			rawEntity.setMedicationHeader(medicationHeaderService.updateOldData(rawEntity.getMedicationHeader()));
		}

		if (rawEntity.getInvoicePaymentOther() != null) {
			rawEntity.setInvoicePaymentOther(invoicePaymentOtherService.updateOldData(rawEntity.getInvoicePaymentOther()));
		}

		if (rawEntity.getInvoicePaymentSelfPaying() != null) {
			rawEntity.setInvoicePaymentSelfPaying(invoicePaymentSelfPayingService.updateOldData(rawEntity.getInvoicePaymentSelfPaying()));
		}

		if (rawEntity.getInvoiceSummary() != null) {
			rawEntity.setInvoiceSummary(invoiceSummaryService.updateOldData(rawEntity.getInvoiceSummary()));
		}

		if (rawEntity.getPrescriptionHeader() != null) {
			rawEntity.setPrescriptionHeader(prescriptionHeaderService.updateOldData(rawEntity.getPrescriptionHeader()));
		}

		if (rawEntity.getIcd10() != null) {
			rawEntity.setIcd10(diagnosesAndProceduresService.updateOldData(rawEntity.getIcd10()));
		}

		if (rawEntity.getIcd9CM() != null) {
			rawEntity.setIcd9CM(diagnosesAndProceduresService.updateOldData(rawEntity.getIcd9CM()));
		}

		if (rawEntity.getBedFacility() != null) {
			rawEntity.setBedFacility(bedFacilityService.updateOldData(rawEntity.getBedFacility()));
		}

		if (rawEntity.getPatientVisit() != null) {
			rawEntity.setPatientVisit(patientVisitService.updateOldData(rawEntity.getPatientVisit()));
		}

		if (rawEntity.getTariffSchema() != null) {
			rawEntity.setTariffSchema(tariffSchemaService.updateOldData(rawEntity.getTariffSchema()));
		}

		if (rawEntity.getVerifiedBy() != null) {
			rawEntity.setVerifiedBy(staffService.updateOldData(rawEntity.getVerifiedBy()));
		}

		Set<InvoiceItemEntity> invoiceItems = new HashSet<>();
		rawEntity.getInvoiceItems().forEach(entity -> {
			invoiceItems.add(invoiceItemService.updateOldData(entity));
		});
		rawEntity.setInvoiceItems(invoiceItems);

		Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurances = new HashSet<>();
		rawEntity.getInvoicePaymentInsurances().forEach(entity -> {
			invoicePaymentInsurances.add(invoicePaymentInsuranceService.updateOldData(entity));
		});
		rawEntity.setInvoicePaymentInsurances(invoicePaymentInsurances);

		InvoiceEntity entityFromDb = invoiceService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		InvoiceEntity newEntity = invoiceService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InvoiceMutationResolver#updateInvoice(InvoiceEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'update')")
	public List<InvoiceEntity> updateAllInvoice(@NonNull List<InvoiceEntity> rawEntities) {
		List<InvoiceEntity> newEntities = Lists.newArrayList(invoiceService.updateAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the updated entities here] off begin
		// % protected region % [Add any additional logic for update before returning the updated entities here] end

		return newEntities;
	}

	/**
	 * Delete the entity with the ID from the database.
	 *
	 * @param id the ID of the entity to be deleted
	 * @return the ID of the deleted entity
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'delete')")
	public String deleteInvoiceById(@NonNull String id) {
		invoiceService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link InvoiceMutationResolver#deleteInvoiceById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'delete')")
	public List<String> deleteAllInvoiceByIds(@NonNull List<String> ids) {
		invoiceService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('InvoiceEntity', 'delete')")
	public List<String> deleteInvoiceExcludingIds(@NonNull List<String> ids) {
		invoiceService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
