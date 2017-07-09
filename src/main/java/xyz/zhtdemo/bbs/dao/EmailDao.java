package xyz.zhtdemo.bbs.dao;

import org.apache.ibatis.annotations.Param;

import xyz.zhtdemo.bbs.entity.EmailEnt;
import xyz.zhtdemo.bbs.entity.Look_forpassEnt;

/**
 * 此类操作有关Email相关表的数据
 * @author zheng
 *
 */
public interface EmailDao {
	/**
	 * 激活账号
	 * @param emailUrl 激活账号url
	 * @return
	 */
	public int checkEmail(String emailUrl);
	/**
	 * 根据用户名查询找回密码表中的数据
	 * @param users 用户名
	 * @return 找回密码表数据
	 */
	public Look_forpassEnt selectForPassByUser(String userid) ;
	
	/**
	 * 插入找回密码数据
	 * @param user	用户名
	 * @param md5	经过md5加密之后的url地址
	 * @return
	 */
	public int insertLook_forpass(@Param("userid")int userid,@Param("md5")String md5);

	/**
	 * 确认找回密码url
	 * @param email_url 找回密码url
	 * @return
	 */
	public Look_forpassEnt selectPassCheckEmail(String email_url);
	/**
	 * 更新用户密码
	 * @param user	用户
	 * @param password	经过md5加密过的密码
	 * @return
	 */
	public int updatePass(@Param("userid")int userid,@Param("password")String password);
	
	/**
	 * 插入邮箱数据
	 * @param email	email地址
	 * @param md5	激活账号路径
	 * @return
	 */
	public int insertEmail(@Param("uid")int uid,@Param("email")String email,@Param("md5")String md5);
	
	/**
	 * 根据email查询邮箱信息
	 * @param email
	 * @return
	 */
	public EmailEnt geEntByUid(int uid);
	
	/**
	 * 更新找回表找回状态为已找回
	 * @param userid 用户id
	 * @param url	找回链接
	 * @return
	 */
	public boolean updateLook_fropassTrue(@Param("userid")int userid,@Param("email_url")String url);
}
