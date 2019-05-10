package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.MenuType;

public abstract interface IMenuTypeService {
	public abstract int getDataListCount();

	public abstract List<MenuType> getDataList(int start, int limit);

	public abstract MenuType getMenuTypeById(int id);

	public abstract boolean saveMenuType(MenuType menuType);

	public abstract boolean updateMenuType(MenuType menuType);

	public abstract boolean deleteMenuType(MenuType menuType);

	public abstract int getMenuTypeCountByName(String name);

	public abstract void saveMenuTypeList(List<MenuType> menuTypeList);

	public abstract List<MenuType> getAllMenuTypeByLevel(String level);
	
	public abstract MenuType getMenuTypeByIdMenuNumber(String menuNumber);
}