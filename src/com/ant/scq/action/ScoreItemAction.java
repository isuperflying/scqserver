package com.ant.scq.action;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.ScoreItem;
import com.ant.scq.service.IScoreItemService;
import com.ant.scq.util.MD5Util;
import com.ant.scq.util.WriterUtil;

@SuppressWarnings("serial")
public class ScoreItemAction extends BaseActionSupport {

	@Resource
	private IScoreItemService scoreItemService;
	private ScoreItem scoreItem;
	List<ScoreItem> scoreItemList;

	public IScoreItemService getScoreItemService() {
		return this.scoreItemService;
	}

	public void setScoreItemService(IScoreItemService scoreItemService) {
		this.scoreItemService = scoreItemService;
	}

	public List<ScoreItem> getScoreItemList() {
		return this.scoreItemList;
	}

	public void setScoreItemList(List<ScoreItem> scoreItemList) {
		this.scoreItemList = scoreItemList;
	}

	public ScoreItem getScoreItem() {
		return this.scoreItem;
	}

	public void setScoreItem(ScoreItem scoreItem) {
		this.scoreItem = scoreItem;
	}
	
	public String getDataList() {
		String result = "success";
		try {
			this.totalCount = this.scoreItemService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.scoreItemList = this.scoreItemService.getDataList((this.page - 1)
					* this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}
	
	public String toAdd() {
		return "success";
	}
	
	public String saveScoreItem() {
		String result = "success";
		try {
			boolean res = scoreItemService.saveScoreItem(scoreItem);
			if (!res) {
				result = "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}

	public String toEdit() {
		String result = "success";
		try {
			this.scoreItem = this.scoreItemService.getScoreItemById(scoreItem.getId());
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}
	
	public void updateScoreItem() {
		
		String result = "success";
		boolean isFlag = this.scoreItemService.updateScoreItem(this.scoreItem);
		if (!isFlag) {
			result = "error";
		}
		WriterUtil.writeStr(result);
	}

	
	public void deleteScoreItem() {
		boolean result = this.scoreItemService.deleteScoreItem(this.scoreItem);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}
}