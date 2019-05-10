package com.ant.scq.action;

import java.util.List;

import javax.annotation.Resource;

import com.ant.scq.base.BaseActionSupport;
import com.ant.scq.entity.MenuType;
import com.ant.scq.service.IMenuTypeService;
import com.ant.scq.util.JsonResult;
import com.ant.scq.util.WriterUtil;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class MenuTypeAction extends BaseActionSupport {

	@Resource
	private IMenuTypeService menuTypeService;
	private MenuType menuType;
	List<MenuType> menuTypeList;

	public IMenuTypeService getMenuTypeService() {
		return this.menuTypeService;
	}

	public void setMenuTypeService(IMenuTypeService menuTypeService) {
		this.menuTypeService = menuTypeService;
	}

	public List<MenuType> getMenuTypeList() {
		return this.menuTypeList;
	}

	public void setMenuTypeList(List<MenuType> menuTypeList) {
		this.menuTypeList = menuTypeList;
	}

	public MenuType getMenuType() {
		return this.menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	public String toAdd() {
		return "success";
	}

	public String toInput() {
		return "success";
	}

	public void getAllMenuTypeByLevel() {
		JsonResult json = null;
		List<MenuType> menuTypeList = menuTypeService.getAllMenuTypeByLevel("2");
		if (menuTypeList != null) {
			json = new JsonResult(true, "success", menuTypeList);
		} else {
			json = new JsonResult(false, "fail", null);
		}
		WriterUtil.writeStr(JSONObject.fromObject(json).toString());
	}
	
	public String getMenuTypeDataList() {
		String result = "success";
		try {
			this.totalCount = this.menuTypeService.getDataListCount();
			if (this.totalCount > 0) {
				if (this.totalCount % 10 == 0)
					this.totalPages = (this.totalCount / 10);
				else {
					this.totalPages = (this.totalCount / 10 + 1);
				}
			}
			this.menuTypeList = this.menuTypeService.getDataList(
					(this.page - 1) * this.rows, this.rows);
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String saveMenuType() {
		String result = "success";
		try {
			boolean res = menuTypeService.saveMenuType(menuType);
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
			menuType = this.menuTypeService.getMenuTypeById(menuType.getId());
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	public String updateMenuType() {
		String result = "success";
		boolean flag = this.menuTypeService.updateMenuType(this.menuType);
		if (!flag) {
			result = "fail";
		}
		return result;
	}

	public void deleteMenuType() {
		boolean result = this.menuTypeService.deleteMenuType(this.menuType);
		if (result)
			WriterUtil.writeStr("success");
		else
			WriterUtil.writeStr("error");
	}

}