package com.garcia.sbapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {

	@GetMapping("/")
	public String defaultPage() {
		return "Landing Page";
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
