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
public class BpjsPcarePesertaKegiatanKelompokEntity extends AbstractEntity {

	public BpjsPcarePesertaKegiatanKelompokEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for eduId here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for eduId here] end
	private String eduid;

	// % protected region % [Modify attribute annotation for noKartu here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noKartu here] end
	private String nokartu;

	// % protected region % [Modify attribute annotation for nama here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nama here] end
	private String nama;

	// % protected region % [Modify attribute annotation for hubunganKeluarga here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for hubunganKeluarga here] end
	private String hubungankeluarga;

	// % protected region % [Modify attribute annotation for sex here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for sex here] end
	private String sex;

	// % protected region % [Modify attribute annotation for tglLahir here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglLahir here] end
	private String tgllahir;

	// % protected region % [Modify attribute annotation for tglMulaiAktif here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglMulaiAktif here] end
	private String tglmulaiaktif;

	// % protected region % [Modify attribute annotation for tglAkhirBerlaku here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglAkhirBerlaku here] end
	private String tglakhirberlaku;

	// % protected region % [Modify attribute annotation for kdProvider here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdProvider here] end
	private String kdprovider;

	// % protected region % [Modify attribute annotation for nmProvider here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmProvider here] end
	private String nmprovider;

	// % protected region % [Modify attribute annotation for kdProviderGigi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdProviderGigi here] end
	private String kdprovidergigi;

	// % protected region % [Modify attribute annotation for nmProviderGigi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmProviderGigi here] end
	private String nmprovidergigi;

	// % protected region % [Modify attribute annotation for namaKelas here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for namaKelas here] end
	private String namakelas;

	// % protected region % [Modify attribute annotation for kodeKelas here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodeKelas here] end
	private String kodekelas;

	// % protected region % [Modify attribute annotation for namaPeserta here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for namaPeserta here] end
	private String namapeserta;

	// % protected region % [Modify attribute annotation for kodePeserta here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodePeserta here] end
	private String kodepeserta;

	// % protected region % [Modify attribute annotation for golDarah here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for golDarah here] end
	private String goldarah;

	// % protected region % [Modify attribute annotation for noHP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noHP here] end
	private String nohp;

	// % protected region % [Modify attribute annotation for noKTP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noKTP here] end
	private String noktp;

	// % protected region % [Modify attribute annotation for pstProl here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for pstProl here] end
	private String pstprol;

	// % protected region % [Modify attribute annotation for pstPrb here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for pstPrb here] end
	private String pstprb;

	// % protected region % [Modify attribute annotation for ketAktif here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ketAktif here] end
	private String ketaktif;

	// % protected region % [Modify attribute annotation for kdAsuransi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdAsuransi here] end
	private String kdasuransi;

	// % protected region % [Modify attribute annotation for nmAsuransi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmAsuransi here] end
	private String nmasuransi;

	// % protected region % [Modify attribute annotation for noAsuransi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noAsuransi here] end
	private String noasuransi;

	// % protected region % [Modify attribute annotation for cob here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for cob here] end
	private String cob;

	// % protected region % [Modify attribute annotation for tunggakan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tunggakan here] end
	private String tunggakan;

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
