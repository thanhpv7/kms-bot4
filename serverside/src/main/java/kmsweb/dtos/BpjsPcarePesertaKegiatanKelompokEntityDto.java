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
@Schema(description = "The Dto for BpjsPcarePesertaKegiatanKelompokEntity")
@EqualsAndHashCode(callSuper = false)
public class BpjsPcarePesertaKegiatanKelompokEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String eduid;

	private String nokartu;

	private String nama;

	private String hubungankeluarga;

	private String sex;

	private String tgllahir;

	private String tglmulaiaktif;

	private String tglakhirberlaku;

	private String kdprovider;

	private String nmprovider;

	private String kdprovidergigi;

	private String nmprovidergigi;

	private String namakelas;

	private String kodekelas;

	private String namapeserta;

	private String kodepeserta;

	private String goldarah;

	private String nohp;

	private String noktp;

	private String pstprol;

	private String pstprb;

	private String ketaktif;

	private String kdasuransi;

	private String nmasuransi;

	private String noasuransi;

	private String cob;

	private String tunggakan;

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
