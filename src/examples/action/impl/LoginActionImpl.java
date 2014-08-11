package examples.action.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.S2ContainerFactory;

import examples.action.LoginAction;
import examples.dao.BookDao;
import examples.form.LoginForm;
import examples.service.LoginService;


public class LoginActionImpl extends Action implements LoginAction {
	
	@Resource
	LoginService loginService;
	
	Logger logger = Logger.getLogger(getClass());
	public void prepare(){
		logger.info("init");
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
	
		LoginForm login = (LoginForm) form;
		logger.info(login);
		
		req.setAttribute("user", login);
		if (loginService.valid(login)) {
			return mapping.findForward(SUCCESS) ;
		} else {
			return mapping.findForward(FAILURE) ;
		}
	}
}
