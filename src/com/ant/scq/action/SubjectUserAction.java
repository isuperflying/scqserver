package com.ant.scq.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.SubjectUser;
import com.ant.scq.service.ISubjectUserService;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.WriterUtil;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class SubjectUserAction extends BaseActionSupport {

	@Resource
	private ISubjectUserService subjectUserService;
	private SubjectUser subjectUser;
	List<SubjectUser> subjectUserList;

	public ISubjectUserService getSubjectUserService() {
		return this.subjectUserService;
	}

	public void setSubjectUserService(ISubjectUserService subjectUserService) {
		this.subjectUserService = subjectUserService;
	}

	public List<SubjectUser> getSubjectUserList() {
		return this.subjectUserList;
	}

	public void setSubjectUserList(List<SubjectUser> subjectUserList) {
		this.subjectUserList = subjectUserList;
	}

	public SubjectUser getSubjectUser() {
		return this.subjectUser;
	}

	public void setSubjectUser(SubjectUser subjectUser) {
		this.subjectUser = subjectUser;
	}

	// --------APP接口
	/**
	 * 发起投票
	 */
	public void addSubjectTopicService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			this.subjectUserService.saveSubjectUser(subjectUser);
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", null);
		} catch (Exception e) {
			jsonMap.put("code", ErrorConstants.DATA_ERR);
			jsonMap.put("message", "数据处理异常");
			jsonMap.put("data", null);
		} finally {
			WriterUtil.writeStr(JSONObject.fromObject(jsonMap).toString());
		}
	}

	public void getSubjectUserDataList() {

	}

}