package com.ant.scq.action;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.BaseData;
import com.ant.scq.service.IBaseDataService;
import com.ant.scq.util.WriterUtil;

@SuppressWarnings("serial")
public class BaseDataAction extends BaseActionSupport {

	@Resource
	private IBaseDataService baseDataService;
	private BaseData baseData;
	List<BaseData> baseDataList;

	public IBaseDataService getBaseDataService() {
		return this.baseDataService;
	}

	public void setBaseDataService(IBaseDataService baseDataService) {
		this.baseDataService = baseDataService;
	}

	public List<BaseData> getBaseDataList() {
		return this.baseDataList;
	}

	public void setBaseDataList(List<BaseData> baseDataList) {
		this.baseDataList = baseDataList;
	}

	public BaseData getBaseData() {
		return this.baseData;
	}

	public void setBaseData(BaseData baseData) {
		this.baseData = baseData;
	}

	public String getDataList() {
		String result = "success";
		try {
			this.totalCount = this.baseDataService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.baseDataList = this.baseDataService.getDataList(
					(this.page - 1) * this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String saveBaseData() {
		String result = "success";

		int count = this.baseDataService.getBaseDataCountByName(this.baseData
				.getBaseDataName());

		if (count == 0) {
			int flag = this.baseDataService.saveBaseData(this.baseData);
			if (flag > 0)
				result = "error";
		} else {
			result = "error";
		}
		WriterUtil.writeStr(result);
		return null;
	}

	public void updateBaseData() {
		boolean result = this.baseDataService.updateBaseData(this.baseData);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

	public void deleteBaseData() {
		boolean result = this.baseDataService.deleteBaseData(this.baseData);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}
}