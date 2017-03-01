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
 * @author Ҷ�ŷ�
 * @date 2015-08-01
 * @desc �����Ϣ��嶯���¼���
 * 
 */

public class InfoInsActEvents implements ActionListener {

	InfoInsertPanel infoInsPan; // �����Ϣ��������
	InfoUpdate infoUpd = new InfoUpdate(); // �޸����ݿ���Ϣ��
	InfoSelect infoSel = new InfoSelect(); // ��ѯ���ݿ���Ϣ��

	JFileChooser fc;// �ļ�ѡ��Ի���
	String fileName;// ��ȡ�ļ��Ի������û�ѡ�е��ļ���
	String path;// ��ȡ�ļ��Ի������û�ѡ�е��ļ����ڵ�·��

	String picturePath = ""; // �û�ѡ��ͼƬ�ļ�·��

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc ���������Ϣ��������
	 * @param infoInsPan
	 */
	public void setInfoInsPan(InfoInsertPanel infoInsPan) {
		this.infoInsPan = infoInsPan;
	}

	/** =============ActionListener�����¼�����================================== */
	public void actionPerformed(ActionEvent e) {

		// ��ȡ�¼�Դ
		JButton source = (JButton) e.getSource();

		/* ===========ѡ��ͼƬ��ť====================== */
		if (infoInsPan.infoPan.getPictureBt().equals(source)) {
			pictureBtHandle();

		}

		/* ==========¼�밴ť======================= */
		else if (infoInsPan.getAddBt().equals(source)) {
			addBtHandle();

		}

		/* ==========���ð�ť======================= */
		else if (source.equals(infoInsPan.getClearBt())) {
			clearBtHandle();

		}
	}

	/**
	 * ���ð�ť��������
	 */
	private void clearBtHandle() {
		// ============������գ���Ͽ�ԭ=============
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
	 * ¼�밴ť��������
	 */
	private void addBtHandle() {
		// ��ȡ�ı����ݣ���װ��String������
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
		// ��װ��Ϣ����
		String[] values = { psw, id, name, sex, grade, dept, major, iden,
					born, phone, pSignature, address, picturePath };

		// ĳЩ��Ϣ����Ϊ��
		if ("".equals(id)) {
			JOptionPane.showMessageDialog(infoInsPan, "ѧ�Ų���Ϊ��");
		} else if ("".equals(psw)) {
			JOptionPane.showMessageDialog(infoInsPan, "���벻��Ϊ��");
		} else if ("".equals(name)) {
			JOptionPane.showMessageDialog(infoInsPan, "��������Ϊ��");
		} else {
			// ¼����Ϣʱ����Ҫ�Ȳ�ѯ��¼���ѧ�������ݿ����Ƿ��Ѵ���
			Vector<String> v = infoSel.directSelIdNum(new String[] {});
			// ���ж����޲�ѯ���
			if (v.size() == 0) {
				// �޲�ѯ����������������
				insertInfo(values);
			}else{
				// �в�ѯ����������õ�����Ϣ
				for(int x=0;x<v.size();x++){
					//�����Ϣ�Ѵ���
					if(id.equals(v.get(x))){
						JOptionPane.showMessageDialog(infoInsPan, "��Ϣ¼��ʧ�ܣ������²���");
						break;
					}else if(!id.equals(v.get(x))){
						//�����Ϣ�����ڣ��������
						insertInfo(values);
						break;
					}
				}
			}
			

		}

	}

	/**
	 * @desc ����Ϣ��ӵ����ݿ�
	 * @param values
	 */
	private void insertInfo(String[] values) {
		// TODO �Զ����ɵķ������
		// ��������ӵ����ݿ��У����ؽ��
		if (infoUpd.insInfo(values)) {
			JOptionPane.showMessageDialog(infoInsPan, "��Ϣ¼��ɹ�");
		} else {
			JOptionPane.showMessageDialog(infoInsPan, "��Ϣ¼��ʧ�ܣ�������¼��");
		}
	}

	/**
	 * ѡ��ͼƬ��ť��������
	 */
	public void pictureBtHandle() {
		fc = new JFileChooser();// �ļ�ѡ��Ի��������
		// �ļ�������
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPEG file", "jpg", "png", "gif");
		// ���õ�ǰ�ļ�������
		fc.setFileFilter(filter);

		// ��ʾ���ļ�ѡ��Ի���
		int open = fc.showOpenDialog(infoInsPan);

		// ����������ǡ�ȷ������ť
		if (open == JFileChooser.APPROVE_OPTION) {
			// ��ȡ�ļ�����
			getFile();

		}
	}

	/**
	 * �����򿪶Ի��򣬵����ȷ������ťʱ����ȡ�ļ��Ĳ���(��Ҫ�ж��ļ��Ƿ����)
	 */
	private void getFile() {
		fileName = fc.getSelectedFile().getName();// ��ȡ�ļ��Ի������û�ѡ�е��ļ���
		path = fc.getCurrentDirectory().toString();// ��ȡ�ļ��Ի������û�ѡ�е��ļ����ڵ�·��

		// �ж��û�ѡ�е��ļ��Ƿ����
		File file1 = fc.getCurrentDirectory(); // ���ص�ǰĿ¼
		String[] strArray = file1.list();// ��ȡ��·������ʾ��Ŀ¼�е��ļ���Ŀ¼������String����

		// �������Ϊ�գ�ѡ�е��ļ�һ���������ڴ�·����
		if (strArray.length == 0) {
			JOptionPane.showMessageDialog(infoInsPan, file1
					+ "\n�Ҳ����ļ���\n�����ļ����Ƿ���ȷ��Ȼ�����ԡ�", "��",
					JOptionPane.WARNING_MESSAGE);
		} else {
			// ��Ϊ�գ���������
			for (int x = 0; x < strArray.length; x++) {
				// ����ļ������ڣ��������ѱ�����ĩβ�������Ի�����ʾ�û�
				if (!strArray[x].equals(fileName) && x == strArray.length - 1) {
					JOptionPane.showMessageDialog(infoInsPan, file1
							+ "\n�Ҳ����ļ���\n�����ļ����Ƿ���ȷ��Ȼ�����ԡ�", "��",
							JOptionPane.WARNING_MESSAGE);
					break;
				}

				// ����ļ����ڣ�������������Ŀ·���£�����ȡ��Ŀ·���µ�ͼƬ�ļ�·��
				else if (strArray[x].equals(fileName)) {
					// ���ж�����Ҫ�򿪵��ļ����ڵ�����£����ļ��Ĳ���
					handleFile();
					break;
				}
			}
		}

	}

	/**
	 * ��Ҫ�򿪵��ļ��Ѵ��ڣ��Ը��ļ����Ĵ�����Ҫ�����ǽ����ļ���������Ŀ·���£�
	 */
	private void handleFile() {
		// ����ͼƬ�ļ�ʱ��Ӧ���ж���Ŀ·�����Ƿ����ͬ���ļ�
		File file2 = new File("picture"); // ��װ��Ŀ·���±���ͼƬ���ļ���
		String[] strArr = file2.list(); // ��ȡ��Ŀ·���µ��ļ���Ŀ¼������String����
		// �������Ϊ�գ�ֱ��ִ�в���
		if (strArr.length == 0) {
			// �����ļ�����
			saveFile();
		} else {
			// ���鲻Ϊ�գ���������
			for (int y = 0; y < strArr.length; y++) {
				// �����ͬ���ļ�
				if (strArr[y].equals(fileName)) {
					JOptionPane.showMessageDialog(infoInsPan,
							"���ļ������ã�����ѡ�ļ�����ĸ��ļ���");
					break;
				} else if (!strArr[y].equals(fileName)) {
					// ���û��ͬ���ļ�,ִ�б����ļ�����
					saveFile();
					break;
				}
			}
		}

	}

	/**
	 * ����Ҫ�򿪵��ļ����浽��Ŀ·����,���ڱ�ǩ����ʾ�򿪵��ļ�
	 */
	private void saveFile() {
		// ͼƬ�ļ�����·��
		picturePath = "picture/" + fileName;
		// ��ͼƬ���浽��Ŀ·����(�����Ǹ���ͼƬ����)
		try {
			// ��װ����Դ
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(path + "/" + fileName));
			// ��װĿ�ĵ�
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(picturePath));
			// ��д����
			byte[] bys = new byte[bis.available()];
			int len;
			while ((len = bis.read(bys)) != -1) {
				bos.write(bys, 0, len);
			}
			// �ͷ���Դ
			bos.close();
			bis.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		// ��ͼƬ��ʾ�ڱ�ǩ��
		ImageIcon ic = new ImageIcon(picturePath);
		// ���ش�ͼ���Image��������Image�����Ű汾�����ذ����ź��ͼƬ����Ϊ��ͼ����ʾ��ͼƬ
		ic.setImage(ic.getImage().getScaledInstance(330, 265, 0));
		// ��ʾͼƬ
		infoInsPan.infoPan.getPictureLab().setIcon(ic);
//System.currentTimeMillis();
	}

}
