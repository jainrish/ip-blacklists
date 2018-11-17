package com.ipblacklists.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipblacklists.dao.impl.MinerDetailsDaoImpl;
import com.ipblacklists.model.MinerDetails;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MinerDetailsControllerTest {

	@Autowired
	MinerDetailsController minerDetailsController;
	
	@Autowired
	MinerDetailsDaoImpl minerDetailsDao;
	
	@Test
	public void testCreate() {
		Assert.assertEquals(0, minerDetailsDao.getTotalWebsitesCount());
		MinerDetails minerDetails = new MinerDetails("https://rishjain.me", "rishabh", 1, "https://coinhive.com/js", null);
		minerDetailsController.saveWebsiteData(minerDetails);
		Assert.assertEquals(1, minerDetailsDao.getTotalWebsitesCount());
		Assert.assertEquals(1, minerDetailsDao.getMiningWebsitesCount());
		
		System.out.println(minerDetailsController.getMinerDetailsByURL("https://rishjain.me"));
		minerDetailsDao.deleteWebsite("https://rishjain.me");
		Assert.assertEquals(0, minerDetailsDao.getTotalWebsitesCount());
		Assert.assertEquals(0, minerDetailsDao.getMiningWebsitesCount());
	}
	
	@Test
	public void testUpdate() {
		Assert.assertEquals(0, minerDetailsDao.getTotalWebsitesCount());
		MinerDetails minerDetails = new MinerDetails("https://rishjain.me", "rishabh", 1, "https://coinhive.com/js", null);
		minerDetailsController.saveWebsiteData(minerDetails);
		Assert.assertEquals(1, minerDetailsController.getTotalWebsitesCount().getBody());
		
		minerDetails = new MinerDetails("https://abc.me", "rishabh", 0, "https://coinhive.com/js", null);
		minerDetailsController.saveWebsiteData(minerDetails);
		Assert.assertEquals(2, minerDetailsController.getTotalWebsitesCount().getBody());
		Assert.assertEquals(1, minerDetailsController.getMiningWebsitesCount().getBody());
		Assert.assertEquals(1, minerDetailsController.getNonMiningWebsitesCount().getBody());
		
		minerDetails = new MinerDetails("https://rishjain.me", "rishabh", 0, "https://coinhive.com", null);
		minerDetailsController.saveWebsiteData(minerDetails);
		Assert.assertEquals(2, minerDetailsController.getTotalWebsitesCount().getBody());
		Assert.assertEquals(0, minerDetailsController.getMiningWebsitesCount().getBody());
		Assert.assertEquals(2, minerDetailsController.getNonMiningWebsitesCount().getBody());
		
		System.out.println(minerDetailsController.getMinerDetailsByURL("https://rishjain.me"));
		minerDetailsDao.deleteWebsite("https://rishjain.me");
		Assert.assertEquals(1, minerDetailsController.getTotalWebsitesCount().getBody());
		Assert.assertEquals(0, minerDetailsController.getMiningWebsitesCount().getBody());
		
		minerDetailsDao.deleteWebsite("https://abc.me");
		Assert.assertEquals(0, minerDetailsController.getTotalWebsitesCount().getBody());
	}
	
	

}
