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
public class BpjsPcareKunjunganRujukanEntity extends AbstractEntity {

	public BpjsPcareKunjunganRujukanEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for noRujukan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noRujukan here] end
	private String norujukan;

	// % protected region % [Modify attribute annotation for kdPPK here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdPPK here] end
	private String kdppk;

	// % protected region % [Modify attribute annotation for nmPPK here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmPPK here] end
	private String nmppk;

	// % protected region % [Modify attribute annotation for alamat here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for alamat here] end
	private String alamat;

	// % protected region % [Modify attribute annotation for kdKC here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdKC here] end
	private String kdkc;

	// % protected region % [Modify attribute annotation for nmKC here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmKC here] end
	private String nmkc;

	// % protected region % [Modify attribute annotation for alamatKC here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for alamatKC here] end
	private String alamatkc;

	// % protected region % [Modify attribute annotation for telpKC here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for telpKC here] end
	private String telpkc;

	// % protected region % [Modify attribute annotation for faxKC here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for faxKC here] end
	private String faxkc;

	// % protected region % [Modify attribute annotation for kdProp here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdProp here] end
	private String kdprop;

	// % protected region % [Modify attribute annotation for kdDati here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdDati here] end
	private String kddati;

	// % protected region % [Modify attribute annotation for nmDati here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmDati here] end
	private String nmdati;

	// % protected region % [Modify attribute annotation for kdKR here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdKR here] end
	private String kdkr;

	// % protected region % [Modify attribute annotation for nmKR here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmKR here] end
	private String nmkr;

	// % protected region % [Modify attribute annotation for alamatKR here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for alamatKR here] end
	private String alamatkr;

	// % protected region % [Modify attribute annotation for telpKR here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for telpKR here] end
	private String telpkr;

	// % protected region % [Modify attribute annotation for faxKR here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for faxKR here] end
	private String faxkr;

	// % protected region % [Modify attribute annotation for tglKunjungan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglKunjungan here] end
	private String tglkunjungan;

	// % protected region % [Modify attribute annotation for kdPoli here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdPoli here] end
	private String kdpoli;

	// % protected region % [Modify attribute annotation for nmPoli here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmPoli here] end
	private String nmpoli;

	// % protected region % [Modify attribute annotation for nokaPst here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nokaPst here] end
	private String nokapst;

	// % protected region % [Modify attribute annotation for nmPst here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmPst here] end
	private String nmpst;

	// % protected region % [Modify attribute annotation for tglLahir here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglLahir here] end
	private String tgllahir;

	// % protected region % [Modify attribute annotation for pisa here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for pisa here] end
	private String pisa;

	// % protected region % [Modify attribute annotation for ketPisa here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ketPisa here] end
	private String ketpisa;

	// % protected region % [Modify attribute annotation for sex here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for sex here] end
	private String sex;

	// % protected region % [Modify attribute annotation for kdDiag1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdDiag1 here] end
	private String kddiag1;

	// % protected region % [Modify attribute annotation for nmDiag1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmDiag1 here] end
	private String nmdiag1;

	// % protected region % [Modify attribute annotation for kdDiag2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdDiag2 here] end
	private String kddiag2;

	// % protected region % [Modify attribute annotation for nmDiag2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmDiag2 here] end
	private String nmdiag2;

	// % protected region % [Modify attribute annotation for kdDiag3 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdDiag3 here] end
	private String kddiag3;

	// % protected region % [Modify attribute annotation for nmDiag3 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmDiag3 here] end
	private String nmdiag3;

	// % protected region % [Modify attribute annotation for catatan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for catatan here] end
	private String catatan;

	// % protected region % [Modify attribute annotation for kdDokter here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdDokter here] end
	private String kddokter;

	// % protected region % [Modify attribute annotation for nmDokter here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmDokter here] end
	private String nmdokter;

	// % protected region % [Modify attribute annotation for nmTacc here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmTacc here] end
	private String nmtacc;

	// % protected region % [Modify attribute annotation for alasanTacc here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for alasanTacc here] end
	private String alasantacc;

	// % protected region % [Modify attribute annotation for infoDenda here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for infoDenda here] end
	private String infodenda;

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
