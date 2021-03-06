package org.mifosplatform.billing.address.handler;

import org.mifosplatform.billing.address.service.AddressWritePlatformService;
import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateNewRecordCommandHandler implements NewCommandSourceHandler {
	 private final AddressWritePlatformService writePlatformService;
	 
	 @Autowired
	    public UpdateNewRecordCommandHandler(final AddressWritePlatformService writePlatformService){
	        this.writePlatformService = writePlatformService;
	    }
	 @Transactional
	    @Override
	    public CommandProcessingResult processCommand(final JsonCommand command) {
		 return this.writePlatformService.updateNewRecord(command,command.entityName(),command.entityId());
	 }

}
