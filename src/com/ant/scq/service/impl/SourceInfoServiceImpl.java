package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.ISourceInfoDao;
import com.ant.scq.entity.SourceInfo;
import com.ant.scq.service.ISourceInfoService;

public class SourceInfoServiceImpl implements ISourceInfoService {

	@Resource
	private ISourceInfoDao sourceInfoDao;

	public ISourceInfoDao getSourceInfoDao() {
		return this.sourceInfoDao;
	}

	public void setSourceInfoDao(ISourceInfoDao sourceInfoDao) {
		this.sourceInfoDao = sourceInfoDao;
	}

	public List<SourceInfo> getDataList(int start, int limit) {
		String hql = " SELECT T FROM SourceInfo T ";
		return this.sourceInfoDao.getDataList(hql, null, start, limit);
	}

	public List<SourceInfo> getDataListBySql(int start, int limit, String uid) {
		String hql = " SELECT T FROM SourceInfo T order by scAddDate desc";
		return this.sourceInfoDao.getDataList(hql, null, start, limit);
	}

	public boolean saveSourceInfo(SourceInfo sourceInfo) {
		return this.sourceInfoDao.save(sourceInfo) > 0 ? true : false;
	}

	public boolean updateSourceInfo(SourceInfo sourceInfo) {
		return this.sourceInfoDao.update(sourceInfo);
	}

	public boolean deleteSourceInfo(SourceInfo sourceInfo) {
		return this.sourceInfoDao.delete(sourceInfo);
	}

	public SourceInfo getSourceInfoById(int id) {
		return (SourceInfo) this.sourceInfoDao.getEntityByHql(" SELECT T FROM SourceInfo T where T.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.sourceInfoDao.getCountByHql("SELECT COUNT(*) FROM SourceInfo ", null);
	}

	public int getSourceInfoCountByName(String sourceInfoName) {
		return this.sourceInfoDao
				.getCountByHql("SELECT COUNT(*) FROM SourceInfo where sourceInfoName = '" + sourceInfoName + "'", null);
	}

	@Override
	public void saveSourceInfoList(List<SourceInfo> sourceInfoList) {
		this.sourceInfoDao.saveList(sourceInfoList);
	}

	@Override
	public List<SourceInfo> getDataListByParams(int start, int limit, SourceInfo sourceInfo) {
		return sourceInfoDao.getDataListByParams(start, limit);
	}

}