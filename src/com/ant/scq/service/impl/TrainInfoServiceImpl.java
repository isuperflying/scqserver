package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.ITrainInfoDao;
import com.ant.scq.entity.Area;
import com.ant.scq.entity.City;
import com.ant.scq.entity.Province;
import com.ant.scq.entity.TrainInfo;
import com.ant.scq.service.ITrainInfoService;

public class TrainInfoServiceImpl implements ITrainInfoService {

	@Resource
	private ITrainInfoDao trainInfoDao;

	public ITrainInfoDao getTrainInfoDao() {
		return this.trainInfoDao;
	}

	public void setTrainInfoDao(ITrainInfoDao trainInfoDao) {
		this.trainInfoDao = trainInfoDao;
	}

	public List<TrainInfo> getDataList(int start, int limit) {
		String hql = " SELECT T FROM TrainInfo T ";
		return this.trainInfoDao.getDataList(hql, null, start, limit);
	}

	public boolean saveTrainInfo(TrainInfo trainInfo) {
		return this.trainInfoDao.save(trainInfo) > 0 ? true : false;
	}

	public boolean updateTrainInfo(TrainInfo trainInfo) {
		return this.trainInfoDao.update(trainInfo);
	}

	public boolean deleteTrainInfo(TrainInfo trainInfo) {
		return this.trainInfoDao.delete(trainInfo);
	}

	public TrainInfo getTrainInfoById(int id) {
		return (TrainInfo) this.trainInfoDao.getEntityByHql(
				" SELECT T FROM TrainInfo T where T.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.trainInfoDao.getCountByHql(
				"SELECT COUNT(*) FROM TrainInfo ", null);
	}

	public int getTrainInfoCountByName(String trainInfoName) {
		return this.trainInfoDao.getCountByHql(
				"SELECT COUNT(*) FROM TrainInfo where trainInfoName = '"
						+ trainInfoName + "'", null);
	}

	@Override
	public void saveTrainInfoList(List<TrainInfo> trainInfoList) {
		this.trainInfoDao.saveList(trainInfoList);
	}

	@Override
	public List<Province> getAllProvince() {
		return trainInfoDao.getFullDataList(" FROM Province ", null);
	}

	@Override
	public List<City> getCityByProvinceId(String id) {
		String hql = " SELECT C FROM City C where C.father = " + id;
		return trainInfoDao.getFullDataList(hql, null);
	}

	@Override
	public List<Area> getAreaByCityId(String id) {
		String hql = " SELECT A FROM Area A where A.father = " + id;
		return trainInfoDao.getFullDataList(hql, null);
	}

	@Override
	public List<TrainInfo> getDataListByParams(int start, int limit,
			TrainInfo trainInfo) {
		return trainInfoDao.getDataListByParams(start, limit, trainInfo);
	}
}