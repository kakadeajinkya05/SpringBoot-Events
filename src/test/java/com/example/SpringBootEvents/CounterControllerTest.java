package com.example.SpringBootEvents;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.SpringBootEvents.controller.SSEController;

@RunWith(MockitoJUnitRunner.class)
public class CounterControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private SSEController sSEController;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.standaloneSetup(sSEController).build();
	}

	@Test
	public void checkRequestStatus() throws Exception{
	    mockMvc.perform(get("/api/count"))
        .andExpect(status().isOk());
	}
	
}

