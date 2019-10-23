/**
 * 
 */
package com.message.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.message.api.model.Message;

/**
 * @author usama
 *
 */
@Repository
public interface MessageRespository extends MongoRepository<Message, Long> {

	@Override
	List<Message> findAll();

	@Override
	Optional<Message> findById(Long id);
}
