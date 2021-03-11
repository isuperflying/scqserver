package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.SpecialInfo;

public abstract interface ISpecialInfoService {
	public abstract int getDataListCount();

	public abstract List<SpecialInfo> getDataList(int start, int limit);

	public abstract SpecialInfo getSpecialInfoById(int id);

	public abstract boolean saveSpecialInfo(SpecialInfo specialInfo);

	public abstract boolean updateSpecialInfo(SpecialInfo specialInfo);

	public abstract boolean deleteSpecialInfo(SpecialInfo specialInfo);

	public abstract int getSpecialInfoCountByName(String name);

	public abstract void saveSpecialInfoList(List<SpecialInfo> specialInfoList);

	public abstract List<SpecialInfo> getAllSpecialInfoByLevel(String level);
	
	public abstract SpecialInfo getSpecialInfoByIdMenuNumber(String menuNumber);
}