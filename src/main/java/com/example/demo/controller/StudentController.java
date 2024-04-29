package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService userService;
	
	@PostMapping("/adduser")
	public Student addUser(@Valid @RequestBody Student user) {
		return userService.createUser(user);
	}
	
	@PostMapping("/addusers")
	public List<Student> addUsers(@Valid @RequestBody List<Student> users) {
		return userService.createUsers(users);
	}
	
	@GetMapping("/user/{id}")
	public Student getUserByID(@PathVariable int id) {
		return userService.getUserBYId(id);
		
	}
	
	@GetMapping("/users")
	public List<Student> getALLUsers(){
		return userService.getAllUsers();
	}
	
	@PatchMapping("/updateuser")
	public Student updateUser(@Valid @RequestBody Student user){
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserByID(id);
	}
	

	@DeleteMapping("/deleteall")
	public int deleteUser() {
		return userService.deleteAllUsers();
	}
	
	@GetMapping("/divide/{id}")
	public int divideNumber(@PathVariable int id) {
		return 10/id;
		
	}
	
	
	
}
