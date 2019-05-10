package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.SourceInfo;

public abstract interface ISourceInfoService {
	
	public abstract int getDataListCount();

	public abstract List<SourceInfo> getDataList(int start, int limit);

	public abstract List<SourceInfo> getDataListBySql(int start, int limit, String uid);
	
	public abstract SourceInfo getSourceInfoById(int id);

	public abstract boolean saveSourceInfo(SourceInfo sourceInfo);

	public abstract boolean updateSourceInfo(SourceInfo sourceInfo);

	public abstract boolean deleteSourceInfo(SourceInfo sourceInfo);

	public abstract int getSourceInfoCountByName(String name);

	public abstract void saveSourceInfoList(List<SourceInfo> sourceInfoList);
	
	public abstract List<SourceInfo> getDataListByParams(int start, int limit,SourceInfo sourceInfo);
	
}