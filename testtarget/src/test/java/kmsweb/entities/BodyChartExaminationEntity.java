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
public class BodyChartExaminationEntity extends AbstractEntity {

	public BodyChartExaminationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "BodyChartExamination";
			MedicalExaminationRecordOneOne.optional = true;
			MedicalExaminationRecordOneOne.type = "One";
			MedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for BC01 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC01 Subjective here] end
	private String bc01Subjective;

	// % protected region % [Modify attribute annotation for BC01 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC01 Objective here] end
	private String bc01Objective;

	// % protected region % [Modify attribute annotation for BC02 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC02 Subjective here] end
	private String bc02Subjective;

	// % protected region % [Modify attribute annotation for BC02 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC02 Objective here] end
	private String bc02Objective;

	// % protected region % [Modify attribute annotation for BC03 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC03 Subjective here] end
	private String bc03Subjective;

	// % protected region % [Modify attribute annotation for BC03 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC03 Objective here] end
	private String bc03Objective;

	// % protected region % [Modify attribute annotation for BC04 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC04 Subjective here] end
	private String bc04Subjective;

	// % protected region % [Modify attribute annotation for BC04 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC04 Objective here] end
	private String bc04Objective;

	// % protected region % [Modify attribute annotation for BC05 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC05 Subjective here] end
	private String bc05Subjective;

	// % protected region % [Modify attribute annotation for BC05 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC05 Objective here] end
	private String bc05Objective;

	// % protected region % [Modify attribute annotation for BC06 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC06 Subjective here] end
	private String bc06Subjective;

	// % protected region % [Modify attribute annotation for BC06 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC06 Objective here] end
	private String bc06Objective;

	// % protected region % [Modify attribute annotation for BC07 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC07 Subjective here] end
	private String bc07Subjective;

	// % protected region % [Modify attribute annotation for BC07 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC07 Objective here] end
	private String bc07Objective;

	// % protected region % [Modify attribute annotation for BC08 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC08 Subjective here] end
	private String bc08Subjective;

	// % protected region % [Modify attribute annotation for BC08 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC08 Objective here] end
	private String bc08Objective;

	// % protected region % [Modify attribute annotation for BC09 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC09 Subjective here] end
	private String bc09Subjective;

	// % protected region % [Modify attribute annotation for BC09 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC09 Objective here] end
	private String bc09Objective;

	// % protected region % [Modify attribute annotation for BC10 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC10 Subjective here] end
	private String bc10Subjective;

	// % protected region % [Modify attribute annotation for BC10 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC10 Objective here] end
	private String bc10Objective;

	// % protected region % [Modify attribute annotation for BC11 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC11 Subjective here] end
	private String bc11Subjective;

	// % protected region % [Modify attribute annotation for BC11 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC11 Objective here] end
	private String bc11Objective;

	// % protected region % [Modify attribute annotation for BC12 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC12 Subjective here] end
	private String bc12Subjective;

	// % protected region % [Modify attribute annotation for BC12 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC12 Objective here] end
	private String bc12Objective;

	// % protected region % [Modify attribute annotation for BC13 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC13 Subjective here] end
	private String bc13Subjective;

	// % protected region % [Modify attribute annotation for BC13 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC13 Objective here] end
	private String bc13Objective;

	// % protected region % [Modify attribute annotation for BC14 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC14 Subjective here] end
	private String bc14Subjective;

	// % protected region % [Modify attribute annotation for BC14 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC14 Objective here] end
	private String bc14Objective;

	// % protected region % [Modify attribute annotation for BC15 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC15 Subjective here] end
	private String bc15Subjective;

	// % protected region % [Modify attribute annotation for BC15 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC15 Objective here] end
	private String bc15Objective;

	// % protected region % [Modify attribute annotation for BC16 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC16 Subjective here] end
	private String bc16Subjective;

	// % protected region % [Modify attribute annotation for BC16 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC16 Objective here] end
	private String bc16Objective;

	// % protected region % [Modify attribute annotation for BC17 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC17 Subjective here] end
	private String bc17Subjective;

	// % protected region % [Modify attribute annotation for BC17 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC17 Objective here] end
	private String bc17Objective;

	// % protected region % [Modify attribute annotation for BC18 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC18 Subjective here] end
	private String bc18Subjective;

	// % protected region % [Modify attribute annotation for BC18 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC18 Objective here] end
	private String bc18Objective;

	// % protected region % [Modify attribute annotation for BC19 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC19 Subjective here] end
	private String bc19Subjective;

	// % protected region % [Modify attribute annotation for BC19 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC19 Objective here] end
	private String bc19Objective;

	// % protected region % [Modify attribute annotation for BC20 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC20 Subjective here] end
	private String bc20Subjective;

	// % protected region % [Modify attribute annotation for BC20 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC20 Objective here] end
	private String bc20Objective;

	// % protected region % [Modify attribute annotation for BC21 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC21 Subjective here] end
	private String bc21Subjective;

	// % protected region % [Modify attribute annotation for BC21 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC21 Objective here] end
	private String bc21Objective;

	// % protected region % [Modify attribute annotation for BC22 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC22 Subjective here] end
	private String bc22Subjective;

	// % protected region % [Modify attribute annotation for BC22 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC22 Objective here] end
	private String bc22Objective;

	// % protected region % [Modify attribute annotation for BC23 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC23 Subjective here] end
	private String bc23Subjective;

	// % protected region % [Modify attribute annotation for BC23 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC23 Objective here] end
	private String bc23Objective;

	// % protected region % [Modify attribute annotation for BC24 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC24 Subjective here] end
	private String bc24Subjective;

	// % protected region % [Modify attribute annotation for BC24 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC24 Objective here] end
	private String bc24Objective;

	// % protected region % [Modify attribute annotation for BC25 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC25 Subjective here] end
	private String bc25Subjective;

	// % protected region % [Modify attribute annotation for BC25 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC25 Objective here] end
	private String bc25Objective;

	// % protected region % [Modify attribute annotation for BC26 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC26 Subjective here] end
	private String bc26Subjective;

	// % protected region % [Modify attribute annotation for BC26 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC26 Objective here] end
	private String bc26Objective;

	// % protected region % [Modify attribute annotation for BC27 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC27 Subjective here] end
	private String bc27Subjective;

	// % protected region % [Modify attribute annotation for BC27 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC27 Objective here] end
	private String bc27Objective;

	// % protected region % [Modify attribute annotation for BC28 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC28 Subjective here] end
	private String bc28Subjective;

	// % protected region % [Modify attribute annotation for BC28 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC28 Objective here] end
	private String bc28Objective;

	// % protected region % [Modify attribute annotation for BC29 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC29 Subjective here] end
	private String bc29Subjective;

	// % protected region % [Modify attribute annotation for BC29 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC29 Objective here] end
	private String bc29Objective;

	// % protected region % [Modify attribute annotation for BC30 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC30 Subjective here] end
	private String bc30Subjective;

	// % protected region % [Modify attribute annotation for BC30 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC30 Objective here] end
	private String bc30Objective;

	// % protected region % [Modify attribute annotation for BC31 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC31 Subjective here] end
	private String bc31Subjective;

	// % protected region % [Modify attribute annotation for BC31 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC31 Objective here] end
	private String bc31Objective;

	// % protected region % [Modify attribute annotation for BC32 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC32 Subjective here] end
	private String bc32Subjective;

	// % protected region % [Modify attribute annotation for BC32 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC32 Objective here] end
	private String bc32Objective;

	// % protected region % [Modify attribute annotation for BC33 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC33 Subjective here] end
	private String bc33Subjective;

	// % protected region % [Modify attribute annotation for BC33 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC33 Objective here] end
	private String bc33Objective;

	// % protected region % [Modify attribute annotation for BC34 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC34 Subjective here] end
	private String bc34Subjective;

	// % protected region % [Modify attribute annotation for BC34 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC34 Objective here] end
	private String bc34Objective;

	// % protected region % [Modify attribute annotation for BC35 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC35 Subjective here] end
	private String bc35Subjective;

	// % protected region % [Modify attribute annotation for BC35 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC35 Objective here] end
	private String bc35Objective;

	// % protected region % [Modify attribute annotation for BC36 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC36 Subjective here] end
	private String bc36Subjective;

	// % protected region % [Modify attribute annotation for BC36 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC36 Objective here] end
	private String bc36Objective;

	// % protected region % [Modify attribute annotation for BC37 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC37 Subjective here] end
	private String bc37Subjective;

	// % protected region % [Modify attribute annotation for BC37 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC37 Objective here] end
	private String bc37Objective;

	// % protected region % [Modify attribute annotation for BC38 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC38 Subjective here] end
	private String bc38Subjective;

	// % protected region % [Modify attribute annotation for BC38 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC38 Objective here] end
	private String bc38Objective;

	// % protected region % [Modify attribute annotation for BC39 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC39 Subjective here] end
	private String bc39Subjective;

	// % protected region % [Modify attribute annotation for BC39 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC39 Objective here] end
	private String bc39Objective;

	// % protected region % [Modify attribute annotation for BC40 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC40 Subjective here] end
	private String bc40Subjective;

	// % protected region % [Modify attribute annotation for BC40 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC40 Objective here] end
	private String bc40Objective;

	// % protected region % [Modify attribute annotation for BC41 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC41 Subjective here] end
	private String bc41Subjective;

	// % protected region % [Modify attribute annotation for BC41 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC41 Objective here] end
	private String bc41Objective;

	// % protected region % [Modify attribute annotation for BC42 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC42 Subjective here] end
	private String bc42Subjective;

	// % protected region % [Modify attribute annotation for BC42 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC42 Objective here] end
	private String bc42Objective;

	// % protected region % [Modify attribute annotation for BC43 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC43 Subjective here] end
	private String bc43Subjective;

	// % protected region % [Modify attribute annotation for BC43 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC43 Objective here] end
	private String bc43Objective;

	// % protected region % [Modify attribute annotation for BC44 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC44 Subjective here] end
	private String bc44Subjective;

	// % protected region % [Modify attribute annotation for BC44 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC44 Objective here] end
	private String bc44Objective;

	// % protected region % [Modify attribute annotation for BC45 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC45 Subjective here] end
	private String bc45Subjective;

	// % protected region % [Modify attribute annotation for BC45 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC45 Objective here] end
	private String bc45Objective;

	// % protected region % [Modify attribute annotation for BC46 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC46 Subjective here] end
	private String bc46Subjective;

	// % protected region % [Modify attribute annotation for BC46 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC46 Objective here] end
	private String bc46Objective;

	// % protected region % [Modify attribute annotation for BC47 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC47 Subjective here] end
	private String bc47Subjective;

	// % protected region % [Modify attribute annotation for BC47 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC47 Objective here] end
	private String bc47Objective;

	// % protected region % [Modify attribute annotation for BC48 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC48 Subjective here] end
	private String bc48Subjective;

	// % protected region % [Modify attribute annotation for BC48 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC48 Objective here] end
	private String bc48Objective;

	// % protected region % [Modify attribute annotation for BC49 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC49 Subjective here] end
	private String bc49Subjective;

	// % protected region % [Modify attribute annotation for BC49 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC49 Objective here] end
	private String bc49Objective;

	// % protected region % [Modify attribute annotation for BC50 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC50 Subjective here] end
	private String bc50Subjective;

	// % protected region % [Modify attribute annotation for BC50 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC50 Objective here] end
	private String bc50Objective;

	// % protected region % [Modify attribute annotation for BC51 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC51 Subjective here] end
	private String bc51Subjective;

	// % protected region % [Modify attribute annotation for BC51 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC51 Objective here] end
	private String bc51Objective;

	// % protected region % [Modify attribute annotation for BC52 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC52 Subjective here] end
	private String bc52Subjective;

	// % protected region % [Modify attribute annotation for BC52 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC52 Objective here] end
	private String bc52Objective;

	// % protected region % [Modify attribute annotation for BC53 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC53 Subjective here] end
	private String bc53Subjective;

	// % protected region % [Modify attribute annotation for BC53 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC53 Objective here] end
	private String bc53Objective;

	// % protected region % [Modify attribute annotation for BC54 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC54 Subjective here] end
	private String bc54Subjective;

	// % protected region % [Modify attribute annotation for BC54 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC54 Objective here] end
	private String bc54Objective;

	// % protected region % [Modify attribute annotation for BC55 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC55 Subjective here] end
	private String bc55Subjective;

	// % protected region % [Modify attribute annotation for BC55 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC55 Objective here] end
	private String bc55Objective;

	// % protected region % [Modify attribute annotation for BC56 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC56 Subjective here] end
	private String bc56Subjective;

	// % protected region % [Modify attribute annotation for BC56 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC56 Objective here] end
	private String bc56Objective;

	// % protected region % [Modify attribute annotation for BC57 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC57 Subjective here] end
	private String bc57Subjective;

	// % protected region % [Modify attribute annotation for BC57 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC57 Objective here] end
	private String bc57Objective;

	// % protected region % [Modify attribute annotation for BC58 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC58 Subjective here] end
	private String bc58Subjective;

	// % protected region % [Modify attribute annotation for BC58 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC58 Objective here] end
	private String bc58Objective;

	// % protected region % [Modify attribute annotation for BC59 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC59 Subjective here] end
	private String bc59Subjective;

	// % protected region % [Modify attribute annotation for BC59 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC59 Objective here] end
	private String bc59Objective;

	// % protected region % [Modify attribute annotation for BC60 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC60 Subjective here] end
	private String bc60Subjective;

	// % protected region % [Modify attribute annotation for BC60 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC60 Objective here] end
	private String bc60Objective;

	// % protected region % [Modify attribute annotation for BC61 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC61 Subjective here] end
	private String bc61Subjective;

	// % protected region % [Modify attribute annotation for BC61 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC61 Objective here] end
	private String bc61Objective;

	// % protected region % [Modify attribute annotation for BC62 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC62 Subjective here] end
	private String bc62Subjective;

	// % protected region % [Modify attribute annotation for BC62 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC62 Objective here] end
	private String bc62Objective;

	// % protected region % [Modify attribute annotation for BC63 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC63 Subjective here] end
	private String bc63Subjective;

	// % protected region % [Modify attribute annotation for BC63 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC63 Objective here] end
	private String bc63Objective;

	// % protected region % [Modify attribute annotation for BC64 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC64 Subjective here] end
	private String bc64Subjective;

	// % protected region % [Modify attribute annotation for BC64 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC64 Objective here] end
	private String bc64Objective;

	// % protected region % [Modify attribute annotation for BC65 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC65 Subjective here] end
	private String bc65Subjective;

	// % protected region % [Modify attribute annotation for BC65 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC65 Objective here] end
	private String bc65Objective;

	// % protected region % [Modify attribute annotation for BC66 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC66 Subjective here] end
	private String bc66Subjective;

	// % protected region % [Modify attribute annotation for BC66 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC66 Objective here] end
	private String bc66Objective;

	// % protected region % [Modify attribute annotation for BC67 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC67 Subjective here] end
	private String bc67Subjective;

	// % protected region % [Modify attribute annotation for BC67 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC67 Objective here] end
	private String bc67Objective;

	// % protected region % [Modify attribute annotation for BC68 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC68 Subjective here] end
	private String bc68Subjective;

	// % protected region % [Modify attribute annotation for BC68 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC68 Objective here] end
	private String bc68Objective;

	// % protected region % [Modify attribute annotation for BC69 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC69 Subjective here] end
	private String bc69Subjective;

	// % protected region % [Modify attribute annotation for BC69 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC69 Objective here] end
	private String bc69Objective;

	// % protected region % [Modify attribute annotation for BC70 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC70 Subjective here] end
	private String bc70Subjective;

	// % protected region % [Modify attribute annotation for BC70 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC70 Objective here] end
	private String bc70Objective;

	// % protected region % [Modify attribute annotation for BC71 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC71 Subjective here] end
	private String bc71Subjective;

	// % protected region % [Modify attribute annotation for BC71 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC71 Objective here] end
	private String bc71Objective;

	// % protected region % [Modify attribute annotation for BC72 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC72 Subjective here] end
	private String bc72Subjective;

	// % protected region % [Modify attribute annotation for BC72 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC72 Objective here] end
	private String bc72Objective;

	// % protected region % [Modify attribute annotation for BC73 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC73 Subjective here] end
	private String bc73Subjective;

	// % protected region % [Modify attribute annotation for BC73 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC73 Objective here] end
	private String bc73Objective;

	// % protected region % [Modify attribute annotation for BC74 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC74 Subjective here] end
	private String bc74Subjective;

	// % protected region % [Modify attribute annotation for BC74 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC74 Objective here] end
	private String bc74Objective;

	// % protected region % [Modify attribute annotation for BC75 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC75 Subjective here] end
	private String bc75Subjective;

	// % protected region % [Modify attribute annotation for BC75 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC75 Objective here] end
	private String bc75Objective;

	// % protected region % [Modify attribute annotation for BC76 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC76 Subjective here] end
	private String bc76Subjective;

	// % protected region % [Modify attribute annotation for BC76 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC76 Objective here] end
	private String bc76Objective;

	// % protected region % [Modify attribute annotation for BC77 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC77 Subjective here] end
	private String bc77Subjective;

	// % protected region % [Modify attribute annotation for BC77 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC77 Objective here] end
	private String bc77Objective;

	// % protected region % [Modify attribute annotation for BC78 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC78 Subjective here] end
	private String bc78Subjective;

	// % protected region % [Modify attribute annotation for BC78 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC78 Objective here] end
	private String bc78Objective;

	// % protected region % [Modify attribute annotation for BC79 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC79 Subjective here] end
	private String bc79Subjective;

	// % protected region % [Modify attribute annotation for BC79 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC79 Objective here] end
	private String bc79Objective;

	// % protected region % [Modify attribute annotation for BC80 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC80 Subjective here] end
	private String bc80Subjective;

	// % protected region % [Modify attribute annotation for BC80 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC80 Objective here] end
	private String bc80Objective;

	// % protected region % [Modify attribute annotation for BC81 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC81 Subjective here] end
	private String bc81Subjective;

	// % protected region % [Modify attribute annotation for BC81 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC81 Objective here] end
	private String bc81Objective;

	// % protected region % [Modify attribute annotation for BC82 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC82 Subjective here] end
	private String bc82Subjective;

	// % protected region % [Modify attribute annotation for BC82 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC82 Objective here] end
	private String bc82Objective;

	// % protected region % [Modify attribute annotation for BC83 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC83 Subjective here] end
	private String bc83Subjective;

	// % protected region % [Modify attribute annotation for BC83 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC83 Objective here] end
	private String bc83Objective;

	// % protected region % [Modify attribute annotation for BC84 Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC84 Subjective here] end
	private String bc84Subjective;

	// % protected region % [Modify attribute annotation for BC84 Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BC84 Objective here] end
	private String bc84Objective;

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

	private MedicalExaminationRecordEntity medicalExaminationRecord;

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

	/**
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetBodyChartExamination(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setBodyChartExamination(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove the MedicalExaminationRecordEntity of medicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetBodyChartExamination();
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
