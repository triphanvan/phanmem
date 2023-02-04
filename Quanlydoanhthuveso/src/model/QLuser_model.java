package model;

import java.util.ArrayList;

public class QLuser_model {
	public ArrayList<model_user> dsuser;
	public QLuser_model(ArrayList<model_user> dsuser) {
		this.dsuser = dsuser;
	}
	public QLuser_model() {
		this.dsuser = new ArrayList<model_user>();
	}
	public void insert(model_user user)
	{
		this.dsuser.add(user);
	}
	public void remove(model_user user)
	{
		this.dsuser.remove(user);
	}
	public ArrayList<model_user> getDsuser() {		
		return dsuser;
	}
	public void setDsuser(ArrayList<model_user> dsuser) {
		this.dsuser = dsuser;
	}
	

}
