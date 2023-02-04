package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

import controller.controllerquanlydoanhthuveso;
import dao.vesodao;
import model.QLVS_model;
import model.QLuser_model;
import model.model_veso;
import model.model_vungmien;

public class viewquanlydoanhthuveso extends JFrame {

	private JPanel contentPane;
	private JTextField textField_mavetimkiem;
	public JTable table;
	public JTextField textField_mave;
	public JTextField textField_soluong;
	public JTextField textField_doanhthu;
	public JTextField textField_ngaythang;
	public JComboBox comboBox_vungmientimkiem;
	public JComboBox comboBox_vungmien;
	public static QLVS_model model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewquanlydoanhthuveso frame = new viewquanlydoanhthuveso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewquanlydoanhthuveso() {
		this.model=new QLVS_model();
		ActionListener action=new controllerquanlydoanhthuveso(this);
		setTitle("Quan ly doanh thu ve so");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 871);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 8, 814, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_File = new JMenu("File");
		menuBar.add(mnNewMenu_File);
		mnNewMenu_File.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JMenuItem mntmNewMenuItem_Open = new JMenuItem("Open");
		mntmNewMenuItem_Open.addActionListener(action);
		mnNewMenu_File.add(mntmNewMenuItem_Open);
		
		JMenuItem mntmNewMenuItem_Save = new JMenuItem("Save");
		mntmNewMenuItem_Save.addActionListener(action);
		mnNewMenu_File.add(mntmNewMenuItem_Save);
		
		JSeparator separator = new JSeparator();
		mnNewMenu_File.add(separator);
		
		JMenuItem JMenuItem_Exit = new JMenuItem("Exit");
		JMenuItem_Exit.addActionListener(action);
		mnNewMenu_File.add(JMenuItem_Exit);
		
		JMenu mnNewMenu_About = new JMenu("About");
		mnNewMenu_About.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_About);
		
		JMenuItem mntmNewMenuItem_AboutMe = new JMenuItem("About Me");
		mntmNewMenuItem_AboutMe.addActionListener(action);
		mnNewMenu_About.add(mntmNewMenuItem_AboutMe);
		
		JLabel lblNewLabel_vungmientimkiem = new JLabel("Vung mien");
		lblNewLabel_vungmientimkiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_vungmientimkiem.setBounds(30, 41, 100, 37);
		contentPane.add(lblNewLabel_vungmientimkiem);
		
		 comboBox_vungmientimkiem = new JComboBox();
		ArrayList<model_vungmien> listvungmientimkiem=model_vungmien.getdsvungmien();
		comboBox_vungmientimkiem.addItem("");
		for (model_vungmien m : listvungmientimkiem) {
			comboBox_vungmientimkiem.addItem(m.getTenvungmien());
		}
		comboBox_vungmientimkiem.setBounds(140, 36, 158, 52);
		contentPane.add(comboBox_vungmientimkiem);
		
		JLabel lblNewLabel_mavetimkiem = new JLabel("Ma ve");
		lblNewLabel_mavetimkiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_mavetimkiem.setBounds(307, 41, 100, 37);
		contentPane.add(lblNewLabel_mavetimkiem);
		
		textField_mavetimkiem = new JTextField();
		textField_mavetimkiem.setBounds(376, 36, 158, 52);
		contentPane.add(textField_mavetimkiem);
		textField_mavetimkiem.setColumns(10);
		
		JButton btnNewButton_Tim = new JButton("Tim");
		btnNewButton_Tim.addActionListener(action);
		btnNewButton_Tim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_Tim.setBounds(570, 41, 89, 52);
		contentPane.add(btnNewButton_Tim);
		
		JButton btnNewButton_Huytim = new JButton("Huy Tim");
		btnNewButton_Huytim.addActionListener(action);
		btnNewButton_Huytim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_Huytim.setBounds(683, 41, 107, 52);
		contentPane.add(btnNewButton_Huytim);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 110, 804, 2);
		contentPane.add(separator_1);
		
		JLabel lbl_danhsachveso = new JLabel("Danh sach ve so");
		lbl_danhsachveso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_danhsachveso.setBounds(20, 123, 168, 45);
		contentPane.add(lbl_danhsachveso);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ma Ve", "Vung Mien", "So luong", "Doanh thu", "Ngay Thang"
			}
		));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 171,780, 360);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 542, 804, 2);
		contentPane.add(separator_1_1);
		
		JLabel lbl_thongtinve = new JLabel("Thong tin ve so");
		lbl_thongtinve.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_thongtinve.setBounds(10, 536, 168, 45);
		contentPane.add(lbl_thongtinve);
		
		JLabel lbl_mave = new JLabel("Ma ve");
		lbl_mave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_mave.setBounds(10, 583, 122, 45);
		contentPane.add(lbl_mave);
		
		textField_mave = new JTextField();
		textField_mave.setColumns(10);
		textField_mave.setBounds(117, 592, 136, 32);
		contentPane.add(textField_mave);
		
		JLabel lbl_soluong = new JLabel("So luong");
		lbl_soluong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_soluong.setBounds(10, 691, 122, 45);
		contentPane.add(lbl_soluong);
		
		textField_soluong = new JTextField();
		textField_soluong.setColumns(10);
		textField_soluong.setBounds(117, 699, 136, 35);
		contentPane.add(textField_soluong);
		
		JLabel lbl_vungmien = new JLabel("Vung mien");
		lbl_vungmien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_vungmien.setBounds(10, 635, 122, 45);
		contentPane.add(lbl_vungmien);
		
		 comboBox_vungmien = new JComboBox();
		ArrayList<model_vungmien> listvungmien=model_vungmien.getdsvungmien();
		comboBox_vungmien.addItem("");
		for (model_vungmien m : listvungmien) {
			comboBox_vungmien.addItem(m.getTenvungmien());
		}
		comboBox_vungmien.setBounds(117, 643, 136, 34);
		contentPane.add(comboBox_vungmien);
		
		JLabel lbl_doanhthu = new JLabel("Doanh thu");
		lbl_doanhthu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_doanhthu.setBounds(416, 583, 122, 45);
		contentPane.add(lbl_doanhthu);
		
		textField_doanhthu = new JTextField();
		textField_doanhthu.setColumns(10);
		textField_doanhthu.setBounds(523, 592, 136, 32);
		contentPane.add(textField_doanhthu);
		
		textField_ngaythang = new JTextField();
		textField_ngaythang.setColumns(10);
		textField_ngaythang.setBounds(523, 644, 136, 32);
		contentPane.add(textField_ngaythang);
		
		JLabel lbl_doanhthu_1 = new JLabel("Ngay thang");
		lbl_doanhthu_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_doanhthu_1.setBounds(416, 635, 122, 45);
		contentPane.add(lbl_doanhthu_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 747, 804, 2);
		contentPane.add(separator_1_2);
		
		JButton btnNewButton_Them = new JButton("Them");
		btnNewButton_Them.addActionListener(action);
		btnNewButton_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_Them.setBounds(10, 769, 120, 52);
		contentPane.add(btnNewButton_Them);
		
		JButton btnNewButton_Xoa = new JButton("Xoa");
		btnNewButton_Xoa.addActionListener(action);
		btnNewButton_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_Xoa.setBounds(161, 769, 120, 52);
		contentPane.add(btnNewButton_Xoa);
		
		JButton btnNewButton_Luu = new JButton("Luu");
		btnNewButton_Luu.addActionListener(action);
		btnNewButton_Luu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_Luu.setBounds(506, 769, 120, 52);
		contentPane.add(btnNewButton_Luu);
		
		JButton btnNewButton_Capnhat = new JButton("Cap nhat");
		btnNewButton_Capnhat.addActionListener(action);
		btnNewButton_Capnhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_Capnhat.setBounds(334, 769, 120, 52);
		contentPane.add(btnNewButton_Capnhat);
		
		JButton btnNewButton_huybo = new JButton("Huy bo");
		btnNewButton_huybo.addActionListener(action);
		btnNewButton_huybo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_huybo.setBounds(674, 769, 120, 52);
		contentPane.add(btnNewButton_huybo);
		
		this.setVisible(true);
	}


	public void xoaform() {
		this.textField_mave.setText("");
		this.comboBox_vungmien.setSelectedIndex(-1);
		this.textField_soluong.setText("");
		this.textField_doanhthu.setText("");
		this.textField_ngaythang.setText("");
		
	}

	public void thuchienthemveso() {
	
				String mave=this.textField_mave.getText()+"";
				int vung=this.comboBox_vungmien.getSelectedIndex()-1;
				model_vungmien vungmien=model_vungmien.getvungmienbiID(vung);
				float soluong=Float.valueOf(this.textField_soluong.getText());
				float doanhthu=Float.valueOf(this.textField_doanhthu.getText());
				
				java.util.Date ngaythang=new java.util.Date(this.textField_ngaythang.getText()+"");
				String ngaythangtext=(ngaythang.getMonth()+1)+"/"+ngaythang.getDate()+"/"+(ngaythang.getYear()+1900)+"";
				System.out.println(ngaythang.toString());
				model_veso veso=new model_veso(mave, vungmien, soluong, doanhthu, ngaythang);
				if(ngaythangtext.equals(this.textField_ngaythang.getText()+""))
				{
					this.themhoaccapnhatveso(veso);
				}
				else JOptionPane.showMessageDialog(this,"Vui long nhap dung cu phap thang/ngay/nam");
			
		
		
	}

	public void themhoaccapnhatveso(model_veso veso) {
		DefaultTableModel model_table=(DefaultTableModel) table.getModel();
		if(!this.model.kiemtratontai(veso))
		{
			try {
				this.model.insert(veso);
				this.themvesovaobang(veso);
				vesodao.getInstance().insert(veso);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this,"Vui long nhap dung cu phap");
			}
			 
		}
		else {
			this.model.update(veso);
			vesodao.getInstance().update(veso);
			int soluongdong=model_table.getRowCount();
			for (int i = 0; i < soluongdong; i++) {
				String maveso=model_table.getValueAt(i, 0)+"";
				if(maveso.equals(veso.getMave()+""))
				{
					model_table.setValueAt(veso.getMave()+"", i, 0);
					model_table.setValueAt(veso.getVungmien().getTenvungmien()+"", i, 1);
					model_table.setValueAt(veso.getSoluong()+"", i, 2);
					model_table.setValueAt(veso.getDoanhthu()+"", i, 3);
					model_table.setValueAt((veso.getNgaythang().getMonth()+1)+"/"+(veso.getNgaythang().getDate())+"/"+(veso.getNgaythang().getYear()+1900)+"", i, 4);
				}
			}
		}
		
	}

	public void themvesovaobang(model_veso veso) {
		
		DefaultTableModel model_table=(DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {veso.getMave(),veso.getVungmien().getTenvungmien(),veso.getSoluong()+"",veso.getDoanhthu()+"",(veso.getNgaythang().getMonth()+1)+"/"+(veso.getNgaythang().getDate())+"/"+(veso.getNgaythang().getYear()+1900)});
	
	
		}
	
	public model_veso getvesodangchon()
	{
		DefaultTableModel model_table=(DefaultTableModel) table.getModel();
		int i_row=table.getSelectedRow();
		String mave=model_table.getValueAt(i_row, 0)+"";
		model_vungmien vungmien=model_vungmien.getvungmienbyTen(model_table.getValueAt(i_row, 1)+"");
		float soluong=Float.valueOf(model_table.getValueAt(i_row, 2)+"");
		float doanhthu=Float.valueOf(model_table.getValueAt(i_row, 3)+"");
		String s_ngaythang=model_table.getValueAt(i_row, 4)+"";
		java.util.Date ngaythang= new java.util.Date(s_ngaythang);
		
		model_veso veso=new model_veso(mave, vungmien, soluong, doanhthu, ngaythang);
		return veso;
	}

	public void hienthithongtindachon() {
		model_veso veso=this.getvesodangchon();
		this.textField_mave.setText(veso.getMave()+"");
		this.comboBox_vungmien.setSelectedItem(veso.getVungmien().getTenvungmien()+"");
		this.textField_soluong.setText(veso.getSoluong()+"");
		this.textField_doanhthu.setText(veso.getDoanhthu()+"");
		String s_ngaysinh=(veso.getNgaythang().getMonth()+1)+"/"+(veso.getNgaythang().getDate())+"/"+(veso.getNgaythang().getYear()+1900)+"";
		this.textField_ngaythang.setText(s_ngaysinh);
			
	}

	public void thuchienxoa() {
		DefaultTableModel model_table=(DefaultTableModel) table.getModel();
		int i=table.getSelectedRow();
		int luachon=JOptionPane.showConfirmDialog(this, "Ban co chac chan muon xoa khong");
		if(luachon==JOptionPane.YES_OPTION)
		{
			model_veso veso=this.getvesodangchon();
			this.model.delete(veso);
			model_table.removeRow(i);
			vesodao.getInstance().delete(veso);
		}
		
	}
	public Date testdate(String chuoi,String mau) throws Exception
	{
		try {
			SimpleDateFormat format=new SimpleDateFormat();
			format.applyPattern(mau);
			Date d=format.parse(chuoi);
			
			return d;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new Exception();
		}
		
	}
	public void kiemtra()
	{
		String mave=this.textField_mave.getText();
		String vungmien=this.comboBox_vungmien.getSelectedItem().toString();
		String soluong=this.textField_soluong.getText();
		String doanhthu=this.textField_doanhthu.getText();
		String ngaythang=this.textField_ngaythang.getText();
		StringBuilder sb=new StringBuilder();
		if(mave.equals(""))
		{
			sb.append("Vui long nhap ma ve \n");
		}
		if(vungmien.equals(""))
		{
			sb.append("Vui long nhap vung mien \n");
		}
		if(soluong.equals(""))
		{
			sb.append("Vui long nhap so luong \n");
		}
		if(doanhthu.equals(""))
		{
			sb.append("Vui long nhap doanh thu \n");
		}
		if(ngaythang.equals(""))
		{
			sb.append("Vui long nhap ngay thang\n");
		}
		if(sb.length()>0)
		{
			JOptionPane.showMessageDialog(this, sb);
		}
		try {
			this.testdate(ngaythang, "dd/MM/yyyy");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "ngay thang phai chuan theo dd/MM/yyyy");
		}
		
	}

	public void thuchientim() {
		this.huytim();
		int vungmien=this.comboBox_vungmientimkiem.getSelectedIndex()-1;
		String maveso=this.textField_mavetimkiem.getText()+"";
		DefaultTableModel model_table=(DefaultTableModel) table.getModel();
		int soluongdong=model_table.getRowCount();
		Set<String> mavesocanxoa=new TreeSet<String>();
		if(vungmien>=0)
		{
			model_vungmien vungmiendachon=model_vungmien.getvungmienbiID(vungmien);
			for(int i=0;i<soluongdong;i++)
			{
				String tenvungmien=model_table.getValueAt(i, 1)+"";
				String tenmave=model_table.getValueAt(i, 0)+"";
				if(!tenvungmien.equals(vungmiendachon.getTenvungmien()))
				{
					mavesocanxoa.add(tenmave);
				}
			}
		}
		if(maveso.length()>0)
		{
			for(int i=0;i<soluongdong;i++)
			{
				String tenmave=model_table.getValueAt(i, 0)+"";
				if(!tenmave.equals(maveso))
				{
					mavesocanxoa.add(tenmave);
				}
			}
			}
		for (String mavecanxoa : mavesocanxoa) {
			soluongdong=model_table.getRowCount();
			for(int i=0;i<soluongdong;i++)
			{
				String mavetrongtable=model_table.getValueAt(i, 0)+"";
				if(mavetrongtable.equals(mavecanxoa+"")) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						// TODO: handle exception
					}
					break;
					
				}
			}
		}
		}
		
		
	

	public void huytim() {
		 while(true)
		 {
			 DefaultTableModel model_table=(DefaultTableModel) table.getModel();
			 int soluongdong=model_table.getRowCount();
			 if(soluongdong==0)
			 {
				 break;
			 }
			 else model_table.removeRow(0);
			 
		 }
		 for (model_veso veso : this.model.getDsveso()) {
			this.themvesovaobang(veso);
		}
		
	}

	public void hienthiabout() {
		JOptionPane.showMessageDialog(this, "Phan mem quan ly doanh thu ve so");
		
	}

	public void thoatkhoichuongtrinh() {
		int luachon=JOptionPane.showConfirmDialog(this, "Ban co chac chan muon thoat khoi chuong trinh","Exit",JOptionPane.YES_NO_OPTION);
		if(luachon==JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
		
	}
	private void savefile(String tenfile) {
		try {
			this.model.setTenfile(tenfile);
			FileOutputStream fos=new FileOutputStream(tenfile);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			for (model_veso veso : this.model.getDsveso()) {
				oos.writeObject(veso);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void thuchiensave() {
		if(this.model.getTenfile().length()>0)
		{
			savefile(this.model.getTenfile());
		}
		else {
			JFileChooser fc=new JFileChooser();
			int returnval=fc.showSaveDialog(this);
			if(returnval==fc.APPROVE_OPTION)
			{
				File file=fc.getSelectedFile();
				savefile(file.getAbsolutePath());
			}
		}
		
	}
	private void openfile(File file) {
		ArrayList<model_veso> ds=new ArrayList<model_veso>();
		try {
			this.model.setTenfile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			model_veso veso=null;
			try {
				while((veso=(model_veso) ois.readObject())!=null)
				{
					ds.add(veso);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.model.setDsveso(ds);
		
		
	
	}

	public void thuchienopen() {
		JFileChooser fc=new JFileChooser();
		int returnval=fc.showOpenDialog(fc);
		if(returnval==fc.APPROVE_OPTION)
		{
			File file=fc.getSelectedFile();
			openfile(file);
			huytim();
		}
		
	}
	
}
