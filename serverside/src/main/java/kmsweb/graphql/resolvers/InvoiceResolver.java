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

package kmsweb.graphql.resolvers;

import kmsweb.entities.*;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Component
public class InvoiceResolver implements GraphQLResolver<InvoiceEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	public Set<InvoiceItemEntity> invoiceItems(InvoiceEntity invoice) {
		return invoice.getInvoiceItems();
	}

	@PreAuthorize("hasPermission('InvoicePaymentInsuranceEntity', 'read')")
	public Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurances(InvoiceEntity invoice) {
		return invoice.getInvoicePaymentInsurances();
	}

	@PreAuthorize("hasPermission('InvoicePaymentOtherEntity', 'read')")
	public InvoicePaymentOtherEntity invoicePaymentOther(InvoiceEntity invoice) {
		return invoice.getInvoicePaymentOther();
	}

	@PreAuthorize("hasPermission('InvoicePaymentSelfPayingEntity', 'read')")
	public InvoicePaymentSelfPayingEntity invoicePaymentSelfPaying(InvoiceEntity invoice) {
		return invoice.getInvoicePaymentSelfPaying();
	}

	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	public InvoiceSummaryEntity invoiceSummary(InvoiceEntity invoice) {
		return invoice.getInvoiceSummary();
	}

	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	public PrescriptionHeaderEntity prescriptionHeader(InvoiceEntity invoice) {
		return invoice.getPrescriptionHeader();
	}

	@PreAuthorize("hasPermission('MedicationHeaderEntity', 'read')")
	public MedicationHeaderEntity medicationHeader(InvoiceEntity invoice) {
		return invoice.getMedicationHeader();
	}

	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'read')")
	public DiagnosesAndProceduresEntity icd10(InvoiceEntity invoice) {
		return invoice.getIcd10();
	}

	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'read')")
	public DiagnosesAndProceduresEntity icd9CM(InvoiceEntity invoice) {
		return invoice.getIcd9CM();
	}

	@PreAuthorize("hasPermission('BedFacilityEntity', 'read')")
	public BedFacilityEntity bedFacility(InvoiceEntity invoice) {
		return invoice.getBedFacility();
	}

	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	public PatientVisitEntity patientVisit(InvoiceEntity invoice) {
		return invoice.getPatientVisit();
	}

	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	public TariffSchemaEntity tariffSchema(InvoiceEntity invoice) {
		return invoice.getTariffSchema();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity verifiedBy(InvoiceEntity invoice) {
		return invoice.getVerifiedBy();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
