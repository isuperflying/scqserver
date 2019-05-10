package com.ant.scq.dao.impl;

import java.util.List;

import com.ant.scq.base.BaseDAOSupport;
import com.ant.scq.dao.ISourceInfoDao;
import com.ant.scq.entity.SourceInfo;

public class SourceInfoDaoImpl extends BaseDAOSupport<SourceInfo> implements
		ISourceInfoDao {

	@Override
	public List<SourceInfo> getDataListByParams(int start, int limit) {
		return null;
	}
}