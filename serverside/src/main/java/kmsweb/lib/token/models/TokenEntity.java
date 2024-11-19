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

package kmsweb.lib.token.models;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.entities.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import kmsweb.deserializers.DateTimeDeserializer;
import org.hibernate.envers.Audited;
import java.time.OffsetDateTime;
import javax.persistence.*;
import lombok.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Entity
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@NoArgsConstructor
@EntityListeners({TokenEntityListener.class})
@Schema(description = "Tokens used for resetting a users password.")
@Audited
@Data
public class TokenEntity extends AbstractEntity {

	/**
	 * Token String. Token should be unique in database
	 */
	@Column(name = "token", unique = true)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String token;

	/**
	 * Expiry Time of the token
	 */
	@Column(name = "expiry_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Expiry Date Time of the token")
	private OffsetDateTime expiryDateTime;

	/**
	 * Type of token
	 */
	@Column(name = "type")
	@Schema(description = "Type of the token")
	private String type;

	/**
	 * Description of the token
	 */
	@Column(name = "description")
	@Schema(description = "Description of the token")
	private String description;

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end

	/**
	 * Check whether token expires valid date.
	 */
	public boolean isValid() {
		// % protected region % [Custom is valid logic here] off begin
		return this.expiryDateTime.isAfter(OffsetDateTime.now());
		// % protected region % [Custom is valid logic here] end
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}
