package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.SourceFieldInfo;

public abstract interface ISourceFieldInfoService {
	
	public abstract int getDataListCount();

	public abstract List<SourceFieldInfo> getDataList(int start, int limit);

	public abstract List<SourceFieldInfo> getDataListBySql(int start, int limit, String uid);
	
	public abstract SourceFieldInfo getSourceFieldInfoById(int id);

	public abstract boolean saveSourceFieldInfo(SourceFieldInfo sourceFieldInfo);

	public abstract boolean updateSourceFieldInfo(SourceFieldInfo sourceFieldInfo);

	public abstract boolean deleteSourceFieldInfo(SourceFieldInfo sourceFieldInfo);

	public abstract int getSourceFieldInfoCountByName(String name);

	public abstract void saveSourceFieldInfoList(List<SourceFieldInfo> sourceFieldInfoList);
	
	public abstract List<SourceFieldInfo> getDataListByParams(int start, int limit,SourceFieldInfo sourceFieldInfo);
	
	public abstract int getDataListcountBySid(int sid);
	
	public abstract List<SourceFieldInfo> getDataListBySid(int start, int limit, int sid);
}