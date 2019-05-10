package com.ant.scq.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.ant.scq.entity.CourseInfo;
import com.ant.scq.entity.MenuType;
import com.ant.scq.entity.TeacherInfo;
import com.ant.scq.entity.TrainInfo;
import com.ant.scq.service.ICourseInfoService;
import com.ant.scq.service.IMenuTypeService;
import com.ant.scq.service.ITeacherInfoService;
import com.ant.scq.util.DateUtil;
import com.ant.scq.util.ErrorConstants;
import com.ant.scq.util.ExcelWorkSheet;
import com.ant.scq.util.JsonResult;
import com.ant.scq.util.WriterUtil;

@SuppressWarnings("serial")
public class CourseInfoAction extends BaseActionSupport {

	@Resource
	private ICourseInfoService courseInfoService;
	@Resource
	private IMenuTypeService menuTypeService;
	@Resource
	private ITeacherInfoService teacherInfoService;
	private CourseInfo courseInfo;
	List<CourseInfo> courseInfoList;

	private List<MenuType> firstMenuList;

	private List<MenuType> secondMenuList;

	private List<MenuType> threeMenuList;

	private String parentNumber;

	private String trainInfoId;

	private File excelFile; // 上传的文件
	private String excelFileFileName; // 保存原始文件名

	// 将Excel文件解析完毕后信息存放到这个对象中
	private ExcelWorkSheet<CourseInfo> excelWorkSheet;

	public ICourseInfoService getCourseInfoService() {
		return this.courseInfoService;
	}

	public void setCourseInfoService(ICourseInfoService courseInfoService) {
		this.courseInfoService = courseInfoService;
	}

	public IMenuTypeService getMenuTypeService() {
		return menuTypeService;
	}

	public void setMenuTypeService(IMenuTypeService menuTypeService) {
		this.menuTypeService = menuTypeService;
	}

	public ITeacherInfoService getTeacherInfoService() {
		return teacherInfoService;
	}

	public void setTeacherInfoService(ITeacherInfoService teacherInfoService) {
		this.teacherInfoService = teacherInfoService;
	}

	public List<CourseInfo> getCourseInfoList() {
		return this.courseInfoList;
	}

	public void setCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}

	public CourseInfo getCourseInfo() {
		return this.courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public List<MenuType> getFirstMenuList() {
		return firstMenuList;
	}

	public void setFirstMenuList(List<MenuType> firstMenuList) {
		this.firstMenuList = firstMenuList;
	}

	public List<MenuType> getSecondMenuList() {
		return secondMenuList;
	}

	public void setSecondMenuList(List<MenuType> secondMenuList) {
		this.secondMenuList = secondMenuList;
	}

	public List<MenuType> getThreeMenuList() {
		return threeMenuList;
	}

	public void setThreeMenuList(List<MenuType> threeMenuList) {
		this.threeMenuList = threeMenuList;
	}

	public String getParentNumber() {
		return parentNumber;
	}

	public void setParentNumber(String parentNumber) {
		this.parentNumber = parentNumber;
	}

	public String getTrainInfoId() {
		return trainInfoId;
	}

	public void setTrainInfoId(String trainInfoId) {
		this.trainInfoId = trainInfoId;
	}

	public String toAdd() {
		firstMenuList = this.courseInfoService.getAllFirstMenu();
		return "success";
	}

	public String toInput() {
		return "success";
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

	public ExcelWorkSheet<CourseInfo> getExcelWorkSheet() {
		return excelWorkSheet;
	}

	public void setExcelWorkSheet(ExcelWorkSheet<CourseInfo> excelWorkSheet) {
		this.excelWorkSheet = excelWorkSheet;
	}

	public void getAllMenuTypeByParentNumber() {
		JsonResult json = null;
		List<MenuType> menuTypeList = courseInfoService
				.getMenuTypeByParentNumber(parentNumber);
		if (menuTypeList != null) {
			json = new JsonResult(true, "success", menuTypeList);
		} else {
			json = new JsonResult(false, "fail", null);
		}
		WriterUtil.writeStr(JSONObject.fromObject(json).toString());
	}

	public String getCourseInfoDataList() {
		String result = "success";
		try {
			this.totalCount = this.courseInfoService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.courseInfoList = this.courseInfoService.getDataList(
					(this.page - 1) * this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String saveCourseInfo() {
		String result = "success";
		try {

			if (courseInfo.getTypeId() != null
					&& courseInfo.getTypeId().getMenuNumber() != null) {
				MenuType menuType = this.menuTypeService
						.getMenuTypeByIdMenuNumber(courseInfo.getTypeId()
								.getMenuNumber());
				courseInfo.setTypeId(menuType);
			}
			boolean res = courseInfoService.saveCourseInfo(courseInfo);
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
			courseInfo = this.courseInfoService.getCourseInfoById(courseInfo
					.getId());

			if (courseInfo.getTypeId().getMenuLevel() == 1) {
				firstMenuList = this.courseInfoService.getAllFirstMenu();
			} else if (courseInfo.getTypeId().getMenuLevel() == 2) {
				// 查询所有一级菜单
				firstMenuList = this.courseInfoService.getAllFirstMenu();
				// 根据父级菜单编号查询所有的二级菜单
				secondMenuList = courseInfoService
						.getMenuTypeByParentNumber(courseInfo.getTypeId()
								.getParentNumber());
				// 设置选中的一级菜单
				courseInfo.setFirstMenuNumber(courseInfo.getTypeId()
						.getParentNumber());
			} else if (courseInfo.getTypeId().getMenuLevel() == 3) {
				// 查询所有一级菜单
				firstMenuList = this.courseInfoService.getAllFirstMenu();
				// 根据父级菜单编号查询所有的三级菜单
				threeMenuList = courseInfoService
						.getMenuTypeByParentNumber(courseInfo.getTypeId()
								.getParentNumber());
				courseInfo.setSecondMenuNumber(courseInfo.getTypeId()
						.getParentNumber());
				courseInfo.setThreeMenuNumber(courseInfo.getTypeId()
						.getMenuNumber());
				if (threeMenuList != null && threeMenuList.size() > 0) {
					MenuType temp = threeMenuList.get(0);
					// 根据父级菜单编号查询所有的二级菜单

					secondMenuList = courseInfoService
							.getSecondMenuTypeByNumber(temp.getParentNumber());
					if (secondMenuList != null && secondMenuList.size() > 0) {
						// 设置选中的一级菜单
						courseInfo.setFirstMenuNumber(secondMenuList.get(0)
								.getParentNumber());
					}
				}
			}

		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String updateCourseInfo() {
		String result = "success";
		boolean flag = this.courseInfoService.updateCourseInfo(this.courseInfo);
		if (!flag) {
			result = "fail";
		}
		return result;
	}

	public void deleteCourseInfo() {
		boolean result = this.courseInfoService
				.deleteCourseInfo(this.courseInfo);
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

	public void inputCourseInfoExcel() {
		try {
			Workbook book = createWorkBook(new FileInputStream(excelFile));
			// book.getNumberOfSheets(); 判断Excel文件有多少个sheet
			Sheet sheet = book.getSheetAt(0);
			excelWorkSheet = new ExcelWorkSheet<CourseInfo>();
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
			if (trainInfoId != null) {
				trainInfo.setId(Integer.parseInt(trainInfoId));
			}

			for (int i = 8; i <= sheet.getLastRowNum(); i++) {
				Row ros = sheet.getRow(i);
				CourseInfo courseInfo = new CourseInfo();

				if (ros.getCell(0) != null) {
					ros.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseName(ros.getCell(0)
							.getStringCellValue());
				}

				if (ros.getCell(1) != null) {
					ros.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseSimpleName(ros.getCell(1)
							.getStringCellValue());
				}
				if (ros.getCell(2) != null) {
					ros.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
					MenuType menuType = this.menuTypeService
							.getMenuTypeByIdMenuNumber(ros.getCell(2)
									.getStringCellValue());
					courseInfo.setTypeId(menuType);
				}
				if (ros.getCell(3) != null) {
					ros.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseGrade(ros.getCell(3)
							.getStringCellValue());
				}
				if (ros.getCell(4) != null) {
					ros.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseClass(ros.getCell(4)
							.getStringCellValue());
				}
				if (ros.getCell(5) != null) {
					ros.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseClassNumber(ros.getCell(5)
							.getStringCellValue());
				}
				if (ros.getCell(6) != null
						&& ros.getCell(6).getDateCellValue() != null) {
					courseInfo.setCourseStartDate(DateUtil.date2String(ros.getCell(6)
							.getDateCellValue(),"yyyy-MM-dd"));
				}
				if (ros.getCell(7) != null
						&& ros.getCell(7).getDateCellValue() != null) {
					courseInfo.setCourseEndDate(DateUtil.date2String(ros.getCell(7)
							.getDateCellValue(),"yyyy-MM-dd"));
				}

				if (ros.getCell(8) != null) {
					ros.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseTime(ros.getCell(8)
							.getStringCellValue());
				}

				if (ros.getCell(9) != null) {
					ros.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseTimeRemark(ros.getCell(9)
							.getStringCellValue());
				}

				if (ros.getCell(10) != null) {
					ros.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseIntroduction(ros.getCell(10)
							.getStringCellValue());
				}

				if (ros.getCell(11) != null) {
					ros.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseYear(ros.getCell(11)
							.getStringCellValue());
				}

				if (ros.getCell(12) != null) {
					ros.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
					TeacherInfo teacherInfo = this.teacherInfoService
							.getTeacherInfoById(Integer.parseInt(ros
									.getCell(12).getStringCellValue()));
					courseInfo.setCourseTeacher(teacherInfo);
				}

				if (ros.getCell(13) != null) {
					ros.getCell(13).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setTeacherName(ros.getCell(13)
							.getStringCellValue());
				}

				if (ros.getCell(14) != null) {
					ros.getCell(14).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCoursePriceType(Integer.parseInt(ros.getCell(
							14).getStringCellValue()));
				}

				if (ros.getCell(15) != null) {
					ros.getCell(15).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseHour(Integer.parseInt(ros.getCell(15)
							.getStringCellValue()));
				}

				if (ros.getCell(16) != null) {
					ros.getCell(16).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseTotalPrice(new BigDecimal(ros.getCell(
							16).getStringCellValue()));
				}

				if (ros.getCell(17) != null) {
					ros.getCell(17).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setCourseBook(ros.getCell(17)
							.getStringCellValue());
				}
				if (ros.getCell(18) != null) {
					ros.getCell(18).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setIsCurated(Integer.parseInt(ros.getCell(18)
							.getStringCellValue()));
				}
				if (ros.getCell(19) != null) {
					ros.getCell(19).setCellType(Cell.CELL_TYPE_STRING);
					courseInfo.setRemark(ros.getCell(19).getStringCellValue());
				}
				courseInfo.setTrainId(trainInfo);
				excelWorkSheet.getData().add(courseInfo);
			}

			List<CourseInfo> courseInfoList = excelWorkSheet.getData();
			boolean result = true;
			try {
				courseInfoService.saveCourseInfoList(courseInfoList);
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

	// 将 Date 转换成 String 类型
	public String getDateToString(Date dt) {
		if (dt == null)
			return "";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String str = format.format(dt);
		return str;
	}

	// -----------------APP接口---------------
	public void mainCourseService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			//查询精选课程
			this.courseInfoList = this.courseInfoService.getDataListByIsCurated(
					(this.page - 1) * this.rows, this.rows,2);
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", courseInfoList);
		} catch (Exception e) {
			jsonMap.put("code", ErrorConstants.DATA_ERR);
			jsonMap.put("message", "数据处理异常");
			jsonMap.put("data", null);
		} finally {
			WriterUtil.writeStr(JSONObject.fromObject(jsonMap).toString());
		}

	}
	
	
	/**
	 * 查询机构下的课程
	 */
	public void findCourseByTrainIdService() {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			//查询精选课程
			this.courseInfoList = this.courseInfoService.getDataListByTrainId(
					(this.page - 1) * this.rows, this.rows, courseInfo.getTrainId().getId());
			jsonMap.put("code", ErrorConstants.SUCCESS);
			jsonMap.put("message", "成功");
			jsonMap.put("data", courseInfoList);
		} catch (Exception e) {
			jsonMap.put("code", ErrorConstants.DATA_ERR);
			jsonMap.put("message", "数据处理异常");
			jsonMap.put("data", null);
		} finally {
			WriterUtil.writeStr(JSONObject.fromObject(jsonMap).toString());
		}

	}
}