package com.ya.control.actionControl.infoHandleActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ya.model.daoModel.InfoSelect;
import com.ya.model.daoModel.InfoUpdate;
import com.ya.view.panelView.infoHandlePanelView.UpdatePasswordPanel;

/**
 * 
 * @author 叶雅芳
 * @date 2015-08-01
 * @desc 修改密码面板动作事件类
 * 
 */
public class UpdPswActEvents implements ActionListener {

	UpdatePasswordPanel updPswPan; // 修改密码面板设计类
	InfoUpdate infoUpd = new InfoUpdate(); // 修改数据库信息类
	InfoSelect infoSel = new InfoSelect(); // 查询数据库信息类

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 修改密码面板设计类
	 * @param updPswPan
	 */
	public void setUpdPswPan(UpdatePasswordPanel updPswPan) {
		this.updPswPan = updPswPan;
	}

	/* ============事件处理==================== */
	public void actionPerformed(ActionEvent e) {
		// 获取事件源
		JButton source = (JButton) e.getSource();

		/* ==========修改按钮=================== */
		if (source.equals(updPswPan.getUpdBt())) {
			updBtHandle();

		}

		/* ===========重置按钮========================= */
		else if (source.equals(updPswPan.getClearBt())) {
			// 文本内容清空
			updPswPan.getIdNumTxt().setText("");
			updPswPan.getPsw().setText("");
			updPswPan.getOkPsw().setText("");
		}
	}

	/**
	 * 修改按钮操作处理
	 */
	private void updBtHandle() {
		// 获取学号
		String id = updPswPan.getIdNumTxt().getText();
		// 到数据库中查询该学号是否存在
		if (infoSel.checkIdNum(new String[] { id }).size() == 0) {
			// 学号不存在
			JOptionPane.showMessageDialog(updPswPan, "该学号不存在！");
		} else {
			// 如果学号存在，获取密码
			String psw = new String(updPswPan.getPsw().getPassword());
			String okPsw = new String(updPswPan.getOkPsw().getPassword());
			// 如果密码匹配
			if (psw.equals(okPsw)) {
				// 根据学号到数据库中修改密码，并返回结果，告知用户是否修改成功，(否：修改失败，请重新输入)
				String[] values = { psw, updPswPan.getIdNumTxt().getText(), };
				if (infoUpd.updPsw(values)) {
					JOptionPane.showMessageDialog(updPswPan, "密码修改成功！");
				} else {
					JOptionPane.showMessageDialog(updPswPan,
							"密码修改失败，请确认输入的信息是否正确！");
				}
			} else {
				// 密码不匹配
				JOptionPane.showMessageDialog(updPswPan, "请准确输入您要修改的密码！");
			}
		}
	}

}
