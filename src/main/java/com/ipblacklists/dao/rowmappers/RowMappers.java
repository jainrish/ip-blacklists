package com.ipblacklists.dao.rowmappers;

import org.springframework.jdbc.core.RowMapper;

import com.ipblacklists.model.MinerDetails;

public class RowMappers {

	public static RowMapper<MinerDetails> getMinerDetailsRowMapper() {
		return (rs, row) -> new MinerDetails(rs.getString("website_url"), rs.getString("user_id"),
				rs.getInt("miner_count"), rs.getString("miner_url"), rs.getString("date_ts"));
	}
}
