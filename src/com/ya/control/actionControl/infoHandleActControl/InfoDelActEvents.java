package com.ya.control.actionControl.infoHandleActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ya.model.daoModel.InfoSelect;
import com.ya.model.daoModel.InfoUpdate;
import com.ya.view.panelView.infoHandlePanelView.InfoDelPanel;

/**
 * 
 * @author 叶雅芳
 * @date 2015-08-01
 * @desc 删除信息面板动作事件类
 * 
 */
public class InfoDelActEvents implements ActionListener {

	InfoDelPanel infoDelPan;// 删除信息面板设计类

	InfoSelect infoSel = new InfoSelect(); // 查询数据库信息类
	InfoUpdate infoUpd = new InfoUpdate(); // 修改数据库信息类

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 删除信息面板设计类
	 * @param infoDelPan
	 */
	public void setInfoDelPan(InfoDelPanel infoDelPan) {
		this.infoDelPan = infoDelPan;
	}

	/** =============ActionListener事件处理========================== */
	public void actionPerformed(ActionEvent e) {
		// 获取事件源
		JButton source = (JButton) e.getSource();

		/* ===============确定按钮============================= */
		if (source.equals(infoDelPan.getSeekBt())) {
			okBtHandle();

		}

		/* ================删除按钮============================ */
		else if (source.equals(infoDelPan.getDelBt())) {
			delBtHandle();
		}

		/* ================重置按钮================================ */
		else if (source.equals(infoDelPan.getClearBt())) {
			clearBtHandle();

		}
	}

	/**
	 * 重置按钮操作
	 */
	private void clearBtHandle() {
		infoDelPan.getDelInfoTxt().setText("");
		infoDelPan.infoPan.getIdNumTxt().setText("");
		infoDelPan.infoPan.getNameTxt().setText("");
		infoDelPan.infoPan.getSexCombox().setSelectedIndex(0);
		infoDelPan.infoPan.getGradeCombox().setSelectedIndex(0);
		infoDelPan.infoPan.getDeptCombox().setSelectedIndex(0);
		infoDelPan.infoPan.getMajorCombox().setSelectedIndex(0);
		infoDelPan.infoPan.getIdenCombox().setSelectedIndex(0);
		infoDelPan.infoPan.getBornTxt().setText("");
		infoDelPan.infoPan.getPhoneTxt().setText("");
		infoDelPan.infoPan.getSignatureArea().setText("");
		infoDelPan.infoPan.getAddressArea().setText("");
		infoDelPan.infoPan.getPictureLab().setIcon(null);
	}

	/**
	 * 删除按钮操作处理
	 */
	private void delBtHandle() {
		// 弹出对话框，询问用户是否删除
		int type = JOptionPane.showConfirmDialog(infoDelPan, "确定要删除该成员的基本信息吗",
				"删除", JOptionPane.YES_NO_OPTION);

		if (type == JOptionPane.YES_OPTION) {
			// 如果点击是，则删除信息
			// 获取学号，到数据库中删除,加入判断，看是否删除成功
			if (infoUpd.delInfo(new String[] { infoDelPan.infoPan.getIdNumTxt()
					.getText() })) {
				JOptionPane.showMessageDialog(infoDelPan, "信息删除成功！");
				//文本清空
				clearBtHandle();
			} else {
				JOptionPane.showMessageDialog(infoDelPan, "信息删除失败，请重新操作！");
			}
		}
	}

	/**
	 * 确定按钮操作处理
	 */
	private void okBtHandle() {
		// 先判断学号是否为空
		if ("".equals(infoDelPan.getDelInfoTxt().getText())) {
			// 学号为空
			JOptionPane.showMessageDialog(infoDelPan, "请输入要删除的学号！！！");
		} else {
			// 不为空，根据学号到数据库中查询信息，获得结果集
			Vector<String> vector = infoSel.selInfo(new String[] { infoDelPan
					.getDelInfoTxt().getText() });

			if (vector.size() == 0) {
				// 如果结果集大小为0，则没有查询到信息，提示用户
				JOptionPane.showMessageDialog(infoDelPan, "该学号不存在!请确认后再输入!");
			} else {
				// 结果集不为0，将信息显示在相应位置
				infoDelPan.infoPan.getIdNumTxt().setText( vector.get(1));
				infoDelPan.infoPan.getNameTxt().setText(vector.get(2));
				infoDelPan.infoPan.getSexCombox().setSelectedItem(vector.get(3));
				infoDelPan.infoPan.getGradeCombox().setSelectedItem(vector.get(4));
				infoDelPan.infoPan.getDeptCombox().setSelectedItem(vector.get(5));
				infoDelPan.infoPan.getMajorCombox().setSelectedItem(vector.get(6));
				infoDelPan.infoPan.getIdenCombox().setSelectedItem(vector.get(7));
				infoDelPan.infoPan.getBornTxt().setText( vector.get(8).substring(0, 10));
				infoDelPan.infoPan.getPhoneTxt().setText( vector.get(9));
				infoDelPan.infoPan.getSignatureArea().setText(vector.get(10));
				infoDelPan.infoPan.getAddressArea().setText(vector.get(11));

				//创建图片大小（根据路径）
				ImageIcon ic=new ImageIcon(vector.get(12));
				// 返回此图标的Image，并创建Image的缩放版本，返回把缩放后的图片设置为此图标显示的图片
				ic.setImage(ic.getImage().getScaledInstance(330, 265, 0));
				// 显示图片
				infoDelPan.infoPan.getPictureLab().setIcon(ic);
	
			}
		}
	}
}
