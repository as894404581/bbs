package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

public class PostEnt implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer plate_id;
	private String title;
	private String content;
	private Integer issue_userid;
	private Integer see_count;
	private Integer reply_count;
	private Long issue_time;
	private Integer last_reply_uid;
	private Long last_reply_issue_time;
	private Integer price;
	private Integer access_rights;
	private UserEnt author;
	private UserEnt last_ue;
	

	public PostEnt(Integer id, Integer plate_id, String title, String content, Integer issue_userid, Integer see_count,
			Integer reply_count, Long issue_time, Integer last_reply_uid, Long last_reply_issue_time, Integer price,
			Integer access_rights, UserEnt author, UserEnt last_ue) {
		super();
		this.id = id;
		this.plate_id = plate_id;
		this.title = title;
		this.content = content;
		this.issue_userid = issue_userid;
		this.see_count = see_count;
		this.reply_count = reply_count;
		this.issue_time = issue_time;
		this.last_reply_uid = last_reply_uid;
		this.last_reply_issue_time = last_reply_issue_time;
		this.price = price;
		this.access_rights = access_rights;
		this.author = author;
		this.last_ue = last_ue;
	}


	@Override
	public String toString() {
		return "PostEnt [id=" + id + ", plate_id=" + plate_id + ", title=" + title + ", content=" + content
				+ ", issue_userid=" + issue_userid + ", see_count=" + see_count + ", reply_count=" + reply_count
				+ ", issue_time=" + issue_time + ", last_reply_uid=" + last_reply_uid + ", last_reply_issue_time="
				+ last_reply_issue_time + ", price=" + price + ", access_rights=" + access_rights + ", author=" + author
				+ ", last_ue=" + last_ue + "]";
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
		PostEnt other = (PostEnt) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPlate_id() {
		return plate_id;
	}


	public void setPlate_id(Integer plate_id) {
		this.plate_id = plate_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Integer getIssue_userid() {
		return issue_userid;
	}


	public void setIssue_userid(Integer issue_userid) {
		this.issue_userid = issue_userid;
	}


	public Integer getSee_count() {
		return see_count;
	}


	public void setSee_count(Integer see_count) {
		this.see_count = see_count;
	}


	public Integer getReply_count() {
		return reply_count;
	}


	public void setReply_count(Integer reply_count) {
		this.reply_count = reply_count;
	}


	public Long getIssue_time() {
		return issue_time;
	}


	public void setIssue_time(Long issue_time) {
		this.issue_time = issue_time;
	}


	public Integer getLast_reply_uid() {
		return last_reply_uid;
	}


	public void setLast_reply_uid(Integer last_reply_uid) {
		this.last_reply_uid = last_reply_uid;
	}


	public Long getLast_reply_issue_time() {
		return last_reply_issue_time;
	}


	public void setLast_reply_issue_time(Long last_reply_issue_time) {
		this.last_reply_issue_time = last_reply_issue_time;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getAccess_rights() {
		return access_rights;
	}


	public void setAccess_rights(Integer access_rights) {
		this.access_rights = access_rights;
	}


	public UserEnt getAuthor() {
		return author;
	}


	public void setAuthor(UserEnt author) {
		this.author = author;
	}


	public UserEnt getLast_ue() {
		return last_ue;
	}


	public void setLast_ue(UserEnt last_ue) {
		this.last_ue = last_ue;
	}


	public PostEnt() {
		
	}
	

}
