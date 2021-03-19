package com.garcia.premierleague.model;

import java.util.List;

import lombok.Data;

@Data
public class Team {

	private final String name;
	private final List<Player> players;
	
	public Team(TeamBuilder builder) {
		this.name = builder.name;
		this.players = builder.players;
	}
	
	public static class TeamBuilder {
		private String name;
		private List<Player> players;
		
		public TeamBuilder() {	
		}
		
		public TeamBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public TeamBuilder setPlayers(List<Player> players) {
			this.players = players;
			return this;
		}
		
		public Team build() {
			Team team =  new Team(this);
            return team;
        }
	}
}
