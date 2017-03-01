package com.ya.control.actionControl.loginActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ya.model.daoModel.InfoSelect;
import com.ya.view.frameView.loginFrameView.LoginView;
import com.ya.view.frameView.mainFrameView.InfoManagerView;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-07-31
 * @desc ��¼���涯���¼���
 * 
 */

public class LoginActEvents implements ActionListener {

	LoginView lgView; // ��¼���������
	InfoSelect infoSel = new InfoSelect(); // ��ѯ���ݿ���Ϣ��
	String user="";	//ʹ����

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-07-31
	 * @desc �����¼������������
	 * @param loginView
	 */
	public void setLgView(LoginView lgView) {
		this.lgView = lgView;
	}

	/** ============ActionListener�¼�����=================== */
	public void actionPerformed(ActionEvent e) {
		// ��ȡ�¼�Դ
		JButton source = (JButton) e.getSource();

		/* ==============��¼�����¼��ť========================== */
		if (lgView.getLoginBt().equals(source)) {

			login();

		}
		/* ==============��¼�������ð�ť========================== */
		else if (lgView.getClearBt().equals(source)) {
			// ���ı������
			lgView.getIdTxt().setText("");
			lgView.getPsw().setText("");
			// ��Ͽ�ԭΪĬ��ѡ��
			lgView.getIdComBox().setSelectedIndex(0);
		}
	}

	
	
	/**
	 *  ��¼��������
	 */
	private void login() {
		// ��ȡѧ��
		String id = lgView.getIdTxt().getText();
		// ��ȡ����
		String psw = new String(lgView.getPsw().getPassword());
		//��ȡ���
		String iden=lgView.getLgIdentity();

		// ��ѧ�Ų���Ϊ�գ������ж�
		if ("".equals(id)) {
			JOptionPane.showMessageDialog(lgView, "ѧ�Ų���Ϊ��");
		}else if(id.length()!=9){
			JOptionPane.showMessageDialog(lgView, "����ȷ����ѧ��");
		}
		// ѧ�Ų�Ϊ��
		else if(!"".equals(id)){
			// ����ѧ�Ų�ѯ��Ϣ������һ�������
			String[] values={id};
			Vector<String> vector = infoSel.selLoginInfo(values);
			user=vector.get(3);
			if (vector.size() == 0) {
				//��������Ϊ�գ����ʾ��Ϣ������
				JOptionPane.showMessageDialog(lgView, "��Ϣ������");
			} else {
				// �������Ϊ�գ��ж�ѧ�š����롢����Ƿ������ݿ��е�����ƥ��
				if (id.equals(vector.get(0)) && psw.equals(vector.get(1))
						&& iden.equals(vector.get(2))) {
					// ƥ�䣬��ʾ��Ϣ����ϵͳ�����棬�ͷŵ�½����
					lgView.dispose();
					InfoManagerView managerView = new InfoManagerView();
					managerView.setVisible(true);
					managerView.getMessageLab().setText(user+"!��ӭ����");
					//�����¼���ǹ���Ա���޸����룬��ɾ�ĵȲ˵��ɱ༭
					if("����Ա".equals(iden)){
						managerView.getUpdPswMi().setEnabled(true);
						managerView.getInsInfoMi().setEnabled(true);
						managerView.getDelInfoMi().setEnabled(true);
						managerView.getUpdInfoMi().setEnabled(true);
					}
				} else {
					// ��ƥ�䣬��ʾ�û���������ı�����Ͽ�ԭΪĬ��ѡ��
					JOptionPane.showMessageDialog(lgView, "������Ϣ��������������");
					lgView.getIdTxt().setText("");
					lgView.getPsw().setText("");
					lgView.getIdComBox().setSelectedIndex(0);
				}
			}
		}
	}

}
