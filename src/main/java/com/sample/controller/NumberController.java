package com.sample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Numbers;
import com.sample.service.NumberService;


@RestController
@RequestMapping("numbers")
public class NumberController {
	
	@Autowired
	private NumberService numberService;

	
	@PostMapping("number")
	public ResponseEntity<Numbers> saveNumbers(@Valid @RequestBody Numbers numbers) {
		numberService.addNumbers(numbers);
		return new ResponseEntity<Numbers>(HttpStatus.OK);
	}
	
	
	@GetMapping("maxNumber/{id}")
	public ResponseEntity<Numbers> getMaxNumber(@PathVariable("id") Long id){
		
		Numbers number = numberService.getNumberById(id);
		return new ResponseEntity<Numbers>(number, HttpStatus.OK);
		
	}
		

}
