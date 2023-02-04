package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.userdao;
import model.model_user;
import view.viewdangki;
import view.viewdangnhap;
import view.viewquanlydoanhthuveso;

public class controllerdangnhap implements ActionListener{
	viewdangnhap view;
	

	public controllerdangnhap(viewdangnhap view) {
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cm=e.getActionCommand();
		if(cm.equals("Login"))
		{
			String username=this.view.textField_username.getText();
			String password=this.view.textField_password.getText();
			StringBuilder sb=new StringBuilder();
			if(username.equals(""))
			{
				sb.append("Username is emty \n");
			}
			if(password.equals(""))
			{
				sb.append("Password is emty\n");
			}
			if(sb.length()>0)
			{
				JOptionPane.showMessageDialog(this.view, sb.toString(),"Invalidation",JOptionPane.ERROR_MESSAGE);
				return ;
			}
			if(sb.length()==0)
			{
				model_user user=new model_user(username, password, "");
				ArrayList<model_user> list=userdao.getInstance().selectAll();
				boolean check=this.view.kiemtratkmk(user,list);
				if(check==true)
				{	
				}
				else 
				{
					JOptionPane.showMessageDialog(this.view, "Failure","Invalidation",JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
			
			
		}
		if(cm.equals("Reset"))
		{
			this.view.textField_username.setText("");
			this.view.textField_password.setText("");
		}
		if(cm.equals("Register"))
		{
			this.view.dispose();
			new viewdangki();
		}
		
	}
	

}
