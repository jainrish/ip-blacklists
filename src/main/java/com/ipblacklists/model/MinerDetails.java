package com.ipblacklists.model;

public class MinerDetails {

	private String websiteURL;
	private String user;
	private int minerCount;
	private String minerURL;
	private String timeStamp;
	
	public MinerDetails(String websiteURL, String user, int minerCount, String minerURL, String timeStamp) {
		super();
		this.websiteURL = websiteURL;
		this.user = user;
		this.minerCount = minerCount;
		this.minerURL = minerURL;
		this.timeStamp = timeStamp;
	}

	public String getWebsiteURL() {
		return websiteURL;
	}

	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getMinerCount() {
		return minerCount;
	}

	public void setMinerCount(int minerCount) {
		this.minerCount = minerCount;
	}

	public String getMinerURL() {
		return minerURL;
	}

	public void setMinerURL(String minerURL) {
		this.minerURL = minerURL;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "MinerDetails [websiteURL=" + websiteURL + ", user=" + user + ", minerCount=" + minerCount
				+ ", minerURL=" + minerURL + ", timeStamp=" + timeStamp + "]";
	}

	
}
