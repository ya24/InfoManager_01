package com.ya.control.mainControl;

import java.awt.EventQueue;

import com.ya.view.frameView.loginFrameView.LoginView;


/**
 * 此系统为爪哇部落信息管理系统
 * @author 叶雅芳
 * @date 2015-07-30
 * @version 1.0
 * @desc 信息管理系统主类，启动登录界面
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
