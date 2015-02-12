package com.mvc.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mvc.model.User;
import com.mvc.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService{
	@Autowired(required=true)
	@Qualifier("mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	@Override
	public void saveUser(User user) {
		mongoTemplate.insert(user);
	}

	@Override
	public User getUser(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class);
	}

	@Override
	public void deleteUser(String id) {
		mongoTemplate.findAndRemove(new Query(Criteria.where("id").is(id)), User.class);
	}

	@Override
	public List<User> getAllUser() {
		return mongoTemplate.findAll(User.class,"users");
	}

	@Override
	public void createCollection() {
		
	}

	@Override
	public void dropCollection() {
		
	}

	@Override
	public void updateUser(User user) {
		Criteria criteria = Criteria.where("id").is(user.getId());
		Query query = new Query(criteria);
		Update update = Update.update("age", user.getAge()).set("name", user.getName()).set("sex", user.getSex());
		mongoTemplate.updateFirst(query, update, User.class);
	}

}
