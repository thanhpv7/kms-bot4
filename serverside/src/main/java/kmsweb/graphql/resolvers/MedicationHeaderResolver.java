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
public class MedicationHeaderResolver implements GraphQLResolver<MedicationHeaderEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	public Set<InvoiceItemEntity> invoiceItems(MedicationHeaderEntity medicationHeader) {
		return medicationHeader.getInvoiceItems();
	}

	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	public InvoiceEntity invoice(MedicationHeaderEntity medicationHeader) {
		return medicationHeader.getInvoice();
	}

	@PreAuthorize("hasPermission('MedicationCompoundEntity', 'read')")
	public Set<MedicationCompoundEntity> medicationCompounds(MedicationHeaderEntity medicationHeader) {
		return medicationHeader.getMedicationCompounds();
	}

	@PreAuthorize("hasPermission('MedicationItemEntity', 'read')")
	public Set<MedicationItemEntity> medicationItems(MedicationHeaderEntity medicationHeader) {
		return medicationHeader.getMedicationItems();
	}

	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public RegistrationEntity registration(MedicationHeaderEntity medicationHeader) {
		return medicationHeader.getRegistration();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity requestedBy(MedicationHeaderEntity medicationHeader) {
		return medicationHeader.getRequestedBy();
	}

	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	public WarehouseEntity warehouse(MedicationHeaderEntity medicationHeader) {
		return medicationHeader.getWarehouse();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
