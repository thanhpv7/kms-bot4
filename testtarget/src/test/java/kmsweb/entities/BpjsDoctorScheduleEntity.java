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
public class BpjsDoctorScheduleEntity extends AbstractEntity {

	public BpjsDoctorScheduleEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Hari here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hari here] end
	private Integer hari;

	// % protected region % [Modify attribute annotation for Nama Hari here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nama Hari here] end
	private String namaHari;

	// % protected region % [Modify attribute annotation for Kapasitas here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kapasitas here] end
	private Integer kapasitas;

	// % protected region % [Modify attribute annotation for JKN Quota here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for JKN Quota here] end
	private Integer jknQuota;

	// % protected region % [Modify attribute annotation for JKN Non Quota here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for JKN Non Quota here] end
	private Integer jknNonQuota;

	// % protected region % [Modify attribute annotation for Interval here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Interval here] end
	private Integer interval;

	// % protected region % [Modify attribute annotation for Libur here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Libur here] end
	private Boolean libur;

	// % protected region % [Modify attribute annotation for Jam Buka here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Jam Buka here] end
	private String jamBuka;

	// % protected region % [Modify attribute annotation for Jam Tutup here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Jam Tutup here] end
	private String jamTutup;

	// % protected region % [Modify attribute annotation for kodepoli here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodepoli here] end
	private String kodepoli;

	// % protected region % [Modify attribute annotation for namapoli here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for namapoli here] end
	private String namapoli;

	// % protected region % [Modify attribute annotation for kodesubspesialis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodesubspesialis here] end
	private String kodesubspesialis;

	// % protected region % [Modify attribute annotation for namasubspesialis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for namasubspesialis here] end
	private String namasubspesialis;

	// % protected region % [Modify attribute annotation for kodedokter here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodedokter here] end
	private String kodedokter;

	// % protected region % [Modify attribute annotation for namadokter here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for namadokter here] end
	private String namadokter;

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
