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

package kmsweb.lib.validators;

import lombok.AllArgsConstructor;
import org.hibernate.validator.internal.engine.path.PathImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;
import java.util.Objects;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Override the Javadoc and annotations here] off begin
/**
 * An implementation of the {@link javax.validation.ConstraintViolation} class to allow for instantiation
 * of custom constraint errors within the application.
 *
 * @param <T>
 */
@AllArgsConstructor
// % protected region % [Override the Javadoc and annotations here] end
public class SimpleConstraintViolationImpl<T> implements ConstraintViolation<T> {

	private final String attributeName;
	private final Object attributeValue;
	private final String message;
	private final String path;

	// % protected region % [Add additional class fields here] off begin
	// % protected region % [Add additional class fields here] end

	@Override
	public String getMessage() {
		return attributeName + " " + message;
	}

	@Override
	public String getMessageTemplate() {
		// % protected region % [Override getMessageTemplate here] off begin
		return null;
		// % protected region % [Override getMessageTemplate here] end
	}

	@Override
	public T getRootBean() {
		// % protected region % [Override getRootBean here] off begin
		return null;
		// % protected region % [Override getRootBean here] end
	}

	@Override
	public Class<T> getRootBeanClass() {
		// % protected region % [Override getRootBeanClass here] off begin
		return null;
		// % protected region % [Override getRootBeanClass here] end
	}

	@Override
	public Object getLeafBean() {
		// % protected region % [Override getLeafBean here] off begin
		return null;
		// % protected region % [Override getLeafBean here] end
	}

	@Override
	public Object[] getExecutableParameters() {
		// % protected region % [Override getExecutableParameters here] off begin
		return new Object[0];
		// % protected region % [Override getExecutableParameters here] end
	}

	@Override
	public Object getExecutableReturnValue() {
		// % protected region % [Override getExecutableReturnValue here] off begin
		return null;
		// % protected region % [Override getExecutableReturnValue here] end
	}

	@Override
	public Path getPropertyPath() {
		// % protected region % [Override getPropertyPath here] off begin
		// Allow the attribute to user friendly but also used as the path.
		return PathImpl.createPathFromString(this.path);
		// % protected region % [Override getPropertyPath here] end
	}

	@Override
	public Object getInvalidValue() {
		// % protected region % [Override getInvalidValue here] off begin
		return this.attributeValue;
		// % protected region % [Override getInvalidValue here] end
	}

	@Override
	public ConstraintDescriptor<?> getConstraintDescriptor() {
		// % protected region % [Override getConstraintDescriptor here] off begin
		return null;
		// % protected region % [Override getConstraintDescriptor here] end
	}

	@Override
	public <U> U unwrap(Class<U> type) {
		// % protected region % [Override unwrap here] off begin
		return null;
		// % protected region % [Override unwrap here] end
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SimpleConstraintViolationImpl<?> that = (SimpleConstraintViolationImpl<?>) o;
		return Objects.equals(attributeName, that.attributeName) && Objects.equals(attributeValue, that.attributeValue) && Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(attributeName, attributeValue, message);
	}

	// % protected region % [Add additional class methods here] off begin
	// % protected region % [Add additional class methods here] end
}

