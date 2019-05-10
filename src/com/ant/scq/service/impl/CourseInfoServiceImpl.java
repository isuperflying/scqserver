package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.ICourseInfoDao;
import com.ant.scq.entity.CourseInfo;
import com.ant.scq.entity.MenuType;
import com.ant.scq.service.ICourseInfoService;

public class CourseInfoServiceImpl implements ICourseInfoService {

	@Resource
	private ICourseInfoDao courseInfoDao;

	public ICourseInfoDao getCourseInfoDao() {
		return this.courseInfoDao;
	}

	public void setCourseInfoDao(ICourseInfoDao courseInfoDao) {
		this.courseInfoDao = courseInfoDao;
	}

	public List<CourseInfo> getDataList(int start, int limit) {
		String hql = " SELECT T FROM CourseInfo T ";
		return this.courseInfoDao.getDataList(hql, null, start, limit);
	}

	public boolean saveCourseInfo(CourseInfo courseInfo) {
		return this.courseInfoDao.save(courseInfo) > 0 ? true : false;
	}

	public boolean updateCourseInfo(CourseInfo courseInfo) {
		return this.courseInfoDao.update(courseInfo);
	}

	public boolean deleteCourseInfo(CourseInfo courseInfo) {
		return this.courseInfoDao.delete(courseInfo);
	}

	public CourseInfo getCourseInfoById(int id) {
		return (CourseInfo) this.courseInfoDao.getEntityByHql(
				" SELECT T FROM CourseInfo T where T.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.courseInfoDao.getCountByHql(
				"SELECT COUNT(*) FROM CourseInfo ", null);
	}

	public int getCourseInfoCountByName(String courseInfoName) {
		return this.courseInfoDao.getCountByHql(
				"SELECT COUNT(*) FROM CourseInfo where courseInfoName = '"
						+ courseInfoName + "'", null);
	}

	@Override
	public void saveCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoDao.saveList(courseInfoList);
	}

	@Override
	public List<MenuType> getAllFirstMenu() {
		return courseInfoDao.getFullDataList(
				" FROM MenuType where menuLevel = 1 ", null);
	}

	@Override
	public List<MenuType> getMenuTypeByParentNumber(String parentNumber) {
		String hql = " SELECT M FROM MenuType M where M.parentNumber = "
				+ parentNumber;
		return courseInfoDao.getFullDataList(hql, null);
	}

	@Override
	public List<Object[]> getFirstMenuNumberByLastMenuNumber(String menuNumber) {
		String sql = "select m.parent_number from t_menu_type m where m.menu_number='"
				+ menuNumber
				+ "' UNION "
				+ "select m.parent_number from t_menu_type m where m.menu_number=( "
				+ "select m.parent_number from t_menu_type m where m.menu_number='"
				+ menuNumber + "')";
		return courseInfoDao.getListObjectBySql(sql, null);
	}

	@Override
	public List<MenuType> getSecondMenuTypeByNumber(String number) {
		String hql = " SELECT M FROM MenuType M where M.parentNumber = ( SELECT MM.parentNumber FROM MenuType MM where MM.menuNumber = '"+number+"')";
		return courseInfoDao.getFullDataList(hql, null);
	}

	@Override
	public List<CourseInfo> getDataListByIsCurated(int start, int limit,
			int isCurated) {
		String hql = " SELECT T FROM CourseInfo T where T.isCurated = ? ";
		return this.courseInfoDao.getDataList(hql, new Object[] { isCurated }, start, limit);
	}

	@Override
	public List<CourseInfo> getDataListByTrainId(int start, int limit,
			int trainId) {
		String hql = " SELECT C FROM CourseInfo C where C.trainId.id = ? ";
		return this.courseInfoDao.getDataList(hql, new Object[] { trainId }, start, limit);
	}

}