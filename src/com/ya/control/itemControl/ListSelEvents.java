package com.ya.control.itemControl;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.ya.model.daoModel.InfoSelect;
import com.ya.view.panelView.infoHandlePanelView.InfoSelectPanel;

/**
 * 
 * @author 叶雅芳
 * @date 2015-08-01
 * @desc 列表框选项事件类
 * 
 */

public class ListSelEvents implements ListSelectionListener {

	InfoSelectPanel infoSelPan; // 列表框选项事件类
	InfoSelect infoSel = new InfoSelect(); // 查询数据库信息类

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 传入列表框选项事件类对象
	 * @param infoSelectPanel
	 */
	public void setInfoSelPan(InfoSelectPanel infoSelPan) {
		this.infoSelPan = infoSelPan;
	}

	/** ==============ListSelectionListener事件处理================= */
	public void valueChanged(ListSelectionEvent e) {
		// 获取事件源
		JList source = (JList) e.getSource();

		// 获取选中选项的内容
		String idNum = (String) source.getSelectedValue();

		// 如果有选中
		if (idNum != null) {

			// 根据学号到数据库中查询信息，获得结果集
			Vector<String> vector = infoSel.selInfo(new String[] { idNum });
			if (vector.size() == 0) {
				// 如果结果集大小为0，则不是没有查询到信息，提示用户
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

				// 创建图标对象（根据图片路径）
				ImageIcon ic = new ImageIcon(vector.get(12));
				// 返回此图标的Image，并创建Image的缩放版本，返回把缩放后的图片设置为此图标显示的图片
				ic.setImage(ic.getImage().getScaledInstance(280, 267, 0));
				// 显示图片
				infoSelPan.getPictureLab().setIcon(ic);

			}

		}
	}

}
