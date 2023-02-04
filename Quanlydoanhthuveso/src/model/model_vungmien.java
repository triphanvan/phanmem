package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class model_vungmien implements Serializable{
	private int vungmien;
	private String tenvungmien;
	public model_vungmien(int vungmien, String tenvungmien) {
		this.vungmien = vungmien;
		this.tenvungmien = tenvungmien;
	}
	public int getVungmien() {
		return vungmien;
	}
	public void setVungmien(int vungmien) {
		this.vungmien = vungmien;
	}
	public String getTenvungmien() {
		return tenvungmien;
	}
	public void setTenvungmien(String tenvungmien) {
		this.tenvungmien = tenvungmien;
	}
	@Override
	public String toString() {
		return "model_vungmien [vungmien=" + vungmien + ", tenvungmien=" + tenvungmien + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(tenvungmien, vungmien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		model_vungmien other = (model_vungmien) obj;
		return Objects.equals(tenvungmien, other.tenvungmien) && vungmien == other.vungmien;
	}
	public static ArrayList<model_vungmien>  getdsvungmien()
	{
		String[] arrayvungmien={
					"Bac",
					"Trung",
					"Nam"
			};
		ArrayList<model_vungmien> dsvungmien=new ArrayList<model_vungmien>();
		int i=0;
		for (String tenvungmien : arrayvungmien) {
			model_vungmien t=new model_vungmien(i, tenvungmien);
			dsvungmien.add(t);
		}
		return dsvungmien;
	}
	public static model_vungmien getvungmienbiID(int i) {
		return model_vungmien.getdsvungmien().get(i);
	}
	public static model_vungmien getvungmienbyTen(String tentinh) {
		ArrayList<model_vungmien> list=model_vungmien.getdsvungmien();
		for (model_vungmien vungmien : list) {
			if(vungmien.getTenvungmien().equals(tentinh))
			{
				return vungmien;
			}
		}
		return null;
	}
	

}
