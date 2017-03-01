package com.ya.view.panelView.infoHandlePanelView;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.ya.control.actionControl.infoHandleActControl.InfoDelActEvents;


/**
 * 
 * @author 叶雅芳
 * @date 2015-07-30
 * @desc 删除信息面板设计类
 *
 */

public class InfoDelPanel extends JPanel {
	
	public InfoPanel infoPan=new InfoPanel();	//信息面板设计类
	InfoDelActEvents delActEvnt=new InfoDelActEvents();	//删除信息面板动作事件类
	
	private JTextField delInfoTxt;	//删除信息文本框
	private JButton seekBt,delBt,clearBt;	//搜索、删除、取消按钮	
	private JPanel tipPan;	//提示“删除”面板

	/**
	 * Create the panel.
	 *
	 */
	public InfoDelPanel() {
		
		//向删除信息面板动作事件类传递删除信息面板设计类对象
		delActEvnt.setInfoDelPan(this);
		
		//信息面板的位置
		infoPan.setLocation(22,70);
		
		//信息删除面板属性设置
		setLayout(null);
		setBounds(10,10,805,670);
		
		//提示删除面板
		tipPan = new JPanel();
		tipPan.setBorder(new TitledBorder(null, "\u5220\u9664", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tipPan.setBounds(22, 10, 730, 60);
		add(tipPan);
		tipPan.setLayout(null);
		
		//删除信息提示标签
		JLabel delInfoLab = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u4FE1\u606F\u7684\u5B66\u53F7");
		delInfoLab.setBounds(10, 23, 160, 25);
		tipPan.add(delInfoLab);
		delInfoLab.setFont(new Font("宋体", Font.PLAIN, 14));
		
		//删除信息文本框
		delInfoTxt = new JTextField();
		delInfoTxt.setBounds(180 , 23, 160, 25);
		tipPan.add(delInfoTxt);
		delInfoTxt.setFont(new Font("宋体", Font.PLAIN, 14));
		delInfoTxt.setColumns(15);
		
		//搜索按钮
		seekBt = new JButton("\u641C\u7D22");
		seekBt.setBounds(360, 23, 70, 25);
		tipPan.add(seekBt);
		seekBt.setFont(new Font("宋体", Font.PLAIN, 14));
		seekBt.addActionListener(delActEvnt);
		
		//添加信息面板
		add(infoPan);
		//将信息面板的密码栏隐藏
		infoPan.getPswLab().setVisible(false);
		infoPan.getPsw().setVisible(false);
		//将选中图片按钮隐藏
		infoPan.getPictureBt().setVisible(false);
		//将学号文本框设置为不可编辑
		infoPan.getIdNumTxt().setEnabled(false);
		
		//删除按钮
		delBt = new JButton("\u5220\u9664");
		delBt.setFont(new Font("宋体", Font.PLAIN, 14));
		delBt.setBounds(292, 630, 93, 23);
		add(delBt);
		delBt.addActionListener(delActEvnt);
		
		//重置按钮
		clearBt = new JButton("\u91CD\u7F6E");
		clearBt.setFont(new Font("宋体", Font.PLAIN, 14));
		clearBt.setBounds(413, 630, 93, 23);
		add(clearBt);
		clearBt.addActionListener(delActEvnt);

	}
	
	
	/**======get方法==================*/
	public JTextField getDelInfoTxt() {
		return delInfoTxt;
	}
	public JButton getSeekBt() {
		return seekBt;
	}
	public JButton getDelBt() {
		return delBt;
	}
	public JButton getClearBt() {
		return clearBt;
	}


}
