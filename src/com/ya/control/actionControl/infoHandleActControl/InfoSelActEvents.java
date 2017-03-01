package com.ya.control.actionControl.infoHandleActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ya.model.daoModel.InfoSelect;
import com.ya.view.panelView.infoHandlePanelView.InfoSelectPanel;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-08-01
 * @desc ��ѯ��Ϣ��嶯���¼���
 * 
 */
public class InfoSelActEvents implements ActionListener {

	InfoSelectPanel infoSelPan; // ��Ϣ��ѯ��������
	InfoSelect infoSel = new InfoSelect(); // ��ѯ���ݿ���Ϣ��

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ��Ϣ��ѯ�����������
	 * @param infoSelPan
	 */
	public void setInfoSelPan(InfoSelectPanel infoSelPan) {
		this.infoSelPan = infoSelPan;
	}

	
	/** ============ActionListener�¼�����=================================== */
	public void actionPerformed(ActionEvent e) {

		// ��ȡ�¼�Դ
		JButton source = (JButton) e.getSource();

		/* ===============�����Ұ�ť========================== */
		if (infoSelPan.getBigSelectBt().equals(source)) {
			bigSelectBtHandle();

		}

		/* ===============����ѧ�Ų��Ұ�ť============================ */
		else if (infoSelPan.getMinSelectBt().equals(source)) {
			minSelectBtHandle();

		}
	}

	/**
	 * ����ѧ�Ų��Ұ�ť��������
	 */
	private void minSelectBtHandle() {
		// ��ȡѧ������
		String idNum = infoSelPan.getIdNumTxt2().getText();
		// ���ѧ������Ϊ��
		if (idNum.equals("")) {
			JOptionPane.showMessageDialog(infoSelPan, "ѧ�Ų���Ϊ��!");
		} else {
			// ����ѧ�ţ������ݿ��ѯ��Ϣ�����ؽ��������ʾ����Ӧλ��
			Vector<String> vector = infoSel.selInfo(new String[] { idNum });
			// ��ʾ��ѯ�����Ϣ
			if (vector.size() == 0) {
				// ����������СΪ0����û�в�ѯ����Ϣ����ʾ�û�
				JOptionPane.showMessageDialog(infoSelPan, "��ѧ�Ų�����!��ȷ�Ϻ���������!");
			} else {
				// �������Ϊ0������Ϣ��ʾ����Ӧλ��
				infoSelPan.getNameTxt().setText(vector.get(2));
				infoSelPan.getIdNumTxt().setText(vector.get(1));
				infoSelPan.getSexTxt().setText(vector.get(3));
				infoSelPan.getGradeTxt().setText(vector.get(4));
				infoSelPan.getDeptTxt().setText(vector.get(5));
				infoSelPan.getMajorTxt().setText(vector.get(6));
				infoSelPan.getPhoneTxt().setText(vector.get(9));
				infoSelPan.getBornTxt().setText(vector.get(8).substring(0, 10));
				infoSelPan.getSignatureArea().setText(vector.get(10));
				infoSelPan.getAddressArea().setText(vector.get(11));

				// ����ͼƬ���󣨸���ͼƬ·����
				ImageIcon ic = new ImageIcon(vector.get(12));
				// ���ش�ͼ���Image��������Image�����Ű汾�����ذ����ź��ͼƬ����Ϊ��ͼ����ʾ��ͼƬ
				ic.setImage(ic.getImage().getScaledInstance(280, 267, 0));
				// ��ʾͼƬ
				infoSelPan.getPictureLab().setIcon(ic);

			}
		}
	}

	/**
	 * �����Ұ�ť��������
	 */
	private void bigSelectBtHandle() {
		// �꼶��Ͽ�ѡ��ѡ�������
		String selGrade = infoSelPan.getSelGrade();

		// ϵ����Ͽ�ѡ��ѡ�������
		String selDept = infoSelPan.getSelDept();

		// �Ա���Ͽ�ѡ��ѡ�������
		String selSex = infoSelPan.getSelSex();

		// ��װ��ѯ����
		String[] values = { selGrade, selSex, selDept };

		// ���������ַ��������ݿ��в��ң�����ѧ�ż���(Vector)���ŵ��б����
		Vector<String> vector = infoSel.selIdNum(values); // ����
		if (vector.size() == 0) {
			JOptionPane.showMessageDialog(infoSelPan, "�Ҳ�����Ϣ");
		} else {
			infoSelPan.getNumList().setListData(vector);
			infoSelPan.getResultLab().setText("�ҵ���" + vector.size() + "����¼");
		}
	}

}
