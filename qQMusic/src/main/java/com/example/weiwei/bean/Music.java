package com.example.weiwei.bean;

public class Music {
	private String name;
	private String singer;
	private String zj;
	private long time;
	private String url;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Music(String name, String singer, String zj) {
		super();
		this.name = name;
		this.singer = singer;
		this.zj = zj;

		
	}
	public Music() {
		super();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getZj() {
		return zj;
	}
	public void setZj(String zj) {
		this.zj = zj;
	}


	@Override
	public String toString() {
		return "Music{" +
				"name='" + name + '\'' +
				", singer='" + singer + '\'' +
				", zj='" + zj + '\'' +
				", time=" + time +
				'}';
	}
}
