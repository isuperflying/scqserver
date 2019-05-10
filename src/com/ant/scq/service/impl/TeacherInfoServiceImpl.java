package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.ITeacherInfoDao;
import com.ant.scq.entity.TeacherInfo;
import com.ant.scq.service.ITeacherInfoService;

public class TeacherInfoServiceImpl implements ITeacherInfoService {

	@Resource
	private ITeacherInfoDao teacherInfoDao;

	public ITeacherInfoDao getTeacherInfoDao() {
		return this.teacherInfoDao;
	}

	public void setTeacherInfoDao(ITeacherInfoDao teacherInfoDao) {
		this.teacherInfoDao = teacherInfoDao;
	}

	public List<TeacherInfo> getDataList(int start, int limit) {
		String hql = " SELECT T FROM TeacherInfo T ";
		return this.teacherInfoDao.getDataList(hql, null, start, limit);
	}

	public boolean saveTeacherInfo(TeacherInfo teacherInfo) {
		return this.teacherInfoDao.save(teacherInfo) > 0 ? true : false;
	}

	public boolean updateTeacherInfo(TeacherInfo teacherInfo) {
		return this.teacherInfoDao.update(teacherInfo);
	}

	public boolean deleteTeacherInfo(TeacherInfo teacherInfo) {
		return this.teacherInfoDao.delete(teacherInfo);
	}

	public TeacherInfo getTeacherInfoById(int id) {
		return (TeacherInfo) this.teacherInfoDao.getEntityByHql(
				" SELECT T FROM TeacherInfo T where T.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.teacherInfoDao.getCountByHql(
				"SELECT COUNT(*) FROM TeacherInfo ", null);
	}

	public int getTeacherInfoCountByName(String teacherInfoName) {
		return this.teacherInfoDao.getCountByHql(
				"SELECT COUNT(*) FROM TeacherInfo where teacherInfoName = '"
						+ teacherInfoName + "'", null);
	}

	@Override
	public void saveTeacherInfoList(List<TeacherInfo> teacherInfoList) {
		this.teacherInfoDao.saveList(teacherInfoList);
	}

	@Override
	public List<TeacherInfo> getDataListByTrainId(int start, int limit,
			int trainId) {
		String hql = " SELECT T FROM TeacherInfo T where T.trainId.id = ? ";
		return this.teacherInfoDao.getDataList(hql, new Object[] { trainId },
				start, limit);
	}

}