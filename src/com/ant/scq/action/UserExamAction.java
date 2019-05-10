package com.ant.scq.action;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.ScoreItem;
import com.ant.scq.entity.UserExam;
import com.ant.scq.service.IScoreItemService;
import com.ant.scq.service.IUserExamService;
import com.ant.scq.util.WriterUtil;

@SuppressWarnings("serial")
public class UserExamAction extends BaseActionSupport {

	@Resource
	private IUserExamService userExamService;
	
	@Resource
	private IScoreItemService scoreItemService;
	
	private UserExam userExam;
	
	List<UserExam> userExamList;

	List<UserExam> examRecordList;
	
	List<ScoreItem> scoreItemList;
	
	public IUserExamService getUserExamService() {
		return this.userExamService;
	}

	public void setUserExamService(IUserExamService userExamService) {
		this.userExamService = userExamService;
	}

	public IScoreItemService getScoreItemService() {
		return scoreItemService;
	}

	public void setScoreItemService(IScoreItemService scoreItemService) {
		this.scoreItemService = scoreItemService;
	}

	public List<UserExam> getUserExamList() {
		return this.userExamList;
	}

	public void setUserExamList(List<UserExam> userExamList) {
		this.userExamList = userExamList;
	}

	public List<UserExam> getExamRecordList() {
		return examRecordList;
	}

	public void setExamRecordList(List<UserExam> examRecordList) {
		this.examRecordList = examRecordList;
	}

	public List<ScoreItem> getScoreItemList() {
		return scoreItemList;
	}

	public void setScoreItemList(List<ScoreItem> scoreItemList) {
		this.scoreItemList = scoreItemList;
	}

	public UserExam getUserExam() {
		return this.userExam;
	}

	public void setUserExam(UserExam userExam) {
		this.userExam = userExam;
	}

	public String toAdd() {
		return "success";
	}

	public String toInput() {
		return "success";
	}

	public String getUserExamDataList() {
		String result = "success";
		try {
			this.totalCount = this.userExamService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.userExamList = this.userExamService.getDataList((this.page - 1) * this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}
	
	public String getExamDataListByExamId() {
		String result = "success";
		try {
			this.totalCount = this.userExamService.getExamCountByExamId(userExam.getExamInfo().getId());
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.examRecordList = this.userExamService.getDataListByExamId((this.page - 1) * this.rows, this.rows, userExam.getExamInfo().getId());
			this.scoreItemList = this.scoreItemService.getAllDataList();
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}
	
	public String saveUserExam() {
		String result = "success";
		try {
			boolean res = userExamService.saveUserExam(userExam);
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
			userExam = this.userExamService.getUserExamById(userExam.getId());
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String updateUserExam() {
		String result = "success";
		boolean flag = this.userExamService.updateUserExam(this.userExam);
		if (!flag) {
			result = "fail";
		}
		return result;
	}
	
	public void updateUserExamScore() {
		
		UserExam tUserExam = this.userExamService.getUserExamById(userExam.getId());
		tUserExam.setExamScore(userExam.getExamScore());
		tUserExam.setIsMarkScore(1);
		boolean result = this.userExamService.updateUserExam(tUserExam);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}
	
	public void deleteUserExam() {
		boolean result = this.userExamService.deleteUserExam(this.userExam);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}
	
}