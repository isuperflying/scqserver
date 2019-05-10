/**************************************************************************************** 
 Copyright © 2014-2014 LUWEI Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.ant.scq.base;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.util.Assert;

import com.ant.scq.util.GenericsUtils;

/**
 * 
 * <Description> TODO<br>
 * 
 * @author lu.wei<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014-11-23 <br>
 * @since V1.0<br>
 * @see com.wsit.nj.ttcar.base <br>
 */
public class BaseDAOSupport<T> implements BaseDAO<T> {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this
			.getClass());

	@Override
	public Integer save(T entity) {
		try {
			int id = (Integer) getSession().save(entity);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public boolean update(T entity) {
		try {
			getSession().update(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(T entity) {
		try {
			getSession().delete(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void delete(List<T> list) {
		for (T obj : list) {
			this.delete(obj);
		}
	}

	/**
	 * 根据hql获取数据列表
	 */
	@Override
	public boolean deleteByParams(final String hql, final Object[] params) {
		try {
			Query query = getSession().createQuery(hql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 根据hql获取数据列表
	 */
	@Override
	public boolean deleteAllByParams(final String hql, final List<String> list) {
		try {
			for (String str : list) {
				this.deleteByParams(hql, new Object[]{ str });
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 根据hql获取数据列表
	 */
	@Override
	public boolean updateByParams(final String hql, final Object[] params) {
		try {
			Query query = getSession().createQuery(hql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 根据hql获取数据列表
	 */
	@Override
	public boolean updateAllByParams(final String hql, final List<String> list) {
		try {
			for (String str : list) {
				this.deleteByParams(hql, new Object[]{ str });
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public T getById(Integer id) {
		return (T) getSession().get(this.entityClass, id);
	}

	/**
	 * 根据查询HQL与参数列表创建Query对象.
	 * 
	 * 本类封装的find()函数全部默认返回对象类型为T,当不为T时使用本函数.
	 * 
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 */
	public Query createQuery(final Session session, final String queryString,
			final int start, final int limit, final Object... values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = session.createQuery(queryString);
		query.setFirstResult(start);
		query.setMaxResults(limit - start);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	/**
	 * 根据hql获取数据列表
	 */
	@Override
	public List<T> getDataList(final String hql, final Object[] params,
			final int start, final int limit) {
		List<T> list = null;
		try {

			Query query = getSession().createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(limit);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * 通过HQL语句拼装语句获取当前条件下的数量<br>
	 * 
	 * @param hql
	 * @param params
	 * @return <br>
	 */
	@Override
	public int getCountHQL(final String hql, final Object[] params) {
		String fromHql = hql;
		// select子句与order by子句会影响count查询,进行简单的排除.
		fromHql = "FROM " + StringUtils.substringAfter(fromHql, "FROM");
		fromHql = StringUtils.substringBefore(fromHql, "order by");
		String countHql = "SELECT COUNT(*) " + fromHql;
		try {
			Long count = findUnique(countHql, params);
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:"
					+ countHql, e);
		}
	}

	/**
	 * Description: 根据指定查询方式获取对象<br>
	 * 异常直接让上层捕捉
	 * 
	 * @param hql
	 * @param params
	 * @return <br>
	 */
	@Override
	public T getEntityByHql(final String hql, final Object[] params) {
		List<T> list = null;
		try {

			Query query = getSession().createQuery(hql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list != null && !list.isEmpty()) {
			return (T) list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 按HQL查询唯一对象.
	 * 
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 */
	public <X> X findUnique(final String hql, final Object... values) {

		List<T> list = null;
		Query query = null;
		try {
			query = getSession().createQuery(hql);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (X) query.uniqueResult();
	}

	/**
	 * 按SQL查询唯一对象.
	 * 
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 */
	public <X> X findUniqueSQL(final String sql, final Object... values) {

		List<T> list = null;
		Query query = null;
		try {
			query = getSession().createSQLQuery(sql);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					query.setParameter(i, values[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (X) query.uniqueResult();
	}

	/**
	 * 根据查询数量的HQL获取数量<br>
	 * 
	 * @param hql
	 * @param params
	 * @return <br>
	 */
	@Override
	public int getCountByHql(final String hql, final Object[] params) {
		try {
			Long count = findUnique(hql, params);
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(
					"hql can't be auto count, hql is:" + hql, e);
		}
	}

	/**
	 * 根据查询数量的SQL获取数量<br>
	 * 
	 * @param sql
	 * @param params
	 * @return <br>
	 */
	public int getCountBySql(String sql, Object[] params) {
		try {
			BigInteger count = (BigInteger) findUniqueSQL(sql, params);
			return count.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"sql can't be auto count, sql is:" + sql, e);
		}
	}

	/**
	 * 根据语句获取满足条件的所有数据<br>
	 * 
	 * @param hql
	 * @param params
	 * @return <br>
	 */
	@Override
	public List<T> getFullDataList(final String hql, final Object[] params) {
		List<T> list = null;
		try {
			Query query = getSession().createQuery(hql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}

	/**
	 * 批量保存<br>
	 * 
	 * @param list
	 * <br>
	 */
	public void saveList(List<T> list) {
		for (T t : list) {
			this.save(t);
		}
	}

	/**
	 * 根据sql查询对象列表
	 * 
	 * @param sql
	 * <br>
	 * @param params
	 * <br>
	 */
	public List<Object[]> getListObjectBySql(final String sql,
			final Object[] params) {
		List<Object[]> list = null;
		try {

			Query query = getSession().createSQLQuery(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}
}
