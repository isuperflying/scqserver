package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.Subject;
import com.ant.scq.entity.SubjectUser;

public abstract interface ISubjectService {

	public abstract int getDataListCount();

	public abstract List<Subject> getDataList(int start, int limit);

	public abstract Subject getSubjectById(int id);

	public abstract Integer saveSubject(Subject subject);

	public abstract boolean updateSubject(Subject subject);

	public abstract boolean deleteSubject(Subject subject);

	public abstract int getSubjectCountByName(String paramString);
	
}