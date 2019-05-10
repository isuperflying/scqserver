package com.ant.scq.base;

import java.util.List;

public abstract interface BaseDAO<T>
{
  public abstract Integer save(T paramT);

  public abstract boolean update(T paramT);

  public abstract boolean delete(T paramT);

  public abstract void delete(List<T> paramList);

  public abstract T getById(Integer paramInteger);

  public abstract List<T> getDataList(String paramString, Object[] paramArrayOfObject, int paramInt1, int paramInt2);

  public abstract int getCountHQL(String paramString, Object[] paramArrayOfObject);

  public abstract T getEntityByHql(String paramString, Object[] paramArrayOfObject);

  public abstract int getCountByHql(String paramString, Object[] paramArrayOfObject);

  public abstract int getCountBySql(String paramString, Object[] paramArrayOfObject);

  public abstract <X> List<X> getFullDataList(String paramString, Object[] paramArrayOfObject);

  public abstract void saveList(List<T> paramList);

  public abstract List<Object[]> getListObjectBySql(String paramString, Object[] paramArrayOfObject);

  public abstract boolean deleteByParams(String paramString, Object[] paramArrayOfObject);

  public abstract boolean deleteAllByParams(String paramString, List<String> paramList);

  public abstract boolean updateByParams(String paramString, Object[] paramArrayOfObject);

  public abstract boolean updateAllByParams(String paramString, List<String> paramList);
}