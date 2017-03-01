package com.ya.control.actionControl.infoHandleActControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ya.model.daoModel.InfoSelect;
import com.ya.model.daoModel.InfoUpdate;
import com.ya.view.panelView.infoHandlePanelView.InfoUpdatePanel;

/**
 * 
 * @author 叶雅芳
 * @date 2015-08-01
 * @desc 修改信息面板动作事件类
 * 
 */

public class InfoUpdActEvents implements ActionListener {

	public InfoUpdatePanel infoUpdPan; // 修改信息面板设计类
	InfoSelect infoSel = new InfoSelect(); // 查询数据库信息类
	InfoUpdate infoUpd = new InfoUpdate(); // 修改数据库信息类

	// 根据学号到数据库中查询获得的信息集合
	Vector<String> vector = null;
	
	JFileChooser fc;// 文件选择对话框
	String fileName;// 获取文件对话框中用户选中的文件名
	String path;// 获取文件对话框中用户选中的文件所在的路径
	
	//图片路径
	String picturePath="";
	

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 传入修改信息面板设计类对象
	 * @param infoUpdPan
	 */
	public void setInfoUpdPan(InfoUpdatePanel infoUpdPan) {
		this.infoUpdPan = infoUpdPan;
	}

	/** =============ActionListener事件处理============================ */
	public void actionPerformed(ActionEvent e) {
		// 获取事件源
		JButton source = (JButton) e.getSource();

		/* ===============修改按钮============================= */
		if (infoUpdPan.getSeekBt().equals(source)) {
			okBtHandle();
		}

		/* ==============选择图片按钮==================================== */
		else if (infoUpdPan.infoPan.getPictureBt().equals(source)) {
			pictureBtHandle();
		}

		/* ================录入修改按钮============================ */
		else if (infoUpdPan.getUpdBt().equals(source)) {
			updBtHandle();

		}

		/* ================重置按钮================================ */
		else if (infoUpdPan.getClearBt().equals(source)) {
			clearBtHandle();
		}
	}

	/**
	 * 重置按钮操作处理
	 */
	private void clearBtHandle() {
			//文本内容清空还原默认
			infoUpdPan.getUpdIdTxt().setText("");
			infoUpdPan.infoPan.getIdNumTxt().setText("");
			infoUpdPan.infoPan.getNameTxt().setText("");
			infoUpdPan.infoPan.getSexCombox().setSelectedIndex(0);
			infoUpdPan.infoPan.getGradeCombox().setSelectedIndex(0);
			infoUpdPan.infoPan.getDeptCombox().setSelectedIndex(0);
			infoUpdPan.infoPan.getMajorCombox().setSelectedIndex(0);
			infoUpdPan.infoPan.getIdenCombox().setSelectedIndex(0);
			infoUpdPan.infoPan.getBornTxt().setText("");
			infoUpdPan.infoPan.getPhoneTxt().setText("");
			infoUpdPan.infoPan.getSignatureArea().setText("");
			infoUpdPan.infoPan.getAddressArea().setText("");
			infoUpdPan.infoPan.getPictureLab().setIcon(null);

	}

	/**
	 * 录入修改按钮操作处理
	 */
	private void updBtHandle() {
		// 获取文本内容
		String id = infoUpdPan.infoPan.getIdNumTxt().getText();
		String nume = infoUpdPan.infoPan.getNameTxt().getText();
		String sex = infoUpdPan.infoPan.getInfoSex();
		String grade = infoUpdPan.infoPan.getInfoGrade();
		String dept = infoUpdPan.infoPan.getInfoDept();
		String major = infoUpdPan.infoPan.getInfoMajor();
		String iden = infoUpdPan.infoPan.getInfoIden();
		String born = infoUpdPan.infoPan.getBornTxt().getText();
		String phone = infoUpdPan.infoPan.getPhoneTxt().getText();
		String signature = infoUpdPan.infoPan.getSignatureArea().getText();
		String address = infoUpdPan.infoPan.getAddressArea().getText();

		// 将修改信息封装到数组中
		String[] values = { id, nume, sex, grade, dept, major, iden, born,
				phone, signature, address,picturePath, id };

		// 传入到数据库中修改,加入判断，看是否修改成功
		if(infoUpd.updInfo(values)){
			JOptionPane.showMessageDialog(infoUpdPan, "信息修改成功！");
		}else{
			JOptionPane.showMessageDialog(infoUpdPan, "信息修改失败，请重新操作！");
		}
		
	}


	/**
	 * 修改按钮操作处理(获取学号，到数据库查询信息，返回结果集，显示在相应位置)
	 */
	private void okBtHandle() {
		// 先判断学号是否为空
		if ("".equals(infoUpdPan.getUpdIdTxt().getText())) {
			// 学号为空
			JOptionPane.showMessageDialog(infoUpdPan, "请输入要修改的学号！！！");
		} else {
			// 不为空，根据学号到数据库中查询信息，获得结果集
			String[] values = { infoUpdPan.getUpdIdTxt().getText() };
			vector = infoSel.selInfo(values);

			if (vector.size() == 0) {
				// 如果结果集大小为0，则没有查询到信息，提示用户
				JOptionPane.showMessageDialog(infoUpdPan, "该学号不存在!请确认后重新输入!");
			} else {
				// 结果集不为0，显示查询后的结果
				showInfo();
			}
		}
	}

	/**
	 * 显示查询后的结果
	 */
	private void showInfo() {
		infoUpdPan.infoPan.getIdNumTxt().setText((String) vector.get(1));
		infoUpdPan.infoPan.getNameTxt().setText((String) vector.get(2));
		infoUpdPan.infoPan.getSexCombox().setSelectedItem(
				(String) vector.get(3));
		infoUpdPan.infoPan.getGradeCombox().setSelectedItem(
				(String) vector.get(4));
		infoUpdPan.infoPan.getDeptCombox().setSelectedItem(
				(String) vector.get(5));
		infoUpdPan.infoPan.getMajorCombox().setSelectedItem(
				(String) vector.get(6));
		infoUpdPan.infoPan.getIdenCombox().setSelectedItem(
				(String) vector.get(7));
		infoUpdPan.infoPan.getBornTxt().setText((String) vector.get(8).substring(0, 10));
		infoUpdPan.infoPan.getPhoneTxt().setText((String) vector.get(9));
		infoUpdPan.infoPan.getSignatureArea().setText((String) vector.get(10));
		infoUpdPan.infoPan.getAddressArea().setText((String) vector.get(11));
		
		//创建图片大小
		ImageIcon ic=new ImageIcon(vector.get(12));
		// 返回此图标的Image，并创建Image的缩放版本，返回把缩放后的图片设置为此图标显示的图片
		ic.setImage(ic.getImage().getScaledInstance(330, 265, 0));
		//显示图片		
		infoUpdPan.infoPan.getPictureLab().setIcon(ic);	
		
		}
	

	/**
	 * 选中图片按钮操作处理
	 */
	public void pictureBtHandle() {
		fc = new JFileChooser();// 文件选择对话框类对象
		// 文件过滤器
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPEG file", "jpg", "png", "gif");
		// 设置当前文件过滤器
		fc.setFileFilter(filter);

		// 显示打开文件选择对话框
		int open = fc.showOpenDialog(infoUpdPan);

		// 如果单击的是“确定”按钮
		if (open == JFileChooser.APPROVE_OPTION) {
			// 获取文件操作
			getFile();

		}
	}

	/**
	 * 弹出打开对话框，点击“确定”按钮时，获取文件的操作(主要判断文件是否存在)
	 */
	private void getFile() {
		fileName = fc.getSelectedFile().getName();// 获取文件对话框中用户选中的文件名
		path = fc.getCurrentDirectory().toString();// 获取文件对话框中用户选中的文件所在的路径

		// 判断用户选中的文件是否存在
		File file1 = fc.getCurrentDirectory(); // 返回当前目录
		String[] strArray = file1.list();// 获取此路径名表示的目录中的文件和目录，返回String数组

		// 如果数组为空，选中的文件一定不存在在此路径下
		if (strArray.length == 0) {
			JOptionPane.showMessageDialog(infoUpdPan, file1
					+ "\n找不到文件。\n请检查文件名是否正确，然后重试。", "打开",
					JOptionPane.WARNING_MESSAGE);
		} else {
			// 不为空，遍历数组
			for (int x = 0; x < strArray.length; x++) {
				// 如果文件不存在，且数组已遍历至末尾，弹出对话框提示用户
				if (!strArray[x].equals(fileName) && x == strArray.length - 1) {
					JOptionPane.showMessageDialog(infoUpdPan, file1
							+ "\n找不到文件。\n请检查文件名是否正确，然后重试。", "打开",
							JOptionPane.WARNING_MESSAGE);
					break;
				}

				// 如果文件存在，把他保存在项目路径下，并获取项目路径下的图片文件路径
				else if (strArray[x].equals(fileName)) {
					// 已判断所需要打开的文件存在的情况下，对文件的操作
					handleFile();
					break;
				}
			}
		}

	}

	/**
	 * 所要打开的文件已存在，对该文件做的处理（主要操作是将该文件保存在项目路径下）
	 */
	private void handleFile() {
		// 保存图片文件时，应先判断项目路径下是否存在同名文件
		File file2 = new File("picture"); // 封装项目路径下保存图片的文件夹
		String[] strArr = file2.list(); // 获取项目路径下的文件和目录，返回String数组
		// 如果数组为空，直接执行操作
		if (strArr.length == 0) {
			//保存文件操作
			saveFile();
		} else {
			// 数组不为空，遍历数组
			for (int y = 0; y < strArr.length; y++) {
				// 如果有同名文件
				if (strArr[y].equals(fileName)) {
					JOptionPane.showMessageDialog(infoUpdPan,"该文件不可用，请另选文件或更改该文件名");
					break;
				} else if (!strArr[y].equals(fileName)) {
					// 如果没有同名文件,执行保存文件操作
					saveFile();
					break;
				}
			}
		}

	}

	/**
	 * 将所要打开的文件保存到项目路径下,并在标签上显示打开的文件
	 */
	private void saveFile() {
		// 图片文件保存路径
		picturePath = "picture/" + fileName;
		// 将图片保存到项目路径下(本质是复制图片操作)
		try {
			// 封装数据源
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(path + "/" + fileName));
			// 封装目的地
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(picturePath));
			// 读写数据
			byte[] bys = new byte[bis.available()];
			int len;
			while ((len = bis.read(bys)) != -1) {
				bos.write(bys, 0, len);
			}
			// 释放资源
			bos.close();
			bis.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		//删除原来的图片
		File file=new File(vector.get(12));
		file.delete();
		
		// 把图片显示在标签上
		ImageIcon ic = new ImageIcon(picturePath);
		// 返回此图标的Image，并创建Image的缩放版本，返回把缩放后的图片设置为此图标显示的图片
		ic.setImage(ic.getImage().getScaledInstance(330, 265, 0));
		// 显示图片
		infoUpdPan.infoPan.getPictureLab().setIcon(ic);

	}



}
