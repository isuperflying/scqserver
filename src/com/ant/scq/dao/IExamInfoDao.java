package com.ant.scq.dao;

import java.util.List;

import com.ant.scq.base.BaseDAO;
import com.ant.scq.entity.ExamInfo;

public abstract interface IExamInfoDao extends BaseDAO<ExamInfo> {
	public abstract List<ExamInfo> getDataListByParams(int start, int limit,
			ExamInfo examInfo);
}