package com.ant.scq.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.TeacherInfo;
import com.ant.scq.entity.TrainInfo;
import com.ant.scq.service.ITeacherInfoService;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.ExcelWorkSheet;
import com.ant.scq.util.WriterUtil;

@SuppressWarnings("serial")
public class TeacherInfoAction extends BaseActionSupport {

	@Resource
	private ITeacherInfoService teacherInfoService;
	private TeacherInfo teacherInfo;
	List<TeacherInfo> teacherInfoList;

	private String trainInfoId;

	private File excelFile; // 上传的文件
	private String excelFileFileName; // 保存原始文件名

	// 将Excel文件解析完毕后信息存放到这个对象中
	private ExcelWorkSheet<TeacherInfo> excelWorkSheet;

	public ITeacherInfoService getTeacherInfoService() {
		return this.teacherInfoService;
	}

	public void setTeacherInfoService(ITeacherInfoService teacherInfoService) {
		this.teacherInfoService = teacherInfoService;
	}

	public List<TeacherInfo> getTeacherInfoList() {
		return this.teacherInfoList;
	}

	public void setTeacherInfoList(List<TeacherInfo> teacherInfoList) {
		this.teacherInfoList = teacherInfoList;
	}

	public TeacherInfo getTeacherInfo() {
		return this.teacherInfo;
	}

	public void setTeacherInfo(TeacherInfo teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	public String toAdd() {
		return "success";
	}

	public String toInput() {
		return "success";
	}

	public String getTrainInfoId() {
		return trainInfoId;
	}

	public void setTrainInfoId(String trainInfoId) {
		this.trainInfoId = trainInfoId;
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

	public ExcelWorkSheet<TeacherInfo> getExcelWorkSheet() {
		return excelWorkSheet;
	}

	public void setExcelWorkSheet(ExcelWorkSheet<TeacherInfo> excelWorkSheet) {
		this.excelWorkSheet = excelWorkSheet;
	}

	public String getTeacherInfoDataList() {
		String result = "success";
		try {
			this.totalCount = this.teacherInfoService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.teacherInfoList = this.teacherInfoService.getDataList(
					(this.page - 1) * this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String saveTeacherInfo() {
		String result = "success";
		try {
			boolean res = teacherInfoService.saveTeacherInfo(teacherInfo);
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
			teacherInfo = this.teacherInfoService
					.getTeacherInfoById(teacherInfo.getId());
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String updateTeacherInfo() {
		String result = "success";
		boolean flag = this.teacherInfoService
				.updateTeacherInfo(this.teacherInfo);
		if (!flag) {
			result = "fail";
		}
		return result;
	}

	public void deleteTeacherInfo() {
		boolean result = this.teacherInfoService
				.deleteTeacherInfo(this.teacherInfo);
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

	public void inputTeacherInfoExcel() {
		try {
			Workbook book = createWorkBook(new FileInputStream(excelFile));
			// book.getNumberOfSheets(); 判断Excel文件有多少个sheet
			Sheet sheet = book.getSheetAt(0);
			excelWorkSheet = new ExcelWorkSheet<TeacherInfo>();
			// 保存工作单名称
			Row firstRow = sheet.getRow(0);
			Iterator<Cell> iterator = firstRow.iterator();

			// 保存列名
			List<String> cellNames = new ArrayList<String>();
			while (iterator.hasNext()) {
				cellNames.add(iterator.next().getStringCellValue());
			}
			excelWorkSheet.setColumns(cellNames);
			
			TrainInfo trainInfo = new TrainInfo();
			if(trainInfoId != null){
				trainInfo.setId(Integer.parseInt(trainInfoId));
			}
			
			for (int i = 8; i <= sheet.getLastRowNum(); i++) {
				Row ros = sheet.getRow(i);
				TeacherInfo teacherInfo = new TeacherInfo();

				if (ros.getCell(0) != null) {
					ros.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					teacherInfo.setTeacherNumber(ros.getCell(0).getStringCellValue());
				}

				if (ros.getCell(1) != null) {
					ros.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
					teacherInfo.setTeacherName(ros.getCell(1)
							.getStringCellValue());
				}
				if (ros.getCell(2) != null) {
					ros.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
					teacherInfo.setSex(Integer.parseInt(ros.getCell(2)
							.getStringCellValue()));
				}
				if (ros.getCell(3) != null) {
					ros.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
					teacherInfo.setAge(Integer.parseInt(ros.getCell(3)
							.getStringCellValue()));
				}
				if (ros.getCell(4) != null) {
					ros.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
					teacherInfo.setTeacherAge(Float.parseFloat(ros.getCell(4)
							.getStringCellValue()));
				}
				if (ros.getCell(5) != null) {
					ros.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					teacherInfo.setPhoneNumber(ros.getCell(5)
							.getStringCellValue());
				}
				if (ros.getCell(6) != null) {
					ros.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
					teacherInfo.setEmailNumber(ros.getCell(6)
							.getStringCellValue());
				}
				if (ros.getCell(7) != null) {
					ros.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
					teacherInfo.setTeacherSpecial(ros.getCell(7)
							.getStringCellValue());
				}
				if (ros.getCell(8) != null) {
					ros.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
					teacherInfo.setTeacherStrong(ros.getCell(8)
							.getStringCellValue());
				}
				if (ros.getCell(9) != null) {
					ros.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
					teacherInfo.setRemark(ros.getCell(9)
							.getStringCellValue());
				}
				teacherInfo.setTrainId(trainInfo);
				excelWorkSheet.getData().add(teacherInfo);
			}

			List<TeacherInfo> teacherInfoList = excelWorkSheet.getData();
			boolean result = true;
			try {
				teacherInfoService.saveTeacherInfoList(teacherInfoList);
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
			if (result)
				WriterUtil.writeStr("success");
			else
				WriterUtil.writeStr("error");
		} catch (Exception e) {
			e.printStackTrace();
			WriterUtil.writeStr("error");
		}
	}
	
	//-------------APP接口--------------------
	
	/**
	 * 查询机构下的老师
	 */
	public void findTeacherByTrainIdService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			//查询精选课程
			this.teacherInfoList = this.teacherInfoService.getDataListByTrainId(
					(this.page - 1) * this.rows, this.rows, teacherInfo.getTrainId().getId());
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", teacherInfoList);
		} catch (Exception e) {
			jsonMap.put("code", ErrorConstants.DATA_ERR);
			jsonMap.put("message", "数据处理异常");
			jsonMap.put("data", null);
		} finally {
			WriterUtil.writeStr(JSONObject.fromObject(jsonMap).toString());
		}

	}
}