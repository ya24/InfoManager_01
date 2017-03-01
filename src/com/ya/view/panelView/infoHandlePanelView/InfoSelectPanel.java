package com.ya.view.panelView.infoHandlePanelView;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;

import com.ya.control.actionControl.infoHandleActControl.InfoSelActEvents;
import com.ya.control.itemControl.ListSelEvents;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-07-30
 * @desc ��ѯ��Ϣ�������࣬ʵ��ItemListener��������Ͽ򣬻�ȡ��Ͽ���ѡ��ѡ����ı�����
 * 
 */

public class InfoSelectPanel extends JPanel implements ItemListener {

	public InfoSelActEvents selActEvnt = new InfoSelActEvents(); // ��ѯ��Ϣ��嶯���¼���
	public ListSelEvents lsSelEvnt = new ListSelEvents(); // �б��ѡ���¼���

	// ������ѧ�š�ϵ�𡢳������ڡ��Ա��꼶��רҵ����ϵ��ʽ�ı���
	private JTextField nameTxt, idNumTxt, deptTxt, bornTxt, sexTxt, gradeTxt,
			majorTxt, phoneTxt;
	// ��ѯ��������е��꼶��ϵ���Ա���Ͽ�
	private JComboBox gradeCombox, deptCombox, sexCombox;
	// ��ѯ��������еķ����Һ͸���ѧ�Ų��Ұ�ť
	private JButton bigSelectBt, minSelectBt;
	// ��ѯ��������еĸ���ѧ�Ų����ı���
	private JTextField idNumTxt2;
	// ѧ�Ź�������
	private JScrollPane scrollPane;
	// ѧ���б��
	private JList numList;
	// ��ѯ�����ʾ��ǩ
	private JLabel resultLab;
	// ����ǩ������ַ�ı���
	private JTextArea signatureArea, addressArea;
	// ��Ƭ���
	private JPanel picturePan;
	// ��Ƭ��ǩ
	private JLabel pictureLab;

	// ��ѯ��Ϣ�����Ͽ���ѡ��ѡ�������
	private String selGrade = "��һ", selDept = "��������������Ϣ����ϵ", selSex = "��";

	/**
	 * Create the panel.
	 */
	public InfoSelectPanel() {

		// ���ѯ��Ϣ��嶯���¼��ഫ����Ϣ��ѯ�����������
		selActEvnt.setInfoSelPan(this);
		// �б��ѡ���¼��ഫ����Ϣ��ѯ�����������
		lsSelEvnt.setInfoSelPan(this);

		// ��ѯ��Ϣ�����������
		setLayout(null);
		setBounds(10, 10, 860, 581);

		// ��ѯ�������
		JPanel selPan = new JPanel();
		selPan.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u64CD\u4F5C",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128,
						128, 128)));
		selPan.setBounds(10, 10, 829, 97);
		add(selPan);
		selPan.setLayout(null);

		// ��ѯ��������е��꼶��ǩ
		JLabel gradeLab1 = new JLabel("\u5E74\u7EA7");
		gradeLab1.setFont(new Font("����", Font.PLAIN, 14));
		gradeLab1.setBounds(40, 15, 40, 30);
		selPan.add(gradeLab1);

		// ��ѯ��������е��꼶��Ͽ�
		gradeCombox = new JComboBox();
		gradeCombox.setModel(new DefaultComboBoxModel(
				new String[] { "\u5927\u4E00", "\u5927\u4E8C", "\u5927\u4E09",
						"\u5927\u56DB" }));
		gradeCombox.setFont(new Font("����", Font.PLAIN, 14));
		gradeCombox.setBounds(91, 15, 61, 30);
		selPan.add(gradeCombox);
		gradeCombox.addItemListener(this);

		// ��ѯ��������е�ϵ���ǩ
		JLabel deptLab1 = new JLabel("\u7CFB\u522B");
		deptLab1.setFont(new Font("����", Font.PLAIN, 14));
		deptLab1.setBounds(180, 15, 40, 30);
		selPan.add(deptLab1);

		// ��ѯ��������е�ϵ����Ͽ�
		deptCombox = new JComboBox();
		deptCombox
				.setModel(new DefaultComboBoxModel(
						new String[] { "\u4E92\u8054\u7F51\u91D1\u878D\u4E0E\u4FE1\u606F\u5DE5\u7A0B\u7CFB" }));
		deptCombox.setFont(new Font("����", Font.PLAIN, 14));
		deptCombox.setBounds(230, 15, 181, 30);
		selPan.add(deptCombox);
		deptCombox.addItemListener(this);

		// ��ѯ��������е��Ա��ǩ
		JLabel sexLab1 = new JLabel("\u6027\u522B");
		sexLab1.setFont(new Font("����", Font.PLAIN, 14));
		sexLab1.setBounds(440, 15, 34, 30);
		selPan.add(sexLab1);

		// ��ѯ��������е��Ա���Ͽ�
		sexCombox = new JComboBox();
		sexCombox.setModel(new DefaultComboBoxModel(new String[] { "\u7537",
				"\u5973" }));
		sexCombox.setFont(new Font("����", Font.PLAIN, 14));
		sexCombox.setBounds(484, 16, 40, 29);
		selPan.add(sexCombox);
		sexCombox.addItemListener(this);

		// ��ѯ��������еĲ��Ұ�ť
		bigSelectBt = new JButton("\u6CDB\u67E5\u627E");
		bigSelectBt.setFont(new Font("����", Font.PLAIN, 14));
		bigSelectBt.setBounds(551, 15, 79, 30);
		selPan.add(bigSelectBt);
		bigSelectBt.addActionListener(selActEvnt);

		// ����ѧ�Ų��ұ�ǩ
		JLabel idNumLab2 = new JLabel("\u5B66\u53F7");
		idNumLab2.setFont(new Font("����", Font.PLAIN, 14));
		idNumLab2.setBounds(40, 55, 40, 32);
		selPan.add(idNumLab2);

		// ����ѧ�Ų����ı���
		idNumTxt2 = new JTextField();
		idNumTxt2.setBounds(91, 61, 363, 25);
		selPan.add(idNumTxt2);
		idNumTxt2.setColumns(10);

		// ����ѧ�Ų��Ұ�ť
		minSelectBt = new JButton("\u6839\u636E\u5B66\u53F7\u67E5\u627E");
		minSelectBt.setFont(new Font("����", Font.PLAIN, 14));
		minSelectBt.setBounds(484, 59, 143, 25);
		selPan.add(minSelectBt);
		minSelectBt.addActionListener(selActEvnt);

		// ��Ϣ���
		JPanel infoPan = new JPanel();
		infoPan.setBorder(new TitledBorder(null,
				"\u6210\u5458\u4FE1\u606F\u5361", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(128, 128, 128)));
		infoPan.setBounds(10, 117, 829, 454);
		add(infoPan);
		infoPan.setLayout(null);

		// ѧ�����
		JPanel numPan = new JPanel();
		numPan.setBorder(new TitledBorder(null, "\u5B66\u53F7",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		numPan.setBounds(10, 25, 146, 419);
		infoPan.add(numPan);
		numPan.setLayout(null);

		// ѧ�Ź�������
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 126, 357);
		numPan.add(scrollPane);

		// ѧ���б��
		numList = new JList();
		numList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		numList.setFont(new Font("����", Font.PLAIN, 14));
		scrollPane.setViewportView(numList);
		numList.addListSelectionListener(lsSelEvnt);

		// ��ѯ�����ʾ��ǩ
		resultLab = new JLabel("\u627E\u5230\uFF1A0\u6761\u8BB0\u5F55");
		resultLab.setHorizontalAlignment(SwingConstants.CENTER);
		resultLab.setFont(new Font("����", Font.PLAIN, 14));
		resultLab.setBounds(10, 387, 126, 22);
		numPan.add(resultLab);

		// ������Ϣ���
		JPanel personPan = new JPanel();
		personPan.setBorder(new TitledBorder(null, "\u4E2A\u4EBA\u4FE1\u606F",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		personPan.setBounds(179, 25, 640, 419);
		infoPan.add(personPan);
		personPan.setLayout(null);

		// ������ǩ
		JLabel nameLab = new JLabel("\u59D3    \u540D");
		nameLab.setFont(new Font("����", Font.PLAIN, 14));
		nameLab.setBounds(30, 33, 65, 25);
		personPan.add(nameLab);

		// ѧ�ű�ǩ
		JLabel idNubLab = new JLabel("\u5B66    \u53F7");
		idNubLab.setFont(new Font("����", Font.PLAIN, 14));
		idNubLab.setBounds(30, 76, 65, 25);
		personPan.add(idNubLab);

		// ������Ϣ ����е�ϵ���ǩ
		JLabel deptLab2 = new JLabel("\u7CFB    \u522B");
		deptLab2.setFont(new Font("����", Font.PLAIN, 14));
		deptLab2.setBounds(30, 200, 65, 25);
		personPan.add(deptLab2);

		// �������ڱ�ǩ
		JLabel bornLab = new JLabel("\u51FA\u751F\u65E5\u671F");
		bornLab.setFont(new Font("����", Font.PLAIN, 14));
		bornLab.setBounds(30, 308, 65, 25);
		personPan.add(bornLab);

		// �����ı���
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("����", Font.PLAIN, 14));
		nameTxt.setBounds(101, 33, 181, 25);
		personPan.add(nameTxt);
		nameTxt.setColumns(15);

		// ѧ���ı���
		idNumTxt = new JTextField();
		idNumTxt.setFont(new Font("����", Font.PLAIN, 14));
		idNumTxt.setBounds(101, 76, 181, 25);
		personPan.add(idNumTxt);
		idNumTxt.setColumns(15);

		// ϵ���ı���
		deptTxt = new JTextField();
		deptTxt.setFont(new Font("����", Font.PLAIN, 14));
		deptTxt.setBounds(101, 200, 181, 25);
		personPan.add(deptTxt);
		deptTxt.setColumns(15);

		// ���������ı���
		bornTxt = new JTextField();
		bornTxt.setFont(new Font("����", Font.PLAIN, 14));
		bornTxt.setBounds(101, 308, 181, 25);
		personPan.add(bornTxt);
		bornTxt.setColumns(10);

		// ������Ϣ����е��Ա��ǩ
		JLabel sexLab2 = new JLabel("\u6027    \u522B");
		sexLab2.setFont(new Font("����", Font.PLAIN, 14));
		sexLab2.setBounds(30, 120, 65, 25);
		personPan.add(sexLab2);

		// ������Ϣ����е��꼶��ǩ
		JLabel gradeLab2 = new JLabel("\u5E74    \u7EA7");
		gradeLab2.setFont(new Font("����", Font.PLAIN, 14));
		gradeLab2.setBounds(30, 160, 65, 25);
		personPan.add(gradeLab2);

		// רҵ��ǩ
		JLabel majorLab = new JLabel("\u4E13    \u4E1A");
		majorLab.setFont(new Font("����", Font.PLAIN, 14));
		majorLab.setBounds(30, 235, 65, 25);
		personPan.add(majorLab);

		// ��ϵ��ʽ��ǩ
		JLabel phoneLab = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		phoneLab.setFont(new Font("����", Font.PLAIN, 14));
		phoneLab.setBounds(30, 270, 65, 25);
		personPan.add(phoneLab);

		// �Ա��ı���
		sexTxt = new JTextField();
		sexTxt.setFont(new Font("����", Font.PLAIN, 14));
		sexTxt.setBounds(101, 119, 181, 25);
		personPan.add(sexTxt);
		sexTxt.setColumns(10);

		// �꼶�ı���
		gradeTxt = new JTextField();
		gradeTxt.setFont(new Font("����", Font.PLAIN, 14));
		gradeTxt.setBounds(101, 160, 181, 25);
		personPan.add(gradeTxt);
		gradeTxt.setColumns(10);

		// רҵ�ı���
		majorTxt = new JTextField();
		majorTxt.setFont(new Font("����", Font.PLAIN, 14));
		majorTxt.setBounds(101, 235, 181, 25);
		personPan.add(majorTxt);
		majorTxt.setColumns(15);

		// ��ϵ��ʽ�ı���
		phoneTxt = new JTextField();
		phoneTxt.setFont(new Font("����", Font.PLAIN, 14));
		phoneTxt.setBounds(101, 270, 181, 25);
		personPan.add(phoneTxt);
		phoneTxt.setColumns(15);

		// ����ǩ����ǩ
		JLabel signatureLab = new JLabel("\u4E2A\u6027\u7B7E\u540D");
		signatureLab.setFont(new Font("����", Font.PLAIN, 14));
		signatureLab.setBounds(30, 365, 65, 25);
		personPan.add(signatureLab);

		// ����ǩ���ı���
		signatureArea = new JTextArea();
		signatureArea.setBorder(UIManager.getBorder("TextField.border"));
		signatureArea.setFont(new Font("����", Font.PLAIN, 14));
		signatureArea.setBounds(101, 350, 181, 51);
		personPan.add(signatureArea);

		// ��ַ��ǩ
		JLabel addressLab = new JLabel("\u5730    \u5740");
		addressLab.setFont(new Font("����", Font.PLAIN, 14));
		addressLab.setBounds(336, 365, 65, 26);
		personPan.add(addressLab);

		// ��ַ�ı���
		addressArea = new JTextArea();
		addressArea.setBorder(UIManager.getBorder("TextField.border"));
		addressArea.setFont(new Font("����", Font.PLAIN, 14));
		addressArea.setBounds(410, 350, 219, 51);
		personPan.add(addressArea);

		// ��Ƭ���
		picturePan = new JPanel();
		picturePan.setBorder(new TitledBorder(null, "\u7167\u7247",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		picturePan.setBounds(330, 33, 300, 297);
		personPan.add(picturePan);
		picturePan.setLayout(null);

		// ��Ƭ��ǩ
		pictureLab = new JLabel("");
		pictureLab.setBounds(10, 20, 280, 267);
		picturePan.add(pictureLab);

	}

	

	/**
	 * ��Ͽ�ѡ���¼�
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {

		// ��ȡ�¼�Դ
		JComboBox source = (JComboBox) e.getSource();

		/* =============== �꼶��Ͽ�=============================== */
		if (source.equals(gradeCombox)) {
			selGrade = (String) source.getSelectedItem();
		}

		/* ==================ϵ����Ͽ�======================= */
		else if (source.equals(deptCombox)) {
			selDept = (String) source.getSelectedItem();
		}

		/* ====================�Ա���Ͽ�=========================== */
		else if (source.equals(sexCombox)) {
			selSex = (String) source.getSelectedItem();
		}
	}

	
	/** ==========get����======================= */
	public JTextField getNameTxt() {
		return nameTxt;
	}

	public JTextField getIdNumTxt() {
		return idNumTxt;
	}

	public JTextField getDeptTxt() {
		return deptTxt;
	}

	public JTextField getBornTxt() {
		return bornTxt;
	}

	public JTextField getSexTxt() {
		return sexTxt;
	}

	public JTextField getGradeTxt() {
		return gradeTxt;
	}

	public JTextField getMajorTxt() {
		return majorTxt;
	}

	public JTextField getPhoneTxt() {
		return phoneTxt;
	}

	public JComboBox getGradeCombox() {
		return gradeCombox;
	}

	public JComboBox getDeptCombox() {
		return deptCombox;
	}

	public JComboBox getSexCombox() {
		return sexCombox;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JList getNumList() {
		return numList;
	}

	public JLabel getResultLab() {
		return resultLab;
	}

	public JTextArea getSignatureArea() {
		return signatureArea;
	}

	public JTextArea getAddressArea() {
		return addressArea;
	}

	public String getSelGrade() {
		return selGrade;
	}

	public String getSelDept() {
		return selDept;
	}

	public String getSelSex() {
		return selSex;
	}

	public JLabel getPictureLab() {
		return pictureLab;
	}

	public JButton getBigSelectBt() {
		return bigSelectBt;
	}

	public JButton getMinSelectBt() {
		return minSelectBt;
	}

	public JTextField getIdNumTxt2() {
		return idNumTxt2;
	}
}
