package com.ant.scq.action;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.SpecialInfo;
import com.ant.scq.service.ISpecialInfoService;
import com.ant.scq.util.DateUtil;
import com.ant.scq.util.JsonResult;
import com.ant.scq.util.UploadFileUtils;
import com.ant.scq.util.WriterUtil;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class SpecialInfoAction extends BaseActionSupport {

	@Resource
	private ISpecialInfoService specialInfoService;

	private SpecialInfo specialInfo;

	List<SpecialInfo> specialInfoList;

	private File coverFile; // 上传的文件

	private String coverFileFileName; // 保存原始文件名

	public File getCoverFile() {
		return coverFile;
	}

	public void setCoverFile(File coverFile) {
		this.coverFile = coverFile;
	}

	public String getCoverFileFileName() {
		return coverFileFileName;
	}

	public void setCoverFileFileName(String coverFileFileName) {
		this.coverFileFileName = coverFileFileName;
	}

	public ISpecialInfoService getSpecialInfoService() {
		return this.specialInfoService;
	}

	public void setSpecialInfoService(ISpecialInfoService specialInfoService) {
		this.specialInfoService = specialInfoService;
	}

	public List<SpecialInfo> getSpecialInfoList() {
		return this.specialInfoList;
	}

	public void setSpecialInfoList(List<SpecialInfo> specialInfoList) {
		this.specialInfoList = specialInfoList;
	}

	public SpecialInfo getSpecialInfo() {
		return this.specialInfo;
	}

	public void setSpecialInfo(SpecialInfo specialInfo) {
		this.specialInfo = specialInfo;
	}

	public String toAdd() {
		return "success";
	}

	public String toInput() {
		return "success";
	}

	public void getAllSpecialInfoByLevel() {
		JsonResult json = null;
		List<SpecialInfo> specialInfoList = specialInfoService.getAllSpecialInfoByLevel("2");
		if (specialInfoList != null) {
			json = new JsonResult(true, "success", specialInfoList);
		} else {
			json = new JsonResult(false, "fail", null);
		}
		WriterUtil.writeStr(JSONObject.fromObject(json).toString());
	}

	public String getSpecialInfoDataList() {
		String result = "success";
		try {
			this.totalCount = this.specialInfoService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.specialInfoList = this.specialInfoService.getDataList((this.page - 1) * this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public void saveSpecialInfo() {

		String result = "success";
		try {
			System.out.println("coverFileName--->" + coverFileFileName);
			if (specialInfo != null) {

				// System.out.println(JSON.toJSON(sourceInfo));

				String thumbSavePath = System.currentTimeMillis() + ".png";

				System.out.println("封面图片的名称--->" + thumbSavePath);

				if (coverFile != null) {
					UploadFileUtils.upload4Stream(thumbSavePath, "E:\\word_upload", coverFile);
				}

				specialInfo.setCover(thumbSavePath);
				specialInfo.setAddDate(DateUtil.getCurrentDate());// 添加时间
				boolean res = specialInfoService.saveSpecialInfo(specialInfo);
				if (!res) {
					result = "error";
				}
			}

		} catch (Exception e) {
			result = "error";
			e.printStackTrace();
		}
		WriterUtil.writeStr(result);

	}

	public String toEdit() {
		String result = "success";
		try {
			specialInfo = this.specialInfoService.getSpecialInfoById(specialInfo.getId());
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String updateSpecialInfo() {
		String result = "success";
		boolean flag = this.specialInfoService.updateSpecialInfo(this.specialInfo);
		if (!flag) {
			result = "fail";
		}
		return result;
	}

	public void deleteSpecialInfo() {
		boolean result = this.specialInfoService.deleteSpecialInfo(this.specialInfo);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

}