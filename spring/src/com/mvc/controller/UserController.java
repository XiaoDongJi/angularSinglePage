package com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mongodb.util.JSON;
import com.mvc.model.User;
import com.mvc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired(required=true)
	@Qualifier("userService")
	private UserService service;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(@RequestBody User user){
		System.out.println(user);
		service.saveUser(user);
		return "index";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public String getAllUser(HttpServletRequest request,HttpServletResponse response){
		List<User> list1 = service.getAllUser();
		JSONArray jsonarr = JSONArray.fromObject(list1);
		return jsonarr.toString();
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@PathVariable("id") String id){
		System.out.println("删除用户id"+id);
		service.deleteUser(id);
		return "index";
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getUser(@PathVariable("id") String id){
		System.out.println("获取用户id"+id);
		User user = service.getUser(id);
		Gson gson = new Gson();
		String userStr = gson.toJson(user);
		return userStr;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String updateUser(@RequestBody User user){
		System.out.println("update"+user);
		service.updateUser(user);
		return "";
	}
}
