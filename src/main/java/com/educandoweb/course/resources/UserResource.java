package com.educandoweb.course.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> listU = new ArrayList<>();
		
		listU.add(new User(1L, "Lucas Eduardo", "lesds2001@gmail.com", "999", "12345678"));
		listU.add(new User(2L, "Ailla Almeida", "lesds2001@gmail.com", "999999", "12345678"));
		listU.add(new User(3L, "Larah Raquel", "lesds2001@gmail.com", "999999", "12345678"));
		return ResponseEntity.ok().body(listU);
	}
}
