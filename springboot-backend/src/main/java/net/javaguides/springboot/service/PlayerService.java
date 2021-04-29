package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.data.CurrentResultData;
import net.javaguides.springboot.domain.Result;
import net.javaguides.springboot.model.Player;
import net.javaguides.springboot.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private CurrentResultData currentResultData;

	public List<Player> findAllPlayers() {
		Result result = currentResultData.getResult();
		List<Player> players = playerRepository.findAll();
		for (Player player : players) {
			if (!result.getStatus().equals("in progress")) {
				player.setEnable(true);
			} else {
				player.setEnable(false);
				if (player.getScoreTeam1().equals(result.getScoreTeam1()) &&
						player.getScoreTeam2().equals(result.getScoreTeam2())) {
					player.setReport("CONGRATS!!");
				} else {
					player.setReport("LOSER!!");
				}
			}
		}
		return players;
	}


}
