package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.IScoreItemDao;
import com.ant.scq.entity.ScoreItem;
import com.ant.scq.service.IScoreItemService;

public class ScoreItemServiceImpl implements IScoreItemService {

	@Resource
	private IScoreItemDao scoreItemDao;

	public IScoreItemDao getScoreItemDao() {
		return this.scoreItemDao;
	}

	public void setScoreItemDao(IScoreItemDao scoreItemDao) {
		this.scoreItemDao = scoreItemDao;
	}

	public List<ScoreItem> getDataList(int start, int limit) {
		String hql = " SELECT T FROM  ScoreItem T ";
		return this.scoreItemDao.getDataList(hql, null, start, limit);
	}
	
	@Override
	public List<ScoreItem> getAllDataList() {
		String hql = " SELECT T FROM  ScoreItem T ";
		return this.scoreItemDao.getFullDataList(hql, null);
	}

	public boolean saveScoreItem(ScoreItem scoreItem) {
		return this.scoreItemDao.save(scoreItem) > 0 ? true : false;
	}

	public boolean updateScoreItem(ScoreItem scoreItem) {
		return this.scoreItemDao.update(scoreItem);
	}

	public boolean deleteScoreItem(ScoreItem scoreItem) {
		return this.scoreItemDao.delete(scoreItem);
	}

	public ScoreItem getScoreItemById(int id) {
		return (ScoreItem) this.scoreItemDao.getEntityByHql(" SELECT T FROM ScoreItem T where T.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.scoreItemDao.getCountByHql("SELECT COUNT(*) FROM ScoreItem ", null);
	}

	public int getScoreItemCountByName(String scoreItemName) {
		return this.scoreItemDao
				.getCountByHql("SELECT COUNT(*) FROM ScoreItem where scoreItemName = '" + scoreItemName + "'", null);
	}

	@Override
	public void saveScoreItemList(List<ScoreItem> scoreItemList) {
		this.scoreItemDao.saveList(scoreItemList);
	}

	@Override
	public List<ScoreItem> getDataListByParams(int start, int limit, ScoreItem scoreItem) {
		return null;
	}

	
}