package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Player;
import net.javaguides.springboot.repository.PlayerRepository;
import net.javaguides.springboot.service.PlayerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerService playerService;

	@GetMapping("/players")
	public List<Player> getAllPlayers() {
		return playerService.findAllPlayers();
	}

	@PostMapping("/players")
	public Player createEmployee(@RequestBody Player player) {
		return playerRepository.save(player);
	}

	@GetMapping("/players/{id}")
	public ResponseEntity<Player> getPlayeryId(@PathVariable Long id) {
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(player);
	}

	@PutMapping("/players/{id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails){
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Player not exist with id :" + id));

		player.setName(playerDetails.getName());
		player.setScoreTeam1(playerDetails.getScoreTeam1());
		player.setScoreTeam2(playerDetails.getScoreTeam2());

		Player updatedPlayer = playerRepository.save(player);
		return ResponseEntity.ok(updatedPlayer);
	}

	@DeleteMapping("/players/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePlayer(@PathVariable Long id){
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Player not exist with id :" + id));

		playerRepository.delete(player);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}


}
