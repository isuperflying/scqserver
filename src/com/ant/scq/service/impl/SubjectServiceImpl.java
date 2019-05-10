package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.ISubjectDao;
import com.ant.scq.entity.Subject;
import com.ant.scq.service.ISubjectService;

public class SubjectServiceImpl implements ISubjectService {

	@Resource
	private ISubjectDao subjectDao;

	public ISubjectDao getSubjectDao() {
		return this.subjectDao;
	}

	public void setSubjectDao(ISubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public List<Subject> getDataList(int start, int limit) {
		StringBuffer hql = new StringBuffer(" SELECT G FROM Subject G ");
		return this.subjectDao.getDataList(hql.toString(), null, start, limit);
	}

	public Integer saveSubject(Subject subject) {
		return this.subjectDao.save(subject);
	}

	public boolean updateSubject(Subject subject) {
		return this.subjectDao.update(subject);
	}

	public boolean deleteSubject(Subject subject) {
		return this.subjectDao.delete(subject);
	}

	public Subject getSubjectById(int id) {
		return (Subject) this.subjectDao.getEntityByHql(
				" SELECT G FROM Subject G where G.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.subjectDao.getCountByHql("SELECT COUNT(*) FROM Subject ",
				null);
	}

	public int getSubjectCountByName(String goodName) {
		return this.subjectDao.getCountByHql(
				"SELECT COUNT(*) FROM Subject where goodName = '"
						+ goodName + "'", null);
	}
	
}