package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.ISubjectItemDao;
import com.ant.scq.entity.SubjectItem;
import com.ant.scq.service.ISubjectItemService;

public class SubjectItemServiceImpl implements ISubjectItemService {

	@Resource
	private ISubjectItemDao subjectItemDao;

	public ISubjectItemDao getSubjectItemDao() {
		return this.subjectItemDao;
	}

	public void setSubjectItemDao(ISubjectItemDao subjectItemDao) {
		this.subjectItemDao = subjectItemDao;
	}

	public List<SubjectItem> getDataList(int start, int limit) {
		StringBuffer hql = new StringBuffer(" SELECT G FROM SubjectItem G ");
		return this.subjectItemDao.getDataList(hql.toString(), null, start, limit);
	}

	public Integer saveSubjectItem(SubjectItem subjectItem) {
		return this.subjectItemDao.save(subjectItem);
	}

	public boolean updateSubjectItem(SubjectItem subjectItem) {
		return this.subjectItemDao.update(subjectItem);
	}

	public boolean deleteSubjectItem(SubjectItem subjectItem) {
		return this.subjectItemDao.delete(subjectItem);
	}

	public SubjectItem getSubjectItemById(int id) {
		return (SubjectItem) this.subjectItemDao.getEntityByHql(
				" SELECT G FROM SubjectItem G where G.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.subjectItemDao.getCountByHql("SELECT COUNT(*) FROM SubjectItem ",
				null);
	}

	public int getSubjectItemCountByName(String goodName) {
		return this.subjectItemDao.getCountByHql(
				"SELECT COUNT(*) FROM SubjectItem where goodName = '"
						+ goodName + "'", null);
	}

	@Override
	public int updateSubjectItemCount(SubjectItem subjectItem) {
		return this.subjectItemDao.getCountBySql("UPDATE t_subject_item t set t.item_select_count = t.item_select_count+1 where t.id = "+subjectItem.getId(),null);
	}

	
	
}