package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

public class Reply_PostEnt implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer post_id;
	private String content;
	private Integer reply_userid;
	private Long issue_time;
	private UserEnt ue;
	public Reply_PostEnt() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPlaced_id() {
		return post_id;
	}
	public void setPlaced_id(Integer post_id) {
		this.post_id = post_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getReply_userid() {
		return reply_userid;
	}
	public void setReply_userid(Integer reply_userid) {
		this.reply_userid = reply_userid;
	}
	public Long getIssue_time() {
		return issue_time;
	}
	public void setIssue_time(Long issue_time) {
		this.issue_time = issue_time;
	}
	public UserEnt getUe() {
		return ue;
	}
	public void setUe(UserEnt ue) {
		this.ue = ue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reply_PostEnt other = (Reply_PostEnt) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reply_PostEnt [id=" + id + ", post_id=" + post_id + ", content=" + content + ", reply_userid="
				+ reply_userid + ", issue_time=" + issue_time + ", ue=" + ue + "]";
	}
	public Reply_PostEnt(Integer id, Integer placed_id, String content, Integer reply_userid, Long issue_time,
			UserEnt ue) {
		super();
		this.id = id;
		this.post_id = placed_id;
		this.content = content;
		this.reply_userid = reply_userid;
		this.issue_time = issue_time;
		this.ue = ue;
	}
	
	
}
