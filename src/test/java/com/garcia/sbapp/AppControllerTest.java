package com.garcia.sbapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@WithMockUser(username = "admin", authorities = { "ADMIN", "USER" })
	@Test
	void test() throws Exception {
		mockMvc.perform(get("/"))
		.andDo(print())//Print request & response
		.andExpect(status().isOk())
		.andExpect(content().string("Landing Page"));
	}
	
	@WithMockUser(username = "admin", authorities = { "ADMIN", "USER" })
	@Test
	void testGetPrinciple() throws Exception {
		mockMvc.perform(get("/principal"))
		.andDo(print())//Print request & response
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("admin"))
		.andExpect(jsonPath("$.credentials").value("password"))
		.andExpect(jsonPath("$.authorities[0].authority").value("ADMIN"));
	}
	
}
