package com.in28minutes.springboot.controller;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.Application;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {
	
	//@LocalServerPort
	//private int port;
	
	@Test
	public void testJsonAssert() throws JSONException{
		JSONAssert.assertEquals("{id:1}","{id:1,name:Ranga}", false);
	}
	
	@Test
	public void test() {
		String url = "http://localhost:" + "port" + "/surveys/Survey1/questions/Question1";
		TestRestTemplate restTemplate = new TestRestTemplate();
		//String output = restTemplate.getForObject(url, String.class);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity entity = new HttpEntity<String>(null,headers);
		
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
		
		System.out.println("Response : " + response.getBody());
		assertTrue(response.getBody().contains("\"id\":\"Question1\""));
	}
}
