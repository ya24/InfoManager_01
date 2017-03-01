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
 * @author 叶雅芳
 * @date 2015-07-30
 * @desc 修改信息面板设计类
 * 
 */

public class InfoUpdatePanel extends JPanel {

	public InfoPanel infoPan = new InfoPanel(); // 信息面板设计类
	InfoUpdActEvents updActEvnt = new InfoUpdActEvents(); // 修改信息面板动作事件类

	private JTextField updIdTxt; // 修改信息文本框

	// 搜索、录入删除、重置按钮
	private JButton seekBt, UpdBt, clearBt;

	/**
	 * Create the panel.
	 * 
	 */
	public InfoUpdatePanel() {
		// 向修改信息面板动作事件类传入修改信息面板设计类对象
		updActEvnt.setInfoUpdPan(this);

		// 信息面板位置设计
		infoPan.setLocation(20, 70);

		// 修改信息面板属性设置
		setLayout(null);
		setBounds(10, 10, 806, 671);

		// 提示修改面板
		JPanel tipPan = new JPanel();
		tipPan.setBorder(new TitledBorder(null, "\u4FEE\u6539",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tipPan.setBounds(10, 10, 741, 60);
		add(tipPan);
		tipPan.setLayout(null);

		// 修改信息文本框
		updIdTxt = new JTextField();
		updIdTxt.setBounds(180, 23, 160, 25);
		tipPan.add(updIdTxt);
		updIdTxt.setFont(new Font("宋体", Font.PLAIN, 14));
		updIdTxt.setColumns(15);

		// 提示修改信息标签
		JLabel updInfoLab = new JLabel(
				"\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u4FE1\u606F\u7684\u5B66\u53F7");
		updInfoLab.setBounds(10, 23, 160, 25);
		tipPan.add(updInfoLab);
		updInfoLab.setFont(new Font("宋体", Font.PLAIN, 14));

		// 搜索按钮
		seekBt = new JButton("\u641C\u7D22");
		seekBt.setBounds(360, 23, 70, 25);
		tipPan.add(seekBt);
		seekBt.setFont(new Font("宋体", Font.PLAIN, 14));
		seekBt.addActionListener(updActEvnt);

		// 添加信息面板
		add(infoPan);
		// 将信息面板的密码栏隐藏
		infoPan.getPswLab().setVisible(false);
		infoPan.getPsw().setVisible(false);
		// 将学号文本框设置为不可编辑
		infoPan.getIdNumTxt().setEnabled(false);
		infoPan.getPictureBt().addActionListener(updActEvnt);

		// 录入修改按钮
		UpdBt = new JButton("\u5F55\u5165\u4FEE\u6539");
		UpdBt.setFont(new Font("宋体", Font.PLAIN, 14));
		UpdBt.setBounds(268, 630, 93, 25);
		add(UpdBt);
		UpdBt.addActionListener(updActEvnt);

		// 重置按钮
		clearBt = new JButton("\u91CD\u7F6E");
		clearBt.setFont(new Font("宋体", Font.PLAIN, 14));
		clearBt.setBounds(393, 630, 93, 25);
		add(clearBt);
		clearBt.addActionListener(updActEvnt);

	}

	

	/** ==========get方法========================== */
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
