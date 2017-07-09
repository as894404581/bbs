package xyz.zhtdemo.bbs.entity;

import java.io.Serializable;

public class User_CountEnt implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer user_id;
	private Integer total_integral;
	private Integer integral1;
	private Integer integral2;
	private Integer integral3;
	private Integer integral4;
	private Integer integral5;
	private Integer integral6;
	private Integer integral7;
	private Integer integral8;
	private Integer post_count;
	private Integer rep_count;
	

	public User_CountEnt(Integer user_id, Integer total_integral, Integer integral1, Integer integral2,
			Integer integral3, Integer integral4, Integer integral5, Integer integral6, Integer integral7,
			Integer integral8, Integer post_count, Integer rep_count) {
		super();
		this.user_id = user_id;
		this.total_integral = total_integral;
		this.integral1 = integral1;
		this.integral2 = integral2;
		this.integral3 = integral3;
		this.integral4 = integral4;
		this.integral5 = integral5;
		this.integral6 = integral6;
		this.integral7 = integral7;
		this.integral8 = integral8;
		this.post_count = post_count;
		this.rep_count = rep_count;
	}


	@Override
	public String toString() {
		return "User_CountEnt [user_id=" + user_id + ", total_integral=" + total_integral + ", integral1=" + integral1
				+ ", integral2=" + integral2 + ", integral3=" + integral3 + ", integral4=" + integral4 + ", integral5="
				+ integral5 + ", integral6=" + integral6 + ", integral7=" + integral7 + ", integral8=" + integral8
				+ ", post_count=" + post_count + ", rep_count=" + rep_count + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		User_CountEnt other = (User_CountEnt) obj;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public Integer getTotal_integral() {
		return total_integral;
	}


	public void setTotal_integral(Integer total_integral) {
		this.total_integral = total_integral;
	}


	public Integer getIntegral1() {
		return integral1;
	}


	public void setIntegral1(Integer integral1) {
		this.integral1 = integral1;
	}


	public Integer getIntegral2() {
		return integral2;
	}


	public void setIntegral2(Integer integral2) {
		this.integral2 = integral2;
	}


	public Integer getIntegral3() {
		return integral3;
	}


	public void setIntegral3(Integer integral3) {
		this.integral3 = integral3;
	}


	public Integer getIntegral4() {
		return integral4;
	}


	public void setIntegral4(Integer integral4) {
		this.integral4 = integral4;
	}


	public Integer getIntegral5() {
		return integral5;
	}


	public void setIntegral5(Integer integral5) {
		this.integral5 = integral5;
	}


	public Integer getIntegral6() {
		return integral6;
	}


	public void setIntegral6(Integer integral6) {
		this.integral6 = integral6;
	}


	public Integer getIntegral7() {
		return integral7;
	}


	public void setIntegral7(Integer integral7) {
		this.integral7 = integral7;
	}


	public Integer getIntegral8() {
		return integral8;
	}


	public void setIntegral8(Integer integral8) {
		this.integral8 = integral8;
	}


	public Integer getPost_count() {
		return post_count;
	}


	public void setPost_count(Integer post_count) {
		this.post_count = post_count;
	}


	public Integer getRep_count() {
		return rep_count;
	}


	public void setRep_count(Integer rep_count) {
		this.rep_count = rep_count;
	}


	public User_CountEnt() {
		
	}
	
	
}
