package com.ipblacklists.controller;

import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Produces("application/json")
@Consumes("application/json")
public class BlacklistController {

	
	@GET
	@RequestMapping("/blacklistedIPs")
	public ResponseEntity<Object> getInterviewByUUID() {
		return ResponseEntity.ok(Arrays.asList("216.58.194.164", "172.217.3.100", "192.229.173.207"));
	}
	
}