package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.ITrainCommentDao;
import com.ant.scq.entity.TrainComment;
import com.ant.scq.service.ITrainCommentService;

public class TrainCommentServiceImpl implements ITrainCommentService {

	@Resource
	private ITrainCommentDao trainCommentDao;

	public ITrainCommentDao getTrainCommentDao() {
		return this.trainCommentDao;
	}

	public void setTrainCommentDao(ITrainCommentDao trainCommentDao) {
		this.trainCommentDao = trainCommentDao;
	}

	public List<TrainComment> getDataList(int start, int limit) {
		StringBuffer hql = new StringBuffer(" SELECT G FROM TrainComment G ");
		return this.trainCommentDao.getDataList(hql.toString(), null, start,
				limit);
	}

	public Integer saveTrainComment(TrainComment trainComment) {
		return this.trainCommentDao.save(trainComment);
	}

	public boolean updateTrainComment(TrainComment trainComment) {
		return this.trainCommentDao.update(trainComment);
	}

	public boolean deleteTrainComment(TrainComment trainComment) {
		return this.trainCommentDao.delete(trainComment);
	}

	public TrainComment getTrainCommentById(int id) {
		return (TrainComment) this.trainCommentDao.getEntityByHql(
				" SELECT G FROM TrainComment G where G.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.trainCommentDao.getCountByHql(
				"SELECT COUNT(*) FROM TrainComment ", null);
	}

	public int getTrainCommentCountByName(String goodName) {
		return this.trainCommentDao.getCountByHql(
				"SELECT COUNT(*) FROM TrainComment where goodName = '"
						+ goodName + "'", null);
	}

	@Override
	public int updateTrainCommentCount(TrainComment trainComment) {
		return this.trainCommentDao
				.getCountBySql(
						"UPDATE t_subject_item t set t.item_select_count = t.item_select_count+1 where t.id = "
								+ trainComment.getId(), null);
	}

	@Override
	public List<TrainComment> getDataListByTrainId(int start, int limit,
			int subjectId) {
		StringBuffer hql = new StringBuffer(
				" SELECT S FROM TrainComment S where S.train.id = ? ");
		return this.trainCommentDao.getDataList(hql.toString(),
				new Object[] { subjectId }, start, limit);
	}

}