package com.ya.view.panelView.infoHandlePanelView;

import javax.swing.JPanel;
import javax.swing.JButton;

import com.ya.control.actionControl.infoHandleActControl.InfoInsActEvents;

import java.awt.Font;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-07-30
 * @desc �����Ϣ��������
 * 
 */

public class InfoInsertPanel extends JPanel {

	// ��Ϣ��������
	public InfoPanel infoPan = new InfoPanel();

	// �����Ϣ��嶯���¼���
	InfoInsActEvents insActEvnt = new InfoInsActEvents();

	// ¼��,�����ť
	private JButton addBt, clearBt;

	
	
	/**
	 * Create the panel.
	 * 
	 */
	public InfoInsertPanel() {

		// �������Ϣ��嶯���¼��ഫ�������Ϣ�����������
		insActEvnt.setInfoInsPan(this);

		// ��Ϣ���λ�����
		infoPan.setLocation(10, 10);
		// ��� ��Ϣ���
		add(infoPan);
		
		// �����Ϣ�����������
		setLayout(null);
		setBounds(10, 10, 780, 643);

		// ¼�밴ť
		addBt = new JButton("\u5F55\u5165");
		addBt.setFont(new Font("����", Font.PLAIN, 14));
		addBt.setBounds(237, 590, 95, 25);
		add(addBt);
		addBt.addActionListener(insActEvnt);

		// �����ť
		clearBt = new JButton("\u91CD\u7F6E");
		clearBt.setFont(new Font("����", Font.PLAIN, 14));
		clearBt.setBounds(377, 590, 95, 25);
		add(clearBt);
		clearBt.addActionListener(insActEvnt);
		
		//ѡ��ͼƬ��ť����Ӷ����¼�
		infoPan.getPictureBt().addActionListener(insActEvnt);

	}

	
	/** ===========get����============ */
	public JButton getAddBt() {
		return addBt;
	}

	public JButton getClearBt() {
		return clearBt;
	}

}
