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
import com.ant.scq.entity.SourceInfo;
import com.ant.scq.entity.User;
import com.ant.scq.service.ISourceInfoService;
import com.ant.scq.service.IUserExamService;
import com.ant.scq.util.DateUtil;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.UploadFileUtils;
import com.ant.scq.util.WriterUtil;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class SourceInfoAction extends BaseActionSupport {

	@Resource
	private ISourceInfoService sourceInfoService;
	
	@Resource
	private IUserExamService userExamService;
	
	private SourceInfo sourceInfo;
	
	List<SourceInfo> sourceInfoList;

	private File thumbFile; // 上传的文件
	
	private String thumbFileFileName; // 保存原始文件名
	
	private File scPreFile; // 上传的文件
	
	private String scPreFileFileName; // 保存原始文件名
	
	private File scCreateFile; // 上传的文件
	
	private String scCreateFileFileName; // 保存原始文件名
	
	public ISourceInfoService getSourceInfoService() {
		return this.sourceInfoService;
	}

	public void setSourceInfoService(ISourceInfoService sourceInfoService) {
		this.sourceInfoService = sourceInfoService;
	}
	
	public IUserExamService getUserExamService() {
		return userExamService;
	}

	public void setUserExamService(IUserExamService userExamService) {
		this.userExamService = userExamService;
	}

	public List<SourceInfo> getSourceInfoList() {
		return this.sourceInfoList;
	}

	public void setSourceInfoList(List<SourceInfo> sourceInfoList) {
		this.sourceInfoList = sourceInfoList;
	}

	public SourceInfo getSourceInfo() {
		return this.sourceInfo;
	}

	public void setSourceInfo(SourceInfo sourceInfo) {
		this.sourceInfo = sourceInfo;
	}

	public String toAdd() {
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

	public String getSourceInfoDataList() {
		String result = "success";
		try {
			this.totalCount = this.sourceInfoService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			//this.sourceInfoList = this.sourceInfoService.getDataList((this.page - 1) * this.rows, this.rows);
			User tempUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
			this.sourceInfoList = this.sourceInfoService.getDataListBySql((this.page - 1) * this.rows, this.rows,tempUser.getId()+"");
			System.out.println(JSON.toJSON(sourceInfoList));
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}
	
	
	public void saveSourceInfo() {
		String result = "success";
		try {
			System.out.println("thumbFileName--->" + thumbFileFileName);
			if (sourceInfo != null) {
				
				//System.out.println(JSON.toJSON(sourceInfo));
				
				String thumbSavePath = System.currentTimeMillis() + ".png";
				
				String preImgSavePath = System.currentTimeMillis() + ((int)(Math.random()*10+1) + 10) + ".png";
				
				String createImgSavePath = System.currentTimeMillis() + ((int)(Math.random()*10+1) + 20) + ".png";
				
				System.out.println("图片的名称--->" + thumbSavePath + "---" + preImgSavePath + "---" + createImgSavePath);
				
				if (thumbFile != null) {
					UploadFileUtils.upload4Stream(thumbSavePath, "E:\\word_upload", thumbFile);
				}
				
				if (scPreFile != null) {
					UploadFileUtils.upload4Stream(preImgSavePath, "E:\\word_upload", scPreFile);
				}
				
				if (scCreateFile != null) {
					UploadFileUtils.upload4Stream(createImgSavePath, "E:\\word_upload", scCreateFile);
				}
				
				sourceInfo.setScThumb(thumbSavePath);
				sourceInfo.setScPreImg(preImgSavePath);
				sourceInfo.setScBeforeImg(createImgSavePath);
				sourceInfo.setScAddDate(DateUtil.getCurrentDate());//添加时间
				boolean res = sourceInfoService.saveSourceInfo(sourceInfo);
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
			sourceInfo = this.sourceInfoService.getSourceInfoById(sourceInfo.getId());
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String updateSourceInfo() {
		String result = "success";
		boolean flag = this.sourceInfoService.updateSourceInfo(this.sourceInfo);
		if (!flag) {
			result = "fail";
		}
		return result;
	}

	public void deleteSourceInfo() {
		boolean result = this.sourceInfoService.deleteSourceInfo(this.sourceInfo);
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
//		SourceInfo tSourceInfo = new SourceInfo();
//		tSourceInfo.setId(sourceInfo.getId());
//		userExam.setSourceInfo(tSourceInfo);
//		
//		userExam.setExamState(1);//设置为已考试
//		userExam.setIsMarkScore(0);
//		userExam.setExamUseTime(sourceInfo.getExamScore());
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
		sourceInfo = this.sourceInfoService.getSourceInfoById(sourceInfo.getId());
		
		if(sourceInfo != null){
			//File examTempFile = new File("E:\\word_upload\\" + sourceInfo.getExamFilePath());
			
			 //return new ByteArrayInputStream(("E:\\word_upload\\" + sourceInfo.getExamFilePath()).getBytes());
			
			//return new FileInputStream("E:\\word_upload\\" + sourceInfo.getExamFilePath());
		}
		return null;
	}
	
	 //对于配置中的 ${fileName}, 获得下载保存时的文件名        
     public String getFileName() {
    	 
    	 //System.out.println("getFileName--->" + sourceInfo.getExamFilePath());
    	 
         try {
        	 String fileName = "";
        	 if(sourceInfo != null){
        		 //fileName = sourceInfo.getExamFilePath();
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
			this.sourceInfoList = this.sourceInfoService.getDataListByParams(
					(this.page - 1) * this.rows, this.rows, sourceInfo);
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", sourceInfoList);
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