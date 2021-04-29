package net.javaguides.springboot.domain;

public class Result {

	private String team1;

	private String team2;

	private Integer scoreTeam1;

	private Integer scoreTeam2;

	private String status;

	public Result() {
		this.status = "empty";
	}

	public Result(String team1, String team2, Integer scoreTeam1, Integer scoreTeam2) {
		this.team1 = team1;
		this.team2 = team2;
		this.scoreTeam1 = scoreTeam1;
		this.scoreTeam2 = scoreTeam2;
		this.status = "in progress";
	}

	public String getTitle() {
		if (this.status.equals("empty")) {
			return "No game in progress";
		} else {
			return team1 + " " + scoreTeam1 + " x " + scoreTeam2 + " " + team2;
		}
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public Integer getScoreTeam1() {
		return scoreTeam1;
	}

	public void setScoreTeam1(Integer scoreTeam1) {
		this.scoreTeam1 = scoreTeam1;
	}

	public Integer getScoreTeam2() {
		return scoreTeam2;
	}

	public void setScoreTeam2(Integer scoreTeam2) {
		this.scoreTeam2 = scoreTeam2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
