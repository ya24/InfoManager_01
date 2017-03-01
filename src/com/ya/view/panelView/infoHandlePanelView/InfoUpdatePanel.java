package com.ya.view.panelView.infoHandlePanelView;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.ya.control.actionControl.infoHandleActControl.InfoUpdActEvents;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-07-30
 * @desc �޸���Ϣ��������
 * 
 */

public class InfoUpdatePanel extends JPanel {

	public InfoPanel infoPan = new InfoPanel(); // ��Ϣ��������
	InfoUpdActEvents updActEvnt = new InfoUpdActEvents(); // �޸���Ϣ��嶯���¼���

	private JTextField updIdTxt; // �޸���Ϣ�ı���

	// ������¼��ɾ�������ð�ť
	private JButton seekBt, UpdBt, clearBt;

	/**
	 * Create the panel.
	 * 
	 */
	public InfoUpdatePanel() {
		// ���޸���Ϣ��嶯���¼��ഫ���޸���Ϣ�����������
		updActEvnt.setInfoUpdPan(this);

		// ��Ϣ���λ�����
		infoPan.setLocation(20, 70);

		// �޸���Ϣ�����������
		setLayout(null);
		setBounds(10, 10, 806, 671);

		// ��ʾ�޸����
		JPanel tipPan = new JPanel();
		tipPan.setBorder(new TitledBorder(null, "\u4FEE\u6539",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tipPan.setBounds(10, 10, 741, 60);
		add(tipPan);
		tipPan.setLayout(null);

		// �޸���Ϣ�ı���
		updIdTxt = new JTextField();
		updIdTxt.setBounds(180, 23, 160, 25);
		tipPan.add(updIdTxt);
		updIdTxt.setFont(new Font("����", Font.PLAIN, 14));
		updIdTxt.setColumns(15);

		// ��ʾ�޸���Ϣ��ǩ
		JLabel updInfoLab = new JLabel(
				"\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u4FE1\u606F\u7684\u5B66\u53F7");
		updInfoLab.setBounds(10, 23, 160, 25);
		tipPan.add(updInfoLab);
		updInfoLab.setFont(new Font("����", Font.PLAIN, 14));

		// ������ť
		seekBt = new JButton("\u641C\u7D22");
		seekBt.setBounds(360, 23, 70, 25);
		tipPan.add(seekBt);
		seekBt.setFont(new Font("����", Font.PLAIN, 14));
		seekBt.addActionListener(updActEvnt);

		// �����Ϣ���
		add(infoPan);
		// ����Ϣ��������������
		infoPan.getPswLab().setVisible(false);
		infoPan.getPsw().setVisible(false);
		// ��ѧ���ı�������Ϊ���ɱ༭
		infoPan.getIdNumTxt().setEnabled(false);
		infoPan.getPictureBt().addActionListener(updActEvnt);

		// ¼���޸İ�ť
		UpdBt = new JButton("\u5F55\u5165\u4FEE\u6539");
		UpdBt.setFont(new Font("����", Font.PLAIN, 14));
		UpdBt.setBounds(268, 630, 93, 25);
		add(UpdBt);
		UpdBt.addActionListener(updActEvnt);

		// ���ð�ť
		clearBt = new JButton("\u91CD\u7F6E");
		clearBt.setFont(new Font("����", Font.PLAIN, 14));
		clearBt.setBounds(393, 630, 93, 25);
		add(clearBt);
		clearBt.addActionListener(updActEvnt);

	}

	

	/** ==========get����========================== */
	public JTextField getUpdIdTxt() {
		return updIdTxt;
	}

	public JButton getSeekBt() {
		return seekBt;
	}

	public JButton getUpdBt() {
		return UpdBt;
	}

	public JButton getClearBt() {
		return clearBt;
	}
}
