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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.BpjsDoctorScheduleEntityDto;
import kmsweb.entities.listeners.BpjsDoctorScheduleEntityListener;
import kmsweb.serializers.BpjsDoctorScheduleSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({BpjsDoctorScheduleEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsDoctorScheduleSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsDoctorScheduleEntity extends AbstractEntity {

	/**
	 * Takes a BpjsDoctorScheduleEntityDto and converts it into a BpjsDoctorScheduleEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsDoctorScheduleEntityDto
	 */
	public BpjsDoctorScheduleEntity(BpjsDoctorScheduleEntityDto bpjsDoctorScheduleEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsDoctorScheduleEntityDto.getId() != null) {
			this.setId(bpjsDoctorScheduleEntityDto.getId());
		}

		if (bpjsDoctorScheduleEntityDto.getHari() != null) {
			this.setHari(bpjsDoctorScheduleEntityDto.getHari());
		}

		if (bpjsDoctorScheduleEntityDto.getNamaHari() != null) {
			this.setNamaHari(bpjsDoctorScheduleEntityDto.getNamaHari());
		}

		if (bpjsDoctorScheduleEntityDto.getKapasitas() != null) {
			this.setKapasitas(bpjsDoctorScheduleEntityDto.getKapasitas());
		}

		if (bpjsDoctorScheduleEntityDto.getJknQuota() != null) {
			this.setJknQuota(bpjsDoctorScheduleEntityDto.getJknQuota());
		}

		if (bpjsDoctorScheduleEntityDto.getJknNonQuota() != null) {
			this.setJknNonQuota(bpjsDoctorScheduleEntityDto.getJknNonQuota());
		}

		if (bpjsDoctorScheduleEntityDto.getInterval() != null) {
			this.setInterval(bpjsDoctorScheduleEntityDto.getInterval());
		}

		if (bpjsDoctorScheduleEntityDto.getLibur() != null) {
			this.setLibur(bpjsDoctorScheduleEntityDto.getLibur());
		}

		if (bpjsDoctorScheduleEntityDto.getJamBuka() != null) {
			this.setJamBuka(bpjsDoctorScheduleEntityDto.getJamBuka());
		}

		if (bpjsDoctorScheduleEntityDto.getJamTutup() != null) {
			this.setJamTutup(bpjsDoctorScheduleEntityDto.getJamTutup());
		}

		if (bpjsDoctorScheduleEntityDto.getKodepoli() != null) {
			this.setKodepoli(bpjsDoctorScheduleEntityDto.getKodepoli());
		}

		if (bpjsDoctorScheduleEntityDto.getNamapoli() != null) {
			this.setNamapoli(bpjsDoctorScheduleEntityDto.getNamapoli());
		}

		if (bpjsDoctorScheduleEntityDto.getKodesubspesialis() != null) {
			this.setKodesubspesialis(bpjsDoctorScheduleEntityDto.getKodesubspesialis());
		}

		if (bpjsDoctorScheduleEntityDto.getNamasubspesialis() != null) {
			this.setNamasubspesialis(bpjsDoctorScheduleEntityDto.getNamasubspesialis());
		}

		if (bpjsDoctorScheduleEntityDto.getKodedokter() != null) {
			this.setKodedokter(bpjsDoctorScheduleEntityDto.getKodedokter());
		}

		if (bpjsDoctorScheduleEntityDto.getNamadokter() != null) {
			this.setNamadokter(bpjsDoctorScheduleEntityDto.getNamadokter());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Hari here] off begin
	@CsvBindByName(column = "HARI", required = false)
	@Nullable
	@Column(name = "hari")
	@Schema(description = "The Hari of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hari here] end
	private Integer hari;

	// % protected region % [Modify attribute annotation for Nama Hari here] off begin
	@CsvBindByName(column = "NAMA_HARI", required = false)
	@Nullable
	@Column(name = "nama_hari")
	@Schema(description = "The Nama Hari of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nama Hari here] end
	private String namaHari;

	// % protected region % [Modify attribute annotation for Kapasitas here] off begin
	@CsvBindByName(column = "KAPASITAS", required = false)
	@Nullable
	@Column(name = "kapasitas")
	@Schema(description = "The Kapasitas of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kapasitas here] end
	private Integer kapasitas;

	// % protected region % [Modify attribute annotation for JKN Quota here] off begin
	@CsvBindByName(column = "JKN_QUOTA", required = false)
	@Nullable
	@Column(name = "jkn_quota")
	@Schema(description = "The JKN Quota of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for JKN Quota here] end
	private Integer jknQuota;

	// % protected region % [Modify attribute annotation for JKN Non Quota here] off begin
	@CsvBindByName(column = "JKN_NON_QUOTA", required = false)
	@Nullable
	@Column(name = "jkn_non_quota")
	@Schema(description = "The JKN Non Quota of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for JKN Non Quota here] end
	private Integer jknNonQuota;

	// % protected region % [Modify attribute annotation for Interval here] off begin
	@CsvBindByName(column = "INTERVAL", required = false)
	@Nullable
	@Column(name = "interval")
	@Schema(description = "The Interval of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Interval here] end
	private Integer interval;

	// % protected region % [Modify attribute annotation for Libur here] off begin
	@CsvBindByName(column = "LIBUR", required = false)
	@Nullable
	@Column(name = "libur")
	@Schema(description = "The Libur of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Libur here] end
	private Boolean libur = false ;

	// % protected region % [Modify attribute annotation for Jam Buka here] off begin
	@CsvBindByName(column = "JAM_BUKA", required = false)
	@Nullable
	@Column(name = "jam_buka")
	@Schema(description = "The Jam Buka of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Jam Buka here] end
	private String jamBuka;

	// % protected region % [Modify attribute annotation for Jam Tutup here] off begin
	@CsvBindByName(column = "JAM_TUTUP", required = false)
	@Nullable
	@Column(name = "jam_tutup")
	@Schema(description = "The Jam Tutup of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Jam Tutup here] end
	private String jamTutup;

	// % protected region % [Modify attribute annotation for kodepoli here] off begin
	@CsvBindByName(column = "KODEPOLI", required = false)
	@Nullable
	@Column(name = "kodepoli")
	@Schema(description = "The kodepoli of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodepoli here] end
	private String kodepoli;

	// % protected region % [Modify attribute annotation for namapoli here] off begin
	@CsvBindByName(column = "NAMAPOLI", required = false)
	@Nullable
	@Column(name = "namapoli")
	@Schema(description = "The namapoli of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for namapoli here] end
	private String namapoli;

	// % protected region % [Modify attribute annotation for kodesubspesialis here] off begin
	@CsvBindByName(column = "KODESUBSPESIALIS", required = false)
	@Nullable
	@Column(name = "kodesubspesialis")
	@Schema(description = "The kodesubspesialis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodesubspesialis here] end
	private String kodesubspesialis;

	// % protected region % [Modify attribute annotation for namasubspesialis here] off begin
	@CsvBindByName(column = "NAMASUBSPESIALIS", required = false)
	@Nullable
	@Column(name = "namasubspesialis")
	@Schema(description = "The namasubspesialis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for namasubspesialis here] end
	private String namasubspesialis;

	// % protected region % [Modify attribute annotation for kodedokter here] off begin
	@CsvBindByName(column = "KODEDOKTER", required = false)
	@Nullable
	@Column(name = "kodedokter")
	@Schema(description = "The kodedokter of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodedokter here] end
	private String kodedokter;

	// % protected region % [Modify attribute annotation for namadokter here] off begin
	@CsvBindByName(column = "NAMADOKTER", required = false)
	@Nullable
	@Column(name = "namadokter")
	@Schema(description = "The namadokter of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for namadokter here] end
	private String namadokter;

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
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "HARI,NAMA_HARI,KAPASITAS,JKN_QUOTA,JKN_NON_QUOTA,INTERVAL,LIBUR,JAM_BUKA,JAM_TUTUP,KODEPOLI,NAMAPOLI,KODESUBSPESIALIS,NAMASUBSPESIALIS,KODEDOKTER,NAMADOKTER,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsDoctorSchedule) {
		if (this == bpjsDoctorSchedule) {
			return true;
		}
		if (bpjsDoctorSchedule == null || this.getClass() != bpjsDoctorSchedule.getClass()) {
			return false;
		}
		if (!super.equals(bpjsDoctorSchedule)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsDoctorScheduleEntity that = (BpjsDoctorScheduleEntity) bpjsDoctorSchedule;
		return
			Objects.equals(this.hari, that.hari) &&
			Objects.equals(this.namaHari, that.namaHari) &&
			Objects.equals(this.kapasitas, that.kapasitas) &&
			Objects.equals(this.jknQuota, that.jknQuota) &&
			Objects.equals(this.jknNonQuota, that.jknNonQuota) &&
			Objects.equals(this.interval, that.interval) &&
			Objects.equals(this.libur, that.libur) &&
			Objects.equals(this.jamBuka, that.jamBuka) &&
			Objects.equals(this.jamTutup, that.jamTutup) &&
			Objects.equals(this.kodepoli, that.kodepoli) &&
			Objects.equals(this.namapoli, that.namapoli) &&
			Objects.equals(this.kodesubspesialis, that.kodesubspesialis) &&
			Objects.equals(this.namasubspesialis, that.namasubspesialis) &&
			Objects.equals(this.kodedokter, that.kodedokter) &&
			Objects.equals(this.namadokter, that.namadokter);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
