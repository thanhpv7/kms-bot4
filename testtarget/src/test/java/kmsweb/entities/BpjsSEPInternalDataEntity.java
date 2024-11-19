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

import lombok.*;
import javax.validation.constraints.NotNull;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class BpjsSEPInternalDataEntity extends AbstractEntity {

	public BpjsSEPInternalDataEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Referred Polyclinic here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referred Polyclinic here] end
	private String referredPolyclinic;

	// % protected region % [Modify attribute annotation for Referring Polyclinic here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referring Polyclinic here] end
	private String referringPolyclinic;

	// % protected region % [Modify attribute annotation for Internal Referral Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Internal Referral Date here] end
	private String internalReferralDate;

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

	// % protected region % [Modify attribute annotation for Ref SEP No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ref SEP No here] end
	private String refSEPNo;

	// % protected region % [Modify attribute annotation for SEP Health Facility here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SEP Health Facility here] end
	private String sepHealthFacility;

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for SEP Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SEP Date here] end
	private String sepDate;

	// % protected region % [Modify attribute annotation for Letter No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Letter No here] end
	private String letterNo;

	// % protected region % [Modify attribute annotation for Is Internal here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Internal here] end
	private String isInternal;

	// % protected region % [Modify attribute annotation for Referring Polyclinic Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referring Polyclinic Code here] end
	private String referringPolyclinicCode;

	// % protected region % [Modify attribute annotation for Diagnostic Support here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diagnostic Support here] end
	private String diagnosticSupport;

	// % protected region % [Modify attribute annotation for Referring Diagnose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referring Diagnose here] end
	private String referringDiagnose;

	// % protected region % [Modify attribute annotation for Doctor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor here] end
	private String doctor;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
