package com.ya.model.daoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ya.model.shareModel.DBUtil;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-08-01
 * @desc �������ݿ���Ϣ �����ࣨ�ײ�ģ���ࣩ
 * 
 */

public class DaoPattern {

	
	/** =========== �������ݿ����õĶ��� ================ */
	Connection conn = null; // ���ݿ����Ӷ���
	PreparedStatement ps = null; // PreparedStatement����
	ResultSet rs = null; // �����
	int count = 0; // ���ݿ�����Ӱ��ļ�¼����

	
	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ����һ���������ر���Դ����
	 */
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ����һ��������sql����ύǰ��׼������
	 * @param sql
	 *            ��Ҫִ�е�sql���
	 * @param values
	 *            ������ֵ���ַ�������
	 */
	public void before(String sql, String[] values) {

		try {
			// ���������ݿ������
			conn = DBUtil.getConnection();
			// ����preparedStatement����
			ps = conn.prepareStatement(sql);
			// ������ֵ
			for (int x = 0; x < values.length; x++) {
				ps.setString(x + 1, values[x]);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc �������ݿⷽ��
	 * @param updSQL
	 *            ��Ҫִ�еĸ������ݿ��������
	 * @param values
	 *            ������ֵ���ַ�������
	 * @return �������ݿ��Ƿ���Ӱ��
	 */
	public boolean updateInfo(String updSQL, String[] values) {
		boolean result = false;	//������ݿ��Ƿ���Ӱ��

		try {
			// �ύsql���ǰ��׼��
			this.before(updSQL, values);
			// ִ��sql��䣬�������ݿ���Ӱ�������
			count = ps.executeUpdate();
			// ��������
			if (count == 1) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			this.close();
		}

		return result;
	}

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ��ѯ���ݿⷽ��
	 * @param selectSQL
	 *            ��Ҫִ�еĲ�ѯ���ݿ��������
	 * @param values
	 *            ������ֵ���ַ�������
	 * @return ���ؽ����
	 */
	public ResultSet queryInfo(String selectSQL, String[] values) {

		try {
			// �ύsql���ǰ��׼��
			this.before(selectSQL, values);
			// ִ��sql��䣬���ؽ����
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

}
