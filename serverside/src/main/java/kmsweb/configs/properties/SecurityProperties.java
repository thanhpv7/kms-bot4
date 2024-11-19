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
package kmsweb.configs.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Properties used to configure the behaviour of the application security
 */
@Slf4j
@Data
@Validated
@ConfigurationProperties("security")
public class SecurityProperties {

	/**
	 * JWT secret used to encode JWT tokens.
	 */
	@NotNull
	@Size(min = 10)
	private String jwtSecret;

	/**
	 * JWT expiration time duration in seconds. Default to 1 hour.
	 */
	private int jwtTokenExpirationTimeSeconds = 3600;

	/**
	 * Max age in seconds for authentication cookie.
	 */
	private int authTokenAgeSeconds = 3600;

	/**
	 * Max age in seconds for CSRF cookie.
	 */
	private int csrfTokenAgeSeconds = 3600;

	/**
	 * Expiration time of a password reset token in seconds
	 */
	private int userPasswordResetExpirationTimeSeconds = 800;

	/**
	 * Default expiration time for the token service
	 */
	private int defaultExpirationTimeSeconds = 3600;


	/**
	 * Enable auditing of all read requests from the database.
	 */
	@NotNull
	private boolean readAuditEnabled = true;

	// % protected region % [Override the setReadAuditEnabled method here] off begin
	/**
	 * Override the Lombok setter method here to allow us to throw a warning when auditing is disabled for reads
	 * @param readAuditEnabled Is the read audit enabled?
	 */
	public void setReadAuditEnabled(boolean readAuditEnabled) {
		if (!readAuditEnabled) {
			log.warn("Read audits have been disabled globally");
		}
		this.readAuditEnabled = readAuditEnabled;
	}
	// % protected region % [Override the setReadAuditEnabled method here] end

	// % protected region % [Add additional security configuration properties here] off begin
	// % protected region % [Add additional security configuration properties here] end
}
