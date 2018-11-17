package com.ipblacklists.dao.impl;

import static com.ipblacklists.constants.IConstants.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ipblacklists.dao.MinerDetailsDao;
import com.ipblacklists.dao.rowmappers.RowMappers;
import com.ipblacklists.model.MinerDetails;

@Repository
public class MinerDetailsDaoImpl extends JdbcDaoSupport implements MinerDetailsDao {

	AtomicInteger totalWebsitesCount;
	Map<String, MinerDetails> minerMap;

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
		totalWebsitesCount = new AtomicInteger(getAllWebsitesCount());
		minerMap = getAllMinerDetails().stream()
				.collect(Collectors.toMap(miner -> miner.getWebsiteURL(), miner -> miner));
	}

	private void createTable() {
		getJdbcTemplate().update(DROP_TABLE_MINER_DETAILS);
		getJdbcTemplate().update(CREATE_MINER_DETAILS_TABLE);
		totalWebsitesCount = new AtomicInteger(0);
		minerMap = new HashMap<>();
	}

	private int getAllWebsitesCount() {
		return getJdbcTemplate().queryForList(GET_TOTAL_COUNT, Integer.class).get(0);
	}

	public List<MinerDetails> getAllMiningWebsites() {
		return getJdbcTemplate().query(GET_MINER_WEBSITES, RowMappers.getMinerDetailsRowMapper());
	}

	@Override
	public List<MinerDetails> getAllMinerDetails() {
		return getJdbcTemplate().query(GET_MINER_WEBSITES, RowMappers.getMinerDetailsRowMapper());
	}

	@Override
	public MinerDetails getMinerDetailsByWebsite(String url) {
		List<MinerDetails> minersList = getJdbcTemplate().query(GET_MINER_DETAILS_BY_WEBSITE, new Object[] { url },
				RowMappers.getMinerDetailsRowMapper());
		return CollectionUtils.isEmpty(minersList) ? null : minersList.get(0);
	}

	@Override
	public boolean saveMinerDetails(MinerDetails minerDetails) {
		int count = 0;
		try {
			count = getJdbcTemplate().update(INSERT_MINER_DETAILS,
					new Object[] { minerDetails.getWebsiteURL(), minerDetails.getUser(), minerDetails.getMinerCount(),
							minerDetails.getMinerURL(), minerDetails.getTimeStamp() });
			if (count > 0) {
				totalWebsitesCount.incrementAndGet();
			}
		} catch (Exception e) {
			count = getJdbcTemplate().update(UPDATE_MINER_DETAILS,
					new Object[] { minerDetails.getUser(), minerDetails.getMinerCount(), minerDetails.getMinerURL(),
							minerDetails.getTimeStamp(), minerDetails.getWebsiteURL() });
		}

		if (count > 0) {
			if (minerDetails.getMinerCount() > 0) {
				minerMap.put(minerDetails.getWebsiteURL(), minerDetails);
			} else {
				minerMap.remove(minerDetails.getWebsiteURL());
			}
		}

		return count > 0 ? true : false;
	}

	@Override
	public Collection<MinerDetails> getMiningWebsites() {
		return minerMap.values();
	}

	@Override
	public List<MinerDetails> getNonMiningWebsites() {
		return getJdbcTemplate().query(GET_NON_MINER_WEBSITES, RowMappers.getMinerDetailsRowMapper());
	}

	@Override
	public int getTotalWebsitesCount() {
		return totalWebsitesCount.intValue();
	}

	@Override
	public int getMiningWebsitesCount() {
		return minerMap.size();// getJdbcTemplate().queryForList(GET_MINER_COUNT, Integer.class).get(0);
	}

	@Override
	public int deleteWebsite(String url) {
		int count = getJdbcTemplate().update(DELETE_MINER_DETAILS, new Object[] { url });
		if (count > 0) {
			totalWebsitesCount.decrementAndGet();
			minerMap.remove(url);
		}
		return count;
	}

	@Override
	public int getNonMiningWebsitesCount() {
		return getAllWebsitesCount() - minerMap.size();
	}
	
	@Override
	public List<MinerDetails> getAllWebsites() {
		return getJdbcTemplate().query(GET_ALL_MINER_DETAILS, RowMappers.getMinerDetailsRowMapper());
	}

}
