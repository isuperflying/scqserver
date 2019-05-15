package com.ant.scq.action;

import java.io.File;
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

import com.alibaba.fastjson.JSON;
import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.SourceFieldInfo;
import com.ant.scq.entity.SourceInfo;
import com.ant.scq.entity.User;
import com.ant.scq.service.ISourceFieldInfoService;
import com.ant.scq.service.IUserExamService;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.WriterUtil;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class SourceFieldInfoAction extends BaseActionSupport {

	@Resource
	private ISourceFieldInfoService sourceFieldInfoService;
	
	@Resource
	private IUserExamService userExamService;
	
	private SourceFieldInfo sourceFieldInfo;
	
	List<SourceFieldInfo> sourceFieldInfoList;

	private File thumbFile; // 上传的文件
	
	private String thumbFileFileName; // 保存原始文件名
	
	private File scPreFile; // 上传的文件
	
	private String scPreFileFileName; // 保存原始文件名
	
	private File scCreateFile; // 上传的文件
	
	private String scCreateFileFileName; // 保存原始文件名
	
	private int sid;
	
	public ISourceFieldInfoService getSourceFieldInfoService() {
		return this.sourceFieldInfoService;
	}

	public void setSourceFieldInfoService(ISourceFieldInfoService sourceFieldInfoService) {
		this.sourceFieldInfoService = sourceFieldInfoService;
	}
	
	public IUserExamService getUserExamService() {
		return userExamService;
	}

	public void setUserExamService(IUserExamService userExamService) {
		this.userExamService = userExamService;
	}

	public List<SourceFieldInfo> getSourceFieldInfoList() {
		return this.sourceFieldInfoList;
	}

	public void setSourceFieldInfoList(List<SourceFieldInfo> sourceFieldInfoList) {
		this.sourceFieldInfoList = sourceFieldInfoList;
	}

	public SourceFieldInfo getSourceFieldInfo() {
		return this.sourceFieldInfo;
	}

	public void setSourceFieldInfo(SourceFieldInfo sourceFieldInfo) {
		this.sourceFieldInfo = sourceFieldInfo;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String toAdd() {
		System.out.println("add sid --->" + sourceFieldInfo.getSourceInfo().getId());
		return "success";
	}

	public String toInput() {
		return "success";
	}

	public File getThumbFile() {
		return thumbFile;
	}

	public void setThumbFile(File thumbFile) {
		this.thumbFile = thumbFile;
	}

	public String getThumbFileFileName() {
		return thumbFileFileName;
	}

	public void setThumbFileFileName(String thumbFileFileName) {
		this.thumbFileFileName = thumbFileFileName;
	}

	public File getScPreFile() {
		return scPreFile;
	}

	public void setScPreFile(File scPreFile) {
		this.scPreFile = scPreFile;
	}

	public String getScPreFileFileName() {
		return scPreFileFileName;
	}

	public void setScPreFileFileName(String scPreFileFileName) {
		this.scPreFileFileName = scPreFileFileName;
	}

	public File getScCreateFile() {
		return scCreateFile;
	}

	public void setScCreateFile(File scCreateFile) {
		this.scCreateFile = scCreateFile;
	}

	public String getScCreateFileFileName() {
		return scCreateFileFileName;
	}

	public void setScCreateFileFileName(String scCreateFileFileName) {
		this.scCreateFileFileName = scCreateFileFileName;
	}

	public String getSourceFieldInfoDataList() {
		String result = "success";
		try {
			this.totalCount = this.sourceFieldInfoService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			//this.sourceFieldInfoList = this.sourceFieldInfoService.getDataList((this.page - 1) * this.rows, this.rows);
			User tempUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
			this.sourceFieldInfoList = this.sourceFieldInfoService.getDataListBySql((this.page - 1) * this.rows, this.rows,tempUser.getId()+"");
			System.out.println(JSON.toJSON(sourceFieldInfoList));
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String getSourceFieldInfoDataListBySid() {
		String result = "success";
		try {
			System.out.println("list sid --->" + sourceFieldInfo.getSourceInfo().getId());
			this.sid = sourceFieldInfo.getSourceInfo().getId();
			this.totalCount = this.sourceFieldInfoService.getDataListcountBySid(sourceFieldInfo.getSourceInfo().getId());
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			
			this.sourceFieldInfoList = this.sourceFieldInfoService.getDataListBySid((this.page - 1) * this.rows, this.rows,sourceFieldInfo.getSourceInfo().getId());
			System.out.println(JSON.toJSON(sourceFieldInfoList));
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}
	
	public void saveSourceFieldInfo() {
		System.out.println("save--->" + sourceFieldInfo.getSourceInfo().getId());
		String result = "success";
		try {
			boolean res = sourceFieldInfoService.saveSourceFieldInfo(sourceFieldInfo);
			if (!res) {
				result = "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		WriterUtil.writeStr(result);
	}

	public String toEdit() {
		String result = "success";
		try {
			sourceFieldInfo = this.sourceFieldInfoService.getSourceFieldInfoById(sourceFieldInfo.getId());
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String updateSourceFieldInfo() {
		String result = "success";
		boolean flag = this.sourceFieldInfoService.updateSourceFieldInfo(this.sourceFieldInfo);
		if (!flag) {
			result = "fail";
		}
		return result;
	}

	public void deleteSourceFieldInfo() {
		boolean result = this.sourceFieldInfoService.deleteSourceFieldInfo(this.sourceFieldInfo);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

	
	public void saveUserExamState() {
		
//		UserExam userExam = new UserExam();
//		User tempUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
//		if(tempUser != null){			
//			userExam.setUser(tempUser);
//		}
//		SourceFieldInfo tSourceFieldInfo = new SourceFieldInfo();
//		tSourceFieldInfo.setId(sourceFieldInfo.getId());
//		userExam.setSourceFieldInfo(tSourceFieldInfo);
//		
//		userExam.setExamState(1);//设置为已考试
//		userExam.setIsMarkScore(0);
//		userExam.setExamUseTime(sourceFieldInfo.getExamScore());
//		boolean result = this.userExamService.saveUserExam(userExam);
//		if (result)
//			WriterUtil.writeStr("success");
//		else
//			WriterUtil.writeStr("error");
	}
	
	// 判断文件类型
	public Workbook createWorkBook(InputStream is) throws IOException {
		if (thumbFileFileName.toLowerCase().endsWith("xls")) {
			return new HSSFWorkbook(is);
		}
		if (thumbFileFileName.toLowerCase().endsWith("xlsx")) {
			return new XSSFWorkbook(is);
		}
		return null;
	}

	 public InputStream getDownloadFile() throws IOException {
		sourceFieldInfo = this.sourceFieldInfoService.getSourceFieldInfoById(sourceFieldInfo.getId());
		
		if(sourceFieldInfo != null){
			//File examTempFile = new File("E:\\word_upload\\" + sourceFieldInfo.getExamFilePath());
			
			 //return new ByteArrayInputStream(("E:\\word_upload\\" + sourceFieldInfo.getExamFilePath()).getBytes());
			
			//return new FileInputStream("E:\\word_upload\\" + sourceFieldInfo.getExamFilePath());
		}
		return null;
	}
	
	 //对于配置中的 ${fileName}, 获得下载保存时的文件名        
     public String getFileName() {
    	 
    	 //System.out.println("getFileName--->" + sourceFieldInfo.getExamFilePath());
    	 
         try {
        	 String fileName = "";
        	 if(sourceFieldInfo != null){
        		 //fileName = sourceFieldInfo.getExamFilePath();
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
			this.sourceFieldInfoList = this.sourceFieldInfoService.getDataListByParams(
					(this.page - 1) * this.rows, this.rows, sourceFieldInfo);
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", sourceFieldInfoList);
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
}