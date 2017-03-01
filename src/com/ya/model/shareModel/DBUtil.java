package com.ya.model.shareModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author 叶雅芳
 * @date 2015-08-01
 * @desc 连接数据库操作类
 *
 */

public class DBUtil {

	public static Connection getConnection() {
		Connection conn=null;
		try {
			// 加载驱动程序
			Class.forName(Constants.DRIVER);
			//连接数据库
			conn = DriverManager.getConnection(Constants.URL,
					Constants.USERNAME, Constants.PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;

	}

}
