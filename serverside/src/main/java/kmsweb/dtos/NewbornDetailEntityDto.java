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
@Schema(description = "The Dto for NewbornDetailEntity")
@EqualsAndHashCode(callSuper = false)
public class NewbornDetailEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String newbornFirstName;

	private String newbornLastName;

	private OffsetDateTime dateTimeOfBirth;

	private String gender;

	private String deliveryType;

	private String deliveryTypeIndication;

	private Integer weight;

	private Integer length;

	private String weightOfGestationalAge;

	private Integer headCircumference;

	private Integer chestCircumference;

	private String birthCondition;

	private String neonatalCase;

	private String congenitalCondition;

	private String physicalExamination;

	private String apgar1MinuteAppearance;

	private String apgar5MinuteAppearance;

	private String apgar10MinuteAppearance;

	private String apgar1MinutePulse;

	private String apgar5MinutePulse;

	private String apgar10MinutePulse;

	private String apgar1MinuteGrimace;

	private String apgar5MinuteGrimace;

	private String apgar10MinuteGrimace;

	private String apgar1MinuteActivity;

	private String apgar5MinuteActivity;

	private String apgar10MinuteActivity;

	private String apgar1MinuteRespiration;

	private String apgar5MinuteRespiration;

	private String apgar10MinuteRespiration;

	private String apgar1MinuteScore;

	private String apgar5MinuteScore;

	private String apgar10MinuteScore;

	private String pediatricNurse;

	private String patientId;

	private String registrationId;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<VitalSignsEntity> vitalSigns = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecord;

	private StaffEntity staff;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
