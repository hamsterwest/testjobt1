package com.testjob;

import com.testjob.controller.FrequencyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringApplicationTests {
	@Autowired
	private FrequencyController frequencyController;

	@Test
	void contextLoads() {
		assertThat(frequencyController).isNotNull();
	}

	@Test
	void testCharacterFrequencyCalculation() {
		RestTemplate restTemplate = new RestTemplate();
		Map response = restTemplate.getForObject("http://localhost:8080/frequency-check?string=aaaaabcccc", Map.class);
		assertEquals(5, response.get("a"));
		assertEquals(4, response.get("c"));
		assertEquals(1, response.get("b"));
	}

	@Test
	void emptyStringParamInQuery() {
		RestTemplate restTemplate = new RestTemplate();
		Map response = restTemplate.getForObject("http://localhost:8080/frequency-check?string=", Map.class);
		assertEquals("Query parameter is empty string", response.get("Error"));
	}
}
