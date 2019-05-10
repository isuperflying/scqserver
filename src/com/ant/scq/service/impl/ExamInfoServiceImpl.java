package com.ant.scq.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.ant.scq.dao.IExamInfoDao;
import com.ant.scq.entity.ExamInfo;
import com.ant.scq.service.IExamInfoService;
import com.ant.scq.util.DateUtil;
import com.ant.scq.util.StringUtil;

public class ExamInfoServiceImpl implements IExamInfoService {

	@Resource
	private IExamInfoDao examInfoDao;

	public IExamInfoDao getExamInfoDao() {
		return this.examInfoDao;
	}

	public void setExamInfoDao(IExamInfoDao examInfoDao) {
		this.examInfoDao = examInfoDao;
	}

	public List<ExamInfo> getDataList(int start, int limit) {
		String hql = " SELECT T FROM ExamInfo T ";
		return this.examInfoDao.getDataList(hql, null, start, limit);
	}

	public List<ExamInfo> getDataListBySql(int start, int limit, String uid) {
		String sql = "select e.*,u.exam_state from t_exam_info e left JOIN t_user_exam u ON u.exam_info_id = e.id and u.user_id = ? limit ?,? ";

		List<Object[]> listObjs = this.examInfoDao.getListObjectBySql(sql, new Object[] { uid, start, limit });

		List<ExamInfo> list = new ArrayList<ExamInfo>();
		if (listObjs == null) {
			return null;
		}
		for (Object[] obj : listObjs) {

			ExamInfo examInfo = new ExamInfo();
			if (obj[0] != null) {
				examInfo.setId(Integer.parseInt(obj[0].toString()));
			}
			examInfo.setExamNumber(StringUtil.isEmptyValue(obj[1]));
			examInfo.setExamName(StringUtil.isEmptyValue(obj[2]));
			examInfo.setExamContent(StringUtil.isEmptyValue(obj[3]));
			examInfo.setExamStartDate(StringUtil.isEmptyValue(obj[5].toString()));
			examInfo.setExamEndDate(StringUtil.isEmptyValue(obj[6].toString()));

			if (obj[7] != null) {
				examInfo.setExamTotalTime(Integer.parseInt(obj[7].toString()));
			}

			examInfo.setExamAddDate(StringUtil.isEmptyValue(obj[8].toString()));
			examInfo.setRemark(StringUtil.isEmptyValue(obj[9]));

			if (obj[10] != null) {
				examInfo.setUserExamState(Integer.parseInt(obj[10].toString()));
			}

			list.add(examInfo);
		}
		return list;
	}

	public boolean saveExamInfo(ExamInfo examInfo) {
		return this.examInfoDao.save(examInfo) > 0 ? true : false;
	}

	public boolean updateExamInfo(ExamInfo examInfo) {
		return this.examInfoDao.update(examInfo);
	}

	public boolean deleteExamInfo(ExamInfo examInfo) {
		return this.examInfoDao.delete(examInfo);
	}

	public ExamInfo getExamInfoById(int id) {
		return (ExamInfo) this.examInfoDao.getEntityByHql(" SELECT T FROM ExamInfo T where T.id = ? ",
				new Object[] { id });
	}

	public int getDataListCount() {
		return this.examInfoDao.getCountByHql("SELECT COUNT(*) FROM ExamInfo ", null);
	}

	public int getExamInfoCountByName(String examInfoName) {
		return this.examInfoDao
				.getCountByHql("SELECT COUNT(*) FROM ExamInfo where examInfoName = '" + examInfoName + "'", null);
	}

	@Override
	public void saveExamInfoList(List<ExamInfo> examInfoList) {
		this.examInfoDao.saveList(examInfoList);
	}

	@Override
	public List<ExamInfo> getDataListByParams(int start, int limit, ExamInfo examInfo) {
		return examInfoDao.getDataListByParams(start, limit, examInfo);
	}

}