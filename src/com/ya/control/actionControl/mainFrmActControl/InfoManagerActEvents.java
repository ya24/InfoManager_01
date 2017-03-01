package com.ya.control.actionControl.mainFrmActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.ya.view.frameView.loginFrameView.LoginView;
import com.ya.view.frameView.mainFrameView.InfoManagerView;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-07-31
 * @desc ��Ϣ����ϵͳ�����涯���¼��࣬������Ϣ����ϵͳ������˵������Ķ����¼�
 * 
 */

public class InfoManagerActEvents implements ActionListener {

	InfoManagerView managerView;// ��Ϣ����ϵͳ�����������

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-07-31
	 * @desc ������Ϣ����ϵͳ��������������
	 * @param managerView
	 */
	public void setManagerView(InfoManagerView managerView) {
		this.managerView = managerView;
	}

	/** ============ActionListener�¼�����========================= */
	public void actionPerformed(ActionEvent e) {
		// ��ȡ�¼�Դ
		JMenuItem source = (JMenuItem) e.getSource();

		/* ===================�޸�����˵���============================= */
		if (managerView.getUpdPswMi().equals(source)) {
			updPswMiHandle();
		}

		/* ====================�˳��˵���========================================= */
		else if (managerView.getExitMi().equals(source)) {
			managerView.dispose(); // �ͷ���Ϣ����ϵͳ������
			new LoginView().setVisible(true); // ��ʾ��¼����
		}

		/* =====================��ҳ��˵���======================================= */
		else if (managerView.getThemeMi().equals(source)) {
			// ������Ϣ����ϵͳ�������С
			managerView.setBounds(350, 100, 620, 520);
			// ��ʾ��ҳ�����
			managerView.getCard().show(managerView.getCardPan(), "n");
		}

		/* ===================��ѯ��Ϣ�˵���====================================== */
		else if (managerView.getSelInfoMi().equals(source)) {
			selInfoMiHandle();
		}

		/* ===================�����Ϣ�˵���====================================== */
		else if (managerView.getInsInfoMi().equals(source)) {
			insInfoMiHandle();

		}

		/* ===================�޸���Ϣ�˵���====================================== */
		else if (managerView.getUpdInfoMi().equals(source)) {
			updInfoMiHandle();

		}

		/* ====================ɾ����Ϣ�˵���===================================== */
		else if (managerView.getDelInfoMi().equals(source)) {
			delInfoMiHandle();

		}

		/* ====================���ڲ˵���===================================== */
		else if (managerView.getAboutMi().equals(source)) {
			// ������Ϣ�Ի���
			JOptionPane.showMessageDialog(managerView,
					"��Ϊצ�۲�����Ϣ����ϵͳ����Ȩ���������С�\n\n���ߣ�Ҷ�ŷ�\n\n����QQ��3066253051\n\n\n\n���ڴ˲�Ʒʹ�����������κ����⣬��ӭ������ѯ��", "����",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	/**
	 * ɾ����Ϣ�˵����������
	 */
	private void delInfoMiHandle() {
		//���ı���
		managerView.setTitle("צ�۲�����Ϣ����ϵͳ����ɾ����Ϣ");
		// ������Ϣ����ϵͳ�������С
		managerView.setBounds(350, 5, 820, 735);
		
		// ��ʾɾ����Ϣ���
		managerView.getCard().show(managerView.getCardPan(), "del");
		// ����ı�
		managerView.infoDelPan.getDelInfoTxt().setText("");
		managerView.infoDelPan.infoPan.getIdNumTxt().setText("");
		managerView.infoDelPan.infoPan.getNameTxt().setText("");
		managerView.infoDelPan.infoPan.getSexCombox().setSelectedIndex(0);
		managerView.infoDelPan.infoPan.getGradeCombox().setSelectedIndex(0);
		managerView.infoDelPan.infoPan.getDeptCombox().setSelectedIndex(0);
		managerView.infoDelPan.infoPan.getMajorCombox().setSelectedIndex(0);
		managerView.infoDelPan.infoPan.getIdenCombox().setSelectedIndex(0);
		managerView.infoDelPan.infoPan.getBornTxt().setText("");
		managerView.infoDelPan.infoPan.getPhoneTxt().setText("");
		managerView.infoDelPan.infoPan.getSignatureArea().setText("");
		managerView.infoDelPan.infoPan.getAddressArea().setText("");
		managerView.infoDelPan.infoPan.getPictureLab().setIcon(null);
	}

	/**
	 * �޸���Ϣ�˵����������
	 */
	private void updInfoMiHandle() {
		//���ı���
		managerView.setTitle("צ�۲�����Ϣ����ϵͳ�����޸���Ϣ");
		// ������Ϣ����ϵͳ�������С
		managerView.setBounds(350, 5, 820, 735);
		// ��ʾ�޸���Ϣ���
		managerView.getCard().show(managerView.getCardPan(), "upd");
		// ����ı�
		managerView.infoUpdPan.getUpdIdTxt().setText("");
		managerView.infoUpdPan.infoPan.getIdNumTxt().setText("");
		managerView.infoUpdPan.infoPan.getNameTxt().setText("");
		managerView.infoUpdPan.infoPan.getSexCombox().setSelectedIndex(0);
		managerView.infoUpdPan.infoPan.getGradeCombox().setSelectedIndex(0);
		managerView.infoUpdPan.infoPan.getDeptCombox().setSelectedIndex(0);
		managerView.infoUpdPan.infoPan.getMajorCombox().setSelectedIndex(0);
		managerView.infoUpdPan.infoPan.getIdenCombox().setSelectedIndex(0);
		managerView.infoUpdPan.infoPan.getBornTxt().setText("");
		managerView.infoUpdPan.infoPan.getPhoneTxt().setText("");
		managerView.infoUpdPan.infoPan.getSignatureArea().setText("");
		managerView.infoUpdPan.infoPan.getAddressArea().setText("");
		managerView.infoUpdPan.infoPan.getPictureLab().setIcon(null);
	}

	/**
	 * �����Ϣ�˵����������
	 */
	private void insInfoMiHandle() {
		//���ı���
		managerView.setTitle("צ�۲�����Ϣ����ϵͳ���������Ϣ");
		// ������Ϣ����ϵͳ�������С
		managerView.setBounds(350, 10, 800, 700);
		// ��ʾ�����Ϣ���
		managerView.getCard().show(managerView.getCardPan(), "ins");
		// ����ı�
		managerView.infoInsPan.infoPan.getIdNumTxt().setText("");
		managerView.infoInsPan.infoPan.getNameTxt().setText("");
		managerView.infoInsPan.infoPan.getSexCombox().setSelectedIndex(0);
		managerView.infoInsPan.infoPan.getGradeCombox().setSelectedIndex(0);
		managerView.infoInsPan.infoPan.getDeptCombox().setSelectedIndex(0);
		managerView.infoInsPan.infoPan.getMajorCombox().setSelectedIndex(0);
		managerView.infoInsPan.infoPan.getIdenCombox().setSelectedIndex(0);
		managerView.infoInsPan.infoPan.getBornTxt().setText("");
		managerView.infoInsPan.infoPan.getPhoneTxt().setText("");
		managerView.infoInsPan.infoPan.getSignatureArea().setText("");
		managerView.infoInsPan.infoPan.getAddressArea().setText("");
		managerView.infoInsPan.infoPan.getPsw().setText("");
		managerView.infoInsPan.infoPan.getPictureLab().setIcon(null);

	}

	/**
	 * ��ѯ��Ϣ�˵����������
	 */
	private void selInfoMiHandle() {
		//���ı���
		managerView.setTitle("צ�۲�����Ϣ����ϵͳ������ѯ��Ϣ");
		// ������Ϣ����ϵͳ�������С
		managerView.setBounds(350, 30, 870, 650);
		// ��ʾ��ѯ��Ϣ���
		managerView.getCard().show(managerView.getCardPan(), "sel");
		// �ı��������
		managerView.infoSelPan.getGradeCombox().setSelectedIndex(0);
		managerView.infoSelPan.getDeptCombox().setSelectedIndex(0);
		managerView.infoSelPan.getSexCombox().setSelectedIndex(0);
		managerView.infoSelPan.getIdNumTxt2().setText("");
		managerView.infoSelPan.getNameTxt().setText("");
		managerView.infoSelPan.getIdNumTxt().setText("");
		managerView.infoSelPan.getSexTxt().setText("");
		managerView.infoSelPan.getGradeTxt().setText("");
		managerView.infoSelPan.getDeptTxt().setText("");
		managerView.infoSelPan.getMajorTxt().setText("");
		managerView.infoSelPan.getPhoneTxt().setText("");
		managerView.infoSelPan.getBornTxt().setText("");
		managerView.infoSelPan.getSignatureArea().setText("");
		managerView.infoSelPan.getAddressArea().setText("");
		managerView.infoSelPan.getPictureLab().setIcon(null);
		managerView.infoSelPan.getResultLab().setText("�ҵ���0����¼");
		managerView.infoSelPan.getNumList().setListData(new Object[]{});

	}

	/**
	 * �޸�����˵����������
	 */
	private void updPswMiHandle() {
		//���ı���
		managerView.setTitle("צ�۲�����Ϣ����ϵͳ�����޸�����");
		// ������Ϣ����ϵͳ�������С
		managerView.setBounds(350, 100, 620, 520);
		// ��ʾ�޸��������
		managerView.getCard().show(managerView.getCardPan(), "psw");
		// �ı�����Ҫ���
		managerView.updPswPan.getIdNumTxt().setText("");
		managerView.updPswPan.getPsw().setText("");
		managerView.updPswPan.getOkPsw().setText("");

	}

}
