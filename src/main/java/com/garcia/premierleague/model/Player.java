package com.garcia.premierleague.model;

import com.garcia.premierleague.enums.PositionEnum;

import lombok.Data;

@Data
public class Player {

	private String name;
	private PositionEnum position;
	private String clubName;
	
}
