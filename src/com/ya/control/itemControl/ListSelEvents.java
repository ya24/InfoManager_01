package com.ya.control.itemControl;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.ya.model.daoModel.InfoSelect;
import com.ya.view.panelView.infoHandlePanelView.InfoSelectPanel;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-08-01
 * @desc �б��ѡ���¼���
 * 
 */

public class ListSelEvents implements ListSelectionListener {

	InfoSelectPanel infoSelPan; // �б��ѡ���¼���
	InfoSelect infoSel = new InfoSelect(); // ��ѯ���ݿ���Ϣ��

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc �����б��ѡ���¼������
	 * @param infoSelectPanel
	 */
	public void setInfoSelPan(InfoSelectPanel infoSelPan) {
		this.infoSelPan = infoSelPan;
	}

	/** ==============ListSelectionListener�¼�����================= */
	public void valueChanged(ListSelectionEvent e) {
		// ��ȡ�¼�Դ
		JList source = (JList) e.getSource();

		// ��ȡѡ��ѡ�������
		String idNum = (String) source.getSelectedValue();

		// �����ѡ��
		if (idNum != null) {

			// ����ѧ�ŵ����ݿ��в�ѯ��Ϣ����ý����
			Vector<String> vector = infoSel.selInfo(new String[] { idNum });
			if (vector.size() == 0) {
				// ����������СΪ0������û�в�ѯ����Ϣ����ʾ�û�
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

				// ����ͼ����󣨸���ͼƬ·����
				ImageIcon ic = new ImageIcon(vector.get(12));
				// ���ش�ͼ���Image��������Image�����Ű汾�����ذ����ź��ͼƬ����Ϊ��ͼ����ʾ��ͼƬ
				ic.setImage(ic.getImage().getScaledInstance(280, 267, 0));
				// ��ʾͼƬ
				infoSelPan.getPictureLab().setIcon(ic);

			}

		}
	}

}
