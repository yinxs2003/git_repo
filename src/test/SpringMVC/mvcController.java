package test.SpringMVC;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.entity.Person;

@Controller

// 提供一种关系映射，就是在项目名后面添加一个“/mvc/...”
@RequestMapping("/mvc")
public class mvcController {

	// 提供关系映射,结合上述条件，访问hello.jsp的路径是：http://localhost:8080/SpringMVCDemo/mvc/hello
	@RequestMapping("/hello")
	public String hello() {
		// 返回值为hello，根据配置，前缀指明在/WEB-INF/jsp/目录下，后缀指明为".jsp"文件，即访问的是webContent目录下的/WEB-INF/jsp/hello.jsp页面
		return "hello";
	}

	@RequestMapping("/index")
	public String toIndex() {
		return "index";
	}

	@RequestMapping("/person")
	public String toPerson(Person p) {
		System.out.println(p.getName() + " " + p.getAge());
		return "hello";
	}

	@RequestMapping("/todate")
	public String toDate() {
		return "date";
	}

	// the parameter was converted in initBinder
	@RequestMapping("/date")
	public String date(Date date) {
		System.out.println(date);
		return "hello";
	}

	// At the time of initialization,convert the type "String" to type "date"
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	// pass the parameters to front-end
	@RequestMapping("/showPerson")
	public String showPerson(Map<String, Object> map) {
		Person p = new Person();
		map.put("p", p);
		p.setAge(20);
		p.setName("jayjay");
		return "showPerson";
	}

	// pass the parameters to front-end using ajax
	@RequestMapping("/getPerson")
	public void getPerson(String name, PrintWriter pw) {
		pw.write("hello," + name);
	}

	@RequestMapping("/name")
	public String sayHello() {
		return "name";
	}

	@RequestMapping("ajaxPerson")
	public String ajaxPerson() {
		return "ajaxPerson";
	}

	@RequestMapping("toUpload")
	public String toUpload() {
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest req) throws Exception {
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		MultipartFile file = mreq.getFile("file");
		String fileName = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/") + "upload/"
				+ sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf('.')));
		fos.write(file.getBytes());
		fos.flush();
		fos.close();

		return "hello";
	}

	@RequestMapping("toParam")
	public String toParam() {
		return "param";
	}

	@RequestMapping(value = "/param")
	public String testRequestParam(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name) {
		System.out.println(id + " " + name);
		return "/hello";
	}
}
