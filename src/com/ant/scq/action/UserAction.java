package com.ant.scq.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.User;
import com.ant.scq.service.IUserService;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.MD5Util;
import com.ant.scq.util.SendMessageTools;
import com.ant.scq.util.WriterUtil;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class UserAction extends BaseActionSupport {

	@Resource
	private IUserService userService;
	private User user;
	private List<User> userList;

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return this.userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public IUserService getUserService() {
		return this.userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String userLogin() {
		String result = "success";
		user = userService.getUserByParams(user.getUserName(),
				MD5Util.MD5Encode(user.getPassWord()));
		if (user == null) {
			result = "fail";
		}
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		return result;
	}
	
	public void addUser() {
		String result = "success";
		user.setUserType(0);//普通用户
		boolean isFlag = userService.addUser(user.getUserName(), MD5Util.MD5Encode(user.getPassWord()));
		if (!isFlag) {
			result = "error";
		}
		WriterUtil.writeStr(result);
	}
	
	public String getUserDataList() {
		String result = "success";
		try {
			this.totalCount = this.userService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.userList = this.userService.getDataList((this.page - 1)
					* this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String saveUser() {
		String result = "success";

		int count = this.userService.getUserCountByName(this.user.getUserName());

		if (count == 0) {
			int flag = this.userService.saveUser(this.user);
			if (flag > 0)
				result = "error";
		} else {
			result = "error";
		}
		WriterUtil.writeStr(result);
		return null;
	}

	public String toEdit() {
		String result = "success";
		try {
			user = this.userService.getUserById(user.getId());
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String updateUser() {
		String result = "success";
		boolean flag = this.userService.updateUser(this.user);
		if (!flag){			
			result = "fail";
		}
		return result;
	}

	public void deleteUser() {
		boolean result = this.userService.deleteUser(this.user);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

	// -----------------APP接口---------------

	/**
	 * 获取短信验证码接口
	 */
	public void findSecurityService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		SendMessageTools sendUtil = SendMessageTools.getInstance();

		boolean flag = sendUtil.sendMessage(user.getUserName(), user.getSecurity());
		if (flag) {
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "短信验证码发送成功");
			jsonMap.put("data", null);
		} else {
			jsonMap.put("code", ErrorConstants.DATA_ERR);
			jsonMap.put("message", "短信验证码发送失败，请稍后重试!");
			jsonMap.put("data", null);
		}

		WriterUtil.writeStr(JSONObject.fromObject(jsonMap).toString());
	}

	/**
	 * 用户登录
	 */
	public void userLoginService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		User userInfo = userService.getUserByParams(user.getUserName(),
				MD5Util.MD5Encode(user.getPassWord()));
		if (userInfo == null) {
			jsonMap.put("code", ErrorConstants.AUTHENTICATION_ERR);
			jsonMap.put("message", "用户名或密码错误");
			jsonMap.put("data", null);
		} else {
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", userInfo);
		}
		WriterUtil.writeStr(JSONObject.fromObject(jsonMap).toString());
	}
	/**
	 * 用户注册
	 */
	public void userRegisterService() {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = this.userService.getUserCountByName(this.user.getUserName());
		if (count == 0) {
			//将密码加密
			user.setPassWord(MD5Util.MD5Encode(user.getPassWord()));
			int userId = this.userService.saveUser(this.user);
			if (userId > 0){
				User tempUser = this.userService.getUserById(userId);
				jsonMap.put("code", ErrorConstants.SUCCESS);
				jsonMap.put("message", "注册成功");
				jsonMap.put("data", tempUser);
			}else{
				jsonMap.put("code", ErrorConstants.AUTHENTICATION_ERR);
				jsonMap.put("message", "注册失败");
				jsonMap.put("data", null);
			}
		} else {
			jsonMap.put("code", ErrorConstants.AUTHENTICATION_ERR);
			jsonMap.put("message", "你已经注册过账号，请直接登录");
			jsonMap.put("data", null);
		}
		
		WriterUtil.writeStr(JSONObject.fromObject(jsonMap).toString());
	}
	
}