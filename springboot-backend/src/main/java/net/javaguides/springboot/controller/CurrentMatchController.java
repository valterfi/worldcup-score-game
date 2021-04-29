package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.domain.StringDTO;
import net.javaguides.springboot.service.CurrentMatchService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CurrentMatchController {

	@Autowired
	private CurrentMatchService currentMatchService;

	@PostMapping("/loadCurrentMatch")
	public ResponseEntity<StringDTO> loadCurrentMatch() {
		String title = currentMatchService.loadCurrentResult();
		return new ResponseEntity<>(new StringDTO(title), HttpStatus.OK);
	}

}
