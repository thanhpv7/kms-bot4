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

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class TaskDashboardEntity extends AbstractEntity {

	public TaskDashboardEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Kdppk here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kdppk here] end
	private String kdppk;

	// % protected region % [Modify attribute annotation for Jumlah antrean here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Jumlah antrean here] end
	private Integer jumlahAntrean;

	// % protected region % [Modify attribute annotation for Namapoli here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Namapoli here] end
	private String namapoli;

	// % protected region % [Modify attribute annotation for Nmppk here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nmppk here] end
	private String nmppk;

	// % protected region % [Modify attribute annotation for Kodepoli here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kodepoli here] end
	private String kodepoli;

	// % protected region % [Modify attribute annotation for Insert Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Insert Date here] end
	private OffsetDateTime insertDate;

	// % protected region % [Modify attribute annotation for tanggal here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tanggal here] end
	private OffsetDateTime tanggal;

	// % protected region % [Modify attribute annotation for Waktu Task1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waktu Task1 here] end
	private Integer waktuTask1;

	// % protected region % [Modify attribute annotation for Waktu Task2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waktu Task2 here] end
	private Integer waktuTask2;

	// % protected region % [Modify attribute annotation for Waktu Task3 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waktu Task3 here] end
	private Integer waktuTask3;

	// % protected region % [Modify attribute annotation for Waktu Task4 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waktu Task4 here] end
	private Integer waktuTask4;

	// % protected region % [Modify attribute annotation for Waktu Task5 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waktu Task5 here] end
	private Integer waktuTask5;

	// % protected region % [Modify attribute annotation for Waktu Task6 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waktu Task6 here] end
	private Integer waktuTask6;

	// % protected region % [Modify attribute annotation for avg waktu task1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for avg waktu task1 here] end
	private Integer avgWaktuTask1;

	// % protected region % [Modify attribute annotation for avg waktu task2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for avg waktu task2 here] end
	private Integer avgWaktuTask2;

	// % protected region % [Modify attribute annotation for avg waktu task3 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for avg waktu task3 here] end
	private Integer avgWaktuTask3;

	// % protected region % [Modify attribute annotation for avg waktu task4 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for avg waktu task4 here] end
	private Integer avgWaktuTask4;

	// % protected region % [Modify attribute annotation for avg waktu task5 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for avg waktu task5 here] end
	private Integer avgWaktuTask5;

	// % protected region % [Modify attribute annotation for avg waktu task6 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for avg waktu task6 here] end
	private Integer avgWaktuTask6;

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
