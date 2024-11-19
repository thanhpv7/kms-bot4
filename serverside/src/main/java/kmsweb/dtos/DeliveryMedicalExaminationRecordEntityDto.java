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
@Schema(description = "The Dto for DeliveryMedicalExaminationRecordEntity")
@EqualsAndHashCode(callSuper = false)
public class DeliveryMedicalExaminationRecordEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String pregnancyHistoryGravida;

	private String pregnancyHistoryPartum;

	private String pregnancyHistoryAbortum;

	private String pregnancyHistoryNotes;

	private OffsetDateTime lnmpStartDate;

	private OffsetDateTime lnmpEndDate;

	private OffsetDateTime approximateBirthDate;

	private Integer gestationAgeWeeks;

	private Integer gestationAgeDays;

	private Boolean tetanusVaccine1;

	private Boolean tetanusVaccine2;

	private String deliveryType;

	private String complicationsInPregnancy;

	private String riskFactor;

	private String fetalPresentation;

	private String abdomenExamination;

	private String fundalHeight;

	private String fhrPerMinute;

	private String estimatedFetalWeight;

	private String leopold1;

	private String leopold2;

	private String leopold3;

	private String leopold4;

	private String geniteliaExterna;

	private String geniteliaInterna;

	private String vaginalExamination;

	private String deliveryComplication;

	private String deliveryNote;

	private Boolean normalDeliveryCase;

	private Integer stage1Hour;

	private Integer unnamedInteger1;

	private Integer stage3Hour;

	private Integer stage4Hour;

	private Integer stage1Minute;

	private Integer stage2Minute;

	private Integer stage3Minute;

	private Integer stage4Minute;

	private String placenta;

	private String perineum;

	private String bleeding;

	private String postpartumComplication;

	private Integer newbornDelivered;

	private Boolean perineumInfection;

	private Boolean earlyBreastfeedingIntiation;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<CoTreatingDoctorEntity> additionalMidwives = new HashSet<>();

	private Set<DeliveryProgressEntity> deliveryProgresses = new HashSet<>();

	private Set<NewbornDetailEntity> newbornDetails = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	private StaffEntity midwife;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
