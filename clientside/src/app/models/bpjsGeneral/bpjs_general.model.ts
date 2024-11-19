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
import {FormGroup, Validators} from '@angular/forms';
import {Group, AbstractModel, ModelProperty, ModelPropertyType, ModelRelation, ModelRelationType} from '../../lib/models/abstract.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsGeneralModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'consID',
		'secretKey',
		'aplicareWebServiceURL',
		'healthFacilityCode',
		'healthFacilityName',
		'vclaimUserKey',
		'connectToOtherSystem',
		'ismobilejkn',
		'externalSystemURL',
		'basicAuthUsername',
		'basicAuthPassword',
		'externalVclaimServiceURL',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'consID',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsGeneralModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsGeneralModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * ConsID given by BPJS.
	 */
	consID: string;

	/**
	 * SecretKey given by BPJS.
	 */
	secretKey: string;

	/**
	 * Vclaim Web Service URL.
	 */
	bpjsWebServiceURL: string;

	/**
	 * Ketersediaan Ruangan API for BPJS.
	 */
	aplicareWebServiceURL: string;

	/**
	 * Health Facility Code.
	 */
	healthFacilityCode: string;

	/**
	 * .
	 */
	healthFacilityName: string;

	/**
	 * .
	 */
	mjknWSBPJSURL: string;

	/**
	 * .
	 */
	mjknWSBPJSUserKey: string;

	/**
	 * .
	 */
	vclaimUserKey: string;

	/**
	 * Send Mobile JKN Data created in ehospital to other system ( KMS 5.4 ).
	 */
	connectToOtherSystem: boolean = false;

	/**
	 * Flag to determine the system is connected with the BPJS Mobile JKN or not.
	 */
	ismobilejkn: boolean = false;

	/**
	 * External System URL Web Service for send Mobile JKN Data.
	 */
	externalSystemURL: string;

	/**
	 * Flag for determine that the request to other system is using Authorization or not.
	 */
	basicAuth: boolean = false;

	/**
	 * Username.
	 */
	basicAuthUsername: string;

	/**
	 * Password.
	 */
	basicAuthPassword: string;

	/**
	 * Disable Checking Untrusted Certificate SSL.
	 */
	bypassSSLValidation: boolean = false;

	/**
	 * Flag to determines is BPJS Claim is bridged or not.
	 */
	claimStatus: boolean = false;

	/**
	 * Faskes 1 or Faskes 2.
	 */
	facilityType: string;

	/**
	 * Flag for determines the system should send the non BPJS registration to the BPJS or not.
	 */
	sendNonJKN: boolean = false;

	/**
	 * Sent vclaim data from ehospital to other system ( KMS 5.4 ).
	 */
	vclaimIntegration: boolean = false;

	/**
	 * External System URL Web Service for send Vclaim Data.
	 */
	externalVclaimServiceURL: string;



	modelPropGroups: { [s: string]: Group } = BpjsGeneralModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'consID',
				// % protected region % [Set displayName for Cons ID here] off begin
				displayName: 'Cons ID',
				// % protected region % [Set displayName for Cons ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Cons ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Cons ID here] end
				// % protected region % [Set isSensitive for Cons ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Cons ID here] end
				// % protected region % [Set readonly for Cons ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Cons ID here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.minLength(4),
					Validators.maxLength(15),
					// % protected region % [Add other validators for Cons ID here] off begin
					// % protected region % [Add other validators for Cons ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Cons ID here] off begin
				// % protected region % [Add any additional model attribute properties for Cons ID here] end
			},
			{
				name: 'secretKey',
				// % protected region % [Set displayName for Secret Key here] off begin
				displayName: 'Secret Key',
				// % protected region % [Set displayName for Secret Key here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Secret Key here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Secret Key here] end
				// % protected region % [Set isSensitive for Secret Key here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Secret Key here] end
				// % protected region % [Set readonly for Secret Key here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Secret Key here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(25),
					// % protected region % [Add other validators for Secret Key here] off begin
					// % protected region % [Add other validators for Secret Key here] end
				],
				// % protected region % [Add any additional model attribute properties for Secret Key here] off begin
				// % protected region % [Add any additional model attribute properties for Secret Key here] end
			},
			{
				name: 'bpjsWebServiceURL',
				// % protected region % [Set displayName for BPJS Web Service URL here] off begin
				displayName: 'BPJS Web Service URL',
				// % protected region % [Set displayName for BPJS Web Service URL here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BPJS Web Service URL here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BPJS Web Service URL here] end
				// % protected region % [Set isSensitive for BPJS Web Service URL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BPJS Web Service URL here] end
				// % protected region % [Set readonly for BPJS Web Service URL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BPJS Web Service URL here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for BPJS Web Service URL here] off begin
					// % protected region % [Add other validators for BPJS Web Service URL here] end
				],
				// % protected region % [Add any additional model attribute properties for BPJS Web Service URL here] off begin
				// % protected region % [Add any additional model attribute properties for BPJS Web Service URL here] end
			},
			{
				name: 'aplicareWebServiceURL',
				// % protected region % [Set displayName for Aplicare Web Service URL here] off begin
				displayName: 'Aplicare Web Service URL',
				// % protected region % [Set displayName for Aplicare Web Service URL here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Aplicare Web Service URL here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Aplicare Web Service URL here] end
				// % protected region % [Set isSensitive for Aplicare Web Service URL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Aplicare Web Service URL here] end
				// % protected region % [Set readonly for Aplicare Web Service URL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Aplicare Web Service URL here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Aplicare Web Service URL here] off begin
					// % protected region % [Add other validators for Aplicare Web Service URL here] end
				],
				// % protected region % [Add any additional model attribute properties for Aplicare Web Service URL here] off begin
				// % protected region % [Add any additional model attribute properties for Aplicare Web Service URL here] end
			},
			{
				name: 'healthFacilityCode',
				// % protected region % [Set displayName for Health Facility Code here] off begin
				displayName: 'Health Facility Code',
				// % protected region % [Set displayName for Health Facility Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Health Facility Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Health Facility Code here] end
				// % protected region % [Set isSensitive for Health Facility Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Health Facility Code here] end
				// % protected region % [Set readonly for Health Facility Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Health Facility Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(25),
					// % protected region % [Add other validators for Health Facility Code here] off begin
					// % protected region % [Add other validators for Health Facility Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Health Facility Code here] off begin
				// % protected region % [Add any additional model attribute properties for Health Facility Code here] end
			},
			{
				name: 'healthFacilityName',
				// % protected region % [Set displayName for Health Facility Name here] off begin
				displayName: 'Health Facility Name',
				// % protected region % [Set displayName for Health Facility Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Health Facility Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Health Facility Name here] end
				// % protected region % [Set isSensitive for Health Facility Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Health Facility Name here] end
				// % protected region % [Set readonly for Health Facility Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Health Facility Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(100),
					// % protected region % [Add other validators for Health Facility Name here] off begin
					// % protected region % [Add other validators for Health Facility Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Health Facility Name here] off begin
				// % protected region % [Add any additional model attribute properties for Health Facility Name here] end
			},
			{
				name: 'mjknWSBPJSURL',
				// % protected region % [Set displayName for MJKN WS BPJS URL here] off begin
				displayName: 'MJKN WS BPJS URL',
				// % protected region % [Set displayName for MJKN WS BPJS URL here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for MJKN WS BPJS URL here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for MJKN WS BPJS URL here] end
				// % protected region % [Set isSensitive for MJKN WS BPJS URL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for MJKN WS BPJS URL here] end
				// % protected region % [Set readonly for MJKN WS BPJS URL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for MJKN WS BPJS URL here] end
				validators: [
					// % protected region % [Add other validators for MJKN WS BPJS URL here] off begin
					// % protected region % [Add other validators for MJKN WS BPJS URL here] end
				],
				// % protected region % [Add any additional model attribute properties for MJKN WS BPJS URL here] off begin
				// % protected region % [Add any additional model attribute properties for MJKN WS BPJS URL here] end
			},
			{
				name: 'mjknWSBPJSUserKey',
				// % protected region % [Set displayName for MJKN WS BPJS User Key here] off begin
				displayName: 'MJKN WS BPJS User Key',
				// % protected region % [Set displayName for MJKN WS BPJS User Key here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for MJKN WS BPJS User Key here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for MJKN WS BPJS User Key here] end
				// % protected region % [Set isSensitive for MJKN WS BPJS User Key here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for MJKN WS BPJS User Key here] end
				// % protected region % [Set readonly for MJKN WS BPJS User Key here] off begin
				readOnly: false,
				// % protected region % [Set readonly for MJKN WS BPJS User Key here] end
				validators: [
					// % protected region % [Add other validators for MJKN WS BPJS User Key here] off begin
					// % protected region % [Add other validators for MJKN WS BPJS User Key here] end
				],
				// % protected region % [Add any additional model attribute properties for MJKN WS BPJS User Key here] off begin
				// % protected region % [Add any additional model attribute properties for MJKN WS BPJS User Key here] end
			},
			{
				name: 'vclaimUserKey',
				// % protected region % [Set displayName for Vclaim User Key here] off begin
				displayName: 'Vclaim User Key',
				// % protected region % [Set displayName for Vclaim User Key here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Vclaim User Key here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Vclaim User Key here] end
				// % protected region % [Set isSensitive for Vclaim User Key here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Vclaim User Key here] end
				// % protected region % [Set readonly for Vclaim User Key here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Vclaim User Key here] end
				validators: [
					// % protected region % [Add other validators for Vclaim User Key here] off begin
					// % protected region % [Add other validators for Vclaim User Key here] end
				],
				// % protected region % [Add any additional model attribute properties for Vclaim User Key here] off begin
				// % protected region % [Add any additional model attribute properties for Vclaim User Key here] end
			},
			{
				name: 'connectToOtherSystem',
				// % protected region % [Set displayName for Connect To Other System here] off begin
				displayName: 'Connect To Other System',
				// % protected region % [Set displayName for Connect To Other System here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Connect To Other System here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Connect To Other System here] end
				// % protected region % [Set isSensitive for Connect To Other System here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Connect To Other System here] end
				// % protected region % [Set readonly for Connect To Other System here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Connect To Other System here] end
				validators: [
					// % protected region % [Add other validators for Connect To Other System here] off begin
					// % protected region % [Add other validators for Connect To Other System here] end
				],
				// % protected region % [Add any additional model attribute properties for Connect To Other System here] off begin
				// % protected region % [Add any additional model attribute properties for Connect To Other System here] end
			},
			{
				name: 'ismobilejkn',
				// % protected region % [Set displayName for IsMobileJKN here] off begin
				displayName: 'IsMobileJKN',
				// % protected region % [Set displayName for IsMobileJKN here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for IsMobileJKN here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for IsMobileJKN here] end
				// % protected region % [Set isSensitive for IsMobileJKN here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for IsMobileJKN here] end
				// % protected region % [Set readonly for IsMobileJKN here] off begin
				readOnly: false,
				// % protected region % [Set readonly for IsMobileJKN here] end
				validators: [
					// % protected region % [Add other validators for IsMobileJKN here] off begin
					// % protected region % [Add other validators for IsMobileJKN here] end
				],
				// % protected region % [Add any additional model attribute properties for IsMobileJKN here] off begin
				// % protected region % [Add any additional model attribute properties for IsMobileJKN here] end
			},
			{
				name: 'externalSystemURL',
				// % protected region % [Set displayName for External System URL here] off begin
				displayName: 'External System URL',
				// % protected region % [Set displayName for External System URL here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for External System URL here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for External System URL here] end
				// % protected region % [Set isSensitive for External System URL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for External System URL here] end
				// % protected region % [Set readonly for External System URL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for External System URL here] end
				validators: [
					// % protected region % [Add other validators for External System URL here] off begin
					// % protected region % [Add other validators for External System URL here] end
				],
				// % protected region % [Add any additional model attribute properties for External System URL here] off begin
				// % protected region % [Add any additional model attribute properties for External System URL here] end
			},
			{
				name: 'basicAuth',
				// % protected region % [Set displayName for Basic Auth here] off begin
				displayName: 'Basic Auth',
				// % protected region % [Set displayName for Basic Auth here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Basic Auth here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Basic Auth here] end
				// % protected region % [Set isSensitive for Basic Auth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Basic Auth here] end
				// % protected region % [Set readonly for Basic Auth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Basic Auth here] end
				validators: [
					// % protected region % [Add other validators for Basic Auth here] off begin
					// % protected region % [Add other validators for Basic Auth here] end
				],
				// % protected region % [Add any additional model attribute properties for Basic Auth here] off begin
				// % protected region % [Add any additional model attribute properties for Basic Auth here] end
			},
			{
				name: 'basicAuthUsername',
				// % protected region % [Set displayName for Basic Auth Username here] off begin
				displayName: 'Basic Auth Username',
				// % protected region % [Set displayName for Basic Auth Username here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Basic Auth Username here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Basic Auth Username here] end
				// % protected region % [Set isSensitive for Basic Auth Username here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Basic Auth Username here] end
				// % protected region % [Set readonly for Basic Auth Username here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Basic Auth Username here] end
				validators: [
					// % protected region % [Add other validators for Basic Auth Username here] off begin
					// % protected region % [Add other validators for Basic Auth Username here] end
				],
				// % protected region % [Add any additional model attribute properties for Basic Auth Username here] off begin
				// % protected region % [Add any additional model attribute properties for Basic Auth Username here] end
			},
			{
				name: 'basicAuthPassword',
				// % protected region % [Set displayName for Basic Auth Password here] off begin
				displayName: 'Basic Auth Password',
				// % protected region % [Set displayName for Basic Auth Password here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Basic Auth Password here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Basic Auth Password here] end
				// % protected region % [Set isSensitive for Basic Auth Password here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Basic Auth Password here] end
				// % protected region % [Set readonly for Basic Auth Password here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Basic Auth Password here] end
				validators: [
					// % protected region % [Add other validators for Basic Auth Password here] off begin
					// % protected region % [Add other validators for Basic Auth Password here] end
				],
				// % protected region % [Add any additional model attribute properties for Basic Auth Password here] off begin
				// % protected region % [Add any additional model attribute properties for Basic Auth Password here] end
			},
			{
				name: 'bypassSSLValidation',
				// % protected region % [Set displayName for Bypass SSL Validation here] off begin
				displayName: 'Bypass SSL Validation',
				// % protected region % [Set displayName for Bypass SSL Validation here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Bypass SSL Validation here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Bypass SSL Validation here] end
				// % protected region % [Set isSensitive for Bypass SSL Validation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bypass SSL Validation here] end
				// % protected region % [Set readonly for Bypass SSL Validation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bypass SSL Validation here] end
				validators: [
					// % protected region % [Add other validators for Bypass SSL Validation here] off begin
					// % protected region % [Add other validators for Bypass SSL Validation here] end
				],
				// % protected region % [Add any additional model attribute properties for Bypass SSL Validation here] off begin
				// % protected region % [Add any additional model attribute properties for Bypass SSL Validation here] end
			},
			{
				name: 'claimStatus',
				// % protected region % [Set displayName for Claim Status here] off begin
				displayName: 'Claim Status',
				// % protected region % [Set displayName for Claim Status here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Claim Status here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Claim Status here] end
				// % protected region % [Set isSensitive for Claim Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Claim Status here] end
				// % protected region % [Set readonly for Claim Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Claim Status here] end
				validators: [
					// % protected region % [Add other validators for Claim Status here] off begin
					// % protected region % [Add other validators for Claim Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Claim Status here] off begin
				// % protected region % [Add any additional model attribute properties for Claim Status here] end
			},
			{
				name: 'facilityType',
				// % protected region % [Set displayName for Facility Type here] off begin
				displayName: 'Facility Type',
				// % protected region % [Set displayName for Facility Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Facility Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Facility Type here] end
				// % protected region % [Set isSensitive for Facility Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Facility Type here] end
				// % protected region % [Set readonly for Facility Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Facility Type here] end
				validators: [
					// % protected region % [Add other validators for Facility Type here] off begin
					// % protected region % [Add other validators for Facility Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Facility Type here] off begin
				// % protected region % [Add any additional model attribute properties for Facility Type here] end
			},
			{
				name: 'sendNonJKN',
				// % protected region % [Set displayName for Send Non JKN here] off begin
				displayName: 'Send Non JKN',
				// % protected region % [Set displayName for Send Non JKN here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Send Non JKN here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Send Non JKN here] end
				// % protected region % [Set isSensitive for Send Non JKN here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Send Non JKN here] end
				// % protected region % [Set readonly for Send Non JKN here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Send Non JKN here] end
				validators: [
					// % protected region % [Add other validators for Send Non JKN here] off begin
					// % protected region % [Add other validators for Send Non JKN here] end
				],
				// % protected region % [Add any additional model attribute properties for Send Non JKN here] off begin
				// % protected region % [Add any additional model attribute properties for Send Non JKN here] end
			},
			{
				name: 'vclaimIntegration',
				// % protected region % [Set displayName for Vclaim Integration here] off begin
				displayName: 'Vclaim Integration',
				// % protected region % [Set displayName for Vclaim Integration here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Vclaim Integration here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Vclaim Integration here] end
				// % protected region % [Set isSensitive for Vclaim Integration here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Vclaim Integration here] end
				// % protected region % [Set readonly for Vclaim Integration here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Vclaim Integration here] end
				validators: [
					// % protected region % [Add other validators for Vclaim Integration here] off begin
					// % protected region % [Add other validators for Vclaim Integration here] end
				],
				// % protected region % [Add any additional model attribute properties for Vclaim Integration here] off begin
				// % protected region % [Add any additional model attribute properties for Vclaim Integration here] end
			},
			{
				name: 'externalVclaimServiceURL',
				// % protected region % [Set displayName for External Vclaim Service URL here] off begin
				displayName: 'External Vclaim Service URL',
				// % protected region % [Set displayName for External Vclaim Service URL here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for External Vclaim Service URL here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for External Vclaim Service URL here] end
				// % protected region % [Set isSensitive for External Vclaim Service URL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for External Vclaim Service URL here] end
				// % protected region % [Set readonly for External Vclaim Service URL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for External Vclaim Service URL here] end
				validators: [
					// % protected region % [Add other validators for External Vclaim Service URL here] off begin
					// % protected region % [Add other validators for External Vclaim Service URL here] end
				],
				// % protected region % [Add any additional model attribute properties for External Vclaim Service URL here] off begin
				// % protected region % [Add any additional model attribute properties for External Vclaim Service URL here] end
			},
			// % protected region % [Add any additional class field names here] off begin
			// % protected region % [Add any additional class field names here] end
		]);
	}

	/**
	 * The relations of the entity
	 */
	static getRelations(): ModelRelation[] {
		return super.getRelations().concat([
		]);
	}

	/**
	 * Convert the form group to the query conditions
	 */
	static convertFilterToCondition(formGroup: FormGroup): Where[][] {
		let conditions: Where[][] = [];

		// % protected region % [Overide the default convertFilterToCondition here] off begin
		Object.keys(formGroup.value).forEach((key) => {
			switch (key) {
				case 'consID':
					break;
				case 'secretKey':
					break;
				case 'aplicareWebServiceURL':
					break;
				case 'healthFacilityCode':
					break;
				case 'healthFacilityName':
					break;
				case 'vclaimUserKey':
					break;
				case 'connectToOtherSystem':
					break;
				case 'ismobilejkn':
					break;
				case 'externalSystemURL':
					break;
				case 'basicAuthUsername':
					break;
				case 'basicAuthPassword':
					break;
				case 'externalVclaimServiceURL':
					break;
				case 'created':
					const created = formGroup.value[key];
					// is the range of date
					if (created instanceof Array) {
						conditions.push([
							{
								path: key,
								operation: QueryOperation.GREATER_THAN_OR_EQUAL,
								value: created[0]
							}
						]);
						conditions.push([
							{
								path: key,
								operation: QueryOperation.LESS_THAN_OR_EQUAL,
								value: created[1]
							}
						]);
					}
			}
		});
		// % protected region % [Overide the default convertFilterToCondition here] end


		return conditions;
	}

	/**
	 * Convert a nested JSON object into an array of flatten objects.
	 */
	static deepParse(data: string | { [K in keyof BpjsGeneralModel]?: BpjsGeneralModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsGeneralModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsGeneralModel = new BpjsGeneralModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsGeneralModel,
	 *    it is expected as a JSON string or as a nullable BpjsGeneralModel.
	 */
	constructor(data?: string | Partial<BpjsGeneralModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsGeneralModel>
				: data;

			this.consID = json.consID;
			this.secretKey = json.secretKey;
			this.bpjsWebServiceURL = json.bpjsWebServiceURL;
			this.aplicareWebServiceURL = json.aplicareWebServiceURL;
			this.healthFacilityCode = json.healthFacilityCode;
			this.healthFacilityName = json.healthFacilityName;
			this.mjknWSBPJSURL = json.mjknWSBPJSURL;
			this.mjknWSBPJSUserKey = json.mjknWSBPJSUserKey;
			this.vclaimUserKey = json.vclaimUserKey;
			this.connectToOtherSystem = json.connectToOtherSystem;
			this.ismobilejkn = json.ismobilejkn;
			this.externalSystemURL = json.externalSystemURL;
			this.basicAuth = json.basicAuth;
			this.basicAuthUsername = json.basicAuthUsername;
			this.basicAuthPassword = json.basicAuthPassword;
			this.bypassSSLValidation = json.bypassSSLValidation;
			this.claimStatus = json.claimStatus;
			this.facilityType = json.facilityType;
			this.sendNonJKN = json.sendNonJKN;
			this.vclaimIntegration = json.vclaimIntegration;
			this.externalVclaimServiceURL = json.externalVclaimServiceURL;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			consID: this.consID,
			secretKey: this.secretKey,
			bpjsWebServiceURL: this.bpjsWebServiceURL,
			aplicareWebServiceURL: this.aplicareWebServiceURL,
			healthFacilityCode: this.healthFacilityCode,
			healthFacilityName: this.healthFacilityName,
			mjknWSBPJSURL: this.mjknWSBPJSURL,
			mjknWSBPJSUserKey: this.mjknWSBPJSUserKey,
			vclaimUserKey: this.vclaimUserKey,
			connectToOtherSystem: this.connectToOtherSystem,
			ismobilejkn: this.ismobilejkn,
			externalSystemURL: this.externalSystemURL,
			basicAuth: this.basicAuth,
			basicAuthUsername: this.basicAuthUsername,
			basicAuthPassword: this.basicAuthPassword,
			bypassSSLValidation: this.bypassSSLValidation,
			claimStatus: this.claimStatus,
			facilityType: this.facilityType,
			sendNonJKN: this.sendNonJKN,
			vclaimIntegration: this.vclaimIntegration,
			externalVclaimServiceURL: this.externalVclaimServiceURL,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsGeneralModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsGeneralModel {
		let newModelJson = this.toJSON();

		if (updates.consID) {
			newModelJson.consID = updates.consID;
		}

		if (updates.secretKey) {
			newModelJson.secretKey = updates.secretKey;
		}

		if (updates.bpjsWebServiceURL) {
			newModelJson.bpjsWebServiceURL = updates.bpjsWebServiceURL;
		}

		if (updates.aplicareWebServiceURL) {
			newModelJson.aplicareWebServiceURL = updates.aplicareWebServiceURL;
		}

		if (updates.healthFacilityCode) {
			newModelJson.healthFacilityCode = updates.healthFacilityCode;
		}

		if (updates.healthFacilityName) {
			newModelJson.healthFacilityName = updates.healthFacilityName;
		}

		if (updates.mjknWSBPJSURL) {
			newModelJson.mjknWSBPJSURL = updates.mjknWSBPJSURL;
		}

		if (updates.mjknWSBPJSUserKey) {
			newModelJson.mjknWSBPJSUserKey = updates.mjknWSBPJSUserKey;
		}

		if (updates.vclaimUserKey) {
			newModelJson.vclaimUserKey = updates.vclaimUserKey;
		}

		if (updates.connectToOtherSystem) {
			newModelJson.connectToOtherSystem = updates.connectToOtherSystem;
		}

		if (updates.ismobilejkn) {
			newModelJson.ismobilejkn = updates.ismobilejkn;
		}

		if (updates.externalSystemURL) {
			newModelJson.externalSystemURL = updates.externalSystemURL;
		}

		if (updates.basicAuth) {
			newModelJson.basicAuth = updates.basicAuth;
		}

		if (updates.basicAuthUsername) {
			newModelJson.basicAuthUsername = updates.basicAuthUsername;
		}

		if (updates.basicAuthPassword) {
			newModelJson.basicAuthPassword = updates.basicAuthPassword;
		}

		if (updates.bypassSSLValidation) {
			newModelJson.bypassSSLValidation = updates.bypassSSLValidation;
		}

		if (updates.claimStatus) {
			newModelJson.claimStatus = updates.claimStatus;
		}

		if (updates.facilityType) {
			newModelJson.facilityType = updates.facilityType;
		}

		if (updates.sendNonJKN) {
			newModelJson.sendNonJKN = updates.sendNonJKN;
		}

		if (updates.vclaimIntegration) {
			newModelJson.vclaimIntegration = updates.vclaimIntegration;
		}

		if (updates.externalVclaimServiceURL) {
			newModelJson.externalVclaimServiceURL = updates.externalVclaimServiceURL;
		}

		return new BpjsGeneralModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsGeneralModel)) {
			return {};
		}

		const diff = {};

		for (const key of _.keys(this)) {
			const thisValue = this[key];
			const otherValue = other[key];

			// Handle dates differently
			if (thisValue instanceof Date) {
				let thisDate = (thisValue) ? thisValue.getTime() : null;
				let otherDate = (otherValue) ? otherValue.getTime() : null;

				if (thisDate !== otherDate) {
					diff[key] = thisValue;
				}
			} else if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
			// % protected region % [Add any other fields to omit here] off begin
			// % protected region % [Add any other fields to omit here] end
		]);
	}

	/**
	 * Sets the relation ID parameters to be based on the ID's of the associated entities.
	 * 
	 * Fetching entities is based on the object, but updating relations is based on the id, so we need to
	 * make sure that they match
	 */
	syncRelations() {
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
