/**
 * 
 */
package com.message.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author usama
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
@Document(collection = "MESSAGE")
public class Message {

	@Transient
	public static final String SEQUENCE_NAME = "message_sequence";

	@Id
	@JsonIgnore
	private Long id;

	private String title;

	private String body;

}
