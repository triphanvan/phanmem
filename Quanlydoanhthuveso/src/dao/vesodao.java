package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbcutil;
import model.model_veso;

public class vesodao implements DAOInterface<model_veso>{
	public static vesodao getInstance()
	{
		return new vesodao();
	}

	@Override
	public int insert(model_veso t) {
		int ketqua = 0;
		try {
			Connection con=jdbcutil.getconnection();
			Statement pst=con.createStatement();
			String sql="Insert into veso(mave,vungmien,soluong,doanhthu,ngaythang)"+
						" Values('"+t.getMave()+"','"+t.getVungmien().getTenvungmien()+"',"+t.getSoluong()+","+t.getDoanhthu()+",'"+(t.getNgaythang().getMonth()+1)+"/"+(t.getNgaythang().getDate())+"/"+(t.getNgaythang().getYear()+1900)+"')";
			
			
			System.out.println(sql);
			ketqua=pst.executeUpdate(sql);
			
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
	public int update(model_veso t) {
		int ketqua = 0;
		try {
			Connection con=jdbcutil.getconnection();
			Statement pst=con.createStatement();
			String sql="Update veso SET "+
						"vungmien='"+t.getVungmien().getTenvungmien()+"'"+
						",soluong="+t.getSoluong()+""+
						",doanhthu="+t.getDoanhthu()+""+
						",ngaythang='"+(t.getNgaythang().getMonth()+1)+"/"+(t.getNgaythang().getDate())+"/"+(t.getNgaythang().getYear()+1900)+"'"+
						" Where mave='"+t.getMave()+"'";
			
			System.out.println(sql);
			ketqua=pst.executeUpdate(sql);
			
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
	public int delete(model_veso t) {
		int ketqua = 0;
		try {
			Connection con=jdbcutil.getconnection();
			Statement pst=con.createStatement();
			String sql="DELETE FROM veso  "+
						"Where mave='"+t.getMave()+"'";
			
			System.out.println(sql);
			ketqua=pst.executeUpdate(sql);
			
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
	public ArrayList<model_veso> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public model_veso selectbyid(model_veso t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<model_veso> selectbycondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
