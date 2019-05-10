package com.ant.scq.service.impl;

import javax.annotation.Resource;

import com.ant.scq.dao.ISubjectUserDao;
import com.ant.scq.entity.SubjectUser;
import com.ant.scq.service.ISubjectUserService;

public class SubjectUserServiceImpl implements ISubjectUserService {

	@Resource
	private ISubjectUserDao subjectUserDao;

	public ISubjectUserDao getSubjectUserDao() {
		return subjectUserDao;
	}

	public void setSubjectUserDao(ISubjectUserDao subjectUserDao) {
		this.subjectUserDao = subjectUserDao;
	}

	@Override
	public Integer saveSubjectUser(SubjectUser subjectUser) {
		return subjectUserDao.save(subjectUser);
	}

	@Override
	public int getSubjectUserByparams(int userId, int subjectId) {
		return this.subjectUserDao.getCountByHql(
				"SELECT COUNT(*) FROM SubjectUser S where S.user.id = ? and S.subject.id = ? ", new Object[] { userId, subjectId});
	}

}