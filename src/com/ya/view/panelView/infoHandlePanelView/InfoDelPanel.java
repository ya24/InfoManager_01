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
 * @author Ҷ�ŷ�
 * @date 2015-07-30
 * @desc ɾ����Ϣ��������
 *
 */

public class InfoDelPanel extends JPanel {
	
	public InfoPanel infoPan=new InfoPanel();	//��Ϣ��������
	InfoDelActEvents delActEvnt=new InfoDelActEvents();	//ɾ����Ϣ��嶯���¼���
	
	private JTextField delInfoTxt;	//ɾ����Ϣ�ı���
	private JButton seekBt,delBt,clearBt;	//������ɾ����ȡ����ť	
	private JPanel tipPan;	//��ʾ��ɾ�������

	/**
	 * Create the panel.
	 *
	 */
	public InfoDelPanel() {
		
		//��ɾ����Ϣ��嶯���¼��ഫ��ɾ����Ϣ�����������
		delActEvnt.setInfoDelPan(this);
		
		//��Ϣ����λ��
		infoPan.setLocation(22,70);
		
		//��Ϣɾ�������������
		setLayout(null);
		setBounds(10,10,805,670);
		
		//��ʾɾ�����
		tipPan = new JPanel();
		tipPan.setBorder(new TitledBorder(null, "\u5220\u9664", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tipPan.setBounds(22, 10, 730, 60);
		add(tipPan);
		tipPan.setLayout(null);
		
		//ɾ����Ϣ��ʾ��ǩ
		JLabel delInfoLab = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u4FE1\u606F\u7684\u5B66\u53F7");
		delInfoLab.setBounds(10, 23, 160, 25);
		tipPan.add(delInfoLab);
		delInfoLab.setFont(new Font("����", Font.PLAIN, 14));
		
		//ɾ����Ϣ�ı���
		delInfoTxt = new JTextField();
		delInfoTxt.setBounds(180 , 23, 160, 25);
		tipPan.add(delInfoTxt);
		delInfoTxt.setFont(new Font("����", Font.PLAIN, 14));
		delInfoTxt.setColumns(15);
		
		//������ť
		seekBt = new JButton("\u641C\u7D22");
		seekBt.setBounds(360, 23, 70, 25);
		tipPan.add(seekBt);
		seekBt.setFont(new Font("����", Font.PLAIN, 14));
		seekBt.addActionListener(delActEvnt);
		
		//�����Ϣ���
		add(infoPan);
		//����Ϣ��������������
		infoPan.getPswLab().setVisible(false);
		infoPan.getPsw().setVisible(false);
		//��ѡ��ͼƬ��ť����
		infoPan.getPictureBt().setVisible(false);
		//��ѧ���ı�������Ϊ���ɱ༭
		infoPan.getIdNumTxt().setEnabled(false);
		
		//ɾ����ť
		delBt = new JButton("\u5220\u9664");
		delBt.setFont(new Font("����", Font.PLAIN, 14));
		delBt.setBounds(292, 630, 93, 23);
		add(delBt);
		delBt.addActionListener(delActEvnt);
		
		//���ð�ť
		clearBt = new JButton("\u91CD\u7F6E");
		clearBt.setFont(new Font("����", Font.PLAIN, 14));
		clearBt.setBounds(413, 630, 93, 23);
		add(clearBt);
		clearBt.addActionListener(delActEvnt);

	}
	
	
	/**======get����==================*/
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
