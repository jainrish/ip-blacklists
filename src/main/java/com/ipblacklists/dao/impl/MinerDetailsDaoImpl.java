package com.ipblacklists.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ipblacklists.constants.IConstants;
import com.ipblacklists.dao.MinerDetailsDao;
import com.ipblacklists.model.MinerDetails;
import static com.ipblacklists.constants.IConstants.*;
@Repository
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
		return getJdbcTemplate().queryForList(GET_TOTAL_COUNT, Integer.class).get(0);
	}

	@Override
	public int getMiningWebsitesCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void createTable() {
		getJdbcTemplate().update(CREATE_MINER_DETAILS_TABLE);
		
	}
	
}
