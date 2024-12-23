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
package kmsweb.configs.security.auditing.services;

import kmsweb.configs.security.SpringAuditorAware;
import kmsweb.configs.security.auditing.entities.PrivilegeEntityReadAudit;
import kmsweb.configs.security.auditing.repositories.PrivilegeEntityReadAuditRepository;
import kmsweb.entities.PrivilegeEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class PrivilegeEntityReadAuditService {

	private final PrivilegeEntityReadAuditRepository repository;
	private SpringAuditorAware auditorAware;
	private final ObjectMapper objectMapper;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PrivilegeEntityReadAuditService(PrivilegeEntityReadAuditRepository repository, SpringAuditorAware auditorAware) {
		this.repository = repository;
		this.auditorAware = auditorAware;
		objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createWith(PrivilegeEntity entity) throws JsonProcessingException {
		PrivilegeEntityReadAudit newAudit = new PrivilegeEntityReadAudit();
		newAudit.setData(objectMapper.writeValueAsString(entity));

		// Visitors will not have a user id associated with them
		auditorAware.getCurrentAuditor().ifPresent(newAudit::setReadBy);

		repository.save(newAudit);
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
