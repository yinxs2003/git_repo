package test.SpringMVC;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.EntityUser;

@Controller
@RequestMapping("/mvc")
public class LoginController {
	// 接收form提交的数据
	@RequestMapping("/login.do")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println(this.getClass() + " " + username + " " + password);
		return "loginSuccess";
	}

	@RequestMapping("/login2.do")
	public String login2(String username, String password) {
		System.out.println(this.getClass() + " " + username + " " + password);
		return "loginSuccess";
	}

	@RequestMapping("/reg.do")
	// @ModelAttribute("user")可以省略，如果省略也可以将表单元素存入user对象，但entityUser一定要是Entity的首字母小写
	public String reg(
			// @ModelAttribute("entityUser")
			EntityUser entityUser) {
		System.out.println(this.getClass() + " " + entityUser);
		return "loginSuccess";
	}

	// At the time of initialization,convert the type "String" to type "date"
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
