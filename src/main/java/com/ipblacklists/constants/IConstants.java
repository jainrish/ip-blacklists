package com.ipblacklists.constants;

public interface IConstants {
	
	String CREATE_MINER_DETAILS_TABLE = "create table miner_details (website_url VARCHAR(500) PRIMARY KEY, user_id VARCHAR(10) NOT NULL, miner_count INTEGER NOT NULL, miner_url VARCHAR(100), date VARCHAR(20))";
	String GET_TOTAL_COUNT = "select count(*) from miner_details";
	String GET_MINER_COUNT = "select count(*) from miner_details where miner_count>0";
}
