package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.ISubjectCommentDao;
import com.ant.scq.entity.SubjectComment;
import com.ant.scq.service.ISubjectCommentService;

public class SubjectCommentServiceImpl implements ISubjectCommentService {

	@Resource
	private ISubjectCommentDao subjectCommentDao;

	public ISubjectCommentDao getSubjectCommentDao() {
		return this.subjectCommentDao;
	}

	public void setSubjectCommentDao(ISubjectCommentDao subjectCommentDao) {
		this.subjectCommentDao = subjectCommentDao;
	}

	public List<SubjectComment> getDataList(int start, int limit) {
		StringBuffer hql = new StringBuffer(" SELECT G FROM SubjectComment G ");
		return this.subjectCommentDao.getDataList(hql.toString(), null, start,
				limit);
	}

	public Integer saveSubjectComment(SubjectComment subjectComment) {
		return this.subjectCommentDao.save(subjectComment);
	}

	public boolean updateSubjectComment(SubjectComment subjectComment) {
		return this.subjectCommentDao.update(subjectComment);
	}

	public boolean deleteSubjectComment(SubjectComment subjectComment) {
		return this.subjectCommentDao.delete(subjectComment);
	}

	public SubjectComment getSubjectCommentById(int id) {
		return (SubjectComment) this.subjectCommentDao.getEntityByHql(
				" SELECT G FROM SubjectComment G where G.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.subjectCommentDao.getCountByHql(
				"SELECT COUNT(*) FROM SubjectComment ", null);
	}

	public int getSubjectCommentCountByName(String goodName) {
		return this.subjectCommentDao.getCountByHql(
				"SELECT COUNT(*) FROM SubjectComment where goodName = '"
						+ goodName + "'", null);
	}

	@Override
	public int updateSubjectCommentCount(SubjectComment subjectComment) {
		return this.subjectCommentDao
				.getCountBySql(
						"UPDATE t_subject_item t set t.item_select_count = t.item_select_count+1 where t.id = "
								+ subjectComment.getId(), null);
	}

	@Override
	public List<SubjectComment> getDataListBySubjectId(int start, int limit,
			int subjectId) {
		StringBuffer hql = new StringBuffer(
				" SELECT S FROM SubjectComment S where S.subject.id = ? ");
		return this.subjectCommentDao.getDataList(hql.toString(),
				new Object[] { subjectId }, start, limit);
	}

}