/**************************************************************************************** 
 Copyright © 2014-2014 LUWEI Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.ant.scq.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import com.ant.scq.entity.User;


/** 
 * <Description> 拦截登陆请求<br> 
 *  
 * @author lu.wei<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014-11-29 <br>
 * @since V1.0<br>
 * @see com.wsit.nj.ttcar.base <br>
 */
public class LoginFilter extends OncePerRequestFilter {

    /**
     * Description: <br> 
     *  
     * @author lu.wei<br>
     * @taskId <br>
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException <br>
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("LOGIN_USER");
        String uri = request.getRequestURI();
        
        if(uri.endsWith("/")) {
            //没有登录
            if (null != user) {
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
            //已经登陆
            else {
                chain.doFilter(request, response);
            }
        }
        else if (uri.indexOf("login") < 0 && uri.indexOf("userLogin.action") < 0) {
            //没有登录
            if (null == user) {
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
            //已经登陆
            else {
                chain.doFilter(request, response);
            }
        }
        else {
            chain.doFilter(request, response);
        }
    }

}
