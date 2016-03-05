package test.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mvc")
public class NewHelloControl {

	public NewHelloControl() {
		System.out.println(this.getClass() + "Constructor");
	}

	@RequestMapping("/hello.do")//注意访问的是hello.do
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", "小强");
		mv.setViewName("hello");
		return mv;
	}
	
	
}
