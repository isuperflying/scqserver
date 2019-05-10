package com.ant.scq.base;

import com.opensymphony.xwork2.ActionSupport;

public class BaseActionSupport extends ActionSupport
{
  private static final long serialVersionUID = 5565251672312767837L;
  protected int page = 1;

  protected int rows = 10;

  protected int totalCount = 0;

  protected int totalPages = 0;

  public int getPage()
  {
    return this.page;
  }

  public void setPage(int page)
  {
    this.page = page;
  }

  public int getRows()
  {
    return this.rows;
  }

  public void setRows(int rows)
  {
    this.rows = rows;
  }

  public int getTotalCount()
  {
    return this.totalCount;
  }

  public void setTotalCount(int totalCount)
  {
    this.totalCount = totalCount;
  }

  public int getTotalPages()
  {
    return this.totalPages;
  }

  public void setTotalPages(int totalPages)
  {
    this.totalPages = totalPages;
  }
}