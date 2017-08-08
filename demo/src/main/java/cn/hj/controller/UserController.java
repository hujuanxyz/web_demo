package cn.hj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hj.entity.User;
import cn.hj.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String userLogin(HttpServletRequest request, User user) {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean flag = false;
        if(!(username.isEmpty() && password.isEmpty())) {
        	flag = userService.userLogin(username, password);
        }		
        if(flag) {
        	request.setAttribute("user", user);
        	return "success";
        }else {
        	request.setAttribute("user", "用户名或者密码错误");
        	return "fail";
        }
	}
	
	 @RequestMapping("/list")
	    public String getAllUsers(Model model) {
	        List<User> users = userService.getAllUser();
	        model.addAttribute("users", users);
	        System.out.println(users);
	        return "list";
	    }
	@SuppressWarnings("finally")
	@RequestMapping("delete")
		public String delete(HttpServletRequest request,String InfoMessage){
		
				String id = request.getParameter("id");
				String str = null;
				if(!(id.isEmpty())) {
					str = userService.deleteUser(Integer.parseInt(id));
					System.err.println("------"+str);
				}
				request.setAttribute("InfoMessage", str);
				return "delete";
		}
	private String string;
	@RequestMapping("edit")
	public String edit(HttpServletRequest request) {
		string = request.getParameter("id");
		System.err.println("id=------"+string);
		return "edit";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request,Model model) {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usercountry = request.getParameter("usercountry");
        System.err.println(username+"----"+password+"----"+usercountry);
        System.err.println("id=------"+string);
		User user = new User();
		user.setId(Integer.parseInt(string));
		user.setUsername(username);
		user.setPassword(password);
		user.setUsercountry(usercountry);
		
		System.err.println(user.toString());
		int flag = 0;
		if(user != null) {
			flag = userService.updateByPrimaryKeySelective(user);
		}
		if(flag > 0) {
			List<User> users = userService.getAllUser();
		    model.addAttribute("users", users);
			return "list";
		}else {
			return "index";
		}
		
	}

}
