package model;

import java.util.ArrayList;

public class QLVS_model {
	public ArrayList<model_veso> dsveso;
	private String luachon;
	private String tenfile;
	public QLVS_model()
		{
			this.dsveso=new ArrayList<model_veso>();
			this.tenfile = "";
		}
	public QLVS_model(ArrayList<model_veso> dsveso, String luachon, String tenfile) {
		this.dsveso = dsveso;
		this.luachon = "";
		this.tenfile = "";
	}
	public ArrayList<model_veso> getDsveso() {
		return dsveso;
	}
	public void setDsveso(ArrayList<model_veso> dsveso) {
		this.dsveso = dsveso;
	}
	public String getLuachon() {
		return luachon;
	}
	public void setLuachon(String luachon) {
		this.luachon = luachon;
	}
	public String getTenfile() {
		return tenfile;
	}
	public void setTenfile(String tenfile) {
		this.tenfile = tenfile;
	}
	public void insert(model_veso veso)
	{
		this.dsveso.add(veso);
	}
	public void remove(model_veso veso)
	{
		this.dsveso.remove(veso);
	}
	public void update(model_veso veso)
	{
		this.dsveso.remove(veso);
		this.dsveso.add(veso);
	}
	public boolean kiemtratontai(model_veso veso)
	{
		for (model_veso model_veso : dsveso) {
			if(model_veso.getMave().equals(veso.getMave()))
			{
				return true;
			}
		}
		return false;
		
	}
	public void delete(model_veso veso) {
		this.dsveso.remove(veso);
		
	}
	

}
