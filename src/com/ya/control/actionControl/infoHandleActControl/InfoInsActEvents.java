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
import com.ya.view.panelView.infoHandlePanelView.InfoInsertPanel;

/**
 * 
 * @author 叶雅芳
 * @date 2015-08-01
 * @desc 添加信息面板动作事件类
 * 
 */

public class InfoInsActEvents implements ActionListener {

	InfoInsertPanel infoInsPan; // 添加信息面板设计类
	InfoUpdate infoUpd = new InfoUpdate(); // 修改数据库信息类
	InfoSelect infoSel = new InfoSelect(); // 查询数据库信息类

	JFileChooser fc;// 文件选择对话框
	String fileName;// 获取文件对话框中用户选中的文件名
	String path;// 获取文件对话框中用户选中的文件所在的路径

	String picturePath = ""; // 用户选中图片文件路径

	/**
	 * @author 叶雅芳
	 * @date 2015-08-01
	 * @desc 传入添加信息面板设计类
	 * @param infoInsPan
	 */
	public void setInfoInsPan(InfoInsertPanel infoInsPan) {
		this.infoInsPan = infoInsPan;
	}

	/** =============ActionListener动作事件处理================================== */
	public void actionPerformed(ActionEvent e) {

		// 获取事件源
		JButton source = (JButton) e.getSource();

		/* ===========选择图片按钮====================== */
		if (infoInsPan.infoPan.getPictureBt().equals(source)) {
			pictureBtHandle();

		}

		/* ==========录入按钮======================= */
		else if (infoInsPan.getAddBt().equals(source)) {
			addBtHandle();

		}

		/* ==========重置按钮======================= */
		else if (source.equals(infoInsPan.getClearBt())) {
			clearBtHandle();

		}
	}

	/**
	 * 重置按钮操作处理
	 */
	private void clearBtHandle() {
		// ============内容清空，组合框复原=============
		infoInsPan.infoPan.getIdNumTxt().setText("");
		infoInsPan.infoPan.getNameTxt().setText("");
		infoInsPan.infoPan.getSexCombox().setSelectedIndex(0);
		infoInsPan.infoPan.getGradeCombox().setSelectedIndex(0);
		infoInsPan.infoPan.getDeptCombox().setSelectedIndex(0);
		infoInsPan.infoPan.getMajorCombox().setSelectedIndex(0);
		infoInsPan.infoPan.getIdenCombox().setSelectedIndex(0);
		infoInsPan.infoPan.getBornTxt().setText("");
		infoInsPan.infoPan.getPhoneTxt().setText("");
		infoInsPan.infoPan.getSignatureArea().setText("");
		infoInsPan.infoPan.getAddressArea().setText("");
		infoInsPan.infoPan.getPsw().setText("");
		infoInsPan.infoPan.getPictureLab().setIcon(null);
	}

	/**
	 * 录入按钮操作处理
	 */
	private void addBtHandle() {
		// 获取文本内容，封装在String数组中
		String psw = new String(infoInsPan.infoPan.getPsw().getPassword());
		String id = infoInsPan.infoPan.getIdNumTxt().getText();
		String name = infoInsPan.infoPan.getNameTxt().getText();
		String sex = infoInsPan.infoPan.getInfoSex();
		String grade = infoInsPan.infoPan.getInfoGrade();
		String dept = infoInsPan.infoPan.getInfoDept();
		String major = infoInsPan.infoPan.getInfoMajor();
		String iden = infoInsPan.infoPan.getInfoIden();
		String born = infoInsPan.infoPan.getBornTxt().getText();
		String phone = infoInsPan.infoPan.getPhoneTxt().getText();
		String pSignature = infoInsPan.infoPan.getSignatureArea().getText();
		String address = infoInsPan.infoPan.getAddressArea().getText();
		// 封装信息数组
		String[] values = { psw, id, name, sex, grade, dept, major, iden,
					born, phone, pSignature, address, picturePath };

		// 某些信息不能为空
		if ("".equals(id)) {
			JOptionPane.showMessageDialog(infoInsPan, "学号不能为空");
		} else if ("".equals(psw)) {
			JOptionPane.showMessageDialog(infoInsPan, "密码不能为空");
		} else if ("".equals(name)) {
			JOptionPane.showMessageDialog(infoInsPan, "姓名不能为空");
		} else {
			// 录入信息时，需要先查询所录入的学号在数据库中是否已存在
			Vector<String> v = infoSel.directSelIdNum(new String[] {});
			// 先判断有无查询结果
			if (v.size() == 0) {
				// 无查询结果，进行数据添加
				insertInfo(values);
			}else{
				// 有查询结果，遍历得到的信息
				for(int x=0;x<v.size();x++){
					//如果信息已存在
					if(id.equals(v.get(x))){
						JOptionPane.showMessageDialog(infoInsPan, "信息录入失败，请重新操作");
						break;
					}else if(!id.equals(v.get(x))){
						//如果信息不存在，添加数据
						insertInfo(values);
						break;
					}
				}
			}
			

		}

	}

	/**
	 * @desc 将信息添加到数据库
	 * @param values
	 */
	private void insertInfo(String[] values) {
		// TODO 自动生成的方法存根
		// 将数据添加到数据库中，返回结果
		if (infoUpd.insInfo(values)) {
			JOptionPane.showMessageDialog(infoInsPan, "信息录入成功");
		} else {
			JOptionPane.showMessageDialog(infoInsPan, "信息录入失败，请重新录入");
		}
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
		int open = fc.showOpenDialog(infoInsPan);

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
			JOptionPane.showMessageDialog(infoInsPan, file1
					+ "\n找不到文件。\n请检查文件名是否正确，然后重试。", "打开",
					JOptionPane.WARNING_MESSAGE);
		} else {
			// 不为空，遍历数组
			for (int x = 0; x < strArray.length; x++) {
				// 如果文件不存在，且数组已遍历至末尾，弹出对话框提示用户
				if (!strArray[x].equals(fileName) && x == strArray.length - 1) {
					JOptionPane.showMessageDialog(infoInsPan, file1
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
			// 保存文件操作
			saveFile();
		} else {
			// 数组不为空，遍历数组
			for (int y = 0; y < strArr.length; y++) {
				// 如果有同名文件
				if (strArr[y].equals(fileName)) {
					JOptionPane.showMessageDialog(infoInsPan,
							"该文件不可用，请另选文件或更改该文件名");
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

		// 把图片显示在标签上
		ImageIcon ic = new ImageIcon(picturePath);
		// 返回此图标的Image，并创建Image的缩放版本，返回把缩放后的图片设置为此图标显示的图片
		ic.setImage(ic.getImage().getScaledInstance(330, 265, 0));
		// 显示图片
		infoInsPan.infoPan.getPictureLab().setIcon(ic);
//System.currentTimeMillis();
	}

}
