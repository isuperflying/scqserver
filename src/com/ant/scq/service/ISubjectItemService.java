package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.SubjectItem;

public abstract interface ISubjectItemService {

	public abstract int getDataListCount();

	public abstract List<SubjectItem> getDataList(int start, int limit);

	public abstract SubjectItem getSubjectItemById(int id);

	public abstract Integer saveSubjectItem(SubjectItem subjectItem);

	public abstract boolean updateSubjectItem(SubjectItem subjectItem);

	public abstract boolean deleteSubjectItem(SubjectItem subjectItem);

	public abstract int getSubjectItemCountByName(String paramString);
	
	public abstract int updateSubjectItemCount(SubjectItem subjectItem);
}