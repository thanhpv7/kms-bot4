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

package kmsweb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.entities.*;
import lombok.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for MedicalRecordNextVerificationChecklistEntity")
@EqualsAndHashCode(callSuper = false)
public class MedicalRecordNextVerificationChecklistEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Boolean outVitalSign;

	private Boolean outAnamnesis;

	private Boolean outPhysicalExamination;

	private Boolean outDiagnosis;

	private Boolean outDismissalType;

	private Boolean outDismissalDateAndTime;

	private Boolean inpVitalSign;

	private Boolean inpDailyCareDoctorNotes;

	private Boolean inpDailyCareDoctorNotesNA;

	private Boolean inpDailyCareNursingNotes;

	private Boolean inpDailyCareNursingNotesNA;

	private Boolean inpDailyCareProgressNotes;

	private Boolean inpDailyCareProgressNotesNA;

	private Boolean inpDismissalDiagnosis;

	private Boolean inpDismissalType;

	private Boolean inpDismissalDateAndTime;

	private Boolean inpDismissalCondition;

	private Boolean drAdmissionDiagnosis;

	private Boolean drObservationDoctorNotes;

	private Boolean drObservationDoctorNotesNA;

	private Boolean drObservationNursingNotes;

	private Boolean drObservationNursingNotesNA;

	private Boolean drObservationProgressNotes;

	private Boolean drObservationProgressNotesNA;

	private Boolean drDismissalDiagnosis;

	private Boolean drDismissalType;

	private Boolean drDismissalDateAndTime;

	private Boolean otPreOperativeDiagnosis;

	private Boolean otPreOperativeNotesSurgery;

	private Boolean otPreOperativeNotesAnaesthesiology;

	private Boolean otIntraOperativeNotesSurgery;

	private Boolean otIntraOperativeNotesAnaesthesiology;

	private Boolean otPostOperativeNotesSurgery;

	private Boolean otPostOperativeNotesAnaesthesiology;

	private Boolean otPostOperativeDiagnosis;

	private Boolean otDismissalType;

	private Boolean otDismissalDateAndTime;

	private Boolean dsResponsibleStaff;

	private Boolean dsInterpretation;

	private String notes;

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

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}