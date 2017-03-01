package com.ya.control.actionControl.mainFrmActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.ya.view.frameView.loginFrameView.LoginView;
import com.ya.view.frameView.mainFrameView.InfoManagerView;

/**
 * 
 * @author 叶雅芳
 * @date 2015-07-31
 * @desc 信息管理系统主界面动作事件类，处理信息管理系统主界面菜单触发的动作事件
 * 
 */

public class InfoManagerActEvents implements ActionListener {

	InfoManagerView managerView;// 信息管理系统主界面设计类

	/**
	 * @author 叶雅芳
	 * @date 2015-07-31
	 * @desc 传入信息管理系统主界面设计类对象
	 * @param managerView
	 */
	public void setManagerView(InfoManagerView managerView) {
		this.managerView = managerView;
	}

	/** ============ActionListener事件处理========================= */
	public void actionPerformed(ActionEvent e) {
		// 获取事件源
		JMenuItem source = (JMenuItem) e.getSource();

		/* ===================修改密码菜单项============================= */
		if (managerView.getUpdPswMi().equals(source)) {
			updPswMiHandle();
		}

		/* ====================退出菜单项========================================= */
		else if (managerView.getExitMi().equals(source)) {
			managerView.dispose(); // 释放信息管理系统主界面
			new LoginView().setVisible(true); // 显示登录界面
		}

		/* =====================主页面菜单项======================================= */
		else if (managerView.getThemeMi().equals(source)) {
			// 更改信息管理系统主界面大小
			managerView.setBounds(350, 100, 620, 520);
			// 显示主页面面板
			managerView.getCard().show(managerView.getCardPan(), "n");
		}

		/* ===================查询信息菜单项====================================== */
		else if (managerView.getSelInfoMi().equals(source)) {
			selInfoMiHandle();
		}

		/* ===================添加信息菜单项====================================== */
		else if (managerView.getInsInfoMi().equals(source)) {
			insInfoMiHandle();

		}

		/* ===================修改信息菜单项====================================== */
		else if (managerView.getUpdInfoMi().equals(source)) {
			updInfoMiHandle();

		}

		/* ====================删除信息菜单项===================================== */
		else if (managerView.getDelInfoMi().equals(source)) {
			delInfoMiHandle();

		}

		/* ====================关于菜单项===================================== */
		else if (managerView.getAboutMi().equals(source)) {
			// 弹出消息对话框
			JOptionPane.showMessageDialog(managerView,
					"此为爪哇部落信息管理系统，版权属个人所有。\n\n作者：叶雅芳\n\n作者QQ：3066253051\n\n\n\n关于此产品使用中遇到的任何问题，欢迎来信咨询！", "关于",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	/**
	 * 删除信息菜单项操作处理
	 */
	private void delInfoMiHandle() {
		//更改标题
		managerView.setTitle("爪哇部落信息管理系统——删除信息");
		// 更改信息管理系统主界面大小
		managerView.setBounds(350, 5, 820, 735);
		
		// 显示删除信息面板
		managerView.getCard().show(managerView.getCardPan(), "del");
		// 清空文本
		managerView.infoDelPan.getDelInfoTxt().setText("");
		managerView.infoDelPan.infoPan.getIdNumTxt().setText("");
		managerView.infoDelPan.infoPan.getNameTxt().setText("");
		managerView.infoDelPan.infoPan.getSexCombox().setSelectedIndex(0);
		managerView.infoDelPan.infoPan.getGradeCombox().setSelectedIndex(0);
		managerView.infoDelPan.infoPan.getDeptCombox().setSelectedIndex(0);
		managerView.infoDelPan.infoPan.getMajorCombox().setSelectedIndex(0);
		managerView.infoDelPan.infoPan.getIdenCombox().setSelectedIndex(0);
		managerView.infoDelPan.infoPan.getBornTxt().setText("");
		managerView.infoDelPan.infoPan.getPhoneTxt().setText("");
		managerView.infoDelPan.infoPan.getSignatureArea().setText("");
		managerView.infoDelPan.infoPan.getAddressArea().setText("");
		managerView.infoDelPan.infoPan.getPictureLab().setIcon(null);
	}

	/**
	 * 修改信息菜单项操作处理
	 */
	private void updInfoMiHandle() {
		//更改标题
		managerView.setTitle("爪哇部落信息管理系统——修改信息");
		// 更改信息管理系统主界面大小
		managerView.setBounds(350, 5, 820, 735);
		// 显示修改信息面板
		managerView.getCard().show(managerView.getCardPan(), "upd");
		// 清空文本
		managerView.infoUpdPan.getUpdIdTxt().setText("");
		managerView.infoUpdPan.infoPan.getIdNumTxt().setText("");
		managerView.infoUpdPan.infoPan.getNameTxt().setText("");
		managerView.infoUpdPan.infoPan.getSexCombox().setSelectedIndex(0);
		managerView.infoUpdPan.infoPan.getGradeCombox().setSelectedIndex(0);
		managerView.infoUpdPan.infoPan.getDeptCombox().setSelectedIndex(0);
		managerView.infoUpdPan.infoPan.getMajorCombox().setSelectedIndex(0);
		managerView.infoUpdPan.infoPan.getIdenCombox().setSelectedIndex(0);
		managerView.infoUpdPan.infoPan.getBornTxt().setText("");
		managerView.infoUpdPan.infoPan.getPhoneTxt().setText("");
		managerView.infoUpdPan.infoPan.getSignatureArea().setText("");
		managerView.infoUpdPan.infoPan.getAddressArea().setText("");
		managerView.infoUpdPan.infoPan.getPictureLab().setIcon(null);
	}

	/**
	 * 添加信息菜单项操作处理
	 */
	private void insInfoMiHandle() {
		//更改标题
		managerView.setTitle("爪哇部落信息管理系统——添加信息");
		// 更改信息管理系统主界面大小
		managerView.setBounds(350, 10, 800, 700);
		// 显示添加信息面板
		managerView.getCard().show(managerView.getCardPan(), "ins");
		// 清空文本
		managerView.infoInsPan.infoPan.getIdNumTxt().setText("");
		managerView.infoInsPan.infoPan.getNameTxt().setText("");
		managerView.infoInsPan.infoPan.getSexCombox().setSelectedIndex(0);
		managerView.infoInsPan.infoPan.getGradeCombox().setSelectedIndex(0);
		managerView.infoInsPan.infoPan.getDeptCombox().setSelectedIndex(0);
		managerView.infoInsPan.infoPan.getMajorCombox().setSelectedIndex(0);
		managerView.infoInsPan.infoPan.getIdenCombox().setSelectedIndex(0);
		managerView.infoInsPan.infoPan.getBornTxt().setText("");
		managerView.infoInsPan.infoPan.getPhoneTxt().setText("");
		managerView.infoInsPan.infoPan.getSignatureArea().setText("");
		managerView.infoInsPan.infoPan.getAddressArea().setText("");
		managerView.infoInsPan.infoPan.getPsw().setText("");
		managerView.infoInsPan.infoPan.getPictureLab().setIcon(null);

	}

	/**
	 * 查询信息菜单项操作处理
	 */
	private void selInfoMiHandle() {
		//更改标题
		managerView.setTitle("爪哇部落信息管理系统——查询信息");
		// 更改信息管理系统主界面大小
		managerView.setBounds(350, 30, 870, 650);
		// 显示查询信息面板
		managerView.getCard().show(managerView.getCardPan(), "sel");
		// 文本内容清空
		managerView.infoSelPan.getGradeCombox().setSelectedIndex(0);
		managerView.infoSelPan.getDeptCombox().setSelectedIndex(0);
		managerView.infoSelPan.getSexCombox().setSelectedIndex(0);
		managerView.infoSelPan.getIdNumTxt2().setText("");
		managerView.infoSelPan.getNameTxt().setText("");
		managerView.infoSelPan.getIdNumTxt().setText("");
		managerView.infoSelPan.getSexTxt().setText("");
		managerView.infoSelPan.getGradeTxt().setText("");
		managerView.infoSelPan.getDeptTxt().setText("");
		managerView.infoSelPan.getMajorTxt().setText("");
		managerView.infoSelPan.getPhoneTxt().setText("");
		managerView.infoSelPan.getBornTxt().setText("");
		managerView.infoSelPan.getSignatureArea().setText("");
		managerView.infoSelPan.getAddressArea().setText("");
		managerView.infoSelPan.getPictureLab().setIcon(null);
		managerView.infoSelPan.getResultLab().setText("找到：0条记录");
		managerView.infoSelPan.getNumList().setListData(new Object[]{});

	}

	/**
	 * 修改密码菜单项操作处理
	 */
	private void updPswMiHandle() {
		//更改标题
		managerView.setTitle("爪哇部落信息管理系统——修改密码");
		// 更改信息管理系统主界面大小
		managerView.setBounds(350, 100, 620, 520);
		// 显示修改密码面板
		managerView.getCard().show(managerView.getCardPan(), "psw");
		// 文本内容要清空
		managerView.updPswPan.getIdNumTxt().setText("");
		managerView.updPswPan.getPsw().setText("");
		managerView.updPswPan.getOkPsw().setText("");

	}

}
