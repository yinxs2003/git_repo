package pb.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// SpringMVC中控制器类
@Controller		// Spring自动扫描并实例化
public class SimpleControl {

	// 添加@RequestMapping注解的方法，代表用户请求处理方法。
	@RequestMapping("/hello.do")
	public ModelAndView hello(String name){
		// 视图名:simple
		// 模型中存入[名称/值]对: name:"msg" value:"你好!name"
		// 等效于request.setAttribute("msg", "你好！" + name);
		return new ModelAndView("simple", "msg", "你好！" + name);
	}
}
