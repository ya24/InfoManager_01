package com.ya.view.frameView.mainFrameView;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import com.ya.control.actionControl.mainFrmActControl.InfoManagerActEvents;
import com.ya.view.panelView.infoHandlePanelView.InfoDelPanel;
import com.ya.view.panelView.infoHandlePanelView.InfoInsertPanel;
import com.ya.view.panelView.infoHandlePanelView.InfoSelectPanel;
import com.ya.view.panelView.infoHandlePanelView.InfoUpdatePanel;
import com.ya.view.panelView.infoHandlePanelView.UpdatePasswordPanel;

import java.awt.Color;

/**
 * 
 * @author 叶雅芳
 * @date 2015-07-30
 * @desc 信息管理系统主界面设计类
 * 
 */

public class InfoManagerView extends JFrame {
	
	//信息管理系统主界面动作事件类
	InfoManagerActEvents managerActEvnt=new InfoManagerActEvents();	
	
	//信息面板类
	public UpdatePasswordPanel updPswPan=new UpdatePasswordPanel();	//修改密码面板设计类
	public InfoSelectPanel infoSelPan=new InfoSelectPanel();	//查询信息面板设计类
	public InfoInsertPanel infoInsPan=new InfoInsertPanel();	//添加信息面板设计类
	public InfoUpdatePanel infoUpdPan=new InfoUpdatePanel();	//修改信息面板设计类
	public InfoDelPanel infoDelPan=new InfoDelPanel();	//删除信息面板设计类

	
	private JMenuItem updPswMi; // 修改密码菜单项
	private JMenuItem exitMi;	//退出菜单项
	private JMenuItem themeMi;	//主页面菜单项
	private JMenuItem selInfoMi; // 查询信息菜单项
	private JMenuItem InsInfoMi; // 添加信息菜单项
	private JMenuItem updInfoMi; // 修改信息菜单项
	private JMenuItem delInfoMi; // 删除信息菜单项
	private JMenuItem aboutMi; // 关于菜单项
	private JLabel themeLab;	//主页面图片标签
	private JPanel cardPan;	//卡片式布局管理器面板
	private CardLayout card;	//卡片式布局管理器 
	private JLabel messageLab;	//标示使用者标签
	
	
	/**
	 * Create the frame.
	 * 
	 */
	public InfoManagerView() {
		
		//向信息管理系统主界面动作事件类传递本类对象
		managerActEvnt.setManagerView(this);
		
		//主界面框架属性设计
		setResizable(false);
		setTitle("\u722A\u54C7\u90E8\u843D\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 620, 520);

		// 菜单栏
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// 设置菜单
		JMenu setMn = new JMenu("\u8BBE\u7F6E");
		setMn.setFont(new Font("宋体", Font.PLAIN, 16));
		menuBar.add(setMn);

		// 修改密码菜单项
		updPswMi = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		updPswMi.setFont(new Font("宋体", Font.PLAIN, 14));
		setMn.add(updPswMi);
		updPswMi.addActionListener(managerActEvnt);
		updPswMi.setEnabled(false);
		
		// 退出菜单项
		exitMi = new JMenuItem("\u9000\u51FA");
		exitMi.setFont(new Font("宋体", Font.PLAIN, 14));
		setMn.add(exitMi);
		exitMi.addActionListener(managerActEvnt);

		// 操作菜单
		JMenu operateMn = new JMenu("\u64CD\u4F5C");
		operateMn.setFont(new Font("宋体", Font.PLAIN, 16));
		menuBar.add(operateMn);
		
		//主页面菜单项
		themeMi = new JMenuItem("\u4E3B\u9875\u9762");
		themeMi.setFont(new Font("宋体", Font.PLAIN, 14));
		operateMn.add(themeMi);
		themeMi.addActionListener(managerActEvnt);

		// 查询信息菜单项
		selInfoMi = new JMenuItem("\u67E5\u8BE2\u6210\u5458\u4FE1\u606F");
		selInfoMi.setFont(new Font("宋体", Font.PLAIN, 14));
		operateMn.add(selInfoMi);
		selInfoMi.addActionListener(managerActEvnt);

		// 添加信息菜单项
		InsInfoMi = new JMenuItem("\u6DFB\u52A0\u6210\u5458\u4FE1\u606F");
		InsInfoMi.setFont(new Font("宋体", Font.PLAIN, 14));
		operateMn.add(InsInfoMi);
		InsInfoMi.addActionListener(managerActEvnt);
		InsInfoMi.setEnabled(false);

		// 修改信息菜单项
		updInfoMi = new JMenuItem("\u4FEE\u6539\u6210\u5458\u4FE1\u606F");
		updInfoMi.setFont(new Font("宋体", Font.PLAIN, 14));
		operateMn.add(updInfoMi);
		updInfoMi.addActionListener(managerActEvnt);
		updInfoMi.setEnabled(false);

		// 删除信息菜单项
		delInfoMi = new JMenuItem("\u5220\u9664\u6210\u5458\u4FE1\u606F");
		delInfoMi.setFont(new Font("宋体", Font.PLAIN, 14));
		operateMn.add(delInfoMi);
		delInfoMi.addActionListener(managerActEvnt);
		delInfoMi.setEnabled(false);

		// 帮助菜单
		JMenu helpMn = new JMenu("\u5E2E\u52A9");
		helpMn.setFont(new Font("宋体", Font.PLAIN, 16));
		menuBar.add(helpMn);

		// 关于菜单项
		aboutMi = new JMenuItem("\u5173\u4E8E");
		aboutMi.setFont(new Font("宋体", Font.PLAIN, 14));
		helpMn.add(aboutMi);
		aboutMi.addActionListener(managerActEvnt);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		//卡片式布局管理器面板
		card=new CardLayout(0, 0);
		cardPan= new JPanel();
		getContentPane().add(cardPan, BorderLayout.CENTER);
		cardPan.setLayout(card);
		
		//主界面面板
		JPanel pan=new  JPanel();
		cardPan.add(pan, "n");
		cardPan.add(updPswPan, "psw");
		cardPan.add(infoSelPan, "sel");
		cardPan.add(infoInsPan, "ins");
		cardPan.add(infoUpdPan, "upd");
		cardPan.add(infoDelPan, "del");
		
		//主界面图片标签
		themeLab = new JLabel("");
		pan.add(themeLab);
		themeLab.setIcon(new ImageIcon(InfoManagerView.class.getResource("/image/\u80CC\u666F2.png")));
		
		//标示使用者标签
		messageLab = new JLabel("");
		messageLab.setForeground(new Color(0, 51, 255));
		messageLab.setFont(new Font("楷体", Font.PLAIN, 18));
		messageLab.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(messageLab, BorderLayout.SOUTH);
		
	}
	
	
	
	/**==========get方法=============================*/
	public JMenuItem getUpdPswMi() {
		return updPswMi;
	}
	
	public JMenuItem getExitMi(){
		return exitMi;
	}
	

	public JMenuItem getThemeMi() {
		return themeMi;
	}

	public JMenuItem getSelInfoMi() {
		return selInfoMi;
	}

	public JMenuItem getInsInfoMi() {
		return InsInfoMi;
	}

	public JMenuItem getUpdInfoMi() {
		return updInfoMi;
	}

	public JMenuItem getDelInfoMi() {
		return delInfoMi;
	}

	public JMenuItem getAboutMi() {
		return aboutMi;
	}

	public JLabel getThemeLab() {
		return themeLab;
	}

	public JPanel getCardPan() {
		return cardPan;
	}
	
	public CardLayout getCard(){
		return card;
	}
	
	public JLabel getMessageLab() {
		return messageLab;
	}
	
}
