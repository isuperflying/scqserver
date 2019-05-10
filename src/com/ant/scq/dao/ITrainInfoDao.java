package com.ant.scq.dao;

import java.util.List;

import com.ant.scq.base.BaseDAO;
import com.ant.scq.entity.TrainInfo;

public abstract interface ITrainInfoDao extends BaseDAO<TrainInfo> {
	public abstract List<TrainInfo> getDataListByParams(int start, int limit,
			TrainInfo trainInfo);
}