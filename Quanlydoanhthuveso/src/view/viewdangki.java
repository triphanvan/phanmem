package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.controllerdangki;
import controller.controllerdangnhap;
import dao.userdao;
import model.QLuser_model;
import model.model_user;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Color;

public class viewdangki extends JFrame {

	private JPanel contentPane;
	public static QLuser_model model=new QLuser_model();
	public JTextField textField_username;
	public JTextField textField_password;
	public JTextField textField_name;
	private ArrayList<model_user> list=userdao.getInstance().selectAll();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewdangki frame = new viewdangki();
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
	public viewdangki() {
		this.model=new QLuser_model();
		setAlwaysOnTop(true);
		setForeground(Color.WHITE);
		ActionListener action=new controllerdangki(this);
		setTitle("Sign up form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jlabel_username = new JLabel("Username:");
		jlabel_username.setFont(new Font("Arial", Font.PLAIN, 13));
		jlabel_username.setBounds(10, 27, 68, 14);
		contentPane.add(jlabel_username);
		
		textField_username = new JTextField();
		textField_username.setColumns(10);
		textField_username.setBounds(98, 21, 242, 26);
		contentPane.add(textField_username);
		
		JLabel lblNewLabel_password = new JLabel("Password:");
		lblNewLabel_password.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_password.setBounds(10, 74, 68, 14);
		contentPane.add(lblNewLabel_password);
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(98, 71, 242, 26);
		contentPane.add(textField_password);
		
		JLabel lblNewLabel_hovaten = new JLabel("Name:");
		lblNewLabel_hovaten.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_hovaten.setBounds(10, 122, 68, 14);
		contentPane.add(lblNewLabel_hovaten);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(98, 119, 242, 26);
		contentPane.add(textField_name);
		
		JButton btnNewButton_signup = new JButton("Sign up");
		btnNewButton_signup.addActionListener(action);
		btnNewButton_signup.setBounds(98, 170, 89, 23);
		contentPane.add(btnNewButton_signup);
		
		JButton btnNewButton_cancel = new JButton("Cancel");
		btnNewButton_cancel.addActionListener(action);
		btnNewButton_cancel.setBounds(230, 170, 89, 23);
		contentPane.add(btnNewButton_cancel);
		this.setVisible(true);
	}

	public void adduser(model_user user) {
		model.insert(user);
		
	}
}
