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
 * @author 叶雅芳
 * @date 2015-07-30
 * @desc 修改密码面板设计类
 * 
 */

public class UpdatePasswordPanel extends JPanel {

	// 修改密码面板动作事件类
	UpdPswActEvents updPswActEvnt = new UpdPswActEvents();

	// 学号文本框
	private JTextField idNumTxt;

	// 修改、取消按钮
	private JButton updBt, clearBt;

	// 密码，确认密码
	private JPasswordField psw, okPsw;

	/**
	 * Create the panel.
	 */
	public UpdatePasswordPanel() {

		// 向修改密码面板动作事件类传递修改密码面板设计类对象
		updPswActEvnt.setUpdPswPan(this);

		// 修改密码面板属性设置
		setLayout(null);
		setBounds(10, 10, 600, 470);

		// 学号标签
		JLabel idNumLab = new JLabel("\u5B66      \u53F7");
		idNumLab.setFont(new Font("宋体", Font.PLAIN, 14));
		idNumLab.setBounds(100, 60, 80, 25);
		add(idNumLab);

		// 密码标签
		JLabel pswLab = new JLabel("\u65B0  \u5BC6   \u7801");
		pswLab.setFont(new Font("宋体", Font.PLAIN, 14));
		pswLab.setBounds(100, 140, 80, 25);
		add(pswLab);

		// 确认密码标签
		JLabel okPswLab = new JLabel("\u786E \u8BA4 \u5BC6 \u7801");
		okPswLab.setFont(new Font("宋体", Font.PLAIN, 14));
		okPswLab.setBounds(100, 216, 80, 25);
		add(okPswLab);

		// 学号文本框
		idNumTxt = new JTextField();
		idNumTxt.setFont(new Font("宋体", Font.PLAIN, 14));
		idNumTxt.setBounds(200, 60, 200, 25);
		add(idNumTxt);
		idNumTxt.setColumns(15);

		// 修改按钮
		updBt = new JButton("\u4FEE\u6539");
		updBt.setFont(new Font("宋体", Font.PLAIN, 14));
		updBt.setBounds(125, 340, 93, 25);
		add(updBt);
		updBt.addActionListener(updPswActEvnt);

		// 取消按钮
		clearBt = new JButton("\u91CD\u7F6E");
		clearBt.setFont(new Font("宋体", Font.PLAIN, 14));
		clearBt.setBounds(284, 341, 93, 25);
		add(clearBt);
		clearBt.addActionListener(updPswActEvnt);

		// 密码
		psw = new JPasswordField();
		psw.setColumns(15);
		psw.setFont(new Font("宋体", Font.PLAIN, 14));
		psw.setBounds(200, 140, 200, 25);
		add(psw);

		// 确认密码
		okPsw = new JPasswordField();
		okPsw.setColumns(15);
		okPsw.setFont(new Font("宋体", Font.PLAIN, 14));
		okPsw.setBounds(200, 216, 200, 25);
		add(okPsw);

	}

	

	/** =========get方法========================== */
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
