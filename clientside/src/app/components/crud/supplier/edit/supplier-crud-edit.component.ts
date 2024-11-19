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

import {Component, EventEmitter, Input, OnChanges, OnInit, OnDestroy, Output, SimpleChanges} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {Observable, Subject, Subscription} from 'rxjs';
import { ActivatedRoute, NavigationExtras } from '@angular/router';
import {debounceTime, distinctUntilChanged, map, filter} from 'rxjs/operators';
import {Store, Action as NgRxAction} from '@ngrx/store';
import * as routingAction from 'src/app/lib/routing/routing.action';
import {Group, ModelProperty, ModelRelation} from 'src/app/lib/models/abstract.model';
import * as modelAction from 'src/app/models/supplier/supplier.model.action';
import {SupplierModelState, SupplierModelAudit} from 'src/app/models/supplier/supplier.model.state';
import {SupplierModel} from 'src/app/models/supplier/supplier.model';
import {
	getSupplierModelAuditsByEntityId,
	getSupplierModelWithId,
	getCountSupplierModels,
} from 'src/app/models/supplier/supplier.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {GoodsReceiveNoteModel} from 'src/app/models/goodsReceiveNote/goods_receive_note.model';
import * as goodsReceiveNoteModelAction from 'src/app/models/goodsReceiveNote/goods_receive_note.model.action';
import {
	getGoodsReceiveNoteCollectionModels, getGoodsReceiveNoteModelWithId,
} from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import {PurchaseOrderModel} from 'src/app/models/purchaseOrder/purchase_order.model';
import * as purchaseOrderModelAction from 'src/app/models/purchaseOrder/purchase_order.model.action';
import {
	getPurchaseOrderCollectionModels, getPurchaseOrderModelWithId,
} from 'src/app/models/purchaseOrder/purchase_order.model.selector';
import {PurchaseRequisitionModel} from 'src/app/models/purchaseRequisition/purchase_requisition.model';
import * as purchaseRequisitionModelAction from 'src/app/models/purchaseRequisition/purchase_requisition.model.action';
import {
	getPurchaseRequisitionCollectionModels, getPurchaseRequisitionModelWithId,
} from 'src/app/models/purchaseRequisition/purchase_requisition.model.selector';
import {ReturnSupplierModel} from 'src/app/models/returnSupplier/return_supplier.model';
import * as returnSupplierModelAction from 'src/app/models/returnSupplier/return_supplier.model.action';
import {
	getReturnSupplierCollectionModels, getReturnSupplierModelWithId,
} from 'src/app/models/returnSupplier/return_supplier.model.selector';
import {SupplierBankAccountModel} from 'src/app/models/supplierBankAccount/supplier_bank_account.model';
import * as supplierBankAccountModelAction from 'src/app/models/supplierBankAccount/supplier_bank_account.model.action';
import {
	getSupplierBankAccountCollectionModels, getSupplierBankAccountModelWithId,
} from 'src/app/models/supplierBankAccount/supplier_bank_account.model.selector';
import {SupplierContactDetailModel} from 'src/app/models/supplierContactDetail/supplier_contact_detail.model';
import * as supplierContactDetailModelAction from 'src/app/models/supplierContactDetail/supplier_contact_detail.model.action';
import {
	getSupplierContactDetailCollectionModels, getSupplierContactDetailModelWithId,
} from 'src/app/models/supplierContactDetail/supplier_contact_detail.model.selector';
import {SupplierProductDetailModel} from 'src/app/models/supplierProductDetail/supplier_product_detail.model';
import * as supplierProductDetailModelAction from 'src/app/models/supplierProductDetail/supplier_product_detail.model.action';
import {
	getSupplierProductDetailCollectionModels, getSupplierProductDetailModelWithId,
} from 'src/app/models/supplierProductDetail/supplier_product_detail.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../supplier-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-supplier-crud-edit',
	templateUrl: './supplier-crud-edit.component.html',
	styleUrls: [
		'./supplier-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class SupplierCrudEditComponent
		// % protected region % [Add any additional interfaces to implement here] off begin
		implements OnInit, OnChanges, OnDestroy
		// % protected region % [Add any additional interfaces to implement here] end
{

	/************************************************************************
	 *	   _____             __ _         ______ _      _     _
	 *  / ____|           / _(_)       |  ____(_)    | |   | |
	 * | |     ___  _ __ | |_ _  __ _  | |__   _  ___| | __| |___
	 * | |    / _ \| '_ \|  _| |/ _` | |  __| | |/ _ \ |/ _` / __|
	 * | |___| (_) | | | | | | | (_| | | |    | |  __/ | (_| \__ \
	 *  \_____\___/|_| |_|_| |_|\__, | |_|    |_|\___|_|\__,_|___/
	 *                           __/ |
	 *                          |___/
	 ************************************************************************/
	/**
	 * Whether route component
	 */
	@Input()
	singlePageComponent = false;

	/**
	 * Whether in create/edit/view mode
	 * Only used when singlePageComponent is turned on
	 * Routing will overwrite this according to the url path
	 */
	@Input()
	tileMode: CrudTileMode = CrudTileMode.Create;

	/**
	 * Id of entity to display
	 * Only used when singlePageComponent is turned on
	 */
	@Input()
	targetModelId: string;

	/**
	 * How many items are included in this page.
	 */
	@Input()
	pageSize: number = 10;

	// % protected region % [Change your collection id if required here] off begin
	/**
	 * The collection id used in the store
	 * Default to be the uuid of the tile, you could change this to custom id you want to share in different component
	 *
	 */
	@Input()
	collectionId: string = '2ebfffc0-16e6-464b-8b1e-84278a2700b9';
	// % protected region % [Change your collection id if required here] end

	/**
	 * Event emitter when user clicking button to change mode of tile
	 */
	@Output()
	tileModeChange: EventEmitter<{tileMode: CrudTileMode, payload?: any}> = new EventEmitter();

	/**
	 * Whether componet is view only
	 */
	get isViewOnly(): boolean {
		return this.tileMode === CrudTileMode.View;
	}

	/**
	 * Entity audits to be fetched from the server.
	 */
	supplierAudits$: Observable<SupplierModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Goods Receive Notes here] off begin
	goodsReceiveNotesMultiCrudActive: boolean = false;
	goodsReceiveNotesDisplayName = 'Goods Receive Notes';
	goodsReceiveNotesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Goods Receive Notes here] end
	goodsReceiveNotesOppositeRelation = 'supplier';
	goodsReceiveNotesRelations: ModelRelation[] = this.goodsReceiveNotesMultiCrudActive ? GoodsReceiveNoteModel.getRelations()
		.map(relation => {
			if (relation.id === this.goodsReceiveNotesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Purchase Orders here] off begin
	purchaseOrdersMultiCrudActive: boolean = false;
	purchaseOrdersDisplayName = 'Purchase Orders';
	purchaseOrdersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Purchase Orders here] end
	purchaseOrdersOppositeRelation = 'supplier';
	purchaseOrdersRelations: ModelRelation[] = this.purchaseOrdersMultiCrudActive ? PurchaseOrderModel.getRelations()
		.map(relation => {
			if (relation.id === this.purchaseOrdersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Purchase Requisitions here] off begin
	purchaseRequisitionsMultiCrudActive: boolean = false;
	purchaseRequisitionsDisplayName = 'Purchase Requisitions';
	purchaseRequisitionsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Purchase Requisitions here] end
	purchaseRequisitionsOppositeRelation = 'supplier';
	purchaseRequisitionsRelations: ModelRelation[] = this.purchaseRequisitionsMultiCrudActive ? PurchaseRequisitionModel.getRelations()
		.map(relation => {
			if (relation.id === this.purchaseRequisitionsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Return Suppliers here] off begin
	returnSuppliersMultiCrudActive: boolean = false;
	returnSuppliersDisplayName = 'Return Suppliers';
	returnSuppliersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Return Suppliers here] end
	returnSuppliersOppositeRelation = 'supplier';
	returnSuppliersRelations: ModelRelation[] = this.returnSuppliersMultiCrudActive ? ReturnSupplierModel.getRelations()
		.map(relation => {
			if (relation.id === this.returnSuppliersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Suplier Contact Details here] off begin
	suplierContactDetailsMultiCrudActive: boolean = false;
	suplierContactDetailsDisplayName = 'Suplier Contact Details';
	suplierContactDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Suplier Contact Details here] end
	suplierContactDetailsOppositeRelation = 'supplier';
	suplierContactDetailsRelations: ModelRelation[] = this.suplierContactDetailsMultiCrudActive ? SupplierContactDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.suplierContactDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Supplier Bank Accounts here] off begin
	supplierBankAccountsMultiCrudActive: boolean = false;
	supplierBankAccountsDisplayName = 'Supplier Bank Accounts';
	supplierBankAccountsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Supplier Bank Accounts here] end
	supplierBankAccountsOppositeRelation = 'supplier';
	supplierBankAccountsRelations: ModelRelation[] = this.supplierBankAccountsMultiCrudActive ? SupplierBankAccountModel.getRelations()
		.map(relation => {
			if (relation.id === this.supplierBankAccountsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Supplier Product Details here] off begin
	supplierProductDetailsMultiCrudActive: boolean = false;
	supplierProductDetailsDisplayName = 'Supplier Product Details';
	supplierProductDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Supplier and Supplier Product Details here] end
	supplierProductDetailsOppositeRelation = 'supplier';
	supplierProductDetailsRelations: ModelRelation[] = this.supplierProductDetailsMultiCrudActive ? SupplierProductDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.supplierProductDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = SupplierModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = SupplierModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = SupplierModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'goodsReceiveNotes' && this.goodsReceiveNotesMultiCrudActive) {
					exp.fields = GoodsReceiveNoteModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'purchaseOrders' && this.purchaseOrdersMultiCrudActive) {
					exp.fields = PurchaseOrderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'purchaseRequisitions' && this.purchaseRequisitionsMultiCrudActive) {
					exp.fields = PurchaseRequisitionModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'returnSuppliers' && this.returnSuppliersMultiCrudActive) {
					exp.fields = ReturnSupplierModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'suplierContactDetails' && this.suplierContactDetailsMultiCrudActive) {
					exp.fields = SupplierContactDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'supplierBankAccounts' && this.supplierBankAccountsMultiCrudActive) {
					exp.fields = SupplierBankAccountModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'supplierProductDetails' && this.supplierProductDetailsMultiCrudActive) {
					exp.fields = SupplierProductDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				return exp;
			}
		);
		return expands;
	}
	// % protected region % [Change your default expands if required here] end

	/**
	 * The model to be created or edited depending on what the model currently is.
	 */
	targetModel: SupplierModel;

	/**
	 * The form group created from the target model
	 */
	modelFormGroup: FormGroup;

	/**
	 * The current router state when this page is displayed.
	 */
	routerState: RouterState;

	/**
	 * Unsubscribe from this subscription when the crud component is destroyed
	 */
	routerStateSubscription$: Subscription;

	/**
	 * The Names of the buttons to be passed to the crud edit page for adding additional entities to the multi crud view.
	 * This requires a list of strings, where each string will become a button which sends an event back to onMultiEntityAction()
	 */
	defaultMultiEntityButtons: {name: string, many: boolean}[] = [];


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		private readonly store: Store<{ model: SupplierModelState }>,
		private readonly routerStore: Store<{ router: RouterState }>,
		private readonly activatedRoute: ActivatedRoute,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnChanges(changes: SimpleChanges) {
		// % protected region % [Add any additional ngOnChanges logic before the main body here] off begin
		// % protected region % [Add any additional ngOnChanges logic before the main body here] end

		// % protected region % [Customise the ngOnChanges main body here] off begin
		if (changes.hasOwnProperty('tileMode') || changes.hasOwnProperty('targetModelId')) {
			this.initializeTargetModel();
		}
		// % protected region % [Customise the ngOnChanges main body here] end

		// % protected region % [Add any additional ngOnChanges logic after the main body here] off begin
		// % protected region % [Add any additional ngOnChanges logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnInit() {
		// % protected region % [Add any additional ngOnInit logic before the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic before the main body here] end

		this.initialiseMultiEntityCollections();

		this.routerStateSubscription$ = this.routerStore.select(getRouterState).subscribe(routerState => {
				this.routerState = routerState;
				this.initializeTargetModel();
			}
		);

		let firstTime = true; // ensures that the user isn't instantly navigated back to the list page
		/**
		 * Tile Mode Change will not be triggered until the creation action has been dispatched and completed
		 * Subscribing in ngOnInit ensures that a count models action can be passed as an afterwards action, so the
		 * subscribed code will not be triggered until after the creation has been completed
		 */
		this.creationNavigationSubscription$.add(this.store.select(getCountSupplierModels).subscribe(count => {
			if (this.singlePageComponent && !firstTime) {
				this.triggerTileModeChange(CrudTileMode.List);
			}

			firstTime = false;
		}));

		// % protected region % [Add any additional ngOnInit logic after the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnDestroy() {
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] end

		if (this.routerStateSubscription$) {
			this.routerStateSubscription$.unsubscribe();
		}

		if (this.creationNavigationSubscription$) {
			this.creationNavigationSubscription$.unsubscribe();
		}

		// % protected region % [Add any additional ngOnDestroy logic after the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic after the main body here] end
	}

	/**
	 * Initialize target model when input fields changed or router changed
	 */
	private initializeTargetModel() {
		// % protected region % [Add any additional initializeTargetModel logic before the main body here] off begin
		// % protected region % [Add any additional initializeTargetModel logic before the main body here] end

		if (!this.singlePageComponent) {
			this.initWithRouting();
		}

		// When tile mode is not defiend, reutrn directly without fetching data
		if (this.tileMode === undefined) {
			return;
		}

		this.resetPropsAndRels();
		this.prepareReferenceCollections();
		this.createReactiveForm();

		if (this.tileMode === CrudTileMode.Edit || this.tileMode === CrudTileMode.View) {
			// % protected region % [Add additional processing for View and Edit mode before the main body here] off begin
			// % protected region % [Add additional processing for View and Edit mode before the main body here] end

			this.fetchEntity();

			// % protected region % [Add additional processing for View and Edit mode after the main body here] off begin
			// % protected region % [Add additional processing for View and Edit mode after the main body here] end
		} else if (this.tileMode === CrudTileMode.Create) {
			// % protected region % [Add additional processing for Create mode before the main body here] off begin
			// % protected region % [Add additional processing for Create mode before the main body here] end

			this.targetModel = new SupplierModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.supplierAudits$ = this.store.select(getSupplierModelAuditsByEntityId, this.targetModelId);
		}

		// % protected region % [Add any additional initializeTargetModel logic after the main body here] off begin
		// % protected region % [Add any additional initializeTargetModel logic after the main body here] end
	}

	/**
	 * Function to initialize the component fields according to the routing
	 * Method only be invoked when routing is enabled
	 */
	private initWithRouting() {
		// % protected region % [Override the initWithRouting method body here] off begin
		this.targetModelId = this.routerState.params.id;
		if (this.routerState.urls.includes('view')) {
			this.tileMode = CrudTileMode.View;
		} else if (this.routerState.urls.includes('edit')) {
			this.tileMode = CrudTileMode.Edit;
		} else if (this.routerState.urls.includes('create')) {
			this.tileMode = CrudTileMode.Create;
		} else {
			this.tileMode = undefined;
		}
		// % protected region % [Override the initWithRouting method body here] end
	}

	/**
	 * Initialize and dispatch event to fetch data from serverside
	 */
	private fetchEntity() {
		const stateConfig: PassableStateConfig<SupplierModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.SupplierAction(
			modelAction.SupplierModelActionTypes.FETCH_SUPPLIER,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getSupplierModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new SupplierModel(model);
			model.syncRelations();

			this.targetModel = model;
			if (this.targetModel) {
				this.modelFormGroup.patchValue(this.targetModel);
			}

			this.multiCrudFetchAdditionalEntities();

			// % protected region % [Add additional actions after setting targetModel here] off begin
			// % protected region % [Add additional actions after setting targetModel here] end
		}));
	}

	/**
	 * This method iterates through all of the relations in the relations array and performs logic to fetch all of the entities to be shown
	 * in the dropdowns. This method does not need to be modified if you add additional entities to your crud list, as it will process all
	 * relations given to it
	 */
	private prepareReferenceCollections() {
		// % protected region % [Add any additional code here before the main logic of prepareReferenceCollections] off begin
		// % protected region % [Add any additional code here before the main logic of prepareReferenceCollections] end

		let updatedRelationsArray: ModelRelation[] = [];

		this.modelRelations.forEach(relation => {
			updatedRelationsArray.push(this.prepareSingleReferenceCollection(relation));
		});

		// % protected region % [Add any additional code here after the main logic of prepareReferenceCollections] off begin
		// % protected region % [Add any additional code here after the main logic of prepareReferenceCollections] end

		this.modelRelations = updatedRelationsArray;
	}

	/**
	 * Prepare the collection for a single Model Relation.  This method is called once for each relation in the modelRelations array,
	 * although there are use cases for processing other relations individually.  Calling prepareReferenceCollections within a subscription
	 * is not recommended, as it will cause a feedback loop which will require a reload to fix.  Therefore, abstracting this logic out allows
	 * for preparing reference collections for multi entity crud for 1:M relations.
	 *
	 * @param relation The relation to prepare the collection for
	 * @returns the same relation, with some additional parameters added following the creation of the collection
	 */
	prepareSingleReferenceCollection(relation: ModelRelation, uniqueCollectionId?: string) {
		let referenceRequirements: PrepareReferenceRequirements;
		referenceRequirements = fetchPrepareReferenceRequirements(relation.entityName);
		relation.stateConfig = {
			pageIndex: 0,
			pageSize: this.pageSize,
			collectionId: uniqueCollectionId ? uniqueCollectionId : this.collectionId
		} as PassableStateConfig<any>;

		this.store.dispatch(new referenceRequirements.baseAction(
			referenceRequirements.initCollectionAction,
			relation.stateConfig
		));

		this.addSearchFunction(relation,
				referenceRequirements.collectionModelsSelector,
				referenceRequirements.baseAction,
				referenceRequirements.fetchWithQueryAction);

		this.store.dispatch(new referenceRequirements.baseAction(
			referenceRequirements.fetchAllAction,
			relation.stateConfig
		));

		return relation;
	}

	/**
	 * Add the search function for each of the relations.
	 *
	 */
	private addSearchFunction(modelRelation: ModelRelation, modelSelector: any, action: new (...args: any[]) => NgRxAction, actionType: string) {
		// % protected region % [Add any additional code before the main logic of addSearchFunction here] off begin
		// % protected region % [Add any additional code before the main logic of addSearchFunction here] end

		modelRelation.searchFunction = new Subject<string>();
		modelRelation.collection = this.store.select(modelSelector, this.collectionId);
		this.creationNavigationSubscription$.add(modelRelation.searchFunction.pipe(
			debounceTime(500),
			distinctUntilChanged(),
			filter(value => value != null)
		).subscribe(
			(term: string) => {
				modelRelation.stateConfig.queryParams = {
					pageSize: this.pageSize,
					pageIndex: 0,
					where: [
						[
							{
								path: modelRelation.displayName,
								operation: QueryOperation.CONTAINS,
								value: term
							}
						]
					]
				};

				// % protected region % [Add any additional logic to the search subscription before dispatch here] off begin
				// % protected region % [Add any additional logic to the search subscription before dispatch here] end

				this.store.dispatch(new action(
					actionType,
					modelRelation.stateConfig
				));

				// % protected region % [Add any additional logic to the search subscription after dispatch here] off begin
				// % protected region % [Add any additional logic to the search subscription after dispatch here] end
			}
		));

		// % protected region % [Add any additional code after the main logic of addSearchFunction here] off begin
		// % protected region % [Add any additional code after the main logic of addSearchFunction here] end
	}

	/**
	 * Chang tile mode based on action and whether using routing
	 */
	private triggerTileModeChange(tileMode: CrudTileMode, id?: string, other?: object) {
		if (this.singlePageComponent) {
			this.tileModeChange.emit({
				tileMode: tileMode,
				payload: {
					id: id,
					...other
				}
			});
		} else {
			let extras: NavigationExtras = {};


			const commands = [];

			commands.push(this.routerState.urls[0]);

			if (tileMode !== CrudTileMode.List) {
				commands.push('supplier');
				commands.push(tileMode.toString());
			}

			if (id) {
				commands.push(id);
			}

			this.routerStore.dispatch(new routingAction.NavigateRoutingAction(commands, extras));
		}
	}

	/**
	 * Triggered when the user clicks on the "View History" button.
	 */
	onViewHistory() {
		// % protected region % [Add any additional onViewHistory logic before the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic before the main body here] end

		this.store.dispatch(new modelAction.SupplierAction(
			modelAction.SupplierModelActionTypes.FETCH_SUPPLIER_AUDITS_BY_ENTITY_ID,
			{
				targetModelId: this.targetModelId
			}
		));

		// % protected region % [Add any additional onViewHistory logic after the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic after the main body here] end
	}

	/**
	 * Triggered when the `Create` or `Save` button is clicked in the child create/edit view.
	 */
	onCreateOrSaveClicked(event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }) {
		// % protected region % [Add any additional onCreateOrSaveClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCreateOrSaveClicked logic before the main body here] end

		this.targetModel = this.addAdditionalEntitiesToModel(this.targetModel, event);

		if (event.isCreate) {
			let stateConfig: PassableStateConfig<SupplierModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.goodsReceiveNotesMultiCrudActive || this.purchaseOrdersMultiCrudActive || this.purchaseRequisitionsMultiCrudActive || this.returnSuppliersMultiCrudActive || this.suplierContactDetailsMultiCrudActive || this.supplierBankAccountsMultiCrudActive || this.supplierProductDetailsMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the creation state config here] off begin
				// % protected region % [Add any additional attributes to the creation state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				afterwardActions = [
					// % protected region % [Add any additional afterwards actions for single page creation here] off begin
					// % protected region % [Add any additional afterwards actions for single page creation here] end
					// Count the models to trigger the tile mode change, as the count will have changed after creation
					new modelAction.SupplierAction(
						modelAction.SupplierModelActionTypes.COUNT_SUPPLIERS,
						null
					)
				];
			} else {
				afterwardActions = [
					// % protected region % [Add any additional afterwards actions for creation here] off begin
					// % protected region % [Add any additional afterwards actions for creation here] end
					new routingAction.BackRoutingAction()
				];
			}

			// % protected region % [Add any additional logic before creating a new model here] off begin
			// % protected region % [Add any additional logic before creating a new model here] end

			this.store.dispatch(new modelAction.SupplierAction(
				modelAction.SupplierModelActionTypes.CREATE_SUPPLIER,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<SupplierModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.goodsReceiveNotesMultiCrudActive || this.purchaseOrdersMultiCrudActive || this.purchaseRequisitionsMultiCrudActive || this.returnSuppliersMultiCrudActive || this.suplierContactDetailsMultiCrudActive || this.supplierBankAccountsMultiCrudActive || this.supplierProductDetailsMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.SupplierAction(
					modelAction.SupplierModelActionTypes.FETCH_SUPPLIER,
					{
						targetModelId: this.targetModelId,
						queryParams: {
							expands: this.defaultExpands
						}
					}
				));
			} else {
				afterwardActions = [
					new routingAction.BackRoutingAction(),
					// % protected region % [Add any additional afterwards actions for updates here] off begin
					// % protected region % [Add any additional afterwards actions for updates here] end
				];
			}

			// % protected region % [Add any additional logic before update the current model here] off begin
			// % protected region % [Add any additional logic before update the current model here] end

			this.store.dispatch(new modelAction.SupplierAction(
				modelAction.SupplierModelActionTypes.UPDATE_SUPPLIER,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: SupplierModel = new SupplierModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getSupplierModelWithId, this.targetModelId).subscribe(model => {
					let differences = new SupplierModel(model).difference(updatedModel);

					// Object has been updated when differences is empty.
					// Differences excludes values such as references.  As these aren't visible on the list they do not need to be checked
					// When the user naivgates to a page which displays references, they will be fetched from the database with the correct values
					if (Object.keys(differences).length === 0) {
						this.triggerTileModeChange(CrudTileMode.List);
					}
				}));
			}
		}

		// % protected region % [Add any additional onCreateOrSaveClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCreateOrSaveClicked logic after the main body here] end
	}

	/**
	 * Removes form elements whose group id matches the group Id passed into the event, or adds a new
	 * group based on the entityName parameter
	 *
	 * @param event The event emitted from the base crud edit page
	 */
	onMultiEntityAction(event: { groupId: string, entityName: string, payload?: { [s: string]: any } }) {
		if (event.groupId) { // This path deletes the group with the specified id from the list
			this.modelProperties = this.modelProperties.filter(prop => {
				if (prop.group) {
					return prop.group.id !== event.groupId;
				}

				// Groupless attributes should pass through no matter what, as they are not related to the additional entities
				return true;
			});

			this.modelRelations = this.modelRelations.filter(relation => {
				if (relation.group) {
					return relation.group.id !== event.groupId;
				}

				// Groupless attributes should pass through no matter what, as they are not related to the additional entities
				return true;
			});
		} else {
			// This will add a new entity of the specified type to the list of props/relations
			if (event.entityName === this.goodsReceiveNotesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(GoodsReceiveNoteModel.getProps(), this.goodsReceiveNotesRelations, this.isViewOnly),
					new GoodsReceiveNoteModel(),
					GoodsReceiveNoteModel,
					this.goodsReceiveNotesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.goodsReceiveNotesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.purchaseOrdersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PurchaseOrderModel.getProps(), this.purchaseOrdersRelations, this.isViewOnly),
					new PurchaseOrderModel(),
					PurchaseOrderModel,
					this.purchaseOrdersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.purchaseOrdersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.purchaseRequisitionsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PurchaseRequisitionModel.getProps(), this.purchaseRequisitionsRelations, this.isViewOnly),
					new PurchaseRequisitionModel(),
					PurchaseRequisitionModel,
					this.purchaseRequisitionsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.purchaseRequisitionsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.returnSuppliersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ReturnSupplierModel.getProps(), this.returnSuppliersRelations, this.isViewOnly),
					new ReturnSupplierModel(),
					ReturnSupplierModel,
					this.returnSuppliersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.returnSuppliersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.suplierContactDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SupplierContactDetailModel.getProps(), this.suplierContactDetailsRelations, this.isViewOnly),
					new SupplierContactDetailModel(),
					SupplierContactDetailModel,
					this.suplierContactDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.suplierContactDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.supplierBankAccountsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SupplierBankAccountModel.getProps(), this.supplierBankAccountsRelations, this.isViewOnly),
					new SupplierBankAccountModel(),
					SupplierBankAccountModel,
					this.supplierBankAccountsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.supplierBankAccountsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.supplierProductDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SupplierProductDetailModel.getProps(), this.supplierProductDetailsRelations, this.isViewOnly),
					new SupplierProductDetailModel(),
					SupplierProductDetailModel,
					this.supplierProductDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.supplierProductDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			}
	}

	/**
	 * Triggered when the user switches from view mode to edit mode.
	 */
	onSwitchEdit() {
		// % protected region % [Add any additional onSwitchEdit logic before the main body here] off begin
		// % protected region % [Add any additional onSwitchEdit logic before the main body here] end

		this.triggerTileModeChange(CrudTileMode.Edit, this.targetModelId);

		// % protected region % [Add any additional onSwitchEdit logic after the main body here] off begin
		// % protected region % [Add any additional onSwitchEdit logic after the main body here] end
	}

	/**
	 * Triggered whenever the `Cancel` of the create/edit child component is clicked.
	 */
	onCancelClicked() {
		// % protected region % [Add any additional onCancelClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic before the main body here] end

		this.triggerTileModeChange(CrudTileMode.List);

		// % protected region % [Add any additional onCancelClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic after the main body here] end
	}

	/**
	 * Create the reactive form from the input model
	 */
	createReactiveForm() {
		// % protected region % [Add any additional createReactiveForm logic before the main body here] off begin
		// % protected region % [Add any additional createReactiveForm logic before the main body here] end

		this.modelFormGroup = createReactiveFormFromModel(this.modelProperties, this.modelRelations, this.isViewOnly);

		// % protected region % [Add any additional createReactiveForm logic after the main body here] off begin
		// % protected region % [Add any additional createReactiveForm logic after the main body here] end
	}

	/**
	 * Returns the props and relations lists back to their default state.  This is called in fetchEntity to ensure that
	 * any time the entity changes these lists remain stable.  If you are adding additional entities to your crud page the
	 * placement of this method ensures that no duplicate attributes will be added on repeat runs of fetch entity
	 */
	resetPropsAndRels() {
		this.modelProperties = SupplierModel.getProps();
		this.modelRelations = SupplierModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'goodsReceiveNotes';
		}).hideElement = this.goodsReceiveNotesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'goodsReceiveNotes').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'purchaseOrders';
		}).hideElement = this.purchaseOrdersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'purchaseOrders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'purchaseRequisitions';
		}).hideElement = this.purchaseRequisitionsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'purchaseRequisitions').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'returnSuppliers';
		}).hideElement = this.returnSuppliersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'returnSuppliers').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'suplierContactDetails';
		}).hideElement = this.suplierContactDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'suplierContactDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'supplierBankAccounts';
		}).hideElement = this.supplierBankAccountsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'supplierBankAccounts').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'supplierProductDetails';
		}).hideElement = this.supplierProductDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'supplierProductDetails').hideElement;

	}

	/**
	 * Initialises the collections used for fetching the entities to display in multi entity crud for many relations.
	 * The same collection used to fetch entities for the relation dropdown cannot be reused, as we need to fetch a
	 * subset for these relations, and using the same collection will result in all entities being returned instead of the
	 * subset we are looking for.
	 *
	 * This method will only be populated if this entity has a many relation (i.e. it is the target of a 1:M relation, or is part of a
	 * M:M relation)
	 */
	initialiseMultiEntityCollections() {
		if (this.goodsReceiveNotesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.goodsReceiveNotesDisplayName, many: true});
			this.store.dispatch(new goodsReceiveNoteModelAction.GoodsReceiveNoteAction(
				goodsReceiveNoteModelAction.GoodsReceiveNoteModelActionTypes.INITIALISE_GOODS_RECEIVE_NOTE_COLLECTION_STATE,
				{
					collectionId: this.goodsReceiveNotesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getGoodsReceiveNoteCollectionModels, this.goodsReceiveNotesCollectionId).subscribe(models => {
				models.forEach(goodsReceiveNotes => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(GoodsReceiveNoteModel.getProps(), this.goodsReceiveNotesRelations, this.isViewOnly),
						goodsReceiveNotes,
						GoodsReceiveNoteModel,
						this.goodsReceiveNotesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.goodsReceiveNotesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.purchaseOrdersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.purchaseOrdersDisplayName, many: true});
			this.store.dispatch(new purchaseOrderModelAction.PurchaseOrderAction(
				purchaseOrderModelAction.PurchaseOrderModelActionTypes.INITIALISE_PURCHASE_ORDER_COLLECTION_STATE,
				{
					collectionId: this.purchaseOrdersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPurchaseOrderCollectionModels, this.purchaseOrdersCollectionId).subscribe(models => {
				models.forEach(purchaseOrders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PurchaseOrderModel.getProps(), this.purchaseOrdersRelations, this.isViewOnly),
						purchaseOrders,
						PurchaseOrderModel,
						this.purchaseOrdersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.purchaseOrdersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.purchaseRequisitionsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.purchaseRequisitionsDisplayName, many: true});
			this.store.dispatch(new purchaseRequisitionModelAction.PurchaseRequisitionAction(
				purchaseRequisitionModelAction.PurchaseRequisitionModelActionTypes.INITIALISE_PURCHASE_REQUISITION_COLLECTION_STATE,
				{
					collectionId: this.purchaseRequisitionsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPurchaseRequisitionCollectionModels, this.purchaseRequisitionsCollectionId).subscribe(models => {
				models.forEach(purchaseRequisitions => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PurchaseRequisitionModel.getProps(), this.purchaseRequisitionsRelations, this.isViewOnly),
						purchaseRequisitions,
						PurchaseRequisitionModel,
						this.purchaseRequisitionsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.purchaseRequisitionsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.returnSuppliersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.returnSuppliersDisplayName, many: true});
			this.store.dispatch(new returnSupplierModelAction.ReturnSupplierAction(
				returnSupplierModelAction.ReturnSupplierModelActionTypes.INITIALISE_RETURN_SUPPLIER_COLLECTION_STATE,
				{
					collectionId: this.returnSuppliersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getReturnSupplierCollectionModels, this.returnSuppliersCollectionId).subscribe(models => {
				models.forEach(returnSuppliers => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(ReturnSupplierModel.getProps(), this.returnSuppliersRelations, this.isViewOnly),
						returnSuppliers,
						ReturnSupplierModel,
						this.returnSuppliersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.returnSuppliersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.suplierContactDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.suplierContactDetailsDisplayName, many: true});
			this.store.dispatch(new supplierContactDetailModelAction.SupplierContactDetailAction(
				supplierContactDetailModelAction.SupplierContactDetailModelActionTypes.INITIALISE_SUPPLIER_CONTACT_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.suplierContactDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getSupplierContactDetailCollectionModels, this.suplierContactDetailsCollectionId).subscribe(models => {
				models.forEach(suplierContactDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(SupplierContactDetailModel.getProps(), this.suplierContactDetailsRelations, this.isViewOnly),
						suplierContactDetails,
						SupplierContactDetailModel,
						this.suplierContactDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.suplierContactDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.supplierBankAccountsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.supplierBankAccountsDisplayName, many: true});
			this.store.dispatch(new supplierBankAccountModelAction.SupplierBankAccountAction(
				supplierBankAccountModelAction.SupplierBankAccountModelActionTypes.INITIALISE_SUPPLIER_BANK_ACCOUNT_COLLECTION_STATE,
				{
					collectionId: this.supplierBankAccountsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getSupplierBankAccountCollectionModels, this.supplierBankAccountsCollectionId).subscribe(models => {
				models.forEach(supplierBankAccounts => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(SupplierBankAccountModel.getProps(), this.supplierBankAccountsRelations, this.isViewOnly),
						supplierBankAccounts,
						SupplierBankAccountModel,
						this.supplierBankAccountsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.supplierBankAccountsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.supplierProductDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.supplierProductDetailsDisplayName, many: true});
			this.store.dispatch(new supplierProductDetailModelAction.SupplierProductDetailAction(
				supplierProductDetailModelAction.SupplierProductDetailModelActionTypes.INITIALISE_SUPPLIER_PRODUCT_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.supplierProductDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getSupplierProductDetailCollectionModels, this.supplierProductDetailsCollectionId).subscribe(models => {
				models.forEach(supplierProductDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(SupplierProductDetailModel.getProps(), this.supplierProductDetailsRelations, this.isViewOnly),
						supplierProductDetails,
						SupplierProductDetailModel,
						this.supplierProductDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.supplierProductDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

	}

	/**
	 * Fetches the entities for any activated multi entity crud selections, and adds groups to the form for every additional
	 * related entity.
	 *
	 * May be empty if the entity for this crud page has no related entities
	 */
	multiCrudFetchAdditionalEntities() {
		if (this.targetModel.goodsReceiveNotesIds && this.targetModel.goodsReceiveNotesIds.length > 0 && this.goodsReceiveNotesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				GoodsReceiveNoteModel,
				this.goodsReceiveNotesOppositeRelation,
				this.goodsReceiveNotesCollectionId,
				this.targetModel.goodsReceiveNotesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.purchaseOrdersIds && this.targetModel.purchaseOrdersIds.length > 0 && this.purchaseOrdersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PurchaseOrderModel,
				this.purchaseOrdersOppositeRelation,
				this.purchaseOrdersCollectionId,
				this.targetModel.purchaseOrdersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.purchaseRequisitionsIds && this.targetModel.purchaseRequisitionsIds.length > 0 && this.purchaseRequisitionsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PurchaseRequisitionModel,
				this.purchaseRequisitionsOppositeRelation,
				this.purchaseRequisitionsCollectionId,
				this.targetModel.purchaseRequisitionsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.returnSuppliersIds && this.targetModel.returnSuppliersIds.length > 0 && this.returnSuppliersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ReturnSupplierModel,
				this.returnSuppliersOppositeRelation,
				this.returnSuppliersCollectionId,
				this.targetModel.returnSuppliersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.suplierContactDetailsIds && this.targetModel.suplierContactDetailsIds.length > 0 && this.suplierContactDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				SupplierContactDetailModel,
				this.suplierContactDetailsOppositeRelation,
				this.suplierContactDetailsCollectionId,
				this.targetModel.suplierContactDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.supplierBankAccountsIds && this.targetModel.supplierBankAccountsIds.length > 0 && this.supplierBankAccountsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				SupplierBankAccountModel,
				this.supplierBankAccountsOppositeRelation,
				this.supplierBankAccountsCollectionId,
				this.targetModel.supplierBankAccountsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.supplierProductDetailsIds && this.targetModel.supplierProductDetailsIds.length > 0 && this.supplierProductDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				SupplierProductDetailModel,
				this.supplierProductDetailsOppositeRelation,
				this.supplierProductDetailsCollectionId,
				this.targetModel.supplierProductDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

	}

	/**
	 * The crud create edit page will handle all potential multi entity crud permutations by returning an
	 * `additionalEntities` parameter in its returned event.  This attribute will contain any entities which
	 * were added to the crud edit page for multi entity model.  Once this attribute has been returned, we need
	 * to process it, and transfer any additional entities from this attribute into the target model, so that these
	 * additional entities can be sent to the serverside for processing.
	 *
	 * @param model The model to inject the additional entities into.  This will usually be the targetModel attribute for this component
	 * @param event The event returned from the crud edit page when clicking create or save.  We only care about the additionalEntities param here
	 * @returns the model passed in as input, but with the entities from the additionalEntities attribute added to that model.
	 */
	addAdditionalEntitiesToModel(model: SupplierModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): SupplierModel {
		let updatedModel: SupplierModel = new SupplierModel(model);

		updatedModel.goodsReceiveNotes = [];
		if (this.goodsReceiveNotesMultiCrudActive) {
			if (event.additionalEntities.goodsReceiveNotes) {
				event.additionalEntities.goodsReceiveNotes.forEach(entity => {
					updatedModel.goodsReceiveNotes.push(entity);
				});
			}

			if (!updatedModel.goodsReceiveNotes.length) {
				updatedModel.goodsReceiveNotesIds = [];
			}
		}
		updatedModel.purchaseOrders = [];
		if (this.purchaseOrdersMultiCrudActive) {
			if (event.additionalEntities.purchaseOrders) {
				event.additionalEntities.purchaseOrders.forEach(entity => {
					updatedModel.purchaseOrders.push(entity);
				});
			}

			if (!updatedModel.purchaseOrders.length) {
				updatedModel.purchaseOrdersIds = [];
			}
		}
		updatedModel.purchaseRequisitions = [];
		if (this.purchaseRequisitionsMultiCrudActive) {
			if (event.additionalEntities.purchaseRequisitions) {
				event.additionalEntities.purchaseRequisitions.forEach(entity => {
					updatedModel.purchaseRequisitions.push(entity);
				});
			}

			if (!updatedModel.purchaseRequisitions.length) {
				updatedModel.purchaseRequisitionsIds = [];
			}
		}
		updatedModel.returnSuppliers = [];
		if (this.returnSuppliersMultiCrudActive) {
			if (event.additionalEntities.returnSuppliers) {
				event.additionalEntities.returnSuppliers.forEach(entity => {
					updatedModel.returnSuppliers.push(entity);
				});
			}

			if (!updatedModel.returnSuppliers.length) {
				updatedModel.returnSuppliersIds = [];
			}
		}
		updatedModel.suplierContactDetails = [];
		if (this.suplierContactDetailsMultiCrudActive) {
			if (event.additionalEntities.suplierContactDetails) {
				event.additionalEntities.suplierContactDetails.forEach(entity => {
					updatedModel.suplierContactDetails.push(entity);
				});
			}

			if (!updatedModel.suplierContactDetails.length) {
				updatedModel.suplierContactDetailsIds = [];
			}
		}
		updatedModel.supplierBankAccounts = [];
		if (this.supplierBankAccountsMultiCrudActive) {
			if (event.additionalEntities.supplierBankAccounts) {
				event.additionalEntities.supplierBankAccounts.forEach(entity => {
					updatedModel.supplierBankAccounts.push(entity);
				});
			}

			if (!updatedModel.supplierBankAccounts.length) {
				updatedModel.supplierBankAccountsIds = [];
			}
		}
		updatedModel.supplierProductDetails = [];
		if (this.supplierProductDetailsMultiCrudActive) {
			if (event.additionalEntities.supplierProductDetails) {
				event.additionalEntities.supplierProductDetails.forEach(entity => {
					updatedModel.supplierProductDetails.push(entity);
				});
			}

			if (!updatedModel.supplierProductDetails.length) {
				updatedModel.supplierProductDetailsIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
