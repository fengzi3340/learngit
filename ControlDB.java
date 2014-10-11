package org.db;
import java.sql.*;
import java.util.*;

import org.bean.*;
public class ControlDB {
	private static ControlDB controlDB = null;
	private ControlDB(){}
	public static ControlDB getInstance() {
		if(controlDB==null) {
			controlDB = new ControlDB();
		}
		return controlDB;
	}
	public List<Book> executeQueryBook(String sql) throws Exception {
		List<Book> list = new ArrayList<Book>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2fengzi3340", "kkx2wwnkm0", "hllzki34imyiiyxx022kiy5m03h34m2x0y03y4jj");
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);//（2）发送SQL语句到数据库中
			while(rs.next()) {
				Book bo = new Book();
				int i = 1;
				bo.setISBN(rs.getString(i++));
				bo.setTitle(rs.getString(i++));
				bo.setAuthorID(rs.getInt(i++));
				bo.setPublisher(rs.getString(i++));
				bo.setPublishDate(rs.getString(i++));
				bo.setPrice(rs.getFloat(i++));
				list.add(bo);
			}
			rs.close();                                           //（4）关闭
			stmt.close();
			con.close();
		} catch(Exception e) {
			throw e;
		}
		return list;
	}
	public List<Author> executeQueryAuthor(String sql) throws Exception {
		List<Author> list = new ArrayList<Author>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2fengzi3340", "kkx2wwnkm0", "hllzki34imyiiyxx022kiy5m03h34m2x0y03y4jj");
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);//（2）发送SQL语句到数据库中
			while(rs.next()) {
				Author au = new Author();
				int i = 1;
				au.setAuthorID(rs.getInt("AuthorID"));
				au.setName(rs.getString("Name"));
				au.setAge(rs.getInt("Age"));
				au.setCountry(rs.getString("Country"));
				list.add(au);
			}
			rs.close();                                           //（4）关闭
			stmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean executeUpdate(String sql) throws Exception {
		boolean flag = false;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2fengzi3340", "kkx2wwnkm0", "hllzki34imyiiyxx022kiy5m03h34m2x0y03y4jj");
			Statement stmt = con.createStatement();
			int row = stmt.executeUpdate(sql);
			System.out.println(row);
			flag = row>0?true:false;
			stmt.close();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
}
