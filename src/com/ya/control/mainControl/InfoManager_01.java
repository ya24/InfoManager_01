package com.ya.control.mainControl;

import java.awt.EventQueue;

import com.ya.view.frameView.loginFrameView.LoginView;


/**
 * ��ϵͳΪצ�۲�����Ϣ����ϵͳ
 * @author Ҷ�ŷ�
 * @date 2015-07-30
 * @version 1.0
 * @desc ��Ϣ����ϵͳ���࣬������¼����
 *
 */

public class InfoManager_01 {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
