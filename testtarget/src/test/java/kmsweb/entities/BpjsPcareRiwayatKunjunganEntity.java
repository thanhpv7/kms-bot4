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
public class BpjsPcareRiwayatKunjunganEntity extends AbstractEntity {

	public BpjsPcareRiwayatKunjunganEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for noKunjungan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noKunjungan here] end
	private String nokunjungan;

	// % protected region % [Modify attribute annotation for tglkunjungan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglkunjungan here] end
	private String tglkunjungan;

	// % protected region % [Modify attribute annotation for providerPelayanan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for providerPelayanan here] end
	private String providerpelayanan;

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

	// % protected region % [Modify attribute annotation for kodePPKPeserta here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodePPKPeserta here] end
	private String kodeppkpeserta;

	// % protected region % [Modify attribute annotation for kodePPKGigi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodePPKGigi here] end
	private String kodeppkgigi;

	// % protected region % [Modify attribute annotation for jenisKelas here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for jenisKelas here] end
	private String jeniskelas;

	// % protected region % [Modify attribute annotation for jenisPeserta here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for jenisPeserta here] end
	private String jenispeserta;

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

	// % protected region % [Modify attribute annotation for asuransi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for asuransi here] end
	private String asuransi;

	// % protected region % [Modify attribute annotation for poli here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for poli here] end
	private String poli;

	// % protected region % [Modify attribute annotation for jenisKunjungan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for jenisKunjungan here] end
	private String jeniskunjungan;

	// % protected region % [Modify attribute annotation for progProlanis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for progProlanis here] end
	private String progprolanis;

	// % protected region % [Modify attribute annotation for keluhan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for keluhan here] end
	private String keluhan;

	// % protected region % [Modify attribute annotation for diagnosa here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for diagnosa here] end
	private String diagnosa;

	// % protected region % [Modify attribute annotation for diagnosa2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for diagnosa2 here] end
	private String diagnosa2;

	// % protected region % [Modify attribute annotation for diagnosa3 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for diagnosa3 here] end
	private String diagnosa3;

	// % protected region % [Modify attribute annotation for kesadaran here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kesadaran here] end
	private String kesadaran;

	// % protected region % [Modify attribute annotation for sistole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for sistole here] end
	private String sistole;

	// % protected region % [Modify attribute annotation for diastole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for diastole here] end
	private String diastole;

	// % protected region % [Modify attribute annotation for beratBadan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for beratBadan here] end
	private String beratbadan;

	// % protected region % [Modify attribute annotation for tinggiBadan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tinggiBadan here] end
	private String tinggibadan;

	// % protected region % [Modify attribute annotation for respiratoryRate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for respiratoryRate here] end
	private String respiratoryrate;

	// % protected region % [Modify attribute annotation for heartRate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for heartRate here] end
	private String heartrate;

	// % protected region % [Modify attribute annotation for catatan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for catatan here] end
	private String catatan;

	// % protected region % [Modify attribute annotation for pemeriksaanFisikLain here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for pemeriksaanFisikLain here] end
	private String pemeriksaanfisiklain;

	// % protected region % [Modify attribute annotation for tglPulang here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglPulang here] end
	private String tglpulang;

	// % protected region % [Modify attribute annotation for dokter here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for dokter here] end
	private String dokter;

	// % protected region % [Modify attribute annotation for statusPulang here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for statusPulang here] end
	private String statuspulang;

	// % protected region % [Modify attribute annotation for tingkatPelayanan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tingkatPelayanan here] end
	private String tingkatpelayanan;

	// % protected region % [Modify attribute annotation for rujukBalik here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for rujukBalik here] end
	private String rujukbalik;

	// % protected region % [Modify attribute annotation for providerAsalRujuk here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for providerAsalRujuk here] end
	private String providerasalrujuk;

	// % protected region % [Modify attribute annotation for providerRujukLanjut here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for providerRujukLanjut here] end
	private String providerrujuklanjut;

	// % protected region % [Modify attribute annotation for poliRujukInternal here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for poliRujukInternal here] end
	private String polirujukinternal;

	// % protected region % [Modify attribute annotation for poliRujukLanjut here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for poliRujukLanjut here] end
	private String polirujuklanjut;

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
