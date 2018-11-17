package com.ipblacklists.dao;

import java.util.List;

import com.ipblacklists.model.MinerDetails;

public interface MinerDetailsDao {

	public List<MinerDetails> getAllMinerDetails();
	public MinerDetails getMinerDetailsByWebsite(String url);
	public boolean saveMinerDetails(MinerDetails minerDetails);
	public List<MinerDetails> getMiningWebsites();
	public List<MinerDetails> getNonMiningWebsites();
	public int getTotalWebsitesCount();
	public int getMiningWebsitesCount();
}
