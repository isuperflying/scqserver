package com.ant.scq.dao;

import java.util.List;

import com.ant.scq.base.BaseDAO;
import com.ant.scq.entity.SourceFieldInfo;

public abstract interface ISourceFieldInfoDao extends BaseDAO<SourceFieldInfo> {
	public abstract List<SourceFieldInfo> getDataListByParams(int start, int limit);
}