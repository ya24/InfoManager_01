package com.ya.model.daoModel;


/**
 * 
 * @author 叶雅芳
 * @date 2015-08-01
 * @desc 修改数据库信息类
 * 
 */

public class InfoUpdate {

	DaoPattern pattern = new DaoPattern();// 操作数据库信息功能类

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 添加信息，传进要给？赋值的字符串； 调用操作数据库信息功能类的方法，传入sql和数组，将数据添加到数据库中
	 * @param values
	 *            给？赋值的字符串数组
	 * @return 数据库中的记录是否受影响
	 */
	public boolean insInfo(String[] values) {

		// 定义添加sql语句
		String insSQL = "insert into PersonInfo(psw, idNumber, name, sex, grade, dept, major, iden, born, phone,pSignature, pAddress,picture) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		return pattern.updateInfo(insSQL, values);
	}

	
	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 修改信息，传进要给？赋值的字符串； 调用操作数据库信息功能类的方法，传入sql和数组，到数据库中修改数据
	 * @param values
	 *            给？赋值的字符串数组
	 * @return 数据库中的记录是否受影响
	 */
	public boolean updInfo(String[] values) {

		// 定义修改sql语句
		String updateSQL = "update PersonInfo set idNumber=?, name=?, sex=?, grade=?, dept=?, major=?, iden=?, born=?, "
				+ "phone=?,pSignature=?, pAddress=? ,picture=? where idNumber=?";

		return pattern.updateInfo(updateSQL, values);
	}

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 删除信息，传进要给？赋值的字符串； 调用操作数据库信息功能类的方法，传入sql和数组，到数据库中删除数据
	 * @param values
	 *            给？赋值的字符串数组
	 * @return 数据库中的记录是否受影响
	 */
	public boolean delInfo(String[] values) {

		// 定义删除sql语句
		String deleteSQL = "delete from PersonInfo where idNumber=?";

		return pattern.updateInfo(deleteSQL, values);
	}

	
	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 修改密码，传进要给？赋值的字符串； 调用操作数据库信息功能类的方法，传入sql和数组，到数据库中修改密码
	 * @param values
	 *            给？赋值的字符串
	 * @return 数据库中的记录是否受影响
	 */
	public boolean updPsw(String[] values) {
		// 定义修改sql语句
		String updPswSQL = "update PersonInfo set psw=? where idNumber=?";
		
		return pattern.updateInfo(updPswSQL, values);
	}



}
