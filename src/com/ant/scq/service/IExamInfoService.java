package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.ExamInfo;

public abstract interface IExamInfoService {
	public abstract int getDataListCount();

	public abstract List<ExamInfo> getDataList(int start, int limit);

	public abstract List<ExamInfo> getDataListBySql(int start, int limit, String uid);
	
	public abstract ExamInfo getExamInfoById(int id);

	public abstract boolean saveExamInfo(ExamInfo examInfo);

	public abstract boolean updateExamInfo(ExamInfo examInfo);

	public abstract boolean deleteExamInfo(ExamInfo examInfo);

	public abstract int getExamInfoCountByName(String name);

	public abstract void saveExamInfoList(List<ExamInfo> examInfoList);
	
	public abstract List<ExamInfo> getDataListByParams(int start, int limit,ExamInfo examInfo);
	
}