/**
 * 
 */
package com.message.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.message.api.model.Message;
import com.message.api.service.MessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

/**
 * @author usama
 *
 */
@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/messages")
@Api(value = "Message", tags = { "Message API" })
public class MessageController {

	@Autowired
	MessageService messageService;

	@PostMapping("")
	@ApiOperation(value = "Add new message")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "New message is saved successfully") })
	public ResponseEntity<?> addNewMessage(@RequestBody Message message) {
		messageService.addNewMessage(message);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/all")
	@ApiOperation(value = "Get all received messages")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Messages have been retrieved successfully") })
	public ResponseEntity<List<Message>> getAllMessages() {
		List<Message> messages = messageService.getAllMessages();
		return new ResponseEntity<>(messages, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get message by its Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Message has been retrieved successfully"),
			@ApiResponse(code = 404, message = "Message not found") })
	public ResponseEntity<Message> getMessage(@PathVariable Long id) {
		Optional<Message> message = messageService.getMessageById(id);
		if (message.isPresent())
			return new ResponseEntity<>(message.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
