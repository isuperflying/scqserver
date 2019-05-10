package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.SubjectComment;

public abstract interface ISubjectCommentService {

	public abstract int getDataListCount();

	public abstract List<SubjectComment> getDataList(int start, int limit);

	public abstract SubjectComment getSubjectCommentById(int id);

	public abstract Integer saveSubjectComment(SubjectComment subjectComment);

	public abstract boolean updateSubjectComment(SubjectComment subjectComment);

	public abstract boolean deleteSubjectComment(SubjectComment subjectComment);

	public abstract int getSubjectCommentCountByName(String paramString);
	
	public abstract int updateSubjectCommentCount(SubjectComment subjectComment);
	
	public abstract List<SubjectComment> getDataListBySubjectId(int start, int limit,int subjectId);
}