package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.ISourceFieldInfoDao;
import com.ant.scq.entity.SourceFieldInfo;
import com.ant.scq.entity.UserExam;
import com.ant.scq.service.ISourceFieldInfoService;

public class SourceFieldInfoServiceImpl implements ISourceFieldInfoService {

	@Resource
	private ISourceFieldInfoDao sourceFieldInfoDao;

	public ISourceFieldInfoDao getSourceFieldInfoDao() {
		return this.sourceFieldInfoDao;
	}

	public void setSourceFieldInfoDao(ISourceFieldInfoDao sourceFieldInfoDao) {
		this.sourceFieldInfoDao = sourceFieldInfoDao;
	}

	public List<SourceFieldInfo> getDataList(int start, int limit) {
		String hql = " SELECT T FROM SourceFieldInfo T ";
		return this.sourceFieldInfoDao.getDataList(hql, null, start, limit);
	}

	public List<SourceFieldInfo> getDataListBySql(int start, int limit, String sid) {
		String hql = " SELECT T FROM SourceFieldInfo T where T.sourceInfo.id = ?";
		return this.sourceFieldInfoDao.getDataList(hql, new Object[] { sid }, start, limit);
	}

	public boolean saveSourceFieldInfo(SourceFieldInfo sourceFieldInfo) {
		return this.sourceFieldInfoDao.save(sourceFieldInfo) > 0 ? true : false;
	}

	public boolean updateSourceFieldInfo(SourceFieldInfo sourceFieldInfo) {
		return this.sourceFieldInfoDao.update(sourceFieldInfo);
	}

	public boolean deleteSourceFieldInfo(SourceFieldInfo sourceFieldInfo) {
		return this.sourceFieldInfoDao.delete(sourceFieldInfo);
	}

	public SourceFieldInfo getSourceFieldInfoById(int id) {
		return (SourceFieldInfo) this.sourceFieldInfoDao.getEntityByHql(" SELECT T FROM SourceFieldInfo T where T.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.sourceFieldInfoDao.getCountByHql("SELECT COUNT(*) FROM SourceFieldInfo ", null);
	}

	public int getSourceFieldInfoCountByName(String sourceFieldInfoName) {
		return this.sourceFieldInfoDao
				.getCountByHql("SELECT COUNT(*) FROM SourceFieldInfo where sourceFieldInfoName = '" + sourceFieldInfoName + "'", null);
	}

	@Override
	public void saveSourceFieldInfoList(List<SourceFieldInfo> sourceFieldInfoList) {
		this.sourceFieldInfoDao.saveList(sourceFieldInfoList);
	}

	@Override
	public List<SourceFieldInfo> getDataListByParams(int start, int limit, SourceFieldInfo sourceFieldInfo) {
		return sourceFieldInfoDao.getDataListByParams(start, limit);
	}

	@Override
	public List<SourceFieldInfo> getDataListBySid(int start, int limit,
			int sid) {
		String hql = " SELECT T FROM SourceFieldInfo T where T.sourceInfo.id = ? order by T.id asc ";
		return this.sourceFieldInfoDao.getDataList(hql, new Object[] { sid },
				start, limit);
	}

	@Override
	public int getDataListcountBySid(int sid) {
		return this.sourceFieldInfoDao.getCountByHql("SELECT COUNT(*) FROM SourceFieldInfo T where T.sourceInfo.id = ? " , new Object[] { sid });
	}

	
}