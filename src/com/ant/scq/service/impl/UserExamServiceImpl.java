package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.IUserExamDao;
import com.ant.scq.entity.UserExam;
import com.ant.scq.service.IUserExamService;

public class UserExamServiceImpl implements IUserExamService {

	@Resource
	private IUserExamDao userExamDao;

	public IUserExamDao getUserExamDao() {
		return this.userExamDao;
	}

	public void setUserExamDao(IUserExamDao userExamDao) {
		this.userExamDao = userExamDao;
	}

	public List<UserExam> getDataList(int start, int limit) {
		String hql = " SELECT T FROM UserExam T ";
		return this.userExamDao.getDataList(hql, null, start, limit);
	}

	public boolean saveUserExam(UserExam userExam) {
		return this.userExamDao.save(userExam) > 0 ? true : false;
	}

	public boolean updateUserExam(UserExam userExam) {
		return this.userExamDao.update(userExam);
	}

	public boolean deleteUserExam(UserExam userExam) {
		return this.userExamDao.delete(userExam);
	}

	public UserExam getUserExamById(int id) {
		return (UserExam) this.userExamDao.getEntityByHql(
				" SELECT T FROM UserExam T where T.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.userExamDao.getCountByHql(
				"SELECT COUNT(*) FROM UserExam ", null);
	}

	public int getUserExamCountByName(String userExamName) {
		return this.userExamDao.getCountByHql(
				"SELECT COUNT(*) FROM UserExam where userExamName = '"
						+ userExamName + "'", null);
	}

	@Override
	public void saveUserExamList(List<UserExam> userExamList) {
		this.userExamDao.saveList(userExamList);
	}

	@Override
	public List<UserExam> getDataListByExamId(int start, int limit,
			int trainId) {
		String hql = " SELECT T FROM UserExam T where T.examInfo.id = ? order by examScore desc ";
		return this.userExamDao.getDataList(hql, new Object[] { trainId },
				start, limit);
	}

	@Override
	public int getExamCountByExamId(int examId) {
		return this.userExamDao.getCountByHql(
				"SELECT COUNT(*) FROM UserExam where examInfo.id = ? " , new Object[] { examId });
	}

}