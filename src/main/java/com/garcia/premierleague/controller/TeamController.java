package com.garcia.premierleague.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garcia.premierleague.model.Team;
import com.garcia.premierleague.service.TeamService;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@GetMapping({"/", "/list"})
	public List<Team> listAllTeams() {
		return teamService.listAllTeams();
	}
	
	@GetMapping("/add")
	public String addPage() {
		return "Add Page";
	}
	
	@GetMapping("/edit")
	public String editPage() {
		return "Edit Page";
	}
	
	@GetMapping("/delete")
	public String deletePage() {
		return "Delete Page";
	}
	
	@GetMapping("boss")
	public String reset() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
		updatedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);

		SecurityContextHolder.getContext().setAuthentication(newAuth);
		return "Reset done!";
	}
	
	@GetMapping("/principal")
	public Principal getPrinciple(Principal principal) {
        return principal;
    }
}
