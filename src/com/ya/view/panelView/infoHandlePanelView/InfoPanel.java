package com.ya.view.panelView.infoHandlePanelView;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-07-30
 * @desc ��Ϣ�������࣬ʵ��ItemListener��������Ͽ򣬻�ȡ��Ͽ���ѡ��ѡ����ı�����
 * 
 */

public class InfoPanel extends JPanel implements ItemListener {

	// ѧ���ı���,�����ı���,���������ı���,��ϵ��ʽ�ı���
	private JTextField idNumTxt, nameTxt, bornTxt, phoneTxt;

	// �����
	private JPasswordField psw;

	// �����ǩ
	private JLabel pswLab;

	// �Ա���Ͽ�;�꼶��Ͽ�,ϵ����Ͽ�רҵ��Ͽ������Ͽ�
	private JComboBox sexCombox, gradeCombox, deptCombox, majorCombox,idenCombox;

	// ����ǩ���ı�������ַ�ı���
	private JTextArea signatureArea, addressArea;

	// ��Ϣ�����Ͽ���ѡ��ѡ�������
	private String infoSex = "��", infoGrade = "��һ", infoDept = "��������������Ϣ����ϵ",
			infoMajor = "�������ѧ�뼼��", infoIden = "�����Ա";

	// ��Ƭ���
	private JPanel picturePan;
	// ��Ƭ��ǩ
	private JLabel pictureLab;
	// ѡ����Ƭ��ť
	private JButton pictureBt;

	/**
	 * Create the panel.
	 */
	public InfoPanel() {

		// �����������
		setLayout(null);
		setSize(780, 560);

		// ѧ�ű�ǩ
		JLabel idNumLab = new JLabel("\u5B66    \u53F7");
		idNumLab.setFont(new Font("����", Font.PLAIN, 14));
		idNumLab.setBounds(40, 20, 66, 25);
		add(idNumLab);

		// ������ǩ
		JLabel nameLab = new JLabel("\u59D3    \u540D");
		nameLab.setFont(new Font("����", Font.PLAIN, 14));
		nameLab.setBounds(40, 65, 66, 25);
		add(nameLab);

		// �Ա��ǩ
		JLabel sexLab = new JLabel("\u6027    \u522B");
		sexLab.setFont(new Font("����", Font.PLAIN, 14));
		sexLab.setBounds(40, 111, 66, 25);
		add(sexLab);

		// �꼶��ǩ
		JLabel gradeLab = new JLabel("\u5E74    \u7EA7");
		gradeLab.setFont(new Font("����", Font.PLAIN, 14));
		gradeLab.setBounds(40, 160, 66, 25);
		add(gradeLab);

		// ϵ���ǩ
		JLabel deptLab = new JLabel("\u7CFB    \u522B");
		deptLab.setFont(new Font("����", Font.PLAIN, 14));
		deptLab.setBounds(40, 205, 66, 25);
		add(deptLab);

		// רҵ��ǩ
		JLabel majorLab = new JLabel("\u4E13    \u4E1A");
		majorLab.setFont(new Font("����", Font.PLAIN, 14));
		majorLab.setBounds(40, 254, 66, 25);
		add(majorLab);

		// �������ڱ�ǩ
		JLabel bornLab = new JLabel("\u51FA\u751F\u65E5\u671F");
		bornLab.setFont(new Font("����", Font.PLAIN, 14));
		bornLab.setBounds(40, 368, 66, 25);
		add(bornLab);

		// ��ϵ��ʽ��ǩ
		JLabel phoneLab = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		phoneLab.setFont(new Font("����", Font.PLAIN, 14));
		phoneLab.setBounds(390, 379, 66, 25);
		add(phoneLab);

		// ����ǩ����ǩ
		JLabel signatureLab = new JLabel("\u4E2A\u6027\u7B7E\u540D");
		signatureLab.setFont(new Font("����", Font.PLAIN, 14));
		signatureLab.setBounds(40, 450, 66, 25);
		add(signatureLab);

		// ��ַ��ǩ
		JLabel addressLab = new JLabel("\u5730    \u5740");
		addressLab.setFont(new Font("����", Font.PLAIN, 14));
		addressLab.setBounds(390, 450, 66, 25);
		add(addressLab);

		// ѧ���ı���
		idNumTxt = new JTextField();
		idNumTxt.setFont(new Font("����", Font.PLAIN, 14));
		idNumTxt.setBounds(131, 20, 200, 25);
		add(idNumTxt);
		idNumTxt.setColumns(15);

		// �����ı���
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("����", Font.PLAIN, 14));
		nameTxt.setBounds(131, 65, 200, 25);
		add(nameTxt);
		nameTxt.setColumns(10);

		// �Ա���Ͽ�
		sexCombox = new JComboBox();
		sexCombox.setModel(new DefaultComboBoxModel(new String[] { "\u7537",
				"\u5973" }));
		sexCombox.setFont(new Font("����", Font.PLAIN, 14));
		sexCombox.setBounds(131, 111, 200, 25);
		add(sexCombox);
		sexCombox.addItemListener(this);

		// �꼶��Ͽ�
		gradeCombox = new JComboBox();
		gradeCombox.setModel(new DefaultComboBoxModel(
				new String[] { "\u5927\u4E00", "\u5927\u4E8C", "\u5927\u4E09",
						"\u5927\u56DB" }));
		gradeCombox.setFont(new Font("����", Font.PLAIN, 14));
		gradeCombox.setBounds(131, 160, 200, 25);
		add(gradeCombox);
		gradeCombox.addItemListener(this);

		// ϵ����Ͽ�
		deptCombox = new JComboBox();
		deptCombox
				.setModel(new DefaultComboBoxModel(
						new String[] { "\u4E92\u8054\u7F51\u91D1\u878D\u4E0E\u4FE1\u606F\u5DE5\u7A0B\u7CFB" }));
		deptCombox.setFont(new Font("����", Font.PLAIN, 14));
		deptCombox.setBounds(131, 205, 200, 25);
		add(deptCombox);
		deptCombox.addItemListener(this);

		// רҵ��Ͽ�
		majorCombox = new JComboBox();
		majorCombox.setModel(new DefaultComboBoxModel(new String[] {
				"\u8BA1\u7B97\u673A\u79D1\u5B66\u4E0E\u6280\u672F",
				"\u4FE1\u606F\u7BA1\u7406", "\u7535\u5B50\u5546\u52A1" }));
		majorCombox.setFont(new Font("����", Font.PLAIN, 14));
		majorCombox.setBounds(131, 254, 200, 25);
		add(majorCombox);
		majorCombox.addItemListener(this);

		// ��ʾ��ǩ
		JLabel tipLab = new JLabel("(\u683C\u5F0F\uFF1Axxxx-xx-xx)");
		tipLab.setForeground(new Color(255, 0, 0));
		tipLab.setFont(new Font("����", Font.PLAIN, 10));
		tipLab.setBounds(27, 382, 95, 21);
		add(tipLab);

		// ���������ı���
		bornTxt = new JTextField();
		bornTxt.setBounds(131, 379, 200, 25);
		add(bornTxt);
		bornTxt.setColumns(10);

		// ��ϵ��ʽ�ı���
		phoneTxt = new JTextField();
		phoneTxt.setBounds(471, 379, 266, 25);
		add(phoneTxt);
		phoneTxt.setColumns(10);

		// ����ǩ���ı���
		signatureArea = new JTextArea();
		signatureArea.setBorder(UIManager.getBorder("TextField.border"));
		signatureArea.setFont(new Font("����", Font.PLAIN, 14));
		signatureArea.setBounds(131, 440, 200, 49);
		add(signatureArea);

		// ��ַ�ı���
		addressArea = new JTextArea();
		addressArea.setBorder(UIManager.getBorder("TextField.border"));
		addressArea.setFont(new Font("����", Font.PLAIN, 14));
		addressArea.setBounds(466, 440, 271, 49);
		add(addressArea);

		// ��ݱ�ǩ
		JLabel identityLab = new JLabel("\u8EAB    \u4EFD");
		identityLab.setFont(new Font("����", Font.PLAIN, 14));
		identityLab.setBounds(40, 302, 66, 25);
		add(identityLab);

		// �����Ͽ�
		idenCombox = new JComboBox();
		idenCombox.setModel(new DefaultComboBoxModel(new String[] {
				"\u90E8\u843D\u6210\u5458", "\u7BA1\u7406\u5458" }));
		idenCombox.setFont(new Font("����", Font.PLAIN, 14));
		idenCombox.setBounds(131, 302, 200, 25);
		add(idenCombox);
		idenCombox.addItemListener(this);

		pswLab = new JLabel("\u5BC6    \u7801");
		pswLab.setFont(new Font("����", Font.PLAIN, 14));
		pswLab.setBounds(40, 519, 66, 28);
		add(pswLab);

		// ����
		psw = new JPasswordField();
		psw.setFont(new Font("����", Font.PLAIN, 14));
		psw.setColumns(15);
		psw.setBounds(131, 521, 200, 25);
		add(psw);

		// ��Ƭ���
		picturePan = new JPanel();
		picturePan.setBorder(new TitledBorder(null, "\u7167\u7247",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		picturePan.setBounds(387, 20, 350, 307);
		add(picturePan);
		picturePan.setLayout(null);

		// ��Ƭ��ǩ
		pictureLab = new JLabel("");
		pictureLab.setBounds(10, 20, 330, 265);
		picturePan.add(pictureLab);

		// ѡ����Ƭ��ť
		pictureBt = new JButton("\u9009\u62E9\u56FE\u7247");
		pictureBt.setFont(new Font("����", Font.PLAIN, 14));
		pictureBt.setBounds(247, 284, 93, 23);
		picturePan.add(pictureBt);

	}

	

	/**
	 * ��Ͽ�ѡ���¼�
	 */
	public void itemStateChanged(ItemEvent e) {
		// ��ȡ�¼�Դ
		JComboBox source = (JComboBox) e.getSource();

		/* =====================�Ա���Ͽ�=================== */
		if (source.equals(sexCombox)) {
			infoSex = (String) source.getSelectedItem();
		}

		/* ==================�꼶��Ͽ�========================= */
		else if (source.equals(gradeCombox)) {
			infoGrade = (String) source.getSelectedItem();
		}

		/* =================ϵ����Ͽ�========================= */
		else if (source.equals(deptCombox)) {
			infoDept = (String) source.getSelectedItem();
		}

		/* =================רҵ��Ͽ�========================= */
		else if (source.equals(majorCombox)) {
			infoMajor = (String) source.getSelectedItem();
		}

		/* =================�����Ͽ�========================= */
		else if (source.equals(idenCombox)) {
			infoIden = (String) source.getSelectedItem();
		}
	}

	/** ==========get����========================= */
	public JTextField getIdNumTxt() {
		return idNumTxt;
	}

	public JTextField getNameTxt() {
		return nameTxt;
	}

	public JTextField getBornTxt() {
		return bornTxt;
	}

	public JTextField getPhoneTxt() {
		return phoneTxt;
	}

	public JPasswordField getPsw() {
		return psw;
	}

	public JLabel getPswLab() {
		return pswLab;
	}

	public JComboBox getSexCombox() {
		return sexCombox;
	}

	public JComboBox getGradeCombox() {
		return gradeCombox;
	}

	public JComboBox getDeptCombox() {
		return deptCombox;
	}

	public JComboBox getMajorCombox() {
		return majorCombox;
	}

	public JComboBox getIdenCombox() {
		return idenCombox;
	}

	public JTextArea getSignatureArea() {
		return signatureArea;
	}

	public JTextArea getAddressArea() {
		return addressArea;
	}

	public String getInfoSex() {
		return infoSex;
	}

	public String getInfoGrade() {
		return infoGrade;
	}

	public String getInfoDept() {
		return infoDept;
	}

	public String getInfoMajor() {
		return infoMajor;
	}

	public String getInfoIden() {
		return infoIden;
	}

	public JLabel getPictureLab() {
		return pictureLab;
	}

	public JButton getPictureBt() {
		return pictureBt;
	}
}
