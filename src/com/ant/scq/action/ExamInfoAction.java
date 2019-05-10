package com.ant.scq.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.ExamInfo;
import com.ant.scq.entity.User;
import com.ant.scq.entity.UserExam;
import com.ant.scq.service.IExamInfoService;
import com.ant.scq.service.IUserExamService;
import com.ant.scq.util.DateUtil;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.UploadFileUtils;
import com.ant.scq.util.WriterUtil;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class ExamInfoAction extends BaseActionSupport {

	@Resource
	private IExamInfoService examInfoService;
	
	@Resource
	private IUserExamService userExamService;
	
	private ExamInfo examInfo;
	
	List<ExamInfo> examInfoList;

	private File excelFile; // 上传的文件
	private String excelFileFileName; // 保存原始文件名

	public IExamInfoService getExamInfoService() {
		return this.examInfoService;
	}

	public void setExamInfoService(IExamInfoService examInfoService) {
		this.examInfoService = examInfoService;
	}
	
	public IUserExamService getUserExamService() {
		return userExamService;
	}

	public void setUserExamService(IUserExamService userExamService) {
		this.userExamService = userExamService;
	}

	public List<ExamInfo> getExamInfoList() {
		return this.examInfoList;
	}

	public void setExamInfoList(List<ExamInfo> examInfoList) {
		this.examInfoList = examInfoList;
	}

	public ExamInfo getExamInfo() {
		return this.examInfo;
	}

	public void setExamInfo(ExamInfo examInfo) {
		this.examInfo = examInfo;
	}

	public String toAdd() {
		return "success";
	}

	public String toInput() {
		return "success";
	}

	public String getExamInfoDataList() {
		String result = "success";
		try {
			this.totalCount = this.examInfoService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			//this.examInfoList = this.examInfoService.getDataList((this.page - 1) * this.rows, this.rows);
			User tempUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
			this.examInfoList = this.examInfoService.getDataListBySql((this.page - 1) * this.rows, this.rows,tempUser.getId()+"");
			
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String saveExamInfo() {
		String result = "success";
		try {
			boolean res = examInfoService.saveExamInfo(examInfo);
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
			examInfo = this.examInfoService.getExamInfoById(examInfo.getId());
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String updateExamInfo() {
		String result = "success";
		boolean flag = this.examInfoService.updateExamInfo(this.examInfo);
		if (!flag) {
			result = "fail";
		}
		return result;
	}

	public void deleteExamInfo() {
		boolean result = this.examInfoService.deleteExamInfo(this.examInfo);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

	
	public void saveUserExamState() {
		
		UserExam userExam = new UserExam();
		User tempUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(tempUser != null){			
			userExam.setUser(tempUser);
		}
		ExamInfo tExamInfo = new ExamInfo();
		tExamInfo.setId(examInfo.getId());
		userExam.setExamInfo(tExamInfo);
		
		userExam.setExamState(1);//设置为已考试
		userExam.setIsMarkScore(0);
		userExam.setExamUseTime(examInfo.getExamScore());
		boolean result = this.userExamService.saveUserExam(userExam);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}
	
	// 判断文件类型
	public Workbook createWorkBook(InputStream is) throws IOException {
		if (excelFileFileName.toLowerCase().endsWith("xls")) {
			return new HSSFWorkbook(is);
		}
		if (excelFileFileName.toLowerCase().endsWith("xlsx")) {
			return new XSSFWorkbook(is);
		}
		return null;
	}

	public void inputExamFile() {
		String result = "success";
		try {
			System.out.println("excelFileFileName--->" + excelFileFileName);
			if (examInfo != null) {
				
				String addFilePath = System.currentTimeMillis() + ".png";
				
				if (excelFile != null) {
					UploadFileUtils.upload4Stream(addFilePath, "E:\\word_upload", excelFile);
				}
				
				examInfo.setExamFilePath(addFilePath);
				examInfo.setExamAddDate(DateUtil.getCurrentDate());//当前时间
				boolean res = examInfoService.saveExamInfo(examInfo);
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

	 public InputStream getDownloadFile() throws IOException {
		examInfo = this.examInfoService.getExamInfoById(examInfo.getId());
		
		if(examInfo != null){
			//File examTempFile = new File("E:\\word_upload\\" + examInfo.getExamFilePath());
			
			 //return new ByteArrayInputStream(("E:\\word_upload\\" + examInfo.getExamFilePath()).getBytes());
			
			return new FileInputStream("E:\\word_upload\\" + examInfo.getExamFilePath());
		}
		return null;
	}
	
	 //对于配置中的 ${fileName}, 获得下载保存时的文件名        
     public String getFileName() {
    	 
    	 System.out.println("getFileName--->" + examInfo.getExamFilePath());
    	 
         try {
        	 String fileName = "";
        	 if(examInfo != null){
        		 fileName = examInfo.getExamFilePath();
        	 }else{
        		 fileName = "序列号-" + System.currentTimeMillis() + ".doc";
        	 }
        	 
             //中文文件名也是需要转码为 ISO8859-1，否则乱码        
             return new String(fileName.getBytes(), "ISO8859-1");
         } catch (Exception e) {        
             return "impossible.txt";        
         }        
     }     
	 
	// -----------------APP接口---------------
	public void findTrainService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			// 查询机构
			this.examInfoList = this.examInfoService.getDataListByParams(
					(this.page - 1) * this.rows, this.rows, examInfo);
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", examInfoList);
		} catch (Exception e) {
			jsonMap.put("code", ErrorConstants.DATA_ERR);
			jsonMap.put("message", "数据处理异常");
			jsonMap.put("data", null);
		} finally {
			WriterUtil.writeStr(JSONObject.fromObject(jsonMap).toString());
		}

	}

	/**
	 * 判断字符串时候为数值
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]*)?$");
		return pattern.matcher(str).matches();
	}

	public File getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}

	public String getExcelFileFileName() {
		return excelFileFileName;
	}

	public void setExcelFileFileName(String excelFileFileName) {
		this.excelFileFileName = excelFileFileName;
	}

}