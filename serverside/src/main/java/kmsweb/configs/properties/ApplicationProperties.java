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
import kmsweb.entities.enums.FileServiceProviderEnum;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Properties used to configure the AWS integration with the application
 */
@Data
@Validated
@ConfigurationProperties("application")
public class ApplicationProperties {

	/**
	 * Set if the scheduled tasks should run
	 */
	private boolean scheduledTasksEnabled = false;

	/**
	 * Name of the application support
	 */
	private String supportName;

	/**
	 * Support URL
	 */
	@URL
	private String supportUrl;

	/**
	 * Support email address
	 */
	@Email
	private String supportEmail;

	/**
	 * Email address used for sending system level emails.
	 * This includes being set as the from address for all outbound emails
	 */
	@Email
	private String systemAdminEmail = "info@example.com";

	/**
	 * The host name of the client-side application
	 */
	@NotNull
	@URL
	private String clientSideHost = "http://localhost:8080";

	/**
	 * The file storage provider in use
	 */
	private FileServiceProviderEnum fileServiceProvider = FileServiceProviderEnum.S3;
	// % protected region % [Add additional security configuration properties here] off begin
	// % protected region % [Add additional security configuration properties here] end
}
