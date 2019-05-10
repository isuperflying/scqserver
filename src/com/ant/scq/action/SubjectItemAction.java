package com.ant.scq.action;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.SubjectItem;
import com.ant.scq.service.ISubjectItemService;
import com.ant.scq.util.WriterUtil;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class SubjectItemAction extends BaseActionSupport {

	@Resource
	private ISubjectItemService subjectItemService;
	private SubjectItem subjectItem;
	List<SubjectItem> subjectItemList;

	public ISubjectItemService getSubjectItemService() {
		return this.subjectItemService;
	}

	public void setSubjectItemService(ISubjectItemService subjectItemService) {
		this.subjectItemService = subjectItemService;
	}

	public List<SubjectItem> getSubjectItemList() {
		return this.subjectItemList;
	}

	public void setSubjectItemList(List<SubjectItem> subjectItemList) {
		this.subjectItemList = subjectItemList;
	}

	public SubjectItem getSubjectItem() {
		return this.subjectItem;
	}

	public void setSubjectItem(SubjectItem subjectItem) {
		this.subjectItem = subjectItem;
	}
	
	public String getDataList() {
		String result = "success";
		try {
			this.totalCount = this.subjectItemService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.subjectItemList = this.subjectItemService.getDataList((this.page - 1)
					* this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String toSubjectItemDetail(){
		subjectItem = this.subjectItemService.getSubjectItemById(subjectItem.getId());
		System.out.println("toSubjectItemDetail------"+subjectItem.getId());
		return "success";
	}
	
	
	public String updateSubjectItem() {
		String result = "success";
		subjectItem = this.subjectItemService.getSubjectItemById(subjectItem.getId());
		subjectItem.setItemSelectCount(subjectItem.getItemSelectCount()+1);
		boolean res = this.subjectItemService.updateSubjectItem(this.subjectItem);
		if (res)
			result = "success";
		else
			result = "fail";
		return result;
	}

	public void updateSubjectItemCount() {
		int res = this.subjectItemService.updateSubjectItemCount(this.subjectItem);
		if (res > 0)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}
	
	
	public void deleteSubjectItem() {
		boolean result = this.subjectItemService.deleteSubjectItem(this.subjectItem);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

	public void getSubjectItemDataList() {
		List list = this.subjectItemService.getDataList(0, 10);
		String res = "";
		if (null != list && list.size() > 0) {
			res = JSONArray.fromObject(list).toString();
		}
		System.out.println("getSubjectItemDataList---" + res);
		WriterUtil.writeStr(res);
	}

}