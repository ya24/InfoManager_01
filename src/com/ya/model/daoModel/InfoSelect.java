package com.ya.model.daoModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-08-01
 * @desc ��ѯ���ݿ���Ϣ�ࣨҵ���߼������ࣩ
 * 
 */

public class InfoSelect {

	/*
	 * ��ѯ��Ϊ�� 
	 * 	1.����ѧ�Ų�ѯ������һ����������ж�ѧ�š����롢����Ƿ������ݿ��е�����ƥ�� 
	 * 		select idNumber,password,iden,name form PersonInfo where idNumber=?
	 * 	2.����ѧ�ţ������ݿ��в��ң���ø�����Ϣ select * from PersonInfo where idNumber=?
	 * 	3.�����꼶���Ա�ϵ�� �������ݿ��в��ң����һϵ��ѧ�� select idNumber from PersonInfo where grade=? and sex=? and dept=?
	 */

	DaoPattern pattern = new DaoPattern();// �������ݿ���Ϣ������

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ��ѯ��½��Ϣ
	 * @param values
	 *            ��?��ֵ���ַ�������
	 * @return ���ز�ѯ������Ϣ����
	 */
	public Vector<String> selLoginInfo(String[] values) {
		// ����һ�����������
		ResultSet rs = null;
		// ����һ�����ϣ�����ʢ�Ų�ѯ������Ϣ
		Vector<String> vector = new Vector<String>();
		try {
			// �����ѯ��½��Ϣsql���
			String selLgInfoSQL = "select idNumber,psw,iden,name from PersonInfo where idNumber=?";
			// ִ��sql��䣬���ؽ����
			rs = pattern.queryInfo(selLgInfoSQL, values);
			// ��������
			while (rs.next()) {
				// ��ÿ����¼���ֶ�ֵ��ӵ�������
				vector.add(rs.getString("idNumber"));
				vector.add(rs.getString("psw"));
				vector.add(rs.getString("iden"));
				vector.add(rs.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			pattern.close();
		}

		return vector;
	}

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ��ѯ������Ϣ�ķ���
	 * @param values
	 *            ��?��ֵ���ַ�������
	 * @return ���ز�ѯ������Ϣ����
	 */
	public Vector<String> selInfo(String[] values) {
		// ����һ�����������
		ResultSet rs = null;
		// ����һ�����ϣ�����ʢ�Ų�ѯ������Ϣ
		Vector<String> vector = new Vector<String>();
		try {
			// �����ѯ������Ϣsql���
			String selSQL = "select * from PersonInfo where idNumber=?";
			// ִ��sql��䣬���ؽ����
			rs = pattern.queryInfo(selSQL, values);
			// ��������
			while (rs.next()) {
				// ��ÿ����¼���ֶ�ֵ��ӵ�������
				vector.add(rs.getString("psw"));
				vector.add(rs.getString("idNumber"));
				vector.add(rs.getString("name"));
				vector.add(rs.getString("sex"));
				vector.add(rs.getString("grade"));
				vector.add(rs.getString("dept"));
				vector.add(rs.getString("major"));
				vector.add(rs.getString("iden"));
				vector.add(rs.getString("born"));
				vector.add(rs.getString("phone"));
				vector.add(rs.getString("pSignature"));
				vector.add(rs.getString("pAddress"));
				vector.add(rs.getString("picture"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			pattern.close();
		}

		return vector;
	}

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ����������ѯѧ�ŵķ���
	 * @param values
	 *            ��?��ֵ���ַ�������
	 * @return ���ز�ѯ������Ϣ����
	 */
	public Vector<String> selIdNum(String[] values) {
		// ����һ�����������
		ResultSet rs = null;
		// ����һ�����ϣ�����ʢ�Ų�ѯ������Ϣ
		Vector<String> vector = new Vector<String>();
		try {
			// �����ѯѧ��sql���(�����꼶���Ա�ϵ�� �������ݿ��в���)
			String selIdNumSQL = "select idNumber from PersonInfo where grade=? and sex=? and dept=?";
			// ִ��sql��䣬���ؽ����
			rs = pattern.queryInfo(selIdNumSQL, values);
			// ��������
			while (rs.next()) {
				vector.add(rs.getString("idNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			pattern.close();
		}

		return vector;
	}

	
	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ֱ�Ӳ�ѯѧ��
	 * @param values ��?��ֵ���ַ�������
	 * @return  ���ز�ѯ������Ϣ����
	 */
	public Vector<String> directSelIdNum(String[] values) {
		// ����һ�����������
		ResultSet rs = null;
		// ����һ�����ϣ�����ʢ�Ų�ѯ������Ϣ
		Vector<String> vector = new Vector<String>();
		try {
			// �����ѯѧ��sql���(ֱ�Ӳ�ѯѧ��)
			String selIdNumSQL = "select idNumber from PersonInfo ";
			// ִ��sql��䣬���ؽ����
			rs = pattern.queryInfo(selIdNumSQL, values);
			// ��������
			while (rs.next()) {
				vector.add(rs.getString("idNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			pattern.close();
		}

		return vector;
	}

	
	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ��ѯ���ݿ����Ƿ����ָ��ѧ��
	 * @param values ��?��ֵ���ַ�������
	 * @return ���ز�ѯ������Ϣ����
	 */
	public Vector<String> checkIdNum(String[] values) {
		// ����һ�����������
		ResultSet rs = null;
		// ����һ�����ϣ�����ʢ�Ų�ѯ������Ϣ
		Vector<String> vector = new Vector<String>();
		try {
			// �����ѯѧ��sql���(ֱ�Ӳ�ѯѧ��)
			String selIdNumSQL = "select idNumber from PersonInfo where idNumber=?";
			// ִ��sql��䣬���ؽ����
			rs = pattern.queryInfo(selIdNumSQL, values);
			// ��������
			while (rs.next()) {
				vector.add(rs.getString("idNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			pattern.close();
		}

		return vector;
	}
}
