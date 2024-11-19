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
import kmsweb.entities.*;
import lombok.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for BpjsPcarePendaftaranEntity")
@EqualsAndHashCode(callSuper = false)
public class BpjsPcarePendaftaranEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String nourut;

	private String tgldaftar;

	private String providerpelayanan;

	private String nokartu;

	private String nama;

	private String hubungankeluarga;

	private String sex;

	private String tgllahir;

	private String tglmulaiaktif;

	private String tglakhirberlaku;

	private String kdproviderpst;

	private String kdprovidergigi;

	private String jnskelas;

	private String jnspeserta;

	private String goldarah;

	private String nohp;

	private String noktp;

	private String aktif;

	private String ketaktif;

	private String asuransi;

	private String kdpoli;

	private String nmpoli;

	private String polisakit;

	private String keluhan;

	private String kunjsakit;

	private String status;

	private String sistole;

	private String diastole;

	private String beratbadan;

	private String tinggibadan;

	private String resprate;

	private String heartrate;

	private String kdtkp;

	private String nmtkp;

	private String kdproviderpelayanan;

	private String nmproviderpelayanan;

	private String nmproviderpst;

	private String nmprovidergigi;

	private String kodekls;

	private String namakls;

	private String kodepeserta;

	private String namapeserta;

	private String kdasuransi;

	private String nmasuransi;

	private String noasuransi;

	private String lingkarperut;

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

	private PatientVisitEntity patientVisit;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
