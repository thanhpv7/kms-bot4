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
package kmsweb.serializers;

import kmsweb.entities.BpjsINACBGClaimEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class BpjsINACBGClaimSerializer extends AbstractSerializer<BpjsINACBGClaimEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public BpjsINACBGClaimSerializer() {
		super(BpjsINACBGClaimEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(BpjsINACBGClaimEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "claimNo", value.getClaimNo());
		writeStringField(gen, "patientID", value.getPatientID());
		writeStringField(gen, "invoiceNumber", value.getInvoiceNumber());
		writeStringField(gen, "bpjsCardNo", value.getBpjsCardNo());
		writeStringField(gen, "sepNo", value.getSepNo());
		writeStringField(gen, "treatmentType", value.getTreatmentType());
		writeStringField(gen, "treatmentClass", value.getTreatmentClass());
		writeOffsetDateTimeField(gen, "admissionDate", value.getAdmissionDate());
		writeOffsetDateTimeField(gen, "dismissalDate", value.getDismissalDate());
		writeStringField(gen, "los", value.getLos());
		writeStringField(gen, "dismissal", value.getDismissal());
		writeStringField(gen, "responsibleDoctor", value.getResponsibleDoctor());
		writeDoubleField(gen, "weight", value.getWeight());
		writeIntegerField(gen, "adl", value.getAdl());
		writeStringField(gen, "claimStatus", value.getClaimStatus());
		writeStringField(gen, "sepStatus", value.getSepStatus());
		writeDoubleField(gen, "hospitalTariff", value.getHospitalTariff());
		writeStringField(gen, "referralLetter", value.getReferralLetter());
		writeStringField(gen, "thirdSelLevel", value.getThirdSelLevel());
		writeStringField(gen, "staffName", value.getStaffName());
		writeOffsetDateTimeField(gen, "dateGrouping", value.getDateGrouping());
		writeStringField(gen, "inacbgTariff", value.getInacbgTariff());
		writeStringField(gen, "description", value.getDescription());
		writeStringField(gen, "cbgType", value.getCbgType());
		writeDoubleField(gen, "tariff", value.getTariff());
		writeStringField(gen, "subAcute", value.getSubAcute());
		writeStringField(gen, "subAcuteCode", value.getSubAcuteCode());
		writeDoubleField(gen, "subAcuteTariff", value.getSubAcuteTariff());
		writeStringField(gen, "chronic", value.getChronic());
		writeStringField(gen, "chronicCode", value.getChronicCode());
		writeDoubleField(gen, "chronicTariff", value.getChronicTariff());
		writeStringField(gen, "resultSpecProcedure", value.getResultSpecProcedure());
		writeStringField(gen, "resultSpecDrug", value.getResultSpecDrug());
		writeStringField(gen, "resultSpecInvestigation", value.getResultSpecInvestigation());
		writeStringField(gen, "resultSpecProsthesis", value.getResultSpecProsthesis());
		writeStringField(gen, "hospitalClass", value.getHospitalClass());
		writeStringField(gen, "tariffType", value.getTariffType());
		writeDoubleField(gen, "totalTariff", value.getTotalTariff());
		writeOffsetDateTimeField(gen, "visitDate", value.getVisitDate());
		writeDoubleField(gen, "specProcedureTariff", value.getSpecProcedureTariff());
		writeDoubleField(gen, "specDrugTariff", value.getSpecDrugTariff());
		writeDoubleField(gen, "specInvestigationTariff", value.getSpecInvestigationTariff());
		writeDoubleField(gen, "specProsthesisTariff", value.getSpecProsthesisTariff());
		writeBooleanField(gen, "upgradeFlag", value.getUpgradeFlag());
		writeBooleanField(gen, "hcuFlag", value.getHcuFlag());
		writeBooleanField(gen, "grouperFlag", value.getGrouperFlag());
		writeDoubleField(gen, "nonSurgeryProcedure", value.getNonSurgeryProcedure());
		writeDoubleField(gen, "surgeryProcedure", value.getSurgeryProcedure());
		writeDoubleField(gen, "consultation", value.getConsultation());
		writeDoubleField(gen, "specialist", value.getSpecialist());
		writeDoubleField(gen, "nursing", value.getNursing());
		writeDoubleField(gen, "diagnostic", value.getDiagnostic());
		writeDoubleField(gen, "radiology", value.getRadiology());
		writeDoubleField(gen, "laboratory", value.getLaboratory());
		writeDoubleField(gen, "bloodService", value.getBloodService());
		writeDoubleField(gen, "rehabilitation", value.getRehabilitation());
		writeDoubleField(gen, "bedAccomodation", value.getBedAccomodation());
		writeDoubleField(gen, "intensiveCare", value.getIntensiveCare());
		writeDoubleField(gen, "drugs", value.getDrugs());
		writeDoubleField(gen, "medicalEquipment", value.getMedicalEquipment());
		writeDoubleField(gen, "dispensedDisposable", value.getDispensedDisposable());
		writeDoubleField(gen, "equipmentRental", value.getEquipmentRental());
		writeStringField(gen, "icd10Code", value.getIcd10Code());
		writeStringField(gen, "icd10Desc", value.getIcd10Desc());
		writeDoubleField(gen, "icd10Tariff", value.getIcd10Tariff());
		writeStringField(gen, "icd9cmCode", value.getIcd9cmCode());
		writeStringField(gen, "icd9cmDesc", value.getIcd9cmDesc());
		writeDoubleField(gen, "icd9cmTariff", value.getIcd9cmTariff());
		writeDoubleField(gen, "chronicDrugs", value.getChronicDrugs());
		writeDoubleField(gen, "chemotherapyDrugs", value.getChemotherapyDrugs());
		writeStringField(gen, "classUpgrade", value.getClassUpgrade());
		writeStringField(gen, "highCareUnit", value.getHighCareUnit());
		writeBooleanField(gen, "inacbgClaimCreated", value.getInacbgClaimCreated());
		writeStringField(gen, "inacbgResponse", value.getInacbgResponse());
		writeDoubleField(gen, "totalInvoice", value.getTotalInvoice());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}