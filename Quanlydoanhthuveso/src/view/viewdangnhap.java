package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.controllerdangnhap;
import dao.userdao;
import model.QLuser_model;
import model.model_user;
import model.model_veso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class viewdangnhap extends JFrame {

	private JPanel contentPane;
	public QLuser_model model;
	public JTextField textField_username;
	public JTextField textField_password;
	public JButton btnNewButton_login;
	public JButton btnNewButton_reset;
	public JCheckBox chckbxNewCheckBox_remmemberme;
	private ArrayList<model_user> list=userdao.getInstance().selectAll();
	/**
	 *;; Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewdangnhap frame = new viewdangnhap();
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
	public viewdangnhap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tri\\Downloads\\329216420_700887218176346_119472564266540292_n.png"));
		setForeground(new Color(255, 255, 255));
		this.model=new QLuser_model();
		setTitle("Login form");
		ActionListener action=new controllerdangnhap(this);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 321);
		Icon icon=new ImageIcon("/Quanlydoanhthuveso/src/lib/329216420_700887218176346_119472564266540292_n.png"); 
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login to System");
		lblNewLabel.setBounds(109, 11, 158, 22);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 369, 2);
		contentPane.add(separator);
		
		JLabel jlabel_username = new JLabel("Username:");
		jlabel_username.setFont(new Font("Arial", Font.PLAIN, 13));
		jlabel_username.setBounds(10, 81, 68, 14);
		contentPane.add(jlabel_username);
		
		JLabel lblNewLabel_password = new JLabel("Password:");
		lblNewLabel_password.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_password.setBounds(10, 118, 68, 14);
		contentPane.add(lblNewLabel_password);
		
		textField_username = new JTextField();
		textField_username.setBounds(109, 75, 242, 26);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-54, 168, 423, 2);
		contentPane.add(separator_1);
		
		textField_password = new JTextField();
		textField_password.setBounds(109, 112, 242, 26);
		contentPane.add(textField_password);
		textField_password.setColumns(10);
		
		 chckbxNewCheckBox_remmemberme = new JCheckBox("Remmember Me?");
		chckbxNewCheckBox_remmemberme.setBounds(127, 138, 152, 23);
		contentPane.add(chckbxNewCheckBox_remmemberme);
		
		 btnNewButton_login = new JButton("Login");
		btnNewButton_login.addActionListener(action);
		btnNewButton_login.setBounds(75, 190, 89, 23);
		contentPane.add(btnNewButton_login);
		
		 btnNewButton_reset = new JButton("Reset");
		 btnNewButton_reset.addActionListener(action);
		btnNewButton_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_reset.setBounds(178, 190, 89, 23);
		contentPane.add(btnNewButton_reset);
		
		JButton btnNewButton_register = new JButton("Register");
		btnNewButton_register.addActionListener(action);
		btnNewButton_register.setBounds(127, 224, 89, 23);
		contentPane.add(btnNewButton_register);
		setVisible(true);
	}
	
public void adduser(model_user user) {
	this.model.insert(user);
		
	}

	
	


	public boolean kiemtratkmk(model_user users,ArrayList<model_user> list) {
		int count=0;
		boolean check=false;
		
		for (model_user user : viewdangki.model.getDsuser()) {
			if(user.getUsername().equals(users.getUsername()))
			{
				count++;
			}
			if(user.getPassword().equals(users.getPassword()))
			{
				count++;
			}
			if(count==2)
			{
				check=true;
			}
			if(check==true)
			{
				JOptionPane.showMessageDialog(this, "Login successfully","Invalidation",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				new viewquanlydoanhthuveso();
				if(this.chckbxNewCheckBox_remmemberme.isSelected())
				{
					JOptionPane.showMessageDialog(this, "Login information is remember");
				}
				return true;
			}
		}
		return false;
		
	}
}
