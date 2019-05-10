package com.ant.scq.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.SubjectComment;
import com.ant.scq.service.ISubjectCommentService;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.WriterUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@SuppressWarnings("serial")
public class SubjectCommentAction extends BaseActionSupport {

	@Resource
	private ISubjectCommentService subjectCommentService;
	private SubjectComment subjectComment;
	List<SubjectComment> subjectCommentList;

	public ISubjectCommentService getSubjectCommentService() {
		return this.subjectCommentService;
	}

	public void setSubjectCommentService(
			ISubjectCommentService subjectCommentService) {
		this.subjectCommentService = subjectCommentService;
	}

	public List<SubjectComment> getSubjectCommentList() {
		return this.subjectCommentList;
	}

	public void setSubjectCommentList(List<SubjectComment> subjectCommentList) {
		this.subjectCommentList = subjectCommentList;
	}

	public SubjectComment getSubjectComment() {
		return this.subjectComment;
	}

	public void setSubjectComment(SubjectComment subjectComment) {
		this.subjectComment = subjectComment;
	}

	public String getDataList() {
		String result = "success";
		try {
			this.totalCount = this.subjectCommentService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.subjectCommentList = this.subjectCommentService.getDataList(
					(this.page - 1) * this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String toSubjectCommentDetail() {
		subjectComment = this.subjectCommentService
				.getSubjectCommentById(subjectComment.getId());
		System.out.println("toSubjectCommentDetail------"
				+ subjectComment.getId());
		return "success";
	}

	public void deleteSubjectComment() {
		boolean result = this.subjectCommentService
				.deleteSubjectComment(this.subjectComment);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

	public void getSubjectCommentDataList() {
		List list = this.subjectCommentService.getDataList(0, 10);
		String res = "";
		if (null != list && list.size() > 0) {
			res = JSONArray.fromObject(list).toString();
		}
		System.out.println("getSubjectCommentDataList---" + res);
		WriterUtil.writeStr(res);
	}

	// -----------------APP接口---------------
	public void findCommentListBySubjectIdService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			// 查询机构
			this.subjectCommentList = this.subjectCommentService
					.getDataListBySubjectId((this.page - 1) * this.rows,
							this.rows, subjectComment.getSubject().getId());
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", subjectCommentList);
		} catch (Exception e) {
			jsonMap.put("code", ErrorConstants.DATA_ERR);
			jsonMap.put("message", "数据处理异常");
			jsonMap.put("data", null);
		} finally {
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[] { "subject" });
			WriterUtil.writeStr(JSONObject.fromObject(jsonMap, config)
					.toString());
		}

	}
	
	//新增话题评论
	public void addSubjectCommentService(){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			this.subjectCommentService.saveSubjectComment(subjectComment);
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
	
}