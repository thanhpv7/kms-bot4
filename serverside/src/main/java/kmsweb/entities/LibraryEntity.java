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
import kmsweb.dtos.LibraryEntityDto;
import kmsweb.entities.listeners.LibraryEntityListener;
import kmsweb.serializers.LibrarySerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.lib.file.models.FileEntity;
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

import java.util.*;
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
@EntityListeners({LibraryEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = LibrarySerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"library_item_code"}, name = "library_item_code"),
	}
)
public class LibraryEntity extends AbstractEntity {

	/**
	 * Takes a LibraryEntityDto and converts it into a LibraryEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param libraryEntityDto
	 */
	public LibraryEntity(LibraryEntityDto libraryEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (libraryEntityDto.getId() != null) {
			this.setId(libraryEntityDto.getId());
		}

		if (libraryEntityDto.getLibraryItemCode() != null) {
			this.setLibraryItemCode(libraryEntityDto.getLibraryItemCode());
		}

		if (libraryEntityDto.getLibraryItemDescription() != null) {
			this.setLibraryItemDescription(libraryEntityDto.getLibraryItemDescription());
		}

		if (libraryEntityDto.getClassification() != null) {
			this.setClassification(libraryEntityDto.getClassification());
		}

		if (libraryEntityDto.getAuthor() != null) {
			this.setAuthor(libraryEntityDto.getAuthor());
		}

		if (libraryEntityDto.getPublisher() != null) {
			this.setPublisher(libraryEntityDto.getPublisher());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Library Item Code here] off begin
	@CsvBindByName(column = "LIBRARY_ITEM_CODE", required = false)
	@Nullable
	@Column(name = "library_item_code")
	@Schema(description = "The Library Item Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Library Item Code here] end
	private String libraryItemCode;

	// % protected region % [Modify attribute annotation for Library Item Description here] off begin
	@CsvBindByName(column = "LIBRARY_ITEM_DESCRIPTION", required = false)
	@Nullable
	@Column(name = "library_item_description")
	@Schema(description = "The Library Item Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Library Item Description here] end
	private String libraryItemDescription;

	// % protected region % [Modify attribute annotation for Classification here] off begin
	@CsvBindByName(column = "CLASSIFICATION", required = false)
	@Nullable
	@Column(name = "classification")
	@Schema(description = "The Classification of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Classification here] end
	private String classification;

	// % protected region % [Modify attribute annotation for Author here] off begin
	@CsvBindByName(column = "AUTHOR", required = false)
	@Nullable
	@Column(name = "author")
	@Schema(description = "The Author of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Author here] end
	private String author;

	// % protected region % [Modify attribute annotation for Publisher here] off begin
	@CsvBindByName(column = "PUBLISHER", required = false)
	@Nullable
	@Column(name = "publisher")
	@Schema(description = "The Publisher of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Publisher here] end
	private String publisher;

	@CsvIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<FileEntity> libraryDocument = new HashSet<>();

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



	public void addLibraryDocument(FileEntity newFile) {
		libraryDocument.add(newFile);
	}

	public void addAllLibraryDocument(Collection<FileEntity> newFiles) {
		libraryDocument.addAll(newFiles);
	}

	public void removeLibraryDocument(FileEntity newFile) {
		libraryDocument.remove(newFile);
	}

	public boolean containsLibraryDocument(FileEntity newFile) {
		return libraryDocument.contains(newFile);
	}

	public void clearAllLibraryDocument() {
		libraryDocument.clear();
	}

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "LIBRARY_ITEM_CODE,LIBRARY_ITEM_DESCRIPTION,CLASSIFICATION,AUTHOR,PUBLISHER,ID";
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
	public boolean equals(Object library) {
		if (this == library) {
			return true;
		}
		if (library == null || this.getClass() != library.getClass()) {
			return false;
		}
		if (!super.equals(library)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		LibraryEntity that = (LibraryEntity) library;
		return
			Objects.equals(this.libraryItemCode, that.libraryItemCode) &&
			Objects.equals(this.libraryItemDescription, that.libraryItemDescription) &&
			Objects.equals(this.classification, that.classification) &&
			Objects.equals(this.author, that.author) &&
			Objects.equals(this.publisher, that.publisher);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
