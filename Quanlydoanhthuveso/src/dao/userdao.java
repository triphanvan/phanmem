package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbcutil;
import model.model_user;
import view.viewdangki;

public class userdao implements DAOInterface<model_user>{
	public static userdao getInstance()
	{
		return new userdao();
	}

	@Override
	public int insert(model_user user) {
		int ketqua = 0;
		try {
			Connection con=jdbcutil.getconnection();
			Statement st=con.createStatement();
			String sql="Insert into user(username,password,hovaten)"+
						" Values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getName()+"')";
			
			
			System.out.println(sql);
			ketqua=st.executeUpdate(sql);
			
			System.out.println("Ban da thuc thi "+sql);
			System.out.println("Co "+ketqua+" ket qua da thay doi");
			
			jdbcutil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return ketqua;
	}

	@Override
	public int update(model_user user) {
		int ketqua = 0;
		try {
			ketqua = 0;
			Connection con=jdbcutil.getconnection();
			String sql="Update user "+
						"SET "+
						"password=?"+
						",hovaten=?"+
						"WHERE username=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getName());
			
			System.out.println(sql);
			ketqua=pst.executeUpdate(sql);
			
			System.out.println("Ban da thuc thi "+sql);
			System.out.println("Co"+ketqua+"da thay doi");
			
			jdbcutil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return ketqua;
	}

	@Override
	public int delete(model_user user) {
		int ketqua = 0;
		try {
			ketqua = 0;
			Connection con=jdbcutil.getconnection();
			String sql="DELETE FROM user "+
						"WHERE username=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			
			System.out.println(sql);
			ketqua=pst.executeUpdate(sql);
			
			System.out.println("Ban da thuc thi "+sql);
			System.out.println("Co"+ketqua+"da thay doi");
			
			jdbcutil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return ketqua;
	}

	@Override
	public ArrayList<model_user> selectAll() {
		ArrayList<model_user> ketqua=new ArrayList<model_user>();
		try {
			
			Connection con=jdbcutil.getconnection();
			Statement st=con.createStatement();
			
			String sql="SELECT * FROM user";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				String username=rs.getString("username");
				String password=rs.getString("password");
				String hovaten=rs.getString("hovaten");
				model_user user=new model_user(sql, password, hovaten);
				ketqua.add(user);
				viewdangki.model.insert(user);
		
			}
			
			jdbcutil.closeConnection(con);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketqua;
	}
	

	@Override
	public model_user selectbyid(model_user t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<model_user> selectbycondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
