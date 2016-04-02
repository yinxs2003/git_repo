package pb.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ����ʵ��
 * @author chen
 *
 */
public class Dept {

	// ʵ���������ͱ���������һ�£�mybatis�Զ�ת����
	@NotNull(message="�����벿�ű��")
	private Integer deptno;
	@NotNull(message="�����벿������")
	@Size(min=2,max=10,message="�������Ʊ�����{min}��{max}�ַ�֮��")
	private String dname;
	private String loc;
	
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
