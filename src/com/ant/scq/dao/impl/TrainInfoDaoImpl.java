package com.ant.scq.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ant.scq.base.BaseDAOSupport;
import com.ant.scq.dao.ITrainInfoDao;
import com.ant.scq.entity.TrainInfo;

public class TrainInfoDaoImpl extends BaseDAOSupport<TrainInfo> implements
		ITrainInfoDao {

	@Override
	public List<TrainInfo> getDataListByParams(int start, int limit,
			TrainInfo trainInfo) {
		Session session = null;
		Query query = null;
		List<TrainInfo> trainInfoList = new ArrayList<TrainInfo>();
		try {
			StringBuffer sql = new StringBuffer("");
			
			String queryDisance = String.valueOf(6371*1000);//默认地球半径(m)
			if(trainInfo.getQuerySelectDiance() != null){
				queryDisance = trainInfo.getQuerySelectDiance();
			}
			
			//32.063744
			//118.741789
			
			if(trainInfo.getCurrentLongitude() != null && trainInfo.getCurrentLatitude() != null){
				sql.append(" select t.*,floor(( ");
				sql.append(" 6371 * acos (cos ( radians("+trainInfo.getCurrentLatitude()+") ) * cos(radians(latitude))* ");
				sql.append(" cos( radians( longitude ) - radians("+trainInfo.getCurrentLongitude()+") ) + sin ( radians("+trainInfo.getCurrentLatitude()+") ) * sin( radians( latitude ))) )*1000) AS distance ");
			}else{
				sql.append(" select t.*,-1 as distance ");
			}
			sql.append(" FROM t_train as t where 1 = 1");
			
			if(trainInfo.getQuerySelectArea() != null && (!"".equals(trainInfo.getQuerySelectArea()))){
				sql.append(" and t.register_area = '"+trainInfo.getQuerySelectArea()+"' ");
			}
			
			sql.append(" HAVING distance < "+queryDisance+" ORDER BY distance LIMIT 0 , 20; ");
			System.out.println("根据条件查询机构列表---"+sql.toString());
			
			query = getSession().createSQLQuery(sql.toString());
			List list = query.list();
			for (int i = 0; i < list.size(); i++) {
				TrainInfo temp = new TrainInfo();
				Object[] obj = (Object[]) list.get(i);

				temp.setId(null != obj[0] ? Integer.parseInt(obj[0].toString())
						: 0);
				temp.setTrainName(null != obj[1] ? obj[1].toString() : "");
				temp.setTrainSchoolArea(null != obj[2] ? obj[2].toString() : "");
				temp.setRegisterProvince(null != obj[3] ? obj[3].toString()
						: "");
				temp.setRegisterCity(null != obj[4] ? obj[4].toString() : "");
				temp.setRegisterArea(null != obj[5] ? obj[5].toString() : "");
				temp.setRegisterAddress(null != obj[6] ? obj[6].toString() : "");
				temp.setContactsName(null != obj[7] ? obj[7].toString() : "");
				temp.setContactsPhone(null != obj[8] ? obj[8].toString() : "");
				temp.setEnrollmentPhoneNumber(null != obj[9] ? obj[9]
						.toString() : "");
				temp.setLicense(null != obj[10] ? obj[10].toString() : "");
				temp.setLongitude(null != obj[11] ? obj[11].toString() : "");
				temp.setLatitude(null != obj[12] ? obj[12].toString() : "");
				temp.setTrainSpecial(null != obj[13] ? obj[13].toString() : "");
				temp.setTrainScale(null != obj[14] ? obj[14].toString() : "");
				temp.setIntroduction(null != obj[15] ? obj[15].toString() : "");
				temp.setRemark(null != obj[16] ? obj[16].toString() : "");
				temp.setDisance(null != obj[17] ? obj[17].toString() : "");
				trainInfoList.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return trainInfoList;
	}
}