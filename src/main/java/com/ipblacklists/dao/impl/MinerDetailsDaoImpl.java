package com.ipblacklists.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ipblacklists.dao.MinerDetailsDao;
import com.ipblacklists.model.MinerDetails;

public class MinerDetailsDaoImpl extends JdbcDaoSupport implements MinerDetailsDao{

	@Autowired 
    DataSource dataSource;
 
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
	
	@Override
	public List<MinerDetails> getAllMinerDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MinerDetails getMinerDetailsByWebsite(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveMinerDetails(MinerDetails minerDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MinerDetails> getMiningWebsites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MinerDetails> getNonMiningWebsites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalWebsitesCount() {
		return getJdbcTemplate().queryForList("select count(*) from minerdetails", Integer.class).get(0);
	}

	@Override
	public int getMiningWebsitesCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
