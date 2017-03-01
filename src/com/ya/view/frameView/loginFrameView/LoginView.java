package com.ya.view.frameView.loginFrameView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import com.ya.control.actionControl.loginActControl.LoginActEvents;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * 
 * @author 叶雅芳
 * @date 2015-07-30
 * @desc 信息管理系统登录界面类
 *
 */
public class LoginView extends JFrame {
	
	LoginActEvents lgActEvnt=new LoginActEvents();	//登录界面动作事件类
	
	private JPanel contentPane;
	private JTextField idTxt;	//学号文本框
	private JPasswordField psw;	//密码
	private JComboBox idComBox;	//身份组合框
	private JButton clearBt;	//重置按钮
	private JButton loginBt;	//登录按钮
	
	private String lgIdentity="部落成员";//身份组合框中的内容，默认为部落成员
		
	
	/**
	 * Create the frame.
	 * 
	 */
	public LoginView() {
		
		lgActEvnt.setLgView(this);	//向登录界面动作事件类传递本类对象
		
		//设计登录界面框架属性
		setResizable(false);
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 150, 252, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		//整体面板，存放标签和另一个信息面板
		JPanel totalPan = new JPanel();
		totalPan.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.inactiveCaptionBorder));
		totalPan.setBounds(0, 0, 246, 335);
		contentPane.add(totalPan);
		totalPan.setLayout(null);
		
		//标记标签，“欢迎访问爪哇部落信息管理系统”
		JLabel signLab = new JLabel("");
		signLab.setIcon(new ImageIcon(LoginView.class.getResource("/image/\u80CC\u666F1_1_1.png")));
		signLab.setBounds(0, 0, 244, 100);
		totalPan.add(signLab);
		
		//信息面板
		JPanel infoPan = new JPanel();
		infoPan.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.inactiveCaptionBorder));
		infoPan.setBounds(0, 104, 246, 234);
		totalPan.add(infoPan);
		infoPan.setLayout(null);
		
		//学号标签
		JLabel idNumLab = new JLabel("\u5B66 \u53F7");
		idNumLab.setFont(new Font("宋体", Font.PLAIN, 14));
		idNumLab.setBounds(8, 26, 45, 25);
		infoPan.add(idNumLab);
		
		//学号文本框
		idTxt = new JTextField();
		idTxt.setFont(new Font("宋体", Font.PLAIN, 14));
		idTxt.setBounds(63, 26, 171, 25);
		infoPan.add(idTxt);
		idTxt.setColumns(15);
		
		//密码标签
		JLabel pswLab = new JLabel("\u5BC6 \u7801");
		pswLab.setFont(new Font("宋体", Font.PLAIN, 14));
		pswLab.setBounds(8, 79, 45, 25);
		infoPan.add(pswLab);
		
		//身份标签
		JLabel idLab = new JLabel("\u8EAB \u4EFD");
		idLab.setFont(new Font("宋体", Font.PLAIN, 14));
		idLab.setBounds(8, 135, 45, 25);
		infoPan.add(idLab);
		
		//身份组合框，及其选项事件处理
		idComBox = new JComboBox();
		idComBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//获取事件源
				JComboBox source=(JComboBox)e.getSource();
				//获取选中选项的内容
				lgIdentity=(String)source.getSelectedItem();
			}
		});
		idComBox.setFont(new Font("宋体", Font.PLAIN, 14));
		idComBox.setModel(new DefaultComboBoxModel(new String[] {"\u90E8\u843D\u6210\u5458", "\u7BA1\u7406\u5458"}));
		idComBox.setBounds(63, 135, 171, 25);
		infoPan.add(idComBox);
		
		//重置按钮
		clearBt = new JButton("\u91CD\u7F6E");
		clearBt.setFont(new Font("宋体", Font.PLAIN, 14));
		clearBt.setBounds(141, 185, 93, 23);
		infoPan.add(clearBt);
		clearBt.addActionListener(lgActEvnt);
		
		//登录按钮
		loginBt = new JButton("\u767B\u5F55");
		loginBt.setBounds(8, 185, 93, 23);
		infoPan.add(loginBt);
		loginBt.setFont(new Font("宋体", Font.PLAIN, 14));
		loginBt.addActionListener(lgActEvnt);
		
		//密码框
		psw = new JPasswordField();
		psw.setBounds(63, 81, 171, 25);
		infoPan.add(psw);
		
	}
	
	
	
	/**=============get方法============================*/
	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getIdTxt() {
		return idTxt;
	}

	public JComboBox getIdComBox() {
		return idComBox;
	}

	public JButton getClearBt() {
		return clearBt;
	}

	public JButton getLoginBt() {
		return loginBt;
	}

	public JPasswordField getPsw() {
		return psw;
	}

	public String getLgIdentity() {
		return lgIdentity;
	}

}
