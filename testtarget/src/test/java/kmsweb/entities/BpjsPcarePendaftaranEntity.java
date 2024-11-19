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
public class BpjsPcarePendaftaranEntity extends AbstractEntity {

	public BpjsPcarePendaftaranEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PatientVisitOneMany = new EntityReference();
			PatientVisitOneMany.entityName = "PatientVisit";
			PatientVisitOneMany.oppositeName = "PatientVisit";
			PatientVisitOneMany.name = "BpjsPcarePendaftarans";
			PatientVisitOneMany.optional = true;
			PatientVisitOneMany.type = "One";
			PatientVisitOneMany.oppositeType = "Many";

		References.add(PatientVisitOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for noUrut here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noUrut here] end
	private String nourut;

	// % protected region % [Modify attribute annotation for tgldaftar here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tgldaftar here] end
	private String tgldaftar;

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

	// % protected region % [Modify attribute annotation for kdProviderPst here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdProviderPst here] end
	private String kdproviderpst;

	// % protected region % [Modify attribute annotation for kdProviderGigi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdProviderGigi here] end
	private String kdprovidergigi;

	// % protected region % [Modify attribute annotation for jnsKelas here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for jnsKelas here] end
	private String jnskelas;

	// % protected region % [Modify attribute annotation for jnsPeserta here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for jnsPeserta here] end
	private String jnspeserta;

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

	// % protected region % [Modify attribute annotation for aktif here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for aktif here] end
	private String aktif;

	// % protected region % [Modify attribute annotation for ketAktif here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ketAktif here] end
	private String ketaktif;

	// % protected region % [Modify attribute annotation for asuransi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for asuransi here] end
	private String asuransi;

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

	// % protected region % [Modify attribute annotation for poliSakit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for poliSakit here] end
	private String polisakit;

	// % protected region % [Modify attribute annotation for keluhan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for keluhan here] end
	private String keluhan;

	// % protected region % [Modify attribute annotation for kunjSakit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kunjSakit here] end
	private String kunjsakit;

	// % protected region % [Modify attribute annotation for status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for status here] end
	private String status;

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

	// % protected region % [Modify attribute annotation for respRate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for respRate here] end
	private String resprate;

	// % protected region % [Modify attribute annotation for heartRate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for heartRate here] end
	private String heartrate;

	// % protected region % [Modify attribute annotation for kdTkp here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdTkp here] end
	private String kdtkp;

	// % protected region % [Modify attribute annotation for nmTkp here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmTkp here] end
	private String nmtkp;

	// % protected region % [Modify attribute annotation for kdProviderPelayanan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdProviderPelayanan here] end
	private String kdproviderpelayanan;

	// % protected region % [Modify attribute annotation for nmProviderPelayanan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmProviderPelayanan here] end
	private String nmproviderpelayanan;

	// % protected region % [Modify attribute annotation for nmProviderPst here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmProviderPst here] end
	private String nmproviderpst;

	// % protected region % [Modify attribute annotation for nmProviderGigi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nmProviderGigi here] end
	private String nmprovidergigi;

	// % protected region % [Modify attribute annotation for kodeKls here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodeKls here] end
	private String kodekls;

	// % protected region % [Modify attribute annotation for namaKls here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for namaKls here] end
	private String namakls;

	// % protected region % [Modify attribute annotation for kodePeserta here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodePeserta here] end
	private String kodepeserta;

	// % protected region % [Modify attribute annotation for namaPeserta here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for namaPeserta here] end
	private String namapeserta;

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

	// % protected region % [Modify attribute annotation for lingkarPerut here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for lingkarPerut here] end
	private String lingkarperut;

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

	private PatientVisitEntity patientVisit;

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

	/**
	 * Similar to {@link this#setPatientVisit(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisit(@NonNull PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(@NonNull PatientVisitEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] end

		if (sameAsFormer(this.patientVisit, entity)) {
			return;
		}

		if (this.patientVisit != null) {
			this.patientVisit.removeBpjsPcarePendaftarans(this, false);
		}
		this.patientVisit = entity;
		if (reverseAdd) {
			this.patientVisit.addBpjsPcarePendaftarans(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisit(boolean)} but default to true.
	 */
	public void unsetPatientVisit() {
		this.unsetPatientVisit(true);
	}

	/**
	 * Remove Patient Visit in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisit(boolean reverse) {
		if (reverse && this.patientVisit != null) {
			this.patientVisit.removeBpjsPcarePendaftarans(this, false);
		}
		this.patientVisit = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
