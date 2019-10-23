/**
 * 
 */
package com.message.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.message.api.model.Message;
import com.message.api.repository.MessageRespository;
import com.message.api.service.MessageService;

/**
 * @author usama
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRespository messageRespository;

	@Override
	public List<Message> getAllMessages() {
		return messageRespository.findAll();
	}

	@Override
	public Optional<Message> getMessageById(Long id) {
		return messageRespository.findById(id);
	}

	@Override
	public void addNewMessage(Message message) {
		messageRespository.save(message);

	}

}
