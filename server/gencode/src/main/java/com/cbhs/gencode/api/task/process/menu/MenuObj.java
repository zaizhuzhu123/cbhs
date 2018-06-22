package com.cbhs.gencode.api.task.process.menu;

import java.util.List;

public class MenuObj {
	private String menuId;
	private String menuName;
	private String menuOpName;
	private String action;
	private String icon;
	private String parentMenuId;
	private List<MenuObj> chidren;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuOpName() {
		return menuOpName;
	}

	public void setMenuOpName(String menuOpName) {
		this.menuOpName = menuOpName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public List<MenuObj> getChidren() {
		return chidren;
	}

	public void setChidren(List<MenuObj> chidren) {
		this.chidren = chidren;
	}

}
