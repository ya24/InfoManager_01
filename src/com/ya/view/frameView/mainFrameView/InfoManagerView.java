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
 * @author Ҷ�ŷ�
 * @date 2015-07-30
 * @desc ��Ϣ����ϵͳ�����������
 * 
 */

public class InfoManagerView extends JFrame {
	
	//��Ϣ����ϵͳ�����涯���¼���
	InfoManagerActEvents managerActEvnt=new InfoManagerActEvents();	
	
	//��Ϣ�����
	public UpdatePasswordPanel updPswPan=new UpdatePasswordPanel();	//�޸�������������
	public InfoSelectPanel infoSelPan=new InfoSelectPanel();	//��ѯ��Ϣ��������
	public InfoInsertPanel infoInsPan=new InfoInsertPanel();	//�����Ϣ��������
	public InfoUpdatePanel infoUpdPan=new InfoUpdatePanel();	//�޸���Ϣ��������
	public InfoDelPanel infoDelPan=new InfoDelPanel();	//ɾ����Ϣ��������

	
	private JMenuItem updPswMi; // �޸�����˵���
	private JMenuItem exitMi;	//�˳��˵���
	private JMenuItem themeMi;	//��ҳ��˵���
	private JMenuItem selInfoMi; // ��ѯ��Ϣ�˵���
	private JMenuItem InsInfoMi; // �����Ϣ�˵���
	private JMenuItem updInfoMi; // �޸���Ϣ�˵���
	private JMenuItem delInfoMi; // ɾ����Ϣ�˵���
	private JMenuItem aboutMi; // ���ڲ˵���
	private JLabel themeLab;	//��ҳ��ͼƬ��ǩ
	private JPanel cardPan;	//��Ƭʽ���ֹ��������
	private CardLayout card;	//��Ƭʽ���ֹ����� 
	private JLabel messageLab;	//��ʾʹ���߱�ǩ
	
	
	/**
	 * Create the frame.
	 * 
	 */
	public InfoManagerView() {
		
		//����Ϣ����ϵͳ�����涯���¼��ഫ�ݱ������
		managerActEvnt.setManagerView(this);
		
		//���������������
		setResizable(false);
		setTitle("\u722A\u54C7\u90E8\u843D\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 620, 520);

		// �˵���
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// ���ò˵�
		JMenu setMn = new JMenu("\u8BBE\u7F6E");
		setMn.setFont(new Font("����", Font.PLAIN, 16));
		menuBar.add(setMn);

		// �޸�����˵���
		updPswMi = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		updPswMi.setFont(new Font("����", Font.PLAIN, 14));
		setMn.add(updPswMi);
		updPswMi.addActionListener(managerActEvnt);
		updPswMi.setEnabled(false);
		
		// �˳��˵���
		exitMi = new JMenuItem("\u9000\u51FA");
		exitMi.setFont(new Font("����", Font.PLAIN, 14));
		setMn.add(exitMi);
		exitMi.addActionListener(managerActEvnt);

		// �����˵�
		JMenu operateMn = new JMenu("\u64CD\u4F5C");
		operateMn.setFont(new Font("����", Font.PLAIN, 16));
		menuBar.add(operateMn);
		
		//��ҳ��˵���
		themeMi = new JMenuItem("\u4E3B\u9875\u9762");
		themeMi.setFont(new Font("����", Font.PLAIN, 14));
		operateMn.add(themeMi);
		themeMi.addActionListener(managerActEvnt);

		// ��ѯ��Ϣ�˵���
		selInfoMi = new JMenuItem("\u67E5\u8BE2\u6210\u5458\u4FE1\u606F");
		selInfoMi.setFont(new Font("����", Font.PLAIN, 14));
		operateMn.add(selInfoMi);
		selInfoMi.addActionListener(managerActEvnt);

		// �����Ϣ�˵���
		InsInfoMi = new JMenuItem("\u6DFB\u52A0\u6210\u5458\u4FE1\u606F");
		InsInfoMi.setFont(new Font("����", Font.PLAIN, 14));
		operateMn.add(InsInfoMi);
		InsInfoMi.addActionListener(managerActEvnt);
		InsInfoMi.setEnabled(false);

		// �޸���Ϣ�˵���
		updInfoMi = new JMenuItem("\u4FEE\u6539\u6210\u5458\u4FE1\u606F");
		updInfoMi.setFont(new Font("����", Font.PLAIN, 14));
		operateMn.add(updInfoMi);
		updInfoMi.addActionListener(managerActEvnt);
		updInfoMi.setEnabled(false);

		// ɾ����Ϣ�˵���
		delInfoMi = new JMenuItem("\u5220\u9664\u6210\u5458\u4FE1\u606F");
		delInfoMi.setFont(new Font("����", Font.PLAIN, 14));
		operateMn.add(delInfoMi);
		delInfoMi.addActionListener(managerActEvnt);
		delInfoMi.setEnabled(false);

		// �����˵�
		JMenu helpMn = new JMenu("\u5E2E\u52A9");
		helpMn.setFont(new Font("����", Font.PLAIN, 16));
		menuBar.add(helpMn);

		// ���ڲ˵���
		aboutMi = new JMenuItem("\u5173\u4E8E");
		aboutMi.setFont(new Font("����", Font.PLAIN, 14));
		helpMn.add(aboutMi);
		aboutMi.addActionListener(managerActEvnt);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		//��Ƭʽ���ֹ��������
		card=new CardLayout(0, 0);
		cardPan= new JPanel();
		getContentPane().add(cardPan, BorderLayout.CENTER);
		cardPan.setLayout(card);
		
		//���������
		JPanel pan=new  JPanel();
		cardPan.add(pan, "n");
		cardPan.add(updPswPan, "psw");
		cardPan.add(infoSelPan, "sel");
		cardPan.add(infoInsPan, "ins");
		cardPan.add(infoUpdPan, "upd");
		cardPan.add(infoDelPan, "del");
		
		//������ͼƬ��ǩ
		themeLab = new JLabel("");
		pan.add(themeLab);
		themeLab.setIcon(new ImageIcon(InfoManagerView.class.getResource("/image/\u80CC\u666F2.png")));
		
		//��ʾʹ���߱�ǩ
		messageLab = new JLabel("");
		messageLab.setForeground(new Color(0, 51, 255));
		messageLab.setFont(new Font("����", Font.PLAIN, 18));
		messageLab.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(messageLab, BorderLayout.SOUTH);
		
	}
	
	
	
	/**==========get����=============================*/
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
