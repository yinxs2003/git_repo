package pb.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pb.entity.Dept;
import pb.service.DeptService;

@Controller
// @RequestMapping("/dept")
public class DeptControl {
	@Autowired
	private DeptService service;

	@RequestMapping("/add.do")
	public String openadd() {
		return "WEB-INF/jsp/adddept";
	}

	// @RequestMapping("/xls.do")
	// public ModelAndView xlsfile(){
	// List<String> list = Arrays.asList("hello", "abc", "test");
	//
	// ModelAndView mv = new ModelAndView();
	// mv.setView(new ExcelView());
	// mv.addObject("wordList", list);
	//
	// return mv;
	//
	// }

	@RequestMapping("/login.do")
	public String login(@RequestParam("deptno") Integer deptno,
			@RequestParam("dname") String dname) {
		System.out.println(deptno + " " + dname);
		Dept dept = service.findDeptById(deptno);
		if (dept.getDname().equals(dname))
			return "index";
		else
			return "error";
	}

	@RequestMapping("/ajax.do")
	public List<Dept> ajaxList(HttpSession session, HttpServletRequest request) {
		List<Dept> deptlist = service.listDept();
		return deptlist;
	}

	@RequestMapping("/list.do")
	public ModelAndView listDept() {
		// 业务方法执行查询
		List<Dept> deptlist = service.listDept();

		// 包括控制器执行后返回视图和模型（封装服务器对象中数据）
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dept/deptlist"); // 返回视图逻辑名
		Map<String, Object> model = mv.getModel(); // 获取Model
		model.put("deptlist", deptlist); // 存入数据(request中)

		return mv;
	}

	// @RequestMapping("/savedept.do")
	// @ModelAttribute 作用1：request中存入指定名称为“Dept”的Dept实体类
	// @ModelAttribute 作用2：把表单提交字段值。按名称填充实体对象属性值（类型自动转换）
	// 默认情况下，实体类前缀@ModelAttribute会自动添加
	@RequestMapping("/save.do")
	// 在需要验证实体类参数前加@Valid
	// BindingResult 必须紧随需要验证实体类参数后面
	public ModelAndView saveDept(@Valid Dept deptment, BindingResult result) {

		// 借助BindingResult判断验证是否通过

		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("dept/adddept");
			return mv;
		}
		try {
			service.saveNewDept(deptment);
			mv.setViewName("redirect:dlist.do"); // 直接进行重定向跳转 [redirect:url]
		} catch (RuntimeException e) {
			mv.setViewName("deptlist");
			// 想Model集合中添加【name/value】
			mv.addObject("msg", "部门信息添加失败！" + e.getMessage());
		}
		return mv;
	}
}