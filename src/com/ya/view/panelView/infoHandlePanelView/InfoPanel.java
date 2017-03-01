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
 * @author 叶雅芳
 * @date 2015-07-30
 * @desc 信息面板设计类，实现ItemListener，监听组合框，获取组合框中选中选项的文本内容
 * 
 */

public class InfoPanel extends JPanel implements ItemListener {

	// 学号文本框,姓名文本框,出生日期文本框,联系方式文本框
	private JTextField idNumTxt, nameTxt, bornTxt, phoneTxt;

	// 密码框
	private JPasswordField psw;

	// 密码标签
	private JLabel pswLab;

	// 性别组合框;年级组合框,系别组合框，专业组合框、身份组合框
	private JComboBox sexCombox, gradeCombox, deptCombox, majorCombox,idenCombox;

	// 个性签名文本区，地址文本区
	private JTextArea signatureArea, addressArea;

	// 信息面板组合框所选中选项的内容
	private String infoSex = "男", infoGrade = "大一", infoDept = "互联网金融与信息工程系",
			infoMajor = "计算机科学与技术", infoIden = "部落成员";

	// 照片面板
	private JPanel picturePan;
	// 照片标签
	private JLabel pictureLab;
	// 选择照片按钮
	private JButton pictureBt;

	/**
	 * Create the panel.
	 */
	public InfoPanel() {

		// 面板属性设置
		setLayout(null);
		setSize(780, 560);

		// 学号标签
		JLabel idNumLab = new JLabel("\u5B66    \u53F7");
		idNumLab.setFont(new Font("宋体", Font.PLAIN, 14));
		idNumLab.setBounds(40, 20, 66, 25);
		add(idNumLab);

		// 姓名标签
		JLabel nameLab = new JLabel("\u59D3    \u540D");
		nameLab.setFont(new Font("宋体", Font.PLAIN, 14));
		nameLab.setBounds(40, 65, 66, 25);
		add(nameLab);

		// 性别标签
		JLabel sexLab = new JLabel("\u6027    \u522B");
		sexLab.setFont(new Font("宋体", Font.PLAIN, 14));
		sexLab.setBounds(40, 111, 66, 25);
		add(sexLab);

		// 年级标签
		JLabel gradeLab = new JLabel("\u5E74    \u7EA7");
		gradeLab.setFont(new Font("宋体", Font.PLAIN, 14));
		gradeLab.setBounds(40, 160, 66, 25);
		add(gradeLab);

		// 系别标签
		JLabel deptLab = new JLabel("\u7CFB    \u522B");
		deptLab.setFont(new Font("宋体", Font.PLAIN, 14));
		deptLab.setBounds(40, 205, 66, 25);
		add(deptLab);

		// 专业标签
		JLabel majorLab = new JLabel("\u4E13    \u4E1A");
		majorLab.setFont(new Font("宋体", Font.PLAIN, 14));
		majorLab.setBounds(40, 254, 66, 25);
		add(majorLab);

		// 出生日期标签
		JLabel bornLab = new JLabel("\u51FA\u751F\u65E5\u671F");
		bornLab.setFont(new Font("宋体", Font.PLAIN, 14));
		bornLab.setBounds(40, 368, 66, 25);
		add(bornLab);

		// 联系方式标签
		JLabel phoneLab = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		phoneLab.setFont(new Font("宋体", Font.PLAIN, 14));
		phoneLab.setBounds(390, 379, 66, 25);
		add(phoneLab);

		// 个性签名标签
		JLabel signatureLab = new JLabel("\u4E2A\u6027\u7B7E\u540D");
		signatureLab.setFont(new Font("宋体", Font.PLAIN, 14));
		signatureLab.setBounds(40, 450, 66, 25);
		add(signatureLab);

		// 地址标签
		JLabel addressLab = new JLabel("\u5730    \u5740");
		addressLab.setFont(new Font("宋体", Font.PLAIN, 14));
		addressLab.setBounds(390, 450, 66, 25);
		add(addressLab);

		// 学号文本框
		idNumTxt = new JTextField();
		idNumTxt.setFont(new Font("宋体", Font.PLAIN, 14));
		idNumTxt.setBounds(131, 20, 200, 25);
		add(idNumTxt);
		idNumTxt.setColumns(15);

		// 姓名文本框
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("宋体", Font.PLAIN, 14));
		nameTxt.setBounds(131, 65, 200, 25);
		add(nameTxt);
		nameTxt.setColumns(10);

		// 性别组合框
		sexCombox = new JComboBox();
		sexCombox.setModel(new DefaultComboBoxModel(new String[] { "\u7537",
				"\u5973" }));
		sexCombox.setFont(new Font("宋体", Font.PLAIN, 14));
		sexCombox.setBounds(131, 111, 200, 25);
		add(sexCombox);
		sexCombox.addItemListener(this);

		// 年级组合框
		gradeCombox = new JComboBox();
		gradeCombox.setModel(new DefaultComboBoxModel(
				new String[] { "\u5927\u4E00", "\u5927\u4E8C", "\u5927\u4E09",
						"\u5927\u56DB" }));
		gradeCombox.setFont(new Font("宋体", Font.PLAIN, 14));
		gradeCombox.setBounds(131, 160, 200, 25);
		add(gradeCombox);
		gradeCombox.addItemListener(this);

		// 系别组合框
		deptCombox = new JComboBox();
		deptCombox
				.setModel(new DefaultComboBoxModel(
						new String[] { "\u4E92\u8054\u7F51\u91D1\u878D\u4E0E\u4FE1\u606F\u5DE5\u7A0B\u7CFB" }));
		deptCombox.setFont(new Font("宋体", Font.PLAIN, 14));
		deptCombox.setBounds(131, 205, 200, 25);
		add(deptCombox);
		deptCombox.addItemListener(this);

		// 专业组合框
		majorCombox = new JComboBox();
		majorCombox.setModel(new DefaultComboBoxModel(new String[] {
				"\u8BA1\u7B97\u673A\u79D1\u5B66\u4E0E\u6280\u672F",
				"\u4FE1\u606F\u7BA1\u7406", "\u7535\u5B50\u5546\u52A1" }));
		majorCombox.setFont(new Font("宋体", Font.PLAIN, 14));
		majorCombox.setBounds(131, 254, 200, 25);
		add(majorCombox);
		majorCombox.addItemListener(this);

		// 提示标签
		JLabel tipLab = new JLabel("(\u683C\u5F0F\uFF1Axxxx-xx-xx)");
		tipLab.setForeground(new Color(255, 0, 0));
		tipLab.setFont(new Font("宋体", Font.PLAIN, 10));
		tipLab.setBounds(27, 382, 95, 21);
		add(tipLab);

		// 出生日期文本框
		bornTxt = new JTextField();
		bornTxt.setBounds(131, 379, 200, 25);
		add(bornTxt);
		bornTxt.setColumns(10);

		// 联系方式文本框
		phoneTxt = new JTextField();
		phoneTxt.setBounds(471, 379, 266, 25);
		add(phoneTxt);
		phoneTxt.setColumns(10);

		// 个性签名文本区
		signatureArea = new JTextArea();
		signatureArea.setBorder(UIManager.getBorder("TextField.border"));
		signatureArea.setFont(new Font("宋体", Font.PLAIN, 14));
		signatureArea.setBounds(131, 440, 200, 49);
		add(signatureArea);

		// 地址文本区
		addressArea = new JTextArea();
		addressArea.setBorder(UIManager.getBorder("TextField.border"));
		addressArea.setFont(new Font("宋体", Font.PLAIN, 14));
		addressArea.setBounds(466, 440, 271, 49);
		add(addressArea);

		// 身份标签
		JLabel identityLab = new JLabel("\u8EAB    \u4EFD");
		identityLab.setFont(new Font("宋体", Font.PLAIN, 14));
		identityLab.setBounds(40, 302, 66, 25);
		add(identityLab);

		// 身份组合框
		idenCombox = new JComboBox();
		idenCombox.setModel(new DefaultComboBoxModel(new String[] {
				"\u90E8\u843D\u6210\u5458", "\u7BA1\u7406\u5458" }));
		idenCombox.setFont(new Font("宋体", Font.PLAIN, 14));
		idenCombox.setBounds(131, 302, 200, 25);
		add(idenCombox);
		idenCombox.addItemListener(this);

		pswLab = new JLabel("\u5BC6    \u7801");
		pswLab.setFont(new Font("宋体", Font.PLAIN, 14));
		pswLab.setBounds(40, 519, 66, 28);
		add(pswLab);

		// 密码
		psw = new JPasswordField();
		psw.setFont(new Font("宋体", Font.PLAIN, 14));
		psw.setColumns(15);
		psw.setBounds(131, 521, 200, 25);
		add(psw);

		// 照片面板
		picturePan = new JPanel();
		picturePan.setBorder(new TitledBorder(null, "\u7167\u7247",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		picturePan.setBounds(387, 20, 350, 307);
		add(picturePan);
		picturePan.setLayout(null);

		// 照片标签
		pictureLab = new JLabel("");
		pictureLab.setBounds(10, 20, 330, 265);
		picturePan.add(pictureLab);

		// 选择照片按钮
		pictureBt = new JButton("\u9009\u62E9\u56FE\u7247");
		pictureBt.setFont(new Font("宋体", Font.PLAIN, 14));
		pictureBt.setBounds(247, 284, 93, 23);
		picturePan.add(pictureBt);

	}

	

	/**
	 * 组合框选项事件
	 */
	public void itemStateChanged(ItemEvent e) {
		// 获取事件源
		JComboBox source = (JComboBox) e.getSource();

		/* =====================性别组合框=================== */
		if (source.equals(sexCombox)) {
			infoSex = (String) source.getSelectedItem();
		}

		/* ==================年级组合框========================= */
		else if (source.equals(gradeCombox)) {
			infoGrade = (String) source.getSelectedItem();
		}

		/* =================系别组合框========================= */
		else if (source.equals(deptCombox)) {
			infoDept = (String) source.getSelectedItem();
		}

		/* =================专业组合框========================= */
		else if (source.equals(majorCombox)) {
			infoMajor = (String) source.getSelectedItem();
		}

		/* =================身份组合框========================= */
		else if (source.equals(idenCombox)) {
			infoIden = (String) source.getSelectedItem();
		}
	}

	/** ==========get方法========================= */
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
