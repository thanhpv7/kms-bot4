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
package kmsweb.graphql.utils.errors;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorHelper;
import graphql.language.SourceLocation;
import org.hibernate.exception.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Constraint Violation Exception in the Graphql
 * Throw when catch constraintViolationException when doing transaction
 * Follow the format in api standard
 * @author Codebots
 */
public class GraphQLConstraintError implements GraphQLError {

	private String constraintName;

	private String errorMessage;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end\

	@Override
	public String getMessage() {
		return errorMessage;
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.ValidationError;
	}

	@Override
	public List<Object> getPath() {
		return null;
	}

	@Override
	public Map<String, Object> toSpecification() {
		return GraphqlErrorHelper.toSpecification(this);
	}

	@Override
	public Map<String, Object> getExtensions() {
		Map<String, Object> extensions = new HashMap<>();
		extensions.put("constraint", this.constraintName);
		extensions.put("statusCode", 409);
		return extensions;
	}

	/**
	 * Sets the error message for the constrain violation using the constraintName where possible.
	 * If the constraint name cannot be found, an attempt is made to extract it from the message.
	 * @param exception
	 */
	public GraphQLConstraintError(ConstraintViolationException exception) {
		this.constraintName = exception.getConstraintName();
		if (this.constraintName == null) {
			// Duplicate unique field exception
			if (exception.getErrorCode() == 23505) {
				Pattern pattern = Pattern.compile("\\((.+)\\)");
				Matcher matcher = pattern.matcher(exception.getCause().getMessage());

				if (matcher.find() && matcher.groupCount() > 0) {
					this.constraintName = matcher.group(1);
				}
			}
		}
		this.errorMessage = "The " + this.constraintName + " field must be unique";
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}