package com.ipblacklists.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipblacklists.dao.impl.MinerDetailsDaoImpl;
import com.ipblacklists.model.MinerDetails;

@RestController
@Produces("application/json")
@Consumes("application/json")
public class MinerDetailsController {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final int MAX_LEN = 100;
	
	@Autowired
	private MinerDetailsDaoImpl minerDetailsDao;
	
	
	@GET
	@RequestMapping("/minerDetails/{url}")
	public ResponseEntity<Object> getAllMinerDetails(@PathVariable String url) {
		MinerDetails minerDetails = minerDetailsDao.getMinerDetailsByWebsite(url);
		return minerDetails==null? ResponseEntity.ok("not found") : ResponseEntity.ok(minerDetails);
	}
	
	@GET
	@RequestMapping("/getTotalWebsitesCount")
	public ResponseEntity<Object> getTotalWebsitesCount() {
		return ResponseEntity.ok(minerDetailsDao.getTotalWebsitesCount());
	}
	
	@GET
	@RequestMapping("/getMiningWebsitesCount")
	public ResponseEntity<Object> getMiningWebsitesCount() {
		return ResponseEntity.ok(minerDetailsDao.getMiningWebsitesCount());
	}
	
	@GET
	@RequestMapping("/getNonMiningWebsitesCount")
	public ResponseEntity<Object> getNonMiningWebsitesCount() {
		return ResponseEntity.ok(minerDetailsDao.getNonMiningWebsitesCount());
	}
	
	@POST
	@RequestMapping("/saveWebsite")
	public ResponseEntity<Object> saveWebsiteData(@RequestBody MinerDetails minerDetails) {
		minerDetails.setTimeStamp(simpleDateFormat.format(new Date()));
		if(minerDetails.getWebsiteURL().length()>MAX_LEN) {
			minerDetails.setWebsiteURL(minerDetails.getWebsiteURL().substring(0, MAX_LEN));
		}
		
		if(minerDetails.getMinerURL().length()>MAX_LEN) {
			minerDetails.setWebsiteURL(minerDetails.getMinerURL().substring(0, MAX_LEN));
		}
		
		boolean saved = minerDetailsDao.saveMinerDetails(minerDetails);
		return saved? ResponseEntity.ok("saved successfully") : ResponseEntity.ok("not saved");
		
	}
	
	
}
