package com.ant.scq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.dao.IUserDao;
import com.ant.scq.entity.User;
import com.ant.scq.service.IUserService;
import com.ant.scq.util.MD5Util;

public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return this.userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserByParams(String userName, String passWord) {
		return (User) this.userDao.getEntityByHql(
				" SELECT U FROM User U where U.userName = ? and passWord = ? ", new Object[] { userName, passWord });
	}

	public List<User> getDataList(int start, int limit) {
		String hql = " SELECT U FROM User U ";
		return this.userDao.getDataList(hql, null, start, limit);
	}

	public Integer saveUser(User user) {
		return this.userDao.save(user);
	}

	public boolean updateUser(User user) {
		return this.userDao.update(user);
	}

	public boolean deleteUser(User user) {
		return this.userDao.delete(user);
	}

	public User getUserById(int id) {
		return (User) this.userDao.getEntityByHql(
				" SELECT U FROM User U where U.id = ? ", new Object[] { id });
	}

	public int getDataListCount() {
		return this.userDao.getCountByHql("SELECT COUNT(*) FROM User ", null);
	}

	public int getUserCountByName(String userName) {
		return this.userDao
				.getCountByHql("SELECT COUNT(*) FROM User where userName = '"
						+ userName + "'", null);
	}

	@Override
	public boolean addUser(String userName, String passWord) {
		boolean isFlag = true;
		if(getUserCountByName(userName) > 0){
			isFlag = false;
		}else{
			User nUser = new User();
			nUser.setUserName(userName);
			nUser.setPassWord(passWord);
			if(this.userDao.save(nUser) > 0){
				isFlag = true;
			}else{
				isFlag = false;
			}
		}
		
		return isFlag;
	}

	
	
}