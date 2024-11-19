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
@Schema(description = "The Dto for PcareMCUEntity")
@EqualsAndHashCode(callSuper = false)
public class PcareMCUEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String kodeMCU;

	private String noKunjungan;

	private String kodeProvider;

	private String namaProvider;

	private String tanggalPelayanan;

	private String sistole;

	private String diastole;

	private String radiologiFoto;

	private String hemoglobin;

	private String leukosit;

	private String eritrosit;

	private String lajuEndapDarah;

	private String hematokrit;

	private String trombosit;

	private String hdl;

	private String ldl;

	private String cholesterol;

	private String trigliserida;

	private String sewaktu;

	private String puasa;

	private String postPrandial;

	private String hba1c;

	private String sgot;

	private String sgpt;

	private String gamma;

	private String proteinKualitatif;

	private String albumin;

	private String creatinine;

	private String ureum;

	private String asam;

	private String abi;

	private String ekg;

	private String echo;

	private String funduskopi;

	private String pemeriksaanLain;

	private String keterangan;

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
