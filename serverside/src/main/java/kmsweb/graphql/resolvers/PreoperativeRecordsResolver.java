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

package kmsweb.graphql.resolvers;

import kmsweb.entities.*;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Component
public class PreoperativeRecordsResolver implements GraphQLResolver<PreoperativeRecordsEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	public Set<CoTreatingDoctorEntity> additionalAnesthesiologists(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getAdditionalAnesthesiologists();
	}

	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	public Set<CoTreatingDoctorEntity> additionalSurgeryNurses(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getAdditionalSurgeryNurses();
	}

	@PreAuthorize("hasPermission('BedFacilityEntity', 'read')")
	public Set<BedFacilityEntity> bedFacilities(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getBedFacilities();
	}

	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	public Set<CoTreatingDoctorEntity> coTreatingAnesthesiologists(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getCoTreatingAnesthesiologists();
	}

	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	public Set<CoTreatingDoctorEntity> coTreatingSurgeons(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getCoTreatingSurgeons();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity anesthesiaMedicalTranscriber(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getAnesthesiaMedicalTranscriber();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity anesthesiologist(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getAnesthesiologist();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity anesthesiologyNurse(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getAnesthesiologyNurse();
	}

	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'read')")
	public DiagnosesAndProceduresEntity preSurgeryICD10(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getPreSurgeryICD10();
	}

	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'read')")
	public DiagnosesAndProceduresEntity preSurgeryICD9CM(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getPreSurgeryICD9CM();
	}

	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	public OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecord(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getOperatingTheaterMedicalExaminationRecord();
	}

	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	public RoomFacilityEntity preoperativeRooms(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getPreoperativeRooms();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity surgeon(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getSurgeon();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity surgicalMedicalTranscriber(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getSurgicalMedicalTranscriber();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity surgicalNurse(PreoperativeRecordsEntity preoperativeRecords) {
		return preoperativeRecords.getSurgicalNurse();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
