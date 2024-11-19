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
@Schema(description = "The Dto for BodyChartExaminationEntity")
@EqualsAndHashCode(callSuper = false)
public class BodyChartExaminationEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String bc01Subjective;

	private String bc01Objective;

	private String bc02Subjective;

	private String bc02Objective;

	private String bc03Subjective;

	private String bc03Objective;

	private String bc04Subjective;

	private String bc04Objective;

	private String bc05Subjective;

	private String bc05Objective;

	private String bc06Subjective;

	private String bc06Objective;

	private String bc07Subjective;

	private String bc07Objective;

	private String bc08Subjective;

	private String bc08Objective;

	private String bc09Subjective;

	private String bc09Objective;

	private String bc10Subjective;

	private String bc10Objective;

	private String bc11Subjective;

	private String bc11Objective;

	private String bc12Subjective;

	private String bc12Objective;

	private String bc13Subjective;

	private String bc13Objective;

	private String bc14Subjective;

	private String bc14Objective;

	private String bc15Subjective;

	private String bc15Objective;

	private String bc16Subjective;

	private String bc16Objective;

	private String bc17Subjective;

	private String bc17Objective;

	private String bc18Subjective;

	private String bc18Objective;

	private String bc19Subjective;

	private String bc19Objective;

	private String bc20Subjective;

	private String bc20Objective;

	private String bc21Subjective;

	private String bc21Objective;

	private String bc22Subjective;

	private String bc22Objective;

	private String bc23Subjective;

	private String bc23Objective;

	private String bc24Subjective;

	private String bc24Objective;

	private String bc25Subjective;

	private String bc25Objective;

	private String bc26Subjective;

	private String bc26Objective;

	private String bc27Subjective;

	private String bc27Objective;

	private String bc28Subjective;

	private String bc28Objective;

	private String bc29Subjective;

	private String bc29Objective;

	private String bc30Subjective;

	private String bc30Objective;

	private String bc31Subjective;

	private String bc31Objective;

	private String bc32Subjective;

	private String bc32Objective;

	private String bc33Subjective;

	private String bc33Objective;

	private String bc34Subjective;

	private String bc34Objective;

	private String bc35Subjective;

	private String bc35Objective;

	private String bc36Subjective;

	private String bc36Objective;

	private String bc37Subjective;

	private String bc37Objective;

	private String bc38Subjective;

	private String bc38Objective;

	private String bc39Subjective;

	private String bc39Objective;

	private String bc40Subjective;

	private String bc40Objective;

	private String bc41Subjective;

	private String bc41Objective;

	private String bc42Subjective;

	private String bc42Objective;

	private String bc43Subjective;

	private String bc43Objective;

	private String bc44Subjective;

	private String bc44Objective;

	private String bc45Subjective;

	private String bc45Objective;

	private String bc46Subjective;

	private String bc46Objective;

	private String bc47Subjective;

	private String bc47Objective;

	private String bc48Subjective;

	private String bc48Objective;

	private String bc49Subjective;

	private String bc49Objective;

	private String bc50Subjective;

	private String bc50Objective;

	private String bc51Subjective;

	private String bc51Objective;

	private String bc52Subjective;

	private String bc52Objective;

	private String bc53Subjective;

	private String bc53Objective;

	private String bc54Subjective;

	private String bc54Objective;

	private String bc55Subjective;

	private String bc55Objective;

	private String bc56Subjective;

	private String bc56Objective;

	private String bc57Subjective;

	private String bc57Objective;

	private String bc58Subjective;

	private String bc58Objective;

	private String bc59Subjective;

	private String bc59Objective;

	private String bc60Subjective;

	private String bc60Objective;

	private String bc61Subjective;

	private String bc61Objective;

	private String bc62Subjective;

	private String bc62Objective;

	private String bc63Subjective;

	private String bc63Objective;

	private String bc64Subjective;

	private String bc64Objective;

	private String bc65Subjective;

	private String bc65Objective;

	private String bc66Subjective;

	private String bc66Objective;

	private String bc67Subjective;

	private String bc67Objective;

	private String bc68Subjective;

	private String bc68Objective;

	private String bc69Subjective;

	private String bc69Objective;

	private String bc70Subjective;

	private String bc70Objective;

	private String bc71Subjective;

	private String bc71Objective;

	private String bc72Subjective;

	private String bc72Objective;

	private String bc73Subjective;

	private String bc73Objective;

	private String bc74Subjective;

	private String bc74Objective;

	private String bc75Subjective;

	private String bc75Objective;

	private String bc76Subjective;

	private String bc76Objective;

	private String bc77Subjective;

	private String bc77Objective;

	private String bc78Subjective;

	private String bc78Objective;

	private String bc79Subjective;

	private String bc79Objective;

	private String bc80Subjective;

	private String bc80Objective;

	private String bc81Subjective;

	private String bc81Objective;

	private String bc82Subjective;

	private String bc82Objective;

	private String bc83Subjective;

	private String bc83Objective;

	private String bc84Subjective;

	private String bc84Objective;

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
