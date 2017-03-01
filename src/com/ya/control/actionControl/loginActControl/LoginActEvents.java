package com.ya.control.actionControl.loginActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ya.model.daoModel.InfoSelect;
import com.ya.view.frameView.loginFrameView.LoginView;
import com.ya.view.frameView.mainFrameView.InfoManagerView;

/**
 * 
 * @author 叶雅芳
 * @date 2015-07-31
 * @desc 登录界面动作事件类
 * 
 */

public class LoginActEvents implements ActionListener {

	LoginView lgView; // 登录界面设计类
	InfoSelect infoSel = new InfoSelect(); // 查询数据库信息类
	String user="";	//使用者

	/**
	 * @author 叶雅芳
	 * @date 2015-07-31
	 * @desc 传入登录界面设计类对象
	 * @param loginView
	 */
	public void setLgView(LoginView lgView) {
		this.lgView = lgView;
	}

	/** ============ActionListener事件处理=================== */
	public void actionPerformed(ActionEvent e) {
		// 获取事件源
		JButton source = (JButton) e.getSource();

		/* ==============登录界面登录按钮========================== */
		if (lgView.getLoginBt().equals(source)) {

			login();

		}
		/* ==============登录界面重置按钮========================== */
		else if (lgView.getClearBt().equals(source)) {
			// 将文本框清空
			lgView.getIdTxt().setText("");
			lgView.getPsw().setText("");
			// 组合框复原为默认选中
			lgView.getIdComBox().setSelectedIndex(0);
		}
	}

	
	
	/**
	 *  登录操作处理
	 */
	private void login() {
		// 获取学号
		String id = lgView.getIdTxt().getText();
		// 获取密码
		String psw = new String(lgView.getPsw().getPassword());
		//获取身份
		String iden=lgView.getLgIdentity();

		// 因学号不能为空，故先判断
		if ("".equals(id)) {
			JOptionPane.showMessageDialog(lgView, "学号不能为空");
		}else if(id.length()!=9){
			JOptionPane.showMessageDialog(lgView, "请正确输入学号");
		}
		// 学号不为空
		else if(!"".equals(id)){
			// 根据学号查询信息，返回一个结果集
			String[] values={id};
			Vector<String> vector = infoSel.selLoginInfo(values);
			user=vector.get(3);
			if (vector.size() == 0) {
				//如果结果集为空，则表示信息不存在
				JOptionPane.showMessageDialog(lgView, "信息不存在");
			} else {
				// 结果集不为空，判断学号、密码、身份是否与数据库中的数据匹配
				if (id.equals(vector.get(0)) && psw.equals(vector.get(1))
						&& iden.equals(vector.get(2))) {
					// 匹配，显示信息管理系统主界面，释放登陆界面
					lgView.dispose();
					InfoManagerView managerView = new InfoManagerView();
					managerView.setVisible(true);
					managerView.getMessageLab().setText(user+"!欢迎您！");
					//如果登录的是管理员，修改密码，增删改等菜单可编辑
					if("管理员".equals(iden)){
						managerView.getUpdPswMi().setEnabled(true);
						managerView.getInsInfoMi().setEnabled(true);
						managerView.getDelInfoMi().setEnabled(true);
						managerView.getUpdInfoMi().setEnabled(true);
					}
				} else {
					// 不匹配，提示用户，并清空文本框，组合框复原为默认选中
					JOptionPane.showMessageDialog(lgView, "您的信息有误！请重新输入");
					lgView.getIdTxt().setText("");
					lgView.getPsw().setText("");
					lgView.getIdComBox().setSelectedIndex(0);
				}
			}
		}
	}

}
