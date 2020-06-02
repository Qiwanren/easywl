package com.forms.wl.action.basic.login.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {
	
    private String rid;
    private String rname;
    private Set<UserInfo> users = new HashSet<UserInfo>();
    private Set<Module> modules = new HashSet<Module>();
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Set<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(Set<UserInfo> users) {
		this.users = users;
	}
	public Set<Module> getModules() {
		return modules;
	}
	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}
	
}
