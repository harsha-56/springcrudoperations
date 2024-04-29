package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;

@Service
//we want doa layer object here we need to inject
public class StudentService {
	@Autowired
	private StudentRepository userRepository;
	
	public Student createUser(Student user) {
		return userRepository.save(user);
	}
	
	
	public List<Student> createUsers(List<Student> users) {
		return userRepository.saveAll(users);
	}
	
	public Student getUserBYId(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public List<Student> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Student updateUser(Student user) {
		Student olduser = null;
		Optional<Student> optionaluser =  userRepository.findById(user.getId());
		
		if(optionaluser.isPresent()) {
			olduser = optionaluser.get();
			olduser.setName(user.getName());
			olduser.setAddress(user.getAddress());
			userRepository.save(olduser);
		}else {
			return new Student();
		}
		return olduser;
	}
	
	public String deleteUserByID(int id) {
		userRepository.deleteById(id);
		return "User got deleted";
		
	}
	
	public int deleteAllUsers() {
		return userRepository.deleteAllUsers();
		
	}


}
