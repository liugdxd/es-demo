package com.liugd.es.esdemo.web;
/**
 * 缓存的session
* @ClassName:：SessionInfo 
* @Description： TODO
* @author ：liugd
* @date ：2018年9月6日 下午4:25:51 
*
 */
public class SessionInfo {
	private String id;
	private long createTime;
	private long lastAccessTime;
	private boolean isNew;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	
}
