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
public class PcareClubProlanisEntity extends AbstractEntity {

	public PcareClubProlanisEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Club ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Club ID here] end
	private String clubID;

	// % protected region % [Modify attribute annotation for Kode Program here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kode Program here] end
	private String kodeProgram;

	// % protected region % [Modify attribute annotation for Nama Program here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nama Program here] end
	private String namaProgram;

	// % protected region % [Modify attribute annotation for Tanggal Mulai here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tanggal Mulai here] end
	private String tanggalMulai;

	// % protected region % [Modify attribute annotation for Tanggal Akhir here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tanggal Akhir here] end
	private String tanggalAkhir;

	// % protected region % [Modify attribute annotation for Alamat Club here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Alamat Club here] end
	private String alamatClub;

	// % protected region % [Modify attribute annotation for Nama Club here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nama Club here] end
	private String namaClub;

	// % protected region % [Modify attribute annotation for No HP Ketua here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for No HP Ketua here] end
	private String noHPKetua;

	// % protected region % [Modify attribute annotation for Nama Ketua here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nama Ketua here] end
	private String namaKetua;

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
