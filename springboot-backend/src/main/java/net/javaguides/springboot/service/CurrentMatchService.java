package net.javaguides.springboot.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.javaguides.springboot.data.CurrentResultData;
import net.javaguides.springboot.domain.Result;
import net.javaguides.springboot.domain.json.Example;

@Service
public class CurrentMatchService {

	@Autowired
	private CurrentResultData currentResultData;

	public String loadCurrentResult() {

		HttpURLConnection connection = null;
		BufferedReader reader = null;
		String json = null;
		try {
			//URL resetEndpoint = new URL("http://worldcup.sfg.io/matches/current");
			URL resetEndpoint = new URL("http://localhost:8080/matches/current");
			connection = (HttpURLConnection) resetEndpoint.openConnection();
			// Set request method to GET as required from the API
			connection.setRequestMethod("GET");

			// Read the response
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonSb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				jsonSb.append(line);
			}
			json = jsonSb.toString();

			if(StringUtils.isNoneEmpty(json)) {
				// Converts JSON string to Java object
				ObjectMapper mapper = new ObjectMapper();
				// Converts to an array of Book
				Example[] examples = mapper.readValue(json, Example[].class);
				if(examples.length >= 1) {
					Example resultadoAtual = examples[0];
					String team1 = resultadoAtual.getHomeTeam().getCountry();
					String team2 = resultadoAtual.getAwayTeam().getCountry();
					Integer scoresTeam1 = resultadoAtual.getHomeTeam().getGoals();
					Integer scoresTeam2 = resultadoAtual.getAwayTeam().getGoals();
					currentResultData.setResult(new Result(team1, team2, scoresTeam1, scoresTeam2));
				} else {
					currentResultData.setResult(new Result());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return currentResultData.getResult().getTitle();

	}

}
