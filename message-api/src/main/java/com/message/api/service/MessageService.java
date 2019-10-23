/**
 * 
 */
package com.message.api.service;

import java.util.List;
import java.util.Optional;

import com.message.api.model.Message;

/**
 * @author usama
 *
 */
public interface MessageService {

	public List<Message> getAllMessages();

	public Optional<Message> getMessageById(Long id);

	public void addNewMessage(Message message);

}
