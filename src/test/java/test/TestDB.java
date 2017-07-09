package test;

import java.io.*;
import java.sql.*;

public class TestDB {

	/**
	 * 读取指定文件下sql脚本，执行到数据库 朱行读取分批处理批量插入数据库
	 */

	public static void main(String[] args) {
		System.err.println("begin");
		long start = System.currentTimeMillis();
		String path = "/Users/zheng/Downloads/Untitled.sql";
		getData(path);
		System.err.print((System.currentTimeMillis() - start) / 1000);

	}

	private static void getData(String path) {
		// 读取文件
		BufferedReader reader;
		Connection conn = null;
		Statement pst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/TestInpt?useUnicode=true&characterEncoding=utf-8", "root", "as77889900");
			pst = conn.createStatement();
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			String line;
			String sql="";
			while ((line = reader.readLine()) != null) {
				
				sql=sql+"\n"+line;
				
			}
			System.out.println(sql);
			// 执行批量更新
			pst.execute(sql);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
