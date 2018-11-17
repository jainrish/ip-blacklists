package com.ipblacklists.constants;

public interface IConstants {
	
	String CREATE_MINER_DETAILS_TABLE = "create table miner_details (website_url VARCHAR(500) PRIMARY KEY, user_id VARCHAR(10) NOT NULL, miner_count INTEGER NOT NULL, miner_url VARCHAR(100), date VARCHAR(20))";
	String GET_TOTAL_COUNT = "select count(*) from miner_details";
	String GET_MINER_COUNT = "select count(*) from miner_details where miner_count>0";
	String INSERT_MINER_DETAILS = "insert into miner_details (website_url, user_id, miner_count, miner_url, date) values(?,?,?,?,now())";
	String UPDATE_MINER_DETAILS = "update miner_details set user_id = ?, miner_count = ?, miner_url = ?, date = now() where website_url = ?";
	String DELETE_MINER_DETAILS = "delete from miner_details where website_url = ?";
	String GET_ALL_MINER_DETAILS = "select * from miner_details";
	String GET_MINER_DETAILS_BY_WEBSITE = "select * from miner_details where website_url = ?";
}
