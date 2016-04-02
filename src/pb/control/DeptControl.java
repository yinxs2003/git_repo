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
		// ҵ�񷽷�ִ�в�ѯ
		List<Dept> deptlist = service.listDept();

		// ����������ִ�к󷵻���ͼ��ģ�ͣ���װ���������������ݣ�
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dept/deptlist"); // ������ͼ�߼���
		Map<String, Object> model = mv.getModel(); // ��ȡModel
		model.put("deptlist", deptlist); // ��������(request��)

		return mv;
	}

	// @RequestMapping("/savedept.do")
	// @ModelAttribute ����1��request�д���ָ������Ϊ��Dept����Deptʵ����
	// @ModelAttribute ����2���ѱ��ύ�ֶ�ֵ�����������ʵ���������ֵ�������Զ�ת����
	// Ĭ������£�ʵ����ǰ׺@ModelAttribute���Զ����
	@RequestMapping("/save.do")
	// ����Ҫ��֤ʵ�������ǰ��@Valid
	// BindingResult ���������Ҫ��֤ʵ�����������
	public ModelAndView saveDept(@Valid Dept deptment, BindingResult result) {

		// ����BindingResult�ж���֤�Ƿ�ͨ��

		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("dept/adddept");
			return mv;
		}
		try {
			service.saveNewDept(deptment);
			mv.setViewName("redirect:dlist.do"); // ֱ�ӽ����ض�����ת [redirect:url]
		} catch (RuntimeException e) {
			mv.setViewName("deptlist");
			// ��Model��������ӡ�name/value��
			mv.addObject("msg", "������Ϣ���ʧ�ܣ�" + e.getMessage());
		}
		return mv;
	}
}