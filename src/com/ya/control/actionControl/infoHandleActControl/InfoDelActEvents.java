package com.ya.control.actionControl.infoHandleActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ya.model.daoModel.InfoSelect;
import com.ya.model.daoModel.InfoUpdate;
import com.ya.view.panelView.infoHandlePanelView.InfoDelPanel;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-08-01
 * @desc ɾ����Ϣ��嶯���¼���
 * 
 */
public class InfoDelActEvents implements ActionListener {

	InfoDelPanel infoDelPan;// ɾ����Ϣ��������

	InfoSelect infoSel = new InfoSelect(); // ��ѯ���ݿ���Ϣ��
	InfoUpdate infoUpd = new InfoUpdate(); // �޸����ݿ���Ϣ��

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ɾ����Ϣ��������
	 * @param infoDelPan
	 */
	public void setInfoDelPan(InfoDelPanel infoDelPan) {
		this.infoDelPan = infoDelPan;
	}

	/** =============ActionListener�¼�����========================== */
	public void actionPerformed(ActionEvent e) {
		// ��ȡ�¼�Դ
		JButton source = (JButton) e.getSource();

		/* ===============ȷ����ť============================= */
		if (source.equals(infoDelPan.getSeekBt())) {
			okBtHandle();

		}

		/* ================ɾ����ť============================ */
		else if (source.equals(infoDelPan.getDelBt())) {
			delBtHandle();
		}

		/* ================���ð�ť================================ */
		else if (source.equals(infoDelPan.getClearBt())) {
			clearBtHandle();

		}
	}

	/**
	 * ���ð�ť����
	 */
	private void clearBtHandle() {
		infoDelPan.getDelInfoTxt().setText("");
		infoDelPan.infoPan.getIdNumTxt().setText("");
		infoDelPan.infoPan.getNameTxt().setText("");
		infoDelPan.infoPan.getSexCombox().setSelectedIndex(0);
		infoDelPan.infoPan.getGradeCombox().setSelectedIndex(0);
		infoDelPan.infoPan.getDeptCombox().setSelectedIndex(0);
		infoDelPan.infoPan.getMajorCombox().setSelectedIndex(0);
		infoDelPan.infoPan.getIdenCombox().setSelectedIndex(0);
		infoDelPan.infoPan.getBornTxt().setText("");
		infoDelPan.infoPan.getPhoneTxt().setText("");
		infoDelPan.infoPan.getSignatureArea().setText("");
		infoDelPan.infoPan.getAddressArea().setText("");
		infoDelPan.infoPan.getPictureLab().setIcon(null);
	}

	/**
	 * ɾ����ť��������
	 */
	private void delBtHandle() {
		// �����Ի���ѯ���û��Ƿ�ɾ��
		int type = JOptionPane.showConfirmDialog(infoDelPan, "ȷ��Ҫɾ���ó�Ա�Ļ�����Ϣ��",
				"ɾ��", JOptionPane.YES_NO_OPTION);

		if (type == JOptionPane.YES_OPTION) {
			// �������ǣ���ɾ����Ϣ
			// ��ȡѧ�ţ������ݿ���ɾ��,�����жϣ����Ƿ�ɾ���ɹ�
			if (infoUpd.delInfo(new String[] { infoDelPan.infoPan.getIdNumTxt()
					.getText() })) {
				JOptionPane.showMessageDialog(infoDelPan, "��Ϣɾ���ɹ���");
				//�ı����
				clearBtHandle();
			} else {
				JOptionPane.showMessageDialog(infoDelPan, "��Ϣɾ��ʧ�ܣ������²�����");
			}
		}
	}

	/**
	 * ȷ����ť��������
	 */
	private void okBtHandle() {
		// ���ж�ѧ���Ƿ�Ϊ��
		if ("".equals(infoDelPan.getDelInfoTxt().getText())) {
			// ѧ��Ϊ��
			JOptionPane.showMessageDialog(infoDelPan, "������Ҫɾ����ѧ�ţ�����");
		} else {
			// ��Ϊ�գ�����ѧ�ŵ����ݿ��в�ѯ��Ϣ����ý����
			Vector<String> vector = infoSel.selInfo(new String[] { infoDelPan
					.getDelInfoTxt().getText() });

			if (vector.size() == 0) {
				// ����������СΪ0����û�в�ѯ����Ϣ����ʾ�û�
				JOptionPane.showMessageDialog(infoDelPan, "��ѧ�Ų�����!��ȷ�Ϻ�������!");
			} else {
				// �������Ϊ0������Ϣ��ʾ����Ӧλ��
				infoDelPan.infoPan.getIdNumTxt().setText( vector.get(1));
				infoDelPan.infoPan.getNameTxt().setText(vector.get(2));
				infoDelPan.infoPan.getSexCombox().setSelectedItem(vector.get(3));
				infoDelPan.infoPan.getGradeCombox().setSelectedItem(vector.get(4));
				infoDelPan.infoPan.getDeptCombox().setSelectedItem(vector.get(5));
				infoDelPan.infoPan.getMajorCombox().setSelectedItem(vector.get(6));
				infoDelPan.infoPan.getIdenCombox().setSelectedItem(vector.get(7));
				infoDelPan.infoPan.getBornTxt().setText( vector.get(8).substring(0, 10));
				infoDelPan.infoPan.getPhoneTxt().setText( vector.get(9));
				infoDelPan.infoPan.getSignatureArea().setText(vector.get(10));
				infoDelPan.infoPan.getAddressArea().setText(vector.get(11));

				//����ͼƬ��С������·����
				ImageIcon ic=new ImageIcon(vector.get(12));
				// ���ش�ͼ���Image��������Image�����Ű汾�����ذ����ź��ͼƬ����Ϊ��ͼ����ʾ��ͼƬ
				ic.setImage(ic.getImage().getScaledInstance(330, 265, 0));
				// ��ʾͼƬ
				infoDelPan.infoPan.getPictureLab().setIcon(ic);
	
			}
		}
	}
}
