package com.ya.view.panelView.infoHandlePanelView;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import com.ya.control.actionControl.infoHandleActControl.UpdPswActEvents;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-07-30
 * @desc �޸�������������
 * 
 */

public class UpdatePasswordPanel extends JPanel {

	// �޸�������嶯���¼���
	UpdPswActEvents updPswActEvnt = new UpdPswActEvents();

	// ѧ���ı���
	private JTextField idNumTxt;

	// �޸ġ�ȡ����ť
	private JButton updBt, clearBt;

	// ���룬ȷ������
	private JPasswordField psw, okPsw;

	/**
	 * Create the panel.
	 */
	public UpdatePasswordPanel() {

		// ���޸�������嶯���¼��ഫ���޸����������������
		updPswActEvnt.setUpdPswPan(this);

		// �޸����������������
		setLayout(null);
		setBounds(10, 10, 600, 470);

		// ѧ�ű�ǩ
		JLabel idNumLab = new JLabel("\u5B66      \u53F7");
		idNumLab.setFont(new Font("����", Font.PLAIN, 14));
		idNumLab.setBounds(100, 60, 80, 25);
		add(idNumLab);

		// �����ǩ
		JLabel pswLab = new JLabel("\u65B0  \u5BC6   \u7801");
		pswLab.setFont(new Font("����", Font.PLAIN, 14));
		pswLab.setBounds(100, 140, 80, 25);
		add(pswLab);

		// ȷ�������ǩ
		JLabel okPswLab = new JLabel("\u786E \u8BA4 \u5BC6 \u7801");
		okPswLab.setFont(new Font("����", Font.PLAIN, 14));
		okPswLab.setBounds(100, 216, 80, 25);
		add(okPswLab);

		// ѧ���ı���
		idNumTxt = new JTextField();
		idNumTxt.setFont(new Font("����", Font.PLAIN, 14));
		idNumTxt.setBounds(200, 60, 200, 25);
		add(idNumTxt);
		idNumTxt.setColumns(15);

		// �޸İ�ť
		updBt = new JButton("\u4FEE\u6539");
		updBt.setFont(new Font("����", Font.PLAIN, 14));
		updBt.setBounds(125, 340, 93, 25);
		add(updBt);
		updBt.addActionListener(updPswActEvnt);

		// ȡ����ť
		clearBt = new JButton("\u91CD\u7F6E");
		clearBt.setFont(new Font("����", Font.PLAIN, 14));
		clearBt.setBounds(284, 341, 93, 25);
		add(clearBt);
		clearBt.addActionListener(updPswActEvnt);

		// ����
		psw = new JPasswordField();
		psw.setColumns(15);
		psw.setFont(new Font("����", Font.PLAIN, 14));
		psw.setBounds(200, 140, 200, 25);
		add(psw);

		// ȷ������
		okPsw = new JPasswordField();
		okPsw.setColumns(15);
		okPsw.setFont(new Font("����", Font.PLAIN, 14));
		okPsw.setBounds(200, 216, 200, 25);
		add(okPsw);

	}

	

	/** =========get����========================== */
	public JTextField getIdNumTxt() {
		return idNumTxt;
	}

	public JButton getUpdBt() {
		return updBt;
	}

	public JButton getClearBt() {
		return clearBt;
	}

	public JPasswordField getPsw() {
		return psw;
	}

	public JPasswordField getOkPsw() {
		return okPsw;
	}
}
