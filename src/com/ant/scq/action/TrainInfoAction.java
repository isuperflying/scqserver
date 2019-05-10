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
import java.util.regex.Pattern;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.Area;
import com.ant.scq.entity.City;
import com.ant.scq.entity.Province;
import com.ant.scq.entity.TrainInfo;
import com.ant.scq.service.ITrainInfoService;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.ExcelWorkSheet;
import com.ant.scq.util.JsonResult;
import com.ant.scq.util.UploadFileUtils;
import com.ant.scq.util.WriterUtil;

@SuppressWarnings("serial")
public class TrainInfoAction extends BaseActionSupport {

	@Resource
	private ITrainInfoService trainInfoService;
	private TrainInfo trainInfo;
	List<TrainInfo> trainInfoList;

	private File excelFile; // 上传的文件
	private String excelFileFileName; // 保存原始文件名

	// 将Excel文件解析完毕后信息存放到这个对象中
	private ExcelWorkSheet<TrainInfo> excelWorkSheet;

	private List<Province> provinceList;

	private List<City> cityList;

	private List<Area> areaList;

	private String provinceId;

	private String cityId;

	public ITrainInfoService getTrainInfoService() {
		return this.trainInfoService;
	}

	public void setTrainInfoService(ITrainInfoService trainInfoService) {
		this.trainInfoService = trainInfoService;
	}

	public List<TrainInfo> getTrainInfoList() {
		return this.trainInfoList;
	}

	public void setTrainInfoList(List<TrainInfo> trainInfoList) {
		this.trainInfoList = trainInfoList;
	}

	public TrainInfo getTrainInfo() {
		return this.trainInfo;
	}

	public void setTrainInfo(TrainInfo trainInfo) {
		this.trainInfo = trainInfo;
	}

	public List<Province> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String toAdd() {
		provinceList = this.trainInfoService.getAllProvince();
		return "success";
	}

	public String toInput() {
		return "success";
	}

	public void getAllCityByProvinceId() {
		JsonResult json = null;
		List<City> cityList = trainInfoService.getCityByProvinceId(provinceId);
		if (cityList != null) {
			json = new JsonResult(true, "success", cityList);
		} else {
			json = new JsonResult(false, "fail", null);
		}
		WriterUtil.writeStr(JSONObject.fromObject(json).toString());
	}

	public void getAllAreaByCityId() {
		JsonResult json = null;
		List<Area> areaList = trainInfoService.getAreaByCityId(cityId);
		if (areaList != null) {
			json = new JsonResult(true, "success", areaList);
		} else {
			json = new JsonResult(false, "fail", null);
		}
		WriterUtil.writeStr(JSONObject.fromObject(json).toString());
	}

	public String getTrainInfoDataList() {
		String result = "success";
		try {
			this.totalCount = this.trainInfoService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.trainInfoList = this.trainInfoService.getDataList(
					(this.page - 1) * this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String saveTrainInfo() {
		String result = "success";
		try {
			boolean res = trainInfoService.saveTrainInfo(trainInfo);
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
			trainInfo = this.trainInfoService.getTrainInfoById(trainInfo.getId());
			provinceList = this.trainInfoService.getAllProvince();
			if (trainInfo != null) {
				if(trainInfo.getRegisterProvince() != null){
					cityList = trainInfoService.getCityByProvinceId(trainInfo
							.getRegisterProvince());
				}
				if(trainInfo.getRegisterCity() != null){
					areaList = trainInfoService.getAreaByCityId(trainInfo
							.getRegisterCity());
				}
			}
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String updateTrainInfo() {
		String result = "success";
		boolean flag = this.trainInfoService.updateTrainInfo(this.trainInfo);
		if (!flag) {
			result = "fail";
		}
		return result;
	}

	public void deleteTrainInfo() {
		boolean result = this.trainInfoService.deleteTrainInfo(this.trainInfo);
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

	public void inputTrainInfoExcel() {

		try {

			Workbook book = createWorkBook(new FileInputStream(excelFile));
			// book.getNumberOfSheets(); 判断Excel文件有多少个sheet
			Sheet sheet = book.getSheetAt(0);
			excelWorkSheet = new ExcelWorkSheet<TrainInfo>();
			// 保存工作单名称
			Row firstRow = sheet.getRow(0);
			Iterator<Cell> iterator = firstRow.iterator();

			// 保存列名
			List<String> cellNames = new ArrayList<String>();
			while (iterator.hasNext()) {
				cellNames.add(iterator.next().getStringCellValue());
			}
			excelWorkSheet.setColumns(cellNames);
			for (int i = 8; i <= sheet.getLastRowNum(); i++) {
				Row ros = sheet.getRow(i);
				TrainInfo trainInfo = new TrainInfo();

				if (ros.getCell(0) != null) {
					ros.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setTrainName(ros.getCell(0).getStringCellValue());
				}

				if (ros.getCell(1) != null) {
					ros.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setTrainSchoolArea(ros.getCell(1)
							.getStringCellValue());
				}
				if (ros.getCell(3) != null) {
					ros.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setRegisterProvince(ros.getCell(3)
							.getStringCellValue());
				}
				if (ros.getCell(4) != null) {
					ros.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setRegisterCity(ros.getCell(4)
							.getStringCellValue());
				}
				if (ros.getCell(5) != null) {
					ros.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setRegisterArea(ros.getCell(5)
							.getStringCellValue());
				}
				if (ros.getCell(6) != null) {
					ros.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setRegisterAddress(ros.getCell(6)
							.getStringCellValue());
				}
				if (ros.getCell(7) != null) {
					ros.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setContactsName(ros.getCell(7)
							.getStringCellValue());
				}
				if (ros.getCell(8) != null) {
					ros.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setContactsPhone(ros.getCell(8)
							.getStringCellValue());
				}
				if (ros.getCell(9) != null) {
					ros.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setEnrollmentPhoneNumber(ros.getCell(9)
							.getStringCellValue());
				}
				if (ros.getCell(10) != null) {
					ros.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setLicense(ros.getCell(10)
							.getStringCellValue());
				}
				if (ros.getCell(11) != null) {
					ros.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setLongitude(ros.getCell(11)
							.getStringCellValue());
				}
				if (ros.getCell(12) != null) {
					ros.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setLatitude(ros.getCell(12)
							.getStringCellValue());
				}
				if (ros.getCell(13) != null) {
					ros.getCell(13).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setTrainSpecial(ros.getCell(13)
							.getStringCellValue());
				}
				if (ros.getCell(14) != null) {
					ros.getCell(14).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setTrainScale(ros.getCell(14)
							.getStringCellValue());
				}
				if (ros.getCell(15) != null) {
					ros.getCell(15).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setIntroduction(ros.getCell(15)
							.getStringCellValue());
				}
				if (ros.getCell(16) != null) {
					ros.getCell(16).setCellType(Cell.CELL_TYPE_STRING);
					trainInfo.setRemark(ros.getCell(16).getStringCellValue());
				}
				excelWorkSheet.getData().add(trainInfo);
			}

			List<TrainInfo> trainInfoList = excelWorkSheet.getData();
			boolean result = true;
			try {
				trainInfoService.saveTrainInfoList(trainInfoList);
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

	public void inputExamFile(){
		try {
			System.out.println("1111");
			UploadFileUtils.upload4Stream("test1.doc", "E:\\word_upload", excelFile);
			System.out.println("2222");
			WriterUtil.writeStr("success");
		} catch (Exception e) {
			e.printStackTrace();
			WriterUtil.writeStr("error");
		}
	}
	
	// -----------------APP接口---------------
	public void findTrainService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			//查询机构
			this.trainInfoList = this.trainInfoService.getDataListByParams(
					(this.page - 1) * this.rows, this.rows, trainInfo);
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", trainInfoList);
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

	public ExcelWorkSheet<TrainInfo> getExcelWorkSheet() {
		return excelWorkSheet;
	}

	public void setExcelWorkSheet(ExcelWorkSheet<TrainInfo> excelWorkSheet) {
		this.excelWorkSheet = excelWorkSheet;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

}