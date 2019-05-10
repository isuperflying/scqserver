package com.ant.scq.dao.impl;

import java.util.List;

import com.ant.scq.base.BaseDAOSupport;
import com.ant.scq.dao.IExamInfoDao;
import com.ant.scq.entity.ExamInfo;

public class ExamInfoDaoImpl extends BaseDAOSupport<ExamInfo> implements
		IExamInfoDao {

	@Override
	public List<ExamInfo> getDataListByParams(int start, int limit,
			ExamInfo trainInfo) {
		
		return null;
	}
}