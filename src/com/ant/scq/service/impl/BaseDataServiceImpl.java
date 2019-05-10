package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.IBaseDataDao;
import com.ant.scq.entity.BaseData;
import com.ant.scq.service.IBaseDataService;

public class BaseDataServiceImpl
  implements IBaseDataService
{

  @Resource
  private IBaseDataDao baseDataDao;

  public IBaseDataDao getBaseDataDao()
  {
    return this.baseDataDao;
  }

  public void setBaseDataDao(IBaseDataDao baseDataDao) {
    this.baseDataDao = baseDataDao;
  }

  public List<BaseData> getDataList(int start, int limit)
  {
    String hql = " SELECT B FROM BaseData B ";
    return this.baseDataDao.getDataList(hql, null, start, limit);
  }

  public Integer saveBaseData(BaseData baseData)
  {
    return this.baseDataDao.save(baseData);
  }

  public boolean updateBaseData(BaseData baseData)
  {
    return this.baseDataDao.update(baseData);
  }

  public boolean deleteBaseData(BaseData baseData)
  {
    return this.baseDataDao.delete(baseData);
  }

  public BaseData getBaseDataById(String id)
  {
    return (BaseData)this.baseDataDao.getEntityByHql(" SELECT B FROM BaseData B where B.id = ? ", new Object[] { id });
  }

  public int getDataListCount()
  {
    return this.baseDataDao.getCountByHql("SELECT COUNT(*) FROM BaseData ", null);
  }

  public int getBaseDataCountByName(String baseDataName)
  {
    return this.baseDataDao.getCountByHql("SELECT COUNT(*) FROM BaseData where baseDataName = '" + baseDataName + "'", null);
  }
}