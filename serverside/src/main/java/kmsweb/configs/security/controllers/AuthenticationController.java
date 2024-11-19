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
package kmsweb.configs.security.controllers;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.*;
import kmsweb.configs.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.*;
import kmsweb.dtos.ErrorDto;
import kmsweb.dtos.ErrorResponseDto;
import kmsweb.dtos.PasswordResetRequestDto;

import java.util.Collections;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Update the API route or description for the AuthenticationController here] off begin
// The text associated with this tag can be found and edited in SwaggerConfig
@Tags(value = @Tag(name = "AuthenticationController"))
@RestController
@RequestMapping(path = "/api/authorization")
// % protected region % [Update the API route or description for the AuthenticationController here] end
public class AuthenticationController {

	private final UserService userService;

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end

	@Autowired
	public AuthenticationController(
			// % protected region % [Add any constructor parameters here] off begin
			// % protected region % [Add any constructor parameters here] end
			UserService userService
	) {
		this.userService= userService;

		// % protected region % [Add any logic for constructor here] off begin
		// % protected region % [Add any logic for constructor here] end
	}
	// % protected region % [Update the API Route mapping or description for the 'requestResetPassword' endpoint here] off begin
	@Operation(
		description = "Request a reset password for the given user"
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successfully requested a password reset."),
		@ApiResponse(responseCode = "404", description = "Could not find the user requesting the password reset."),
		@ApiResponse(responseCode = "400", description = "Failed to request a password reset due to to a malformed request.")
	})
	@RequestMapping(method = POST, path = "request-reset-password")
	// % protected region % [Update the API Route mapping or description for the 'requestResetPassword' endpoint here] end
	public ResponseEntity<?> requestResetPassword(
			@Parameter(description = "The information about the user requesting the password reset.")
			@RequestBody PasswordResetRequestDto requestBody
	) throws Exception {

		String username = requestBody.getUsername();

		if (username == null) {
			var response = new ErrorResponseDto();
			var error = new ErrorDto();
			error.setError("missing_arguments");
			error.setMessage("Username is required");
			response.setErrors(Collections.singletonList(error));

			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(response);
		}

		// % protected region % [Add any logic for constructor here before invoke forgottenPassword method] off begin
		// % protected region % [Add any logic for constructor here before invoke forgottenPassword method] end

		try {
			userService.forgottenPassword(username);

			// % protected region % [Add any logic for constructor here after invoke forgottenPassword method] off begin
			// % protected region % [Add any logic for constructor here after invoke forgottenPassword method] end
		} catch (AuthenticationCredentialsNotFoundException authExcept) {
			var response = new ErrorResponseDto();
			var error = new ErrorDto();
			error.setError("unknown_user");
			error.setMessage("Could not find the user. Please check your username.");
			response.setErrors(Collections.singletonList(error));

			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(response);
		} catch (Exception except) {
			throw new RuntimeException(except);
		}

		// % protected region % [Add any logic for constructor here before returning value from requestResetPassword] off begin
		// % protected region % [Add any logic for constructor here before returning value from requestResetPassword] end

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
