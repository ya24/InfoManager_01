package com.ya.model.daoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ya.model.shareModel.DBUtil;

/**
 * 
 * @author 叶雅芳
 * @date 2015-08-01
 * @desc 操作数据库信息 功能类（底层模型类）
 * 
 */

public class DaoPattern {

	
	/** =========== 声明数据库所用的对象 ================ */
	Connection conn = null; // 数据库连接对象
	PreparedStatement ps = null; // PreparedStatement对象
	ResultSet rs = null; // 结果集
	int count = 0; // 数据库中受影响的记录数量

	
	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 定义一个方法，关闭资源对象
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
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 定义一个方法，sql语句提交前的准备工作
	 * @param sql
	 *            需要执行的sql语句
	 * @param values
	 *            给？赋值的字符串数组
	 */
	public void before(String sql, String[] values) {

		try {
			// 建立与数据库的连接
			conn = DBUtil.getConnection();
			// 创建preparedStatement对象
			ps = conn.prepareStatement(sql);
			// 给？赋值
			for (int x = 0; x < values.length; x++) {
				ps.setString(x + 1, values[x]);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 更新数据库方法
	 * @param updSQL
	 *            需要执行的更新数据库操作语言
	 * @param values
	 *            给？赋值的字符串数组
	 * @return 返回数据库是否受影响
	 */
	public boolean updateInfo(String updSQL, String[] values) {
		boolean result = false;	//标记数据库是否受影响

		try {
			// 提交sql语句前期准备
			this.before(updSQL, values);
			// 执行sql语句，返回数据库受影响的行数
			count = ps.executeUpdate();
			// 处理结果集
			if (count == 1) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			this.close();
		}

		return result;
	}

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 查询数据库方法
	 * @param selectSQL
	 *            需要执行的查询数据库操作语言
	 * @param values
	 *            给？赋值的字符串数组
	 * @return 返回结果集
	 */
	public ResultSet queryInfo(String selectSQL, String[] values) {

		try {
			// 提交sql语句前期准备
			this.before(selectSQL, values);
			// 执行sql语句，返回结果集
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

}
