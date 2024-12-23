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
package kmsweb.cucumber.pom.pages.admin.crud.list;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import kmsweb.cucumber.pom.factories.AdminPageFactory;
import kmsweb.cucumber.utils.TypingUtils;
import cucumber.runtime.java.guice.ScenarioScoped;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import kmsweb.entities.BpjsPcareKegiatanKelompokEntity;
import java.util.Properties;
import java.util.Collection;
import kmsweb.entities.AbstractEntity;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * BPJS Pcare Kegiatan KelompokPage is a Page POM that is associated with the admin/entities/bpjs-pcare-kegiatan-kelompok url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsPcareKegiatanKelompokCrudListPage extends CrudList {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end

	@Inject
	public AdminEntitiesBpjsPcareKegiatanKelompokCrudListPage(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			@NonNull WebDriver webDriver,
			@NonNull Properties properties
	) {
		super(
			webDriver,
			properties,
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
			"admin/entities/bpjs-pcare-kegiatan-kelompok"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}
