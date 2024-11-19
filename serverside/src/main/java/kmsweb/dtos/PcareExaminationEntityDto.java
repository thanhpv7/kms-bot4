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
import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for PcareExaminationEntity")
@EqualsAndHashCode(callSuper = false)
public class PcareExaminationEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String visitType;

	private String treatment;

	private String destinationPolyclinic;

	private String disease;

	private String diagnosis;

	private String diagnosis2;

	private String diagnosis3;

	private String therapy;

	private String consciousness;

	private String dischargeStatus;

	private String internalReferralPolyclinic;

	private OffsetDateTime referringDate;

	private String pkk;

	private String subSpecialist;

	private String facility;

	private String tacc;

	private String taccReason;

	private String special;

	private Double height;

	private Double weight;

	private Double waistCircumference;

	private Double bmi;

	private Integer systole;

	private Integer diastole;

	private Double respiratoryRate;

	private Double heartRate;

	private String medicalStaff;

	private String tglpulang;

	private String kdsubspesialis1;

	private String rujuklanjut;

	private String catatan;

	private String nokunjungan;

	private String jsoninsert;

	private String jsonupdate;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<PcareActionExaminationEntity> pcareActionExaminations = new HashSet<>();

	private Set<PcareCompoundDrugEntity> pcareCompoundDrugs = new HashSet<>();

	private Set<PcareNonCompoundDrugEntity> pcareNonCompoundDrugs = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private RegistrationEntity registration;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
