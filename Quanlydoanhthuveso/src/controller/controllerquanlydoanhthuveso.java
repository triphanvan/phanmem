package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewquanlydoanhthuveso;

public class controllerquanlydoanhthuveso implements ActionListener{
	viewquanlydoanhthuveso view;
	public controllerquanlydoanhthuveso(viewquanlydoanhthuveso view) {
		
		this.view = view;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String cm=e.getActionCommand();
		if(cm.equals("Them"))
		{
			this.view.xoaform();
		}else if(cm.equals("Luu"))
		{
			this.view.kiemtra();
			this.view.thuchienthemveso();
		}else if(cm.equals("Cap nhat"))
		{
			this.view.hienthithongtindachon();
		}else if(cm.equals("Xoa"))
		{
			this.view.thuchienxoa();
		}else if(cm.equals("Huy bo"))
		{
			this.view.xoaform();
		}else if(cm.equals("Tim"))
		{
			this.view.thuchientim();
		}else if(cm.equals("Huy Tim"))
		{
			this.view.huytim();
		}else if(cm.equals("About Me"))
		{
			this.view.hienthiabout();
		}else if(cm.equals("Exit"))
		{
			this.view.thoatkhoichuongtrinh();
		}else if(cm.equals("Save"))
		{
			this.view.thuchiensave();
		}else if(cm.equals("Open"))
		{
			this.view.thuchienopen();
		}
		
	}
	

}
