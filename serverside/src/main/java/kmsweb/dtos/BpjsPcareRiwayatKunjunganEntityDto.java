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

package kmsweb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for BpjsPcareRiwayatKunjunganEntity")
@EqualsAndHashCode(callSuper = false)
public class BpjsPcareRiwayatKunjunganEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String nokunjungan;

	private String tglkunjungan;

	private String providerpelayanan;

	private String nokartu;

	private String nama;

	private String hubungankeluarga;

	private String sex;

	private String tgllahir;

	private String tglmulaiaktif;

	private String tglakhirberlaku;

	private String kodeppkpeserta;

	private String kodeppkgigi;

	private String jeniskelas;

	private String jenispeserta;

	private String goldarah;

	private String nohp;

	private String noktp;

	private String asuransi;

	private String poli;

	private String jeniskunjungan;

	private String progprolanis;

	private String keluhan;

	private String diagnosa;

	private String diagnosa2;

	private String diagnosa3;

	private String kesadaran;

	private String sistole;

	private String diastole;

	private String beratbadan;

	private String tinggibadan;

	private String respiratoryrate;

	private String heartrate;

	private String catatan;

	private String pemeriksaanfisiklain;

	private String tglpulang;

	private String dokter;

	private String statuspulang;

	private String tingkatpelayanan;

	private String rujukbalik;

	private String providerasalrujuk;

	private String providerrujuklanjut;

	private String polirujukinternal;

	private String polirujuklanjut;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
