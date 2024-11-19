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

import lombok.*;
import javax.validation.constraints.NotNull;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class BpjsBedAvailabilityEntity extends AbstractEntity {

	public BpjsBedAvailabilityEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for koderuang here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for koderuang here] end
	private String koderuang;

	// % protected region % [Modify attribute annotation for namaruang here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for namaruang here] end
	private String namaruang;

	// % protected region % [Modify attribute annotation for kodekelas here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodekelas here] end
	private String kodekelas;

	// % protected region % [Modify attribute annotation for namakelas here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for namakelas here] end
	private String namakelas;

	// % protected region % [Modify attribute annotation for lastupdate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for lastupdate here] end
	private String lastupdate;

	// % protected region % [Modify attribute annotation for kapasitas here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kapasitas here] end
	private Integer kapasitas;

	// % protected region % [Modify attribute annotation for tersedia here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tersedia here] end
	private Integer tersedia;

	// % protected region % [Modify attribute annotation for tersediapria here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tersediapria here] end
	private Integer tersediapria;

	// % protected region % [Modify attribute annotation for tersediawanita here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tersediawanita here] end
	private Integer tersediawanita;

	// % protected region % [Modify attribute annotation for tersediapriawanita here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tersediapriawanita here] end
	private Integer tersediapriawanita;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
