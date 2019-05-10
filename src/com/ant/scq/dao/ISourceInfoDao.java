package com.ant.scq.dao;

import java.util.List;

import com.ant.scq.base.BaseDAO;
import com.ant.scq.entity.SourceInfo;

public abstract interface ISourceInfoDao extends BaseDAO<SourceInfo> {
	public abstract List<SourceInfo> getDataListByParams(int start, int limit);
}