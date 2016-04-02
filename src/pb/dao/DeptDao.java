package pb.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pb.entity.Dept;

@Repository	// 负责数据持久化Bean(作用和@Component)
public class DeptDao {

	@Autowired
	private SqlSessionTemplate template;

	// 查询全部
	@Transactional
	public List<Dept> listAll(){
		return template.selectList("pb.mapper.DeptDaoMapper.selectAll");
	}
	
	// 根据Id查询
	@Transactional
	public Dept findById(int id){
		return template.selectOne("pb.mapper.DeptDaoMapper.selectById", id);
	}
	
	// 保存部门
	@Transactional
	public int saveDept(Dept dept){
		return template.insert("pb.mapper.DeptDaoMapper.addDept", dept);
	}
}
