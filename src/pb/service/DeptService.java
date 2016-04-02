package pb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pb.dao.DeptDao;
import pb.entity.Dept;

@Service
public class DeptService {

	@Autowired
	private DeptDao dao;
	
	// 部门列表
	public List<Dept> listDept(){
		return dao.listAll();
	}
	
	// 通过id查询
	public Dept findDeptById(Integer id){
		return dao.findById(id);
	}
	
	// 添加部门
	public int saveNewDept(Dept dept){
		if(dao.findById(dept.getDeptno()) != null){
			throw new RuntimeException("部门id重复");
		}
		return dao.saveDept(dept);
	}
}
