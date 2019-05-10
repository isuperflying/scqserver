package com.ant.scq.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.Subject;
import com.ant.scq.entity.SubjectItem;
import com.ant.scq.service.ISubjectService;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.WriterUtil;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class SubjectAction extends BaseActionSupport {

	@Resource
	private ISubjectService subjectService;
	private Subject subject;
	List<Subject> subjectList;

	public ISubjectService getSubjectService() {
		return this.subjectService;
	}

	public void setSubjectService(ISubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public List<Subject> getSubjectList() {
		return this.subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDataList() {
		String result = "success";
		try {
			this.totalCount = this.subjectService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.subjectList = this.subjectService.getDataList((this.page - 1)
					* this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String saveSubject() {
		String result = "success";
		System.out.println("选项内容--" + subject.getSubjectContent());

		String subjectContent[] = subject.getSubjectContent().split("#!");
		List<SubjectItem> list = new ArrayList<SubjectItem>();
		if (list != null && list.size() > 0) {
			list.clear();
		}

		for (int i = 0; i < subjectContent.length; i++) {
			if (subjectContent[i] != null
					&& subjectContent[i].trim().length() > 0) {
				SubjectItem subjectItem = new SubjectItem();
				if (i == 0) {
					subjectItem.setItemCode("A");
				} else if (i == 1) {
					subjectItem.setItemCode("B");
				} else if (i == 2) {
					subjectItem.setItemCode("C");
				} else if (i == 3) {
					subjectItem.setItemCode("D");
				} else {
					// subjectItem.setItemCode("E");
				}
				subjectItem.setItemContent(subjectContent[i].trim());
				subjectItem.setItemSelectCount(0);
				subjectItem.setSubject(subject);
				list.add(subjectItem);
			}
		}

		subject.setSubjectItemList(list);

		int id = this.subjectService.saveSubject(subject);
		subject.setId(id);
		ActionContext.getContext().getSession().put("CURRENT_SUBJECT", subject);
		if (id > 0) {
			result = "success";
		} else {
			result = "error";
		}

		return result;
	}

	public String toSubjectDetail() {
		subject = this.subjectService.getSubjectById(subject.getId());
		System.out.println("toSubjectDetail------" + subject.getId());
		return "success";
	}

	public String toSubjectResult() {
		subject = this.subjectService.getSubjectById(subject.getId());
		System.out.println("结果--" + subject.getId());
		return "success";
	}

	public void updateSubject() {
		boolean result = this.subjectService.updateSubject(this.subject);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

	public void deleteSubject() {
		boolean result = this.subjectService.deleteSubject(this.subject);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

	public void getSubjectDataList() {
		List list = this.subjectService.getDataList(0, 10);
		String res = "";
		if (null != list && list.size() > 0) {
			res = JSONArray.fromObject(list).toString();
		}
		System.out.println("getSubjectDataList---" + res);
		WriterUtil.writeStr(res);
	}

	// -----------------APP接口---------------
	public void findSubjectListService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			// 查询机构
			this.subjectList = this.subjectService.getDataList((this.page - 1)
					* this.rows, this.rows);
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", subjectList);
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

	public void addSubjectService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			
			//String temp = new String(subject.getSubjectContent().getBytes("iso8859-1"),"UTF-8");
			
			System.out.println("---修改后---"+subject.getSubjectContent());
			
			String subjectContent[] = subject.getSubjectContent().split("#!");
			List<SubjectItem> list = new ArrayList<SubjectItem>();
			if (list != null && list.size() > 0) {
				list.clear();
			}

			for (int i = 0; i < subjectContent.length; i++) {
				if (subjectContent[i] != null
						&& subjectContent[i].trim().length() > 0) {
					SubjectItem subjectItem = new SubjectItem();
					if (i == 0) {
						subjectItem.setItemCode("A");
					} else if (i == 1) {
						subjectItem.setItemCode("B");
					} else if (i == 2) {
						subjectItem.setItemCode("C");
					} else if (i == 3) {
						subjectItem.setItemCode("D");
					} else {
						// subjectItem.setItemCode("E");
					}
					subjectItem.setItemContent(subjectContent[i].trim());
					subjectItem.setItemSelectCount(0);
					subjectItem.setSubject(subject);
					list.add(subjectItem);
				}
			}

			subject.setSubjectItemList(list);

			this.subjectService.saveSubject(subject);

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