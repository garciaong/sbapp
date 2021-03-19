package com.garcia.premierleague.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.garcia.premierleague.model.Team;

@Service
public class TeamServiceImpl implements TeamService{

	public List<Team> listAllTeams(){
		List<Team> teams = new ArrayList<>();
		teams.add(new Team.TeamBuilder().setName("Arsenal").build());
		teams.add(new Team.TeamBuilder().setName("Chelsea").build());
		teams.add(new Team.TeamBuilder().setName("Liverpool").build());
		teams.add(new Team.TeamBuilder().setName("Manchester United").build());
		teams.add(new Team.TeamBuilder().setName("Manchester City").build());
		teams.add(new Team.TeamBuilder().setName("Tottenham").build());
		return teams;
	}
	
}
