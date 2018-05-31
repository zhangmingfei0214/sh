package action;


import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDAO;
import service.impl.UsersDAOImpl;

/**
 *struts2的模型驱动方式
 */
public class UsersAction extends SuperAction implements ModelDriven<Users>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	
	//用户登录动作
	public String login() {
		UsersDAO udao = new UsersDAOImpl();
		if(udao.usersLogin(user)) {
			
			//在session中保存登录成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			
			return "login_success";
		} else {
			return "login_failure";
		}
	}
	
	
	@SkipValidation //保证用户在注销时执行validate()方法
	//用户注销方法
	public String logout() {
		if(session.getAttribute("loginUserName")!=null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	
	@Override
	public void validate() {
		
		//用户名不能为空
		if("".equals(user.getUsername().trim())) {
			
			this.addFieldError("usernameError","用户名不能为空");
		}
		if(user.getPassword().length()<6) {
			this.addFieldError("passwordError", "密码长度不少于6位");
		}
	}

	@Override
	public Users getModel() {
		
		return this.user;
	}

}
