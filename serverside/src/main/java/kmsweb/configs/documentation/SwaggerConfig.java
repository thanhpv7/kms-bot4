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
package kmsweb.configs.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// % protected region % [Add additional imports here] off begin
// % protected region % [Add additional imports here] end

@Configuration
public class SwaggerConfig {
	// % protected region % [Override or customise API grouping here] off begin
	@Bean
	public GroupedOpenApi crudApi() {
		return GroupedOpenApi.builder()
				.group("CRUD")
				.pathsToMatch("/api/**")
				.build();
	}

	@Bean
	public GroupedOpenApi actuatorAPi() {
		return GroupedOpenApi.builder()
				.group("actuator")
				.pathsToMatch("/actuator/**")
				.build();
	}
// % protected region % [Override or customise API grouping here] end

	@Bean
	public OpenAPI springShopOpenAPI() {
		// % protected region % [Customise your API info for your swagger documentation here] off begin
		return new OpenAPI()
				.info(new Info().title("kmsweb developer REST API")
						.version("1.0.0")
						.description("Developer API to allow for integration with third party systems."
								+ "Please see the [Developer API Behaviour Overview](https://codebots.com/docs/90)"
								+ "for a summary of the developer API.")

				)
				.components(new Components()
						.addSecuritySchemes("Authentication-Token",
								new SecurityScheme()
										.type(SecurityScheme.Type.APIKEY)
										.in(SecurityScheme.In.COOKIE)
								.name("AUTH-TOKEN")
						)
						.addSecuritySchemes("CSRF-Cookie",
								new SecurityScheme()
										.description("Cookie containing the CSRF token used in the double submit cookie protection method")
										.type(SecurityScheme.Type.APIKEY)
										.in(SecurityScheme.In.COOKIE)
										.name("XSRF-TOKEN")
						)
						.addSecuritySchemes("CSRF-Token",
								new SecurityScheme()
										.description("The CSRF token that is extracted from the CSRF cookie")
										.type(SecurityScheme.Type.APIKEY)
										.in(SecurityScheme.In.COOKIE)
										.name("X-XSRF-TOKEN")
						)
				);
		// % protected region % [Customise your API info for your swagger documentation here] end
	}
}
