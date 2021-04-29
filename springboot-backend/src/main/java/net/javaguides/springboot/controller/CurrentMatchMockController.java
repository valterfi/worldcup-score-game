package net.javaguides.springboot.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/matches/")
public class CurrentMatchMockController {

	@GetMapping(value = "current", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object current() {
		Resource resource = new ClassPathResource("emptyList.json");
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(resource.getInputStream(), Object.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
