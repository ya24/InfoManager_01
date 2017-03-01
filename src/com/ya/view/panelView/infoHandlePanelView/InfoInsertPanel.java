package com.ya.view.panelView.infoHandlePanelView;

import javax.swing.JPanel;
import javax.swing.JButton;

import com.ya.control.actionControl.infoHandleActControl.InfoInsActEvents;

import java.awt.Font;

/**
 * 
 * @author 叶雅芳
 * @date 2015-07-30
 * @desc 添加信息面板设计类
 * 
 */

public class InfoInsertPanel extends JPanel {

	// 信息面板设计类
	public InfoPanel infoPan = new InfoPanel();

	// 添加信息面板动作事件类
	InfoInsActEvents insActEvnt = new InfoInsActEvents();

	// 录入,清除按钮
	private JButton addBt, clearBt;

	
	
	/**
	 * Create the panel.
	 * 
	 */
	public InfoInsertPanel() {

		// 向添加信息面板动作事件类传递添加信息面板设计类对象
		insActEvnt.setInfoInsPan(this);

		// 信息面板位置设计
		infoPan.setLocation(10, 10);
		// 添加 信息面板
		add(infoPan);
		
		// 添加信息面板属性设置
		setLayout(null);
		setBounds(10, 10, 780, 643);

		// 录入按钮
		addBt = new JButton("\u5F55\u5165");
		addBt.setFont(new Font("宋体", Font.PLAIN, 14));
		addBt.setBounds(237, 590, 95, 25);
		add(addBt);
		addBt.addActionListener(insActEvnt);

		// 清除按钮
		clearBt = new JButton("\u91CD\u7F6E");
		clearBt.setFont(new Font("宋体", Font.PLAIN, 14));
		clearBt.setBounds(377, 590, 95, 25);
		add(clearBt);
		clearBt.addActionListener(insActEvnt);
		
		//选择图片按钮，添加动作事件
		infoPan.getPictureBt().addActionListener(insActEvnt);

	}

	
	/** ===========get方法============ */
	public JButton getAddBt() {
		return addBt;
	}

	public JButton getClearBt() {
		return clearBt;
	}

}
