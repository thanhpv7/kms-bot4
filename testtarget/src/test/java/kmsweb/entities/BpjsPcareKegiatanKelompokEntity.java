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
public class BpjsPcareKegiatanKelompokEntity extends AbstractEntity {

	public BpjsPcareKegiatanKelompokEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for ketuaNama here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ketuaNama here] end
	private String ketuanama;

	// % protected region % [Modify attribute annotation for nama here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nama here] end
	private String nama;

	// % protected region % [Modify attribute annotation for eduId here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for eduId here] end
	private String eduid;

	// % protected region % [Modify attribute annotation for clubId here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for clubId here] end
	private String clubid;

	// % protected region % [Modify attribute annotation for kdProgram here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdProgram here] end
	private String kdprogram;

	// % protected region % [Modify attribute annotation for nmProgram here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmProgram here] end
	private String nmprogram;

	// % protected region % [Modify attribute annotation for tglMulai here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglMulai here] end
	private String tglmulai;

	// % protected region % [Modify attribute annotation for tglAkhir here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglAkhir here] end
	private String tglakhir;

	// % protected region % [Modify attribute annotation for alamat here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for alamat here] end
	private String alamat;

	// % protected region % [Modify attribute annotation for ketuaNoHp here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ketuaNoHp here] end
	private String ketuanohp;

	// % protected region % [Modify attribute annotation for tglPelayanan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglPelayanan here] end
	private String tglpelayanan;

	// % protected region % [Modify attribute annotation for kegiatanNama here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kegiatanNama here] end
	private String kegiatannama;

	// % protected region % [Modify attribute annotation for kegiatanKode here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kegiatanKode here] end
	private String kegiatankode;

	// % protected region % [Modify attribute annotation for kelompokNama here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kelompokNama here] end
	private String kelompoknama;

	// % protected region % [Modify attribute annotation for kelompokKode here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kelompokKode here] end
	private String kelompokkode;

	// % protected region % [Modify attribute annotation for materi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for materi here] end
	private String materi;

	// % protected region % [Modify attribute annotation for pembicara here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for pembicara here] end
	private String pembicara;

	// % protected region % [Modify attribute annotation for lokasi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for lokasi here] end
	private String lokasi;

	// % protected region % [Modify attribute annotation for keterangan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for keterangan here] end
	private String keterangan;

	// % protected region % [Modify attribute annotation for biaya here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for biaya here] end
	private String biaya;

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
