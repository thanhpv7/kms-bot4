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
import kmsweb.dtos.DeliveryMedicalExaminationRecordEntityDto;
import kmsweb.entities.listeners.DeliveryMedicalExaminationRecordEntityListener;
import kmsweb.serializers.DeliveryMedicalExaminationRecordSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
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
@EntityListeners({DeliveryMedicalExaminationRecordEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = DeliveryMedicalExaminationRecordSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class DeliveryMedicalExaminationRecordEntity extends AbstractEntity {

	/**
	 * Takes a DeliveryMedicalExaminationRecordEntityDto and converts it into a DeliveryMedicalExaminationRecordEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param deliveryMedicalExaminationRecordEntityDto
	 */
	public DeliveryMedicalExaminationRecordEntity(DeliveryMedicalExaminationRecordEntityDto deliveryMedicalExaminationRecordEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (deliveryMedicalExaminationRecordEntityDto.getId() != null) {
			this.setId(deliveryMedicalExaminationRecordEntityDto.getId());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getPregnancyHistoryGravida() != null) {
			this.setPregnancyHistoryGravida(deliveryMedicalExaminationRecordEntityDto.getPregnancyHistoryGravida());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getPregnancyHistoryPartum() != null) {
			this.setPregnancyHistoryPartum(deliveryMedicalExaminationRecordEntityDto.getPregnancyHistoryPartum());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getPregnancyHistoryAbortum() != null) {
			this.setPregnancyHistoryAbortum(deliveryMedicalExaminationRecordEntityDto.getPregnancyHistoryAbortum());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getPregnancyHistoryNotes() != null) {
			this.setPregnancyHistoryNotes(deliveryMedicalExaminationRecordEntityDto.getPregnancyHistoryNotes());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getLnmpStartDate() != null) {
			this.setLnmpStartDate(deliveryMedicalExaminationRecordEntityDto.getLnmpStartDate());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getLnmpEndDate() != null) {
			this.setLnmpEndDate(deliveryMedicalExaminationRecordEntityDto.getLnmpEndDate());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getApproximateBirthDate() != null) {
			this.setApproximateBirthDate(deliveryMedicalExaminationRecordEntityDto.getApproximateBirthDate());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getGestationAgeWeeks() != null) {
			this.setGestationAgeWeeks(deliveryMedicalExaminationRecordEntityDto.getGestationAgeWeeks());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getGestationAgeDays() != null) {
			this.setGestationAgeDays(deliveryMedicalExaminationRecordEntityDto.getGestationAgeDays());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getTetanusVaccine1() != null) {
			this.setTetanusVaccine1(deliveryMedicalExaminationRecordEntityDto.getTetanusVaccine1());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getTetanusVaccine2() != null) {
			this.setTetanusVaccine2(deliveryMedicalExaminationRecordEntityDto.getTetanusVaccine2());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getDeliveryType() != null) {
			this.setDeliveryType(deliveryMedicalExaminationRecordEntityDto.getDeliveryType());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getComplicationsInPregnancy() != null) {
			this.setComplicationsInPregnancy(deliveryMedicalExaminationRecordEntityDto.getComplicationsInPregnancy());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getRiskFactor() != null) {
			this.setRiskFactor(deliveryMedicalExaminationRecordEntityDto.getRiskFactor());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getFetalPresentation() != null) {
			this.setFetalPresentation(deliveryMedicalExaminationRecordEntityDto.getFetalPresentation());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getAbdomenExamination() != null) {
			this.setAbdomenExamination(deliveryMedicalExaminationRecordEntityDto.getAbdomenExamination());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getFundalHeight() != null) {
			this.setFundalHeight(deliveryMedicalExaminationRecordEntityDto.getFundalHeight());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getFhrPerMinute() != null) {
			this.setFhrPerMinute(deliveryMedicalExaminationRecordEntityDto.getFhrPerMinute());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getEstimatedFetalWeight() != null) {
			this.setEstimatedFetalWeight(deliveryMedicalExaminationRecordEntityDto.getEstimatedFetalWeight());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getLeopold1() != null) {
			this.setLeopold1(deliveryMedicalExaminationRecordEntityDto.getLeopold1());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getLeopold2() != null) {
			this.setLeopold2(deliveryMedicalExaminationRecordEntityDto.getLeopold2());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getLeopold3() != null) {
			this.setLeopold3(deliveryMedicalExaminationRecordEntityDto.getLeopold3());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getLeopold4() != null) {
			this.setLeopold4(deliveryMedicalExaminationRecordEntityDto.getLeopold4());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getGeniteliaExterna() != null) {
			this.setGeniteliaExterna(deliveryMedicalExaminationRecordEntityDto.getGeniteliaExterna());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getGeniteliaInterna() != null) {
			this.setGeniteliaInterna(deliveryMedicalExaminationRecordEntityDto.getGeniteliaInterna());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getVaginalExamination() != null) {
			this.setVaginalExamination(deliveryMedicalExaminationRecordEntityDto.getVaginalExamination());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getDeliveryComplication() != null) {
			this.setDeliveryComplication(deliveryMedicalExaminationRecordEntityDto.getDeliveryComplication());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getDeliveryNote() != null) {
			this.setDeliveryNote(deliveryMedicalExaminationRecordEntityDto.getDeliveryNote());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getNormalDeliveryCase() != null) {
			this.setNormalDeliveryCase(deliveryMedicalExaminationRecordEntityDto.getNormalDeliveryCase());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getStage1Hour() != null) {
			this.setStage1Hour(deliveryMedicalExaminationRecordEntityDto.getStage1Hour());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getUnnamedInteger1() != null) {
			this.setUnnamedInteger1(deliveryMedicalExaminationRecordEntityDto.getUnnamedInteger1());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getStage3Hour() != null) {
			this.setStage3Hour(deliveryMedicalExaminationRecordEntityDto.getStage3Hour());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getStage4Hour() != null) {
			this.setStage4Hour(deliveryMedicalExaminationRecordEntityDto.getStage4Hour());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getStage1Minute() != null) {
			this.setStage1Minute(deliveryMedicalExaminationRecordEntityDto.getStage1Minute());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getStage2Minute() != null) {
			this.setStage2Minute(deliveryMedicalExaminationRecordEntityDto.getStage2Minute());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getStage3Minute() != null) {
			this.setStage3Minute(deliveryMedicalExaminationRecordEntityDto.getStage3Minute());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getStage4Minute() != null) {
			this.setStage4Minute(deliveryMedicalExaminationRecordEntityDto.getStage4Minute());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getPlacenta() != null) {
			this.setPlacenta(deliveryMedicalExaminationRecordEntityDto.getPlacenta());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getPerineum() != null) {
			this.setPerineum(deliveryMedicalExaminationRecordEntityDto.getPerineum());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getBleeding() != null) {
			this.setBleeding(deliveryMedicalExaminationRecordEntityDto.getBleeding());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getPostpartumComplication() != null) {
			this.setPostpartumComplication(deliveryMedicalExaminationRecordEntityDto.getPostpartumComplication());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getNewbornDelivered() != null) {
			this.setNewbornDelivered(deliveryMedicalExaminationRecordEntityDto.getNewbornDelivered());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getPerineumInfection() != null) {
			this.setPerineumInfection(deliveryMedicalExaminationRecordEntityDto.getPerineumInfection());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getEarlyBreastfeedingIntiation() != null) {
			this.setEarlyBreastfeedingIntiation(deliveryMedicalExaminationRecordEntityDto.getEarlyBreastfeedingIntiation());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getAdditionalMidwives() != null) {
			this.setAdditionalMidwives(deliveryMedicalExaminationRecordEntityDto.getAdditionalMidwives());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getDeliveryProgresses() != null) {
			this.setDeliveryProgresses(deliveryMedicalExaminationRecordEntityDto.getDeliveryProgresses());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getNewbornDetails() != null) {
			this.setNewbornDetails(deliveryMedicalExaminationRecordEntityDto.getNewbornDetails());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(deliveryMedicalExaminationRecordEntityDto.getMedicalExaminationRecord());
		}

		if (deliveryMedicalExaminationRecordEntityDto.getMidwife() != null) {
			this.setMidwife(deliveryMedicalExaminationRecordEntityDto.getMidwife());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Pregnancy History Gravida here] off begin
	@CsvBindByName(column = "PREGNANCY_HISTORY_GRAVIDA", required = false)
	@Nullable
	@Column(name = "pregnancy_history_gravida")
	@Schema(description = "The Pregnancy History Gravida of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pregnancy History Gravida here] end
	private String pregnancyHistoryGravida;

	// % protected region % [Modify attribute annotation for Pregnancy History Partum  here] off begin
	@CsvBindByName(column = "PREGNANCY_HISTORY_PARTUM", required = false)
	@Nullable
	@Column(name = "pregnancy_history_partum")
	@Schema(description = "The Pregnancy History Partum  of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pregnancy History Partum  here] end
	private String pregnancyHistoryPartum;

	// % protected region % [Modify attribute annotation for Pregnancy History Abortum  here] off begin
	@CsvBindByName(column = "PREGNANCY_HISTORY_ABORTUM", required = false)
	@Nullable
	@Column(name = "pregnancy_history_abortum")
	@Schema(description = "The Pregnancy History Abortum  of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pregnancy History Abortum  here] end
	private String pregnancyHistoryAbortum;

	// % protected region % [Modify attribute annotation for Pregnancy History Notes here] off begin
	@CsvBindByName(column = "PREGNANCY_HISTORY_NOTES", required = false)
	@Nullable
	@Column(name = "pregnancy_history_notes")
	@Schema(description = "The Pregnancy History Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pregnancy History Notes here] end
	private String pregnancyHistoryNotes;

	// % protected region % [Modify attribute annotation for LNMP Start Date here] off begin
	@CsvCustomBindByName(column = "LNMP_START_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "lnmp_start_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The LNMP Start Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for LNMP Start Date here] end
	private OffsetDateTime lnmpStartDate;

	// % protected region % [Modify attribute annotation for LNMP End Date here] off begin
	@CsvCustomBindByName(column = "LNMP_END_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "lnmp_end_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The LNMP End Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for LNMP End Date here] end
	private OffsetDateTime lnmpEndDate;

	// % protected region % [Modify attribute annotation for Approximate Birth Date here] off begin
	@CsvCustomBindByName(column = "APPROXIMATE_BIRTH_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "approximate_birth_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Approximate Birth Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approximate Birth Date here] end
	private OffsetDateTime approximateBirthDate;

	// % protected region % [Modify attribute annotation for Gestation Age Weeks here] off begin
	@CsvBindByName(column = "GESTATION_AGE_WEEKS", required = false)
	@Nullable
	@Column(name = "gestation_age_weeks")
	@Schema(description = "The Gestation Age Weeks of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gestation Age Weeks here] end
	private Integer gestationAgeWeeks;

	// % protected region % [Modify attribute annotation for Gestation Age Days here] off begin
	@CsvBindByName(column = "GESTATION_AGE_DAYS", required = false)
	@Nullable
	@Column(name = "gestation_age_days")
	@Schema(description = "The Gestation Age Days of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gestation Age Days here] end
	private Integer gestationAgeDays;

	// % protected region % [Modify attribute annotation for Tetanus Vaccine 1 here] off begin
	@CsvBindByName(column = "TETANUS_VACCINE_1", required = false)
	@Nullable
	@Column(name = "tetanus_vaccine_1")
	@Schema(description = "The Tetanus Vaccine 1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tetanus Vaccine 1 here] end
	private Boolean tetanusVaccine1 = false ;

	// % protected region % [Modify attribute annotation for Tetanus Vaccine 2 here] off begin
	@CsvBindByName(column = "TETANUS_VACCINE_2", required = false)
	@Nullable
	@Column(name = "tetanus_vaccine_2")
	@Schema(description = "The Tetanus Vaccine 2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tetanus Vaccine 2 here] end
	private Boolean tetanusVaccine2 = false ;

	// % protected region % [Modify attribute annotation for Delivery Type here] off begin
	@CsvBindByName(column = "DELIVERY_TYPE", required = false)
	@Nullable
	@Column(name = "delivery_type")
	@Schema(description = "The Delivery Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Delivery Type here] end
	private String deliveryType;

	// % protected region % [Modify attribute annotation for Complications In Pregnancy here] off begin
	@CsvBindByName(column = "COMPLICATIONS_IN_PREGNANCY", required = false)
	@Nullable
	@Column(name = "complications_in_pregnancy")
	@Schema(description = "The Complications In Pregnancy of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Complications In Pregnancy here] end
	private String complicationsInPregnancy;

	// % protected region % [Modify attribute annotation for Risk Factor here] off begin
	@CsvBindByName(column = "RISK_FACTOR", required = false)
	@Nullable
	@Column(name = "risk_factor")
	@Schema(description = "The Risk Factor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Risk Factor here] end
	private String riskFactor;

	// % protected region % [Modify attribute annotation for Fetal Presentation here] off begin
	@CsvBindByName(column = "FETAL_PRESENTATION", required = false)
	@Nullable
	@Column(name = "fetal_presentation")
	@Schema(description = "The Fetal Presentation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Fetal Presentation here] end
	private String fetalPresentation;

	// % protected region % [Modify attribute annotation for Abdomen Examination here] off begin
	@CsvBindByName(column = "ABDOMEN_EXAMINATION", required = false)
	@Nullable
	@Column(name = "abdomen_examination")
	@Schema(description = "The Abdomen Examination of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Abdomen Examination here] end
	private String abdomenExamination;

	// % protected region % [Modify attribute annotation for Fundal Height here] off begin
	@CsvBindByName(column = "FUNDAL_HEIGHT", required = false)
	@Nullable
	@Column(name = "fundal_height")
	@Schema(description = "The Fundal Height of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Fundal Height here] end
	private String fundalHeight;

	// % protected region % [Modify attribute annotation for FHR Per Minute here] off begin
	@CsvBindByName(column = "FHR_PER_MINUTE", required = false)
	@Nullable
	@Column(name = "fhr_per_minute")
	@Schema(description = "The FHR Per Minute of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for FHR Per Minute here] end
	private String fhrPerMinute;

	// % protected region % [Modify attribute annotation for Estimated Fetal Weight here] off begin
	@CsvBindByName(column = "ESTIMATED_FETAL_WEIGHT", required = false)
	@Nullable
	@Column(name = "estimated_fetal_weight")
	@Schema(description = "The Estimated Fetal Weight of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Estimated Fetal Weight here] end
	private String estimatedFetalWeight;

	// % protected region % [Modify attribute annotation for Leopold 1 here] off begin
	@CsvBindByName(column = "LEOPOLD_1", required = false)
	@Nullable
	@Column(name = "leopold_1")
	@Schema(description = "The Leopold 1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Leopold 1 here] end
	private String leopold1;

	// % protected region % [Modify attribute annotation for Leopold 2 here] off begin
	@CsvBindByName(column = "LEOPOLD_2", required = false)
	@Nullable
	@Column(name = "leopold_2")
	@Schema(description = "The Leopold 2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Leopold 2 here] end
	private String leopold2;

	// % protected region % [Modify attribute annotation for Leopold 3 here] off begin
	@CsvBindByName(column = "LEOPOLD_3", required = false)
	@Nullable
	@Column(name = "leopold_3")
	@Schema(description = "The Leopold 3 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Leopold 3 here] end
	private String leopold3;

	// % protected region % [Modify attribute annotation for Leopold 4 here] off begin
	@CsvBindByName(column = "LEOPOLD_4", required = false)
	@Nullable
	@Column(name = "leopold_4")
	@Schema(description = "The Leopold 4 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Leopold 4 here] end
	private String leopold4;

	// % protected region % [Modify attribute annotation for Genitelia Externa here] off begin
	@CsvBindByName(column = "GENITELIA_EXTERNA", required = false)
	@Nullable
	@Column(name = "genitelia_externa")
	@Schema(description = "The Genitelia Externa of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Genitelia Externa here] end
	private String geniteliaExterna;

	// % protected region % [Modify attribute annotation for Genitelia Interna here] off begin
	@CsvBindByName(column = "GENITELIA_INTERNA", required = false)
	@Nullable
	@Column(name = "genitelia_interna")
	@Schema(description = "The Genitelia Interna of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Genitelia Interna here] end
	private String geniteliaInterna;

	// % protected region % [Modify attribute annotation for Vaginal Examination here] off begin
	@CsvBindByName(column = "VAGINAL_EXAMINATION", required = false)
	@Nullable
	@Column(name = "vaginal_examination")
	@Schema(description = "The Vaginal Examination of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vaginal Examination here] end
	private String vaginalExamination;

	// % protected region % [Modify attribute annotation for Delivery Complication here] off begin
	@CsvBindByName(column = "DELIVERY_COMPLICATION", required = false)
	@Nullable
	@Column(name = "delivery_complication")
	@Schema(description = "The Delivery Complication of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Delivery Complication here] end
	private String deliveryComplication;

	// % protected region % [Modify attribute annotation for Delivery Note here] off begin
	@CsvBindByName(column = "DELIVERY_NOTE", required = false)
	@Nullable
	@Column(name = "delivery_note")
	@Schema(description = "The Delivery Note of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Delivery Note here] end
	private String deliveryNote;

	// % protected region % [Modify attribute annotation for Normal Delivery Case here] off begin
	@CsvBindByName(column = "NORMAL_DELIVERY_CASE", required = false)
	@Nullable
	@Column(name = "normal_delivery_case")
	@Schema(description = "The Normal Delivery Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Normal Delivery Case here] end
	private Boolean normalDeliveryCase = false ;

	// % protected region % [Modify attribute annotation for Stage 1 Hour here] off begin
	@CsvBindByName(column = "STAGE_1_HOUR", required = false)
	@Nullable
	@Column(name = "stage_1_hour")
	@Schema(description = "The Stage 1 Hour of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stage 1 Hour here] end
	private Integer stage1Hour;

	// % protected region % [Modify attribute annotation for Unnamed Integer 1 here] off begin
	@CsvBindByName(column = "UNNAMED_INTEGER_1", required = false)
	@Nullable
	@Column(name = "unnamed_integer_1")
	@Schema(description = "The Unnamed Integer 1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unnamed Integer 1 here] end
	private Integer unnamedInteger1;

	// % protected region % [Modify attribute annotation for Stage 3 Hour here] off begin
	@CsvBindByName(column = "STAGE_3_HOUR", required = false)
	@Nullable
	@Column(name = "stage_3_hour")
	@Schema(description = "The Stage 3 Hour of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stage 3 Hour here] end
	private Integer stage3Hour;

	// % protected region % [Modify attribute annotation for Stage 4 Hour here] off begin
	@CsvBindByName(column = "STAGE_4_HOUR", required = false)
	@Nullable
	@Column(name = "stage_4_hour")
	@Schema(description = "The Stage 4 Hour of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stage 4 Hour here] end
	private Integer stage4Hour;

	// % protected region % [Modify attribute annotation for Stage 1 Minute here] off begin
	@CsvBindByName(column = "STAGE_1_MINUTE", required = false)
	@Nullable
	@Column(name = "stage_1_minute")
	@Schema(description = "The Stage 1 Minute of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stage 1 Minute here] end
	private Integer stage1Minute;

	// % protected region % [Modify attribute annotation for Stage 2 Minute here] off begin
	@CsvBindByName(column = "STAGE_2_MINUTE", required = false)
	@Nullable
	@Column(name = "stage_2_minute")
	@Schema(description = "The Stage 2 Minute of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stage 2 Minute here] end
	private Integer stage2Minute;

	// % protected region % [Modify attribute annotation for Stage 3 Minute here] off begin
	@CsvBindByName(column = "STAGE_3_MINUTE", required = false)
	@Nullable
	@Column(name = "stage_3_minute")
	@Schema(description = "The Stage 3 Minute of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stage 3 Minute here] end
	private Integer stage3Minute;

	// % protected region % [Modify attribute annotation for Stage 4 Minute here] off begin
	@CsvBindByName(column = "STAGE_4_MINUTE", required = false)
	@Nullable
	@Column(name = "stage_4_minute")
	@Schema(description = "The Stage 4 Minute of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stage 4 Minute here] end
	private Integer stage4Minute;

	// % protected region % [Modify attribute annotation for Placenta here] off begin
	@CsvBindByName(column = "PLACENTA", required = false)
	@Nullable
	@Column(name = "placenta")
	@Schema(description = "The Placenta of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Placenta here] end
	private String placenta;

	// % protected region % [Modify attribute annotation for Perineum here] off begin
	@CsvBindByName(column = "PERINEUM", required = false)
	@Nullable
	@Column(name = "perineum")
	@Schema(description = "The Perineum of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Perineum here] end
	private String perineum;

	// % protected region % [Modify attribute annotation for Bleeding here] off begin
	@CsvBindByName(column = "BLEEDING", required = false)
	@Nullable
	@Column(name = "bleeding")
	@Schema(description = "The Bleeding of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bleeding here] end
	private String bleeding;

	// % protected region % [Modify attribute annotation for Postpartum Complication here] off begin
	@CsvBindByName(column = "POSTPARTUM_COMPLICATION", required = false)
	@Nullable
	@Column(name = "postpartum_complication")
	@Schema(description = "The Postpartum Complication of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Postpartum Complication here] end
	private String postpartumComplication;

	// % protected region % [Modify attribute annotation for Newborn Delivered here] off begin
	@CsvBindByName(column = "NEWBORN_DELIVERED", required = false)
	@Nullable
	@Column(name = "newborn_delivered")
	@Schema(description = "The Newborn Delivered of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Newborn Delivered here] end
	private Integer newbornDelivered;

	// % protected region % [Modify attribute annotation for Perineum Infection here] off begin
	@CsvBindByName(column = "PERINEUM_INFECTION", required = false)
	@Nullable
	@Column(name = "perineum_infection")
	@Schema(description = "The Perineum Infection of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Perineum Infection here] end
	private Boolean perineumInfection = false ;

	// % protected region % [Modify attribute annotation for Early Breastfeeding Intiation here] off begin
	@CsvBindByName(column = "EARLY_BREASTFEEDING_INTIATION", required = false)
	@Nullable
	@Column(name = "early_breastfeeding_intiation")
	@Schema(description = "The Early Breastfeeding Intiation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Early Breastfeeding Intiation here] end
	private Boolean earlyBreastfeedingIntiation = false ;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Additional Midwives here] off begin
	@Schema(description = "The Co Treating Doctor entities that are related to this entity.")
	@OneToMany(mappedBy = "additionalMidwife", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Additional Midwives here] end
	private Set<CoTreatingDoctorEntity> additionalMidwives = new HashSet<>();

	// % protected region % [Update the annotation for additionalMidwivesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADDITIONAL_MIDWIVES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for additionalMidwivesIds here] end
	private Set<UUID> additionalMidwivesIds = new HashSet<>();

	// % protected region % [Update the annotation for Delivery Progresses here] off begin
	@Schema(description = "The Delivery Progress entities that are related to this entity.")
	@OneToMany(mappedBy = "deliveryMedicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Delivery Progresses here] end
	private Set<DeliveryProgressEntity> deliveryProgresses = new HashSet<>();

	// % protected region % [Update the annotation for deliveryProgressesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DELIVERY_PROGRESSES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for deliveryProgressesIds here] end
	private Set<UUID> deliveryProgressesIds = new HashSet<>();

	// % protected region % [Update the annotation for Newborn Details here] off begin
	@Schema(description = "The Newborn Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "deliveryMedicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Newborn Details here] end
	private Set<NewbornDetailEntity> newbornDetails = new HashSet<>();

	// % protected region % [Update the annotation for newbornDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "NEWBORN_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for newbornDetailsIds here] end
	private Set<UUID> newbornDetailsIds = new HashSet<>();

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

	// % protected region % [Update the annotation for Midwife here] off begin
	@Schema(description = "The Midwife entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Midwife here] end
	private StaffEntity midwife;

	// % protected region % [Update the annotation for midwifeId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MIDWIFE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for midwifeId here] end
	private UUID midwifeId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addAdditionalMidwives(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalMidwives(@NotNull CoTreatingDoctorEntity entity) {
		addAdditionalMidwives(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to additionalMidwives in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdditionalMidwives(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.additionalMidwives.contains(entity)) {
			additionalMidwives.add(entity);
			if (reverseAdd) {
				entity.setAdditionalMidwife(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdditionalMidwives(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalMidwives(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		addAdditionalMidwives(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Additional Midwives in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdditionalMidwives(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdditionalMidwives(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdditionalMidwives(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeAdditionalMidwives(@NotNull CoTreatingDoctorEntity entity) {
		this.removeAdditionalMidwives(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdditionalMidwives(@NotNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdditionalMidwife(false);
		}
		this.additionalMidwives.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdditionalMidwives(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeAdditionalMidwives(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeAdditionalMidwives(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdditionalMidwives(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdditionalMidwives(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdditionalMidwives(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setAdditionalMidwives(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		setAdditionalMidwives(entities, true);
	}

	/**
	 * Replace the current entities in Additional Midwives with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdditionalMidwives(@NotNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetAdditionalMidwives();
		this.additionalMidwives = new HashSet<>(entities);
		if (reverseAdd) {
			this.additionalMidwives.forEach(additionalMidwivesEntity -> additionalMidwivesEntity.setAdditionalMidwife(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdditionalMidwives(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdditionalMidwives() {
		this.unsetAdditionalMidwives(true);
	}

	/**
	 * Remove all the entities in Additional Midwives from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdditionalMidwives(boolean doReverse) {
		if (doReverse) {
			this.additionalMidwives.forEach(additionalMidwivesEntity -> additionalMidwivesEntity.unsetAdditionalMidwife(false));
		}
		this.additionalMidwives.clear();
	}

/**
	 * Similar to {@link this#addDeliveryProgresses(DeliveryProgressEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryProgressEntity to be added to this entity
	 */
	public void addDeliveryProgresses(@NotNull DeliveryProgressEntity entity) {
		addDeliveryProgresses(entity, true);
	}

	/**
	 * Add a new DeliveryProgressEntity to deliveryProgresses in this entity.
	 *
	 * @param entity the given DeliveryProgressEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDeliveryProgresses(@NonNull DeliveryProgressEntity entity, boolean reverseAdd) {
		if (!this.deliveryProgresses.contains(entity)) {
			deliveryProgresses.add(entity);
			if (reverseAdd) {
				entity.setDeliveryMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be added to this entity
	 */
	public void addDeliveryProgresses(@NotNull Collection<DeliveryProgressEntity> entities) {
		addDeliveryProgresses(entities, true);
	}

	/**
	 * Add a new collection of DeliveryProgressEntity to Delivery Progresses in this entity.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDeliveryProgresses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDeliveryProgresses(DeliveryProgressEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryProgressEntity to be set to this entity
	 */
	public void removeDeliveryProgresses(@NotNull DeliveryProgressEntity entity) {
		this.removeDeliveryProgresses(entity, true);
	}

	/**
	 * Remove the given DeliveryProgressEntity from this entity.
	 *
	 * @param entity the given DeliveryProgressEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDeliveryProgresses(@NotNull DeliveryProgressEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDeliveryMedicalExaminationRecord(false);
		}
		this.deliveryProgresses.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be removed to this entity
	 */
	public void removeDeliveryProgresses(@NotNull Collection<DeliveryProgressEntity> entities) {
		this.removeDeliveryProgresses(entities, true);
	}

	/**
	 * Remove the given collection of DeliveryProgressEntity from  to this entity.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDeliveryProgresses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be set to this entity
	 */
	public void setDeliveryProgresses(@NotNull Collection<DeliveryProgressEntity> entities) {
		setDeliveryProgresses(entities, true);
	}

	/**
	 * Replace the current entities in Delivery Progresses with the given ones.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDeliveryProgresses(@NotNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {

		this.unsetDeliveryProgresses();
		this.deliveryProgresses = new HashSet<>(entities);
		if (reverseAdd) {
			this.deliveryProgresses.forEach(deliveryProgressesEntity -> deliveryProgressesEntity.setDeliveryMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDeliveryProgresses(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDeliveryProgresses() {
		this.unsetDeliveryProgresses(true);
	}

	/**
	 * Remove all the entities in Delivery Progresses from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDeliveryProgresses(boolean doReverse) {
		if (doReverse) {
			this.deliveryProgresses.forEach(deliveryProgressesEntity -> deliveryProgressesEntity.unsetDeliveryMedicalExaminationRecord(false));
		}
		this.deliveryProgresses.clear();
	}

/**
	 * Similar to {@link this#addNewbornDetails(NewbornDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NewbornDetailEntity to be added to this entity
	 */
	public void addNewbornDetails(@NotNull NewbornDetailEntity entity) {
		addNewbornDetails(entity, true);
	}

	/**
	 * Add a new NewbornDetailEntity to newbornDetails in this entity.
	 *
	 * @param entity the given NewbornDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNewbornDetails(@NonNull NewbornDetailEntity entity, boolean reverseAdd) {
		if (!this.newbornDetails.contains(entity)) {
			newbornDetails.add(entity);
			if (reverseAdd) {
				entity.setDeliveryMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNewbornDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be added to this entity
	 */
	public void addNewbornDetails(@NotNull Collection<NewbornDetailEntity> entities) {
		addNewbornDetails(entities, true);
	}

	/**
	 * Add a new collection of NewbornDetailEntity to Newborn Details in this entity.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNewbornDetails(@NonNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addNewbornDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNewbornDetails(NewbornDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NewbornDetailEntity to be set to this entity
	 */
	public void removeNewbornDetails(@NotNull NewbornDetailEntity entity) {
		this.removeNewbornDetails(entity, true);
	}

	/**
	 * Remove the given NewbornDetailEntity from this entity.
	 *
	 * @param entity the given NewbornDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNewbornDetails(@NotNull NewbornDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDeliveryMedicalExaminationRecord(false);
		}
		this.newbornDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNewbornDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be removed to this entity
	 */
	public void removeNewbornDetails(@NotNull Collection<NewbornDetailEntity> entities) {
		this.removeNewbornDetails(entities, true);
	}

	/**
	 * Remove the given collection of NewbornDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeNewbornDetails(@NonNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeNewbornDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setNewbornDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be set to this entity
	 */
	public void setNewbornDetails(@NotNull Collection<NewbornDetailEntity> entities) {
		setNewbornDetails(entities, true);
	}

	/**
	 * Replace the current entities in Newborn Details with the given ones.
	 *
	 * @param entities the given collection of NewbornDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNewbornDetails(@NotNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {

		this.unsetNewbornDetails();
		this.newbornDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.newbornDetails.forEach(newbornDetailsEntity -> newbornDetailsEntity.setDeliveryMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetNewbornDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetNewbornDetails() {
		this.unsetNewbornDetails(true);
	}

	/**
	 * Remove all the entities in Newborn Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetNewbornDetails(boolean doReverse) {
		if (doReverse) {
			this.newbornDetails.forEach(newbornDetailsEntity -> newbornDetailsEntity.unsetDeliveryMedicalExaminationRecord(false));
		}
		this.newbornDetails.clear();
	}
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
			this.medicalExaminationRecord.unsetDeliveryMedicalExaminationRecord(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setDeliveryMedicalExaminationRecord(this, false);
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
			this.medicalExaminationRecord.unsetDeliveryMedicalExaminationRecord();
		}
		this.medicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setMidwife(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setMidwife(@NotNull StaffEntity entity) {
		setMidwife(entity, true);
	}

	/**
	 * Set or update the midwife in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to midwife
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMidwife(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMidwife here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMidwife here] end

		if (sameAsFormer(this.midwife, entity)) {
			return;
		}

		if (this.midwife != null) {
			this.midwife.removeMidwives(this, false);
		}
		this.midwife = entity;
		if (reverseAdd) {
			this.midwife.addMidwives(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMidwife incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMidwife incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMidwife(boolean)} but default to true.
	 */
	public void unsetMidwife() {
		this.unsetMidwife(true);
	}

	/**
	 * Remove Midwife in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMidwife(boolean reverse) {
		if (reverse && this.midwife != null) {
			this.midwife.removeMidwives(this, false);
		}
		this.midwife = null;
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
		return "PREGNANCY_HISTORY_GRAVIDA,PREGNANCY_HISTORY_PARTUM,PREGNANCY_HISTORY_ABORTUM,PREGNANCY_HISTORY_NOTES,LNMP_START_DATE,LNMP_END_DATE,APPROXIMATE_BIRTH_DATE,GESTATION_AGE_WEEKS,GESTATION_AGE_DAYS,TETANUS_VACCINE_1,TETANUS_VACCINE_2,DELIVERY_TYPE,COMPLICATIONS_IN_PREGNANCY,RISK_FACTOR,FETAL_PRESENTATION,ABDOMEN_EXAMINATION,FUNDAL_HEIGHT,FHR_PER_MINUTE,ESTIMATED_FETAL_WEIGHT,LEOPOLD_1,LEOPOLD_2,LEOPOLD_3,LEOPOLD_4,GENITELIA_EXTERNA,GENITELIA_INTERNA,VAGINAL_EXAMINATION,DELIVERY_COMPLICATION,DELIVERY_NOTE,NORMAL_DELIVERY_CASE,STAGE_1_HOUR,UNNAMED_INTEGER_1,STAGE_3_HOUR,STAGE_4_HOUR,STAGE_1_MINUTE,STAGE_2_MINUTE,STAGE_3_MINUTE,STAGE_4_MINUTE,PLACENTA,PERINEUM,BLEEDING,POSTPARTUM_COMPLICATION,NEWBORN_DELIVERED,PERINEUM_INFECTION,EARLY_BREASTFEEDING_INTIATION,MEDICAL_EXAMINATION_RECORD_ID,MIDWIFE_ID,ADDITIONAL_MIDWIVES_IDS,DELIVERY_PROGRESSES_IDS,NEWBORN_DETAILS_IDS,ID";
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

		Optional<StaffEntity> midwifeRelation = Optional.ofNullable(this.midwife);
		midwifeRelation.ifPresent(entity -> this.midwifeId = entity.getId());

		this.additionalMidwivesIds = new HashSet<>();
		for (CoTreatingDoctorEntity additionalMidwives: this.additionalMidwives) {
			this.additionalMidwivesIds.add(additionalMidwives.getId());
		}

		this.deliveryProgressesIds = new HashSet<>();
		for (DeliveryProgressEntity deliveryProgresses: this.deliveryProgresses) {
			this.deliveryProgressesIds.add(deliveryProgresses.getId());
		}

		this.newbornDetailsIds = new HashSet<>();
		for (NewbornDetailEntity newbornDetails: this.newbornDetails) {
			this.newbornDetailsIds.add(newbornDetails.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object deliveryMedicalExaminationRecord) {
		if (this == deliveryMedicalExaminationRecord) {
			return true;
		}
		if (deliveryMedicalExaminationRecord == null || this.getClass() != deliveryMedicalExaminationRecord.getClass()) {
			return false;
		}
		if (!super.equals(deliveryMedicalExaminationRecord)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		DeliveryMedicalExaminationRecordEntity that = (DeliveryMedicalExaminationRecordEntity) deliveryMedicalExaminationRecord;
		return
			Objects.equals(this.pregnancyHistoryGravida, that.pregnancyHistoryGravida) &&
			Objects.equals(this.pregnancyHistoryPartum, that.pregnancyHistoryPartum) &&
			Objects.equals(this.pregnancyHistoryAbortum, that.pregnancyHistoryAbortum) &&
			Objects.equals(this.pregnancyHistoryNotes, that.pregnancyHistoryNotes) &&
			Objects.equals(
			     this.lnmpStartDate != null ? this.lnmpStartDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.lnmpStartDate != null ? that.lnmpStartDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.lnmpEndDate != null ? this.lnmpEndDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.lnmpEndDate != null ? that.lnmpEndDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.approximateBirthDate != null ? this.approximateBirthDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.approximateBirthDate != null ? that.approximateBirthDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.gestationAgeWeeks, that.gestationAgeWeeks) &&
			Objects.equals(this.gestationAgeDays, that.gestationAgeDays) &&
			Objects.equals(this.tetanusVaccine1, that.tetanusVaccine1) &&
			Objects.equals(this.tetanusVaccine2, that.tetanusVaccine2) &&
			Objects.equals(this.deliveryType, that.deliveryType) &&
			Objects.equals(this.complicationsInPregnancy, that.complicationsInPregnancy) &&
			Objects.equals(this.riskFactor, that.riskFactor) &&
			Objects.equals(this.fetalPresentation, that.fetalPresentation) &&
			Objects.equals(this.abdomenExamination, that.abdomenExamination) &&
			Objects.equals(this.fundalHeight, that.fundalHeight) &&
			Objects.equals(this.fhrPerMinute, that.fhrPerMinute) &&
			Objects.equals(this.estimatedFetalWeight, that.estimatedFetalWeight) &&
			Objects.equals(this.leopold1, that.leopold1) &&
			Objects.equals(this.leopold2, that.leopold2) &&
			Objects.equals(this.leopold3, that.leopold3) &&
			Objects.equals(this.leopold4, that.leopold4) &&
			Objects.equals(this.geniteliaExterna, that.geniteliaExterna) &&
			Objects.equals(this.geniteliaInterna, that.geniteliaInterna) &&
			Objects.equals(this.vaginalExamination, that.vaginalExamination) &&
			Objects.equals(this.deliveryComplication, that.deliveryComplication) &&
			Objects.equals(this.deliveryNote, that.deliveryNote) &&
			Objects.equals(this.normalDeliveryCase, that.normalDeliveryCase) &&
			Objects.equals(this.stage1Hour, that.stage1Hour) &&
			Objects.equals(this.unnamedInteger1, that.unnamedInteger1) &&
			Objects.equals(this.stage3Hour, that.stage3Hour) &&
			Objects.equals(this.stage4Hour, that.stage4Hour) &&
			Objects.equals(this.stage1Minute, that.stage1Minute) &&
			Objects.equals(this.stage2Minute, that.stage2Minute) &&
			Objects.equals(this.stage3Minute, that.stage3Minute) &&
			Objects.equals(this.stage4Minute, that.stage4Minute) &&
			Objects.equals(this.placenta, that.placenta) &&
			Objects.equals(this.perineum, that.perineum) &&
			Objects.equals(this.bleeding, that.bleeding) &&
			Objects.equals(this.postpartumComplication, that.postpartumComplication) &&
			Objects.equals(this.newbornDelivered, that.newbornDelivered) &&
			Objects.equals(this.perineumInfection, that.perineumInfection) &&
			Objects.equals(this.earlyBreastfeedingIntiation, that.earlyBreastfeedingIntiation) &&
			Objects.equals(this.additionalMidwivesIds, that.additionalMidwivesIds) &&
			Objects.equals(this.deliveryProgressesIds, that.deliveryProgressesIds) &&
			Objects.equals(this.newbornDetailsIds, that.newbornDetailsIds) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId) &&
			Objects.equals(this.midwifeId, that.midwifeId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
