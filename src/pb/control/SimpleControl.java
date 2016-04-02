package pb.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// SpringMVC�п�������
@Controller		// Spring�Զ�ɨ�貢ʵ����
public class SimpleControl {

	// ���@RequestMappingע��ķ����������û�����������
	@RequestMapping("/hello.do")
	public ModelAndView hello(String name){
		// ��ͼ��:simple
		// ģ���д���[����/ֵ]��: name:"msg" value:"���!name"
		// ��Ч��request.setAttribute("msg", "��ã�" + name);
		return new ModelAndView("simple", "msg", "��ã�" + name);
	}
}
