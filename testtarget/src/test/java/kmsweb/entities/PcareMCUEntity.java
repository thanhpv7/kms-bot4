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
public class PcareMCUEntity extends AbstractEntity {

	public PcareMCUEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Kode MCU here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kode MCU here] end
	private String kodeMCU;

	// % protected region % [Modify attribute annotation for No Kunjungan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for No Kunjungan here] end
	private String noKunjungan;

	// % protected region % [Modify attribute annotation for Kode Provider here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kode Provider here] end
	private String kodeProvider;

	// % protected region % [Modify attribute annotation for Nama Provider here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nama Provider here] end
	private String namaProvider;

	// % protected region % [Modify attribute annotation for Tanggal Pelayanan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tanggal Pelayanan here] end
	private String tanggalPelayanan;

	// % protected region % [Modify attribute annotation for Sistole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sistole here] end
	private String sistole;

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diastole here] end
	private String diastole;

	// % protected region % [Modify attribute annotation for Radiologi Foto here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Radiologi Foto here] end
	private String radiologiFoto;

	// % protected region % [Modify attribute annotation for Hemoglobin here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hemoglobin here] end
	private String hemoglobin;

	// % protected region % [Modify attribute annotation for Leukosit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Leukosit here] end
	private String leukosit;

	// % protected region % [Modify attribute annotation for Eritrosit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Eritrosit here] end
	private String eritrosit;

	// % protected region % [Modify attribute annotation for Laju Endap Darah here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Laju Endap Darah here] end
	private String lajuEndapDarah;

	// % protected region % [Modify attribute annotation for Hematokrit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hematokrit here] end
	private String hematokrit;

	// % protected region % [Modify attribute annotation for Trombosit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Trombosit here] end
	private String trombosit;

	// % protected region % [Modify attribute annotation for HDL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for HDL here] end
	private String hdl;

	// % protected region % [Modify attribute annotation for LDL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for LDL here] end
	private String ldl;

	// % protected region % [Modify attribute annotation for Cholesterol here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Cholesterol here] end
	private String cholesterol;

	// % protected region % [Modify attribute annotation for Trigliserida here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Trigliserida here] end
	private String trigliserida;

	// % protected region % [Modify attribute annotation for Sewaktu here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sewaktu here] end
	private String sewaktu;

	// % protected region % [Modify attribute annotation for Puasa here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Puasa here] end
	private String puasa;

	// % protected region % [Modify attribute annotation for Post Prandial here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Post Prandial here] end
	private String postPrandial;

	// % protected region % [Modify attribute annotation for HbA1c here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for HbA1c here] end
	private String hba1c;

	// % protected region % [Modify attribute annotation for SGOT here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SGOT here] end
	private String sgot;

	// % protected region % [Modify attribute annotation for SGPT here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SGPT here] end
	private String sgpt;

	// % protected region % [Modify attribute annotation for Gamma here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gamma here] end
	private String gamma;

	// % protected region % [Modify attribute annotation for Protein Kualitatif here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Protein Kualitatif here] end
	private String proteinKualitatif;

	// % protected region % [Modify attribute annotation for Albumin here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Albumin here] end
	private String albumin;

	// % protected region % [Modify attribute annotation for Creatinine here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Creatinine here] end
	private String creatinine;

	// % protected region % [Modify attribute annotation for Ureum here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ureum here] end
	private String ureum;

	// % protected region % [Modify attribute annotation for Asam here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Asam here] end
	private String asam;

	// % protected region % [Modify attribute annotation for ABI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ABI here] end
	private String abi;

	// % protected region % [Modify attribute annotation for EKG here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for EKG here] end
	private String ekg;

	// % protected region % [Modify attribute annotation for Echo here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Echo here] end
	private String echo;

	// % protected region % [Modify attribute annotation for Funduskopi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Funduskopi here] end
	private String funduskopi;

	// % protected region % [Modify attribute annotation for Pemeriksaan Lain here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pemeriksaan Lain here] end
	private String pemeriksaanLain;

	// % protected region % [Modify attribute annotation for Keterangan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Keterangan here] end
	private String keterangan;

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
