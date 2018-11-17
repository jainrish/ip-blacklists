package com.ipblacklists.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipblacklists.dao.impl.MinerDetailsDaoImpl;

@RestController
@Produces("application/json")
@Consumes("application/json")
public class MinerDetailsController {

	@Autowired
	private MinerDetailsDaoImpl minerDetailsDao;
	
	@GET
	@RequestMapping("/minerDetails")
	public ResponseEntity<Object> getAllMinerDetails() {
//		minerDetailsDao.createTable();
		return ResponseEntity.ok("created table");
	}
	
	@GET
	@RequestMapping("/getWebsitesCount")
	public ResponseEntity<Object> getWebsitesCount() {
		return ResponseEntity.ok(minerDetailsDao.getTotalWebsitesCount());
	}
	
}
