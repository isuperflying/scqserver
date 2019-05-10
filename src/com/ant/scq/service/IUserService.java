package com.ant.scq.service;

import java.util.List;

import com.ant.scq.entity.User;

public abstract interface IUserService {

	public abstract User getUserByParams(String userName, String passWord);

	public abstract int getDataListCount();

	public abstract List<User> getDataList(int paramInt1, int paramInt2);

	public abstract User getUserById(int id);

	public abstract Integer saveUser(User user);

	public abstract boolean updateUser(User user);

	public abstract boolean deleteUser(User user);

	public abstract int getUserCountByName(String paramString);
	
	public abstract boolean addUser(String userName, String passWord);
}