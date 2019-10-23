/**
 * 
 */
package com.message.api.event;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.message.api.model.Message;
import com.message.api.service.impl.SequenceGeneratorService;

/**
 * @author usama
 *
 */
@Component
public class MessageModelListner extends AbstractMongoEventListener<Message> {
	@Autowired
	private SequenceGeneratorService sequenceGenerator;

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Message> event) {
		if (Objects.isNull(event.getSource().getId()))
			event.getSource().setId(sequenceGenerator.generateSequence(Message.SEQUENCE_NAME));

	}

}
