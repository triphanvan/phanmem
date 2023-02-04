package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.userdao;
import database.jdbcutil;
import model.QLuser_model;
import model.model_user;
import view.viewdangki;
import view.viewdangnhap;
import view.viewquanlydoanhthuveso;

public class controllerdangki implements ActionListener{
	viewdangki view;
	viewdangnhap viewdangnhap;
	

	public controllerdangki(viewdangki view) {
		this.view = view;
		
	}
	


	public controllerdangki(viewdangki view, view.viewdangnhap viewdangnhap) {
		
		this.view = view;
		this.viewdangnhap = viewdangnhap;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String cm=e.getActionCommand();
		if(cm.equals("Sign up"))
		{
			String username=this.view.textField_username.getText();
			String password=this.view.textField_password.getText();
			String name=this.view.textField_name.getText();
			StringBuilder sb=new StringBuilder();
			if(username.equals(""))
			{
				sb.append("Username is emty \n");
			}
			if(password.equals(""))
			{
				sb.append("Password is emty\n");
			}
			if(name.equals(""))
			{
				sb.append("Name is emty\n");
			}
			if(sb.length()>0)
			{
				JOptionPane.showMessageDialog(this.view, sb.toString(),"Invalidation",JOptionPane.ERROR_MESSAGE);
				return ;
			}
			else 
			{
				model_user user=new model_user(username, password, name);
				this.view.adduser(user);
				userdao.getInstance().insert(user);
				JOptionPane.showMessageDialog(this.view, "Successfully","",JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		if(cm.equals("Cancel"))
		{
			this.view.dispose();
			new viewdangnhap();
		}
		
	}
	

}
