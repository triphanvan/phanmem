package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class model_veso implements Serializable{
	private String mave;
	private model_vungmien vungmien;
	private float soluong;
	private float doanhthu;
	private java.util.Date ngaythang;
	public model_veso()
	{
		
	}
	
	public model_veso(String mave, model_vungmien vungmien, float soluong, float doanhthu, Date ngaythang) {
		this.mave = mave;
		this.vungmien = vungmien;
		this.soluong = soluong;
		this.doanhthu = doanhthu;
		this.ngaythang = ngaythang;
	}

	public String getMave() {
		return mave;
	}
	public void setMave(String mave) {
		this.mave = mave;
	}
	public model_vungmien getVungmien() {
		return vungmien;
	}
	public void setVungmien(model_vungmien vungmien) {
		this.vungmien = vungmien;
	}
	public float getSoluong() {
		return soluong;
	}
	public void setSoluong(float soluong) {
		this.soluong = soluong;
	}
	public java.util.Date getNgaythang() {
		return ngaythang;
	}
	public void setNgaythang(java.util.Date ngaythang) {
		this.ngaythang = ngaythang;
	}
	
	public float getDoanhthu() {
		return doanhthu;
	}

	public void setDoanhthu(float doanhthu) {
		this.doanhthu = doanhthu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mave, ngaythang, soluong, vungmien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		model_veso other = (model_veso) obj;
		return Objects.equals(mave, other.mave) && Objects.equals(ngaythang, other.ngaythang)
				&& Float.floatToIntBits(soluong) == Float.floatToIntBits(other.soluong)
				&& Objects.equals(vungmien, other.vungmien);
	}
	@Override
	public String toString() {
		return "model_veso [mave=" + mave + ", vungmien=" + vungmien + ", soluong=" + soluong + ", ngaythang="
				+ ngaythang + "]";
	}
	
	
}
