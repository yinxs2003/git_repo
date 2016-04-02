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
	
	// �����б�
	public List<Dept> listDept(){
		return dao.listAll();
	}
	
	// ͨ��id��ѯ
	public Dept findDeptById(Integer id){
		return dao.findById(id);
	}
	
	// ��Ӳ���
	public int saveNewDept(Dept dept){
		if(dao.findById(dept.getDeptno()) != null){
			throw new RuntimeException("����id�ظ�");
		}
		return dao.saveDept(dept);
	}
}
