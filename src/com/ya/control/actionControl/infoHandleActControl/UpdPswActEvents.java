package com.ya.control.actionControl.infoHandleActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ya.model.daoModel.InfoSelect;
import com.ya.model.daoModel.InfoUpdate;
import com.ya.view.panelView.infoHandlePanelView.UpdatePasswordPanel;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-08-01
 * @desc �޸�������嶯���¼���
 * 
 */
public class UpdPswActEvents implements ActionListener {

	UpdatePasswordPanel updPswPan; // �޸�������������
	InfoUpdate infoUpd = new InfoUpdate(); // �޸����ݿ���Ϣ��
	InfoSelect infoSel = new InfoSelect(); // ��ѯ���ݿ���Ϣ��

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc �޸�������������
	 * @param updPswPan
	 */
	public void setUpdPswPan(UpdatePasswordPanel updPswPan) {
		this.updPswPan = updPswPan;
	}

	/* ============�¼�����==================== */
	public void actionPerformed(ActionEvent e) {
		// ��ȡ�¼�Դ
		JButton source = (JButton) e.getSource();

		/* ==========�޸İ�ť=================== */
		if (source.equals(updPswPan.getUpdBt())) {
			updBtHandle();

		}

		/* ===========���ð�ť========================= */
		else if (source.equals(updPswPan.getClearBt())) {
			// �ı��������
			updPswPan.getIdNumTxt().setText("");
			updPswPan.getPsw().setText("");
			updPswPan.getOkPsw().setText("");
		}
	}

	/**
	 * �޸İ�ť��������
	 */
	private void updBtHandle() {
		// ��ȡѧ��
		String id = updPswPan.getIdNumTxt().getText();
		// �����ݿ��в�ѯ��ѧ���Ƿ����
		if (infoSel.checkIdNum(new String[] { id }).size() == 0) {
			// ѧ�Ų�����
			JOptionPane.showMessageDialog(updPswPan, "��ѧ�Ų����ڣ�");
		} else {
			// ���ѧ�Ŵ��ڣ���ȡ����
			String psw = new String(updPswPan.getPsw().getPassword());
			String okPsw = new String(updPswPan.getOkPsw().getPassword());
			// �������ƥ��
			if (psw.equals(okPsw)) {
				// ����ѧ�ŵ����ݿ����޸����룬�����ؽ������֪�û��Ƿ��޸ĳɹ���(���޸�ʧ�ܣ�����������)
				String[] values = { psw, updPswPan.getIdNumTxt().getText(), };
				if (infoUpd.updPsw(values)) {
					JOptionPane.showMessageDialog(updPswPan, "�����޸ĳɹ���");
				} else {
					JOptionPane.showMessageDialog(updPswPan,
							"�����޸�ʧ�ܣ���ȷ���������Ϣ�Ƿ���ȷ��");
				}
			} else {
				// ���벻ƥ��
				JOptionPane.showMessageDialog(updPswPan, "��׼ȷ������Ҫ�޸ĵ����룡");
			}
		}
	}

}
