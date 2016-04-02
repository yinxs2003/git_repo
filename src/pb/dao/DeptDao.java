package pb.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pb.entity.Dept;

@Repository	// �������ݳ־û�Bean(���ú�@Component)
public class DeptDao {

	@Autowired
	private SqlSessionTemplate template;

	// ��ѯȫ��
	@Transactional
	public List<Dept> listAll(){
		return template.selectList("pb.mapper.DeptDaoMapper.selectAll");
	}
	
	// ����Id��ѯ
	@Transactional
	public Dept findById(int id){
		return template.selectOne("pb.mapper.DeptDaoMapper.selectById", id);
	}
	
	// ���沿��
	@Transactional
	public int saveDept(Dept dept){
		return template.insert("pb.mapper.DeptDaoMapper.addDept", dept);
	}
}
