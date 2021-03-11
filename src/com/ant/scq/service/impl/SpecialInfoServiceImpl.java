package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.ISpecialInfoDao;
import com.ant.scq.entity.SpecialInfo;
import com.ant.scq.service.ISpecialInfoService;

public class SpecialInfoServiceImpl implements ISpecialInfoService {

	@Resource
	private ISpecialInfoDao specialInfoDao;

	public ISpecialInfoDao getSpecialInfoDao() {
		return this.specialInfoDao;
	}

	public void setSpecialInfoDao(ISpecialInfoDao specialInfoDao) {
		this.specialInfoDao = specialInfoDao;
	}

	public List<SpecialInfo> getDataList(int start, int limit) {
		String hql = " SELECT T FROM SpecialInfo T ";
		return this.specialInfoDao.getDataList(hql, null, start, limit);
	}

	public boolean saveSpecialInfo(SpecialInfo specialInfo) {
		return this.specialInfoDao.save(specialInfo) > 0 ? true : false;
	}

	public boolean updateSpecialInfo(SpecialInfo specialInfo) {
		return this.specialInfoDao.update(specialInfo);
	}

	public boolean deleteSpecialInfo(SpecialInfo specialInfo) {
		return this.specialInfoDao.delete(specialInfo);
	}

	public SpecialInfo getSpecialInfoById(int id) {
		return (SpecialInfo) this.specialInfoDao.getEntityByHql(
				" SELECT T FROM SpecialInfo T where T.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.specialInfoDao.getCountByHql("SELECT COUNT(*) FROM SpecialInfo ",
				null);
	}

	public int getSpecialInfoCountByName(String specialInfoName) {
		return this.specialInfoDao.getCountByHql(
				"SELECT COUNT(*) FROM SpecialInfo where specialInfoName = '"
						+ specialInfoName + "'", null);
	}

	@Override
	public void saveSpecialInfoList(List<SpecialInfo> specialInfoList) {
		this.specialInfoDao.saveList(specialInfoList);
	}

	@Override
	public List<SpecialInfo> getAllSpecialInfoByLevel(String level) {
		String hql = " SELECT M FROM SpecialInfo M where M.menuLevel = " + level;
		return specialInfoDao.getFullDataList(hql, null);
	}

	@Override
	public SpecialInfo getSpecialInfoByIdMenuNumber(String menuNumber) {
		return (SpecialInfo) this.specialInfoDao.getEntityByHql(
				" SELECT T FROM SpecialInfo T where T.menuNumber = ? ",
				new Object[] { menuNumber });
	}

}