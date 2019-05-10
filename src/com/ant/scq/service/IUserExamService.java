package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.UserExam;

public abstract interface IUserExamService {
	public abstract int getDataListCount();

	public abstract List<UserExam> getDataList(int start, int limit);

	public abstract UserExam getUserExamById(int id);

	public abstract boolean saveUserExam(UserExam userExam);

	public abstract boolean updateUserExam(UserExam userExam);

	public abstract boolean deleteUserExam(UserExam userExam);

	public abstract int getUserExamCountByName(String name);

	public abstract void saveUserExamList(List<UserExam> userExamList);

	public abstract int getExamCountByExamId(int examId);
	
	public abstract List<UserExam> getDataListByExamId(int start,
			int limit, int examId);
}