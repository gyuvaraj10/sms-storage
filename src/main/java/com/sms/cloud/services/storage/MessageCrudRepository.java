package com.sms.cloud.services.storage;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MessageCrudRepository extends CrudRepository<Message, String> {
}
