package com.ant.scq.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.TrainComment;
import com.ant.scq.service.ITrainCommentService;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.WriterUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@SuppressWarnings("serial")
public class TrainCommentAction extends BaseActionSupport {

	@Resource
	private ITrainCommentService trainCommentService;
	private TrainComment trainComment;
	List<TrainComment> trainCommentList;

	public ITrainCommentService getTrainCommentService() {
		return this.trainCommentService;
	}

	public void setTrainCommentService(
			ITrainCommentService trainCommentService) {
		this.trainCommentService = trainCommentService;
	}

	public List<TrainComment> getTrainCommentList() {
		return this.trainCommentList;
	}

	public void setTrainCommentList(List<TrainComment> trainCommentList) {
		this.trainCommentList = trainCommentList;
	}

	public TrainComment getTrainComment() {
		return this.trainComment;
	}

	public void setTrainComment(TrainComment trainComment) {
		this.trainComment = trainComment;
	}

	public String getDataList() {
		String result = "success";
		try {
			this.totalCount = this.trainCommentService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.trainCommentList = this.trainCommentService.getDataList(
					(this.page - 1) * this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String toTrainCommentDetail() {
		trainComment = this.trainCommentService
				.getTrainCommentById(trainComment.getId());
		System.out.println("toTrainCommentDetail------"
				+ trainComment.getId());
		return "success";
	}

	public void deleteTrainComment() {
		boolean result = this.trainCommentService
				.deleteTrainComment(this.trainComment);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

	public void getTrainCommentDataList() {
		List list = this.trainCommentService.getDataList(0, 10);
		String res = "";
		if (null != list && list.size() > 0) {
			res = JSONArray.fromObject(list).toString();
		}
		System.out.println("getTrainCommentDataList---" + res);
		WriterUtil.writeStr(res);
	}

	// -----------------APP接口---------------
	public void findCommentListByTrainIdService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			// 查询机构
			this.trainCommentList = this.trainCommentService
					.getDataListByTrainId((this.page - 1) * this.rows,
							this.rows, trainComment.getTrain().getId());
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", trainCommentList);
		} catch (Exception e) {
			jsonMap.put("code", ErrorConstants.DATA_ERR);
			jsonMap.put("message", "数据处理异常");
			jsonMap.put("data", null);
		} finally {
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[] { "train" });
			WriterUtil.writeStr(JSONObject.fromObject(jsonMap, config)
					.toString());
		}

	}
	
	//新增机构评论
	public void addTrainCommentService(){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			this.trainCommentService.saveTrainComment(trainComment);
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