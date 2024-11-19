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
import * as modelAction from 'src/app/models/transactionDetailType/transaction_detail_type.model.action';
import {TransactionDetailTypeModelState, TransactionDetailTypeModelAudit} from 'src/app/models/transactionDetailType/transaction_detail_type.model.state';
import {TransactionDetailTypeModel} from 'src/app/models/transactionDetailType/transaction_detail_type.model';
import {
	getTransactionDetailTypeModelAuditsByEntityId,
	getTransactionDetailTypeModelWithId,
	getCountTransactionDetailTypeModels,
} from 'src/app/models/transactionDetailType/transaction_detail_type.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {InventoryAdjustmentModel} from 'src/app/models/inventoryAdjustment/inventory_adjustment.model';
import * as inventoryAdjustmentModelAction from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.action';
import {
	getInventoryAdjustmentCollectionModels, getInventoryAdjustmentModelWithId,
} from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.selector';
import {StockTransactionDetailModel} from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model';
import * as stockTransactionDetailModelAction from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.action';
import {
	getStockTransactionDetailCollectionModels, getStockTransactionDetailModelWithId,
} from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.selector';
import {StockTransactionPerDateTypeModel} from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model';
import * as stockTransactionPerDateTypeModelAction from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.action';
import {
	getStockTransactionPerDateTypeCollectionModels, getStockTransactionPerDateTypeModelWithId,
} from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.selector';
import {TransactionDetailTypeMappingModel} from 'src/app/models/transactionDetailTypeMapping/transaction_detail_type_mapping.model';
import * as transactionDetailTypeMappingModelAction from 'src/app/models/transactionDetailTypeMapping/transaction_detail_type_mapping.model.action';
import {
	getTransactionDetailTypeMappingCollectionModels, getTransactionDetailTypeMappingModelWithId,
} from 'src/app/models/transactionDetailTypeMapping/transaction_detail_type_mapping.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../transaction-detail-type-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-transaction-detail-type-crud-edit',
	templateUrl: './transaction-detail-type-crud-edit.component.html',
	styleUrls: [
		'./transaction-detail-type-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class TransactionDetailTypeCrudEditComponent
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
	collectionId: string = '2b16b403-7972-4d22-bfb3-85c1bd863508';
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
	transactionDetailTypeAudits$: Observable<TransactionDetailTypeModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Transaction Detail Type and Inventory Adjustments here] off begin
	inventoryAdjustmentsMultiCrudActive: boolean = false;
	inventoryAdjustmentsDisplayName = 'Inventory Adjustments';
	inventoryAdjustmentsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Transaction Detail Type and Inventory Adjustments here] end
	inventoryAdjustmentsOppositeRelation = 'transactionDetailType';
	inventoryAdjustmentsRelations: ModelRelation[] = this.inventoryAdjustmentsMultiCrudActive ? InventoryAdjustmentModel.getRelations()
		.map(relation => {
			if (relation.id === this.inventoryAdjustmentsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Transaction Detail Type and Stock Transaction Details here] off begin
	stockTransactionDetailsMultiCrudActive: boolean = false;
	stockTransactionDetailsDisplayName = 'Stock Transaction Details';
	stockTransactionDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Transaction Detail Type and Stock Transaction Details here] end
	stockTransactionDetailsOppositeRelation = 'transactionDetailType';
	stockTransactionDetailsRelations: ModelRelation[] = this.stockTransactionDetailsMultiCrudActive ? StockTransactionDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockTransactionDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Transaction Detail Type and Stock Transaction Per Date Types here] off begin
	stockTransactionPerDateTypesMultiCrudActive: boolean = false;
	stockTransactionPerDateTypesDisplayName = 'Stock Transaction Per Date Types';
	stockTransactionPerDateTypesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Transaction Detail Type and Stock Transaction Per Date Types here] end
	stockTransactionPerDateTypesOppositeRelation = 'transactionDetailType';
	stockTransactionPerDateTypesRelations: ModelRelation[] = this.stockTransactionPerDateTypesMultiCrudActive ? StockTransactionPerDateTypeModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockTransactionPerDateTypesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Transaction Detail Type and Transaction Detail Type Mappings here] off begin
	transactionDetailTypeMappingsMultiCrudActive: boolean = false;
	transactionDetailTypeMappingsDisplayName = 'Transaction Detail Type Mappings';
	transactionDetailTypeMappingsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Transaction Detail Type and Transaction Detail Type Mappings here] end
	transactionDetailTypeMappingsOppositeRelation = 'transactionDetailType';
	transactionDetailTypeMappingsRelations: ModelRelation[] = this.transactionDetailTypeMappingsMultiCrudActive ? TransactionDetailTypeMappingModel.getRelations()
		.map(relation => {
			if (relation.id === this.transactionDetailTypeMappingsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = TransactionDetailTypeModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = TransactionDetailTypeModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = TransactionDetailTypeModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'inventoryAdjustments' && this.inventoryAdjustmentsMultiCrudActive) {
					exp.fields = InventoryAdjustmentModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'stockTransactionDetails' && this.stockTransactionDetailsMultiCrudActive) {
					exp.fields = StockTransactionDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'stockTransactionPerDateTypes' && this.stockTransactionPerDateTypesMultiCrudActive) {
					exp.fields = StockTransactionPerDateTypeModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'transactionDetailTypeMappings' && this.transactionDetailTypeMappingsMultiCrudActive) {
					exp.fields = TransactionDetailTypeMappingModel.getProps().map(prop => {
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
	targetModel: TransactionDetailTypeModel;

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
		private readonly store: Store<{ model: TransactionDetailTypeModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountTransactionDetailTypeModels).subscribe(count => {
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

			this.targetModel = new TransactionDetailTypeModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.transactionDetailTypeAudits$ = this.store.select(getTransactionDetailTypeModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<TransactionDetailTypeModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.TransactionDetailTypeAction(
			modelAction.TransactionDetailTypeModelActionTypes.FETCH_TRANSACTION_DETAIL_TYPE,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getTransactionDetailTypeModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new TransactionDetailTypeModel(model);
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
				commands.push('transaction-detail-type');
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

		this.store.dispatch(new modelAction.TransactionDetailTypeAction(
			modelAction.TransactionDetailTypeModelActionTypes.FETCH_TRANSACTION_DETAIL_TYPE_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<TransactionDetailTypeModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.inventoryAdjustmentsMultiCrudActive || this.stockTransactionDetailsMultiCrudActive || this.stockTransactionPerDateTypesMultiCrudActive || this.transactionDetailTypeMappingsMultiCrudActive,
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
					new modelAction.TransactionDetailTypeAction(
						modelAction.TransactionDetailTypeModelActionTypes.COUNT_TRANSACTION_DETAIL_TYPES,
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

			this.store.dispatch(new modelAction.TransactionDetailTypeAction(
				modelAction.TransactionDetailTypeModelActionTypes.CREATE_TRANSACTION_DETAIL_TYPE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<TransactionDetailTypeModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.inventoryAdjustmentsMultiCrudActive || this.stockTransactionDetailsMultiCrudActive || this.stockTransactionPerDateTypesMultiCrudActive || this.transactionDetailTypeMappingsMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.TransactionDetailTypeAction(
					modelAction.TransactionDetailTypeModelActionTypes.FETCH_TRANSACTION_DETAIL_TYPE,
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

			this.store.dispatch(new modelAction.TransactionDetailTypeAction(
				modelAction.TransactionDetailTypeModelActionTypes.UPDATE_TRANSACTION_DETAIL_TYPE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: TransactionDetailTypeModel = new TransactionDetailTypeModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getTransactionDetailTypeModelWithId, this.targetModelId).subscribe(model => {
					let differences = new TransactionDetailTypeModel(model).difference(updatedModel);

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
			if (event.entityName === this.inventoryAdjustmentsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InventoryAdjustmentModel.getProps(), this.inventoryAdjustmentsRelations, this.isViewOnly),
					new InventoryAdjustmentModel(),
					InventoryAdjustmentModel,
					this.inventoryAdjustmentsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.inventoryAdjustmentsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.stockTransactionDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StockTransactionDetailModel.getProps(), this.stockTransactionDetailsRelations, this.isViewOnly),
					new StockTransactionDetailModel(),
					StockTransactionDetailModel,
					this.stockTransactionDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockTransactionDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.stockTransactionPerDateTypesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StockTransactionPerDateTypeModel.getProps(), this.stockTransactionPerDateTypesRelations, this.isViewOnly),
					new StockTransactionPerDateTypeModel(),
					StockTransactionPerDateTypeModel,
					this.stockTransactionPerDateTypesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockTransactionPerDateTypesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.transactionDetailTypeMappingsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(TransactionDetailTypeMappingModel.getProps(), this.transactionDetailTypeMappingsRelations, this.isViewOnly),
					new TransactionDetailTypeMappingModel(),
					TransactionDetailTypeMappingModel,
					this.transactionDetailTypeMappingsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.transactionDetailTypeMappingsRelations,
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
		this.modelProperties = TransactionDetailTypeModel.getProps();
		this.modelRelations = TransactionDetailTypeModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'inventoryAdjustments';
		}).hideElement = this.inventoryAdjustmentsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'inventoryAdjustments').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'stockTransactionDetails';
		}).hideElement = this.stockTransactionDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'stockTransactionDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'stockTransactionPerDateTypes';
		}).hideElement = this.stockTransactionPerDateTypesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'stockTransactionPerDateTypes').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'transactionDetailTypeMappings';
		}).hideElement = this.transactionDetailTypeMappingsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'transactionDetailTypeMappings').hideElement;

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
		if (this.inventoryAdjustmentsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.inventoryAdjustmentsDisplayName, many: true});
			this.store.dispatch(new inventoryAdjustmentModelAction.InventoryAdjustmentAction(
				inventoryAdjustmentModelAction.InventoryAdjustmentModelActionTypes.INITIALISE_INVENTORY_ADJUSTMENT_COLLECTION_STATE,
				{
					collectionId: this.inventoryAdjustmentsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInventoryAdjustmentCollectionModels, this.inventoryAdjustmentsCollectionId).subscribe(models => {
				models.forEach(inventoryAdjustments => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InventoryAdjustmentModel.getProps(), this.inventoryAdjustmentsRelations, this.isViewOnly),
						inventoryAdjustments,
						InventoryAdjustmentModel,
						this.inventoryAdjustmentsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.inventoryAdjustmentsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.stockTransactionDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.stockTransactionDetailsDisplayName, many: true});
			this.store.dispatch(new stockTransactionDetailModelAction.StockTransactionDetailAction(
				stockTransactionDetailModelAction.StockTransactionDetailModelActionTypes.INITIALISE_STOCK_TRANSACTION_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.stockTransactionDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getStockTransactionDetailCollectionModels, this.stockTransactionDetailsCollectionId).subscribe(models => {
				models.forEach(stockTransactionDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(StockTransactionDetailModel.getProps(), this.stockTransactionDetailsRelations, this.isViewOnly),
						stockTransactionDetails,
						StockTransactionDetailModel,
						this.stockTransactionDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.stockTransactionDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.stockTransactionPerDateTypesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.stockTransactionPerDateTypesDisplayName, many: true});
			this.store.dispatch(new stockTransactionPerDateTypeModelAction.StockTransactionPerDateTypeAction(
				stockTransactionPerDateTypeModelAction.StockTransactionPerDateTypeModelActionTypes.INITIALISE_STOCK_TRANSACTION_PER_DATE_TYPE_COLLECTION_STATE,
				{
					collectionId: this.stockTransactionPerDateTypesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getStockTransactionPerDateTypeCollectionModels, this.stockTransactionPerDateTypesCollectionId).subscribe(models => {
				models.forEach(stockTransactionPerDateTypes => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(StockTransactionPerDateTypeModel.getProps(), this.stockTransactionPerDateTypesRelations, this.isViewOnly),
						stockTransactionPerDateTypes,
						StockTransactionPerDateTypeModel,
						this.stockTransactionPerDateTypesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.stockTransactionPerDateTypesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.transactionDetailTypeMappingsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.transactionDetailTypeMappingsDisplayName, many: true});
			this.store.dispatch(new transactionDetailTypeMappingModelAction.TransactionDetailTypeMappingAction(
				transactionDetailTypeMappingModelAction.TransactionDetailTypeMappingModelActionTypes.INITIALISE_TRANSACTION_DETAIL_TYPE_MAPPING_COLLECTION_STATE,
				{
					collectionId: this.transactionDetailTypeMappingsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getTransactionDetailTypeMappingCollectionModels, this.transactionDetailTypeMappingsCollectionId).subscribe(models => {
				models.forEach(transactionDetailTypeMappings => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(TransactionDetailTypeMappingModel.getProps(), this.transactionDetailTypeMappingsRelations, this.isViewOnly),
						transactionDetailTypeMappings,
						TransactionDetailTypeMappingModel,
						this.transactionDetailTypeMappingsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.transactionDetailTypeMappingsRelations,
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
		if (this.targetModel.inventoryAdjustmentsIds && this.targetModel.inventoryAdjustmentsIds.length > 0 && this.inventoryAdjustmentsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InventoryAdjustmentModel,
				this.inventoryAdjustmentsOppositeRelation,
				this.inventoryAdjustmentsCollectionId,
				this.targetModel.inventoryAdjustmentsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.stockTransactionDetailsIds && this.targetModel.stockTransactionDetailsIds.length > 0 && this.stockTransactionDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StockTransactionDetailModel,
				this.stockTransactionDetailsOppositeRelation,
				this.stockTransactionDetailsCollectionId,
				this.targetModel.stockTransactionDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.stockTransactionPerDateTypesIds && this.targetModel.stockTransactionPerDateTypesIds.length > 0 && this.stockTransactionPerDateTypesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StockTransactionPerDateTypeModel,
				this.stockTransactionPerDateTypesOppositeRelation,
				this.stockTransactionPerDateTypesCollectionId,
				this.targetModel.stockTransactionPerDateTypesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.transactionDetailTypeMappingsIds && this.targetModel.transactionDetailTypeMappingsIds.length > 0 && this.transactionDetailTypeMappingsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				TransactionDetailTypeMappingModel,
				this.transactionDetailTypeMappingsOppositeRelation,
				this.transactionDetailTypeMappingsCollectionId,
				this.targetModel.transactionDetailTypeMappingsIds.length,
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
	addAdditionalEntitiesToModel(model: TransactionDetailTypeModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): TransactionDetailTypeModel {
		let updatedModel: TransactionDetailTypeModel = new TransactionDetailTypeModel(model);

		updatedModel.inventoryAdjustments = [];
		if (this.inventoryAdjustmentsMultiCrudActive) {
			if (event.additionalEntities.inventoryAdjustments) {
				event.additionalEntities.inventoryAdjustments.forEach(entity => {
					updatedModel.inventoryAdjustments.push(entity);
				});
			}

			if (!updatedModel.inventoryAdjustments.length) {
				updatedModel.inventoryAdjustmentsIds = [];
			}
		}
		updatedModel.stockTransactionDetails = [];
		if (this.stockTransactionDetailsMultiCrudActive) {
			if (event.additionalEntities.stockTransactionDetails) {
				event.additionalEntities.stockTransactionDetails.forEach(entity => {
					updatedModel.stockTransactionDetails.push(entity);
				});
			}

			if (!updatedModel.stockTransactionDetails.length) {
				updatedModel.stockTransactionDetailsIds = [];
			}
		}
		updatedModel.stockTransactionPerDateTypes = [];
		if (this.stockTransactionPerDateTypesMultiCrudActive) {
			if (event.additionalEntities.stockTransactionPerDateTypes) {
				event.additionalEntities.stockTransactionPerDateTypes.forEach(entity => {
					updatedModel.stockTransactionPerDateTypes.push(entity);
				});
			}

			if (!updatedModel.stockTransactionPerDateTypes.length) {
				updatedModel.stockTransactionPerDateTypesIds = [];
			}
		}
		updatedModel.transactionDetailTypeMappings = [];
		if (this.transactionDetailTypeMappingsMultiCrudActive) {
			if (event.additionalEntities.transactionDetailTypeMappings) {
				event.additionalEntities.transactionDetailTypeMappings.forEach(entity => {
					updatedModel.transactionDetailTypeMappings.push(entity);
				});
			}

			if (!updatedModel.transactionDetailTypeMappings.length) {
				updatedModel.transactionDetailTypeMappingsIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
