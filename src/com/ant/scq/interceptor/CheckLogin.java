package com.ant.scq.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ant.scq.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckLogin
  implements Interceptor, ServletRequestAware
{
  private HttpServletRequest request;

  public void destroy()
  {
  }

  public void init()
  {
  }

  public String intercept(ActionInvocation arg0)
    throws Exception
  {
    System.out.println("------CheckLogin.intercept------");

    String namespace = arg0.getProxy().getNamespace();
    String actionName = arg0.getProxy().getActionName();

    Map session = ActionContext.getContext().getSession();
    User user = (User)session.get("user");

    System.out.println("namespace---" + namespace + "--actionName--" + 
      actionName);

    if (("/".equals(namespace)) && ("userLogin".equals(actionName))) {
      return arg0.invoke();
    }
    if (user == null) {
      return "checkLoginFail";
    }
    return arg0.invoke();
  }

  public void setServletRequest(HttpServletRequest arg0)
  {
    this.request = arg0;
  }
}