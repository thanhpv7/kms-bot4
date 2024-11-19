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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.EntExaminationEntityDto;
import kmsweb.entities.listeners.EntExaminationEntityListener;
import kmsweb.serializers.EntExaminationSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({EntExaminationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = EntExaminationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class EntExaminationEntity extends AbstractEntity {

	/**
	 * Takes a EntExaminationEntityDto and converts it into a EntExaminationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param entExaminationEntityDto
	 */
	public EntExaminationEntity(EntExaminationEntityDto entExaminationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (entExaminationEntityDto.getId() != null) {
			this.setId(entExaminationEntityDto.getId());
		}

		if (entExaminationEntityDto.getRightExternalEarSubjective() != null) {
			this.setRightExternalEarSubjective(entExaminationEntityDto.getRightExternalEarSubjective());
		}

		if (entExaminationEntityDto.getRightExternalEarObjective() != null) {
			this.setRightExternalEarObjective(entExaminationEntityDto.getRightExternalEarObjective());
		}

		if (entExaminationEntityDto.getRightConchaSubjective() != null) {
			this.setRightConchaSubjective(entExaminationEntityDto.getRightConchaSubjective());
		}

		if (entExaminationEntityDto.getRightConchaObjective() != null) {
			this.setRightConchaObjective(entExaminationEntityDto.getRightConchaObjective());
		}

		if (entExaminationEntityDto.getRightEarlobeSubjective() != null) {
			this.setRightEarlobeSubjective(entExaminationEntityDto.getRightEarlobeSubjective());
		}

		if (entExaminationEntityDto.getRightEarlobeObjective() != null) {
			this.setRightEarlobeObjective(entExaminationEntityDto.getRightEarlobeObjective());
		}

		if (entExaminationEntityDto.getRightEarCanalSubjective() != null) {
			this.setRightEarCanalSubjective(entExaminationEntityDto.getRightEarCanalSubjective());
		}

		if (entExaminationEntityDto.getRightEarCanalObjective() != null) {
			this.setRightEarCanalObjective(entExaminationEntityDto.getRightEarCanalObjective());
		}

		if (entExaminationEntityDto.getRightEardrumSubjective() != null) {
			this.setRightEardrumSubjective(entExaminationEntityDto.getRightEardrumSubjective());
		}

		if (entExaminationEntityDto.getRightEardrumObjective() != null) {
			this.setRightEardrumObjective(entExaminationEntityDto.getRightEardrumObjective());
		}

		if (entExaminationEntityDto.getLeftExternalEarSubjective() != null) {
			this.setLeftExternalEarSubjective(entExaminationEntityDto.getLeftExternalEarSubjective());
		}

		if (entExaminationEntityDto.getLeftExternalEarObjective() != null) {
			this.setLeftExternalEarObjective(entExaminationEntityDto.getLeftExternalEarObjective());
		}

		if (entExaminationEntityDto.getLeftConchaSubjective() != null) {
			this.setLeftConchaSubjective(entExaminationEntityDto.getLeftConchaSubjective());
		}

		if (entExaminationEntityDto.getLeftConchaObjective() != null) {
			this.setLeftConchaObjective(entExaminationEntityDto.getLeftConchaObjective());
		}

		if (entExaminationEntityDto.getLeftEarlobeSubjective() != null) {
			this.setLeftEarlobeSubjective(entExaminationEntityDto.getLeftEarlobeSubjective());
		}

		if (entExaminationEntityDto.getLeftEarlobeObjective() != null) {
			this.setLeftEarlobeObjective(entExaminationEntityDto.getLeftEarlobeObjective());
		}

		if (entExaminationEntityDto.getLeftEarCanalSubjective() != null) {
			this.setLeftEarCanalSubjective(entExaminationEntityDto.getLeftEarCanalSubjective());
		}

		if (entExaminationEntityDto.getLeftEarCanalObjective() != null) {
			this.setLeftEarCanalObjective(entExaminationEntityDto.getLeftEarCanalObjective());
		}

		if (entExaminationEntityDto.getLeftEardrumSubjective() != null) {
			this.setLeftEardrumSubjective(entExaminationEntityDto.getLeftEardrumSubjective());
		}

		if (entExaminationEntityDto.getLeftEardrumObjective() != null) {
			this.setLeftEardrumObjective(entExaminationEntityDto.getLeftEardrumObjective());
		}

		if (entExaminationEntityDto.getNasalBoneSubjective() != null) {
			this.setNasalBoneSubjective(entExaminationEntityDto.getNasalBoneSubjective());
		}

		if (entExaminationEntityDto.getNasalBoneObjective() != null) {
			this.setNasalBoneObjective(entExaminationEntityDto.getNasalBoneObjective());
		}

		if (entExaminationEntityDto.getRightFrontalSinusSubjective() != null) {
			this.setRightFrontalSinusSubjective(entExaminationEntityDto.getRightFrontalSinusSubjective());
		}

		if (entExaminationEntityDto.getRightFrontalSinusObjective() != null) {
			this.setRightFrontalSinusObjective(entExaminationEntityDto.getRightFrontalSinusObjective());
		}

		if (entExaminationEntityDto.getRightEthmoidSinusSubjective() != null) {
			this.setRightEthmoidSinusSubjective(entExaminationEntityDto.getRightEthmoidSinusSubjective());
		}

		if (entExaminationEntityDto.getRightEthmoidSinusObjective() != null) {
			this.setRightEthmoidSinusObjective(entExaminationEntityDto.getRightEthmoidSinusObjective());
		}

		if (entExaminationEntityDto.getRightSuperiorTurbinateSubjective() != null) {
			this.setRightSuperiorTurbinateSubjective(entExaminationEntityDto.getRightSuperiorTurbinateSubjective());
		}

		if (entExaminationEntityDto.getRightSuperiorTurbinateObjective() != null) {
			this.setRightSuperiorTurbinateObjective(entExaminationEntityDto.getRightSuperiorTurbinateObjective());
		}

		if (entExaminationEntityDto.getRightMiddleTurbinateSubjective() != null) {
			this.setRightMiddleTurbinateSubjective(entExaminationEntityDto.getRightMiddleTurbinateSubjective());
		}

		if (entExaminationEntityDto.getRightMiddleTurbinateObjective() != null) {
			this.setRightMiddleTurbinateObjective(entExaminationEntityDto.getRightMiddleTurbinateObjective());
		}

		if (entExaminationEntityDto.getRightMaxillarySinusSubjective() != null) {
			this.setRightMaxillarySinusSubjective(entExaminationEntityDto.getRightMaxillarySinusSubjective());
		}

		if (entExaminationEntityDto.getRightMaxillarySinusObjective() != null) {
			this.setRightMaxillarySinusObjective(entExaminationEntityDto.getRightMaxillarySinusObjective());
		}

		if (entExaminationEntityDto.getRightNasalCavitySubjective() != null) {
			this.setRightNasalCavitySubjective(entExaminationEntityDto.getRightNasalCavitySubjective());
		}

		if (entExaminationEntityDto.getRightNasalCavityObjective() != null) {
			this.setRightNasalCavityObjective(entExaminationEntityDto.getRightNasalCavityObjective());
		}

		if (entExaminationEntityDto.getRightInferiorTurbinateSubjective() != null) {
			this.setRightInferiorTurbinateSubjective(entExaminationEntityDto.getRightInferiorTurbinateSubjective());
		}

		if (entExaminationEntityDto.getRightInferiorTurbinateObjective() != null) {
			this.setRightInferiorTurbinateObjective(entExaminationEntityDto.getRightInferiorTurbinateObjective());
		}

		if (entExaminationEntityDto.getLeftFrontalSinusSubjective() != null) {
			this.setLeftFrontalSinusSubjective(entExaminationEntityDto.getLeftFrontalSinusSubjective());
		}

		if (entExaminationEntityDto.getLeftFrontalSinusObjective() != null) {
			this.setLeftFrontalSinusObjective(entExaminationEntityDto.getLeftFrontalSinusObjective());
		}

		if (entExaminationEntityDto.getLeftEthmoidSinusSubjective() != null) {
			this.setLeftEthmoidSinusSubjective(entExaminationEntityDto.getLeftEthmoidSinusSubjective());
		}

		if (entExaminationEntityDto.getLeftEthmoidSinusObjective() != null) {
			this.setLeftEthmoidSinusObjective(entExaminationEntityDto.getLeftEthmoidSinusObjective());
		}

		if (entExaminationEntityDto.getLeftSuperiorTurbinateSubjective() != null) {
			this.setLeftSuperiorTurbinateSubjective(entExaminationEntityDto.getLeftSuperiorTurbinateSubjective());
		}

		if (entExaminationEntityDto.getLeftSuperiorTurbinateObjective() != null) {
			this.setLeftSuperiorTurbinateObjective(entExaminationEntityDto.getLeftSuperiorTurbinateObjective());
		}

		if (entExaminationEntityDto.getLeftMiddleTurbinateSubjective() != null) {
			this.setLeftMiddleTurbinateSubjective(entExaminationEntityDto.getLeftMiddleTurbinateSubjective());
		}

		if (entExaminationEntityDto.getLeftMiddleTurbinateObjective() != null) {
			this.setLeftMiddleTurbinateObjective(entExaminationEntityDto.getLeftMiddleTurbinateObjective());
		}

		if (entExaminationEntityDto.getLeftMaxillarySinusSubjective() != null) {
			this.setLeftMaxillarySinusSubjective(entExaminationEntityDto.getLeftMaxillarySinusSubjective());
		}

		if (entExaminationEntityDto.getLeftMaxillarySinusObjective() != null) {
			this.setLeftMaxillarySinusObjective(entExaminationEntityDto.getLeftMaxillarySinusObjective());
		}

		if (entExaminationEntityDto.getLeftNasalCavitySubjective() != null) {
			this.setLeftNasalCavitySubjective(entExaminationEntityDto.getLeftNasalCavitySubjective());
		}

		if (entExaminationEntityDto.getLeftNasalCavityObjective() != null) {
			this.setLeftNasalCavityObjective(entExaminationEntityDto.getLeftNasalCavityObjective());
		}

		if (entExaminationEntityDto.getLeftInferiorTurbinateSubjective() != null) {
			this.setLeftInferiorTurbinateSubjective(entExaminationEntityDto.getLeftInferiorTurbinateSubjective());
		}

		if (entExaminationEntityDto.getLeftInferiorTurbinateObjective() != null) {
			this.setLeftInferiorTurbinateObjective(entExaminationEntityDto.getLeftInferiorTurbinateObjective());
		}

		if (entExaminationEntityDto.getLingualTonsilSubjective() != null) {
			this.setLingualTonsilSubjective(entExaminationEntityDto.getLingualTonsilSubjective());
		}

		if (entExaminationEntityDto.getLingualTonsilObjective() != null) {
			this.setLingualTonsilObjective(entExaminationEntityDto.getLingualTonsilObjective());
		}

		if (entExaminationEntityDto.getEpiglottisSubjective() != null) {
			this.setEpiglottisSubjective(entExaminationEntityDto.getEpiglottisSubjective());
		}

		if (entExaminationEntityDto.getEpiglottisObjective() != null) {
			this.setEpiglottisObjective(entExaminationEntityDto.getEpiglottisObjective());
		}

		if (entExaminationEntityDto.getRightVocalFoldSubjective() != null) {
			this.setRightVocalFoldSubjective(entExaminationEntityDto.getRightVocalFoldSubjective());
		}

		if (entExaminationEntityDto.getRightVocalFoldObjective() != null) {
			this.setRightVocalFoldObjective(entExaminationEntityDto.getRightVocalFoldObjective());
		}

		if (entExaminationEntityDto.getRightVentricularFoldSubjective() != null) {
			this.setRightVentricularFoldSubjective(entExaminationEntityDto.getRightVentricularFoldSubjective());
		}

		if (entExaminationEntityDto.getRightVentricularFoldObjective() != null) {
			this.setRightVentricularFoldObjective(entExaminationEntityDto.getRightVentricularFoldObjective());
		}

		if (entExaminationEntityDto.getGlottisSubjective() != null) {
			this.setGlottisSubjective(entExaminationEntityDto.getGlottisSubjective());
		}

		if (entExaminationEntityDto.getGlottisObjective() != null) {
			this.setGlottisObjective(entExaminationEntityDto.getGlottisObjective());
		}

		if (entExaminationEntityDto.getRightCuneiformCartilageSubjective() != null) {
			this.setRightCuneiformCartilageSubjective(entExaminationEntityDto.getRightCuneiformCartilageSubjective());
		}

		if (entExaminationEntityDto.getRightCuneiformCartilageObjective() != null) {
			this.setRightCuneiformCartilageObjective(entExaminationEntityDto.getRightCuneiformCartilageObjective());
		}

		if (entExaminationEntityDto.getRightCorniculateCartilageSubjective() != null) {
			this.setRightCorniculateCartilageSubjective(entExaminationEntityDto.getRightCorniculateCartilageSubjective());
		}

		if (entExaminationEntityDto.getRightCorniculateCartilageObjective() != null) {
			this.setRightCorniculateCartilageObjective(entExaminationEntityDto.getRightCorniculateCartilageObjective());
		}

		if (entExaminationEntityDto.getTracheaSubjective() != null) {
			this.setTracheaSubjective(entExaminationEntityDto.getTracheaSubjective());
		}

		if (entExaminationEntityDto.getTracheaObjective() != null) {
			this.setTracheaObjective(entExaminationEntityDto.getTracheaObjective());
		}

		if (entExaminationEntityDto.getLeftVocalFoldSubjective() != null) {
			this.setLeftVocalFoldSubjective(entExaminationEntityDto.getLeftVocalFoldSubjective());
		}

		if (entExaminationEntityDto.getLeftVocalFoldObjective() != null) {
			this.setLeftVocalFoldObjective(entExaminationEntityDto.getLeftVocalFoldObjective());
		}

		if (entExaminationEntityDto.getLeftVentricularFoldSubjective() != null) {
			this.setLeftVentricularFoldSubjective(entExaminationEntityDto.getLeftVentricularFoldSubjective());
		}

		if (entExaminationEntityDto.getLeftVentricularFoldObjective() != null) {
			this.setLeftVentricularFoldObjective(entExaminationEntityDto.getLeftVentricularFoldObjective());
		}

		if (entExaminationEntityDto.getLeftCuneiformCartilageSubjective() != null) {
			this.setLeftCuneiformCartilageSubjective(entExaminationEntityDto.getLeftCuneiformCartilageSubjective());
		}

		if (entExaminationEntityDto.getLeftCuneiformCartilageObjective() != null) {
			this.setLeftCuneiformCartilageObjective(entExaminationEntityDto.getLeftCuneiformCartilageObjective());
		}

		if (entExaminationEntityDto.getLeftCorniculateCartilageSubjective() != null) {
			this.setLeftCorniculateCartilageSubjective(entExaminationEntityDto.getLeftCorniculateCartilageSubjective());
		}

		if (entExaminationEntityDto.getLeftCorniculateCartilageObjective() != null) {
			this.setLeftCorniculateCartilageObjective(entExaminationEntityDto.getLeftCorniculateCartilageObjective());
		}

		if (entExaminationEntityDto.getSoftPalateSubjective() != null) {
			this.setSoftPalateSubjective(entExaminationEntityDto.getSoftPalateSubjective());
		}

		if (entExaminationEntityDto.getSoftPalateObjective() != null) {
			this.setSoftPalateObjective(entExaminationEntityDto.getSoftPalateObjective());
		}

		if (entExaminationEntityDto.getRightAnteriorPillarSubjective() != null) {
			this.setRightAnteriorPillarSubjective(entExaminationEntityDto.getRightAnteriorPillarSubjective());
		}

		if (entExaminationEntityDto.getRightAnteriorPillarObjective() != null) {
			this.setRightAnteriorPillarObjective(entExaminationEntityDto.getRightAnteriorPillarObjective());
		}

		if (entExaminationEntityDto.getUvulaSubjective() != null) {
			this.setUvulaSubjective(entExaminationEntityDto.getUvulaSubjective());
		}

		if (entExaminationEntityDto.getUvulaObjective() != null) {
			this.setUvulaObjective(entExaminationEntityDto.getUvulaObjective());
		}

		if (entExaminationEntityDto.getRightPosteriorPillarSubjective() != null) {
			this.setRightPosteriorPillarSubjective(entExaminationEntityDto.getRightPosteriorPillarSubjective());
		}

		if (entExaminationEntityDto.getRightPosteriorPillarObjective() != null) {
			this.setRightPosteriorPillarObjective(entExaminationEntityDto.getRightPosteriorPillarObjective());
		}

		if (entExaminationEntityDto.getRightTonsilSubjective() != null) {
			this.setRightTonsilSubjective(entExaminationEntityDto.getRightTonsilSubjective());
		}

		if (entExaminationEntityDto.getRightTonsilObjective() != null) {
			this.setRightTonsilObjective(entExaminationEntityDto.getRightTonsilObjective());
		}

		if (entExaminationEntityDto.getRightPosteriorSubjective() != null) {
			this.setRightPosteriorSubjective(entExaminationEntityDto.getRightPosteriorSubjective());
		}

		if (entExaminationEntityDto.getRightPosteriorObjective() != null) {
			this.setRightPosteriorObjective(entExaminationEntityDto.getRightPosteriorObjective());
		}

		if (entExaminationEntityDto.getUpperTongueSubjective() != null) {
			this.setUpperTongueSubjective(entExaminationEntityDto.getUpperTongueSubjective());
		}

		if (entExaminationEntityDto.getUpperTongueObjective() != null) {
			this.setUpperTongueObjective(entExaminationEntityDto.getUpperTongueObjective());
		}

		if (entExaminationEntityDto.getLeftAnteriorPillarSubjective() != null) {
			this.setLeftAnteriorPillarSubjective(entExaminationEntityDto.getLeftAnteriorPillarSubjective());
		}

		if (entExaminationEntityDto.getLeftAnteriorPillarObjective() != null) {
			this.setLeftAnteriorPillarObjective(entExaminationEntityDto.getLeftAnteriorPillarObjective());
		}

		if (entExaminationEntityDto.getLeftPosteriorPillarSubjective() != null) {
			this.setLeftPosteriorPillarSubjective(entExaminationEntityDto.getLeftPosteriorPillarSubjective());
		}

		if (entExaminationEntityDto.getLeftPosteriorPillarObjective() != null) {
			this.setLeftPosteriorPillarObjective(entExaminationEntityDto.getLeftPosteriorPillarObjective());
		}

		if (entExaminationEntityDto.getLeftTonsilSubjective() != null) {
			this.setLeftTonsilSubjective(entExaminationEntityDto.getLeftTonsilSubjective());
		}

		if (entExaminationEntityDto.getLeftTonsilObjective() != null) {
			this.setLeftTonsilObjective(entExaminationEntityDto.getLeftTonsilObjective());
		}

		if (entExaminationEntityDto.getLeftPosteriorWallSubjective() != null) {
			this.setLeftPosteriorWallSubjective(entExaminationEntityDto.getLeftPosteriorWallSubjective());
		}

		if (entExaminationEntityDto.getLeftPosteriorWallObjective() != null) {
			this.setLeftPosteriorWallObjective(entExaminationEntityDto.getLeftPosteriorWallObjective());
		}

		if (entExaminationEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(entExaminationEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Right External Ear Subjective here] off begin
	@CsvBindByName(column = "RIGHT_EXTERNAL_EAR_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_external_ear_subjective")
	@Schema(description = "The Right External Ear Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right External Ear Subjective here] end
	private String rightExternalEarSubjective;

	// % protected region % [Modify attribute annotation for Right External Ear Objective here] off begin
	@CsvBindByName(column = "RIGHT_EXTERNAL_EAR_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_external_ear_objective")
	@Schema(description = "The Right External Ear Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right External Ear Objective here] end
	private String rightExternalEarObjective;

	// % protected region % [Modify attribute annotation for Right Concha Subjective here] off begin
	@CsvBindByName(column = "RIGHT_CONCHA_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_concha_subjective")
	@Schema(description = "The Right Concha Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Concha Subjective here] end
	private String rightConchaSubjective;

	// % protected region % [Modify attribute annotation for Right Concha Objective here] off begin
	@CsvBindByName(column = "RIGHT_CONCHA_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_concha_objective")
	@Schema(description = "The Right Concha Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Concha Objective here] end
	private String rightConchaObjective;

	// % protected region % [Modify attribute annotation for Right Earlobe Subjective here] off begin
	@CsvBindByName(column = "RIGHT_EARLOBE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_earlobe_subjective")
	@Schema(description = "The Right Earlobe Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Earlobe Subjective here] end
	private String rightEarlobeSubjective;

	// % protected region % [Modify attribute annotation for Right Earlobe Objective here] off begin
	@CsvBindByName(column = "RIGHT_EARLOBE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_earlobe_objective")
	@Schema(description = "The Right Earlobe Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Earlobe Objective here] end
	private String rightEarlobeObjective;

	// % protected region % [Modify attribute annotation for Right Ear Canal Subjective here] off begin
	@CsvBindByName(column = "RIGHT_EAR_CANAL_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_ear_canal_subjective")
	@Schema(description = "The Right Ear Canal Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Ear Canal Subjective here] end
	private String rightEarCanalSubjective;

	// % protected region % [Modify attribute annotation for Right Ear Canal Objective here] off begin
	@CsvBindByName(column = "RIGHT_EAR_CANAL_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_ear_canal_objective")
	@Schema(description = "The Right Ear Canal Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Ear Canal Objective here] end
	private String rightEarCanalObjective;

	// % protected region % [Modify attribute annotation for Right Eardrum Subjective here] off begin
	@CsvBindByName(column = "RIGHT_EARDRUM_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_eardrum_subjective")
	@Schema(description = "The Right Eardrum Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Eardrum Subjective here] end
	private String rightEardrumSubjective;

	// % protected region % [Modify attribute annotation for Right Eardrum Objective here] off begin
	@CsvBindByName(column = "RIGHT_EARDRUM_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_eardrum_objective")
	@Schema(description = "The Right Eardrum Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Eardrum Objective here] end
	private String rightEardrumObjective;

	// % protected region % [Modify attribute annotation for Left External Ear Subjective here] off begin
	@CsvBindByName(column = "LEFT_EXTERNAL_EAR_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_external_ear_subjective")
	@Schema(description = "The Left External Ear Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left External Ear Subjective here] end
	private String leftExternalEarSubjective;

	// % protected region % [Modify attribute annotation for Left External Ear Objective here] off begin
	@CsvBindByName(column = "LEFT_EXTERNAL_EAR_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_external_ear_objective")
	@Schema(description = "The Left External Ear Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left External Ear Objective here] end
	private String leftExternalEarObjective;

	// % protected region % [Modify attribute annotation for Left Concha Subjective here] off begin
	@CsvBindByName(column = "LEFT_CONCHA_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_concha_subjective")
	@Schema(description = "The Left Concha Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Concha Subjective here] end
	private String leftConchaSubjective;

	// % protected region % [Modify attribute annotation for Left Concha Objective here] off begin
	@CsvBindByName(column = "LEFT_CONCHA_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_concha_objective")
	@Schema(description = "The Left Concha Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Concha Objective here] end
	private String leftConchaObjective;

	// % protected region % [Modify attribute annotation for Left Earlobe Subjective here] off begin
	@CsvBindByName(column = "LEFT_EARLOBE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_earlobe_subjective")
	@Schema(description = "The Left Earlobe Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Earlobe Subjective here] end
	private String leftEarlobeSubjective;

	// % protected region % [Modify attribute annotation for Left Earlobe Objective here] off begin
	@CsvBindByName(column = "LEFT_EARLOBE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_earlobe_objective")
	@Schema(description = "The Left Earlobe Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Earlobe Objective here] end
	private String leftEarlobeObjective;

	// % protected region % [Modify attribute annotation for Left Ear Canal Subjective here] off begin
	@CsvBindByName(column = "LEFT_EAR_CANAL_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_ear_canal_subjective")
	@Schema(description = "The Left Ear Canal Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Ear Canal Subjective here] end
	private String leftEarCanalSubjective;

	// % protected region % [Modify attribute annotation for Left Ear Canal Objective here] off begin
	@CsvBindByName(column = "LEFT_EAR_CANAL_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_ear_canal_objective")
	@Schema(description = "The Left Ear Canal Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Ear Canal Objective here] end
	private String leftEarCanalObjective;

	// % protected region % [Modify attribute annotation for Left Eardrum Subjective here] off begin
	@CsvBindByName(column = "LEFT_EARDRUM_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_eardrum_subjective")
	@Schema(description = "The Left Eardrum Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Eardrum Subjective here] end
	private String leftEardrumSubjective;

	// % protected region % [Modify attribute annotation for Left Eardrum Objective here] off begin
	@CsvBindByName(column = "LEFT_EARDRUM_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_eardrum_objective")
	@Schema(description = "The Left Eardrum Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Eardrum Objective here] end
	private String leftEardrumObjective;

	// % protected region % [Modify attribute annotation for Nasal Bone Subjective here] off begin
	@CsvBindByName(column = "NASAL_BONE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "nasal_bone_subjective")
	@Schema(description = "The Nasal Bone Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nasal Bone Subjective here] end
	private String nasalBoneSubjective;

	// % protected region % [Modify attribute annotation for Nasal Bone Objective here] off begin
	@CsvBindByName(column = "NASAL_BONE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "nasal_bone_objective")
	@Schema(description = "The Nasal Bone Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nasal Bone Objective here] end
	private String nasalBoneObjective;

	// % protected region % [Modify attribute annotation for Right Frontal Sinus Subjective here] off begin
	@CsvBindByName(column = "RIGHT_FRONTAL_SINUS_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_frontal_sinus_subjective")
	@Schema(description = "The Right Frontal Sinus Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Frontal Sinus Subjective here] end
	private String rightFrontalSinusSubjective;

	// % protected region % [Modify attribute annotation for Right Frontal Sinus Objective here] off begin
	@CsvBindByName(column = "RIGHT_FRONTAL_SINUS_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_frontal_sinus_objective")
	@Schema(description = "The Right Frontal Sinus Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Frontal Sinus Objective here] end
	private String rightFrontalSinusObjective;

	// % protected region % [Modify attribute annotation for Right Ethmoid Sinus Subjective here] off begin
	@CsvBindByName(column = "RIGHT_ETHMOID_SINUS_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_ethmoid_sinus_subjective")
	@Schema(description = "The Right Ethmoid Sinus Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Ethmoid Sinus Subjective here] end
	private String rightEthmoidSinusSubjective;

	// % protected region % [Modify attribute annotation for Right Ethmoid Sinus Objective here] off begin
	@CsvBindByName(column = "RIGHT_ETHMOID_SINUS_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_ethmoid_sinus_objective")
	@Schema(description = "The Right Ethmoid Sinus Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Ethmoid Sinus Objective here] end
	private String rightEthmoidSinusObjective;

	// % protected region % [Modify attribute annotation for Right Superior Turbinate Subjective here] off begin
	@CsvBindByName(column = "RIGHT_SUPERIOR_TURBINATE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_superior_turbinate_subjective")
	@Schema(description = "The Right Superior Turbinate Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Superior Turbinate Subjective here] end
	private String rightSuperiorTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Right Superior Turbinate Objective here] off begin
	@CsvBindByName(column = "RIGHT_SUPERIOR_TURBINATE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_superior_turbinate_objective")
	@Schema(description = "The Right Superior Turbinate Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Superior Turbinate Objective here] end
	private String rightSuperiorTurbinateObjective;

	// % protected region % [Modify attribute annotation for Right Middle Turbinate Subjective here] off begin
	@CsvBindByName(column = "RIGHT_MIDDLE_TURBINATE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_middle_turbinate_subjective")
	@Schema(description = "The Right Middle Turbinate Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Middle Turbinate Subjective here] end
	private String rightMiddleTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Right Middle Turbinate Objective here] off begin
	@CsvBindByName(column = "RIGHT_MIDDLE_TURBINATE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_middle_turbinate_objective")
	@Schema(description = "The Right Middle Turbinate Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Middle Turbinate Objective here] end
	private String rightMiddleTurbinateObjective;

	// % protected region % [Modify attribute annotation for Right Maxillary Sinus Subjective here] off begin
	@CsvBindByName(column = "RIGHT_MAXILLARY_SINUS_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_maxillary_sinus_subjective")
	@Schema(description = "The Right Maxillary Sinus Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Maxillary Sinus Subjective here] end
	private String rightMaxillarySinusSubjective;

	// % protected region % [Modify attribute annotation for Right Maxillary Sinus Objective here] off begin
	@CsvBindByName(column = "RIGHT_MAXILLARY_SINUS_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_maxillary_sinus_objective")
	@Schema(description = "The Right Maxillary Sinus Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Maxillary Sinus Objective here] end
	private String rightMaxillarySinusObjective;

	// % protected region % [Modify attribute annotation for Right Nasal Cavity Subjective here] off begin
	@CsvBindByName(column = "RIGHT_NASAL_CAVITY_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_nasal_cavity_subjective")
	@Schema(description = "The Right Nasal Cavity Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Nasal Cavity Subjective here] end
	private String rightNasalCavitySubjective;

	// % protected region % [Modify attribute annotation for Right Nasal Cavity Objective here] off begin
	@CsvBindByName(column = "RIGHT_NASAL_CAVITY_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_nasal_cavity_objective")
	@Schema(description = "The Right Nasal Cavity Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Nasal Cavity Objective here] end
	private String rightNasalCavityObjective;

	// % protected region % [Modify attribute annotation for Right Inferior Turbinate Subjective here] off begin
	@CsvBindByName(column = "RIGHT_INFERIOR_TURBINATE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_inferior_turbinate_subjective")
	@Schema(description = "The Right Inferior Turbinate Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Inferior Turbinate Subjective here] end
	private String rightInferiorTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Right Inferior Turbinate Objective here] off begin
	@CsvBindByName(column = "RIGHT_INFERIOR_TURBINATE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_inferior_turbinate_objective")
	@Schema(description = "The Right Inferior Turbinate Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Inferior Turbinate Objective here] end
	private String rightInferiorTurbinateObjective;

	// % protected region % [Modify attribute annotation for Left Frontal Sinus Subjective here] off begin
	@CsvBindByName(column = "LEFT_FRONTAL_SINUS_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_frontal_sinus_subjective")
	@Schema(description = "The Left Frontal Sinus Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Frontal Sinus Subjective here] end
	private String leftFrontalSinusSubjective;

	// % protected region % [Modify attribute annotation for Left Frontal Sinus Objective here] off begin
	@CsvBindByName(column = "LEFT_FRONTAL_SINUS_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_frontal_sinus_objective")
	@Schema(description = "The Left Frontal Sinus Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Frontal Sinus Objective here] end
	private String leftFrontalSinusObjective;

	// % protected region % [Modify attribute annotation for Left Ethmoid Sinus Subjective here] off begin
	@CsvBindByName(column = "LEFT_ETHMOID_SINUS_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_ethmoid_sinus_subjective")
	@Schema(description = "The Left Ethmoid Sinus Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Ethmoid Sinus Subjective here] end
	private String leftEthmoidSinusSubjective;

	// % protected region % [Modify attribute annotation for Left Ethmoid Sinus Objective here] off begin
	@CsvBindByName(column = "LEFT_ETHMOID_SINUS_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_ethmoid_sinus_objective")
	@Schema(description = "The Left Ethmoid Sinus Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Ethmoid Sinus Objective here] end
	private String leftEthmoidSinusObjective;

	// % protected region % [Modify attribute annotation for Left Superior Turbinate Subjective here] off begin
	@CsvBindByName(column = "LEFT_SUPERIOR_TURBINATE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_superior_turbinate_subjective")
	@Schema(description = "The Left Superior Turbinate Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Superior Turbinate Subjective here] end
	private String leftSuperiorTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Left Superior Turbinate Objective here] off begin
	@CsvBindByName(column = "LEFT_SUPERIOR_TURBINATE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_superior_turbinate_objective")
	@Schema(description = "The Left Superior Turbinate Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Superior Turbinate Objective here] end
	private String leftSuperiorTurbinateObjective;

	// % protected region % [Modify attribute annotation for Left Middle Turbinate Subjective here] off begin
	@CsvBindByName(column = "LEFT_MIDDLE_TURBINATE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_middle_turbinate_subjective")
	@Schema(description = "The Left Middle Turbinate Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Middle Turbinate Subjective here] end
	private String leftMiddleTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Left Middle Turbinate Objective here] off begin
	@CsvBindByName(column = "LEFT_MIDDLE_TURBINATE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_middle_turbinate_objective")
	@Schema(description = "The Left Middle Turbinate Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Middle Turbinate Objective here] end
	private String leftMiddleTurbinateObjective;

	// % protected region % [Modify attribute annotation for Left Maxillary Sinus Subjective here] off begin
	@CsvBindByName(column = "LEFT_MAXILLARY_SINUS_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_maxillary_sinus_subjective")
	@Schema(description = "The Left Maxillary Sinus Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Maxillary Sinus Subjective here] end
	private String leftMaxillarySinusSubjective;

	// % protected region % [Modify attribute annotation for Left Maxillary Sinus Objective here] off begin
	@CsvBindByName(column = "LEFT_MAXILLARY_SINUS_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_maxillary_sinus_objective")
	@Schema(description = "The Left Maxillary Sinus Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Maxillary Sinus Objective here] end
	private String leftMaxillarySinusObjective;

	// % protected region % [Modify attribute annotation for Left Nasal Cavity Subjective here] off begin
	@CsvBindByName(column = "LEFT_NASAL_CAVITY_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_nasal_cavity_subjective")
	@Schema(description = "The Left Nasal Cavity Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Nasal Cavity Subjective here] end
	private String leftNasalCavitySubjective;

	// % protected region % [Modify attribute annotation for Left Nasal Cavity Objective here] off begin
	@CsvBindByName(column = "LEFT_NASAL_CAVITY_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_nasal_cavity_objective")
	@Schema(description = "The Left Nasal Cavity Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Nasal Cavity Objective here] end
	private String leftNasalCavityObjective;

	// % protected region % [Modify attribute annotation for Left Inferior Turbinate Subjective here] off begin
	@CsvBindByName(column = "LEFT_INFERIOR_TURBINATE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_inferior_turbinate_subjective")
	@Schema(description = "The Left Inferior Turbinate Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Inferior Turbinate Subjective here] end
	private String leftInferiorTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Left Inferior Turbinate Objective here] off begin
	@CsvBindByName(column = "LEFT_INFERIOR_TURBINATE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_inferior_turbinate_objective")
	@Schema(description = "The Left Inferior Turbinate Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Inferior Turbinate Objective here] end
	private String leftInferiorTurbinateObjective;

	// % protected region % [Modify attribute annotation for Lingual Tonsil Subjective here] off begin
	@CsvBindByName(column = "LINGUAL_TONSIL_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "lingual_tonsil_subjective")
	@Schema(description = "The Lingual Tonsil Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lingual Tonsil Subjective here] end
	private String lingualTonsilSubjective;

	// % protected region % [Modify attribute annotation for Lingual Tonsil Objective here] off begin
	@CsvBindByName(column = "LINGUAL_TONSIL_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "lingual_tonsil_objective")
	@Schema(description = "The Lingual Tonsil Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lingual Tonsil Objective here] end
	private String lingualTonsilObjective;

	// % protected region % [Modify attribute annotation for Epiglottis Subjective here] off begin
	@CsvBindByName(column = "EPIGLOTTIS_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "epiglottis_subjective")
	@Schema(description = "The Epiglottis Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Epiglottis Subjective here] end
	private String epiglottisSubjective;

	// % protected region % [Modify attribute annotation for Epiglottis Objective here] off begin
	@CsvBindByName(column = "EPIGLOTTIS_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "epiglottis_objective")
	@Schema(description = "The Epiglottis Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Epiglottis Objective here] end
	private String epiglottisObjective;

	// % protected region % [Modify attribute annotation for Right Vocal Fold Subjective here] off begin
	@CsvBindByName(column = "RIGHT_VOCAL_FOLD_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_vocal_fold_subjective")
	@Schema(description = "The Right Vocal Fold Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Vocal Fold Subjective here] end
	private String rightVocalFoldSubjective;

	// % protected region % [Modify attribute annotation for Right Vocal Fold Objective here] off begin
	@CsvBindByName(column = "RIGHT_VOCAL_FOLD_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_vocal_fold_objective")
	@Schema(description = "The Right Vocal Fold Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Vocal Fold Objective here] end
	private String rightVocalFoldObjective;

	// % protected region % [Modify attribute annotation for Right Ventricular Fold Subjective here] off begin
	@CsvBindByName(column = "RIGHT_VENTRICULAR_FOLD_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_ventricular_fold_subjective")
	@Schema(description = "The Right Ventricular Fold Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Ventricular Fold Subjective here] end
	private String rightVentricularFoldSubjective;

	// % protected region % [Modify attribute annotation for Right Ventricular Fold Objective here] off begin
	@CsvBindByName(column = "RIGHT_VENTRICULAR_FOLD_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_ventricular_fold_objective")
	@Schema(description = "The Right Ventricular Fold Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Ventricular Fold Objective here] end
	private String rightVentricularFoldObjective;

	// % protected region % [Modify attribute annotation for Glottis Subjective here] off begin
	@CsvBindByName(column = "GLOTTIS_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "glottis_subjective")
	@Schema(description = "The Glottis Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Glottis Subjective here] end
	private String glottisSubjective;

	// % protected region % [Modify attribute annotation for Glottis Objective here] off begin
	@CsvBindByName(column = "GLOTTIS_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "glottis_objective")
	@Schema(description = "The Glottis Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Glottis Objective here] end
	private String glottisObjective;

	// % protected region % [Modify attribute annotation for Right Cuneiform Cartilage Subjective here] off begin
	@CsvBindByName(column = "RIGHT_CUNEIFORM_CARTILAGE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_cuneiform_cartilage_subjective")
	@Schema(description = "The Right Cuneiform Cartilage Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Cuneiform Cartilage Subjective here] end
	private String rightCuneiformCartilageSubjective;

	// % protected region % [Modify attribute annotation for Right Cuneiform Cartilage Objective here] off begin
	@CsvBindByName(column = "RIGHT_CUNEIFORM_CARTILAGE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_cuneiform_cartilage_objective")
	@Schema(description = "The Right Cuneiform Cartilage Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Cuneiform Cartilage Objective here] end
	private String rightCuneiformCartilageObjective;

	// % protected region % [Modify attribute annotation for Right Corniculate Cartilage Subjective here] off begin
	@CsvBindByName(column = "RIGHT_CORNICULATE_CARTILAGE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_corniculate_cartilage_subjective")
	@Schema(description = "The Right Corniculate Cartilage Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Corniculate Cartilage Subjective here] end
	private String rightCorniculateCartilageSubjective;

	// % protected region % [Modify attribute annotation for Right Corniculate Cartilage Objective here] off begin
	@CsvBindByName(column = "RIGHT_CORNICULATE_CARTILAGE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_corniculate_cartilage_objective")
	@Schema(description = "The Right Corniculate Cartilage Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Corniculate Cartilage Objective here] end
	private String rightCorniculateCartilageObjective;

	// % protected region % [Modify attribute annotation for Trachea Subjective here] off begin
	@CsvBindByName(column = "TRACHEA_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "trachea_subjective")
	@Schema(description = "The Trachea Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Trachea Subjective here] end
	private String tracheaSubjective;

	// % protected region % [Modify attribute annotation for Trachea Objective here] off begin
	@CsvBindByName(column = "TRACHEA_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "trachea_objective")
	@Schema(description = "The Trachea Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Trachea Objective here] end
	private String tracheaObjective;

	// % protected region % [Modify attribute annotation for Left Vocal Fold Subjective here] off begin
	@CsvBindByName(column = "LEFT_VOCAL_FOLD_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_vocal_fold_subjective")
	@Schema(description = "The Left Vocal Fold Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Vocal Fold Subjective here] end
	private String leftVocalFoldSubjective;

	// % protected region % [Modify attribute annotation for Left Vocal Fold Objective here] off begin
	@CsvBindByName(column = "LEFT_VOCAL_FOLD_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_vocal_fold_objective")
	@Schema(description = "The Left Vocal Fold Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Vocal Fold Objective here] end
	private String leftVocalFoldObjective;

	// % protected region % [Modify attribute annotation for Left Ventricular Fold Subjective here] off begin
	@CsvBindByName(column = "LEFT_VENTRICULAR_FOLD_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_ventricular_fold_subjective")
	@Schema(description = "The Left Ventricular Fold Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Ventricular Fold Subjective here] end
	private String leftVentricularFoldSubjective;

	// % protected region % [Modify attribute annotation for Left Ventricular Fold Objective here] off begin
	@CsvBindByName(column = "LEFT_VENTRICULAR_FOLD_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_ventricular_fold_objective")
	@Schema(description = "The Left Ventricular Fold Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Ventricular Fold Objective here] end
	private String leftVentricularFoldObjective;

	// % protected region % [Modify attribute annotation for Left Cuneiform Cartilage Subjective here] off begin
	@CsvBindByName(column = "LEFT_CUNEIFORM_CARTILAGE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_cuneiform_cartilage_subjective")
	@Schema(description = "The Left Cuneiform Cartilage Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Cuneiform Cartilage Subjective here] end
	private String leftCuneiformCartilageSubjective;

	// % protected region % [Modify attribute annotation for Left Cuneiform Cartilage Objective here] off begin
	@CsvBindByName(column = "LEFT_CUNEIFORM_CARTILAGE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_cuneiform_cartilage_objective")
	@Schema(description = "The Left Cuneiform Cartilage Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Cuneiform Cartilage Objective here] end
	private String leftCuneiformCartilageObjective;

	// % protected region % [Modify attribute annotation for Left Corniculate Cartilage Subjective here] off begin
	@CsvBindByName(column = "LEFT_CORNICULATE_CARTILAGE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_corniculate_cartilage_subjective")
	@Schema(description = "The Left Corniculate Cartilage Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Corniculate Cartilage Subjective here] end
	private String leftCorniculateCartilageSubjective;

	// % protected region % [Modify attribute annotation for Left Corniculate Cartilage Objective here] off begin
	@CsvBindByName(column = "LEFT_CORNICULATE_CARTILAGE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_corniculate_cartilage_objective")
	@Schema(description = "The Left Corniculate Cartilage Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Corniculate Cartilage Objective here] end
	private String leftCorniculateCartilageObjective;

	// % protected region % [Modify attribute annotation for Soft Palate Subjective here] off begin
	@CsvBindByName(column = "SOFT_PALATE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "soft_palate_subjective")
	@Schema(description = "The Soft Palate Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Soft Palate Subjective here] end
	private String softPalateSubjective;

	// % protected region % [Modify attribute annotation for Soft Palate Objective here] off begin
	@CsvBindByName(column = "SOFT_PALATE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "soft_palate_objective")
	@Schema(description = "The Soft Palate Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Soft Palate Objective here] end
	private String softPalateObjective;

	// % protected region % [Modify attribute annotation for Right Anterior Pillar Subjective here] off begin
	@CsvBindByName(column = "RIGHT_ANTERIOR_PILLAR_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_anterior_pillar_subjective")
	@Schema(description = "The Right Anterior Pillar Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Anterior Pillar Subjective here] end
	private String rightAnteriorPillarSubjective;

	// % protected region % [Modify attribute annotation for Right Anterior Pillar Objective here] off begin
	@CsvBindByName(column = "RIGHT_ANTERIOR_PILLAR_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_anterior_pillar_objective")
	@Schema(description = "The Right Anterior Pillar Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Anterior Pillar Objective here] end
	private String rightAnteriorPillarObjective;

	// % protected region % [Modify attribute annotation for Uvula Subjective here] off begin
	@CsvBindByName(column = "UVULA_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "uvula_subjective")
	@Schema(description = "The Uvula Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Uvula Subjective here] end
	private String uvulaSubjective;

	// % protected region % [Modify attribute annotation for Uvula Objective here] off begin
	@CsvBindByName(column = "UVULA_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "uvula_objective")
	@Schema(description = "The Uvula Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Uvula Objective here] end
	private String uvulaObjective;

	// % protected region % [Modify attribute annotation for Right Posterior Pillar Subjective here] off begin
	@CsvBindByName(column = "RIGHT_POSTERIOR_PILLAR_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_posterior_pillar_subjective")
	@Schema(description = "The Right Posterior Pillar Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Posterior Pillar Subjective here] end
	private String rightPosteriorPillarSubjective;

	// % protected region % [Modify attribute annotation for Right Posterior Pillar Objective here] off begin
	@CsvBindByName(column = "RIGHT_POSTERIOR_PILLAR_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_posterior_pillar_objective")
	@Schema(description = "The Right Posterior Pillar Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Posterior Pillar Objective here] end
	private String rightPosteriorPillarObjective;

	// % protected region % [Modify attribute annotation for Right Tonsil Subjective here] off begin
	@CsvBindByName(column = "RIGHT_TONSIL_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_tonsil_subjective")
	@Schema(description = "The Right Tonsil Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Tonsil Subjective here] end
	private String rightTonsilSubjective;

	// % protected region % [Modify attribute annotation for Right Tonsil Objective here] off begin
	@CsvBindByName(column = "RIGHT_TONSIL_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_tonsil_objective")
	@Schema(description = "The Right Tonsil Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Tonsil Objective here] end
	private String rightTonsilObjective;

	// % protected region % [Modify attribute annotation for Right Posterior Subjective here] off begin
	@CsvBindByName(column = "RIGHT_POSTERIOR_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_posterior_subjective")
	@Schema(description = "The Right Posterior Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Posterior Subjective here] end
	private String rightPosteriorSubjective;

	// % protected region % [Modify attribute annotation for Right Posterior Objective here] off begin
	@CsvBindByName(column = "RIGHT_POSTERIOR_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_posterior_objective")
	@Schema(description = "The Right Posterior Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Posterior Objective here] end
	private String rightPosteriorObjective;

	// % protected region % [Modify attribute annotation for Upper Tongue Subjective here] off begin
	@CsvBindByName(column = "UPPER_TONGUE_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "upper_tongue_subjective")
	@Schema(description = "The Upper Tongue Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Upper Tongue Subjective here] end
	private String upperTongueSubjective;

	// % protected region % [Modify attribute annotation for Upper Tongue Objective here] off begin
	@CsvBindByName(column = "UPPER_TONGUE_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "upper_tongue_objective")
	@Schema(description = "The Upper Tongue Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Upper Tongue Objective here] end
	private String upperTongueObjective;

	// % protected region % [Modify attribute annotation for Left Anterior Pillar Subjective here] off begin
	@CsvBindByName(column = "LEFT_ANTERIOR_PILLAR_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_anterior_pillar_subjective")
	@Schema(description = "The Left Anterior Pillar Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Anterior Pillar Subjective here] end
	private String leftAnteriorPillarSubjective;

	// % protected region % [Modify attribute annotation for Left Anterior Pillar Objective here] off begin
	@CsvBindByName(column = "LEFT_ANTERIOR_PILLAR_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_anterior_pillar_objective")
	@Schema(description = "The Left Anterior Pillar Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Anterior Pillar Objective here] end
	private String leftAnteriorPillarObjective;

	// % protected region % [Modify attribute annotation for Left Posterior Pillar Subjective here] off begin
	@CsvBindByName(column = "LEFT_POSTERIOR_PILLAR_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_posterior_pillar_subjective")
	@Schema(description = "The Left Posterior Pillar Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Posterior Pillar Subjective here] end
	private String leftPosteriorPillarSubjective;

	// % protected region % [Modify attribute annotation for Left Posterior Pillar Objective here] off begin
	@CsvBindByName(column = "LEFT_POSTERIOR_PILLAR_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_posterior_pillar_objective")
	@Schema(description = "The Left Posterior Pillar Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Posterior Pillar Objective here] end
	private String leftPosteriorPillarObjective;

	// % protected region % [Modify attribute annotation for Left Tonsil Subjective here] off begin
	@CsvBindByName(column = "LEFT_TONSIL_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_tonsil_subjective")
	@Schema(description = "The Left Tonsil Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Tonsil Subjective here] end
	private String leftTonsilSubjective;

	// % protected region % [Modify attribute annotation for Left Tonsil Objective here] off begin
	@CsvBindByName(column = "LEFT_TONSIL_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_tonsil_objective")
	@Schema(description = "The Left Tonsil Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Tonsil Objective here] end
	private String leftTonsilObjective;

	// % protected region % [Modify attribute annotation for Left Posterior Wall Subjective here] off begin
	@CsvBindByName(column = "LEFT_POSTERIOR_WALL_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_posterior_wall_subjective")
	@Schema(description = "The Left Posterior Wall Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Posterior Wall Subjective here] end
	private String leftPosteriorWallSubjective;

	// % protected region % [Modify attribute annotation for Left Posterior Wall Objective here] off begin
	@CsvBindByName(column = "LEFT_POSTERIOR_WALL_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_posterior_wall_objective")
	@Schema(description = "The Left Posterior Wall Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Posterior Wall Objective here] end
	private String leftPosteriorWallObjective;

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

	// % protected region % [Update the annotation for Medical Examination Record here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record here] end
	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Update the annotation for medicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordId here] end
	private UUID medicalExaminationRecordId;

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
			this.medicalExaminationRecord.unsetEntExamination(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setEntExamination(this, false);
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
			this.medicalExaminationRecord.unsetEntExamination();
		}
		this.medicalExaminationRecord = null;
	}

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "RIGHT_EXTERNAL_EAR_SUBJECTIVE,RIGHT_EXTERNAL_EAR_OBJECTIVE,RIGHT_CONCHA_SUBJECTIVE,RIGHT_CONCHA_OBJECTIVE,RIGHT_EARLOBE_SUBJECTIVE,RIGHT_EARLOBE_OBJECTIVE,RIGHT_EAR_CANAL_SUBJECTIVE,RIGHT_EAR_CANAL_OBJECTIVE,RIGHT_EARDRUM_SUBJECTIVE,RIGHT_EARDRUM_OBJECTIVE,LEFT_EXTERNAL_EAR_SUBJECTIVE,LEFT_EXTERNAL_EAR_OBJECTIVE,LEFT_CONCHA_SUBJECTIVE,LEFT_CONCHA_OBJECTIVE,LEFT_EARLOBE_SUBJECTIVE,LEFT_EARLOBE_OBJECTIVE,LEFT_EAR_CANAL_SUBJECTIVE,LEFT_EAR_CANAL_OBJECTIVE,LEFT_EARDRUM_SUBJECTIVE,LEFT_EARDRUM_OBJECTIVE,NASAL_BONE_SUBJECTIVE,NASAL_BONE_OBJECTIVE,RIGHT_FRONTAL_SINUS_SUBJECTIVE,RIGHT_FRONTAL_SINUS_OBJECTIVE,RIGHT_ETHMOID_SINUS_SUBJECTIVE,RIGHT_ETHMOID_SINUS_OBJECTIVE,RIGHT_SUPERIOR_TURBINATE_SUBJECTIVE,RIGHT_SUPERIOR_TURBINATE_OBJECTIVE,RIGHT_MIDDLE_TURBINATE_SUBJECTIVE,RIGHT_MIDDLE_TURBINATE_OBJECTIVE,RIGHT_MAXILLARY_SINUS_SUBJECTIVE,RIGHT_MAXILLARY_SINUS_OBJECTIVE,RIGHT_NASAL_CAVITY_SUBJECTIVE,RIGHT_NASAL_CAVITY_OBJECTIVE,RIGHT_INFERIOR_TURBINATE_SUBJECTIVE,RIGHT_INFERIOR_TURBINATE_OBJECTIVE,LEFT_FRONTAL_SINUS_SUBJECTIVE,LEFT_FRONTAL_SINUS_OBJECTIVE,LEFT_ETHMOID_SINUS_SUBJECTIVE,LEFT_ETHMOID_SINUS_OBJECTIVE,LEFT_SUPERIOR_TURBINATE_SUBJECTIVE,LEFT_SUPERIOR_TURBINATE_OBJECTIVE,LEFT_MIDDLE_TURBINATE_SUBJECTIVE,LEFT_MIDDLE_TURBINATE_OBJECTIVE,LEFT_MAXILLARY_SINUS_SUBJECTIVE,LEFT_MAXILLARY_SINUS_OBJECTIVE,LEFT_NASAL_CAVITY_SUBJECTIVE,LEFT_NASAL_CAVITY_OBJECTIVE,LEFT_INFERIOR_TURBINATE_SUBJECTIVE,LEFT_INFERIOR_TURBINATE_OBJECTIVE,LINGUAL_TONSIL_SUBJECTIVE,LINGUAL_TONSIL_OBJECTIVE,EPIGLOTTIS_SUBJECTIVE,EPIGLOTTIS_OBJECTIVE,RIGHT_VOCAL_FOLD_SUBJECTIVE,RIGHT_VOCAL_FOLD_OBJECTIVE,RIGHT_VENTRICULAR_FOLD_SUBJECTIVE,RIGHT_VENTRICULAR_FOLD_OBJECTIVE,GLOTTIS_SUBJECTIVE,GLOTTIS_OBJECTIVE,RIGHT_CUNEIFORM_CARTILAGE_SUBJECTIVE,RIGHT_CUNEIFORM_CARTILAGE_OBJECTIVE,RIGHT_CORNICULATE_CARTILAGE_SUBJECTIVE,RIGHT_CORNICULATE_CARTILAGE_OBJECTIVE,TRACHEA_SUBJECTIVE,TRACHEA_OBJECTIVE,LEFT_VOCAL_FOLD_SUBJECTIVE,LEFT_VOCAL_FOLD_OBJECTIVE,LEFT_VENTRICULAR_FOLD_SUBJECTIVE,LEFT_VENTRICULAR_FOLD_OBJECTIVE,LEFT_CUNEIFORM_CARTILAGE_SUBJECTIVE,LEFT_CUNEIFORM_CARTILAGE_OBJECTIVE,LEFT_CORNICULATE_CARTILAGE_SUBJECTIVE,LEFT_CORNICULATE_CARTILAGE_OBJECTIVE,SOFT_PALATE_SUBJECTIVE,SOFT_PALATE_OBJECTIVE,RIGHT_ANTERIOR_PILLAR_SUBJECTIVE,RIGHT_ANTERIOR_PILLAR_OBJECTIVE,UVULA_SUBJECTIVE,UVULA_OBJECTIVE,RIGHT_POSTERIOR_PILLAR_SUBJECTIVE,RIGHT_POSTERIOR_PILLAR_OBJECTIVE,RIGHT_TONSIL_SUBJECTIVE,RIGHT_TONSIL_OBJECTIVE,RIGHT_POSTERIOR_SUBJECTIVE,RIGHT_POSTERIOR_OBJECTIVE,UPPER_TONGUE_SUBJECTIVE,UPPER_TONGUE_OBJECTIVE,LEFT_ANTERIOR_PILLAR_SUBJECTIVE,LEFT_ANTERIOR_PILLAR_OBJECTIVE,LEFT_POSTERIOR_PILLAR_SUBJECTIVE,LEFT_POSTERIOR_PILLAR_OBJECTIVE,LEFT_TONSIL_SUBJECTIVE,LEFT_TONSIL_OBJECTIVE,LEFT_POSTERIOR_WALL_SUBJECTIVE,LEFT_POSTERIOR_WALL_OBJECTIVE,MEDICAL_EXAMINATION_RECORD_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object entExamination) {
		if (this == entExamination) {
			return true;
		}
		if (entExamination == null || this.getClass() != entExamination.getClass()) {
			return false;
		}
		if (!super.equals(entExamination)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		EntExaminationEntity that = (EntExaminationEntity) entExamination;
		return
			Objects.equals(this.rightExternalEarSubjective, that.rightExternalEarSubjective) &&
			Objects.equals(this.rightExternalEarObjective, that.rightExternalEarObjective) &&
			Objects.equals(this.rightConchaSubjective, that.rightConchaSubjective) &&
			Objects.equals(this.rightConchaObjective, that.rightConchaObjective) &&
			Objects.equals(this.rightEarlobeSubjective, that.rightEarlobeSubjective) &&
			Objects.equals(this.rightEarlobeObjective, that.rightEarlobeObjective) &&
			Objects.equals(this.rightEarCanalSubjective, that.rightEarCanalSubjective) &&
			Objects.equals(this.rightEarCanalObjective, that.rightEarCanalObjective) &&
			Objects.equals(this.rightEardrumSubjective, that.rightEardrumSubjective) &&
			Objects.equals(this.rightEardrumObjective, that.rightEardrumObjective) &&
			Objects.equals(this.leftExternalEarSubjective, that.leftExternalEarSubjective) &&
			Objects.equals(this.leftExternalEarObjective, that.leftExternalEarObjective) &&
			Objects.equals(this.leftConchaSubjective, that.leftConchaSubjective) &&
			Objects.equals(this.leftConchaObjective, that.leftConchaObjective) &&
			Objects.equals(this.leftEarlobeSubjective, that.leftEarlobeSubjective) &&
			Objects.equals(this.leftEarlobeObjective, that.leftEarlobeObjective) &&
			Objects.equals(this.leftEarCanalSubjective, that.leftEarCanalSubjective) &&
			Objects.equals(this.leftEarCanalObjective, that.leftEarCanalObjective) &&
			Objects.equals(this.leftEardrumSubjective, that.leftEardrumSubjective) &&
			Objects.equals(this.leftEardrumObjective, that.leftEardrumObjective) &&
			Objects.equals(this.nasalBoneSubjective, that.nasalBoneSubjective) &&
			Objects.equals(this.nasalBoneObjective, that.nasalBoneObjective) &&
			Objects.equals(this.rightFrontalSinusSubjective, that.rightFrontalSinusSubjective) &&
			Objects.equals(this.rightFrontalSinusObjective, that.rightFrontalSinusObjective) &&
			Objects.equals(this.rightEthmoidSinusSubjective, that.rightEthmoidSinusSubjective) &&
			Objects.equals(this.rightEthmoidSinusObjective, that.rightEthmoidSinusObjective) &&
			Objects.equals(this.rightSuperiorTurbinateSubjective, that.rightSuperiorTurbinateSubjective) &&
			Objects.equals(this.rightSuperiorTurbinateObjective, that.rightSuperiorTurbinateObjective) &&
			Objects.equals(this.rightMiddleTurbinateSubjective, that.rightMiddleTurbinateSubjective) &&
			Objects.equals(this.rightMiddleTurbinateObjective, that.rightMiddleTurbinateObjective) &&
			Objects.equals(this.rightMaxillarySinusSubjective, that.rightMaxillarySinusSubjective) &&
			Objects.equals(this.rightMaxillarySinusObjective, that.rightMaxillarySinusObjective) &&
			Objects.equals(this.rightNasalCavitySubjective, that.rightNasalCavitySubjective) &&
			Objects.equals(this.rightNasalCavityObjective, that.rightNasalCavityObjective) &&
			Objects.equals(this.rightInferiorTurbinateSubjective, that.rightInferiorTurbinateSubjective) &&
			Objects.equals(this.rightInferiorTurbinateObjective, that.rightInferiorTurbinateObjective) &&
			Objects.equals(this.leftFrontalSinusSubjective, that.leftFrontalSinusSubjective) &&
			Objects.equals(this.leftFrontalSinusObjective, that.leftFrontalSinusObjective) &&
			Objects.equals(this.leftEthmoidSinusSubjective, that.leftEthmoidSinusSubjective) &&
			Objects.equals(this.leftEthmoidSinusObjective, that.leftEthmoidSinusObjective) &&
			Objects.equals(this.leftSuperiorTurbinateSubjective, that.leftSuperiorTurbinateSubjective) &&
			Objects.equals(this.leftSuperiorTurbinateObjective, that.leftSuperiorTurbinateObjective) &&
			Objects.equals(this.leftMiddleTurbinateSubjective, that.leftMiddleTurbinateSubjective) &&
			Objects.equals(this.leftMiddleTurbinateObjective, that.leftMiddleTurbinateObjective) &&
			Objects.equals(this.leftMaxillarySinusSubjective, that.leftMaxillarySinusSubjective) &&
			Objects.equals(this.leftMaxillarySinusObjective, that.leftMaxillarySinusObjective) &&
			Objects.equals(this.leftNasalCavitySubjective, that.leftNasalCavitySubjective) &&
			Objects.equals(this.leftNasalCavityObjective, that.leftNasalCavityObjective) &&
			Objects.equals(this.leftInferiorTurbinateSubjective, that.leftInferiorTurbinateSubjective) &&
			Objects.equals(this.leftInferiorTurbinateObjective, that.leftInferiorTurbinateObjective) &&
			Objects.equals(this.lingualTonsilSubjective, that.lingualTonsilSubjective) &&
			Objects.equals(this.lingualTonsilObjective, that.lingualTonsilObjective) &&
			Objects.equals(this.epiglottisSubjective, that.epiglottisSubjective) &&
			Objects.equals(this.epiglottisObjective, that.epiglottisObjective) &&
			Objects.equals(this.rightVocalFoldSubjective, that.rightVocalFoldSubjective) &&
			Objects.equals(this.rightVocalFoldObjective, that.rightVocalFoldObjective) &&
			Objects.equals(this.rightVentricularFoldSubjective, that.rightVentricularFoldSubjective) &&
			Objects.equals(this.rightVentricularFoldObjective, that.rightVentricularFoldObjective) &&
			Objects.equals(this.glottisSubjective, that.glottisSubjective) &&
			Objects.equals(this.glottisObjective, that.glottisObjective) &&
			Objects.equals(this.rightCuneiformCartilageSubjective, that.rightCuneiformCartilageSubjective) &&
			Objects.equals(this.rightCuneiformCartilageObjective, that.rightCuneiformCartilageObjective) &&
			Objects.equals(this.rightCorniculateCartilageSubjective, that.rightCorniculateCartilageSubjective) &&
			Objects.equals(this.rightCorniculateCartilageObjective, that.rightCorniculateCartilageObjective) &&
			Objects.equals(this.tracheaSubjective, that.tracheaSubjective) &&
			Objects.equals(this.tracheaObjective, that.tracheaObjective) &&
			Objects.equals(this.leftVocalFoldSubjective, that.leftVocalFoldSubjective) &&
			Objects.equals(this.leftVocalFoldObjective, that.leftVocalFoldObjective) &&
			Objects.equals(this.leftVentricularFoldSubjective, that.leftVentricularFoldSubjective) &&
			Objects.equals(this.leftVentricularFoldObjective, that.leftVentricularFoldObjective) &&
			Objects.equals(this.leftCuneiformCartilageSubjective, that.leftCuneiformCartilageSubjective) &&
			Objects.equals(this.leftCuneiformCartilageObjective, that.leftCuneiformCartilageObjective) &&
			Objects.equals(this.leftCorniculateCartilageSubjective, that.leftCorniculateCartilageSubjective) &&
			Objects.equals(this.leftCorniculateCartilageObjective, that.leftCorniculateCartilageObjective) &&
			Objects.equals(this.softPalateSubjective, that.softPalateSubjective) &&
			Objects.equals(this.softPalateObjective, that.softPalateObjective) &&
			Objects.equals(this.rightAnteriorPillarSubjective, that.rightAnteriorPillarSubjective) &&
			Objects.equals(this.rightAnteriorPillarObjective, that.rightAnteriorPillarObjective) &&
			Objects.equals(this.uvulaSubjective, that.uvulaSubjective) &&
			Objects.equals(this.uvulaObjective, that.uvulaObjective) &&
			Objects.equals(this.rightPosteriorPillarSubjective, that.rightPosteriorPillarSubjective) &&
			Objects.equals(this.rightPosteriorPillarObjective, that.rightPosteriorPillarObjective) &&
			Objects.equals(this.rightTonsilSubjective, that.rightTonsilSubjective) &&
			Objects.equals(this.rightTonsilObjective, that.rightTonsilObjective) &&
			Objects.equals(this.rightPosteriorSubjective, that.rightPosteriorSubjective) &&
			Objects.equals(this.rightPosteriorObjective, that.rightPosteriorObjective) &&
			Objects.equals(this.upperTongueSubjective, that.upperTongueSubjective) &&
			Objects.equals(this.upperTongueObjective, that.upperTongueObjective) &&
			Objects.equals(this.leftAnteriorPillarSubjective, that.leftAnteriorPillarSubjective) &&
			Objects.equals(this.leftAnteriorPillarObjective, that.leftAnteriorPillarObjective) &&
			Objects.equals(this.leftPosteriorPillarSubjective, that.leftPosteriorPillarSubjective) &&
			Objects.equals(this.leftPosteriorPillarObjective, that.leftPosteriorPillarObjective) &&
			Objects.equals(this.leftTonsilSubjective, that.leftTonsilSubjective) &&
			Objects.equals(this.leftTonsilObjective, that.leftTonsilObjective) &&
			Objects.equals(this.leftPosteriorWallSubjective, that.leftPosteriorWallSubjective) &&
			Objects.equals(this.leftPosteriorWallObjective, that.leftPosteriorWallObjective) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
