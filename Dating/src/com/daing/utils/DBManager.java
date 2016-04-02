package com.daing.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	public static Connection getConn() {
		Connection conn = null;
		try {
			// 1、加载连接驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2、连接到数据库（获得连接对象）
			// 通过连接管理器(DriverManager)类的一个方法来获得连接对象，里面的参数表示我们连接到数据源bookdemo
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/Dating?"
							+ "useUnicode=true&characterEncoding=utf8", "root", "root");
		} catch (ClassNotFoundException e) {
			// 以堆栈的方式将错误信息打印出来
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn; // 将连接对象返回
	}

	public static void closeConn(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
