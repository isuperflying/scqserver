package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.IMenuTypeDao;
import com.ant.scq.entity.MenuType;
import com.ant.scq.service.IMenuTypeService;

public class MenuTypeServiceImpl implements IMenuTypeService {

	@Resource
	private IMenuTypeDao menuTypeDao;

	public IMenuTypeDao getMenuTypeDao() {
		return this.menuTypeDao;
	}

	public void setMenuTypeDao(IMenuTypeDao menuTypeDao) {
		this.menuTypeDao = menuTypeDao;
	}

	public List<MenuType> getDataList(int start, int limit) {
		String hql = " SELECT T FROM MenuType T ";
		return this.menuTypeDao.getDataList(hql, null, start, limit);
	}

	public boolean saveMenuType(MenuType menuType) {
		return this.menuTypeDao.save(menuType) > 0 ? true : false;
	}

	public boolean updateMenuType(MenuType menuType) {
		return this.menuTypeDao.update(menuType);
	}

	public boolean deleteMenuType(MenuType menuType) {
		return this.menuTypeDao.delete(menuType);
	}

	public MenuType getMenuTypeById(int id) {
		return (MenuType) this.menuTypeDao.getEntityByHql(
				" SELECT T FROM MenuType T where T.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.menuTypeDao.getCountByHql("SELECT COUNT(*) FROM MenuType ",
				null);
	}

	public int getMenuTypeCountByName(String menuTypeName) {
		return this.menuTypeDao.getCountByHql(
				"SELECT COUNT(*) FROM MenuType where menuTypeName = '"
						+ menuTypeName + "'", null);
	}

	@Override
	public void saveMenuTypeList(List<MenuType> menuTypeList) {
		this.menuTypeDao.saveList(menuTypeList);
	}

	@Override
	public List<MenuType> getAllMenuTypeByLevel(String level) {
		String hql = " SELECT M FROM MenuType M where M.menuLevel = " + level;
		return menuTypeDao.getFullDataList(hql, null);
	}

	@Override
	public MenuType getMenuTypeByIdMenuNumber(String menuNumber) {
		return (MenuType) this.menuTypeDao.getEntityByHql(
				" SELECT T FROM MenuType T where T.menuNumber = ? ",
				new Object[] { menuNumber });
	}

}