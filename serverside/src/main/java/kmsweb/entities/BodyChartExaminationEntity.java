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
import kmsweb.dtos.BodyChartExaminationEntityDto;
import kmsweb.entities.listeners.BodyChartExaminationEntityListener;
import kmsweb.serializers.BodyChartExaminationSerializer;
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
@EntityListeners({BodyChartExaminationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BodyChartExaminationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BodyChartExaminationEntity extends AbstractEntity {

	/**
	 * Takes a BodyChartExaminationEntityDto and converts it into a BodyChartExaminationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bodyChartExaminationEntityDto
	 */
	public BodyChartExaminationEntity(BodyChartExaminationEntityDto bodyChartExaminationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bodyChartExaminationEntityDto.getId() != null) {
			this.setId(bodyChartExaminationEntityDto.getId());
		}

		if (bodyChartExaminationEntityDto.getBc01Subjective() != null) {
			this.setBc01Subjective(bodyChartExaminationEntityDto.getBc01Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc01Objective() != null) {
			this.setBc01Objective(bodyChartExaminationEntityDto.getBc01Objective());
		}

		if (bodyChartExaminationEntityDto.getBc02Subjective() != null) {
			this.setBc02Subjective(bodyChartExaminationEntityDto.getBc02Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc02Objective() != null) {
			this.setBc02Objective(bodyChartExaminationEntityDto.getBc02Objective());
		}

		if (bodyChartExaminationEntityDto.getBc03Subjective() != null) {
			this.setBc03Subjective(bodyChartExaminationEntityDto.getBc03Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc03Objective() != null) {
			this.setBc03Objective(bodyChartExaminationEntityDto.getBc03Objective());
		}

		if (bodyChartExaminationEntityDto.getBc04Subjective() != null) {
			this.setBc04Subjective(bodyChartExaminationEntityDto.getBc04Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc04Objective() != null) {
			this.setBc04Objective(bodyChartExaminationEntityDto.getBc04Objective());
		}

		if (bodyChartExaminationEntityDto.getBc05Subjective() != null) {
			this.setBc05Subjective(bodyChartExaminationEntityDto.getBc05Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc05Objective() != null) {
			this.setBc05Objective(bodyChartExaminationEntityDto.getBc05Objective());
		}

		if (bodyChartExaminationEntityDto.getBc06Subjective() != null) {
			this.setBc06Subjective(bodyChartExaminationEntityDto.getBc06Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc06Objective() != null) {
			this.setBc06Objective(bodyChartExaminationEntityDto.getBc06Objective());
		}

		if (bodyChartExaminationEntityDto.getBc07Subjective() != null) {
			this.setBc07Subjective(bodyChartExaminationEntityDto.getBc07Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc07Objective() != null) {
			this.setBc07Objective(bodyChartExaminationEntityDto.getBc07Objective());
		}

		if (bodyChartExaminationEntityDto.getBc08Subjective() != null) {
			this.setBc08Subjective(bodyChartExaminationEntityDto.getBc08Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc08Objective() != null) {
			this.setBc08Objective(bodyChartExaminationEntityDto.getBc08Objective());
		}

		if (bodyChartExaminationEntityDto.getBc09Subjective() != null) {
			this.setBc09Subjective(bodyChartExaminationEntityDto.getBc09Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc09Objective() != null) {
			this.setBc09Objective(bodyChartExaminationEntityDto.getBc09Objective());
		}

		if (bodyChartExaminationEntityDto.getBc10Subjective() != null) {
			this.setBc10Subjective(bodyChartExaminationEntityDto.getBc10Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc10Objective() != null) {
			this.setBc10Objective(bodyChartExaminationEntityDto.getBc10Objective());
		}

		if (bodyChartExaminationEntityDto.getBc11Subjective() != null) {
			this.setBc11Subjective(bodyChartExaminationEntityDto.getBc11Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc11Objective() != null) {
			this.setBc11Objective(bodyChartExaminationEntityDto.getBc11Objective());
		}

		if (bodyChartExaminationEntityDto.getBc12Subjective() != null) {
			this.setBc12Subjective(bodyChartExaminationEntityDto.getBc12Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc12Objective() != null) {
			this.setBc12Objective(bodyChartExaminationEntityDto.getBc12Objective());
		}

		if (bodyChartExaminationEntityDto.getBc13Subjective() != null) {
			this.setBc13Subjective(bodyChartExaminationEntityDto.getBc13Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc13Objective() != null) {
			this.setBc13Objective(bodyChartExaminationEntityDto.getBc13Objective());
		}

		if (bodyChartExaminationEntityDto.getBc14Subjective() != null) {
			this.setBc14Subjective(bodyChartExaminationEntityDto.getBc14Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc14Objective() != null) {
			this.setBc14Objective(bodyChartExaminationEntityDto.getBc14Objective());
		}

		if (bodyChartExaminationEntityDto.getBc15Subjective() != null) {
			this.setBc15Subjective(bodyChartExaminationEntityDto.getBc15Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc15Objective() != null) {
			this.setBc15Objective(bodyChartExaminationEntityDto.getBc15Objective());
		}

		if (bodyChartExaminationEntityDto.getBc16Subjective() != null) {
			this.setBc16Subjective(bodyChartExaminationEntityDto.getBc16Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc16Objective() != null) {
			this.setBc16Objective(bodyChartExaminationEntityDto.getBc16Objective());
		}

		if (bodyChartExaminationEntityDto.getBc17Subjective() != null) {
			this.setBc17Subjective(bodyChartExaminationEntityDto.getBc17Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc17Objective() != null) {
			this.setBc17Objective(bodyChartExaminationEntityDto.getBc17Objective());
		}

		if (bodyChartExaminationEntityDto.getBc18Subjective() != null) {
			this.setBc18Subjective(bodyChartExaminationEntityDto.getBc18Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc18Objective() != null) {
			this.setBc18Objective(bodyChartExaminationEntityDto.getBc18Objective());
		}

		if (bodyChartExaminationEntityDto.getBc19Subjective() != null) {
			this.setBc19Subjective(bodyChartExaminationEntityDto.getBc19Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc19Objective() != null) {
			this.setBc19Objective(bodyChartExaminationEntityDto.getBc19Objective());
		}

		if (bodyChartExaminationEntityDto.getBc20Subjective() != null) {
			this.setBc20Subjective(bodyChartExaminationEntityDto.getBc20Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc20Objective() != null) {
			this.setBc20Objective(bodyChartExaminationEntityDto.getBc20Objective());
		}

		if (bodyChartExaminationEntityDto.getBc21Subjective() != null) {
			this.setBc21Subjective(bodyChartExaminationEntityDto.getBc21Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc21Objective() != null) {
			this.setBc21Objective(bodyChartExaminationEntityDto.getBc21Objective());
		}

		if (bodyChartExaminationEntityDto.getBc22Subjective() != null) {
			this.setBc22Subjective(bodyChartExaminationEntityDto.getBc22Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc22Objective() != null) {
			this.setBc22Objective(bodyChartExaminationEntityDto.getBc22Objective());
		}

		if (bodyChartExaminationEntityDto.getBc23Subjective() != null) {
			this.setBc23Subjective(bodyChartExaminationEntityDto.getBc23Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc23Objective() != null) {
			this.setBc23Objective(bodyChartExaminationEntityDto.getBc23Objective());
		}

		if (bodyChartExaminationEntityDto.getBc24Subjective() != null) {
			this.setBc24Subjective(bodyChartExaminationEntityDto.getBc24Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc24Objective() != null) {
			this.setBc24Objective(bodyChartExaminationEntityDto.getBc24Objective());
		}

		if (bodyChartExaminationEntityDto.getBc25Subjective() != null) {
			this.setBc25Subjective(bodyChartExaminationEntityDto.getBc25Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc25Objective() != null) {
			this.setBc25Objective(bodyChartExaminationEntityDto.getBc25Objective());
		}

		if (bodyChartExaminationEntityDto.getBc26Subjective() != null) {
			this.setBc26Subjective(bodyChartExaminationEntityDto.getBc26Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc26Objective() != null) {
			this.setBc26Objective(bodyChartExaminationEntityDto.getBc26Objective());
		}

		if (bodyChartExaminationEntityDto.getBc27Subjective() != null) {
			this.setBc27Subjective(bodyChartExaminationEntityDto.getBc27Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc27Objective() != null) {
			this.setBc27Objective(bodyChartExaminationEntityDto.getBc27Objective());
		}

		if (bodyChartExaminationEntityDto.getBc28Subjective() != null) {
			this.setBc28Subjective(bodyChartExaminationEntityDto.getBc28Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc28Objective() != null) {
			this.setBc28Objective(bodyChartExaminationEntityDto.getBc28Objective());
		}

		if (bodyChartExaminationEntityDto.getBc29Subjective() != null) {
			this.setBc29Subjective(bodyChartExaminationEntityDto.getBc29Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc29Objective() != null) {
			this.setBc29Objective(bodyChartExaminationEntityDto.getBc29Objective());
		}

		if (bodyChartExaminationEntityDto.getBc30Subjective() != null) {
			this.setBc30Subjective(bodyChartExaminationEntityDto.getBc30Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc30Objective() != null) {
			this.setBc30Objective(bodyChartExaminationEntityDto.getBc30Objective());
		}

		if (bodyChartExaminationEntityDto.getBc31Subjective() != null) {
			this.setBc31Subjective(bodyChartExaminationEntityDto.getBc31Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc31Objective() != null) {
			this.setBc31Objective(bodyChartExaminationEntityDto.getBc31Objective());
		}

		if (bodyChartExaminationEntityDto.getBc32Subjective() != null) {
			this.setBc32Subjective(bodyChartExaminationEntityDto.getBc32Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc32Objective() != null) {
			this.setBc32Objective(bodyChartExaminationEntityDto.getBc32Objective());
		}

		if (bodyChartExaminationEntityDto.getBc33Subjective() != null) {
			this.setBc33Subjective(bodyChartExaminationEntityDto.getBc33Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc33Objective() != null) {
			this.setBc33Objective(bodyChartExaminationEntityDto.getBc33Objective());
		}

		if (bodyChartExaminationEntityDto.getBc34Subjective() != null) {
			this.setBc34Subjective(bodyChartExaminationEntityDto.getBc34Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc34Objective() != null) {
			this.setBc34Objective(bodyChartExaminationEntityDto.getBc34Objective());
		}

		if (bodyChartExaminationEntityDto.getBc35Subjective() != null) {
			this.setBc35Subjective(bodyChartExaminationEntityDto.getBc35Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc35Objective() != null) {
			this.setBc35Objective(bodyChartExaminationEntityDto.getBc35Objective());
		}

		if (bodyChartExaminationEntityDto.getBc36Subjective() != null) {
			this.setBc36Subjective(bodyChartExaminationEntityDto.getBc36Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc36Objective() != null) {
			this.setBc36Objective(bodyChartExaminationEntityDto.getBc36Objective());
		}

		if (bodyChartExaminationEntityDto.getBc37Subjective() != null) {
			this.setBc37Subjective(bodyChartExaminationEntityDto.getBc37Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc37Objective() != null) {
			this.setBc37Objective(bodyChartExaminationEntityDto.getBc37Objective());
		}

		if (bodyChartExaminationEntityDto.getBc38Subjective() != null) {
			this.setBc38Subjective(bodyChartExaminationEntityDto.getBc38Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc38Objective() != null) {
			this.setBc38Objective(bodyChartExaminationEntityDto.getBc38Objective());
		}

		if (bodyChartExaminationEntityDto.getBc39Subjective() != null) {
			this.setBc39Subjective(bodyChartExaminationEntityDto.getBc39Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc39Objective() != null) {
			this.setBc39Objective(bodyChartExaminationEntityDto.getBc39Objective());
		}

		if (bodyChartExaminationEntityDto.getBc40Subjective() != null) {
			this.setBc40Subjective(bodyChartExaminationEntityDto.getBc40Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc40Objective() != null) {
			this.setBc40Objective(bodyChartExaminationEntityDto.getBc40Objective());
		}

		if (bodyChartExaminationEntityDto.getBc41Subjective() != null) {
			this.setBc41Subjective(bodyChartExaminationEntityDto.getBc41Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc41Objective() != null) {
			this.setBc41Objective(bodyChartExaminationEntityDto.getBc41Objective());
		}

		if (bodyChartExaminationEntityDto.getBc42Subjective() != null) {
			this.setBc42Subjective(bodyChartExaminationEntityDto.getBc42Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc42Objective() != null) {
			this.setBc42Objective(bodyChartExaminationEntityDto.getBc42Objective());
		}

		if (bodyChartExaminationEntityDto.getBc43Subjective() != null) {
			this.setBc43Subjective(bodyChartExaminationEntityDto.getBc43Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc43Objective() != null) {
			this.setBc43Objective(bodyChartExaminationEntityDto.getBc43Objective());
		}

		if (bodyChartExaminationEntityDto.getBc44Subjective() != null) {
			this.setBc44Subjective(bodyChartExaminationEntityDto.getBc44Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc44Objective() != null) {
			this.setBc44Objective(bodyChartExaminationEntityDto.getBc44Objective());
		}

		if (bodyChartExaminationEntityDto.getBc45Subjective() != null) {
			this.setBc45Subjective(bodyChartExaminationEntityDto.getBc45Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc45Objective() != null) {
			this.setBc45Objective(bodyChartExaminationEntityDto.getBc45Objective());
		}

		if (bodyChartExaminationEntityDto.getBc46Subjective() != null) {
			this.setBc46Subjective(bodyChartExaminationEntityDto.getBc46Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc46Objective() != null) {
			this.setBc46Objective(bodyChartExaminationEntityDto.getBc46Objective());
		}

		if (bodyChartExaminationEntityDto.getBc47Subjective() != null) {
			this.setBc47Subjective(bodyChartExaminationEntityDto.getBc47Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc47Objective() != null) {
			this.setBc47Objective(bodyChartExaminationEntityDto.getBc47Objective());
		}

		if (bodyChartExaminationEntityDto.getBc48Subjective() != null) {
			this.setBc48Subjective(bodyChartExaminationEntityDto.getBc48Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc48Objective() != null) {
			this.setBc48Objective(bodyChartExaminationEntityDto.getBc48Objective());
		}

		if (bodyChartExaminationEntityDto.getBc49Subjective() != null) {
			this.setBc49Subjective(bodyChartExaminationEntityDto.getBc49Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc49Objective() != null) {
			this.setBc49Objective(bodyChartExaminationEntityDto.getBc49Objective());
		}

		if (bodyChartExaminationEntityDto.getBc50Subjective() != null) {
			this.setBc50Subjective(bodyChartExaminationEntityDto.getBc50Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc50Objective() != null) {
			this.setBc50Objective(bodyChartExaminationEntityDto.getBc50Objective());
		}

		if (bodyChartExaminationEntityDto.getBc51Subjective() != null) {
			this.setBc51Subjective(bodyChartExaminationEntityDto.getBc51Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc51Objective() != null) {
			this.setBc51Objective(bodyChartExaminationEntityDto.getBc51Objective());
		}

		if (bodyChartExaminationEntityDto.getBc52Subjective() != null) {
			this.setBc52Subjective(bodyChartExaminationEntityDto.getBc52Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc52Objective() != null) {
			this.setBc52Objective(bodyChartExaminationEntityDto.getBc52Objective());
		}

		if (bodyChartExaminationEntityDto.getBc53Subjective() != null) {
			this.setBc53Subjective(bodyChartExaminationEntityDto.getBc53Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc53Objective() != null) {
			this.setBc53Objective(bodyChartExaminationEntityDto.getBc53Objective());
		}

		if (bodyChartExaminationEntityDto.getBc54Subjective() != null) {
			this.setBc54Subjective(bodyChartExaminationEntityDto.getBc54Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc54Objective() != null) {
			this.setBc54Objective(bodyChartExaminationEntityDto.getBc54Objective());
		}

		if (bodyChartExaminationEntityDto.getBc55Subjective() != null) {
			this.setBc55Subjective(bodyChartExaminationEntityDto.getBc55Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc55Objective() != null) {
			this.setBc55Objective(bodyChartExaminationEntityDto.getBc55Objective());
		}

		if (bodyChartExaminationEntityDto.getBc56Subjective() != null) {
			this.setBc56Subjective(bodyChartExaminationEntityDto.getBc56Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc56Objective() != null) {
			this.setBc56Objective(bodyChartExaminationEntityDto.getBc56Objective());
		}

		if (bodyChartExaminationEntityDto.getBc57Subjective() != null) {
			this.setBc57Subjective(bodyChartExaminationEntityDto.getBc57Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc57Objective() != null) {
			this.setBc57Objective(bodyChartExaminationEntityDto.getBc57Objective());
		}

		if (bodyChartExaminationEntityDto.getBc58Subjective() != null) {
			this.setBc58Subjective(bodyChartExaminationEntityDto.getBc58Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc58Objective() != null) {
			this.setBc58Objective(bodyChartExaminationEntityDto.getBc58Objective());
		}

		if (bodyChartExaminationEntityDto.getBc59Subjective() != null) {
			this.setBc59Subjective(bodyChartExaminationEntityDto.getBc59Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc59Objective() != null) {
			this.setBc59Objective(bodyChartExaminationEntityDto.getBc59Objective());
		}

		if (bodyChartExaminationEntityDto.getBc60Subjective() != null) {
			this.setBc60Subjective(bodyChartExaminationEntityDto.getBc60Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc60Objective() != null) {
			this.setBc60Objective(bodyChartExaminationEntityDto.getBc60Objective());
		}

		if (bodyChartExaminationEntityDto.getBc61Subjective() != null) {
			this.setBc61Subjective(bodyChartExaminationEntityDto.getBc61Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc61Objective() != null) {
			this.setBc61Objective(bodyChartExaminationEntityDto.getBc61Objective());
		}

		if (bodyChartExaminationEntityDto.getBc62Subjective() != null) {
			this.setBc62Subjective(bodyChartExaminationEntityDto.getBc62Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc62Objective() != null) {
			this.setBc62Objective(bodyChartExaminationEntityDto.getBc62Objective());
		}

		if (bodyChartExaminationEntityDto.getBc63Subjective() != null) {
			this.setBc63Subjective(bodyChartExaminationEntityDto.getBc63Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc63Objective() != null) {
			this.setBc63Objective(bodyChartExaminationEntityDto.getBc63Objective());
		}

		if (bodyChartExaminationEntityDto.getBc64Subjective() != null) {
			this.setBc64Subjective(bodyChartExaminationEntityDto.getBc64Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc64Objective() != null) {
			this.setBc64Objective(bodyChartExaminationEntityDto.getBc64Objective());
		}

		if (bodyChartExaminationEntityDto.getBc65Subjective() != null) {
			this.setBc65Subjective(bodyChartExaminationEntityDto.getBc65Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc65Objective() != null) {
			this.setBc65Objective(bodyChartExaminationEntityDto.getBc65Objective());
		}

		if (bodyChartExaminationEntityDto.getBc66Subjective() != null) {
			this.setBc66Subjective(bodyChartExaminationEntityDto.getBc66Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc66Objective() != null) {
			this.setBc66Objective(bodyChartExaminationEntityDto.getBc66Objective());
		}

		if (bodyChartExaminationEntityDto.getBc67Subjective() != null) {
			this.setBc67Subjective(bodyChartExaminationEntityDto.getBc67Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc67Objective() != null) {
			this.setBc67Objective(bodyChartExaminationEntityDto.getBc67Objective());
		}

		if (bodyChartExaminationEntityDto.getBc68Subjective() != null) {
			this.setBc68Subjective(bodyChartExaminationEntityDto.getBc68Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc68Objective() != null) {
			this.setBc68Objective(bodyChartExaminationEntityDto.getBc68Objective());
		}

		if (bodyChartExaminationEntityDto.getBc69Subjective() != null) {
			this.setBc69Subjective(bodyChartExaminationEntityDto.getBc69Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc69Objective() != null) {
			this.setBc69Objective(bodyChartExaminationEntityDto.getBc69Objective());
		}

		if (bodyChartExaminationEntityDto.getBc70Subjective() != null) {
			this.setBc70Subjective(bodyChartExaminationEntityDto.getBc70Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc70Objective() != null) {
			this.setBc70Objective(bodyChartExaminationEntityDto.getBc70Objective());
		}

		if (bodyChartExaminationEntityDto.getBc71Subjective() != null) {
			this.setBc71Subjective(bodyChartExaminationEntityDto.getBc71Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc71Objective() != null) {
			this.setBc71Objective(bodyChartExaminationEntityDto.getBc71Objective());
		}

		if (bodyChartExaminationEntityDto.getBc72Subjective() != null) {
			this.setBc72Subjective(bodyChartExaminationEntityDto.getBc72Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc72Objective() != null) {
			this.setBc72Objective(bodyChartExaminationEntityDto.getBc72Objective());
		}

		if (bodyChartExaminationEntityDto.getBc73Subjective() != null) {
			this.setBc73Subjective(bodyChartExaminationEntityDto.getBc73Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc73Objective() != null) {
			this.setBc73Objective(bodyChartExaminationEntityDto.getBc73Objective());
		}

		if (bodyChartExaminationEntityDto.getBc74Subjective() != null) {
			this.setBc74Subjective(bodyChartExaminationEntityDto.getBc74Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc74Objective() != null) {
			this.setBc74Objective(bodyChartExaminationEntityDto.getBc74Objective());
		}

		if (bodyChartExaminationEntityDto.getBc75Subjective() != null) {
			this.setBc75Subjective(bodyChartExaminationEntityDto.getBc75Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc75Objective() != null) {
			this.setBc75Objective(bodyChartExaminationEntityDto.getBc75Objective());
		}

		if (bodyChartExaminationEntityDto.getBc76Subjective() != null) {
			this.setBc76Subjective(bodyChartExaminationEntityDto.getBc76Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc76Objective() != null) {
			this.setBc76Objective(bodyChartExaminationEntityDto.getBc76Objective());
		}

		if (bodyChartExaminationEntityDto.getBc77Subjective() != null) {
			this.setBc77Subjective(bodyChartExaminationEntityDto.getBc77Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc77Objective() != null) {
			this.setBc77Objective(bodyChartExaminationEntityDto.getBc77Objective());
		}

		if (bodyChartExaminationEntityDto.getBc78Subjective() != null) {
			this.setBc78Subjective(bodyChartExaminationEntityDto.getBc78Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc78Objective() != null) {
			this.setBc78Objective(bodyChartExaminationEntityDto.getBc78Objective());
		}

		if (bodyChartExaminationEntityDto.getBc79Subjective() != null) {
			this.setBc79Subjective(bodyChartExaminationEntityDto.getBc79Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc79Objective() != null) {
			this.setBc79Objective(bodyChartExaminationEntityDto.getBc79Objective());
		}

		if (bodyChartExaminationEntityDto.getBc80Subjective() != null) {
			this.setBc80Subjective(bodyChartExaminationEntityDto.getBc80Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc80Objective() != null) {
			this.setBc80Objective(bodyChartExaminationEntityDto.getBc80Objective());
		}

		if (bodyChartExaminationEntityDto.getBc81Subjective() != null) {
			this.setBc81Subjective(bodyChartExaminationEntityDto.getBc81Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc81Objective() != null) {
			this.setBc81Objective(bodyChartExaminationEntityDto.getBc81Objective());
		}

		if (bodyChartExaminationEntityDto.getBc82Subjective() != null) {
			this.setBc82Subjective(bodyChartExaminationEntityDto.getBc82Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc82Objective() != null) {
			this.setBc82Objective(bodyChartExaminationEntityDto.getBc82Objective());
		}

		if (bodyChartExaminationEntityDto.getBc83Subjective() != null) {
			this.setBc83Subjective(bodyChartExaminationEntityDto.getBc83Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc83Objective() != null) {
			this.setBc83Objective(bodyChartExaminationEntityDto.getBc83Objective());
		}

		if (bodyChartExaminationEntityDto.getBc84Subjective() != null) {
			this.setBc84Subjective(bodyChartExaminationEntityDto.getBc84Subjective());
		}

		if (bodyChartExaminationEntityDto.getBc84Objective() != null) {
			this.setBc84Objective(bodyChartExaminationEntityDto.getBc84Objective());
		}

		if (bodyChartExaminationEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(bodyChartExaminationEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for BC01 Subjective here] off begin
	@CsvBindByName(column = "BC01_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc01_subjective")
	@Schema(description = "The BC01 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC01 Subjective here] end
	private String bc01Subjective;

	// % protected region % [Modify attribute annotation for BC01 Objective here] off begin
	@CsvBindByName(column = "BC01_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc01_objective")
	@Schema(description = "The BC01 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC01 Objective here] end
	private String bc01Objective;

	// % protected region % [Modify attribute annotation for BC02 Subjective here] off begin
	@CsvBindByName(column = "BC02_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc02_subjective")
	@Schema(description = "The BC02 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC02 Subjective here] end
	private String bc02Subjective;

	// % protected region % [Modify attribute annotation for BC02 Objective here] off begin
	@CsvBindByName(column = "BC02_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc02_objective")
	@Schema(description = "The BC02 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC02 Objective here] end
	private String bc02Objective;

	// % protected region % [Modify attribute annotation for BC03 Subjective here] off begin
	@CsvBindByName(column = "BC03_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc03_subjective")
	@Schema(description = "The BC03 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC03 Subjective here] end
	private String bc03Subjective;

	// % protected region % [Modify attribute annotation for BC03 Objective here] off begin
	@CsvBindByName(column = "BC03_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc03_objective")
	@Schema(description = "The BC03 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC03 Objective here] end
	private String bc03Objective;

	// % protected region % [Modify attribute annotation for BC04 Subjective here] off begin
	@CsvBindByName(column = "BC04_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc04_subjective")
	@Schema(description = "The BC04 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC04 Subjective here] end
	private String bc04Subjective;

	// % protected region % [Modify attribute annotation for BC04 Objective here] off begin
	@CsvBindByName(column = "BC04_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc04_objective")
	@Schema(description = "The BC04 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC04 Objective here] end
	private String bc04Objective;

	// % protected region % [Modify attribute annotation for BC05 Subjective here] off begin
	@CsvBindByName(column = "BC05_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc05_subjective")
	@Schema(description = "The BC05 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC05 Subjective here] end
	private String bc05Subjective;

	// % protected region % [Modify attribute annotation for BC05 Objective here] off begin
	@CsvBindByName(column = "BC05_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc05_objective")
	@Schema(description = "The BC05 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC05 Objective here] end
	private String bc05Objective;

	// % protected region % [Modify attribute annotation for BC06 Subjective here] off begin
	@CsvBindByName(column = "BC06_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc06_subjective")
	@Schema(description = "The BC06 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC06 Subjective here] end
	private String bc06Subjective;

	// % protected region % [Modify attribute annotation for BC06 Objective here] off begin
	@CsvBindByName(column = "BC06_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc06_objective")
	@Schema(description = "The BC06 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC06 Objective here] end
	private String bc06Objective;

	// % protected region % [Modify attribute annotation for BC07 Subjective here] off begin
	@CsvBindByName(column = "BC07_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc07_subjective")
	@Schema(description = "The BC07 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC07 Subjective here] end
	private String bc07Subjective;

	// % protected region % [Modify attribute annotation for BC07 Objective here] off begin
	@CsvBindByName(column = "BC07_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc07_objective")
	@Schema(description = "The BC07 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC07 Objective here] end
	private String bc07Objective;

	// % protected region % [Modify attribute annotation for BC08 Subjective here] off begin
	@CsvBindByName(column = "BC08_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc08_subjective")
	@Schema(description = "The BC08 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC08 Subjective here] end
	private String bc08Subjective;

	// % protected region % [Modify attribute annotation for BC08 Objective here] off begin
	@CsvBindByName(column = "BC08_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc08_objective")
	@Schema(description = "The BC08 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC08 Objective here] end
	private String bc08Objective;

	// % protected region % [Modify attribute annotation for BC09 Subjective here] off begin
	@CsvBindByName(column = "BC09_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc09_subjective")
	@Schema(description = "The BC09 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC09 Subjective here] end
	private String bc09Subjective;

	// % protected region % [Modify attribute annotation for BC09 Objective here] off begin
	@CsvBindByName(column = "BC09_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc09_objective")
	@Schema(description = "The BC09 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC09 Objective here] end
	private String bc09Objective;

	// % protected region % [Modify attribute annotation for BC10 Subjective here] off begin
	@CsvBindByName(column = "BC10_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc10_subjective")
	@Schema(description = "The BC10 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC10 Subjective here] end
	private String bc10Subjective;

	// % protected region % [Modify attribute annotation for BC10 Objective here] off begin
	@CsvBindByName(column = "BC10_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc10_objective")
	@Schema(description = "The BC10 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC10 Objective here] end
	private String bc10Objective;

	// % protected region % [Modify attribute annotation for BC11 Subjective here] off begin
	@CsvBindByName(column = "BC11_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc11_subjective")
	@Schema(description = "The BC11 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC11 Subjective here] end
	private String bc11Subjective;

	// % protected region % [Modify attribute annotation for BC11 Objective here] off begin
	@CsvBindByName(column = "BC11_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc11_objective")
	@Schema(description = "The BC11 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC11 Objective here] end
	private String bc11Objective;

	// % protected region % [Modify attribute annotation for BC12 Subjective here] off begin
	@CsvBindByName(column = "BC12_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc12_subjective")
	@Schema(description = "The BC12 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC12 Subjective here] end
	private String bc12Subjective;

	// % protected region % [Modify attribute annotation for BC12 Objective here] off begin
	@CsvBindByName(column = "BC12_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc12_objective")
	@Schema(description = "The BC12 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC12 Objective here] end
	private String bc12Objective;

	// % protected region % [Modify attribute annotation for BC13 Subjective here] off begin
	@CsvBindByName(column = "BC13_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc13_subjective")
	@Schema(description = "The BC13 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC13 Subjective here] end
	private String bc13Subjective;

	// % protected region % [Modify attribute annotation for BC13 Objective here] off begin
	@CsvBindByName(column = "BC13_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc13_objective")
	@Schema(description = "The BC13 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC13 Objective here] end
	private String bc13Objective;

	// % protected region % [Modify attribute annotation for BC14 Subjective here] off begin
	@CsvBindByName(column = "BC14_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc14_subjective")
	@Schema(description = "The BC14 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC14 Subjective here] end
	private String bc14Subjective;

	// % protected region % [Modify attribute annotation for BC14 Objective here] off begin
	@CsvBindByName(column = "BC14_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc14_objective")
	@Schema(description = "The BC14 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC14 Objective here] end
	private String bc14Objective;

	// % protected region % [Modify attribute annotation for BC15 Subjective here] off begin
	@CsvBindByName(column = "BC15_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc15_subjective")
	@Schema(description = "The BC15 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC15 Subjective here] end
	private String bc15Subjective;

	// % protected region % [Modify attribute annotation for BC15 Objective here] off begin
	@CsvBindByName(column = "BC15_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc15_objective")
	@Schema(description = "The BC15 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC15 Objective here] end
	private String bc15Objective;

	// % protected region % [Modify attribute annotation for BC16 Subjective here] off begin
	@CsvBindByName(column = "BC16_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc16_subjective")
	@Schema(description = "The BC16 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC16 Subjective here] end
	private String bc16Subjective;

	// % protected region % [Modify attribute annotation for BC16 Objective here] off begin
	@CsvBindByName(column = "BC16_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc16_objective")
	@Schema(description = "The BC16 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC16 Objective here] end
	private String bc16Objective;

	// % protected region % [Modify attribute annotation for BC17 Subjective here] off begin
	@CsvBindByName(column = "BC17_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc17_subjective")
	@Schema(description = "The BC17 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC17 Subjective here] end
	private String bc17Subjective;

	// % protected region % [Modify attribute annotation for BC17 Objective here] off begin
	@CsvBindByName(column = "BC17_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc17_objective")
	@Schema(description = "The BC17 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC17 Objective here] end
	private String bc17Objective;

	// % protected region % [Modify attribute annotation for BC18 Subjective here] off begin
	@CsvBindByName(column = "BC18_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc18_subjective")
	@Schema(description = "The BC18 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC18 Subjective here] end
	private String bc18Subjective;

	// % protected region % [Modify attribute annotation for BC18 Objective here] off begin
	@CsvBindByName(column = "BC18_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc18_objective")
	@Schema(description = "The BC18 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC18 Objective here] end
	private String bc18Objective;

	// % protected region % [Modify attribute annotation for BC19 Subjective here] off begin
	@CsvBindByName(column = "BC19_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc19_subjective")
	@Schema(description = "The BC19 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC19 Subjective here] end
	private String bc19Subjective;

	// % protected region % [Modify attribute annotation for BC19 Objective here] off begin
	@CsvBindByName(column = "BC19_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc19_objective")
	@Schema(description = "The BC19 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC19 Objective here] end
	private String bc19Objective;

	// % protected region % [Modify attribute annotation for BC20 Subjective here] off begin
	@CsvBindByName(column = "BC20_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc20_subjective")
	@Schema(description = "The BC20 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC20 Subjective here] end
	private String bc20Subjective;

	// % protected region % [Modify attribute annotation for BC20 Objective here] off begin
	@CsvBindByName(column = "BC20_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc20_objective")
	@Schema(description = "The BC20 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC20 Objective here] end
	private String bc20Objective;

	// % protected region % [Modify attribute annotation for BC21 Subjective here] off begin
	@CsvBindByName(column = "BC21_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc21_subjective")
	@Schema(description = "The BC21 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC21 Subjective here] end
	private String bc21Subjective;

	// % protected region % [Modify attribute annotation for BC21 Objective here] off begin
	@CsvBindByName(column = "BC21_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc21_objective")
	@Schema(description = "The BC21 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC21 Objective here] end
	private String bc21Objective;

	// % protected region % [Modify attribute annotation for BC22 Subjective here] off begin
	@CsvBindByName(column = "BC22_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc22_subjective")
	@Schema(description = "The BC22 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC22 Subjective here] end
	private String bc22Subjective;

	// % protected region % [Modify attribute annotation for BC22 Objective here] off begin
	@CsvBindByName(column = "BC22_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc22_objective")
	@Schema(description = "The BC22 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC22 Objective here] end
	private String bc22Objective;

	// % protected region % [Modify attribute annotation for BC23 Subjective here] off begin
	@CsvBindByName(column = "BC23_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc23_subjective")
	@Schema(description = "The BC23 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC23 Subjective here] end
	private String bc23Subjective;

	// % protected region % [Modify attribute annotation for BC23 Objective here] off begin
	@CsvBindByName(column = "BC23_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc23_objective")
	@Schema(description = "The BC23 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC23 Objective here] end
	private String bc23Objective;

	// % protected region % [Modify attribute annotation for BC24 Subjective here] off begin
	@CsvBindByName(column = "BC24_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc24_subjective")
	@Schema(description = "The BC24 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC24 Subjective here] end
	private String bc24Subjective;

	// % protected region % [Modify attribute annotation for BC24 Objective here] off begin
	@CsvBindByName(column = "BC24_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc24_objective")
	@Schema(description = "The BC24 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC24 Objective here] end
	private String bc24Objective;

	// % protected region % [Modify attribute annotation for BC25 Subjective here] off begin
	@CsvBindByName(column = "BC25_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc25_subjective")
	@Schema(description = "The BC25 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC25 Subjective here] end
	private String bc25Subjective;

	// % protected region % [Modify attribute annotation for BC25 Objective here] off begin
	@CsvBindByName(column = "BC25_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc25_objective")
	@Schema(description = "The BC25 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC25 Objective here] end
	private String bc25Objective;

	// % protected region % [Modify attribute annotation for BC26 Subjective here] off begin
	@CsvBindByName(column = "BC26_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc26_subjective")
	@Schema(description = "The BC26 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC26 Subjective here] end
	private String bc26Subjective;

	// % protected region % [Modify attribute annotation for BC26 Objective here] off begin
	@CsvBindByName(column = "BC26_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc26_objective")
	@Schema(description = "The BC26 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC26 Objective here] end
	private String bc26Objective;

	// % protected region % [Modify attribute annotation for BC27 Subjective here] off begin
	@CsvBindByName(column = "BC27_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc27_subjective")
	@Schema(description = "The BC27 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC27 Subjective here] end
	private String bc27Subjective;

	// % protected region % [Modify attribute annotation for BC27 Objective here] off begin
	@CsvBindByName(column = "BC27_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc27_objective")
	@Schema(description = "The BC27 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC27 Objective here] end
	private String bc27Objective;

	// % protected region % [Modify attribute annotation for BC28 Subjective here] off begin
	@CsvBindByName(column = "BC28_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc28_subjective")
	@Schema(description = "The BC28 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC28 Subjective here] end
	private String bc28Subjective;

	// % protected region % [Modify attribute annotation for BC28 Objective here] off begin
	@CsvBindByName(column = "BC28_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc28_objective")
	@Schema(description = "The BC28 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC28 Objective here] end
	private String bc28Objective;

	// % protected region % [Modify attribute annotation for BC29 Subjective here] off begin
	@CsvBindByName(column = "BC29_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc29_subjective")
	@Schema(description = "The BC29 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC29 Subjective here] end
	private String bc29Subjective;

	// % protected region % [Modify attribute annotation for BC29 Objective here] off begin
	@CsvBindByName(column = "BC29_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc29_objective")
	@Schema(description = "The BC29 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC29 Objective here] end
	private String bc29Objective;

	// % protected region % [Modify attribute annotation for BC30 Subjective here] off begin
	@CsvBindByName(column = "BC30_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc30_subjective")
	@Schema(description = "The BC30 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC30 Subjective here] end
	private String bc30Subjective;

	// % protected region % [Modify attribute annotation for BC30 Objective here] off begin
	@CsvBindByName(column = "BC30_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc30_objective")
	@Schema(description = "The BC30 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC30 Objective here] end
	private String bc30Objective;

	// % protected region % [Modify attribute annotation for BC31 Subjective here] off begin
	@CsvBindByName(column = "BC31_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc31_subjective")
	@Schema(description = "The BC31 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC31 Subjective here] end
	private String bc31Subjective;

	// % protected region % [Modify attribute annotation for BC31 Objective here] off begin
	@CsvBindByName(column = "BC31_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc31_objective")
	@Schema(description = "The BC31 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC31 Objective here] end
	private String bc31Objective;

	// % protected region % [Modify attribute annotation for BC32 Subjective here] off begin
	@CsvBindByName(column = "BC32_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc32_subjective")
	@Schema(description = "The BC32 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC32 Subjective here] end
	private String bc32Subjective;

	// % protected region % [Modify attribute annotation for BC32 Objective here] off begin
	@CsvBindByName(column = "BC32_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc32_objective")
	@Schema(description = "The BC32 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC32 Objective here] end
	private String bc32Objective;

	// % protected region % [Modify attribute annotation for BC33 Subjective here] off begin
	@CsvBindByName(column = "BC33_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc33_subjective")
	@Schema(description = "The BC33 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC33 Subjective here] end
	private String bc33Subjective;

	// % protected region % [Modify attribute annotation for BC33 Objective here] off begin
	@CsvBindByName(column = "BC33_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc33_objective")
	@Schema(description = "The BC33 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC33 Objective here] end
	private String bc33Objective;

	// % protected region % [Modify attribute annotation for BC34 Subjective here] off begin
	@CsvBindByName(column = "BC34_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc34_subjective")
	@Schema(description = "The BC34 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC34 Subjective here] end
	private String bc34Subjective;

	// % protected region % [Modify attribute annotation for BC34 Objective here] off begin
	@CsvBindByName(column = "BC34_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc34_objective")
	@Schema(description = "The BC34 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC34 Objective here] end
	private String bc34Objective;

	// % protected region % [Modify attribute annotation for BC35 Subjective here] off begin
	@CsvBindByName(column = "BC35_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc35_subjective")
	@Schema(description = "The BC35 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC35 Subjective here] end
	private String bc35Subjective;

	// % protected region % [Modify attribute annotation for BC35 Objective here] off begin
	@CsvBindByName(column = "BC35_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc35_objective")
	@Schema(description = "The BC35 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC35 Objective here] end
	private String bc35Objective;

	// % protected region % [Modify attribute annotation for BC36 Subjective here] off begin
	@CsvBindByName(column = "BC36_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc36_subjective")
	@Schema(description = "The BC36 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC36 Subjective here] end
	private String bc36Subjective;

	// % protected region % [Modify attribute annotation for BC36 Objective here] off begin
	@CsvBindByName(column = "BC36_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc36_objective")
	@Schema(description = "The BC36 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC36 Objective here] end
	private String bc36Objective;

	// % protected region % [Modify attribute annotation for BC37 Subjective here] off begin
	@CsvBindByName(column = "BC37_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc37_subjective")
	@Schema(description = "The BC37 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC37 Subjective here] end
	private String bc37Subjective;

	// % protected region % [Modify attribute annotation for BC37 Objective here] off begin
	@CsvBindByName(column = "BC37_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc37_objective")
	@Schema(description = "The BC37 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC37 Objective here] end
	private String bc37Objective;

	// % protected region % [Modify attribute annotation for BC38 Subjective here] off begin
	@CsvBindByName(column = "BC38_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc38_subjective")
	@Schema(description = "The BC38 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC38 Subjective here] end
	private String bc38Subjective;

	// % protected region % [Modify attribute annotation for BC38 Objective here] off begin
	@CsvBindByName(column = "BC38_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc38_objective")
	@Schema(description = "The BC38 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC38 Objective here] end
	private String bc38Objective;

	// % protected region % [Modify attribute annotation for BC39 Subjective here] off begin
	@CsvBindByName(column = "BC39_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc39_subjective")
	@Schema(description = "The BC39 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC39 Subjective here] end
	private String bc39Subjective;

	// % protected region % [Modify attribute annotation for BC39 Objective here] off begin
	@CsvBindByName(column = "BC39_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc39_objective")
	@Schema(description = "The BC39 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC39 Objective here] end
	private String bc39Objective;

	// % protected region % [Modify attribute annotation for BC40 Subjective here] off begin
	@CsvBindByName(column = "BC40_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc40_subjective")
	@Schema(description = "The BC40 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC40 Subjective here] end
	private String bc40Subjective;

	// % protected region % [Modify attribute annotation for BC40 Objective here] off begin
	@CsvBindByName(column = "BC40_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc40_objective")
	@Schema(description = "The BC40 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC40 Objective here] end
	private String bc40Objective;

	// % protected region % [Modify attribute annotation for BC41 Subjective here] off begin
	@CsvBindByName(column = "BC41_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc41_subjective")
	@Schema(description = "The BC41 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC41 Subjective here] end
	private String bc41Subjective;

	// % protected region % [Modify attribute annotation for BC41 Objective here] off begin
	@CsvBindByName(column = "BC41_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc41_objective")
	@Schema(description = "The BC41 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC41 Objective here] end
	private String bc41Objective;

	// % protected region % [Modify attribute annotation for BC42 Subjective here] off begin
	@CsvBindByName(column = "BC42_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc42_subjective")
	@Schema(description = "The BC42 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC42 Subjective here] end
	private String bc42Subjective;

	// % protected region % [Modify attribute annotation for BC42 Objective here] off begin
	@CsvBindByName(column = "BC42_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc42_objective")
	@Schema(description = "The BC42 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC42 Objective here] end
	private String bc42Objective;

	// % protected region % [Modify attribute annotation for BC43 Subjective here] off begin
	@CsvBindByName(column = "BC43_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc43_subjective")
	@Schema(description = "The BC43 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC43 Subjective here] end
	private String bc43Subjective;

	// % protected region % [Modify attribute annotation for BC43 Objective here] off begin
	@CsvBindByName(column = "BC43_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc43_objective")
	@Schema(description = "The BC43 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC43 Objective here] end
	private String bc43Objective;

	// % protected region % [Modify attribute annotation for BC44 Subjective here] off begin
	@CsvBindByName(column = "BC44_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc44_subjective")
	@Schema(description = "The BC44 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC44 Subjective here] end
	private String bc44Subjective;

	// % protected region % [Modify attribute annotation for BC44 Objective here] off begin
	@CsvBindByName(column = "BC44_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc44_objective")
	@Schema(description = "The BC44 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC44 Objective here] end
	private String bc44Objective;

	// % protected region % [Modify attribute annotation for BC45 Subjective here] off begin
	@CsvBindByName(column = "BC45_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc45_subjective")
	@Schema(description = "The BC45 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC45 Subjective here] end
	private String bc45Subjective;

	// % protected region % [Modify attribute annotation for BC45 Objective here] off begin
	@CsvBindByName(column = "BC45_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc45_objective")
	@Schema(description = "The BC45 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC45 Objective here] end
	private String bc45Objective;

	// % protected region % [Modify attribute annotation for BC46 Subjective here] off begin
	@CsvBindByName(column = "BC46_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc46_subjective")
	@Schema(description = "The BC46 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC46 Subjective here] end
	private String bc46Subjective;

	// % protected region % [Modify attribute annotation for BC46 Objective here] off begin
	@CsvBindByName(column = "BC46_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc46_objective")
	@Schema(description = "The BC46 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC46 Objective here] end
	private String bc46Objective;

	// % protected region % [Modify attribute annotation for BC47 Subjective here] off begin
	@CsvBindByName(column = "BC47_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc47_subjective")
	@Schema(description = "The BC47 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC47 Subjective here] end
	private String bc47Subjective;

	// % protected region % [Modify attribute annotation for BC47 Objective here] off begin
	@CsvBindByName(column = "BC47_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc47_objective")
	@Schema(description = "The BC47 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC47 Objective here] end
	private String bc47Objective;

	// % protected region % [Modify attribute annotation for BC48 Subjective here] off begin
	@CsvBindByName(column = "BC48_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc48_subjective")
	@Schema(description = "The BC48 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC48 Subjective here] end
	private String bc48Subjective;

	// % protected region % [Modify attribute annotation for BC48 Objective here] off begin
	@CsvBindByName(column = "BC48_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc48_objective")
	@Schema(description = "The BC48 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC48 Objective here] end
	private String bc48Objective;

	// % protected region % [Modify attribute annotation for BC49 Subjective here] off begin
	@CsvBindByName(column = "BC49_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc49_subjective")
	@Schema(description = "The BC49 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC49 Subjective here] end
	private String bc49Subjective;

	// % protected region % [Modify attribute annotation for BC49 Objective here] off begin
	@CsvBindByName(column = "BC49_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc49_objective")
	@Schema(description = "The BC49 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC49 Objective here] end
	private String bc49Objective;

	// % protected region % [Modify attribute annotation for BC50 Subjective here] off begin
	@CsvBindByName(column = "BC50_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc50_subjective")
	@Schema(description = "The BC50 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC50 Subjective here] end
	private String bc50Subjective;

	// % protected region % [Modify attribute annotation for BC50 Objective here] off begin
	@CsvBindByName(column = "BC50_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc50_objective")
	@Schema(description = "The BC50 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC50 Objective here] end
	private String bc50Objective;

	// % protected region % [Modify attribute annotation for BC51 Subjective here] off begin
	@CsvBindByName(column = "BC51_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc51_subjective")
	@Schema(description = "The BC51 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC51 Subjective here] end
	private String bc51Subjective;

	// % protected region % [Modify attribute annotation for BC51 Objective here] off begin
	@CsvBindByName(column = "BC51_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc51_objective")
	@Schema(description = "The BC51 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC51 Objective here] end
	private String bc51Objective;

	// % protected region % [Modify attribute annotation for BC52 Subjective here] off begin
	@CsvBindByName(column = "BC52_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc52_subjective")
	@Schema(description = "The BC52 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC52 Subjective here] end
	private String bc52Subjective;

	// % protected region % [Modify attribute annotation for BC52 Objective here] off begin
	@CsvBindByName(column = "BC52_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc52_objective")
	@Schema(description = "The BC52 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC52 Objective here] end
	private String bc52Objective;

	// % protected region % [Modify attribute annotation for BC53 Subjective here] off begin
	@CsvBindByName(column = "BC53_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc53_subjective")
	@Schema(description = "The BC53 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC53 Subjective here] end
	private String bc53Subjective;

	// % protected region % [Modify attribute annotation for BC53 Objective here] off begin
	@CsvBindByName(column = "BC53_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc53_objective")
	@Schema(description = "The BC53 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC53 Objective here] end
	private String bc53Objective;

	// % protected region % [Modify attribute annotation for BC54 Subjective here] off begin
	@CsvBindByName(column = "BC54_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc54_subjective")
	@Schema(description = "The BC54 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC54 Subjective here] end
	private String bc54Subjective;

	// % protected region % [Modify attribute annotation for BC54 Objective here] off begin
	@CsvBindByName(column = "BC54_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc54_objective")
	@Schema(description = "The BC54 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC54 Objective here] end
	private String bc54Objective;

	// % protected region % [Modify attribute annotation for BC55 Subjective here] off begin
	@CsvBindByName(column = "BC55_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc55_subjective")
	@Schema(description = "The BC55 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC55 Subjective here] end
	private String bc55Subjective;

	// % protected region % [Modify attribute annotation for BC55 Objective here] off begin
	@CsvBindByName(column = "BC55_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc55_objective")
	@Schema(description = "The BC55 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC55 Objective here] end
	private String bc55Objective;

	// % protected region % [Modify attribute annotation for BC56 Subjective here] off begin
	@CsvBindByName(column = "BC56_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc56_subjective")
	@Schema(description = "The BC56 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC56 Subjective here] end
	private String bc56Subjective;

	// % protected region % [Modify attribute annotation for BC56 Objective here] off begin
	@CsvBindByName(column = "BC56_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc56_objective")
	@Schema(description = "The BC56 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC56 Objective here] end
	private String bc56Objective;

	// % protected region % [Modify attribute annotation for BC57 Subjective here] off begin
	@CsvBindByName(column = "BC57_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc57_subjective")
	@Schema(description = "The BC57 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC57 Subjective here] end
	private String bc57Subjective;

	// % protected region % [Modify attribute annotation for BC57 Objective here] off begin
	@CsvBindByName(column = "BC57_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc57_objective")
	@Schema(description = "The BC57 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC57 Objective here] end
	private String bc57Objective;

	// % protected region % [Modify attribute annotation for BC58 Subjective here] off begin
	@CsvBindByName(column = "BC58_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc58_subjective")
	@Schema(description = "The BC58 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC58 Subjective here] end
	private String bc58Subjective;

	// % protected region % [Modify attribute annotation for BC58 Objective here] off begin
	@CsvBindByName(column = "BC58_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc58_objective")
	@Schema(description = "The BC58 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC58 Objective here] end
	private String bc58Objective;

	// % protected region % [Modify attribute annotation for BC59 Subjective here] off begin
	@CsvBindByName(column = "BC59_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc59_subjective")
	@Schema(description = "The BC59 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC59 Subjective here] end
	private String bc59Subjective;

	// % protected region % [Modify attribute annotation for BC59 Objective here] off begin
	@CsvBindByName(column = "BC59_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc59_objective")
	@Schema(description = "The BC59 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC59 Objective here] end
	private String bc59Objective;

	// % protected region % [Modify attribute annotation for BC60 Subjective here] off begin
	@CsvBindByName(column = "BC60_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc60_subjective")
	@Schema(description = "The BC60 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC60 Subjective here] end
	private String bc60Subjective;

	// % protected region % [Modify attribute annotation for BC60 Objective here] off begin
	@CsvBindByName(column = "BC60_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc60_objective")
	@Schema(description = "The BC60 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC60 Objective here] end
	private String bc60Objective;

	// % protected region % [Modify attribute annotation for BC61 Subjective here] off begin
	@CsvBindByName(column = "BC61_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc61_subjective")
	@Schema(description = "The BC61 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC61 Subjective here] end
	private String bc61Subjective;

	// % protected region % [Modify attribute annotation for BC61 Objective here] off begin
	@CsvBindByName(column = "BC61_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc61_objective")
	@Schema(description = "The BC61 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC61 Objective here] end
	private String bc61Objective;

	// % protected region % [Modify attribute annotation for BC62 Subjective here] off begin
	@CsvBindByName(column = "BC62_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc62_subjective")
	@Schema(description = "The BC62 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC62 Subjective here] end
	private String bc62Subjective;

	// % protected region % [Modify attribute annotation for BC62 Objective here] off begin
	@CsvBindByName(column = "BC62_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc62_objective")
	@Schema(description = "The BC62 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC62 Objective here] end
	private String bc62Objective;

	// % protected region % [Modify attribute annotation for BC63 Subjective here] off begin
	@CsvBindByName(column = "BC63_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc63_subjective")
	@Schema(description = "The BC63 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC63 Subjective here] end
	private String bc63Subjective;

	// % protected region % [Modify attribute annotation for BC63 Objective here] off begin
	@CsvBindByName(column = "BC63_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc63_objective")
	@Schema(description = "The BC63 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC63 Objective here] end
	private String bc63Objective;

	// % protected region % [Modify attribute annotation for BC64 Subjective here] off begin
	@CsvBindByName(column = "BC64_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc64_subjective")
	@Schema(description = "The BC64 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC64 Subjective here] end
	private String bc64Subjective;

	// % protected region % [Modify attribute annotation for BC64 Objective here] off begin
	@CsvBindByName(column = "BC64_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc64_objective")
	@Schema(description = "The BC64 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC64 Objective here] end
	private String bc64Objective;

	// % protected region % [Modify attribute annotation for BC65 Subjective here] off begin
	@CsvBindByName(column = "BC65_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc65_subjective")
	@Schema(description = "The BC65 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC65 Subjective here] end
	private String bc65Subjective;

	// % protected region % [Modify attribute annotation for BC65 Objective here] off begin
	@CsvBindByName(column = "BC65_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc65_objective")
	@Schema(description = "The BC65 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC65 Objective here] end
	private String bc65Objective;

	// % protected region % [Modify attribute annotation for BC66 Subjective here] off begin
	@CsvBindByName(column = "BC66_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc66_subjective")
	@Schema(description = "The BC66 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC66 Subjective here] end
	private String bc66Subjective;

	// % protected region % [Modify attribute annotation for BC66 Objective here] off begin
	@CsvBindByName(column = "BC66_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc66_objective")
	@Schema(description = "The BC66 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC66 Objective here] end
	private String bc66Objective;

	// % protected region % [Modify attribute annotation for BC67 Subjective here] off begin
	@CsvBindByName(column = "BC67_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc67_subjective")
	@Schema(description = "The BC67 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC67 Subjective here] end
	private String bc67Subjective;

	// % protected region % [Modify attribute annotation for BC67 Objective here] off begin
	@CsvBindByName(column = "BC67_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc67_objective")
	@Schema(description = "The BC67 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC67 Objective here] end
	private String bc67Objective;

	// % protected region % [Modify attribute annotation for BC68 Subjective here] off begin
	@CsvBindByName(column = "BC68_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc68_subjective")
	@Schema(description = "The BC68 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC68 Subjective here] end
	private String bc68Subjective;

	// % protected region % [Modify attribute annotation for BC68 Objective here] off begin
	@CsvBindByName(column = "BC68_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc68_objective")
	@Schema(description = "The BC68 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC68 Objective here] end
	private String bc68Objective;

	// % protected region % [Modify attribute annotation for BC69 Subjective here] off begin
	@CsvBindByName(column = "BC69_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc69_subjective")
	@Schema(description = "The BC69 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC69 Subjective here] end
	private String bc69Subjective;

	// % protected region % [Modify attribute annotation for BC69 Objective here] off begin
	@CsvBindByName(column = "BC69_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc69_objective")
	@Schema(description = "The BC69 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC69 Objective here] end
	private String bc69Objective;

	// % protected region % [Modify attribute annotation for BC70 Subjective here] off begin
	@CsvBindByName(column = "BC70_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc70_subjective")
	@Schema(description = "The BC70 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC70 Subjective here] end
	private String bc70Subjective;

	// % protected region % [Modify attribute annotation for BC70 Objective here] off begin
	@CsvBindByName(column = "BC70_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc70_objective")
	@Schema(description = "The BC70 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC70 Objective here] end
	private String bc70Objective;

	// % protected region % [Modify attribute annotation for BC71 Subjective here] off begin
	@CsvBindByName(column = "BC71_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc71_subjective")
	@Schema(description = "The BC71 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC71 Subjective here] end
	private String bc71Subjective;

	// % protected region % [Modify attribute annotation for BC71 Objective here] off begin
	@CsvBindByName(column = "BC71_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc71_objective")
	@Schema(description = "The BC71 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC71 Objective here] end
	private String bc71Objective;

	// % protected region % [Modify attribute annotation for BC72 Subjective here] off begin
	@CsvBindByName(column = "BC72_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc72_subjective")
	@Schema(description = "The BC72 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC72 Subjective here] end
	private String bc72Subjective;

	// % protected region % [Modify attribute annotation for BC72 Objective here] off begin
	@CsvBindByName(column = "BC72_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc72_objective")
	@Schema(description = "The BC72 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC72 Objective here] end
	private String bc72Objective;

	// % protected region % [Modify attribute annotation for BC73 Subjective here] off begin
	@CsvBindByName(column = "BC73_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc73_subjective")
	@Schema(description = "The BC73 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC73 Subjective here] end
	private String bc73Subjective;

	// % protected region % [Modify attribute annotation for BC73 Objective here] off begin
	@CsvBindByName(column = "BC73_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc73_objective")
	@Schema(description = "The BC73 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC73 Objective here] end
	private String bc73Objective;

	// % protected region % [Modify attribute annotation for BC74 Subjective here] off begin
	@CsvBindByName(column = "BC74_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc74_subjective")
	@Schema(description = "The BC74 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC74 Subjective here] end
	private String bc74Subjective;

	// % protected region % [Modify attribute annotation for BC74 Objective here] off begin
	@CsvBindByName(column = "BC74_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc74_objective")
	@Schema(description = "The BC74 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC74 Objective here] end
	private String bc74Objective;

	// % protected region % [Modify attribute annotation for BC75 Subjective here] off begin
	@CsvBindByName(column = "BC75_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc75_subjective")
	@Schema(description = "The BC75 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC75 Subjective here] end
	private String bc75Subjective;

	// % protected region % [Modify attribute annotation for BC75 Objective here] off begin
	@CsvBindByName(column = "BC75_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc75_objective")
	@Schema(description = "The BC75 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC75 Objective here] end
	private String bc75Objective;

	// % protected region % [Modify attribute annotation for BC76 Subjective here] off begin
	@CsvBindByName(column = "BC76_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc76_subjective")
	@Schema(description = "The BC76 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC76 Subjective here] end
	private String bc76Subjective;

	// % protected region % [Modify attribute annotation for BC76 Objective here] off begin
	@CsvBindByName(column = "BC76_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc76_objective")
	@Schema(description = "The BC76 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC76 Objective here] end
	private String bc76Objective;

	// % protected region % [Modify attribute annotation for BC77 Subjective here] off begin
	@CsvBindByName(column = "BC77_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc77_subjective")
	@Schema(description = "The BC77 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC77 Subjective here] end
	private String bc77Subjective;

	// % protected region % [Modify attribute annotation for BC77 Objective here] off begin
	@CsvBindByName(column = "BC77_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc77_objective")
	@Schema(description = "The BC77 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC77 Objective here] end
	private String bc77Objective;

	// % protected region % [Modify attribute annotation for BC78 Subjective here] off begin
	@CsvBindByName(column = "BC78_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc78_subjective")
	@Schema(description = "The BC78 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC78 Subjective here] end
	private String bc78Subjective;

	// % protected region % [Modify attribute annotation for BC78 Objective here] off begin
	@CsvBindByName(column = "BC78_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc78_objective")
	@Schema(description = "The BC78 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC78 Objective here] end
	private String bc78Objective;

	// % protected region % [Modify attribute annotation for BC79 Subjective here] off begin
	@CsvBindByName(column = "BC79_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc79_subjective")
	@Schema(description = "The BC79 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC79 Subjective here] end
	private String bc79Subjective;

	// % protected region % [Modify attribute annotation for BC79 Objective here] off begin
	@CsvBindByName(column = "BC79_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc79_objective")
	@Schema(description = "The BC79 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC79 Objective here] end
	private String bc79Objective;

	// % protected region % [Modify attribute annotation for BC80 Subjective here] off begin
	@CsvBindByName(column = "BC80_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc80_subjective")
	@Schema(description = "The BC80 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC80 Subjective here] end
	private String bc80Subjective;

	// % protected region % [Modify attribute annotation for BC80 Objective here] off begin
	@CsvBindByName(column = "BC80_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc80_objective")
	@Schema(description = "The BC80 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC80 Objective here] end
	private String bc80Objective;

	// % protected region % [Modify attribute annotation for BC81 Subjective here] off begin
	@CsvBindByName(column = "BC81_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc81_subjective")
	@Schema(description = "The BC81 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC81 Subjective here] end
	private String bc81Subjective;

	// % protected region % [Modify attribute annotation for BC81 Objective here] off begin
	@CsvBindByName(column = "BC81_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc81_objective")
	@Schema(description = "The BC81 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC81 Objective here] end
	private String bc81Objective;

	// % protected region % [Modify attribute annotation for BC82 Subjective here] off begin
	@CsvBindByName(column = "BC82_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc82_subjective")
	@Schema(description = "The BC82 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC82 Subjective here] end
	private String bc82Subjective;

	// % protected region % [Modify attribute annotation for BC82 Objective here] off begin
	@CsvBindByName(column = "BC82_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc82_objective")
	@Schema(description = "The BC82 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC82 Objective here] end
	private String bc82Objective;

	// % protected region % [Modify attribute annotation for BC83 Subjective here] off begin
	@CsvBindByName(column = "BC83_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc83_subjective")
	@Schema(description = "The BC83 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC83 Subjective here] end
	private String bc83Subjective;

	// % protected region % [Modify attribute annotation for BC83 Objective here] off begin
	@CsvBindByName(column = "BC83_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc83_objective")
	@Schema(description = "The BC83 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC83 Objective here] end
	private String bc83Objective;

	// % protected region % [Modify attribute annotation for BC84 Subjective here] off begin
	@CsvBindByName(column = "BC84_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc84_subjective")
	@Schema(description = "The BC84 Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC84 Subjective here] end
	private String bc84Subjective;

	// % protected region % [Modify attribute annotation for BC84 Objective here] off begin
	@CsvBindByName(column = "BC84_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "bc84_objective")
	@Schema(description = "The BC84 Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BC84 Objective here] end
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "BC01_SUBJECTIVE,BC01_OBJECTIVE,BC02_SUBJECTIVE,BC02_OBJECTIVE,BC03_SUBJECTIVE,BC03_OBJECTIVE,BC04_SUBJECTIVE,BC04_OBJECTIVE,BC05_SUBJECTIVE,BC05_OBJECTIVE,BC06_SUBJECTIVE,BC06_OBJECTIVE,BC07_SUBJECTIVE,BC07_OBJECTIVE,BC08_SUBJECTIVE,BC08_OBJECTIVE,BC09_SUBJECTIVE,BC09_OBJECTIVE,BC10_SUBJECTIVE,BC10_OBJECTIVE,BC11_SUBJECTIVE,BC11_OBJECTIVE,BC12_SUBJECTIVE,BC12_OBJECTIVE,BC13_SUBJECTIVE,BC13_OBJECTIVE,BC14_SUBJECTIVE,BC14_OBJECTIVE,BC15_SUBJECTIVE,BC15_OBJECTIVE,BC16_SUBJECTIVE,BC16_OBJECTIVE,BC17_SUBJECTIVE,BC17_OBJECTIVE,BC18_SUBJECTIVE,BC18_OBJECTIVE,BC19_SUBJECTIVE,BC19_OBJECTIVE,BC20_SUBJECTIVE,BC20_OBJECTIVE,BC21_SUBJECTIVE,BC21_OBJECTIVE,BC22_SUBJECTIVE,BC22_OBJECTIVE,BC23_SUBJECTIVE,BC23_OBJECTIVE,BC24_SUBJECTIVE,BC24_OBJECTIVE,BC25_SUBJECTIVE,BC25_OBJECTIVE,BC26_SUBJECTIVE,BC26_OBJECTIVE,BC27_SUBJECTIVE,BC27_OBJECTIVE,BC28_SUBJECTIVE,BC28_OBJECTIVE,BC29_SUBJECTIVE,BC29_OBJECTIVE,BC30_SUBJECTIVE,BC30_OBJECTIVE,BC31_SUBJECTIVE,BC31_OBJECTIVE,BC32_SUBJECTIVE,BC32_OBJECTIVE,BC33_SUBJECTIVE,BC33_OBJECTIVE,BC34_SUBJECTIVE,BC34_OBJECTIVE,BC35_SUBJECTIVE,BC35_OBJECTIVE,BC36_SUBJECTIVE,BC36_OBJECTIVE,BC37_SUBJECTIVE,BC37_OBJECTIVE,BC38_SUBJECTIVE,BC38_OBJECTIVE,BC39_SUBJECTIVE,BC39_OBJECTIVE,BC40_SUBJECTIVE,BC40_OBJECTIVE,BC41_SUBJECTIVE,BC41_OBJECTIVE,BC42_SUBJECTIVE,BC42_OBJECTIVE,BC43_SUBJECTIVE,BC43_OBJECTIVE,BC44_SUBJECTIVE,BC44_OBJECTIVE,BC45_SUBJECTIVE,BC45_OBJECTIVE,BC46_SUBJECTIVE,BC46_OBJECTIVE,BC47_SUBJECTIVE,BC47_OBJECTIVE,BC48_SUBJECTIVE,BC48_OBJECTIVE,BC49_SUBJECTIVE,BC49_OBJECTIVE,BC50_SUBJECTIVE,BC50_OBJECTIVE,BC51_SUBJECTIVE,BC51_OBJECTIVE,BC52_SUBJECTIVE,BC52_OBJECTIVE,BC53_SUBJECTIVE,BC53_OBJECTIVE,BC54_SUBJECTIVE,BC54_OBJECTIVE,BC55_SUBJECTIVE,BC55_OBJECTIVE,BC56_SUBJECTIVE,BC56_OBJECTIVE,BC57_SUBJECTIVE,BC57_OBJECTIVE,BC58_SUBJECTIVE,BC58_OBJECTIVE,BC59_SUBJECTIVE,BC59_OBJECTIVE,BC60_SUBJECTIVE,BC60_OBJECTIVE,BC61_SUBJECTIVE,BC61_OBJECTIVE,BC62_SUBJECTIVE,BC62_OBJECTIVE,BC63_SUBJECTIVE,BC63_OBJECTIVE,BC64_SUBJECTIVE,BC64_OBJECTIVE,BC65_SUBJECTIVE,BC65_OBJECTIVE,BC66_SUBJECTIVE,BC66_OBJECTIVE,BC67_SUBJECTIVE,BC67_OBJECTIVE,BC68_SUBJECTIVE,BC68_OBJECTIVE,BC69_SUBJECTIVE,BC69_OBJECTIVE,BC70_SUBJECTIVE,BC70_OBJECTIVE,BC71_SUBJECTIVE,BC71_OBJECTIVE,BC72_SUBJECTIVE,BC72_OBJECTIVE,BC73_SUBJECTIVE,BC73_OBJECTIVE,BC74_SUBJECTIVE,BC74_OBJECTIVE,BC75_SUBJECTIVE,BC75_OBJECTIVE,BC76_SUBJECTIVE,BC76_OBJECTIVE,BC77_SUBJECTIVE,BC77_OBJECTIVE,BC78_SUBJECTIVE,BC78_OBJECTIVE,BC79_SUBJECTIVE,BC79_OBJECTIVE,BC80_SUBJECTIVE,BC80_OBJECTIVE,BC81_SUBJECTIVE,BC81_OBJECTIVE,BC82_SUBJECTIVE,BC82_OBJECTIVE,BC83_SUBJECTIVE,BC83_OBJECTIVE,BC84_SUBJECTIVE,BC84_OBJECTIVE,MEDICAL_EXAMINATION_RECORD_ID,ID";
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
	public boolean equals(Object bodyChartExamination) {
		if (this == bodyChartExamination) {
			return true;
		}
		if (bodyChartExamination == null || this.getClass() != bodyChartExamination.getClass()) {
			return false;
		}
		if (!super.equals(bodyChartExamination)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BodyChartExaminationEntity that = (BodyChartExaminationEntity) bodyChartExamination;
		return
			Objects.equals(this.bc01Subjective, that.bc01Subjective) &&
			Objects.equals(this.bc01Objective, that.bc01Objective) &&
			Objects.equals(this.bc02Subjective, that.bc02Subjective) &&
			Objects.equals(this.bc02Objective, that.bc02Objective) &&
			Objects.equals(this.bc03Subjective, that.bc03Subjective) &&
			Objects.equals(this.bc03Objective, that.bc03Objective) &&
			Objects.equals(this.bc04Subjective, that.bc04Subjective) &&
			Objects.equals(this.bc04Objective, that.bc04Objective) &&
			Objects.equals(this.bc05Subjective, that.bc05Subjective) &&
			Objects.equals(this.bc05Objective, that.bc05Objective) &&
			Objects.equals(this.bc06Subjective, that.bc06Subjective) &&
			Objects.equals(this.bc06Objective, that.bc06Objective) &&
			Objects.equals(this.bc07Subjective, that.bc07Subjective) &&
			Objects.equals(this.bc07Objective, that.bc07Objective) &&
			Objects.equals(this.bc08Subjective, that.bc08Subjective) &&
			Objects.equals(this.bc08Objective, that.bc08Objective) &&
			Objects.equals(this.bc09Subjective, that.bc09Subjective) &&
			Objects.equals(this.bc09Objective, that.bc09Objective) &&
			Objects.equals(this.bc10Subjective, that.bc10Subjective) &&
			Objects.equals(this.bc10Objective, that.bc10Objective) &&
			Objects.equals(this.bc11Subjective, that.bc11Subjective) &&
			Objects.equals(this.bc11Objective, that.bc11Objective) &&
			Objects.equals(this.bc12Subjective, that.bc12Subjective) &&
			Objects.equals(this.bc12Objective, that.bc12Objective) &&
			Objects.equals(this.bc13Subjective, that.bc13Subjective) &&
			Objects.equals(this.bc13Objective, that.bc13Objective) &&
			Objects.equals(this.bc14Subjective, that.bc14Subjective) &&
			Objects.equals(this.bc14Objective, that.bc14Objective) &&
			Objects.equals(this.bc15Subjective, that.bc15Subjective) &&
			Objects.equals(this.bc15Objective, that.bc15Objective) &&
			Objects.equals(this.bc16Subjective, that.bc16Subjective) &&
			Objects.equals(this.bc16Objective, that.bc16Objective) &&
			Objects.equals(this.bc17Subjective, that.bc17Subjective) &&
			Objects.equals(this.bc17Objective, that.bc17Objective) &&
			Objects.equals(this.bc18Subjective, that.bc18Subjective) &&
			Objects.equals(this.bc18Objective, that.bc18Objective) &&
			Objects.equals(this.bc19Subjective, that.bc19Subjective) &&
			Objects.equals(this.bc19Objective, that.bc19Objective) &&
			Objects.equals(this.bc20Subjective, that.bc20Subjective) &&
			Objects.equals(this.bc20Objective, that.bc20Objective) &&
			Objects.equals(this.bc21Subjective, that.bc21Subjective) &&
			Objects.equals(this.bc21Objective, that.bc21Objective) &&
			Objects.equals(this.bc22Subjective, that.bc22Subjective) &&
			Objects.equals(this.bc22Objective, that.bc22Objective) &&
			Objects.equals(this.bc23Subjective, that.bc23Subjective) &&
			Objects.equals(this.bc23Objective, that.bc23Objective) &&
			Objects.equals(this.bc24Subjective, that.bc24Subjective) &&
			Objects.equals(this.bc24Objective, that.bc24Objective) &&
			Objects.equals(this.bc25Subjective, that.bc25Subjective) &&
			Objects.equals(this.bc25Objective, that.bc25Objective) &&
			Objects.equals(this.bc26Subjective, that.bc26Subjective) &&
			Objects.equals(this.bc26Objective, that.bc26Objective) &&
			Objects.equals(this.bc27Subjective, that.bc27Subjective) &&
			Objects.equals(this.bc27Objective, that.bc27Objective) &&
			Objects.equals(this.bc28Subjective, that.bc28Subjective) &&
			Objects.equals(this.bc28Objective, that.bc28Objective) &&
			Objects.equals(this.bc29Subjective, that.bc29Subjective) &&
			Objects.equals(this.bc29Objective, that.bc29Objective) &&
			Objects.equals(this.bc30Subjective, that.bc30Subjective) &&
			Objects.equals(this.bc30Objective, that.bc30Objective) &&
			Objects.equals(this.bc31Subjective, that.bc31Subjective) &&
			Objects.equals(this.bc31Objective, that.bc31Objective) &&
			Objects.equals(this.bc32Subjective, that.bc32Subjective) &&
			Objects.equals(this.bc32Objective, that.bc32Objective) &&
			Objects.equals(this.bc33Subjective, that.bc33Subjective) &&
			Objects.equals(this.bc33Objective, that.bc33Objective) &&
			Objects.equals(this.bc34Subjective, that.bc34Subjective) &&
			Objects.equals(this.bc34Objective, that.bc34Objective) &&
			Objects.equals(this.bc35Subjective, that.bc35Subjective) &&
			Objects.equals(this.bc35Objective, that.bc35Objective) &&
			Objects.equals(this.bc36Subjective, that.bc36Subjective) &&
			Objects.equals(this.bc36Objective, that.bc36Objective) &&
			Objects.equals(this.bc37Subjective, that.bc37Subjective) &&
			Objects.equals(this.bc37Objective, that.bc37Objective) &&
			Objects.equals(this.bc38Subjective, that.bc38Subjective) &&
			Objects.equals(this.bc38Objective, that.bc38Objective) &&
			Objects.equals(this.bc39Subjective, that.bc39Subjective) &&
			Objects.equals(this.bc39Objective, that.bc39Objective) &&
			Objects.equals(this.bc40Subjective, that.bc40Subjective) &&
			Objects.equals(this.bc40Objective, that.bc40Objective) &&
			Objects.equals(this.bc41Subjective, that.bc41Subjective) &&
			Objects.equals(this.bc41Objective, that.bc41Objective) &&
			Objects.equals(this.bc42Subjective, that.bc42Subjective) &&
			Objects.equals(this.bc42Objective, that.bc42Objective) &&
			Objects.equals(this.bc43Subjective, that.bc43Subjective) &&
			Objects.equals(this.bc43Objective, that.bc43Objective) &&
			Objects.equals(this.bc44Subjective, that.bc44Subjective) &&
			Objects.equals(this.bc44Objective, that.bc44Objective) &&
			Objects.equals(this.bc45Subjective, that.bc45Subjective) &&
			Objects.equals(this.bc45Objective, that.bc45Objective) &&
			Objects.equals(this.bc46Subjective, that.bc46Subjective) &&
			Objects.equals(this.bc46Objective, that.bc46Objective) &&
			Objects.equals(this.bc47Subjective, that.bc47Subjective) &&
			Objects.equals(this.bc47Objective, that.bc47Objective) &&
			Objects.equals(this.bc48Subjective, that.bc48Subjective) &&
			Objects.equals(this.bc48Objective, that.bc48Objective) &&
			Objects.equals(this.bc49Subjective, that.bc49Subjective) &&
			Objects.equals(this.bc49Objective, that.bc49Objective) &&
			Objects.equals(this.bc50Subjective, that.bc50Subjective) &&
			Objects.equals(this.bc50Objective, that.bc50Objective) &&
			Objects.equals(this.bc51Subjective, that.bc51Subjective) &&
			Objects.equals(this.bc51Objective, that.bc51Objective) &&
			Objects.equals(this.bc52Subjective, that.bc52Subjective) &&
			Objects.equals(this.bc52Objective, that.bc52Objective) &&
			Objects.equals(this.bc53Subjective, that.bc53Subjective) &&
			Objects.equals(this.bc53Objective, that.bc53Objective) &&
			Objects.equals(this.bc54Subjective, that.bc54Subjective) &&
			Objects.equals(this.bc54Objective, that.bc54Objective) &&
			Objects.equals(this.bc55Subjective, that.bc55Subjective) &&
			Objects.equals(this.bc55Objective, that.bc55Objective) &&
			Objects.equals(this.bc56Subjective, that.bc56Subjective) &&
			Objects.equals(this.bc56Objective, that.bc56Objective) &&
			Objects.equals(this.bc57Subjective, that.bc57Subjective) &&
			Objects.equals(this.bc57Objective, that.bc57Objective) &&
			Objects.equals(this.bc58Subjective, that.bc58Subjective) &&
			Objects.equals(this.bc58Objective, that.bc58Objective) &&
			Objects.equals(this.bc59Subjective, that.bc59Subjective) &&
			Objects.equals(this.bc59Objective, that.bc59Objective) &&
			Objects.equals(this.bc60Subjective, that.bc60Subjective) &&
			Objects.equals(this.bc60Objective, that.bc60Objective) &&
			Objects.equals(this.bc61Subjective, that.bc61Subjective) &&
			Objects.equals(this.bc61Objective, that.bc61Objective) &&
			Objects.equals(this.bc62Subjective, that.bc62Subjective) &&
			Objects.equals(this.bc62Objective, that.bc62Objective) &&
			Objects.equals(this.bc63Subjective, that.bc63Subjective) &&
			Objects.equals(this.bc63Objective, that.bc63Objective) &&
			Objects.equals(this.bc64Subjective, that.bc64Subjective) &&
			Objects.equals(this.bc64Objective, that.bc64Objective) &&
			Objects.equals(this.bc65Subjective, that.bc65Subjective) &&
			Objects.equals(this.bc65Objective, that.bc65Objective) &&
			Objects.equals(this.bc66Subjective, that.bc66Subjective) &&
			Objects.equals(this.bc66Objective, that.bc66Objective) &&
			Objects.equals(this.bc67Subjective, that.bc67Subjective) &&
			Objects.equals(this.bc67Objective, that.bc67Objective) &&
			Objects.equals(this.bc68Subjective, that.bc68Subjective) &&
			Objects.equals(this.bc68Objective, that.bc68Objective) &&
			Objects.equals(this.bc69Subjective, that.bc69Subjective) &&
			Objects.equals(this.bc69Objective, that.bc69Objective) &&
			Objects.equals(this.bc70Subjective, that.bc70Subjective) &&
			Objects.equals(this.bc70Objective, that.bc70Objective) &&
			Objects.equals(this.bc71Subjective, that.bc71Subjective) &&
			Objects.equals(this.bc71Objective, that.bc71Objective) &&
			Objects.equals(this.bc72Subjective, that.bc72Subjective) &&
			Objects.equals(this.bc72Objective, that.bc72Objective) &&
			Objects.equals(this.bc73Subjective, that.bc73Subjective) &&
			Objects.equals(this.bc73Objective, that.bc73Objective) &&
			Objects.equals(this.bc74Subjective, that.bc74Subjective) &&
			Objects.equals(this.bc74Objective, that.bc74Objective) &&
			Objects.equals(this.bc75Subjective, that.bc75Subjective) &&
			Objects.equals(this.bc75Objective, that.bc75Objective) &&
			Objects.equals(this.bc76Subjective, that.bc76Subjective) &&
			Objects.equals(this.bc76Objective, that.bc76Objective) &&
			Objects.equals(this.bc77Subjective, that.bc77Subjective) &&
			Objects.equals(this.bc77Objective, that.bc77Objective) &&
			Objects.equals(this.bc78Subjective, that.bc78Subjective) &&
			Objects.equals(this.bc78Objective, that.bc78Objective) &&
			Objects.equals(this.bc79Subjective, that.bc79Subjective) &&
			Objects.equals(this.bc79Objective, that.bc79Objective) &&
			Objects.equals(this.bc80Subjective, that.bc80Subjective) &&
			Objects.equals(this.bc80Objective, that.bc80Objective) &&
			Objects.equals(this.bc81Subjective, that.bc81Subjective) &&
			Objects.equals(this.bc81Objective, that.bc81Objective) &&
			Objects.equals(this.bc82Subjective, that.bc82Subjective) &&
			Objects.equals(this.bc82Objective, that.bc82Objective) &&
			Objects.equals(this.bc83Subjective, that.bc83Subjective) &&
			Objects.equals(this.bc83Objective, that.bc83Objective) &&
			Objects.equals(this.bc84Subjective, that.bc84Subjective) &&
			Objects.equals(this.bc84Objective, that.bc84Objective) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
