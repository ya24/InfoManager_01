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
 * @author Ҷ�ŷ�
 * @date 2015-08-01
 * @desc �޸���Ϣ��嶯���¼���
 * 
 */

public class InfoUpdActEvents implements ActionListener {

	public InfoUpdatePanel infoUpdPan; // �޸���Ϣ��������
	InfoSelect infoSel = new InfoSelect(); // ��ѯ���ݿ���Ϣ��
	InfoUpdate infoUpd = new InfoUpdate(); // �޸����ݿ���Ϣ��

	// ����ѧ�ŵ����ݿ��в�ѯ��õ���Ϣ����
	Vector<String> vector = null;
	
	JFileChooser fc;// �ļ�ѡ��Ի���
	String fileName;// ��ȡ�ļ��Ի������û�ѡ�е��ļ���
	String path;// ��ȡ�ļ��Ի������û�ѡ�е��ļ����ڵ�·��
	
	//ͼƬ·��
	String picturePath="";
	

	/**
	 * @author Ҷ�ŷ�
	 * @date 2015-08-01
	 * @desc �����޸���Ϣ�����������
	 * @param infoUpdPan
	 */
	public void setInfoUpdPan(InfoUpdatePanel infoUpdPan) {
		this.infoUpdPan = infoUpdPan;
	}

	/** =============ActionListener�¼�����============================ */
	public void actionPerformed(ActionEvent e) {
		// ��ȡ�¼�Դ
		JButton source = (JButton) e.getSource();

		/* ===============�޸İ�ť============================= */
		if (infoUpdPan.getSeekBt().equals(source)) {
			okBtHandle();
		}

		/* ==============ѡ��ͼƬ��ť==================================== */
		else if (infoUpdPan.infoPan.getPictureBt().equals(source)) {
			pictureBtHandle();
		}

		/* ================¼���޸İ�ť============================ */
		else if (infoUpdPan.getUpdBt().equals(source)) {
			updBtHandle();

		}

		/* ================���ð�ť================================ */
		else if (infoUpdPan.getClearBt().equals(source)) {
			clearBtHandle();
		}
	}

	/**
	 * ���ð�ť��������
	 */
	private void clearBtHandle() {
			//�ı�������ջ�ԭĬ��
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
	 * ¼���޸İ�ť��������
	 */
	private void updBtHandle() {
		// ��ȡ�ı�����
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

		// ���޸���Ϣ��װ��������
		String[] values = { id, nume, sex, grade, dept, major, iden, born,
				phone, signature, address,picturePath, id };

		// ���뵽���ݿ����޸�,�����жϣ����Ƿ��޸ĳɹ�
		if(infoUpd.updInfo(values)){
			JOptionPane.showMessageDialog(infoUpdPan, "��Ϣ�޸ĳɹ���");
		}else{
			JOptionPane.showMessageDialog(infoUpdPan, "��Ϣ�޸�ʧ�ܣ������²�����");
		}
		
	}


	/**
	 * �޸İ�ť��������(��ȡѧ�ţ������ݿ��ѯ��Ϣ�����ؽ��������ʾ����Ӧλ��)
	 */
	private void okBtHandle() {
		// ���ж�ѧ���Ƿ�Ϊ��
		if ("".equals(infoUpdPan.getUpdIdTxt().getText())) {
			// ѧ��Ϊ��
			JOptionPane.showMessageDialog(infoUpdPan, "������Ҫ�޸ĵ�ѧ�ţ�����");
		} else {
			// ��Ϊ�գ�����ѧ�ŵ����ݿ��в�ѯ��Ϣ����ý����
			String[] values = { infoUpdPan.getUpdIdTxt().getText() };
			vector = infoSel.selInfo(values);

			if (vector.size() == 0) {
				// ����������СΪ0����û�в�ѯ����Ϣ����ʾ�û�
				JOptionPane.showMessageDialog(infoUpdPan, "��ѧ�Ų�����!��ȷ�Ϻ���������!");
			} else {
				// �������Ϊ0����ʾ��ѯ��Ľ��
				showInfo();
			}
		}
	}

	/**
	 * ��ʾ��ѯ��Ľ��
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
		
		//����ͼƬ��С
		ImageIcon ic=new ImageIcon(vector.get(12));
		// ���ش�ͼ���Image��������Image�����Ű汾�����ذ����ź��ͼƬ����Ϊ��ͼ����ʾ��ͼƬ
		ic.setImage(ic.getImage().getScaledInstance(330, 265, 0));
		//��ʾͼƬ		
		infoUpdPan.infoPan.getPictureLab().setIcon(ic);	
		
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
		int open = fc.showOpenDialog(infoUpdPan);

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
			JOptionPane.showMessageDialog(infoUpdPan, file1
					+ "\n�Ҳ����ļ���\n�����ļ����Ƿ���ȷ��Ȼ�����ԡ�", "��",
					JOptionPane.WARNING_MESSAGE);
		} else {
			// ��Ϊ�գ���������
			for (int x = 0; x < strArray.length; x++) {
				// ����ļ������ڣ��������ѱ�����ĩβ�������Ի�����ʾ�û�
				if (!strArray[x].equals(fileName) && x == strArray.length - 1) {
					JOptionPane.showMessageDialog(infoUpdPan, file1
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
			//�����ļ�����
			saveFile();
		} else {
			// ���鲻Ϊ�գ���������
			for (int y = 0; y < strArr.length; y++) {
				// �����ͬ���ļ�
				if (strArr[y].equals(fileName)) {
					JOptionPane.showMessageDialog(infoUpdPan,"���ļ������ã�����ѡ�ļ�����ĸ��ļ���");
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

		//ɾ��ԭ����ͼƬ
		File file=new File(vector.get(12));
		file.delete();
		
		// ��ͼƬ��ʾ�ڱ�ǩ��
		ImageIcon ic = new ImageIcon(picturePath);
		// ���ش�ͼ���Image��������Image�����Ű汾�����ذ����ź��ͼƬ����Ϊ��ͼ����ʾ��ͼƬ
		ic.setImage(ic.getImage().getScaledInstance(330, 265, 0));
		// ��ʾͼƬ
		infoUpdPan.infoPan.getPictureLab().setIcon(ic);

	}



}
