package com.spring.boot.rocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rocks.model.AppUser;
import com.spring.boot.rocks.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserRESTController {

	@Autowired
	UserRepository appUserRepository;

	@PostMapping("/appUsers")
	public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
		try {
			AppUser _appUser = appUserRepository.save(new AppUser(appUser.getSalutation(), appUser.getName(),
					appUser.getEmail(), appUser.getPreference(), appUser.getAddressList(), appUser.getExpertise()));
			return new ResponseEntity<>(_appUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
