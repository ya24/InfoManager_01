package com.ya.model.daoModel;


/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-08-01
 * @desc �޸����ݿ���Ϣ��
 * 
 */

public class InfoUpdate {

	DaoPattern pattern = new DaoPattern();// �������ݿ���Ϣ������

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc �����Ϣ������Ҫ������ֵ���ַ����� ���ò������ݿ���Ϣ������ķ���������sql�����飬��������ӵ����ݿ���
	 * @param values
	 *            ������ֵ���ַ�������
	 * @return ���ݿ��еļ�¼�Ƿ���Ӱ��
	 */
	public boolean insInfo(String[] values) {

		// �������sql���
		String insSQL = "insert into PersonInfo(psw, idNumber, name, sex, grade, dept, major, iden, born, phone,pSignature, pAddress,picture) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		return pattern.updateInfo(insSQL, values);
	}

	
	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc �޸���Ϣ������Ҫ������ֵ���ַ����� ���ò������ݿ���Ϣ������ķ���������sql�����飬�����ݿ����޸�����
	 * @param values
	 *            ������ֵ���ַ�������
	 * @return ���ݿ��еļ�¼�Ƿ���Ӱ��
	 */
	public boolean updInfo(String[] values) {

		// �����޸�sql���
		String updateSQL = "update PersonInfo set idNumber=?, name=?, sex=?, grade=?, dept=?, major=?, iden=?, born=?, "
				+ "phone=?,pSignature=?, pAddress=? ,picture=? where idNumber=?";

		return pattern.updateInfo(updateSQL, values);
	}

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ɾ����Ϣ������Ҫ������ֵ���ַ����� ���ò������ݿ���Ϣ������ķ���������sql�����飬�����ݿ���ɾ������
	 * @param values
	 *            ������ֵ���ַ�������
	 * @return ���ݿ��еļ�¼�Ƿ���Ӱ��
	 */
	public boolean delInfo(String[] values) {

		// ����ɾ��sql���
		String deleteSQL = "delete from PersonInfo where idNumber=?";

		return pattern.updateInfo(deleteSQL, values);
	}

	
	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc �޸����룬����Ҫ������ֵ���ַ����� ���ò������ݿ���Ϣ������ķ���������sql�����飬�����ݿ����޸�����
	 * @param values
	 *            ������ֵ���ַ���
	 * @return ���ݿ��еļ�¼�Ƿ���Ӱ��
	 */
	public boolean updPsw(String[] values) {
		// �����޸�sql���
		String updPswSQL = "update PersonInfo set psw=? where idNumber=?";
		
		return pattern.updateInfo(updPswSQL, values);
	}



}
