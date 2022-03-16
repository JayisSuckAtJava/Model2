package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionAuthInterCeptor extends HandlerInterceptorAdapter{
	
	// preHandle() : ��Ʈ�ѷ����� ���� ����Ǵ� �޼���
    @Override
    public boolean preHandle(HttpServletRequest request, 
    		HttpServletResponse response, Object handler)
            throws Exception {
        
    	// session ��ü�� ������
        HttpSession session = request.getSession();
        
        // loginó���� ����ϴ� ����� ������ ��� �ִ� ��ü�� ������
        String sid = (String)session.getAttribute("sid");
               
        if(sid == null){
        	
            // �α����� �ȵǾ� �ִ� ���������� �α��� ������ �ٽ� ��������(redirect)
            response.sendRedirect("/model2/login?connect=illegal");
            
            return false; 
        }
         
        return true;
    }
 
    // ��Ʈ�ѷ��� ����ǰ� ȭ���� �������� ������ ����Ǵ� �޼���
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    } 

}
