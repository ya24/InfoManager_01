package com.ya.control.actionControl.infoHandleActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ya.model.daoModel.InfoSelect;
import com.ya.view.panelView.infoHandlePanelView.InfoSelectPanel;

/**
 * 
 * @author 叶雅芳
 * @date 2015-08-01
 * @desc 查询信息面板动作事件类
 * 
 */
public class InfoSelActEvents implements ActionListener {

	InfoSelectPanel infoSelPan; // 信息查询面板设计类
	InfoSelect infoSel = new InfoSelect(); // 查询数据库信息类

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 信息查询面板设计类对象
	 * @param infoSelPan
	 */
	public void setInfoSelPan(InfoSelectPanel infoSelPan) {
		this.infoSelPan = infoSelPan;
	}

	
	/** ============ActionListener事件处理=================================== */
	public void actionPerformed(ActionEvent e) {

		// 获取事件源
		JButton source = (JButton) e.getSource();

		/* ===============泛查找按钮========================== */
		if (infoSelPan.getBigSelectBt().equals(source)) {
			bigSelectBtHandle();

		}

		/* ===============根据学号查找按钮============================ */
		else if (infoSelPan.getMinSelectBt().equals(source)) {
			minSelectBtHandle();

		}
	}

	/**
	 * 根据学号查找按钮操作处理
	 */
	private void minSelectBtHandle() {
		// 获取学号内容
		String idNum = infoSelPan.getIdNumTxt2().getText();
		// 如果学号内容为空
		if (idNum.equals("")) {
			JOptionPane.showMessageDialog(infoSelPan, "学号不能为空!");
		} else {
			// 根据学号，到数据库查询信息，返回结果集，显示在相应位置
			Vector<String> vector = infoSel.selInfo(new String[] { idNum });
			// 显示查询后的信息
			if (vector.size() == 0) {
				// 如果结果集大小为0，则没有查询到信息，提示用户
				JOptionPane.showMessageDialog(infoSelPan, "该学号不存在!请确认后重新输入!");
			} else {
				// 结果集不为0，将信息显示在相应位置
				infoSelPan.getNameTxt().setText(vector.get(2));
				infoSelPan.getIdNumTxt().setText(vector.get(1));
				infoSelPan.getSexTxt().setText(vector.get(3));
				infoSelPan.getGradeTxt().setText(vector.get(4));
				infoSelPan.getDeptTxt().setText(vector.get(5));
				infoSelPan.getMajorTxt().setText(vector.get(6));
				infoSelPan.getPhoneTxt().setText(vector.get(9));
				infoSelPan.getBornTxt().setText(vector.get(8).substring(0, 10));
				infoSelPan.getSignatureArea().setText(vector.get(10));
				infoSelPan.getAddressArea().setText(vector.get(11));

				// 创建图片对象（根据图片路径）
				ImageIcon ic = new ImageIcon(vector.get(12));
				// 返回此图标的Image，并创建Image的缩放版本，返回把缩放后的图片设置为此图标显示的图片
				ic.setImage(ic.getImage().getScaledInstance(280, 267, 0));
				// 显示图片
				infoSelPan.getPictureLab().setIcon(ic);

			}
		}
	}

	/**
	 * 泛查找按钮操作处理
	 */
	private void bigSelectBtHandle() {
		// 年级组合框选中选项的内容
		String selGrade = infoSelPan.getSelGrade();

		// 系别组合框选中选项的内容
		String selDept = infoSelPan.getSelDept();

		// 性别组合框选中选项的内容
		String selSex = infoSelPan.getSelSex();

		// 封装查询条件
		String[] values = { selGrade, selSex, selDept };

		// 根据三个字符串到数据库中查找，返回学号集合(Vector)，放到列表框中
		Vector<String> vector = infoSel.selIdNum(values); // 【】
		if (vector.size() == 0) {
			JOptionPane.showMessageDialog(infoSelPan, "找不到信息");
		} else {
			infoSelPan.getNumList().setListData(vector);
			infoSelPan.getResultLab().setText("找到：" + vector.size() + "条记录");
		}
	}

}
