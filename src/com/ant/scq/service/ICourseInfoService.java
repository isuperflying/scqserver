package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.CourseInfo;
import com.ant.scq.entity.MenuType;

public abstract interface ICourseInfoService {
	public abstract int getDataListCount();

	public abstract List<CourseInfo> getDataList(int start, int limit);

	public abstract CourseInfo getCourseInfoById(int id);

	public abstract boolean saveCourseInfo(CourseInfo courseInfo);

	public abstract boolean updateCourseInfo(CourseInfo courseInfo);

	public abstract boolean deleteCourseInfo(CourseInfo courseInfo);

	public abstract int getCourseInfoCountByName(String name);

	public abstract void saveCourseInfoList(List<CourseInfo> courseInfoList);
	
	public abstract List<MenuType> getAllFirstMenu();

	public abstract List<MenuType> getMenuTypeByParentNumber(String parentNumber);
	/**
	 * 根据三级菜单的编号查询一级、二级菜单编号
	 * @param menuNumber
	 * @return
	 */
	public abstract List<Object[]> getFirstMenuNumberByLastMenuNumber(String menuNumber);
	/**
	 * 根据三级菜单的编号查询所有的二级菜单
	 * @param parentNumber
	 * @return
	 */
	public abstract List<MenuType> getSecondMenuTypeByNumber(String number);
	
	/**
	 * 是否是精选课程
	 * @param start
	 * @param limit
	 * @param isCurated
	 * @return
	 */
	public abstract List<CourseInfo> getDataListByIsCurated(int start, int limit,int isCurated);
	
	/**
	 * 查询机构下的课程
	 * @param start
	 * @param limit
	 * @param trainId
	 * @return
	 */
	public abstract List<CourseInfo> getDataListByTrainId(int start, int limit,int trainId);
}