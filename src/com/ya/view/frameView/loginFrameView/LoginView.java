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
 * @author Ҷ�ŷ�
 * @date 2015-07-30
 * @desc ��Ϣ����ϵͳ��¼������
 *
 */
public class LoginView extends JFrame {
	
	LoginActEvents lgActEvnt=new LoginActEvents();	//��¼���涯���¼���
	
	private JPanel contentPane;
	private JTextField idTxt;	//ѧ���ı���
	private JPasswordField psw;	//����
	private JComboBox idComBox;	//�����Ͽ�
	private JButton clearBt;	//���ð�ť
	private JButton loginBt;	//��¼��ť
	
	private String lgIdentity="�����Ա";//�����Ͽ��е����ݣ�Ĭ��Ϊ�����Ա
		
	
	/**
	 * Create the frame.
	 * 
	 */
	public LoginView() {
		
		lgActEvnt.setLgView(this);	//���¼���涯���¼��ഫ�ݱ������
		
		//��Ƶ�¼����������
		setResizable(false);
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 150, 252, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		//������壬��ű�ǩ����һ����Ϣ���
		JPanel totalPan = new JPanel();
		totalPan.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.inactiveCaptionBorder));
		totalPan.setBounds(0, 0, 246, 335);
		contentPane.add(totalPan);
		totalPan.setLayout(null);
		
		//��Ǳ�ǩ������ӭ����צ�۲�����Ϣ����ϵͳ��
		JLabel signLab = new JLabel("");
		signLab.setIcon(new ImageIcon(LoginView.class.getResource("/image/\u80CC\u666F1_1_1.png")));
		signLab.setBounds(0, 0, 244, 100);
		totalPan.add(signLab);
		
		//��Ϣ���
		JPanel infoPan = new JPanel();
		infoPan.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.inactiveCaptionBorder));
		infoPan.setBounds(0, 104, 246, 234);
		totalPan.add(infoPan);
		infoPan.setLayout(null);
		
		//ѧ�ű�ǩ
		JLabel idNumLab = new JLabel("\u5B66 \u53F7");
		idNumLab.setFont(new Font("����", Font.PLAIN, 14));
		idNumLab.setBounds(8, 26, 45, 25);
		infoPan.add(idNumLab);
		
		//ѧ���ı���
		idTxt = new JTextField();
		idTxt.setFont(new Font("����", Font.PLAIN, 14));
		idTxt.setBounds(63, 26, 171, 25);
		infoPan.add(idTxt);
		idTxt.setColumns(15);
		
		//�����ǩ
		JLabel pswLab = new JLabel("\u5BC6 \u7801");
		pswLab.setFont(new Font("����", Font.PLAIN, 14));
		pswLab.setBounds(8, 79, 45, 25);
		infoPan.add(pswLab);
		
		//��ݱ�ǩ
		JLabel idLab = new JLabel("\u8EAB \u4EFD");
		idLab.setFont(new Font("����", Font.PLAIN, 14));
		idLab.setBounds(8, 135, 45, 25);
		infoPan.add(idLab);
		
		//�����Ͽ򣬼���ѡ���¼�����
		idComBox = new JComboBox();
		idComBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//��ȡ�¼�Դ
				JComboBox source=(JComboBox)e.getSource();
				//��ȡѡ��ѡ�������
				lgIdentity=(String)source.getSelectedItem();
			}
		});
		idComBox.setFont(new Font("����", Font.PLAIN, 14));
		idComBox.setModel(new DefaultComboBoxModel(new String[] {"\u90E8\u843D\u6210\u5458", "\u7BA1\u7406\u5458"}));
		idComBox.setBounds(63, 135, 171, 25);
		infoPan.add(idComBox);
		
		//���ð�ť
		clearBt = new JButton("\u91CD\u7F6E");
		clearBt.setFont(new Font("����", Font.PLAIN, 14));
		clearBt.setBounds(141, 185, 93, 23);
		infoPan.add(clearBt);
		clearBt.addActionListener(lgActEvnt);
		
		//��¼��ť
		loginBt = new JButton("\u767B\u5F55");
		loginBt.setBounds(8, 185, 93, 23);
		infoPan.add(loginBt);
		loginBt.setFont(new Font("����", Font.PLAIN, 14));
		loginBt.addActionListener(lgActEvnt);
		
		//�����
		psw = new JPasswordField();
		psw.setBounds(63, 81, 171, 25);
		infoPan.add(psw);
		
	}
	
	
	
	/**=============get����============================*/
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
