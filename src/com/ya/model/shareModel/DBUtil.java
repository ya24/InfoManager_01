package com.ya.model.shareModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-08-01
 * @desc �������ݿ������
 *
 */

public class DBUtil {

	public static Connection getConnection() {
		Connection conn=null;
		try {
			// ������������
			Class.forName(Constants.DRIVER);
			//�������ݿ�
			conn = DriverManager.getConnection(Constants.URL,
					Constants.USERNAME, Constants.PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;

	}

}
