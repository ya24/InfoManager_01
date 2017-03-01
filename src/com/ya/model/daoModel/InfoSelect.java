package com.ya.model.daoModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 
 * @author 叶雅芳
 * @date 2015-08-01
 * @desc 查询数据库信息类（业务逻辑处理类）
 * 
 */

public class InfoSelect {

	/*
	 * 查询分为： 
	 * 	1.根据学号查询，返回一个结果集，判断学号、密码、身份是否与数据库中的数据匹配 
	 * 		select idNumber,password,iden,name form PersonInfo where idNumber=?
	 * 	2.根据学号，到数据库中查找，获得个人信息 select * from PersonInfo where idNumber=?
	 * 	3.根据年级，性别，系别 ；到数据库中查找，获得一系列学号 select idNumber from PersonInfo where grade=? and sex=? and dept=?
	 */

	DaoPattern pattern = new DaoPattern();// 操作数据库信息功能类

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 查询登陆信息
	 * @param values
	 *            给?赋值的字符串数组
	 * @return 返回查询到的信息集合
	 */
	public Vector<String> selLoginInfo(String[] values) {
		// 定义一个结果集对象
		ResultSet rs = null;
		// 定义一个集合，用来盛放查询到的信息
		Vector<String> vector = new Vector<String>();
		try {
			// 定义查询登陆信息sql语句
			String selLgInfoSQL = "select idNumber,psw,iden,name from PersonInfo where idNumber=?";
			// 执行sql语句，返回结果集
			rs = pattern.queryInfo(selLgInfoSQL, values);
			// 处理结果集
			while (rs.next()) {
				// 将每条记录的字段值添加到集合中
				vector.add(rs.getString("idNumber"));
				vector.add(rs.getString("psw"));
				vector.add(rs.getString("iden"));
				vector.add(rs.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			pattern.close();
		}

		return vector;
	}

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 查询个人信息的方法
	 * @param values
	 *            给?赋值的字符串数组
	 * @return 返回查询到的信息集合
	 */
	public Vector<String> selInfo(String[] values) {
		// 定义一个结果集对象
		ResultSet rs = null;
		// 定义一个集合，用来盛放查询到的信息
		Vector<String> vector = new Vector<String>();
		try {
			// 定义查询个人信息sql语句
			String selSQL = "select * from PersonInfo where idNumber=?";
			// 执行sql语句，返回结果集
			rs = pattern.queryInfo(selSQL, values);
			// 处理结果集
			while (rs.next()) {
				// 将每条记录的字段值添加到集合中
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
			// 释放资源
			pattern.close();
		}

		return vector;
	}

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 根据条件查询学号的方法
	 * @param values
	 *            给?赋值的字符串数组
	 * @return 返回查询到的信息集合
	 */
	public Vector<String> selIdNum(String[] values) {
		// 定义一个结果集对象
		ResultSet rs = null;
		// 定义一个集合，用来盛放查询到的信息
		Vector<String> vector = new Vector<String>();
		try {
			// 定义查询学号sql语句(根据年级，性别，系别 ；到数据库中查找)
			String selIdNumSQL = "select idNumber from PersonInfo where grade=? and sex=? and dept=?";
			// 执行sql语句，返回结果集
			rs = pattern.queryInfo(selIdNumSQL, values);
			// 处理结果集
			while (rs.next()) {
				vector.add(rs.getString("idNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			pattern.close();
		}

		return vector;
	}

	
	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 直接查询学号
	 * @param values 给?赋值的字符串数组
	 * @return  返回查询到的信息集合
	 */
	public Vector<String> directSelIdNum(String[] values) {
		// 定义一个结果集对象
		ResultSet rs = null;
		// 定义一个集合，用来盛放查询到的信息
		Vector<String> vector = new Vector<String>();
		try {
			// 定义查询学号sql语句(直接查询学号)
			String selIdNumSQL = "select idNumber from PersonInfo ";
			// 执行sql语句，返回结果集
			rs = pattern.queryInfo(selIdNumSQL, values);
			// 处理结果集
			while (rs.next()) {
				vector.add(rs.getString("idNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			pattern.close();
		}

		return vector;
	}

	
	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 查询数据库中是否存在指定学号
	 * @param values 给?赋值的字符串数组
	 * @return 返回查询到的信息集合
	 */
	public Vector<String> checkIdNum(String[] values) {
		// 定义一个结果集对象
		ResultSet rs = null;
		// 定义一个集合，用来盛放查询到的信息
		Vector<String> vector = new Vector<String>();
		try {
			// 定义查询学号sql语句(直接查询学号)
			String selIdNumSQL = "select idNumber from PersonInfo where idNumber=?";
			// 执行sql语句，返回结果集
			rs = pattern.queryInfo(selIdNumSQL, values);
			// 处理结果集
			while (rs.next()) {
				vector.add(rs.getString("idNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			pattern.close();
		}

		return vector;
	}
}
