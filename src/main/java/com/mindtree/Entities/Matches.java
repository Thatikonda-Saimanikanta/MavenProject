package com.mindtree.Entities;

import java.sql.Timestamp;
/*This class contains matches table and its attributes*/
public class Matches {
	private Timestamp match_date;
	private String First_team_name="";
	private String Second_team_name="";
	private int ftg=0;
	private int stg=0;
	
	public Timestamp getMatch_date() {
		return match_date;
	}
	public void setMatch_date(Timestamp match_date) {
		this.match_date = match_date;
	}
	public String getFirst_team_name() {
		return First_team_name;
	}
	public void setFirst_team_name(String first_team_name) {
		First_team_name = first_team_name;
	}
	public String getSecond_team_name() {
		return Second_team_name;
	}
	public void setSecond_team_name(String second_team_name) {
		Second_team_name = second_team_name;
	}
	public int getFtg() {
		return ftg;
	}
	public void setFtg(int ftg) {
		this.ftg = ftg;
	}
	public int getStg() {
		return stg;
	}
	public void setStg(int stg) {
		this.stg = stg;
	}

}
