/**
 * 
 */
package com.message.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author usama
 *
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "database_sequence")
public class DatabaseSequence {

	@Id
	private String id;

	private long seq;

}
