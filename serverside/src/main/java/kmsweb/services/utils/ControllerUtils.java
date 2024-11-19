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

package kmsweb.services.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import kmsweb.dtos.ErrorDto;
import kmsweb.dtos.ErrorResponseDto;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

public class ControllerUtils {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public static ResponseEntity<ErrorResponseDto> failedValidationApiResponse(ConstraintViolationException err) {
		List<ErrorDto> validationErrors = new ArrayList<>();
		for (ConstraintViolation<?> violation: err.getConstraintViolations()) {
			// % protected region % [Update the message returned for each violation here] off begin
			var error = new ErrorDto();
			error.setMessage(violation.getMessage());
			error.setError(violation.getPropertyPath().toString());
			validationErrors.add(error);
			// % protected region % [Update the message returned for each violation here] end
		}

		var response = new ErrorResponseDto();
		response.setErrors(validationErrors);
		response.setDescription("Constraint violation");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}